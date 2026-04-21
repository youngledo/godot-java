package org.godot.node;

import java.lang.foreign.MemorySegment;

public class HFlowContainer extends FlowContainer {
	HFlowContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HFlowContainer(long nativePointer) {
		super(nativePointer);
	}
}
