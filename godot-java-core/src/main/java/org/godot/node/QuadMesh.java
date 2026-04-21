package org.godot.node;

import java.lang.foreign.MemorySegment;

public class QuadMesh extends PlaneMesh {
	QuadMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	QuadMesh(long nativePointer) {
		super(nativePointer);
	}
}
