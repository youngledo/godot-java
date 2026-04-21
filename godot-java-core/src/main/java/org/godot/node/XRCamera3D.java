package org.godot.node;

import java.lang.foreign.MemorySegment;

public class XRCamera3D extends Camera3D {
	XRCamera3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRCamera3D(long nativePointer) {
		super(nativePointer);
	}
}
