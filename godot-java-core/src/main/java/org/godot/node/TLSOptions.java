package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class TLSOptions extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("server", 36969539L), java.util.Map.entry("get_trusted_ca_chain", 1120709175L),
			java.util.Map.entry("is_server", 36873697L), java.util.Map.entry("client_unsafe", 2090251749L),
			java.util.Map.entry("get_private_key", 2119971811L), java.util.Map.entry("is_unsafe_client", 36873697L),
			java.util.Map.entry("client", 3565000357L), java.util.Map.entry("get_own_certificate", 1120709175L),
			java.util.Map.entry("get_common_name_override", 201670096L));

	TLSOptions(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TLSOptions(long nativePointer) {
		super(nativePointer);
	}

	public TLSOptions client(X509Certificate trusted_chain, String common_name_override) {
		return (TLSOptions) super.call("client",
				new java.lang.Object[]{(java.lang.Object) trusted_chain, (java.lang.Object) common_name_override});
	}

	public TLSOptions client_unsafe(X509Certificate trusted_chain) {
		return (TLSOptions) super.call("client_unsafe", new java.lang.Object[]{(java.lang.Object) trusted_chain});
	}

	public TLSOptions server(CryptoKey key, X509Certificate certificate) {
		return (TLSOptions) super.call("server",
				new java.lang.Object[]{(java.lang.Object) key, (java.lang.Object) certificate});
	}

	public boolean is_server() {
		return (boolean) super.call("is_server");
	}

	public boolean is_unsafe_client() {
		return (boolean) super.call("is_unsafe_client");
	}
}
