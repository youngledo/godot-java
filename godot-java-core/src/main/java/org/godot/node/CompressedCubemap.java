package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CompressedCubemap extends CompressedTextureLayered {
	CompressedCubemap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CompressedCubemap(long nativePointer) {
		super(nativePointer);
	}
}
