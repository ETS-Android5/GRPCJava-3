// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: envoy/api/v2/cds.proto

package io.grpc.xds.shaded.envoy.api.v2;

/**
 * Protobuf type {@code envoy.api.v2.UpstreamConnectionOptions}
 */
public  final class UpstreamConnectionOptions extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:envoy.api.v2.UpstreamConnectionOptions)
    UpstreamConnectionOptionsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpstreamConnectionOptions.newBuilder() to construct.
  private UpstreamConnectionOptions(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpstreamConnectionOptions() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpstreamConnectionOptions(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.Builder subBuilder = null;
            if (tcpKeepalive_ != null) {
              subBuilder = tcpKeepalive_.toBuilder();
            }
            tcpKeepalive_ = input.readMessage(io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(tcpKeepalive_);
              tcpKeepalive_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.xds.shaded.envoy.api.v2.Cds.internal_static_envoy_api_v2_UpstreamConnectionOptions_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.xds.shaded.envoy.api.v2.Cds.internal_static_envoy_api_v2_UpstreamConnectionOptions_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.class, io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.Builder.class);
  }

  public static final int TCP_KEEPALIVE_FIELD_NUMBER = 1;
  private io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive tcpKeepalive_;
  /**
   * <pre>
   * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
   * </pre>
   *
   * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
   */
  public boolean hasTcpKeepalive() {
    return tcpKeepalive_ != null;
  }
  /**
   * <pre>
   * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
   * </pre>
   *
   * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
   */
  public io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive getTcpKeepalive() {
    return tcpKeepalive_ == null ? io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.getDefaultInstance() : tcpKeepalive_;
  }
  /**
   * <pre>
   * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
   * </pre>
   *
   * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
   */
  public io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepaliveOrBuilder getTcpKeepaliveOrBuilder() {
    return getTcpKeepalive();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (tcpKeepalive_ != null) {
      output.writeMessage(1, getTcpKeepalive());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (tcpKeepalive_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getTcpKeepalive());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions)) {
      return super.equals(obj);
    }
    io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions other = (io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions) obj;

    boolean result = true;
    result = result && (hasTcpKeepalive() == other.hasTcpKeepalive());
    if (hasTcpKeepalive()) {
      result = result && getTcpKeepalive()
          .equals(other.getTcpKeepalive());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasTcpKeepalive()) {
      hash = (37 * hash) + TCP_KEEPALIVE_FIELD_NUMBER;
      hash = (53 * hash) + getTcpKeepalive().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code envoy.api.v2.UpstreamConnectionOptions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:envoy.api.v2.UpstreamConnectionOptions)
      io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptionsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.xds.shaded.envoy.api.v2.Cds.internal_static_envoy_api_v2_UpstreamConnectionOptions_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.xds.shaded.envoy.api.v2.Cds.internal_static_envoy_api_v2_UpstreamConnectionOptions_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.class, io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.Builder.class);
    }

    // Construct using io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (tcpKeepaliveBuilder_ == null) {
        tcpKeepalive_ = null;
      } else {
        tcpKeepalive_ = null;
        tcpKeepaliveBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.xds.shaded.envoy.api.v2.Cds.internal_static_envoy_api_v2_UpstreamConnectionOptions_descriptor;
    }

    public io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions getDefaultInstanceForType() {
      return io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.getDefaultInstance();
    }

    public io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions build() {
      io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions buildPartial() {
      io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions result = new io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions(this);
      if (tcpKeepaliveBuilder_ == null) {
        result.tcpKeepalive_ = tcpKeepalive_;
      } else {
        result.tcpKeepalive_ = tcpKeepaliveBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions) {
        return mergeFrom((io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions other) {
      if (other == io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions.getDefaultInstance()) return this;
      if (other.hasTcpKeepalive()) {
        mergeTcpKeepalive(other.getTcpKeepalive());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive tcpKeepalive_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive, io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.Builder, io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepaliveOrBuilder> tcpKeepaliveBuilder_;
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public boolean hasTcpKeepalive() {
      return tcpKeepaliveBuilder_ != null || tcpKeepalive_ != null;
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive getTcpKeepalive() {
      if (tcpKeepaliveBuilder_ == null) {
        return tcpKeepalive_ == null ? io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.getDefaultInstance() : tcpKeepalive_;
      } else {
        return tcpKeepaliveBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public Builder setTcpKeepalive(io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive value) {
      if (tcpKeepaliveBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        tcpKeepalive_ = value;
        onChanged();
      } else {
        tcpKeepaliveBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public Builder setTcpKeepalive(
        io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.Builder builderForValue) {
      if (tcpKeepaliveBuilder_ == null) {
        tcpKeepalive_ = builderForValue.build();
        onChanged();
      } else {
        tcpKeepaliveBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public Builder mergeTcpKeepalive(io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive value) {
      if (tcpKeepaliveBuilder_ == null) {
        if (tcpKeepalive_ != null) {
          tcpKeepalive_ =
            io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.newBuilder(tcpKeepalive_).mergeFrom(value).buildPartial();
        } else {
          tcpKeepalive_ = value;
        }
        onChanged();
      } else {
        tcpKeepaliveBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public Builder clearTcpKeepalive() {
      if (tcpKeepaliveBuilder_ == null) {
        tcpKeepalive_ = null;
        onChanged();
      } else {
        tcpKeepalive_ = null;
        tcpKeepaliveBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.Builder getTcpKeepaliveBuilder() {
      
      onChanged();
      return getTcpKeepaliveFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    public io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepaliveOrBuilder getTcpKeepaliveOrBuilder() {
      if (tcpKeepaliveBuilder_ != null) {
        return tcpKeepaliveBuilder_.getMessageOrBuilder();
      } else {
        return tcpKeepalive_ == null ?
            io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.getDefaultInstance() : tcpKeepalive_;
      }
    }
    /**
     * <pre>
     * If set then set SO_KEEPALIVE on the socket to enable TCP Keepalives.
     * </pre>
     *
     * <code>.envoy.api.v2.core.TcpKeepalive tcp_keepalive = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive, io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.Builder, io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepaliveOrBuilder> 
        getTcpKeepaliveFieldBuilder() {
      if (tcpKeepaliveBuilder_ == null) {
        tcpKeepaliveBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive, io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepalive.Builder, io.grpc.xds.shaded.envoy.api.v2.core.TcpKeepaliveOrBuilder>(
                getTcpKeepalive(),
                getParentForChildren(),
                isClean());
        tcpKeepalive_ = null;
      }
      return tcpKeepaliveBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:envoy.api.v2.UpstreamConnectionOptions)
  }

  // @@protoc_insertion_point(class_scope:envoy.api.v2.UpstreamConnectionOptions)
  private static final io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions();
  }

  public static io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpstreamConnectionOptions>
      PARSER = new com.google.protobuf.AbstractParser<UpstreamConnectionOptions>() {
    public UpstreamConnectionOptions parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpstreamConnectionOptions(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpstreamConnectionOptions> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpstreamConnectionOptions> getParserForType() {
    return PARSER;
  }

  public io.grpc.xds.shaded.envoy.api.v2.UpstreamConnectionOptions getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

