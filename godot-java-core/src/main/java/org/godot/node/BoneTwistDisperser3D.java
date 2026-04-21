package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;

public class BoneTwistDisperser3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_end_bone", 923996154L), java.util.Map.entry("set_damping_curve", 1447180063L),
			java.util.Map.entry("get_setting_count", 3905245786L),
			java.util.Map.entry("set_extend_end_bone", 300928843L), java.util.Map.entry("get_twist_from", 476865136L),
			java.util.Map.entry("get_damping_curve", 747537754L), java.util.Map.entry("get_root_bone_name", 844755477L),
			java.util.Map.entry("set_twist_from", 2823819782L),
			java.util.Map.entry("get_joint_twist_amount", 3085491603L),
			java.util.Map.entry("is_end_bone_extended", 1116898809L),
			java.util.Map.entry("set_end_bone_name", 501894301L),
			java.util.Map.entry("is_twist_from_rest", 1116898809L),
			java.util.Map.entry("get_disperse_mode", 1326397005L),
			java.util.Map.entry("set_disperse_mode", 2954194337L),
			java.util.Map.entry("set_root_bone_name", 501894301L), java.util.Map.entry("get_end_bone_name", 844755477L),
			java.util.Map.entry("set_end_bone", 3937882851L),
			java.util.Map.entry("set_joint_twist_amount", 3506521499L),
			java.util.Map.entry("get_end_bone_direction", 1843036459L),
			java.util.Map.entry("get_joint_bone", 3175239445L), java.util.Map.entry("get_root_bone", 923996154L),
			java.util.Map.entry("are_bone_axes_mutable", 36873697L),
			java.util.Map.entry("set_twist_from_rest", 300928843L),
			java.util.Map.entry("set_setting_count", 1286410249L), java.util.Map.entry("clear_settings", 3218959716L),
			java.util.Map.entry("get_reference_bone_name", 844755477L),
			java.util.Map.entry("set_end_bone_direction", 2838484201L),
			java.util.Map.entry("get_joint_bone_name", 1391810591L),
			java.util.Map.entry("get_weight_position", 2339986948L),
			java.util.Map.entry("get_reference_bone", 923996154L), java.util.Map.entry("get_joint_count", 923996154L),
			java.util.Map.entry("set_root_bone", 3937882851L), java.util.Map.entry("set_weight_position", 1602489585L),
			java.util.Map.entry("set_mutable_bone_axes", 2586408642L));

	BoneTwistDisperser3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BoneTwistDisperser3D(long nativePointer) {
		super(nativePointer);
	}

	public void clear_settings() {
		super.call("clear_settings");
	}

	public boolean are_bone_axes_mutable() {
		return (boolean) super.call("are_bone_axes_mutable");
	}

	public void set_root_bone_name(long index, String bone_name) {
		super.call("set_root_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_root_bone_name(long index) {
		return (String) super.call("get_root_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_root_bone(long index, long bone) {
		super.call("set_root_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_root_bone(long index) {
		return (int) super.call("get_root_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_name(long index, String bone_name) {
		super.call("set_end_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_end_bone_name(long index) {
		return (String) super.call("get_end_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone(long index, long bone) {
		super.call("set_end_bone", new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_end_bone(long index) {
		return (int) super.call("get_end_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_reference_bone_name(long index) {
		return (String) super.call("get_reference_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_reference_bone(long index) {
		return (int) super.call("get_reference_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_extend_end_bone(long index, boolean enabled) {
		super.call("set_extend_end_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_end_bone_extended(long index) {
		return (boolean) super.call("is_end_bone_extended", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_direction(long index, int bone_direction) {
		super.call("set_end_bone_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(bone_direction)});
	}

	public int get_end_bone_direction(long index) {
		return (int) super.call("get_end_bone_direction", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_twist_from_rest(long index, boolean enabled) {
		super.call("set_twist_from_rest",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_twist_from_rest(long index) {
		return (boolean) super.call("is_twist_from_rest", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_twist_from(long index, Quaternion from) {
		super.call("set_twist_from", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) from});
	}

	public Quaternion get_twist_from(long index) {
		return (Quaternion) super.call("get_twist_from", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_disperse_mode(long index, int disperse_mode) {
		super.call("set_disperse_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(disperse_mode)});
	}

	public int get_disperse_mode(long index) {
		return (int) super.call("get_disperse_mode", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_weight_position(long index, double weight_position) {
		super.call("set_weight_position",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(weight_position)});
	}

	public double get_weight_position(long index) {
		return (double) super.call("get_weight_position", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_damping_curve(long index, Curve curve) {
		super.call("set_damping_curve",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) curve});
	}

	public Curve get_damping_curve(long index) {
		return (Curve) super.call("get_damping_curve", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_joint_bone_name(long index, long joint) {
		return (String) super.call("get_joint_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public int get_joint_bone(long index, long joint) {
		return (int) super.call("get_joint_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public double get_joint_twist_amount(long index, long joint) {
		return (double) super.call("get_joint_twist_amount",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_twist_amount(long index, long joint, double twist_amount) {
		super.call("set_joint_twist_amount", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Double.valueOf(twist_amount)});
	}

	public int get_joint_count(long index) {
		return (int) super.call("get_joint_count", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean getMutable_bone_axes() {
		return (boolean) super.call("are_bone_axes_mutable", new java.lang.Object[0]);
	}

	public void setMutable_bone_axes(boolean value) {
		super.call("set_mutable_bone_axes", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
