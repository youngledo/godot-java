package org.godot.node;

import java.lang.foreign.MemorySegment;

public class TextServerDummy extends TextServerExtension {
	TextServerDummy(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextServerDummy(long nativePointer) {
		super(nativePointer);
	}
}
