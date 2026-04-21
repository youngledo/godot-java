package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeParticleMultiplyByAxisAngle extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_degrees_mode", 2586408642L), java.util.Map.entry("is_degrees_mode", 36873697L));

	VisualShaderNodeParticleMultiplyByAxisAngle(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeParticleMultiplyByAxisAngle(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_degrees_mode() {
		return (boolean) super.call("is_degrees_mode");
	}

	public boolean isDegrees_mode() {
		return (boolean) super.call("is_degrees_mode", new java.lang.Object[0]);
	}

	public void setDegrees_mode(boolean value) {
		super.call("set_degrees_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
