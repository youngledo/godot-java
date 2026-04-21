package org.godot.node;

import java.lang.foreign.MemorySegment;

public class TextServerExtension extends TextServer {
	TextServerExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextServerExtension(long nativePointer) {
		super(nativePointer);
	}
}
