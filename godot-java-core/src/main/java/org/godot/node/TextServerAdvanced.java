package org.godot.node;

import java.lang.foreign.MemorySegment;

public class TextServerAdvanced extends TextServerExtension {
	TextServerAdvanced(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextServerAdvanced(long nativePointer) {
		super(nativePointer);
	}
}
