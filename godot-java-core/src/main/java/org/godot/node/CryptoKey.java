package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CryptoKey extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_public_only", 36873697L), java.util.Map.entry("load", 885841341L),
			java.util.Map.entry("save", 885841341L), java.util.Map.entry("load_from_string", 885841341L),
			java.util.Map.entry("save_to_string", 32795936L));

	CryptoKey(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CryptoKey(long nativePointer) {
		super(nativePointer);
	}

	public int save(String path, boolean public_only) {
		return (int) super.call("save",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(public_only)});
	}

	public int load(String path, boolean public_only) {
		return (int) super.call("load",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(public_only)});
	}

	public boolean is_public_only() {
		return (boolean) super.call("is_public_only");
	}

	public String save_to_string(boolean public_only) {
		return (String) super.call("save_to_string", new java.lang.Object[]{java.lang.Boolean.valueOf(public_only)});
	}

	public int load_from_string(String string_key, boolean public_only) {
		return (int) super.call("load_from_string",
				new java.lang.Object[]{(java.lang.Object) string_key, java.lang.Boolean.valueOf(public_only)});
	}
}
