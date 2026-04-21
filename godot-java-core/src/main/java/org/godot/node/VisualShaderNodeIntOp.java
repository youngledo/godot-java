package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeIntOp extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_operator", 1236987913L), java.util.Map.entry("set_operator", 1677909323L));

	VisualShaderNodeIntOp(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeIntOp(long nativePointer) {
		super(nativePointer);
	}

	public long getOperator() {
		return (long) super.call("get_operator", new java.lang.Object[0]);
	}

	public void setOperator(long value) {
		super.call("set_operator", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
