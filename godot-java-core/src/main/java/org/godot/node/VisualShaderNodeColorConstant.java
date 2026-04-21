package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class VisualShaderNodeColorConstant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 3444240500L), java.util.Map.entry("set_constant", 2920490490L));

	VisualShaderNodeColorConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeColorConstant(long nativePointer) {
		super(nativePointer);
	}

	public Color getConstant() {
		return (Color) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(Color value) {
		super.call("set_constant", new java.lang.Object[]{(java.lang.Object) value});
	}
}
