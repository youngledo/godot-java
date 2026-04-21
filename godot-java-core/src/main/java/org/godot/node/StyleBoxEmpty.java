package org.godot.node;

import java.lang.foreign.MemorySegment;

public class StyleBoxEmpty extends StyleBox {
	StyleBoxEmpty(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StyleBoxEmpty(long nativePointer) {
		super(nativePointer);
	}
}
