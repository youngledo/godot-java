package org.godot.node;

import java.lang.foreign.MemorySegment;

public class RenderSceneDataRD extends RenderSceneData {
	RenderSceneDataRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneDataRD(long nativePointer) {
		super(nativePointer);
	}
}
