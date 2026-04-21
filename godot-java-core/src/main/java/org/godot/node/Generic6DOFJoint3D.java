package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Generic6DOFJoint3D extends Joint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_flag_y", 2451594564L), java.util.Map.entry("set_flag_x", 2451594564L),
			java.util.Map.entry("get_flag_z", 2122427807L), java.util.Map.entry("set_param_x", 2018184242L),
			java.util.Map.entry("set_param_y", 2018184242L), java.util.Map.entry("set_param_z", 2018184242L),
			java.util.Map.entry("set_flag_z", 2451594564L), java.util.Map.entry("get_param_z", 2599835054L),
			java.util.Map.entry("get_flag_x", 2122427807L), java.util.Map.entry("get_param_y", 2599835054L),
			java.util.Map.entry("get_flag_y", 2122427807L), java.util.Map.entry("get_param_x", 2599835054L));

	Generic6DOFJoint3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Generic6DOFJoint3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_param_x(int param, double value) {
		super.call("set_param_x",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param_x(int param) {
		return (double) super.call("get_param_x", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_param_y(int param, double value) {
		super.call("set_param_y",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param_y(int param) {
		return (double) super.call("get_param_y", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_param_z(int param, double value) {
		super.call("set_param_z",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param_z(int param) {
		return (double) super.call("get_param_z", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}

	public void set_flag_x(int flag, boolean value) {
		super.call("set_flag_x",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_flag_x(int flag) {
		return (boolean) super.call("get_flag_x", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}

	public void set_flag_y(int flag, boolean value) {
		super.call("set_flag_y",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_flag_y(int flag) {
		return (boolean) super.call("get_flag_y", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}

	public void set_flag_z(int flag, boolean value) {
		super.call("set_flag_z",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_flag_z(int flag) {
		return (boolean) super.call("get_flag_z", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}
}
