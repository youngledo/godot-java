package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PanelContainer extends Container {
	PanelContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PanelContainer(long nativePointer) {
		super(nativePointer);
	}
}
