package org.godot.node;

import java.lang.foreign.MemorySegment;

public class RenderSceneBuffersExtension extends RenderSceneBuffers {
	RenderSceneBuffersExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneBuffersExtension(long nativePointer) {
		super(nativePointer);
	}
}
