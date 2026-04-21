package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VBoxContainer extends BoxContainer {
	VBoxContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VBoxContainer(long nativePointer) {
		super(nativePointer);
	}
}
