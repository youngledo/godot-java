package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class VisualShaderNodeVec2Constant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 3341600327L), java.util.Map.entry("set_constant", 743155724L));

	VisualShaderNodeVec2Constant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeVec2Constant(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getConstant() {
		return (Vector2) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(Vector2 value) {
		super.call("set_constant", new java.lang.Object[]{(java.lang.Object) value});
	}
}
