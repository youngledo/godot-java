package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeSwitch extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_op_type", 510471861L), java.util.Map.entry("get_op_type", 2517845071L));

	VisualShaderNodeSwitch(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeSwitch(long nativePointer) {
		super(nativePointer);
	}

	public long getOp_type() {
		return (long) super.call("get_op_type", new java.lang.Object[0]);
	}

	public void setOp_type(long value) {
		super.call("set_op_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
