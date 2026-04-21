package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ChainIK3D extends IKModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_end_bone", 3937882851L),
			java.util.Map.entry("get_end_bone_direction", 1843036459L),
			java.util.Map.entry("get_joint_bone", 3175239445L), java.util.Map.entry("get_root_bone", 923996154L),
			java.util.Map.entry("get_end_bone", 923996154L), java.util.Map.entry("set_extend_end_bone", 300928843L),
			java.util.Map.entry("set_end_bone_length", 1602489585L),
			java.util.Map.entry("set_end_bone_direction", 2838484201L),
			java.util.Map.entry("get_joint_bone_name", 1391810591L),
			java.util.Map.entry("get_root_bone_name", 844755477L),
			java.util.Map.entry("is_end_bone_extended", 1116898809L),
			java.util.Map.entry("get_joint_count", 923996154L), java.util.Map.entry("set_end_bone_name", 501894301L),
			java.util.Map.entry("set_root_bone", 3937882851L), java.util.Map.entry("get_end_bone_length", 2339986948L),
			java.util.Map.entry("set_root_bone_name", 501894301L),
			java.util.Map.entry("get_end_bone_name", 844755477L));

	ChainIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ChainIK3D(long nativePointer) {
		super(nativePointer);
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

	public void set_end_bone_length(long index, double length) {
		super.call("set_end_bone_length",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(length)});
	}

	public double get_end_bone_length(long index) {
		return (double) super.call("get_end_bone_length", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_joint_bone_name(long index, long joint) {
		return (String) super.call("get_joint_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public int get_joint_bone(long index, long joint) {
		return (int) super.call("get_joint_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public int get_joint_count(long index) {
		return (int) super.call("get_joint_count", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
