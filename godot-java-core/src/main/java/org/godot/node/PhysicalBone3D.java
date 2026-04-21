package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class PhysicalBone3D extends PhysicsBody3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_joint_offset", 2952846383L), java.util.Map.entry("get_bounce", 1740695150L),
			java.util.Map.entry("set_bounce", 373806689L), java.util.Map.entry("set_gravity_scale", 373806689L),
			java.util.Map.entry("get_linear_damp", 1740695150L),
			java.util.Map.entry("apply_central_impulse", 3460891852L),
			java.util.Map.entry("set_joint_rotation", 3460891852L),
			java.util.Map.entry("set_angular_damp_mode", 1244972221L),
			java.util.Map.entry("get_gravity_scale", 1740695150L),
			java.util.Map.entry("set_linear_velocity", 3460891852L),
			java.util.Map.entry("set_angular_damp", 373806689L), java.util.Map.entry("get_angular_damp", 1740695150L),
			java.util.Map.entry("get_joint_type", 931347320L), java.util.Map.entry("get_bone_id", 3905245786L),
			java.util.Map.entry("get_linear_velocity", 3360562783L),
			java.util.Map.entry("get_linear_damp_mode", 205884699L),
			java.util.Map.entry("set_linear_damp_mode", 1244972221L),
			java.util.Map.entry("get_joint_rotation", 3360562783L), java.util.Map.entry("set_body_offset", 2952846383L),
			java.util.Map.entry("is_simulating_physics", 2240911060L),
			java.util.Map.entry("is_using_custom_integrator", 2240911060L),
			java.util.Map.entry("get_simulate_physics", 2240911060L), java.util.Map.entry("set_can_sleep", 2586408642L),
			java.util.Map.entry("get_angular_damp_mode", 205884699L),
			java.util.Map.entry("set_use_custom_integrator", 2586408642L), java.util.Map.entry("set_mass", 373806689L),
			java.util.Map.entry("get_body_offset", 3229777777L),
			java.util.Map.entry("get_angular_velocity", 3360562783L),
			java.util.Map.entry("is_able_to_sleep", 36873697L), java.util.Map.entry("get_mass", 1740695150L),
			java.util.Map.entry("set_angular_velocity", 3460891852L), java.util.Map.entry("get_friction", 1740695150L),
			java.util.Map.entry("set_linear_damp", 373806689L), java.util.Map.entry("apply_impulse", 2754756483L),
			java.util.Map.entry("set_joint_type", 2289552604L), java.util.Map.entry("get_joint_offset", 3229777777L),
			java.util.Map.entry("set_friction", 373806689L));

	PhysicalBone3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicalBone3D(long nativePointer) {
		super(nativePointer);
	}

	public void apply_central_impulse(Vector3 impulse) {
		super.call("apply_central_impulse", new java.lang.Object[]{(java.lang.Object) impulse});
	}

	public void apply_impulse(Vector3 impulse, Vector3 position) {
		super.call("apply_impulse", new java.lang.Object[]{(java.lang.Object) impulse, (java.lang.Object) position});
	}

	public boolean is_simulating_physics() {
		return (boolean) super.call("is_simulating_physics");
	}

	public boolean is_using_custom_integrator() {
		return (boolean) super.call("is_using_custom_integrator");
	}

	public boolean is_able_to_sleep() {
		return (boolean) super.call("is_able_to_sleep");
	}

	public long getJoint_type() {
		return (long) super.call("get_joint_type", new java.lang.Object[0]);
	}

	public void setJoint_type(long value) {
		super.call("set_joint_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Transform3D getJoint_offset() {
		return (Transform3D) super.call("get_joint_offset", new java.lang.Object[0]);
	}

	public void setJoint_offset(Transform3D value) {
		super.call("set_joint_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getJoint_rotation() {
		return (Vector3) super.call("get_joint_rotation", new java.lang.Object[0]);
	}

	public void setJoint_rotation(Vector3 value) {
		super.call("set_joint_rotation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Transform3D getBody_offset() {
		return (Transform3D) super.call("get_body_offset", new java.lang.Object[0]);
	}

	public void setBody_offset(Transform3D value) {
		super.call("set_body_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMass() {
		return (double) super.call("get_mass", new java.lang.Object[0]);
	}

	public void setMass(double value) {
		super.call("set_mass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFriction() {
		return (double) super.call("get_friction", new java.lang.Object[0]);
	}

	public void setFriction(double value) {
		super.call("set_friction", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBounce() {
		return (double) super.call("get_bounce", new java.lang.Object[0]);
	}

	public void setBounce(double value) {
		super.call("set_bounce", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGravity_scale() {
		return (double) super.call("get_gravity_scale", new java.lang.Object[0]);
	}

	public void setGravity_scale(double value) {
		super.call("set_gravity_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCustom_integrator() {
		return (boolean) super.call("is_using_custom_integrator", new java.lang.Object[0]);
	}

	public void setCustom_integrator(boolean value) {
		super.call("set_use_custom_integrator", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public Vector3 getLinear_velocity() {
		return (Vector3) super.call("get_linear_velocity", new java.lang.Object[0]);
	}

	public void setLinear_velocity(Vector3 value) {
		super.call("set_linear_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getAngular_velocity() {
		return (Vector3) super.call("get_angular_velocity", new java.lang.Object[0]);
	}

	public void setAngular_velocity(Vector3 value) {
		super.call("set_angular_velocity", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCan_sleep() {
		return (boolean) super.call("is_able_to_sleep", new java.lang.Object[0]);
	}

	public void setCan_sleep(boolean value) {
		super.call("set_can_sleep", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
