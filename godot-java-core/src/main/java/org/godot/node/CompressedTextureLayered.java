package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CompressedTextureLayered extends TextureLayered {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("load", 166001499L), java.util.Map.entry("get_load_path", 201670096L));

	CompressedTextureLayered(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CompressedTextureLayered(long nativePointer) {
		super(nativePointer);
	}

	public int load(String path) {
		return (int) super.call("load", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String getLoad_path() {
		return (String) super.call("get_load_path", new java.lang.Object[0]);
	}

	public void setLoad_path(String value) {
		super.call("load", new java.lang.Object[]{(java.lang.Object) value});
	}
}
