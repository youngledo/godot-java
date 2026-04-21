package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CheckBox extends Button {
	CheckBox(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CheckBox(long nativePointer) {
		super(nativePointer);
	}
}
