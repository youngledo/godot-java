package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;
import org.godot.math.Vector3;

public class IterateIK3D extends ChainIK3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_joint_limitation_right_axis_vector", 2866752138L),
			java.util.Map.entry("set_angular_delta_limit", 373806689L),
			java.util.Map.entry("set_joint_limitation_rotation_offset", 4188936002L),
			java.util.Map.entry("get_angular_delta_limit", 1740695150L),
			java.util.Map.entry("get_joint_limitation_rotation_offset", 2722473700L),
			java.util.Map.entry("get_joint_limitation", 91665146L),
			java.util.Map.entry("set_joint_rotation_axis_vector", 2866752138L),
			java.util.Map.entry("set_target_node", 2761262315L), java.util.Map.entry("set_max_iterations", 1286410249L),
			java.util.Map.entry("set_joint_limitation_right_axis", 3838967147L),
			java.util.Map.entry("is_deterministic", 36873697L), java.util.Map.entry("set_min_distance", 373806689L),
			java.util.Map.entry("get_joint_limitation_right_axis", 623936134L),
			java.util.Map.entry("get_max_iterations", 3905245786L), java.util.Map.entry("get_target_node", 408788394L),
			java.util.Map.entry("set_joint_limitation", 1194636955L),
			java.util.Map.entry("set_deterministic", 2586408642L),
			java.util.Map.entry("set_joint_rotation_axis", 1391134969L),
			java.util.Map.entry("get_joint_limitation_right_axis_vector", 1592972041L),
			java.util.Map.entry("get_min_distance", 1740695150L),
			java.util.Map.entry("get_joint_rotation_axis", 3312594080L),
			java.util.Map.entry("get_joint_rotation_axis_vector", 1592972041L));

	IterateIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	IterateIK3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_deterministic() {
		return (boolean) super.call("is_deterministic");
	}

	public void set_target_node(long index, String target_node) {
		super.call("set_target_node",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) target_node});
	}

	public String get_target_node(long index) {
		return (String) super.call("get_target_node", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_joint_rotation_axis(long index, long joint, int axis) {
		super.call("set_joint_rotation_axis", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(axis)});
	}

	public int get_joint_rotation_axis(long index, long joint) {
		return (int) super.call("get_joint_rotation_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_rotation_axis_vector(long index, long joint, Vector3 axis_vector) {
		super.call("set_joint_rotation_axis_vector", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), (java.lang.Object) axis_vector});
	}

	public Vector3 get_joint_rotation_axis_vector(long index, long joint) {
		return (Vector3) super.call("get_joint_rotation_axis_vector",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_limitation(long index, long joint, JointLimitation3D limitation) {
		super.call("set_joint_limitation", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), (java.lang.Object) limitation});
	}

	public JointLimitation3D get_joint_limitation(long index, long joint) {
		return (JointLimitation3D) super.call("get_joint_limitation",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_limitation_right_axis(long index, long joint, int direction) {
		super.call("set_joint_limitation_right_axis", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(direction)});
	}

	public int get_joint_limitation_right_axis(long index, long joint) {
		return (int) super.call("get_joint_limitation_right_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_limitation_right_axis_vector(long index, long joint, Vector3 vector) {
		super.call("set_joint_limitation_right_axis_vector", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), (java.lang.Object) vector});
	}

	public Vector3 get_joint_limitation_right_axis_vector(long index, long joint) {
		return (Vector3) super.call("get_joint_limitation_right_axis_vector",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_limitation_rotation_offset(long index, long joint, Quaternion offset) {
		super.call("set_joint_limitation_rotation_offset", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), (java.lang.Object) offset});
	}

	public Quaternion get_joint_limitation_rotation_offset(long index, long joint) {
		return (Quaternion) super.call("get_joint_limitation_rotation_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public long getMax_iterations() {
		return (long) super.call("get_max_iterations", new java.lang.Object[0]);
	}

	public void setMax_iterations(long value) {
		super.call("set_max_iterations", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getMin_distance() {
		return (double) super.call("get_min_distance", new java.lang.Object[0]);
	}

	public void setMin_distance(double value) {
		super.call("set_min_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAngular_delta_limit() {
		return (double) super.call("get_angular_delta_limit", new java.lang.Object[0]);
	}

	public void setAngular_delta_limit(double value) {
		super.call("set_angular_delta_limit", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDeterministic() {
		return (boolean) super.call("is_deterministic", new java.lang.Object[0]);
	}

	public void setDeterministic(boolean value) {
		super.call("set_deterministic", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
