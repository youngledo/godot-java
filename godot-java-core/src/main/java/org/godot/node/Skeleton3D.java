package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class Skeleton3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_show_rest_only", 36873697L), java.util.Map.entry("get_bone_pose_scale", 711720468L),
			java.util.Map.entry("get_bone_global_rest", 1965739696L),
			java.util.Map.entry("set_bone_enabled", 972357352L), java.util.Map.entry("advance", 373806689L),
			java.util.Map.entry("find_bone", 1321353865L),
			java.util.Map.entry("force_update_all_bone_transforms", 3218959716L),
			java.util.Map.entry("set_bone_pose_scale", 1530502735L),
			java.util.Map.entry("unparent_bone_and_rest", 1286410249L),
			java.util.Map.entry("set_bone_global_pose", 3616898986L),
			java.util.Map.entry("reset_bone_poses", 3218959716L),
			java.util.Map.entry("physical_bones_start_simulation", 2787316981L),
			java.util.Map.entry("reset_bone_pose", 1286410249L), java.util.Map.entry("has_bone_meta", 921227809L),
			java.util.Map.entry("get_bone_pose_position", 711720468L),
			java.util.Map.entry("is_bone_enabled", 1116898809L), java.util.Map.entry("get_bone_children", 1706082319L),
			java.util.Map.entry("set_bone_global_pose_override", 3483398371L),
			java.util.Map.entry("get_bone_global_pose_no_override", 1965739696L),
			java.util.Map.entry("set_bone_parent", 3937882851L), java.util.Map.entry("set_bone_rest", 3616898986L),
			java.util.Map.entry("get_bone_count", 3905245786L),
			java.util.Map.entry("get_animate_physical_bones", 36873697L),
			java.util.Map.entry("create_skin_from_rest_transforms", 1032037385L),
			java.util.Map.entry("set_motion_scale", 373806689L), java.util.Map.entry("get_bone_pose", 1965739696L),
			java.util.Map.entry("set_bone_pose_rotation", 2823819782L),
			java.util.Map.entry("register_skin", 3405789568L), java.util.Map.entry("get_bone_name", 844755477L),
			java.util.Map.entry("set_modifier_callback_mode_process", 3916362634L),
			java.util.Map.entry("clear_bones", 3218959716L),
			java.util.Map.entry("get_modifier_callback_mode_process", 997182536L),
			java.util.Map.entry("get_bone_parent", 923996154L), java.util.Map.entry("get_bone_meta", 203112058L),
			java.util.Map.entry("get_bone_global_pose", 1965739696L), java.util.Map.entry("set_bone_pose", 3616898986L),
			java.util.Map.entry("set_show_rest_only", 2586408642L), java.util.Map.entry("set_bone_name", 501894301L),
			java.util.Map.entry("set_bone_pose_position", 1530502735L),
			java.util.Map.entry("physical_bones_remove_collision_exception", 2722037293L),
			java.util.Map.entry("set_bone_meta", 702482756L),
			java.util.Map.entry("get_concatenated_bone_names", 2002593661L),
			java.util.Map.entry("get_parentless_bones", 1930428628L),
			java.util.Map.entry("get_bone_global_pose_override", 1965739696L),
			java.util.Map.entry("get_bone_meta_list", 663333327L),
			java.util.Map.entry("set_animate_physical_bones", 2586408642L),
			java.util.Map.entry("localize_rests", 3218959716L), java.util.Map.entry("get_version", 3905245786L),
			java.util.Map.entry("add_bone", 1597066294L),
			java.util.Map.entry("force_update_bone_child_transform", 1286410249L),
			java.util.Map.entry("get_bone_pose_rotation", 476865136L),
			java.util.Map.entry("clear_bones_global_pose_override", 3218959716L),
			java.util.Map.entry("get_bone_rest", 1965739696L),
			java.util.Map.entry("physical_bones_stop_simulation", 3218959716L),
			java.util.Map.entry("physical_bones_add_collision_exception", 2722037293L),
			java.util.Map.entry("get_motion_scale", 1740695150L));

	Skeleton3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Skeleton3D(long nativePointer) {
		super(nativePointer);
	}

	public int add_bone(String name) {
		return (int) super.call("add_bone", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int find_bone(String name) {
		return (int) super.call("find_bone", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_bone_name(long bone_idx) {
		return (String) super.call("get_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_name(long bone_idx, String name) {
		super.call("set_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) name});
	}

	public Object get_bone_meta(long bone_idx, String key) {
		return (Object) super.call("get_bone_meta",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) key});
	}

	public String[] get_bone_meta_list(long bone_idx) {
		return (String[]) super.call("get_bone_meta_list", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public boolean has_bone_meta(long bone_idx, String key) {
		return (boolean) super.call("has_bone_meta",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) key});
	}

	public void set_bone_meta(long bone_idx, String key, Object value) {
		super.call("set_bone_meta", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) key,
				(java.lang.Object) value});
	}

	public int get_bone_parent(long bone_idx) {
		return (int) super.call("get_bone_parent", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_parent(long bone_idx, long parent_idx) {
		super.call("set_bone_parent",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), java.lang.Long.valueOf(parent_idx)});
	}

	public void unparent_bone_and_rest(long bone_idx) {
		super.call("unparent_bone_and_rest", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public int[] get_bone_children(long bone_idx) {
		return (int[]) super.call("get_bone_children", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public Transform3D get_bone_rest(long bone_idx) {
		return (Transform3D) super.call("get_bone_rest", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_rest(long bone_idx, Transform3D rest) {
		super.call("set_bone_rest", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) rest});
	}

	public Transform3D get_bone_global_rest(long bone_idx) {
		return (Transform3D) super.call("get_bone_global_rest",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public Skin create_skin_from_rest_transforms() {
		return (Skin) super.call("create_skin_from_rest_transforms");
	}

	public SkinReference register_skin(Skin skin) {
		return (SkinReference) super.call("register_skin", new java.lang.Object[]{(java.lang.Object) skin});
	}

	public void localize_rests() {
		super.call("localize_rests");
	}

	public void clear_bones() {
		super.call("clear_bones");
	}

	public Transform3D get_bone_pose(long bone_idx) {
		return (Transform3D) super.call("get_bone_pose", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_pose(long bone_idx, Transform3D pose) {
		super.call("set_bone_pose", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) pose});
	}

	public void set_bone_pose_position(long bone_idx, Vector3 position) {
		super.call("set_bone_pose_position",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) position});
	}

	public void set_bone_pose_rotation(long bone_idx, Quaternion rotation) {
		super.call("set_bone_pose_rotation",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) rotation});
	}

	public void set_bone_pose_scale(long bone_idx, Vector3 scale) {
		super.call("set_bone_pose_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) scale});
	}

	public Vector3 get_bone_pose_position(long bone_idx) {
		return (Vector3) super.call("get_bone_pose_position", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public Quaternion get_bone_pose_rotation(long bone_idx) {
		return (Quaternion) super.call("get_bone_pose_rotation",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public Vector3 get_bone_pose_scale(long bone_idx) {
		return (Vector3) super.call("get_bone_pose_scale", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void reset_bone_pose(long bone_idx) {
		super.call("reset_bone_pose", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void reset_bone_poses() {
		super.call("reset_bone_poses");
	}

	public boolean is_bone_enabled(long bone_idx) {
		return (boolean) super.call("is_bone_enabled", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_enabled(long bone_idx, boolean enabled) {
		super.call("set_bone_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), java.lang.Boolean.valueOf(enabled)});
	}

	public Transform3D get_bone_global_pose(long bone_idx) {
		return (Transform3D) super.call("get_bone_global_pose",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void set_bone_global_pose(long bone_idx, Transform3D pose) {
		super.call("set_bone_global_pose",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx), (java.lang.Object) pose});
	}

	public void force_update_all_bone_transforms() {
		super.call("force_update_all_bone_transforms");
	}

	public void force_update_bone_child_transform(long bone_idx) {
		super.call("force_update_bone_child_transform", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public boolean is_show_rest_only() {
		return (boolean) super.call("is_show_rest_only");
	}

	public void advance(double delta) {
		super.call("advance", new java.lang.Object[]{java.lang.Double.valueOf(delta)});
	}

	public void clear_bones_global_pose_override() {
		super.call("clear_bones_global_pose_override");
	}

	public void set_bone_global_pose_override(long bone_idx, Transform3D pose, double amount, boolean persistent) {
		super.call("set_bone_global_pose_override", new java.lang.Object[]{java.lang.Long.valueOf(bone_idx),
				(java.lang.Object) pose, java.lang.Double.valueOf(amount), java.lang.Boolean.valueOf(persistent)});
	}

	public Transform3D get_bone_global_pose_override(long bone_idx) {
		return (Transform3D) super.call("get_bone_global_pose_override",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public Transform3D get_bone_global_pose_no_override(long bone_idx) {
		return (Transform3D) super.call("get_bone_global_pose_no_override",
				new java.lang.Object[]{java.lang.Long.valueOf(bone_idx)});
	}

	public void physical_bones_stop_simulation() {
		super.call("physical_bones_stop_simulation");
	}

	public void physical_bones_start_simulation(String[] bones) {
		super.call("physical_bones_start_simulation", new java.lang.Object[]{(java.lang.Object) bones});
	}

	public void physical_bones_add_collision_exception(long exception) {
		super.call("physical_bones_add_collision_exception", new java.lang.Object[]{java.lang.Long.valueOf(exception)});
	}

	public void physical_bones_remove_collision_exception(long exception) {
		super.call("physical_bones_remove_collision_exception",
				new java.lang.Object[]{java.lang.Long.valueOf(exception)});
	}

	public double getMotion_scale() {
		return (double) super.call("get_motion_scale", new java.lang.Object[0]);
	}

	public void setMotion_scale(double value) {
		super.call("set_motion_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isShow_rest_only() {
		return (boolean) super.call("is_show_rest_only", new java.lang.Object[0]);
	}

	public void setShow_rest_only(boolean value) {
		super.call("set_show_rest_only", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getModifier_callback_mode_process() {
		return (long) super.call("get_modifier_callback_mode_process", new java.lang.Object[0]);
	}

	public void setModifier_callback_mode_process(long value) {
		super.call("set_modifier_callback_mode_process", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAnimate_physical_bones() {
		return (boolean) super.call("get_animate_physical_bones", new java.lang.Object[0]);
	}

	public void setAnimate_physical_bones(boolean value) {
		super.call("set_animate_physical_bones", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
