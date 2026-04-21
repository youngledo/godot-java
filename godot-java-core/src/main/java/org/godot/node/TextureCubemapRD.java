package org.godot.node;

import java.lang.foreign.MemorySegment;

public class TextureCubemapRD extends TextureLayeredRD {
	TextureCubemapRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextureCubemapRD(long nativePointer) {
		super(nativePointer);
	}
}
