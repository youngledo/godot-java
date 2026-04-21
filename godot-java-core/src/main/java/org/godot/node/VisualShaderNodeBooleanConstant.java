package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeBooleanConstant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 36873697L), java.util.Map.entry("set_constant", 2586408642L));

	VisualShaderNodeBooleanConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeBooleanConstant(long nativePointer) {
		super(nativePointer);
	}

	public boolean getConstant() {
		return (boolean) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(boolean value) {
		super.call("set_constant", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
