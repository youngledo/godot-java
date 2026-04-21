package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParticleEmit extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_flags", 171277835L), java.util.Map.entry("set_flags", 3960756792L));

	VisualShaderNodeParticleEmit(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParticleEmit(long nativePointer) {
		super(nativePointer);
	}

	public long getFlags() {
		return (long) super.call("get_flags", new java.lang.Object[0]);
	}

	public void setFlags(long value) {
		super.call("set_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
