// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: envoy/api/v2/auth/cert.proto

package io.grpc.xds.shaded.envoy.api.v2.auth;

public interface TlsParametersOrBuilder extends
    // @@protoc_insertion_point(interface_extends:envoy.api.v2.auth.TlsParameters)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Minimum TLS protocol version.
   * </pre>
   *
   * <code>.envoy.api.v2.auth.TlsParameters.TlsProtocol tls_minimum_protocol_version = 1 [(.validate.rules) = { ... }</code>
   */
  int getTlsMinimumProtocolVersionValue();
  /**
   * <pre>
   * Minimum TLS protocol version.
   * </pre>
   *
   * <code>.envoy.api.v2.auth.TlsParameters.TlsProtocol tls_minimum_protocol_version = 1 [(.validate.rules) = { ... }</code>
   */
  io.grpc.xds.shaded.envoy.api.v2.auth.TlsParameters.TlsProtocol getTlsMinimumProtocolVersion();

  /**
   * <pre>
   * Maximum TLS protocol version.
   * </pre>
   *
   * <code>.envoy.api.v2.auth.TlsParameters.TlsProtocol tls_maximum_protocol_version = 2 [(.validate.rules) = { ... }</code>
   */
  int getTlsMaximumProtocolVersionValue();
  /**
   * <pre>
   * Maximum TLS protocol version.
   * </pre>
   *
   * <code>.envoy.api.v2.auth.TlsParameters.TlsProtocol tls_maximum_protocol_version = 2 [(.validate.rules) = { ... }</code>
   */
  io.grpc.xds.shaded.envoy.api.v2.auth.TlsParameters.TlsProtocol getTlsMaximumProtocolVersion();

  /**
   * <pre>
   * If specified, the TLS listener will only support the specified `cipher list
   * &lt;https://commondatastorage.googleapis.com/chromium-boringssl-docs/ssl.h.html#Cipher-suite-configuration&gt;`_.
   * If not specified, the default list:
   * .. code-block:: none
   *   [ECDHE-ECDSA-AES128-GCM-SHA256|ECDHE-ECDSA-CHACHA20-POLY1305]
   *   [ECDHE-RSA-AES128-GCM-SHA256|ECDHE-RSA-CHACHA20-POLY1305]
   *   ECDHE-ECDSA-AES128-SHA
   *   ECDHE-RSA-AES128-SHA
   *   AES128-GCM-SHA256
   *   AES128-SHA
   *   ECDHE-ECDSA-AES256-GCM-SHA384
   *   ECDHE-RSA-AES256-GCM-SHA384
   *   ECDHE-ECDSA-AES256-SHA
   *   ECDHE-RSA-AES256-SHA
   *   AES256-GCM-SHA384
   *   AES256-SHA
   * will be used.
   * </pre>
   *
   * <code>repeated string cipher_suites = 3;</code>
   */
  java.util.List<java.lang.String>
      getCipherSuitesList();
  /**
   * <pre>
   * If specified, the TLS listener will only support the specified `cipher list
   * &lt;https://commondatastorage.googleapis.com/chromium-boringssl-docs/ssl.h.html#Cipher-suite-configuration&gt;`_.
   * If not specified, the default list:
   * .. code-block:: none
   *   [ECDHE-ECDSA-AES128-GCM-SHA256|ECDHE-ECDSA-CHACHA20-POLY1305]
   *   [ECDHE-RSA-AES128-GCM-SHA256|ECDHE-RSA-CHACHA20-POLY1305]
   *   ECDHE-ECDSA-AES128-SHA
   *   ECDHE-RSA-AES128-SHA
   *   AES128-GCM-SHA256
   *   AES128-SHA
   *   ECDHE-ECDSA-AES256-GCM-SHA384
   *   ECDHE-RSA-AES256-GCM-SHA384
   *   ECDHE-ECDSA-AES256-SHA
   *   ECDHE-RSA-AES256-SHA
   *   AES256-GCM-SHA384
   *   AES256-SHA
   * will be used.
   * </pre>
   *
   * <code>repeated string cipher_suites = 3;</code>
   */
  int getCipherSuitesCount();
  /**
   * <pre>
   * If specified, the TLS listener will only support the specified `cipher list
   * &lt;https://commondatastorage.googleapis.com/chromium-boringssl-docs/ssl.h.html#Cipher-suite-configuration&gt;`_.
   * If not specified, the default list:
   * .. code-block:: none
   *   [ECDHE-ECDSA-AES128-GCM-SHA256|ECDHE-ECDSA-CHACHA20-POLY1305]
   *   [ECDHE-RSA-AES128-GCM-SHA256|ECDHE-RSA-CHACHA20-POLY1305]
   *   ECDHE-ECDSA-AES128-SHA
   *   ECDHE-RSA-AES128-SHA
   *   AES128-GCM-SHA256
   *   AES128-SHA
   *   ECDHE-ECDSA-AES256-GCM-SHA384
   *   ECDHE-RSA-AES256-GCM-SHA384
   *   ECDHE-ECDSA-AES256-SHA
   *   ECDHE-RSA-AES256-SHA
   *   AES256-GCM-SHA384
   *   AES256-SHA
   * will be used.
   * </pre>
   *
   * <code>repeated string cipher_suites = 3;</code>
   */
  java.lang.String getCipherSuites(int index);
  /**
   * <pre>
   * If specified, the TLS listener will only support the specified `cipher list
   * &lt;https://commondatastorage.googleapis.com/chromium-boringssl-docs/ssl.h.html#Cipher-suite-configuration&gt;`_.
   * If not specified, the default list:
   * .. code-block:: none
   *   [ECDHE-ECDSA-AES128-GCM-SHA256|ECDHE-ECDSA-CHACHA20-POLY1305]
   *   [ECDHE-RSA-AES128-GCM-SHA256|ECDHE-RSA-CHACHA20-POLY1305]
   *   ECDHE-ECDSA-AES128-SHA
   *   ECDHE-RSA-AES128-SHA
   *   AES128-GCM-SHA256
   *   AES128-SHA
   *   ECDHE-ECDSA-AES256-GCM-SHA384
   *   ECDHE-RSA-AES256-GCM-SHA384
   *   ECDHE-ECDSA-AES256-SHA
   *   ECDHE-RSA-AES256-SHA
   *   AES256-GCM-SHA384
   *   AES256-SHA
   * will be used.
   * </pre>
   *
   * <code>repeated string cipher_suites = 3;</code>
   */
  com.google.protobuf.ByteString
      getCipherSuitesBytes(int index);

  /**
   * <pre>
   * If specified, the TLS connection will only support the specified ECDH
   * curves. If not specified, the default curves (X25519, P-256) will be used.
   * </pre>
   *
   * <code>repeated string ecdh_curves = 4;</code>
   */
  java.util.List<java.lang.String>
      getEcdhCurvesList();
  /**
   * <pre>
   * If specified, the TLS connection will only support the specified ECDH
   * curves. If not specified, the default curves (X25519, P-256) will be used.
   * </pre>
   *
   * <code>repeated string ecdh_curves = 4;</code>
   */
  int getEcdhCurvesCount();
  /**
   * <pre>
   * If specified, the TLS connection will only support the specified ECDH
   * curves. If not specified, the default curves (X25519, P-256) will be used.
   * </pre>
   *
   * <code>repeated string ecdh_curves = 4;</code>
   */
  java.lang.String getEcdhCurves(int index);
  /**
   * <pre>
   * If specified, the TLS connection will only support the specified ECDH
   * curves. If not specified, the default curves (X25519, P-256) will be used.
   * </pre>
   *
   * <code>repeated string ecdh_curves = 4;</code>
   */
  com.google.protobuf.ByteString
      getEcdhCurvesBytes(int index);
}
