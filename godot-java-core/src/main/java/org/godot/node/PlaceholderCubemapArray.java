package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PlaceholderCubemapArray extends PlaceholderTextureLayered {
	PlaceholderCubemapArray(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaceholderCubemapArray(long nativePointer) {
		super(nativePointer);
	}
}
