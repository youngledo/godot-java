package org.godot.node;

import java.lang.foreign.MemorySegment;

public class Panel extends Control {
	Panel(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Panel(long nativePointer) {
		super(nativePointer);
	}
}
