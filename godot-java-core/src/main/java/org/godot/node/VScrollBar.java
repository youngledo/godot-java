package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VScrollBar extends ScrollBar {
	VScrollBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VScrollBar(long nativePointer) {
		super(nativePointer);
	}
}
