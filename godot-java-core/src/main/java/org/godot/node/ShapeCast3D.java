package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.collection.GodotArray;
import org.godot.math.Color;
import org.godot.math.Vector3;

public class ShapeCast3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_exception", 1976431078L),
			java.util.Map.entry("set_collision_mask_value", 300928843L),
			java.util.Map.entry("get_closest_collision_unsafe_fraction", 1740695150L),
			java.util.Map.entry("resource_changed", 968641751L), java.util.Map.entry("get_collision_point", 711720468L),
			java.util.Map.entry("get_closest_collision_safe_fraction", 1740695150L),
			java.util.Map.entry("get_debug_shape_custom_color", 3444240500L),
			java.util.Map.entry("get_collider_shape", 923996154L),
			java.util.Map.entry("set_target_position", 3460891852L), java.util.Map.entry("get_collider", 3332903315L),
			java.util.Map.entry("set_shape", 1549710052L), java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("is_enabled", 36873697L), java.util.Map.entry("get_collision_result", 3995934104L),
			java.util.Map.entry("is_collide_with_areas_enabled", 36873697L),
			java.util.Map.entry("is_collide_with_bodies_enabled", 36873697L),
			java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("set_exclude_parent_body", 2586408642L),
			java.util.Map.entry("get_target_position", 3360562783L),
			java.util.Map.entry("set_collide_with_areas", 2586408642L),
			java.util.Map.entry("set_collide_with_bodies", 2586408642L),
			java.util.Map.entry("set_max_results", 1286410249L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("force_shapecast_update", 3218959716L),
			java.util.Map.entry("get_max_results", 3905245786L),
			java.util.Map.entry("get_exclude_parent_body", 36873697L),
			java.util.Map.entry("get_collider_rid", 495598643L), java.util.Map.entry("remove_exception", 1976431078L),
			java.util.Map.entry("get_margin", 1740695150L),
			java.util.Map.entry("set_debug_shape_custom_color", 2920490490L),
			java.util.Map.entry("get_collision_normal", 711720468L), java.util.Map.entry("set_margin", 373806689L),
			java.util.Map.entry("get_shape", 3214262478L), java.util.Map.entry("is_colliding", 36873697L),
			java.util.Map.entry("set_enabled", 2586408642L), java.util.Map.entry("remove_exception_rid", 2722037293L),
			java.util.Map.entry("clear_exceptions", 3218959716L), java.util.Map.entry("add_exception_rid", 2722037293L),
			java.util.Map.entry("get_collision_count", 3905245786L));

	ShapeCast3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ShapeCast3D(long nativePointer) {
		super(nativePointer);
	}

	public void resource_changed(Resource resource) {
		super.call("resource_changed", new java.lang.Object[]{(java.lang.Object) resource});
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public boolean is_colliding() {
		return (boolean) super.call("is_colliding");
	}

	public void force_shapecast_update() {
		super.call("force_shapecast_update");
	}

	public GodotObject get_collider(long index) {
		return (GodotObject) super.call("get_collider", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long get_collider_rid(long index) {
		return (long) super.call("get_collider_rid", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_collider_shape(long index) {
		return (int) super.call("get_collider_shape", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Vector3 get_collision_point(long index) {
		return (Vector3) super.call("get_collision_point", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Vector3 get_collision_normal(long index) {
		return (Vector3) super.call("get_collision_normal", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_exception_rid(long rid) {
		super.call("add_exception_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void add_exception(CollisionObject3D node) {
		super.call("add_exception", new java.lang.Object[]{(java.lang.Object) node});
	}

	public void remove_exception_rid(long rid) {
		super.call("remove_exception_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void remove_exception(CollisionObject3D node) {
		super.call("remove_exception", new java.lang.Object[]{(java.lang.Object) node});
	}

	public void clear_exceptions() {
		super.call("clear_exceptions");
	}

	public void set_collision_mask_value(long layer_number, boolean value) {
		super.call("set_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_mask_value(long layer_number) {
		return (boolean) super.call("get_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public boolean is_collide_with_areas_enabled() {
		return (boolean) super.call("is_collide_with_areas_enabled");
	}

	public boolean is_collide_with_bodies_enabled() {
		return (boolean) super.call("is_collide_with_bodies_enabled");
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Shape3D getShape() {
		return (Shape3D) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(Shape3D value) {
		super.call("set_shape", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getExclude_parent() {
		return (boolean) super.call("get_exclude_parent_body", new java.lang.Object[0]);
	}

	public void setExclude_parent(boolean value) {
		super.call("set_exclude_parent_body", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector3 getTarget_position() {
		return (Vector3) super.call("get_target_position", new java.lang.Object[0]);
	}

	public void setTarget_position(Vector3 value) {
		super.call("set_target_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMargin() {
		return (double) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(double value) {
		super.call("set_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_results() {
		return (long) super.call("get_max_results", new java.lang.Object[0]);
	}

	public void setMax_results(long value) {
		super.call("set_max_results", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotArray getCollision_result() {
		return (GodotArray) super.call("get_collision_result", new java.lang.Object[0]);
	}

	public void setCollision_result(GodotArray value) {
		super.call("set_collision_result", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCollide_with_areas() {
		return (boolean) super.call("is_collide_with_areas_enabled", new java.lang.Object[0]);
	}

	public void setCollide_with_areas(boolean value) {
		super.call("set_collide_with_areas", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCollide_with_bodies() {
		return (boolean) super.call("is_collide_with_bodies_enabled", new java.lang.Object[0]);
	}

	public void setCollide_with_bodies(boolean value) {
		super.call("set_collide_with_bodies", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getDebug_shape_custom_color() {
		return (Color) super.call("get_debug_shape_custom_color", new java.lang.Object[0]);
	}

	public void setDebug_shape_custom_color(Color value) {
		super.call("set_debug_shape_custom_color", new java.lang.Object[]{(java.lang.Object) value});
	}
}
