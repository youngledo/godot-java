package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VisualShaderNodeCubemapParameter extends VisualShaderNodeTextureParameter {
	VisualShaderNodeCubemapParameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeCubemapParameter(long nativePointer) {
		super(nativePointer);
	}
}
