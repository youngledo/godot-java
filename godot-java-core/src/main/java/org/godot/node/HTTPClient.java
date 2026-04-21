package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;

public class HTTPClient extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("request", 3778990155L), java.util.Map.entry("set_blocking_mode", 2586408642L),
			java.util.Map.entry("is_blocking_mode_enabled", 36873697L),
			java.util.Map.entry("get_response_headers", 2981934095L),
			java.util.Map.entry("set_https_proxy", 2956805083L), java.util.Map.entry("get_connection", 2741655269L),
			java.util.Map.entry("query_string_from_dict", 2538086567L), java.util.Map.entry("request_raw", 540161961L),
			java.util.Map.entry("get_status", 1426656811L), java.util.Map.entry("get_response_code", 3905245786L),
			java.util.Map.entry("has_response", 36873697L), java.util.Map.entry("poll", 166280745L),
			java.util.Map.entry("get_response_body_length", 3905245786L),
			java.util.Map.entry("set_connection", 3281897016L), java.util.Map.entry("is_response_chunked", 36873697L),
			java.util.Map.entry("set_http_proxy", 2956805083L), java.util.Map.entry("connect_to_host", 504540374L),
			java.util.Map.entry("get_response_headers_as_dictionary", 2382534195L),
			java.util.Map.entry("get_read_chunk_size", 3905245786L),
			java.util.Map.entry("read_response_body_chunk", 2115431945L), java.util.Map.entry("close", 3218959716L),
			java.util.Map.entry("set_read_chunk_size", 1286410249L));

	HTTPClient(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HTTPClient(long nativePointer) {
		super(nativePointer);
	}

	public int connect_to_host(String host, long port, TLSOptions tls_options) {
		return (int) super.call("connect_to_host", new java.lang.Object[]{(java.lang.Object) host,
				java.lang.Long.valueOf(port), (java.lang.Object) tls_options});
	}

	public int request_raw(int method, String url, String[] headers, byte[] body) {
		return (int) super.call("request_raw", new java.lang.Object[]{java.lang.Integer.valueOf(method),
				(java.lang.Object) url, (java.lang.Object) headers, (java.lang.Object) body});
	}

	public int request(int method, String url, String[] headers, String body) {
		return (int) super.call("request", new java.lang.Object[]{java.lang.Integer.valueOf(method),
				(java.lang.Object) url, (java.lang.Object) headers, (java.lang.Object) body});
	}

	public void close() {
		super.call("close");
	}

	public boolean has_response() {
		return (boolean) super.call("has_response");
	}

	public boolean is_response_chunked() {
		return (boolean) super.call("is_response_chunked");
	}

	public byte[] read_response_body_chunk() {
		return (byte[]) super.call("read_response_body_chunk");
	}

	public boolean is_blocking_mode_enabled() {
		return (boolean) super.call("is_blocking_mode_enabled");
	}

	public int poll() {
		return (int) super.call("poll");
	}

	public void set_http_proxy(String host, long port) {
		super.call("set_http_proxy", new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}

	public void set_https_proxy(String host, long port) {
		super.call("set_https_proxy", new java.lang.Object[]{(java.lang.Object) host, java.lang.Long.valueOf(port)});
	}

	public String query_string_from_dict(GodotDictionary fields) {
		return (String) super.call("query_string_from_dict", new java.lang.Object[]{(java.lang.Object) fields});
	}

	public boolean isBlocking_mode_enabled() {
		return (boolean) super.call("is_blocking_mode_enabled", new java.lang.Object[0]);
	}

	public void setBlocking_mode_enabled(boolean value) {
		super.call("set_blocking_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public StreamPeer getConnection() {
		return (StreamPeer) super.call("get_connection", new java.lang.Object[0]);
	}

	public void setConnection(StreamPeer value) {
		super.call("set_connection", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getRead_chunk_size() {
		return (long) super.call("get_read_chunk_size", new java.lang.Object[0]);
	}

	public void setRead_chunk_size(long value) {
		super.call("set_read_chunk_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
