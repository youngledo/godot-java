package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CompressedCubemapArray extends CompressedTextureLayered {
	CompressedCubemapArray(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CompressedCubemapArray(long nativePointer) {
		super(nativePointer);
	}
}
