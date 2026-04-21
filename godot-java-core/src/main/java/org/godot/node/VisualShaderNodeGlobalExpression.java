package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VisualShaderNodeGlobalExpression extends VisualShaderNodeExpression {
	VisualShaderNodeGlobalExpression(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeGlobalExpression(long nativePointer) {
		super(nativePointer);
	}
}
