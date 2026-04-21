package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeUIntConstant extends VisualShaderNodeConstant {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant", 3905245786L), java.util.Map.entry("set_constant", 1286410249L));

	VisualShaderNodeUIntConstant(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeUIntConstant(long nativePointer) {
		super(nativePointer);
	}

	public long getConstant() {
		return (long) super.call("get_constant", new java.lang.Object[0]);
	}

	public void setConstant(long value) {
		super.call("set_constant", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
