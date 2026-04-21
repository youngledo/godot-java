package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class HTTPRequest extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("request", 3215244323L), java.util.Map.entry("set_download_file", 83702148L),
			java.util.Map.entry("set_use_threads", 2586408642L), java.util.Map.entry("set_accept_gzip", 2586408642L),
			java.util.Map.entry("get_timeout", 191475506L), java.util.Map.entry("set_https_proxy", 2956805083L),
			java.util.Map.entry("get_body_size_limit", 3905245786L),
			java.util.Map.entry("is_accepting_gzip", 36873697L), java.util.Map.entry("request_raw", 2714829993L),
			java.util.Map.entry("get_body_size", 3905245786L), java.util.Map.entry("cancel_request", 3218959716L),
			java.util.Map.entry("is_using_threads", 36873697L), java.util.Map.entry("set_body_size_limit", 1286410249L),
			java.util.Map.entry("set_tls_options", 2210231844L),
			java.util.Map.entry("get_http_client_status", 1426656811L), java.util.Map.entry("set_timeout", 373806689L),
			java.util.Map.entry("set_http_proxy", 2956805083L), java.util.Map.entry("get_download_file", 201670096L),
			java.util.Map.entry("set_max_redirects", 1286410249L),
			java.util.Map.entry("get_downloaded_bytes", 3905245786L),
			java.util.Map.entry("get_max_redirects", 3905245786L),
			java.util.Map.entry("get_download_chunk_size", 3905245786L),
			java.util.Map.entry("set_download_chunk_size", 1286410249L));

	HTTPRequest(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HTTPRequest(long nativePointer) {
		super(nativePointer);
	}

	public int request(String url, String[] custom_headers, int method, String request_data) {
		return (int) super.call("request", new java.lang.Object[]{(java.lang.Object) url,
				(java.lang.Object) custom_headers, java.lang.Integer.valueOf(method), (java.lang.Object) request_data});
	}

	public int request_raw(String url, String[] custom_headers, int method, byte[] request_data_raw) {
		return (int) super.call("request_raw",
				new java.lang.Object[]{(java.lang.Object) url, (java.lang.Object) custom_headers,
						java.lang.Integer.valueOf(method), (java.lang.Object) request_data_raw});
	}

	public void cancel_request() {
		super.call("cancel_request");
	}

	public boolean is_using_threads() {
		return (boolean) super.call("is_using_threads");
	}

	public boolean is_accepting_gzip() {
		return (boolean) super.call("is_accepting_gzip");
	}

	public void set_http_proxy(String host, long port) {
		super.call("set_http_proxy", new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}

	public void set_https_proxy(String host, long port) {
		super.call("set_https_proxy", new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}

	public String getDownload_file() {
		return (String) super.call("get_download_file", new java.lang.Object[0]);
	}

	public void setDownload_file(String value) {
		super.call("set_download_file", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDownload_chunk_size() {
		return (long) super.call("get_download_chunk_size", new java.lang.Object[0]);
	}

	public void setDownload_chunk_size(long value) {
		super.call("set_download_chunk_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_threads() {
		return (boolean) super.call("is_using_threads", new java.lang.Object[0]);
	}

	public void setUse_threads(boolean value) {
		super.call("set_use_threads", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAccept_gzip() {
		return (boolean) super.call("is_accepting_gzip", new java.lang.Object[0]);
	}

	public void setAccept_gzip(boolean value) {
		super.call("set_accept_gzip", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getBody_size_limit() {
		return (long) super.call("get_body_size_limit", new java.lang.Object[0]);
	}

	public void setBody_size_limit(long value) {
		super.call("set_body_size_limit", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_redirects() {
		return (long) super.call("get_max_redirects", new java.lang.Object[0]);
	}

	public void setMax_redirects(long value) {
		super.call("set_max_redirects", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getTimeout() {
		return (double) super.call("get_timeout", new java.lang.Object[0]);
	}

	public void setTimeout(double value) {
		super.call("set_timeout", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
