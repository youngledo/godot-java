package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OpenXRVisibilityMask extends VisualInstance3D {
	OpenXRVisibilityMask(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRVisibilityMask(long nativePointer) {
		super(nativePointer);
	}
}
