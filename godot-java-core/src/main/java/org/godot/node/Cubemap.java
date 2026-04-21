package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Cubemap extends ImageTextureLayered {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("create_placeholder", 121922552L));

	Cubemap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Cubemap(long nativePointer) {
		super(nativePointer);
	}

	public Resource create_placeholder() {
		return (Resource) super.call("create_placeholder");
	}
}
