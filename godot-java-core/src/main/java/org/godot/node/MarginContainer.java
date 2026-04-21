package org.godot.node;

import java.lang.foreign.MemorySegment;

public class MarginContainer extends Container {
	MarginContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MarginContainer(long nativePointer) {
		super(nativePointer);
	}
}
