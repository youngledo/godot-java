package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PointMesh extends PrimitiveMesh {
	PointMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PointMesh(long nativePointer) {
		super(nativePointer);
	}
}
