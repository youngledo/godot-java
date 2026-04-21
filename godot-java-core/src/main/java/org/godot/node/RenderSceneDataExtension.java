package org.godot.node;

import java.lang.foreign.MemorySegment;

public class RenderSceneDataExtension extends RenderSceneData {
	RenderSceneDataExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneDataExtension(long nativePointer) {
		super(nativePointer);
	}
}
