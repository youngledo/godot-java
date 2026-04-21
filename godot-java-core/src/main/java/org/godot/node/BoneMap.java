package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class BoneMap extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("find_profile_bone_name", 1965194235L),
			java.util.Map.entry("set_skeleton_bone_name", 3740211285L), java.util.Map.entry("set_profile", 3870374136L),
			java.util.Map.entry("get_profile", 4291782652L),
			java.util.Map.entry("get_skeleton_bone_name", 1965194235L));

	BoneMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BoneMap(long nativePointer) {
		super(nativePointer);
	}

	public String get_skeleton_bone_name(String profile_bone_name) {
		return (String) super.call("get_skeleton_bone_name",
				new java.lang.Object[]{(java.lang.Object) profile_bone_name});
	}

	public void set_skeleton_bone_name(String profile_bone_name, String skeleton_bone_name) {
		super.call("set_skeleton_bone_name",
				new java.lang.Object[]{(java.lang.Object) profile_bone_name, (java.lang.Object) skeleton_bone_name});
	}

	public String find_profile_bone_name(String skeleton_bone_name) {
		return (String) super.call("find_profile_bone_name",
				new java.lang.Object[]{(java.lang.Object) skeleton_bone_name});
	}

	public SkeletonProfile getProfile() {
		return (SkeletonProfile) super.call("get_profile", new java.lang.Object[0]);
	}

	public void setProfile(SkeletonProfile value) {
		super.call("set_profile", new java.lang.Object[]{(java.lang.Object) value});
	}
}
