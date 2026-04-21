package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OpenXRHapticBase extends Resource {
	OpenXRHapticBase(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRHapticBase(long nativePointer) {
		super(nativePointer);
	}
}
