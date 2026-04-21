package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OpenXRBindingModifier extends Resource {
	OpenXRBindingModifier(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRBindingModifier(long nativePointer) {
		super(nativePointer);
	}
}
