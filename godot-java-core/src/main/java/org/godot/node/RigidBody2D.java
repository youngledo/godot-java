package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class RigidBody2D extends PhysicsBody2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_constant_force", 3341600327L),
			java.util.Map.entry("get_center_of_mass", 3341600327L),
			java.util.Map.entry("add_constant_force", 4288681949L), java.util.Map.entry("is_freeze_enabled", 36873697L),
			java.util.Map.entry("set_gravity_scale", 373806689L),
			java.util.Map.entry("set_contact_monitor", 2586408642L),
			java.util.Map.entry("set_angular_damp_mode", 3406533708L),
			java.util.Map.entry("apply_central_impulse", 3862383994L),
			java.util.Map.entry("get_gravity_scale", 1740695150L),
			java.util.Map.entry("set_physics_material_override", 1784508650L),
			java.util.Map.entry("set_angular_damp", 373806689L), java.util.Map.entry("get_angular_damp", 1740695150L),
			java.util.Map.entry("set_lock_rotation_enabled", 2586408642L),
			java.util.Map.entry("apply_force", 4288681949L), java.util.Map.entry("set_can_sleep", 2586408642L),
			java.util.Map.entry("get_inertia", 1740695150L),
			java.util.Map.entry("set_center_of_mass_mode", 1757235706L),
			java.util.Map.entry("is_contact_monitor_enabled", 36873697L),
			java.util.Map.entry("set_freeze_enabled", 2586408642L), java.util.Map.entry("is_able_to_sleep", 36873697L),
			java.util.Map.entry("is_lock_rotation_enabled", 36873697L),
			java.util.Map.entry("apply_torque_impulse", 373806689L), java.util.Map.entry("is_sleeping", 36873697L),
			java.util.Map.entry("set_linear_damp", 373806689L), java.util.Map.entry("apply_impulse", 4288681949L),
			java.util.Map.entry("set_center_of_mass", 743155724L),
			java.util.Map.entry("set_constant_torque", 373806689L),
			java.util.Map.entry("get_max_contacts_reported", 3905245786L),
			java.util.Map.entry("get_linear_damp", 1740695150L), java.util.Map.entry("set_linear_velocity", 743155724L),
			java.util.Map.entry("get_linear_velocity", 3341600327L),
			java.util.Map.entry("get_linear_damp_mode", 2970511462L),
			java.util.Map.entry("add_constant_torque", 373806689L),
			java.util.Map.entry("set_linear_damp_mode", 3406533708L),
			java.util.Map.entry("get_freeze_mode", 2016872314L),
			java.util.Map.entry("get_center_of_mass_mode", 3277132817L),
			java.util.Map.entry("is_using_custom_integrator", 2240911060L),
			java.util.Map.entry("set_constant_force", 743155724L),
			java.util.Map.entry("get_physics_material_override", 2521850424L),
			java.util.Map.entry("get_angular_damp_mode", 2970511462L),
			java.util.Map.entry("set_freeze_mode", 1705112154L),
			java.util.Map.entry("set_use_custom_integrator", 2586408642L),
			java.util.Map.entry("set_continuous_collision_detection_mode", 1000241384L),
			java.util.Map.entry("get_colliding_bodies", 3995934104L), java.util.Map.entry("set_mass", 373806689L),
			java.util.Map.entry("set_inertia", 373806689L), java.util.Map.entry("get_angular_velocity", 1740695150L),
			java.util.Map.entry("get_constant_torque", 1740695150L),
			java.util.Map.entry("get_contact_count", 3905245786L), java.util.Map.entry("set_sleeping", 2586408642L),
			java.util.Map.entry("get_mass", 1740695150L), java.util.Map.entry("set_angular_velocity", 373806689L),
			java.util.Map.entry("apply_central_force", 743155724L),
			java.util.Map.entry("set_axis_velocity", 743155724L),
			java.util.Map.entry("get_continuous_collision_detection_mode", 815214376L),
			java.util.Map.entry("add_constant_central_force", 743155724L),
			java.util.Map.entry("set_max_contacts_reported", 1286410249L),
			java.util.Map.entry("apply_torque", 373806689L));

	RigidBody2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RigidBody2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_custom_integrator() {
		return (boolean) super.call("is_using_custom_integrator");
	}

	public boolean is_contact_monitor_enabled() {
		return (boolean) super.call("is_contact_monitor_enabled");
	}

	public void apply_central_impulse(Vector2 impulse) {
		super.call("apply_central_impulse", new java.lang.Object[]{(java.lang.Object) impulse});
	}

	public void apply_impulse(Vector2 impulse, Vector2 position) {
		super.call("apply_impulse", new java.lang.Object[]{(java.lang.Object) impulse, (java.lang.Object) position});
	}

	public void apply_torque_impulse(double torque) {
		super.call("apply_torque_impulse", new java.lang.Object[]{java.lang.Double.valueOf(torque)});
	}

	public void apply_central_force(Vector2 force) {
		super.call("apply_central_force", new java.lang.Object[]{(java.lang.Object) force});
	}

	public void apply_force(Vector2 force, Vector2 position) {
		super.call("apply_force", new java.lang.Object[]{(java.lang.Object) force, (java.lang.Object) position});
	}

	public void apply_torque(double torque) {
		super.call("apply_torque", new java.lang.Object[]{java.lang.Double.valueOf(torque)});
	}

	public void add_constant_central_force(Vector2 force) {
		super.call("add_constant_central_force", new java.lang.Object[]{(java.lang.Object) force});
	}

	public void add_constant_force(Vector2 force, Vector2 position) {
		super.call("add_constant_force", new java.lang.Object[]{(java.lang.Object) force, (java.lang.Object) position});
	}

	public void add_constant_torque(double torque) {
		super.call("add_constant_torque", new java.lang.Object[]{java.lang.Double.valueOf(torque)});
	}

	public boolean is_sleeping() {
		return (boolean) super.call("is_sleeping");
	}

	public boolean is_able_to_sleep() {
		return (boolean) super.call("is_able_to_sleep");
	}

	public boolean is_lock_rotation_enabled() {
		return (boolean) super.call("is_lock_rotation_enabled");
	}

	public boolean is_freeze_enabled() {
		return (boolean) super.call("is_freeze_enabled");
	}

	public double getMass() {
		return (double) super.call("get_mass", new java.lang.Object[0]);
	}

	public void setMass(double value) {
		super.call("set_mass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public PhysicsMaterial getPhysics_material_override() {
		return (PhysicsMaterial) super.call("get_physics_material_override", new java.lang.Object[0]);
	}

	public void setPhysics_material_override(PhysicsMaterial value) {
		super.call("set_physics_material_override", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getGravity_scale() {
		return (double) super.call("get_gravity_scale", new java.lang.Object[0]);
	}

	public void setGravity_scale(double value) {
		super.call("set_gravity_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getCenter_of_mass_mode() {
		return (long) super.call("get_center_of_mass_mode", new java.lang.Object[0]);
	}

	public void setCenter_of_mass_mode(long value) {
		super.call("set_center_of_mass_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getCenter_of_mass() {
		return (Vector2) super.call("get_center_of_mass", new java.lang.Object[0]);
	}

	public void setCenter_of_mass(Vector2 value) {
		super.call("set_center_of_mass", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getInertia() {
		return (double) super.call("get_inertia", new java.lang.Object[0]);
	}

	public void setInertia(double value) {
		super.call("set_inertia", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isSleeping() {
		return (boolean) super.call("is_sleeping", new java.lang.Object[0]);
	}

	public void setSleeping(boolean value) {
		super.call("set_sleeping", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCan_sleep() {
		return (boolean) super.call("is_able_to_sleep", new java.lang.Object[0]);
	}

	public void setCan_sleep(boolean value) {
		super.call("set_can_sleep", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isLock_rotation() {
		return (boolean) super.call("is_lock_rotation_enabled", new java.lang.Object[0]);
	}

	public void setLock_rotation(boolean value) {
		super.call("set_lock_rotation_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFreeze() {
		return (boolean) super.call("is_freeze_enabled", new java.lang.Object[0]);
	}

	public void setFreeze(boolean value) {
		super.call("set_freeze_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getFreeze_mode() {
		return (long) super.call("get_freeze_mode", new java.lang.Object[0]);
	}

	public void setFreeze_mode(long value) {
		super.call("set_freeze_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isCustom_integrator() {
		return (boolean) super.call("is_using_custom_integrator", new java.lang.Object[0]);
	}

	public void setCustom_integrator(boolean value) {
		super.call("set_use_custom_integrator", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getContinuous_cd() {
		return (long) super.call("get_continuous_collision_detection_mode", new java.lang.Object[0]);
	}

	public void setContinuous_cd(long value) {
		super.call("set_continuous_collision_detection_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isContact_monitor() {
		return (boolean) super.call("is_contact_monitor_enabled", new java.lang.Object[0]);
	}

	public void setContact_monitor(boolean value) {
		super.call("set_contact_monitor", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMax_contacts_reported() {
		return (long) super.call("get_max_contacts_reported", new java.lang.Object[0]);
	}

	public void setMax_contacts_reported(long value) {
		super.call("set_max_contacts_reported", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getLinear_velocity() {
		return (Vector2) super.call("get_linear_velocity", new java.lang.Object[0]);
	}

	public void setLinear_velocity(Vector2 value) {
		super.call("set_linear_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLinear_damp_mode() {
		return (long) super.call("get_linear_damp_mode", new java.lang.Object[0]);
	}

	public void setLinear_damp_mode(long value) {
		super.call("set_linear_damp_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getLinear_damp() {
		return (double) super.call("get_linear_damp", new java.lang.Object[0]);
	}

	public void setLinear_damp(double value) {
		super.call("set_linear_damp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAngular_velocity() {
		return (double) super.call("get_angular_velocity", new java.lang.Object[0]);
	}

	public void setAngular_velocity(double value) {
		super.call("set_angular_velocity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAngular_damp_mode() {
		return (long) super.call("get_angular_damp_mode", new java.lang.Object[0]);
	}

	public void setAngular_damp_mode(long value) {
		super.call("set_angular_damp_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getAngular_damp() {
		return (double) super.call("get_angular_damp", new java.lang.Object[0]);
	}

	public void setAngular_damp(double value) {
		super.call("set_angular_damp", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getConstant_force() {
		return (Vector2) super.call("get_constant_force", new java.lang.Object[0]);
	}

	public void setConstant_force(Vector2 value) {
		super.call("set_constant_force", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getConstant_torque() {
		return (double) super.call("get_constant_torque", new java.lang.Object[0]);
	}

	public void setConstant_torque(double value) {
		super.call("set_constant_torque", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
