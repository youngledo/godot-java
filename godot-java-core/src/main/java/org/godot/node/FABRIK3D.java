package org.godot.node;

import java.lang.foreign.MemorySegment;

public class FABRIK3D extends IterateIK3D {
	FABRIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FABRIK3D(long nativePointer) {
		super(nativePointer);
	}
}
