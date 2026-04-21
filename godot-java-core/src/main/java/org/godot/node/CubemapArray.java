package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CubemapArray extends ImageTextureLayered {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("create_placeholder", 121922552L));

	CubemapArray(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CubemapArray(long nativePointer) {
		super(nativePointer);
	}

	public Resource create_placeholder() {
		return (Resource) super.call("create_placeholder");
	}
}
