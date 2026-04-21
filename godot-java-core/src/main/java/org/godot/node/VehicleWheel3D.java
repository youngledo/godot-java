package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VehicleWheel3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_suspension_travel", 373806689L),
			java.util.Map.entry("set_suspension_rest_length", 373806689L),
			java.util.Map.entry("get_steering", 1740695150L),
			java.util.Map.entry("get_damping_relaxation", 1740695150L),
			java.util.Map.entry("set_suspension_stiffness", 373806689L),
			java.util.Map.entry("get_suspension_rest_length", 1740695150L),
			java.util.Map.entry("get_friction_slip", 1740695150L),
			java.util.Map.entry("is_used_as_traction", 36873697L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("get_roll_influence", 1740695150L),
			java.util.Map.entry("get_skidinfo", 1740695150L), java.util.Map.entry("is_in_contact", 36873697L),
			java.util.Map.entry("get_rpm", 1740695150L), java.util.Map.entry("set_use_as_traction", 2586408642L),
			java.util.Map.entry("set_brake", 373806689L), java.util.Map.entry("set_use_as_steering", 2586408642L),
			java.util.Map.entry("get_damping_compression", 1740695150L),
			java.util.Map.entry("set_engine_force", 373806689L),
			java.util.Map.entry("get_suspension_travel", 1740695150L), java.util.Map.entry("set_steering", 373806689L),
			java.util.Map.entry("get_contact_point", 3360562783L),
			java.util.Map.entry("set_damping_compression", 373806689L),
			java.util.Map.entry("get_contact_body", 151077316L),
			java.util.Map.entry("get_suspension_stiffness", 1740695150L),
			java.util.Map.entry("get_engine_force", 1740695150L), java.util.Map.entry("get_brake", 1740695150L),
			java.util.Map.entry("set_suspension_max_force", 373806689L),
			java.util.Map.entry("set_damping_relaxation", 373806689L),
			java.util.Map.entry("set_friction_slip", 373806689L), java.util.Map.entry("is_used_as_steering", 36873697L),
			java.util.Map.entry("set_roll_influence", 373806689L),
			java.util.Map.entry("get_suspension_max_force", 1740695150L),
			java.util.Map.entry("get_contact_normal", 3360562783L));

	VehicleWheel3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VehicleWheel3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_used_as_traction() {
		return (boolean) super.call("is_used_as_traction");
	}

	public boolean is_used_as_steering() {
		return (boolean) super.call("is_used_as_steering");
	}

	public boolean is_in_contact() {
		return (boolean) super.call("is_in_contact");
	}

	public double getEngine_force() {
		return (double) super.call("get_engine_force", new java.lang.Object[0]);
	}

	public void setEngine_force(double value) {
		super.call("set_engine_force", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBrake() {
		return (double) super.call("get_brake", new java.lang.Object[0]);
	}

	public void setBrake(double value) {
		super.call("set_brake", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSteering() {
		return (double) super.call("get_steering", new java.lang.Object[0]);
	}

	public void setSteering(double value) {
		super.call("set_steering", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isUse_as_traction() {
		return (boolean) super.call("is_used_as_traction", new java.lang.Object[0]);
	}

	public void setUse_as_traction(boolean value) {
		super.call("set_use_as_traction", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_as_steering() {
		return (boolean) super.call("is_used_as_steering", new java.lang.Object[0]);
	}

	public void setUse_as_steering(boolean value) {
		super.call("set_use_as_steering", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getWheel_roll_influence() {
		return (double) super.call("get_roll_influence", new java.lang.Object[0]);
	}

	public void setWheel_roll_influence(double value) {
		super.call("set_roll_influence", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWheel_radius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setWheel_radius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWheel_rest_length() {
		return (double) super.call("get_suspension_rest_length", new java.lang.Object[0]);
	}

	public void setWheel_rest_length(double value) {
		super.call("set_suspension_rest_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWheel_friction_slip() {
		return (double) super.call("get_friction_slip", new java.lang.Object[0]);
	}

	public void setWheel_friction_slip(double value) {
		super.call("set_friction_slip", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSuspension_travel() {
		return (double) super.call("get_suspension_travel", new java.lang.Object[0]);
	}

	public void setSuspension_travel(double value) {
		super.call("set_suspension_travel", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSuspension_stiffness() {
		return (double) super.call("get_suspension_stiffness", new java.lang.Object[0]);
	}

	public void setSuspension_stiffness(double value) {
		super.call("set_suspension_stiffness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSuspension_max_force() {
		return (double) super.call("get_suspension_max_force", new java.lang.Object[0]);
	}

	public void setSuspension_max_force(double value) {
		super.call("set_suspension_max_force", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping_compression() {
		return (double) super.call("get_damping_compression", new java.lang.Object[0]);
	}

	public void setDamping_compression(double value) {
		super.call("set_damping_compression", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping_relaxation() {
		return (double) super.call("get_damping_relaxation", new java.lang.Object[0]);
	}

	public void setDamping_relaxation(double value) {
		super.call("set_damping_relaxation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
