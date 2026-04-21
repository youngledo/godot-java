package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CSGCombiner3D extends CSGShape3D {
	CSGCombiner3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CSGCombiner3D(long nativePointer) {
		super(nativePointer);
	}
}
