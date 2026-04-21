package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.math.Basis;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class PhysicsDirectBodyState3D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant_force", 3360562783L), java.util.Map.entry("set_sleep_state", 2586408642L),
			java.util.Map.entry("get_collision_layer", 3905245786L),
			java.util.Map.entry("get_center_of_mass", 3360562783L),
			java.util.Map.entry("get_principal_inertia_axes", 2716978435L),
			java.util.Map.entry("get_velocity_at_local_position", 192990374L),
			java.util.Map.entry("add_constant_force", 2754756483L),
			java.util.Map.entry("get_contact_collider", 495598643L),
			java.util.Map.entry("get_total_gravity", 3360562783L),
			java.util.Map.entry("get_contact_local_position", 711720468L),
			java.util.Map.entry("get_inverse_inertia", 3360562783L),
			java.util.Map.entry("get_contact_local_normal", 711720468L),
			java.util.Map.entry("apply_central_impulse", 2007698547L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("get_contact_impulse", 711720468L), java.util.Map.entry("apply_force", 2754756483L),
			java.util.Map.entry("get_contact_collider_shape", 923996154L),
			java.util.Map.entry("get_contact_local_shape", 923996154L),
			java.util.Map.entry("integrate_forces", 3218959716L), java.util.Map.entry("get_transform", 3229777777L),
			java.util.Map.entry("set_collision_layer", 1286410249L),
			java.util.Map.entry("get_contact_collider_position", 711720468L),
			java.util.Map.entry("apply_torque_impulse", 3460891852L),
			java.util.Map.entry("get_total_linear_damp", 1740695150L),
			java.util.Map.entry("get_center_of_mass_local", 3360562783L), java.util.Map.entry("is_sleeping", 36873697L),
			java.util.Map.entry("get_inverse_inertia_tensor", 2716978435L),
			java.util.Map.entry("get_total_angular_damp", 1740695150L),
			java.util.Map.entry("get_inverse_mass", 1740695150L), java.util.Map.entry("apply_impulse", 2754756483L),
			java.util.Map.entry("get_contact_local_velocity_at_position", 711720468L),
			java.util.Map.entry("get_contact_collider_id", 923996154L),
			java.util.Map.entry("get_contact_collider_velocity_at_position", 711720468L),
			java.util.Map.entry("set_constant_torque", 3460891852L), java.util.Map.entry("get_step", 1740695150L),
			java.util.Map.entry("set_linear_velocity", 3460891852L),
			java.util.Map.entry("get_linear_velocity", 3360562783L),
			java.util.Map.entry("add_constant_torque", 3460891852L), java.util.Map.entry("set_transform", 2952846383L),
			java.util.Map.entry("get_space_state", 2069328350L), java.util.Map.entry("set_constant_force", 3460891852L),
			java.util.Map.entry("get_contact_collider_object", 3332903315L),
			java.util.Map.entry("get_angular_velocity", 3360562783L),
			java.util.Map.entry("get_constant_torque", 3360562783L),
			java.util.Map.entry("get_contact_count", 3905245786L),
			java.util.Map.entry("set_angular_velocity", 3460891852L),
			java.util.Map.entry("apply_central_force", 2007698547L),
			java.util.Map.entry("add_constant_central_force", 2007698547L),
			java.util.Map.entry("apply_torque", 3460891852L));

	PhysicsDirectBodyState3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsDirectBodyState3D(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 get_velocity_at_local_position(Vector3 local_position) {
		return (Vector3) super.call("get_velocity_at_local_position",
				new java.lang.Object[]{(java.lang.Object) local_position});
	}

	public void apply_central_impulse(Vector3 impulse) {
		super.call("apply_central_impulse", new java.lang.Object[]{(java.lang.Object) impulse});
	}

	public void apply_impulse(Vector3 impulse, Vector3 position) {
		super.call("apply_impulse", new java.lang.Object[]{(java.lang.Object) impulse, (java.lang.Object) position});
	}

	public void apply_torque_impulse(Vector3 impulse) {
		super.call("apply_torque_impulse", new java.lang.Object[]{(java.lang.Object) impulse});
	}

	public void apply_central_force(Vector3 force) {
		super.call("apply_central_force", new java.lang.Object[]{(java.lang.Object) force});
	}

	public void apply_force(Vector3 force, Vector3 position) {
		super.call("apply_force", new java.lang.Object[]{(java.lang.Object) force, (java.lang.Object) position});
	}

	public void apply_torque(Vector3 torque) {
		super.call("apply_torque", new java.lang.Object[]{(java.lang.Object) torque});
	}

	public void add_constant_central_force(Vector3 force) {
		super.call("add_constant_central_force", new java.lang.Object[]{(java.lang.Object) force});
	}

	public void add_constant_force(Vector3 force, Vector3 position) {
		super.call("add_constant_force", new java.lang.Object[]{(java.lang.Object) force, (java.lang.Object) position});
	}

	public void add_constant_torque(Vector3 torque) {
		super.call("add_constant_torque", new java.lang.Object[]{(java.lang.Object) torque});
	}

	public boolean is_sleeping() {
		return (boolean) super.call("is_sleeping");
	}

	public Vector3 get_contact_local_position(long contact_idx) {
		return (Vector3) super.call("get_contact_local_position",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public Vector3 get_contact_local_normal(long contact_idx) {
		return (Vector3) super.call("get_contact_local_normal",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public Vector3 get_contact_impulse(long contact_idx) {
		return (Vector3) super.call("get_contact_impulse", new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public int get_contact_local_shape(long contact_idx) {
		return (int) super.call("get_contact_local_shape", new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public Vector3 get_contact_local_velocity_at_position(long contact_idx) {
		return (Vector3) super.call("get_contact_local_velocity_at_position",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public long get_contact_collider(long contact_idx) {
		return (long) super.call("get_contact_collider", new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public Vector3 get_contact_collider_position(long contact_idx) {
		return (Vector3) super.call("get_contact_collider_position",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public java.math.BigInteger get_contact_collider_id(long contact_idx) {
		return (java.math.BigInteger) super.call("get_contact_collider_id",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public GodotObject get_contact_collider_object(long contact_idx) {
		return (GodotObject) super.call("get_contact_collider_object",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public int get_contact_collider_shape(long contact_idx) {
		return (int) super.call("get_contact_collider_shape",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public Vector3 get_contact_collider_velocity_at_position(long contact_idx) {
		return (Vector3) super.call("get_contact_collider_velocity_at_position",
				new java.lang.Object[]{java.lang.Long.valueOf(contact_idx)});
	}

	public void integrate_forces() {
		super.call("integrate_forces");
	}

	public double getStep() {
		return (double) super.call("get_step", new java.lang.Object[0]);
	}

	public void setStep(double value) {
		super.call("set_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getInverse_mass() {
		return (double) super.call("get_inverse_mass", new java.lang.Object[0]);
	}

	public void setInverse_mass(double value) {
		super.call("set_inverse_mass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTotal_angular_damp() {
		return (double) super.call("get_total_angular_damp", new java.lang.Object[0]);
	}

	public void setTotal_angular_damp(double value) {
		super.call("set_total_angular_damp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTotal_linear_damp() {
		return (double) super.call("get_total_linear_damp", new java.lang.Object[0]);
	}

	public void setTotal_linear_damp(double value) {
		super.call("set_total_linear_damp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector3 getInverse_inertia() {
		return (Vector3) super.call("get_inverse_inertia", new java.lang.Object[0]);
	}

	public void setInverse_inertia(Vector3 value) {
		super.call("set_inverse_inertia", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Basis getInverse_inertia_tensor() {
		return (Basis) super.call("get_inverse_inertia_tensor", new java.lang.Object[0]);
	}

	public void setInverse_inertia_tensor(Basis value) {
		super.call("set_inverse_inertia_tensor", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getTotal_gravity() {
		return (Vector3) super.call("get_total_gravity", new java.lang.Object[0]);
	}

	public void setTotal_gravity(Vector3 value) {
		super.call("set_total_gravity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getCenter_of_mass() {
		return (Vector3) super.call("get_center_of_mass", new java.lang.Object[0]);
	}

	public void setCenter_of_mass(Vector3 value) {
		super.call("set_center_of_mass", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getCenter_of_mass_local() {
		return (Vector3) super.call("get_center_of_mass_local", new java.lang.Object[0]);
	}

	public void setCenter_of_mass_local(Vector3 value) {
		super.call("set_center_of_mass_local", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Basis getPrincipal_inertia_axes() {
		return (Basis) super.call("get_principal_inertia_axes", new java.lang.Object[0]);
	}

	public void setPrincipal_inertia_axes(Basis value) {
		super.call("set_principal_inertia_axes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getAngular_velocity() {
		return (Vector3) super.call("get_angular_velocity", new java.lang.Object[0]);
	}

	public void setAngular_velocity(Vector3 value) {
		super.call("set_angular_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getLinear_velocity() {
		return (Vector3) super.call("get_linear_velocity", new java.lang.Object[0]);
	}

	public void setLinear_velocity(Vector3 value) {
		super.call("set_linear_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isSleeping() {
		return (boolean) super.call("is_sleeping", new java.lang.Object[0]);
	}

	public void setSleeping(boolean value) {
		super.call("set_sleep_state", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public Transform3D getTransform() {
		return (Transform3D) super.call("get_transform", new java.lang.Object[0]);
	}

	public void setTransform(Transform3D value) {
		super.call("set_transform", new java.lang.Object[]{(java.lang.Object) value});
	}
}
