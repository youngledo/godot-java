package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector2;

public class SkeletonProfile extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_tail_direction", 2675997574L), java.util.Map.entry("get_bone_name", 659327637L),
			java.util.Map.entry("get_scale_base_bone", 2737447660L), java.util.Map.entry("set_group", 3780747571L),
			java.util.Map.entry("get_bone_parent", 659327637L), java.util.Map.entry("get_bone_size", 2455072627L),
			java.util.Map.entry("find_bone", 2458036349L), java.util.Map.entry("set_reference_pose", 3616898986L),
			java.util.Map.entry("is_required", 1116898809L), java.util.Map.entry("set_group_name", 3780747571L),
			java.util.Map.entry("set_bone_name", 3780747571L), java.util.Map.entry("set_required", 300928843L),
			java.util.Map.entry("get_handle_offset", 2299179447L), java.util.Map.entry("set_handle_offset", 163021252L),
			java.util.Map.entry("set_group_size", 1286410249L), java.util.Map.entry("set_bone_size", 1286410249L),
			java.util.Map.entry("get_root_bone", 2737447660L), java.util.Map.entry("get_group_name", 659327637L),
			java.util.Map.entry("set_scale_base_bone", 3304788590L), java.util.Map.entry("set_bone_tail", 3780747571L),
			java.util.Map.entry("get_group_size", 2455072627L), java.util.Map.entry("set_bone_parent", 3780747571L),
			java.util.Map.entry("get_reference_pose", 1965739696L), java.util.Map.entry("get_group", 659327637L),
			java.util.Map.entry("set_root_bone", 3304788590L), java.util.Map.entry("set_texture", 666127730L),
			java.util.Map.entry("set_tail_direction", 1231951015L), java.util.Map.entry("get_bone_tail", 659327637L),
			java.util.Map.entry("get_texture", 3536238170L));

	SkeletonProfile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonProfile(long nativePointer) {
		super(nativePointer);
	}

	public String get_group_name(long group_idx) {
		return (String) super.call("get_group_name", new java.lang.Object[]{java.lang.Long.valueOf(group_idx)});
	}

	public void set_group_name(long group_idx, String group_name) {
		super.call("set_group_name",
				new java.lang.Object[]{java.lang.Long.valueOf(group_idx), (java.lang.Object) group_name});
	}

	public Texture2D get_texture(long group_idx) {
		return (Texture2D) super.call("get_texture", new java.lang.Object[]{java.lang.Long.valueOf(group_idx)});
	}

	public void set_texture(long group_idx, Texture2D texture) {
		super.call("set_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(group_idx), (java.lang.Object) texture});
	}

	public int find_bone(String bone_name) {
		return (int) super.call("find_bone", new java.lang.Object[]{(java.lang.Object) bone_name});
	}

	public String get_bone_name(long bone_idx) {
		return (String) super.call("get_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_name(long bone_idx, String bone_name) {
		super.call("set_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) bone_name});
	}

	public String get_bone_parent(long bone_idx) {
		return (String) super.call("get_bone_parent", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_parent(long bone_idx, String bone_parent) {
		super.call("set_bone_parent",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) bone_parent});
	}

	public int get_tail_direction(long bone_idx) {
		return (int) super.call("get_tail_direction", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_tail_direction(long bone_idx, int tail_direction) {
		super.call("set_tail_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), java.lang.Integer.valueOf(tail_direction)});
	}

	public String get_bone_tail(long bone_idx) {
		return (String) super.call("get_bone_tail", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_tail(long bone_idx, String bone_tail) {
		super.call("set_bone_tail",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) bone_tail});
	}

	public Transform3D get_reference_pose(long bone_idx) {
		return (Transform3D) super.call("get_reference_pose", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_reference_pose(long bone_idx, Transform3D bone_name) {
		super.call("set_reference_pose",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) bone_name});
	}

	public Vector2 get_handle_offset(long bone_idx) {
		return (Vector2) super.call("get_handle_offset", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_handle_offset(long bone_idx, Vector2 handle_offset) {
		super.call("set_handle_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) handle_offset});
	}

	public String get_group(long bone_idx) {
		return (String) super.call("get_group", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_group(long bone_idx, String group) {
		super.call("set_group", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) group});
	}

	public boolean is_required(long bone_idx) {
		return (boolean) super.call("is_required", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_required(long bone_idx, boolean required) {
		super.call("set_required",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), java.lang.Boolean.valueOf(required)});
	}

	public String getRoot_bone() {
		return (String) super.call("get_root_bone", new java.lang.Object[0]);
	}

	public void setRoot_bone(String value) {
		super.call("set_root_bone", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getScale_base_bone() {
		return (String) super.call("get_scale_base_bone", new java.lang.Object[0]);
	}

	public void setScale_base_bone(String value) {
		super.call("set_scale_base_bone", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getGroup_size() {
		return (long) super.call("get_group_size", new java.lang.Object[0]);
	}

	public void setGroup_size(long value) {
		super.call("set_group_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBone_size() {
		return (long) super.call("get_bone_size", new java.lang.Object[0]);
	}

	public void setBone_size(long value) {
		super.call("set_bone_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
