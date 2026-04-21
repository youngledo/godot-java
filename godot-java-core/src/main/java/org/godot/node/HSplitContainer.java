package org.godot.node;

import java.lang.foreign.MemorySegment;

public class HSplitContainer extends SplitContainer {
	HSplitContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HSplitContainer(long nativePointer) {
		super(nativePointer);
	}
}
