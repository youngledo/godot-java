package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VFlowContainer extends FlowContainer {
	VFlowContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VFlowContainer(long nativePointer) {
		super(nativePointer);
	}
}
