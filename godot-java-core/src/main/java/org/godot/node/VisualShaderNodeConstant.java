package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VisualShaderNodeConstant extends VisualShaderNode {
	VisualShaderNodeConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeConstant(long nativePointer) {
		super(nativePointer);
	}
}
