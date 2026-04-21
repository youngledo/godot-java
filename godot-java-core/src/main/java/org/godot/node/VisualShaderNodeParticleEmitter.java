package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParticleEmitter extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("is_mode_2d", 36873697L), java.util.Map.entry("set_mode_2d", 2586408642L));

	VisualShaderNodeParticleEmitter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParticleEmitter(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_mode_2d() {
		return (boolean) super.call("is_mode_2d");
	}

	public boolean isMode_2d() {
		return (boolean) super.call("is_mode_2d", new java.lang.Object[0]);
	}

	public void setMode_2d(boolean value) {
		super.call("set_mode_2d", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
