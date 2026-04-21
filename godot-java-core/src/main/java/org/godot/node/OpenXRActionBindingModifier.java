package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OpenXRActionBindingModifier extends OpenXRBindingModifier {
	OpenXRActionBindingModifier(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRActionBindingModifier(long nativePointer) {
		super(nativePointer);
	}
}
