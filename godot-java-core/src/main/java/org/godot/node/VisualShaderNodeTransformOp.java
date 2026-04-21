package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeTransformOp extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_operator", 1238663601L), java.util.Map.entry("set_operator", 2287310733L));

	VisualShaderNodeTransformOp(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeTransformOp(long nativePointer) {
		super(nativePointer);
	}

	public long getOperator() {
		return (long) super.call("get_operator", new java.lang.Object[0]);
	}

	public void setOperator(long value) {
		super.call("set_operator", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
