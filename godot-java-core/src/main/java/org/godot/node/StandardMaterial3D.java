package org.godot.node;

import java.lang.foreign.MemorySegment;

public class StandardMaterial3D extends BaseMaterial3D {
	StandardMaterial3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StandardMaterial3D(long nativePointer) {
		super(nativePointer);
	}
}
