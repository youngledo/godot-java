package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class LightOccluder2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_set_as_sdf_collision", 36873697L),
			java.util.Map.entry("get_occluder_polygon", 3962317075L),
			java.util.Map.entry("get_occluder_light_mask", 3905245786L),
			java.util.Map.entry("set_occluder_polygon", 3258315893L),
			java.util.Map.entry("set_occluder_light_mask", 1286410249L),
			java.util.Map.entry("set_as_sdf_collision", 2586408642L));

	LightOccluder2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LightOccluder2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_set_as_sdf_collision() {
		return (boolean) super.call("is_set_as_sdf_collision");
	}

	public OccluderPolygon2D getOccluder() {
		return (OccluderPolygon2D) super.call("get_occluder_polygon", new java.lang.Object[0]);
	}

	public void setOccluder(OccluderPolygon2D value) {
		super.call("set_occluder_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isSdf_collision() {
		return (boolean) super.call("is_set_as_sdf_collision", new java.lang.Object[0]);
	}

	public void setSdf_collision(boolean value) {
		super.call("set_as_sdf_collision", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getOccluder_light_mask() {
		return (long) super.call("get_occluder_light_mask", new java.lang.Object[0]);
	}

	public void setOccluder_light_mask(long value) {
		super.call("set_occluder_light_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
