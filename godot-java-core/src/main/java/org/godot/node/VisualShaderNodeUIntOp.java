package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeUIntOp extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_operator", 256631461L), java.util.Map.entry("set_operator", 3463048345L));

	VisualShaderNodeUIntOp(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeUIntOp(long nativePointer) {
		super(nativePointer);
	}

	public long getOperator() {
		return (long) super.call("get_operator", new java.lang.Object[0]);
	}

	public void setOperator(long value) {
		super.call("set_operator", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
