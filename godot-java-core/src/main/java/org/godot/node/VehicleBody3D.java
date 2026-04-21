package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VehicleBody3D extends RigidBody3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_brake", 373806689L), java.util.Map.entry("set_steering", 373806689L),
			java.util.Map.entry("get_steering", 1740695150L), java.util.Map.entry("get_engine_force", 1740695150L),
			java.util.Map.entry("get_brake", 1740695150L), java.util.Map.entry("set_engine_force", 373806689L));

	VehicleBody3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VehicleBody3D(long nativePointer) {
		super(nativePointer);
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
}
