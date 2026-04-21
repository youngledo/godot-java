package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class CollisionShape2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_one_way_collision", 2586408642L), java.util.Map.entry("set_disabled", 2586408642L),
			java.util.Map.entry("set_one_way_collision_margin", 373806689L),
			java.util.Map.entry("get_one_way_collision_margin", 1740695150L),
			java.util.Map.entry("is_disabled", 36873697L), java.util.Map.entry("set_debug_color", 2920490490L),
			java.util.Map.entry("get_debug_color", 3444240500L), java.util.Map.entry("get_shape", 522005891L),
			java.util.Map.entry("set_shape", 771364740L),
			java.util.Map.entry("is_one_way_collision_enabled", 36873697L));

	CollisionShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CollisionShape2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_disabled() {
		return (boolean) super.call("is_disabled");
	}

	public boolean is_one_way_collision_enabled() {
		return (boolean) super.call("is_one_way_collision_enabled");
	}

	public Shape2D getShape() {
		return (Shape2D) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(Shape2D value) {
		super.call("set_shape", new java.lang.Object[]{(java.lang.Object) value});
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

	public Color getDebug_color() {
		return (Color) super.call("get_debug_color", new java.lang.Object[0]);
	}

	public void setDebug_color(Color value) {
		super.call("set_debug_color", new java.lang.Object[]{(java.lang.Object) value});
	}
}
