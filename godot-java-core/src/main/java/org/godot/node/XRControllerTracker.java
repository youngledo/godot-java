package org.godot.node;

import java.lang.foreign.MemorySegment;

public class XRControllerTracker extends XRPositionalTracker {
	XRControllerTracker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRControllerTracker(long nativePointer) {
		super(nativePointer);
	}
}
