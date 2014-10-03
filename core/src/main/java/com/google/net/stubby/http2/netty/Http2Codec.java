package com.google.net.stubby.http2.netty;

import com.google.net.stubby.Metadata;
import com.google.net.stubby.NoOpRequest;
import com.google.net.stubby.Operation;
import com.google.net.stubby.Operation.Phase;
import com.google.net.stubby.Request;
import com.google.net.stubby.RequestRegistry;
import com.google.net.stubby.Response;
import com.google.net.stubby.Session;
import com.google.net.stubby.Status;
import com.google.net.stubby.transport.MessageFramer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.AsciiString;
import io.netty.handler.codec.http2.DefaultHttp2Connection;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameAdapter;
import io.netty.handler.codec.http2.Http2Headers;

import java.util.Map;

/**
 * Codec used by clients and servers to interpret HTTP2 frames in the context of an ongoing
 * request-response dialog
 */
public class Http2Codec extends Http2ConnectionHandler {
  public static final int PADDING = 0;
  private final RequestRegistry requestRegistry;
  private final Session session;
  private Http2Codec.Http2Writer http2Writer;

  /**
   * Constructor used by servers, takes a session which will receive operation events.
   */
  public Http2Codec(Session session, RequestRegistry requestRegistry) {
    this(new DefaultHttp2Connection(true), session, requestRegistry);
  }

  /**
   * Constructor used by clients to send operations to a remote server
   */
  public Http2Codec(RequestRegistry requestRegistry) {
    this(new DefaultHttp2Connection(false), null, requestRegistry);
  }

  /**
   * Constructor used by servers, takes a session which will receive operation events.
   */
  private Http2Codec(Http2Connection connection, Session session, RequestRegistry requestRegistry) {
    super(connection, new LazyFrameListener());
    this.session = session;
    this.requestRegistry = requestRegistry;
    initListener();
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    http2Writer = new Http2Writer(ctx);
  }

  public Http2Writer getWriter() {
    return http2Writer;
  }

  private void initListener() {
    ((LazyFrameListener)((DefaultHttp2ConnectionDecoder) this.decoder()).listener()).setCodec(this);
  }

