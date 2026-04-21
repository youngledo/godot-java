package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform2D;

public class Skeleton2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_bone_local_pose_override", 2995540667L),
			java.util.Map.entry("get_bone_count", 3905245786L), java.util.Map.entry("get_bone", 2556267111L),
			java.util.Map.entry("get_modification_stack", 2107508396L),
			java.util.Map.entry("execute_modifications", 1005356550L),
			java.util.Map.entry("set_bone_local_pose_override", 555457532L),
			java.util.Map.entry("get_skeleton", 2944877500L),
			java.util.Map.entry("set_modification_stack", 3907307132L));

	Skeleton2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Skeleton2D(long nativePointer) {
		super(nativePointer);
	}

	public Bone2D get_bone(long idx) {
		return (Bone2D) super.call("get_bone", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void execute_modifications(double delta, long execution_mode) {
		super.call("execute_modifications",
				new java.lang.Object[]{java.lang.Double.valueOf(delta), java.lang.Long.valueOf(execution_mode)});
	}

	public void set_bone_local_pose_override(long bone_idx, Transform2D override_pose, double strength,
			boolean persistent) {
		super.call("set_bone_local_pose_override",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) override_pose,
						java.lang.Double.valueOf(strength), java.lang.Boolean.valueOf(persistent)});
	}

	public Transform2D get_bone_local_pose_override(long bone_idx) {
		return (Transform2D) super.call("get_bone_local_pose_override",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}
}
