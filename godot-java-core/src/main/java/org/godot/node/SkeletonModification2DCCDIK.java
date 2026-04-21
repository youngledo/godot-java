package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModification2DCCDIK extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_ccdik_joint_constraint_angle_min", 1602489585L),
			java.util.Map.entry("set_ccdik_joint_rotate_from_joint", 300928843L),
			java.util.Map.entry("get_ccdik_joint_constraint_angle_invert", 1116898809L),
			java.util.Map.entry("set_target_node", 1348162250L),
			java.util.Map.entry("set_ccdik_joint_bone_index", 3937882851L),
			java.util.Map.entry("get_tip_node", 4075236667L),
			java.util.Map.entry("get_ccdik_joint_rotate_from_joint", 1116898809L),
			java.util.Map.entry("set_ccdik_joint_constraint_angle_max", 1602489585L),
			java.util.Map.entry("set_ccdik_joint_constraint_angle_invert", 300928843L),
			java.util.Map.entry("get_ccdik_joint_constraint_angle_min", 2339986948L),
			java.util.Map.entry("get_ccdik_data_chain_length", 2455072627L),
			java.util.Map.entry("get_ccdik_joint_enable_constraint", 1116898809L),
			java.util.Map.entry("get_ccdik_joint_bone_index", 923996154L),
			java.util.Map.entry("get_target_node", 4075236667L),
			java.util.Map.entry("set_ccdik_data_chain_length", 1286410249L),
			java.util.Map.entry("set_ccdik_joint_bone2d_node", 2761262315L),
			java.util.Map.entry("get_ccdik_joint_constraint_angle_max", 2339986948L),
			java.util.Map.entry("set_tip_node", 1348162250L),
			java.util.Map.entry("set_ccdik_joint_enable_constraint", 300928843L),
			java.util.Map.entry("get_ccdik_joint_bone2d_node", 408788394L));

	SkeletonModification2DCCDIK(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DCCDIK(long nativePointer) {
		super(nativePointer);
	}

	public void set_ccdik_joint_bone2d_node(long joint_idx, String bone2d_nodepath) {
		super.call("set_ccdik_joint_bone2d_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), (java.lang.Object) bone2d_nodepath});
	}

	public String get_ccdik_joint_bone2d_node(long joint_idx) {
		return (String) super.call("get_ccdik_joint_bone2d_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_ccdik_joint_bone_index(long joint_idx, long bone_idx) {
		super.call("set_ccdik_joint_bone_index",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Long.valueOf(bone_idx)});
	}

	public int get_ccdik_joint_bone_index(long joint_idx) {
		return (int) super.call("get_ccdik_joint_bone_index",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_ccdik_joint_rotate_from_joint(long joint_idx, boolean rotate_from_joint) {
		super.call("set_ccdik_joint_rotate_from_joint", new java.lang.Object[]{java.lang.Long.valueOf(joint_idx),
				java.lang.Boolean.valueOf(rotate_from_joint)});
	}

	public boolean get_ccdik_joint_rotate_from_joint(long joint_idx) {
		return (boolean) super.call("get_ccdik_joint_rotate_from_joint",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_ccdik_joint_enable_constraint(long joint_idx, boolean enable_constraint) {
		super.call("set_ccdik_joint_enable_constraint", new java.lang.Object[]{java.lang.Long.valueOf(joint_idx),
				java.lang.Boolean.valueOf(enable_constraint)});
	}

	public boolean get_ccdik_joint_enable_constraint(long joint_idx) {
		return (boolean) super.call("get_ccdik_joint_enable_constraint",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_ccdik_joint_constraint_angle_min(long joint_idx, double angle_min) {
		super.call("set_ccdik_joint_constraint_angle_min",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Double.valueOf(angle_min)});
	}

	public double get_ccdik_joint_constraint_angle_min(long joint_idx) {
		return (double) super.call("get_ccdik_joint_constraint_angle_min",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_ccdik_joint_constraint_angle_max(long joint_idx, double angle_max) {
		super.call("set_ccdik_joint_constraint_angle_max",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Double.valueOf(angle_max)});
	}

	public double get_ccdik_joint_constraint_angle_max(long joint_idx) {
		return (double) super.call("get_ccdik_joint_constraint_angle_max",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_ccdik_joint_constraint_angle_invert(long joint_idx, boolean invert) {
		super.call("set_ccdik_joint_constraint_angle_invert",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Boolean.valueOf(invert)});
	}

	public boolean get_ccdik_joint_constraint_angle_invert(long joint_idx) {
		return (boolean) super.call("get_ccdik_joint_constraint_angle_invert",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public String getTarget_nodepath() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_nodepath(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTip_nodepath() {
		return (String) super.call("get_tip_node", new java.lang.Object[0]);
	}

	public void setTip_nodepath(String value) {
		super.call("set_tip_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getCcdik_data_chain_length() {
		return (long) super.call("get_ccdik_data_chain_length", new java.lang.Object[0]);
	}

	public void setCcdik_data_chain_length(long value) {
		super.call("set_ccdik_data_chain_length", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
