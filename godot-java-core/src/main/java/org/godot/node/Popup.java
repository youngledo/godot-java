package org.godot.node;

import java.lang.foreign.MemorySegment;

public class Popup extends Window {
	Popup(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Popup(long nativePointer) {
		super(nativePointer);
	}
}
