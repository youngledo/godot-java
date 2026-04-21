package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRHand extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_hand", 2850644561L), java.util.Map.entry("get_hand_skeleton", 4075236667L),
			java.util.Map.entry("set_hand", 1849328560L), java.util.Map.entry("set_hand_skeleton", 1348162250L),
			java.util.Map.entry("set_bone_update", 3144625444L), java.util.Map.entry("set_skeleton_rig", 1528072213L),
			java.util.Map.entry("get_motion_range", 2191822314L), java.util.Map.entry("set_motion_range", 3326516003L),
			java.util.Map.entry("get_skeleton_rig", 968409338L), java.util.Map.entry("get_bone_update", 1310695248L));

	OpenXRHand(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRHand(long nativePointer) {
		super(nativePointer);
	}

	public long getHand() {
		return (long) super.call("get_hand", new java.lang.Object[0]);
	}

	public void setHand(long value) {
		super.call("set_hand", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMotion_range() {
		return (long) super.call("get_motion_range", new java.lang.Object[0]);
	}

	public void setMotion_range(long value) {
		super.call("set_motion_range", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getHand_skeleton() {
		return (String) super.call("get_hand_skeleton", new java.lang.Object[0]);
	}

	public void setHand_skeleton(String value) {
		super.call("set_hand_skeleton", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSkeleton_rig() {
		return (long) super.call("get_skeleton_rig", new java.lang.Object[0]);
	}

	public void setSkeleton_rig(long value) {
		super.call("set_skeleton_rig", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBone_update() {
		return (long) super.call("get_bone_update", new java.lang.Object[0]);
	}

	public void setBone_update(long value) {
		super.call("set_bone_update", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
