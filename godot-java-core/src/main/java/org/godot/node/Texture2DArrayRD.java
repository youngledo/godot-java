package org.godot.node;

import java.lang.foreign.MemorySegment;

public class Texture2DArrayRD extends TextureLayeredRD {
	Texture2DArrayRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Texture2DArrayRD(long nativePointer) {
		super(nativePointer);
	}
}
