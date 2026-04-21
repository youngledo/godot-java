package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class RetargetModifier3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_enable_flags", 2687954213L),
			java.util.Map.entry("is_using_global_pose", 36873697L),
			java.util.Map.entry("is_position_enabled", 36873697L), java.util.Map.entry("is_scale_enabled", 36873697L),
			java.util.Map.entry("get_enable_flags", 358995420L),
			java.util.Map.entry("set_position_enabled", 2586408642L),
			java.util.Map.entry("set_use_global_pose", 2586408642L),
			java.util.Map.entry("set_scale_enabled", 2586408642L), java.util.Map.entry("set_profile", 3870374136L),
			java.util.Map.entry("set_rotation_enabled", 2586408642L), java.util.Map.entry("get_profile", 4291782652L),
			java.util.Map.entry("is_rotation_enabled", 36873697L));

	RetargetModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RetargetModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_global_pose() {
		return (boolean) super.call("is_using_global_pose");
	}

	public boolean is_position_enabled() {
		return (boolean) super.call("is_position_enabled");
	}

	public boolean is_rotation_enabled() {
		return (boolean) super.call("is_rotation_enabled");
	}

	public boolean is_scale_enabled() {
		return (boolean) super.call("is_scale_enabled");
	}

	public SkeletonProfile getProfile() {
		return (SkeletonProfile) super.call("get_profile", new java.lang.Object[0]);
	}

	public void setProfile(SkeletonProfile value) {
		super.call("set_profile", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isUse_global_pose() {
		return (boolean) super.call("is_using_global_pose", new java.lang.Object[0]);
	}

	public void setUse_global_pose(boolean value) {
		super.call("set_use_global_pose", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getEnable() {
		return (long) super.call("get_enable_flags", new java.lang.Object[0]);
	}

	public void setEnable(long value) {
		super.call("set_enable_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
