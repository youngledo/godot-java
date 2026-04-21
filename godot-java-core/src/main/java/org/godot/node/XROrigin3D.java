package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class XROrigin3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_world_scale", 1740695150L), java.util.Map.entry("set_world_scale", 373806689L),
			java.util.Map.entry("is_current", 36873697L), java.util.Map.entry("set_current", 2586408642L));

	XROrigin3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XROrigin3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_current() {
		return (boolean) super.call("is_current");
	}

	public double getWorld_scale() {
		return (double) super.call("get_world_scale", new java.lang.Object[0]);
	}

	public void setWorld_scale(double value) {
		super.call("set_world_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCurrent() {
		return (boolean) super.call("is_current", new java.lang.Object[0]);
	}

	public void setCurrent(boolean value) {
		super.call("set_current", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
