package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector3;

public class RayCast3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_exception", 1976431078L),
			java.util.Map.entry("set_collision_mask_value", 300928843L),
			java.util.Map.entry("get_collision_point", 3360562783L),
			java.util.Map.entry("get_debug_shape_custom_color", 3444240500L),
			java.util.Map.entry("get_collider_shape", 3905245786L),
			java.util.Map.entry("set_target_position", 3460891852L), java.util.Map.entry("get_collider", 1981248198L),
			java.util.Map.entry("is_hit_from_inside_enabled", 36873697L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("set_hit_back_faces", 2586408642L), java.util.Map.entry("is_enabled", 36873697L),
			java.util.Map.entry("is_collide_with_areas_enabled", 36873697L),
			java.util.Map.entry("is_collide_with_bodies_enabled", 36873697L),
			java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("set_exclude_parent_body", 2586408642L),
			java.util.Map.entry("set_debug_shape_thickness", 1286410249L),
			java.util.Map.entry("get_debug_shape_thickness", 3905245786L),
			java.util.Map.entry("get_target_position", 3360562783L),
			java.util.Map.entry("set_collide_with_areas", 2586408642L),
			java.util.Map.entry("set_collide_with_bodies", 2586408642L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("get_exclude_parent_body", 36873697L),
			java.util.Map.entry("get_collider_rid", 2944877500L), java.util.Map.entry("remove_exception", 1976431078L),
			java.util.Map.entry("set_debug_shape_custom_color", 2920490490L),
			java.util.Map.entry("get_collision_normal", 3360562783L),
			java.util.Map.entry("force_raycast_update", 3218959716L),
			java.util.Map.entry("get_collision_face_index", 3905245786L),
			java.util.Map.entry("is_colliding", 36873697L), java.util.Map.entry("set_hit_from_inside", 2586408642L),
			java.util.Map.entry("set_enabled", 2586408642L), java.util.Map.entry("remove_exception_rid", 2722037293L),
			java.util.Map.entry("clear_exceptions", 3218959716L), java.util.Map.entry("add_exception_rid", 2722037293L),
			java.util.Map.entry("is_hit_back_faces_enabled", 36873697L));

	RayCast3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RayCast3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public boolean is_colliding() {
		return (boolean) super.call("is_colliding");
	}

	public void force_raycast_update() {
		super.call("force_raycast_update");
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

	public boolean is_hit_from_inside_enabled() {
		return (boolean) super.call("is_hit_from_inside_enabled");
	}

	public boolean is_hit_back_faces_enabled() {
		return (boolean) super.call("is_hit_back_faces_enabled");
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isHit_from_inside() {
		return (boolean) super.call("is_hit_from_inside_enabled", new java.lang.Object[0]);
	}

	public void setHit_from_inside(boolean value) {
		super.call("set_hit_from_inside", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHit_back_faces() {
		return (boolean) super.call("is_hit_back_faces_enabled", new java.lang.Object[0]);
	}

	public void setHit_back_faces(boolean value) {
		super.call("set_hit_back_faces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getDebug_shape_thickness() {
		return (long) super.call("get_debug_shape_thickness", new java.lang.Object[0]);
	}

	public void setDebug_shape_thickness(long value) {
		super.call("set_debug_shape_thickness", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
