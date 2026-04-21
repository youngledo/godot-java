package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PlaceholderCubemap extends PlaceholderTextureLayered {
	PlaceholderCubemap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaceholderCubemap(long nativePointer) {
		super(nativePointer);
	}
}
