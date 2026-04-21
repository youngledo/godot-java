package org.godot.node;

import java.lang.foreign.MemorySegment;

public class Texture extends Resource {
	Texture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Texture(long nativePointer) {
		super(nativePointer);
	}
}
