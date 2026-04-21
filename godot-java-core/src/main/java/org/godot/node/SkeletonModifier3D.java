package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModifier3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_active", 36873697L), java.util.Map.entry("get_influence", 1740695150L),
			java.util.Map.entry("set_active", 2586408642L), java.util.Map.entry("set_influence", 373806689L),
			java.util.Map.entry("get_skeleton", 1488626673L));

	SkeletonModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public boolean isActive() {
		return (boolean) super.call("is_active", new java.lang.Object[0]);
	}

	public void setActive(boolean value) {
		super.call("set_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getInfluence() {
		return (double) super.call("get_influence", new java.lang.Object[0]);
	}

	public void setInfluence(double value) {
		super.call("set_influence", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
