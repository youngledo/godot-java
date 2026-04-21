package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ORMMaterial3D extends BaseMaterial3D {
	ORMMaterial3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ORMMaterial3D(long nativePointer) {
		super(nativePointer);
	}
}