  private void onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data,
      boolean endOfStream) throws Http2Exception {
    Request request = requestRegistry.lookup(streamId);
    if (request == null) {
      // Stream may have been terminated already or this is just plain spurious
      throw Http2Exception.format(Http2Error.STREAM_CLOSED, "Stream does not exist");
    }
    Operation operation = isClient() ? request.getResponse() : request;
    try {
      ByteBufDeframer deframer = getOrCreateDeframer(operation, ctx);
      deframer.deframe(data, operation);
      if (endOfStream) {
        finish(operation);
      }
    } catch (Throwable e) {
      // TODO(user): Need to disambiguate between stream corruption as well as client/server
      // generated errors. For stream corruption we always just send reset stream. For
      // clients we will also generally reset-stream on error, servers may send a more detailed
      // status.
      Status status = Status.fromThrowable(e);
      closeWithError(request, status);
    }
  }

  private void onHeadersRead(ChannelHandlerContext ctx,
      int streamId,
      Http2Headers headers,
      boolean endStream) throws Http2Exception {
    Request operation = requestRegistry.lookup(streamId);
    if (operation == null) {
      if (isClient()) {
        // For clients an operation must already exist in the registry
        throw Http2Exception.format(Http2Error.REFUSED_STREAM, "Stream does not exist");
      } else {
        operation = serverStart(ctx, streamId, headers);
        if (operation == null) {
          closeWithError(new NoOpRequest(createResponse(new Http2Writer(ctx), streamId).build()),
              Status.NOT_FOUND);
        }
      }
    }
    if (endStream) {
      finish(isClient() ? operation.getResponse() : operation);
    }
  }

  private void onRstStreamRead(int streamId) {
    Request request = requestRegistry.lookup(streamId);
    if (request != null) {
      closeWithError(request, Status.CANCELLED.withDescription("Stream reset"));
      requestRegistry.remove(streamId);
    }
  }

  private boolean isClient() {
    return !connection().isServer();
  }

  /**
   * Closes the request and its associated response with an internal error.
   */
  private void closeWithError(Request request, Status status) {
    try {
      request.close(status);
      request.getResponse().close(status);
    } finally {
      requestRegistry.remove(request.getId());
      disposeDeframer(request);
    }
  }

  /**
   * Create an HTTP2 response handler
   */
  private Response.ResponseBuilder createResponse(Http2Writer writer, int streamId) {
    return Http2Response.builder(streamId, writer, new MessageFramer(4096));
  }

  /**
   * Start the Request operation on the server
   */
  private Request serverStart(ChannelHandlerContext ctx, int streamId, Http2Headers headers) {
    if (!Http2Session.PROTORPC.equals(headers.get(Http2Session.CONTENT_TYPE))) {
      return null;
    }
    // Use Path to specify the operation
    String operationName =
        normalizeOperationName(headers.get(Http2Headers.PseudoHeaderName.PATH.value()).toString());
    if (operationName == null) {
      return null;
    }

    // The Netty AsciiString class is really just a wrapper around a byte[] and supports
    // arbitrary binary data, not just ASCII.
    byte[][] headerValues = new byte[headers.size() * 2][];
    int i = 0;
    for (Map.Entry<AsciiString, AsciiString> entry : headers) {
      headerValues[i++] = entry.getKey().array();
      headerValues[i++] = entry.getValue().array();
    }
    Metadata.Headers grpcHeaders = new Metadata.Headers(headerValues);

    // Create the operation and bind a HTTP2 response operation
    Request op = session.startRequest(operationName, grpcHeaders,
        createResponse(new Http2Writer(ctx), streamId));
    if (op == null) {
      return null;
    }
    requestRegistry.register(op);
    return op;
  }

  // TODO(user): This needs proper namespacing support, this is currently just a hack
  private static String normalizeOperationName(String path) {
    return path.substring(1);
  }

  /**
   * Called when a HTTP2 stream is closed.
   */
  private void finish(Operation operation) {
    disposeDeframer(operation);
    requestRegistry.remove(operation.getId());
    if (operation.getPhase() != Phase.CLOSED) {
      operation.close(Status.OK);
    }
  }

  public ByteBufDeframer getOrCreateDeframer(Operation operation, ChannelHandlerContext ctx) {
    ByteBufDeframer deframer = operation.get(ByteBufDeframer.class);
    if (deframer == null) {
      deframer = new ByteBufDeframer(ctx.alloc());
      operation.put(ByteBufDeframer.class, deframer);
    }
    return deframer;
  }

  public void disposeDeframer(Operation operation) {
    ByteBufDeframer deframer = operation.remove(ByteBufDeframer.class);
    if (deframer != null) {
      deframer.dispose();
    }
  }

  public class Http2Writer {
    private final ChannelHandlerContext ctx;

    public Http2Writer(ChannelHandlerContext ctx) {
      this.ctx = ctx;
    }

    public ChannelFuture writeData(int streamId, ByteBuf data, boolean endStream) {
      return encoder().writeData(ctx, streamId, data, PADDING, endStream, ctx.newPromise());
    }

    public ChannelFuture writeHeaders(int streamId, Http2Headers headers, boolean endStream) {
      return encoder().writeHeaders(ctx,
          streamId,
          headers,
          PADDING,
          endStream,
          ctx.newPromise());
    }

    public ChannelFuture writeHeaders(int streamId,
        Http2Headers headers,
        int streamDependency,
        short weight,
        boolean exclusive,
        boolean endStream) {
      return encoder().writeHeaders(ctx,
          streamId,
          headers,
          streamDependency,
          weight,
          exclusive,
          PADDING,
          endStream,
          ctx.newPromise());
    }

    public ChannelFuture writeRstStream(int streamId, long errorCode) {
      return encoder().writeRstStream(ctx, streamId, errorCode, ctx.newPromise());
    }
  }

  private static class LazyFrameListener extends Http2FrameAdapter {
    private Http2Codec codec;

    void setCodec(Http2Codec codec) {
      this.codec = codec;
    }

    @Override
    public void onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data, int padding,
        boolean endOfStream) throws Http2Exception {
      codec.onDataRead(ctx, streamId, data, endOfStream);
    }

    @Override
    public void onHeadersRead(ChannelHandlerContext ctx,
        int streamId,
        Http2Headers headers,
        int streamDependency,
        short weight,
        boolean exclusive,
        int padding,
        boolean endStream) throws Http2Exception {
      codec.onHeadersRead(ctx, streamId, headers, endStream);
    }

    @Override
    public void onRstStreamRead(ChannelHandlerContext ctx, int streamId, long errorCode)
        throws Http2Exception {
      codec.onRstStreamRead(streamId);
    }
  }
}
