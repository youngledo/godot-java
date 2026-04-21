package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeFloatConstant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 1740695150L), java.util.Map.entry("set_constant", 373806689L));

	VisualShaderNodeFloatConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeFloatConstant(long nativePointer) {
		super(nativePointer);
	}

	public double getConstant() {
		return (double) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(double value) {
		super.call("set_constant", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
