package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParticleAccelerator extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_mode", 2660365633L), java.util.Map.entry("set_mode", 3457585749L));

	VisualShaderNodeParticleAccelerator(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParticleAccelerator(long nativePointer) {
		super(nativePointer);
	}

	public long getMode() {
		return (long) super.call("get_mode", new java.lang.Object[0]);
	}

	public void setMode(long value) {
		super.call("set_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
