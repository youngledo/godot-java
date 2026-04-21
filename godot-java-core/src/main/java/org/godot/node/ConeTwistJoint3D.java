package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ConeTwistJoint3D extends Joint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_param", 2928790850L), java.util.Map.entry("set_param", 1062470226L));

	ConeTwistJoint3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConeTwistJoint3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_param(int param, double value) {
		super.call("set_param",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param(int param) {
		return (double) super.call("get_param", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public double getSwing_span() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setSwing_span(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTwist_span() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setTwist_span(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBias() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setBias(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSoftness() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setSoftness(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRelaxation() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setRelaxation(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
