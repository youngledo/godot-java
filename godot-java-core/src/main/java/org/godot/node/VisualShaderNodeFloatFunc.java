package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeFloatFunc extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_function", 536026177L), java.util.Map.entry("get_function", 2033948868L));

	VisualShaderNodeFloatFunc(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeFloatFunc(long nativePointer) {
		super(nativePointer);
	}

	public long getFunction() {
		return (long) super.call("get_function", new java.lang.Object[0]);
	}

	public void setFunction(long value) {
		super.call("set_function", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
