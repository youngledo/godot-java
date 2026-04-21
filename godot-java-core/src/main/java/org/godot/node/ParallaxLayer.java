package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class ParallaxLayer extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_mirroring", 3341600327L), java.util.Map.entry("set_motion_scale", 743155724L),
			java.util.Map.entry("set_motion_offset", 743155724L), java.util.Map.entry("set_mirroring", 743155724L),
			java.util.Map.entry("get_motion_offset", 3341600327L),
			java.util.Map.entry("get_motion_scale", 3341600327L));

	ParallaxLayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ParallaxLayer(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getMotion_scale() {
		return (Vector2) super.call("get_motion_scale", new java.lang.Object[0]);
	}

	public void setMotion_scale(Vector2 value) {
		super.call("set_motion_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getMotion_offset() {
		return (Vector2) super.call("get_motion_offset", new java.lang.Object[0]);
	}

	public void setMotion_offset(Vector2 value) {
		super.call("set_motion_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getMotion_mirroring() {
		return (Vector2) super.call("get_mirroring", new java.lang.Object[0]);
	}

	public void setMotion_mirroring(Vector2 value) {
		super.call("set_mirroring", new java.lang.Object[]{(java.lang.Object) value});
	}
}
