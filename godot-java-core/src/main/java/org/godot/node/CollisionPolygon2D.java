package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CollisionPolygon2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_build_mode", 3044948800L), java.util.Map.entry("set_build_mode", 2780803135L),
			java.util.Map.entry("set_one_way_collision", 2586408642L), java.util.Map.entry("set_disabled", 2586408642L),
			java.util.Map.entry("set_one_way_collision_margin", 373806689L),
			java.util.Map.entry("get_one_way_collision_margin", 1740695150L),
			java.util.Map.entry("is_disabled", 36873697L), java.util.Map.entry("set_polygon", 1509147220L),
			java.util.Map.entry("get_polygon", 2961356807L),
			java.util.Map.entry("is_one_way_collision_enabled", 36873697L));

	CollisionPolygon2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CollisionPolygon2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_disabled() {
		return (boolean) super.call("is_disabled");
	}

	public boolean is_one_way_collision_enabled() {
		return (boolean) super.call("is_one_way_collision_enabled");
	}

	public long getBuild_mode() {
		return (long) super.call("get_build_mode", new java.lang.Object[0]);
	}

	public void setBuild_mode(long value) {
		super.call("set_build_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double[][] getPolygon() {
		return (double[][]) super.call("get_polygon", new java.lang.Object[0]);
	}

	public void setPolygon(double[][] value) {
		super.call("set_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isDisabled() {
		return (boolean) super.call("is_disabled", new java.lang.Object[0]);
	}

	public void setDisabled(boolean value) {
		super.call("set_disabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isOne_way_collision() {
		return (boolean) super.call("is_one_way_collision_enabled", new java.lang.Object[0]);
	}

	public void setOne_way_collision(boolean value) {
		super.call("set_one_way_collision", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getOne_way_collision_margin() {
		return (double) super.call("get_one_way_collision_margin", new java.lang.Object[0]);
	}

	public void setOne_way_collision_margin(double value) {
		super.call("set_one_way_collision_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
