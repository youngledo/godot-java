package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeUIntFunc extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_function", 2273148961L), java.util.Map.entry("get_function", 4187123296L));

	VisualShaderNodeUIntFunc(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeUIntFunc(long nativePointer) {
		super(nativePointer);
	}

	public long getFunction() {
		return (long) super.call("get_function", new java.lang.Object[0]);
	}

	public void setFunction(long value) {
		super.call("set_function", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
