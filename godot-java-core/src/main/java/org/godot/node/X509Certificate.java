package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class X509Certificate extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load", 166001499L), java.util.Map.entry("save", 166001499L),
			java.util.Map.entry("load_from_string", 166001499L), java.util.Map.entry("save_to_string", 2841200299L));

	X509Certificate(MemorySegment nativePointer) {
		super(nativePointer);
	}

	X509Certificate(long nativePointer) {
		super(nativePointer);
	}

	public int save(String path) {
		return (int) super.call("save", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int load(String path) {
		return (int) super.call("load", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String save_to_string() {
		return (String) super.call("save_to_string");
	}

	public int load_from_string(String string) {
		return (int) super.call("load_from_string", new java.lang.Object[]{(java.lang.Object) string});
	}
}
