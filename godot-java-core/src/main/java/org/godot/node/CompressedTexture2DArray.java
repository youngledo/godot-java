package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CompressedTexture2DArray extends CompressedTextureLayered {
	CompressedTexture2DArray(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CompressedTexture2DArray(long nativePointer) {
		super(nativePointer);
	}
}
