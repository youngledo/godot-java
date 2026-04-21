package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class HingeJoint3D extends Joint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_flag", 1083494620L), java.util.Map.entry("get_param", 4066002676L),
			java.util.Map.entry("set_param", 3082977519L), java.util.Map.entry("get_flag", 2841369610L));

	HingeJoint3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HingeJoint3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_param(int param, double value) {
		super.call("set_param",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param(int param) {
		return (double) super.call("get_param", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_flag(int flag, boolean enabled) {
		super.call("set_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean get_flag(int flag) {
		return (boolean) super.call("get_flag", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}
}
