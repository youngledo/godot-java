package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModification2DTwoBoneIK extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_joint_two_bone_idx", 1286410249L),
			java.util.Map.entry("set_joint_two_bone2d_node", 1348162250L),
			java.util.Map.entry("set_target_node", 1348162250L),
			java.util.Map.entry("set_flip_bend_direction", 2586408642L),
			java.util.Map.entry("set_joint_one_bone_idx", 1286410249L),
			java.util.Map.entry("set_joint_one_bone2d_node", 1348162250L),
			java.util.Map.entry("get_joint_two_bone_idx", 3905245786L),
			java.util.Map.entry("set_target_minimum_distance", 373806689L),
			java.util.Map.entry("get_flip_bend_direction", 36873697L),
			java.util.Map.entry("set_target_maximum_distance", 373806689L),
			java.util.Map.entry("get_target_node", 4075236667L),
			java.util.Map.entry("get_joint_one_bone2d_node", 4075236667L),
			java.util.Map.entry("get_joint_one_bone_idx", 3905245786L),
			java.util.Map.entry("get_joint_two_bone2d_node", 4075236667L),
			java.util.Map.entry("get_target_minimum_distance", 1740695150L),
			java.util.Map.entry("get_target_maximum_distance", 1740695150L));

	SkeletonModification2DTwoBoneIK(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DTwoBoneIK(long nativePointer) {
		super(nativePointer);
	}

	public String getTarget_nodepath() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_nodepath(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTarget_minimum_distance() {
		return (double) super.call("get_target_minimum_distance", new java.lang.Object[0]);
	}

	public void setTarget_minimum_distance(double value) {
		super.call("set_target_minimum_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTarget_maximum_distance() {
		return (double) super.call("get_target_maximum_distance", new java.lang.Object[0]);
	}

	public void setTarget_maximum_distance(double value) {
		super.call("set_target_maximum_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getFlip_bend_direction() {
		return (boolean) super.call("get_flip_bend_direction", new java.lang.Object[0]);
	}

	public void setFlip_bend_direction(boolean value) {
		super.call("set_flip_bend_direction", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
