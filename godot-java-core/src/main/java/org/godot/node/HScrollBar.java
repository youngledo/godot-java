package org.godot.node;

import java.lang.foreign.MemorySegment;

public class HScrollBar extends ScrollBar {
	HScrollBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HScrollBar(long nativePointer) {
		super(nativePointer);
	}
}
