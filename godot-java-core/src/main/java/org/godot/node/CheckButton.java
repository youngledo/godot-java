package org.godot.node;

import java.lang.foreign.MemorySegment;

public class CheckButton extends Button {
	CheckButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CheckButton(long nativePointer) {
		super(nativePointer);
	}
}
