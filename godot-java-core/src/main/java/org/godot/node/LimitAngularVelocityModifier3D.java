package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class LimitAngularVelocityModifier3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_end_bone", 3937882851L), java.util.Map.entry("get_root_bone", 923996154L),
			java.util.Map.entry("get_end_bone", 923996154L),
			java.util.Map.entry("set_max_angular_velocity", 373806689L),
			java.util.Map.entry("clear_chains", 3218959716L), java.util.Map.entry("is_exclude", 36873697L),
			java.util.Map.entry("set_chain_count", 1286410249L), java.util.Map.entry("get_root_bone_name", 844755477L),
			java.util.Map.entry("set_exclude", 2586408642L), java.util.Map.entry("set_end_bone_name", 501894301L),
			java.util.Map.entry("reset", 3218959716L), java.util.Map.entry("set_root_bone", 3937882851L),
			java.util.Map.entry("get_max_angular_velocity", 1740695150L),
			java.util.Map.entry("get_chain_count", 3905245786L), java.util.Map.entry("set_root_bone_name", 501894301L),
			java.util.Map.entry("get_end_bone_name", 844755477L));

	LimitAngularVelocityModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LimitAngularVelocityModifier3D(long nativePointer) {
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

	public void clear_chains() {
		super.call("clear_chains");
	}

	public boolean is_exclude() {
		return (boolean) super.call("is_exclude");
	}

	public void reset() {
		super.call("reset");
	}

	public double getMax_angular_velocity() {
		return (double) super.call("get_max_angular_velocity", new java.lang.Object[0]);
	}

	public void setMax_angular_velocity(double value) {
		super.call("set_max_angular_velocity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isExclude() {
		return (boolean) super.call("is_exclude", new java.lang.Object[0]);
	}

	public void setExclude(boolean value) {
		super.call("set_exclude", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getChain_count() {
		return (long) super.call("get_chain_count", new java.lang.Object[0]);
	}

	public void setChain_count(long value) {
		super.call("set_chain_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getJoint_count() {
		return (long) super.call("_get_joint_count", new java.lang.Object[0]);
	}

	public void setJoint_count(long value) {
		super.call("set_joint_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
