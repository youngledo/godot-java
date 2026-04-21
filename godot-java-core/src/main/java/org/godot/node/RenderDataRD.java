package org.godot.node;

import java.lang.foreign.MemorySegment;

public class RenderDataRD extends RenderData {
	RenderDataRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderDataRD(long nativePointer) {
		super(nativePointer);
	}
}
