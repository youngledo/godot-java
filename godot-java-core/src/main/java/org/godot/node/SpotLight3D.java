package org.godot.node;

import java.lang.foreign.MemorySegment;

public class SpotLight3D extends Light3D {
	SpotLight3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpotLight3D(long nativePointer) {
		super(nativePointer);
	}

	public double getSpot_range() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setSpot_range(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpot_attenuation() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setSpot_attenuation(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpot_angle() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setSpot_angle(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpot_angle_attenuation() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setSpot_angle_attenuation(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
