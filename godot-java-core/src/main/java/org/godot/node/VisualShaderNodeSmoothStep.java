package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeSmoothStep extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_op_type", 2427426148L), java.util.Map.entry("get_op_type", 359640855L));

	VisualShaderNodeSmoothStep(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeSmoothStep(long nativePointer) {
		super(nativePointer);
	}

	public long getOp_type() {
		return (long) super.call("get_op_type", new java.lang.Object[0]);
	}

	public void setOp_type(long value) {
		super.call("set_op_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
