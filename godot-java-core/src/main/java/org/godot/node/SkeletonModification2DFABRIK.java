package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class SkeletonModification2DFABRIK extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_fabrik_joint_magnet_position", 2299179447L),
			java.util.Map.entry("set_fabrik_joint_use_target_rotation", 300928843L),
			java.util.Map.entry("get_fabrik_joint_bone_index", 923996154L),
			java.util.Map.entry("set_fabrik_data_chain_length", 1286410249L),
			java.util.Map.entry("get_fabrik_data_chain_length", 2455072627L),
			java.util.Map.entry("set_fabrik_joint_bone2d_node", 2761262315L),
			java.util.Map.entry("get_fabrik_joint_bone2d_node", 408788394L),
			java.util.Map.entry("set_fabrik_joint_bone_index", 3937882851L),
			java.util.Map.entry("get_fabrik_joint_use_target_rotation", 1116898809L),
			java.util.Map.entry("get_target_node", 4075236667L),
			java.util.Map.entry("set_fabrik_joint_magnet_position", 163021252L),
			java.util.Map.entry("set_target_node", 1348162250L));

	SkeletonModification2DFABRIK(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DFABRIK(long nativePointer) {
		super(nativePointer);
	}

	public void set_fabrik_joint_bone2d_node(long joint_idx, String bone2d_nodepath) {
		super.call("set_fabrik_joint_bone2d_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), (java.lang.Object) bone2d_nodepath});
	}

	public String get_fabrik_joint_bone2d_node(long joint_idx) {
		return (String) super.call("get_fabrik_joint_bone2d_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_fabrik_joint_bone_index(long joint_idx, long bone_idx) {
		super.call("set_fabrik_joint_bone_index",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Long.valueOf(bone_idx)});
	}

	public int get_fabrik_joint_bone_index(long joint_idx) {
		return (int) super.call("get_fabrik_joint_bone_index",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_fabrik_joint_magnet_position(long joint_idx, Vector2 magnet_position) {
		super.call("set_fabrik_joint_magnet_position",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), (java.lang.Object) magnet_position});
	}

	public Vector2 get_fabrik_joint_magnet_position(long joint_idx) {
		return (Vector2) super.call("get_fabrik_joint_magnet_position",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_fabrik_joint_use_target_rotation(long joint_idx, boolean use_target_rotation) {
		super.call("set_fabrik_joint_use_target_rotation", new java.lang.Object[]{java.lang.Long.valueOf(joint_idx),
				java.lang.Boolean.valueOf(use_target_rotation)});
	}

	public boolean get_fabrik_joint_use_target_rotation(long joint_idx) {
		return (boolean) super.call("get_fabrik_joint_use_target_rotation",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public String getTarget_nodepath() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_nodepath(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFabrik_data_chain_length() {
		return (long) super.call("get_fabrik_data_chain_length", new java.lang.Object[0]);
	}

	public void setFabrik_data_chain_length(long value) {
		super.call("set_fabrik_data_chain_length", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
