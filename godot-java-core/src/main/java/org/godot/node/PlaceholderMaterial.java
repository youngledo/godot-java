package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PlaceholderMaterial extends Material {
	PlaceholderMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaceholderMaterial(long nativePointer) {
		super(nativePointer);
	}
}
