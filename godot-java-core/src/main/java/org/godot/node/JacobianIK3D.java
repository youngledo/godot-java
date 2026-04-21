package org.godot.node;

import java.lang.foreign.MemorySegment;

public class JacobianIK3D extends IterateIK3D {
	JacobianIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JacobianIK3D(long nativePointer) {
		super(nativePointer);
	}
}
