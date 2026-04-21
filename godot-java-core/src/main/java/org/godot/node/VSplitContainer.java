package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VSplitContainer extends SplitContainer {
	VSplitContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VSplitContainer(long nativePointer) {
		super(nativePointer);
	}
}
