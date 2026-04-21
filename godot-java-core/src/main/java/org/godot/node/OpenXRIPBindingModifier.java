package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OpenXRIPBindingModifier extends OpenXRBindingModifier {
	OpenXRIPBindingModifier(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRIPBindingModifier(long nativePointer) {
		super(nativePointer);
	}
}
