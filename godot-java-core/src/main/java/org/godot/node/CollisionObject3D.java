package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.math.Transform3D;

public class CollisionObject3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_collision_layer", 3905245786L),
			java.util.Map.entry("set_collision_mask_value", 300928843L),
			java.util.Map.entry("shape_owner_clear_shapes", 1286410249L),
			java.util.Map.entry("get_collision_layer_value", 1116898809L),
			java.util.Map.entry("remove_shape_owner", 1286410249L),
			java.util.Map.entry("shape_owner_get_shape", 4015519174L),
			java.util.Map.entry("get_shape_owners", 969006518L),
			java.util.Map.entry("get_capture_input_on_drag", 36873697L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("is_shape_owner_disabled", 1116898809L),
			java.util.Map.entry("set_collision_layer_value", 300928843L),
			java.util.Map.entry("shape_owner_set_disabled", 300928843L),
			java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("shape_owner_get_shape_index", 3175239445L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("get_collision_priority", 1740695150L),
			java.util.Map.entry("set_ray_pickable", 2586408642L),
			java.util.Map.entry("shape_owner_get_transform", 1965739696L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("set_collision_layer", 1286410249L),
			java.util.Map.entry("shape_owner_add_shape", 2566676345L),
			java.util.Map.entry("set_collision_priority", 373806689L),
			java.util.Map.entry("is_ray_pickable", 36873697L), java.util.Map.entry("create_shape_owner", 3429307534L),
			java.util.Map.entry("shape_owner_remove_shape", 3937882851L),
			java.util.Map.entry("shape_owner_get_owner", 3332903315L),
			java.util.Map.entry("shape_owner_get_shape_count", 923996154L),
			java.util.Map.entry("set_disable_mode", 1623620376L), java.util.Map.entry("get_disable_mode", 410164780L),
			java.util.Map.entry("shape_find_owner", 923996154L),
			java.util.Map.entry("set_capture_input_on_drag", 2586408642L),
			java.util.Map.entry("shape_owner_set_transform", 3616898986L));

	CollisionObject3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CollisionObject3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_collision_layer_value(long layer_number, boolean value) {
		super.call("set_collision_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_layer_value(long layer_number) {
		return (boolean) super.call("get_collision_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void set_collision_mask_value(long layer_number, boolean value) {
		super.call("set_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_mask_value(long layer_number) {
		return (boolean) super.call("get_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public boolean is_ray_pickable() {
		return (boolean) super.call("is_ray_pickable");
	}

	public long create_shape_owner(GodotObject owner) {
		return (long) super.call("create_shape_owner", new java.lang.Object[]{(java.lang.Object) owner});
	}

	public void remove_shape_owner(long owner_id) {
		super.call("remove_shape_owner", new java.lang.Object[]{java.lang.Long.valueOf(owner_id)});
	}

	public void shape_owner_set_transform(long owner_id, Transform3D transform) {
		super.call("shape_owner_set_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id), (java.lang.Object) transform});
	}

	public Transform3D shape_owner_get_transform(long owner_id) {
		return (Transform3D) super.call("shape_owner_get_transform",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id)});
	}

	public GodotObject shape_owner_get_owner(long owner_id) {
		return (GodotObject) super.call("shape_owner_get_owner",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id)});
	}

	public void shape_owner_set_disabled(long owner_id, boolean disabled) {
		super.call("shape_owner_set_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id), java.lang.Boolean.valueOf(disabled)});
	}

	public boolean is_shape_owner_disabled(long owner_id) {
		return (boolean) super.call("is_shape_owner_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id)});
	}

	public void shape_owner_add_shape(long owner_id, Shape3D shape) {
		super.call("shape_owner_add_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id), (java.lang.Object) shape});
	}

	public int shape_owner_get_shape_count(long owner_id) {
		return (int) super.call("shape_owner_get_shape_count",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id)});
	}

	public Shape3D shape_owner_get_shape(long owner_id, long shape_id) {
		return (Shape3D) super.call("shape_owner_get_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id), java.lang.Long.valueOf(shape_id)});
	}

	public int shape_owner_get_shape_index(long owner_id, long shape_id) {
		return (int) super.call("shape_owner_get_shape_index",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id), java.lang.Long.valueOf(shape_id)});
	}

	public void shape_owner_remove_shape(long owner_id, long shape_id) {
		super.call("shape_owner_remove_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(owner_id), java.lang.Long.valueOf(shape_id)});
	}

	public void shape_owner_clear_shapes(long owner_id) {
		super.call("shape_owner_clear_shapes", new java.lang.Object[]{java.lang.Long.valueOf(owner_id)});
	}

	public long shape_find_owner(long shape_index) {
		return (long) super.call("shape_find_owner", new java.lang.Object[]{java.lang.Long.valueOf(shape_index)});
	}

	public long getDisable_mode() {
		return (long) super.call("get_disable_mode", new java.lang.Object[0]);
	}

	public void setDisable_mode(long value) {
		super.call("set_disable_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCollision_layer() {
		return (long) super.call("get_collision_layer", new java.lang.Object[0]);
	}

	public void setCollision_layer(long value) {
		super.call("set_collision_layer", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCollision_mask() {
		return (long) super.call("get_collision_mask", new java.lang.Object[0]);
	}

	public void setCollision_mask(long value) {
		super.call("set_collision_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getCollision_priority() {
		return (double) super.call("get_collision_priority", new java.lang.Object[0]);
	}

	public void setCollision_priority(double value) {
		super.call("set_collision_priority", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isInput_ray_pickable() {
		return (boolean) super.call("is_ray_pickable", new java.lang.Object[0]);
	}

	public void setInput_ray_pickable(boolean value) {
		super.call("set_ray_pickable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getInput_capture_on_drag() {
		return (boolean) super.call("get_capture_input_on_drag", new java.lang.Object[0]);
	}

	public void setInput_capture_on_drag(boolean value) {
		super.call("set_capture_input_on_drag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
