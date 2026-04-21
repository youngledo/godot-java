package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PinJoint2D extends Joint2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_angular_limit_enabled", 36873697L),
			java.util.Map.entry("set_angular_limit_upper", 373806689L),
			java.util.Map.entry("set_motor_target_velocity", 373806689L),
			java.util.Map.entry("get_angular_limit_lower", 1740695150L),
			java.util.Map.entry("set_angular_limit_lower", 373806689L),
			java.util.Map.entry("get_softness", 1740695150L), java.util.Map.entry("is_motor_enabled", 36873697L),
			java.util.Map.entry("get_angular_limit_upper", 1740695150L),
			java.util.Map.entry("get_motor_target_velocity", 1740695150L),
			java.util.Map.entry("set_angular_limit_enabled", 2586408642L),
			java.util.Map.entry("set_softness", 373806689L), java.util.Map.entry("set_motor_enabled", 2586408642L));

	PinJoint2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PinJoint2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_motor_enabled() {
		return (boolean) super.call("is_motor_enabled");
	}

	public boolean is_angular_limit_enabled() {
		return (boolean) super.call("is_angular_limit_enabled");
	}

	public double getSoftness() {
		return (double) super.call("get_softness", new java.lang.Object[0]);
	}

	public void setSoftness(double value) {
		super.call("set_softness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAngular_limit_enabled() {
		return (boolean) super.call("is_angular_limit_enabled", new java.lang.Object[0]);
	}

	public void setAngular_limit_enabled(boolean value) {
		super.call("set_angular_limit_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAngular_limit_lower() {
		return (double) super.call("get_angular_limit_lower", new java.lang.Object[0]);
	}

	public void setAngular_limit_lower(double value) {
		super.call("set_angular_limit_lower", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAngular_limit_upper() {
		return (double) super.call("get_angular_limit_upper", new java.lang.Object[0]);
	}

	public void setAngular_limit_upper(double value) {
		super.call("set_angular_limit_upper", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isMotor_enabled() {
		return (boolean) super.call("is_motor_enabled", new java.lang.Object[0]);
	}

	public void setMotor_enabled(boolean value) {
		super.call("set_motor_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getMotor_target_velocity() {
		return (double) super.call("get_motor_target_velocity", new java.lang.Object[0]);
	}

	public void setMotor_target_velocity(double value) {
		super.call("set_motor_target_velocity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
