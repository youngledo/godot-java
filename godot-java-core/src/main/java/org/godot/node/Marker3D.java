package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Marker3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_gizmo_extents", 373806689L),
			java.util.Map.entry("get_gizmo_extents", 1740695150L));

	Marker3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Marker3D(long nativePointer) {
		super(nativePointer);
	}

	public double getGizmo_extents() {
		return (double) super.call("get_gizmo_extents", new java.lang.Object[0]);
	}

	public void setGizmo_extents(double value) {
		super.call("set_gizmo_extents", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
