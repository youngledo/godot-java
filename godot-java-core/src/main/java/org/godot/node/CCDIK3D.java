package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CCDIK3D extends IterateIK3D {
	CCDIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CCDIK3D(long nativePointer) {
		super(nativePointer);
	}
}
