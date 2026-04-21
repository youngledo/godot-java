package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ConcavePolygonShape3D extends Shape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_backface_collision_enabled", 36873697L),
			java.util.Map.entry("get_faces", 497664490L), java.util.Map.entry("set_faces", 334873810L),
			java.util.Map.entry("set_backface_collision_enabled", 2586408642L));

	ConcavePolygonShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConcavePolygonShape3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_backface_collision_enabled() {
		return (boolean) super.call("is_backface_collision_enabled");
	}

	public double[][] getData() {
		return (double[][]) super.call("get_faces", new java.lang.Object[0]);
	}

	public void setData(double[][] value) {
		super.call("set_faces", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isBackface_collision() {
		return (boolean) super.call("is_backface_collision_enabled", new java.lang.Object[0]);
	}

	public void setBackface_collision(boolean value) {
		super.call("set_backface_collision_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
