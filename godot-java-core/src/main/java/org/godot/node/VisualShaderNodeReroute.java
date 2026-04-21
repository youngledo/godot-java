package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeReroute extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_port_type", 1287173294L));

	VisualShaderNodeReroute(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeReroute(long nativePointer) {
		super(nativePointer);
	}

	public long getPort_type() {
		return (long) super.call("get_port_type", new java.lang.Object[0]);
	}

	public void setPort_type(long value) {
		super.call("_set_port_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
