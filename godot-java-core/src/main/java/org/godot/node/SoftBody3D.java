package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class SoftBody3D extends MeshInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_collision_layer", 3905245786L),
			java.util.Map.entry("set_collision_mask_value", 300928843L),
			java.util.Map.entry("set_parent_collision_ignore", 1348162250L),
			java.util.Map.entry("get_damping_coefficient", 191475506L),
			java.util.Map.entry("get_collision_layer_value", 1116898809L),
			java.util.Map.entry("set_damping_coefficient", 373806689L),
			java.util.Map.entry("get_point_transform", 871989493L),
			java.util.Map.entry("get_parent_collision_ignore", 4075236667L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("apply_central_impulse", 3460891852L),
			java.util.Map.entry("set_pressure_coefficient", 373806689L),
			java.util.Map.entry("get_pressure_coefficient", 191475506L),
			java.util.Map.entry("set_collision_layer_value", 300928843L),
			java.util.Map.entry("get_linear_stiffness", 191475506L),
			java.util.Map.entry("add_collision_exception_with", 1078189570L),
			java.util.Map.entry("set_collision_mask", 1286410249L), java.util.Map.entry("set_point_pinned", 528784402L),
			java.util.Map.entry("get_drag_coefficient", 191475506L),
			java.util.Map.entry("set_shrinking_factor", 373806689L),
			java.util.Map.entry("get_simulation_precision", 2455072627L),
			java.util.Map.entry("set_drag_coefficient", 373806689L),
			java.util.Map.entry("get_collision_mask_value", 1116898809L),
			java.util.Map.entry("apply_force", 1530502735L),
			java.util.Map.entry("remove_collision_exception_with", 1078189570L),
			java.util.Map.entry("get_total_mass", 191475506L), java.util.Map.entry("set_ray_pickable", 2586408642L),
			java.util.Map.entry("set_simulation_precision", 1286410249L),
			java.util.Map.entry("is_point_pinned", 1116898809L),
			java.util.Map.entry("get_shrinking_factor", 191475506L), java.util.Map.entry("set_total_mass", 373806689L),
			java.util.Map.entry("set_collision_layer", 1286410249L),
			java.util.Map.entry("set_linear_stiffness", 373806689L), java.util.Map.entry("is_ray_pickable", 36873697L),
			java.util.Map.entry("apply_central_force", 3460891852L),
			java.util.Map.entry("set_disable_mode", 1104158384L),
			java.util.Map.entry("get_collision_exceptions", 2915620761L),
			java.util.Map.entry("get_physics_rid", 2944877500L), java.util.Map.entry("get_disable_mode", 4135042476L),
			java.util.Map.entry("apply_impulse", 1530502735L));

	SoftBody3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SoftBody3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_collision_mask_value(long layer_number, boolean value) {
		super.call("set_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_mask_value(long layer_number) {
		return (boolean) super.call("get_collision_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void set_collision_layer_value(long layer_number, boolean value) {
		super.call("set_collision_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_collision_layer_value(long layer_number) {
		return (boolean) super.call("get_collision_layer_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public void add_collision_exception_with(Node body) {
		super.call("add_collision_exception_with", new java.lang.Object[]{(java.lang.Object) body});
	}

	public void remove_collision_exception_with(Node body) {
		super.call("remove_collision_exception_with", new java.lang.Object[]{(java.lang.Object) body});
	}

	public Vector3 get_point_transform(long point_index) {
		return (Vector3) super.call("get_point_transform", new java.lang.Object[]{java.lang.Long.valueOf(point_index)});
	}

	public void apply_impulse(long point_index, Vector3 impulse) {
		super.call("apply_impulse",
				new java.lang.Object[]{java.lang.Long.valueOf(point_index), (java.lang.Object) impulse});
	}

	public void apply_force(long point_index, Vector3 force) {
		super.call("apply_force",
				new java.lang.Object[]{java.lang.Long.valueOf(point_index), (java.lang.Object) force});
	}

	public void apply_central_impulse(Vector3 impulse) {
		super.call("apply_central_impulse", new java.lang.Object[]{(java.lang.Object) impulse});
	}

	public void apply_central_force(Vector3 force) {
		super.call("apply_central_force", new java.lang.Object[]{(java.lang.Object) force});
	}

	public void set_point_pinned(long point_index, boolean pinned, String attachment_path, long insert_at) {
		super.call("set_point_pinned",
				new java.lang.Object[]{java.lang.Long.valueOf(point_index), java.lang.Boolean.valueOf(pinned),
						(java.lang.Object) attachment_path, java.lang.Long.valueOf(insert_at)});
	}

	public boolean is_point_pinned(long point_index) {
		return (boolean) super.call("is_point_pinned", new java.lang.Object[]{java.lang.Long.valueOf(point_index)});
	}

	public boolean is_ray_pickable() {
		return (boolean) super.call("is_ray_pickable");
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

	public String getParent_collision_ignore() {
		return (String) super.call("get_parent_collision_ignore", new java.lang.Object[0]);
	}

	public void setParent_collision_ignore(String value) {
		super.call("set_parent_collision_ignore", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSimulation_precision() {
		return (long) super.call("get_simulation_precision", new java.lang.Object[0]);
	}

	public void setSimulation_precision(long value) {
		super.call("set_simulation_precision", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getTotal_mass() {
		return (double) super.call("get_total_mass", new java.lang.Object[0]);
	}

	public void setTotal_mass(double value) {
		super.call("set_total_mass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLinear_stiffness() {
		return (double) super.call("get_linear_stiffness", new java.lang.Object[0]);
	}

	public void setLinear_stiffness(double value) {
		super.call("set_linear_stiffness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getShrinking_factor() {
		return (double) super.call("get_shrinking_factor", new java.lang.Object[0]);
	}

	public void setShrinking_factor(double value) {
		super.call("set_shrinking_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPressure_coefficient() {
		return (double) super.call("get_pressure_coefficient", new java.lang.Object[0]);
	}

	public void setPressure_coefficient(double value) {
		super.call("set_pressure_coefficient", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping_coefficient() {
		return (double) super.call("get_damping_coefficient", new java.lang.Object[0]);
	}

	public void setDamping_coefficient(double value) {
		super.call("set_damping_coefficient", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrag_coefficient() {
		return (double) super.call("get_drag_coefficient", new java.lang.Object[0]);
	}

	public void setDrag_coefficient(double value) {
		super.call("set_drag_coefficient", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isRay_pickable() {
		return (boolean) super.call("is_ray_pickable", new java.lang.Object[0]);
	}

	public void setRay_pickable(boolean value) {
		super.call("set_ray_pickable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDisable_mode() {
		return (long) super.call("get_disable_mode", new java.lang.Object[0]);
	}

	public void setDisable_mode(long value) {
		super.call("set_disable_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
