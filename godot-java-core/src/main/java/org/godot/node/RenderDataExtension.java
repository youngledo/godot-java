package org.godot.node;

import java.lang.foreign.MemorySegment;

public class RenderDataExtension extends RenderData {
	RenderDataExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderDataExtension(long nativePointer) {
		super(nativePointer);
	}
}
