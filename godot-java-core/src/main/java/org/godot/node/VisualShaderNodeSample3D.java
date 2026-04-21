package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeSample3D extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_source", 1079494121L), java.util.Map.entry("set_source", 3315130991L));

	VisualShaderNodeSample3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeSample3D(long nativePointer) {
		super(nativePointer);
	}

	public long getSource() {
		return (long) super.call("get_source", new java.lang.Object[0]);
	}

	public void setSource(long value) {
		super.call("set_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
