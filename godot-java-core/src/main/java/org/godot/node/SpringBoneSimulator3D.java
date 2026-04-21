package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class SpringBoneSimulator3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_setting_count", 3905245786L), java.util.Map.entry("get_radius", 2339986948L),
			java.util.Map.entry("set_extend_end_bone", 300928843L),
			java.util.Map.entry("get_gravity_damping_curve", 747537754L),
			java.util.Map.entry("set_radius", 1602489585L), java.util.Map.entry("set_center_bone_name", 501894301L),
			java.util.Map.entry("set_drag_damping_curve", 1447180063L),
			java.util.Map.entry("get_joint_radius", 3085491603L),
			java.util.Map.entry("is_end_bone_extended", 1116898809L),
			java.util.Map.entry("is_config_individual", 1116898809L),
			java.util.Map.entry("set_end_bone_name", 501894301L),
			java.util.Map.entry("get_exclude_collision_path", 464924783L),
			java.util.Map.entry("get_exclude_collision_count", 923996154L),
			java.util.Map.entry("set_joint_rotation_axis", 1391134969L),
			java.util.Map.entry("set_rotation_axis", 1539703856L),
			java.util.Map.entry("set_root_bone_name", 501894301L),
			java.util.Map.entry("clear_exclude_collisions", 1286410249L),
			java.util.Map.entry("get_root_bone", 923996154L), java.util.Map.entry("get_gravity", 2339986948L),
			java.util.Map.entry("get_joint_stiffness", 3085491603L),
			java.util.Map.entry("set_enable_all_child_collisions", 300928843L),
			java.util.Map.entry("get_joint_gravity_direction", 1592972041L),
			java.util.Map.entry("get_stiffness_damping_curve", 747537754L),
			java.util.Map.entry("set_drag", 1602489585L),
			java.util.Map.entry("set_joint_rotation_axis_vector", 2866752138L),
			java.util.Map.entry("set_joint_drag", 3506521499L),
			java.util.Map.entry("set_end_bone_direction", 2838484201L),
			java.util.Map.entry("get_center_bone", 923996154L), java.util.Map.entry("clear_settings", 3218959716L),
			java.util.Map.entry("get_joint_count", 923996154L), java.util.Map.entry("get_drag", 2339986948L),
			java.util.Map.entry("get_gravity_direction", 711720468L),
			java.util.Map.entry("set_individual_config", 300928843L), java.util.Map.entry("reset", 3218959716L),
			java.util.Map.entry("get_end_bone_length", 2339986948L),
			java.util.Map.entry("set_exclude_collision_count", 3937882851L),
			java.util.Map.entry("get_joint_rotation_axis_vector", 1592972041L),
			java.util.Map.entry("set_mutable_bone_axes", 2586408642L),
			java.util.Map.entry("set_external_force", 3460891852L), java.util.Map.entry("get_end_bone", 923996154L),
			java.util.Map.entry("set_stiffness", 1602489585L),
			java.util.Map.entry("set_rotation_axis_vector", 1530502735L),
			java.util.Map.entry("set_end_bone_length", 1602489585L),
			java.util.Map.entry("set_collision_path", 132481804L), java.util.Map.entry("set_center_node", 2761262315L),
			java.util.Map.entry("clear_collisions", 1286410249L),
			java.util.Map.entry("are_all_child_collisions_enabled", 1116898809L),
			java.util.Map.entry("get_center_bone_name", 844755477L),
			java.util.Map.entry("get_root_bone_name", 844755477L),
			java.util.Map.entry("set_joint_stiffness", 3506521499L),
			java.util.Map.entry("get_radius_damping_curve", 747537754L),
			java.util.Map.entry("get_stiffness", 2339986948L), java.util.Map.entry("get_joint_drag", 3085491603L),
			java.util.Map.entry("set_joint_radius", 3506521499L),
			java.util.Map.entry("set_joint_gravity_direction", 2866752138L),
			java.util.Map.entry("get_rotation_axis", 2844851118L), java.util.Map.entry("get_center_from", 2721930813L),
			java.util.Map.entry("get_drag_damping_curve", 747537754L),
			java.util.Map.entry("get_external_force", 3360562783L),
			java.util.Map.entry("get_end_bone_name", 844755477L), java.util.Map.entry("set_end_bone", 3937882851L),
			java.util.Map.entry("get_rotation_axis_vector", 711720468L),
			java.util.Map.entry("get_end_bone_direction", 1843036459L),
			java.util.Map.entry("get_joint_bone", 3175239445L), java.util.Map.entry("are_bone_axes_mutable", 36873697L),
			java.util.Map.entry("set_setting_count", 1286410249L),
			java.util.Map.entry("set_radius_damping_curve", 1447180063L),
			java.util.Map.entry("set_center_bone", 3937882851L),
			java.util.Map.entry("get_joint_bone_name", 1391810591L), java.util.Map.entry("set_gravity", 1602489585L),
			java.util.Map.entry("set_gravity_damping_curve", 1447180063L),
			java.util.Map.entry("get_collision_path", 464924783L), java.util.Map.entry("set_center_from", 2551505749L),
			java.util.Map.entry("get_center_node", 408788394L),
			java.util.Map.entry("set_gravity_direction", 1530502735L),
			java.util.Map.entry("set_root_bone", 3937882851L), java.util.Map.entry("set_collision_count", 3937882851L),
			java.util.Map.entry("set_stiffness_damping_curve", 1447180063L),
			java.util.Map.entry("get_collision_count", 923996154L),
			java.util.Map.entry("get_joint_gravity", 3085491603L),
			java.util.Map.entry("get_joint_rotation_axis", 3312594080L),
			java.util.Map.entry("set_joint_gravity", 3506521499L),
			java.util.Map.entry("set_exclude_collision_path", 132481804L));

	SpringBoneSimulator3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpringBoneSimulator3D(long nativePointer) {
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

	public void set_extend_end_bone(long index, boolean enabled) {
		super.call("set_extend_end_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_end_bone_extended(long index) {
		return (boolean) super.call("is_end_bone_extended", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_direction(long index, int bone_direction) {
		super.call("set_end_bone_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(bone_direction)});
	}

	public int get_end_bone_direction(long index) {
		return (int) super.call("get_end_bone_direction", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_end_bone_length(long index, double length) {
		super.call("set_end_bone_length",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(length)});
	}

	public double get_end_bone_length(long index) {
		return (double) super.call("get_end_bone_length", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_center_from(long index, int center_from) {
		super.call("set_center_from",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(center_from)});
	}

	public int get_center_from(long index) {
		return (int) super.call("get_center_from", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_center_node(long index, String node_path) {
		super.call("set_center_node",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) node_path});
	}

	public String get_center_node(long index) {
		return (String) super.call("get_center_node", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_center_bone_name(long index, String bone_name) {
		super.call("set_center_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) bone_name});
	}

	public String get_center_bone_name(long index) {
		return (String) super.call("get_center_bone_name", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_center_bone(long index, long bone) {
		super.call("set_center_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(bone)});
	}

	public int get_center_bone(long index) {
		return (int) super.call("get_center_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_radius(long index, double radius) {
		super.call("set_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(radius)});
	}

	public double get_radius(long index) {
		return (double) super.call("get_radius", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_rotation_axis(long index, int axis) {
		super.call("set_rotation_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis)});
	}

	public int get_rotation_axis(long index) {
		return (int) super.call("get_rotation_axis", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_rotation_axis_vector(long index, Vector3 vector) {
		super.call("set_rotation_axis_vector",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) vector});
	}

	public Vector3 get_rotation_axis_vector(long index) {
		return (Vector3) super.call("get_rotation_axis_vector", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_radius_damping_curve(long index, Curve curve) {
		super.call("set_radius_damping_curve",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) curve});
	}

	public Curve get_radius_damping_curve(long index) {
		return (Curve) super.call("get_radius_damping_curve", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stiffness(long index, double stiffness) {
		super.call("set_stiffness",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(stiffness)});
	}

	public double get_stiffness(long index) {
		return (double) super.call("get_stiffness", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stiffness_damping_curve(long index, Curve curve) {
		super.call("set_stiffness_damping_curve",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) curve});
	}

	public Curve get_stiffness_damping_curve(long index) {
		return (Curve) super.call("get_stiffness_damping_curve", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_drag(long index, double drag) {
		super.call("set_drag", new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(drag)});
	}

	public double get_drag(long index) {
		return (double) super.call("get_drag", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_drag_damping_curve(long index, Curve curve) {
		super.call("set_drag_damping_curve",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) curve});
	}

	public Curve get_drag_damping_curve(long index) {
		return (Curve) super.call("get_drag_damping_curve", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_gravity(long index, double gravity) {
		super.call("set_gravity",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(gravity)});
	}

	public double get_gravity(long index) {
		return (double) super.call("get_gravity", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_gravity_damping_curve(long index, Curve curve) {
		super.call("set_gravity_damping_curve",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) curve});
	}

	public Curve get_gravity_damping_curve(long index) {
		return (Curve) super.call("get_gravity_damping_curve", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_gravity_direction(long index, Vector3 gravity_direction) {
		super.call("set_gravity_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) gravity_direction});
	}

	public Vector3 get_gravity_direction(long index) {
		return (Vector3) super.call("get_gravity_direction", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_settings() {
		super.call("clear_settings");
	}

	public void set_individual_config(long index, boolean enabled) {
		super.call("set_individual_config",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_config_individual(long index) {
		return (boolean) super.call("is_config_individual", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_joint_bone_name(long index, long joint) {
		return (String) super.call("get_joint_bone_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public int get_joint_bone(long index, long joint) {
		return (int) super.call("get_joint_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_rotation_axis(long index, long joint, int axis) {
		super.call("set_joint_rotation_axis", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Integer.valueOf(axis)});
	}

	public int get_joint_rotation_axis(long index, long joint) {
		return (int) super.call("get_joint_rotation_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_rotation_axis_vector(long index, long joint, Vector3 vector) {
		super.call("set_joint_rotation_axis_vector", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), (java.lang.Object) vector});
	}

	public Vector3 get_joint_rotation_axis_vector(long index, long joint) {
		return (Vector3) super.call("get_joint_rotation_axis_vector",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_radius(long index, long joint, double radius) {
		super.call("set_joint_radius", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Double.valueOf(radius)});
	}

	public double get_joint_radius(long index, long joint) {
		return (double) super.call("get_joint_radius",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_stiffness(long index, long joint, double stiffness) {
		super.call("set_joint_stiffness", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Double.valueOf(stiffness)});
	}

	public double get_joint_stiffness(long index, long joint) {
		return (double) super.call("get_joint_stiffness",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_drag(long index, long joint, double drag) {
		super.call("set_joint_drag", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Double.valueOf(drag)});
	}

	public double get_joint_drag(long index, long joint) {
		return (double) super.call("get_joint_drag",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_gravity(long index, long joint, double gravity) {
		super.call("set_joint_gravity", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), java.lang.Double.valueOf(gravity)});
	}

	public double get_joint_gravity(long index, long joint) {
		return (double) super.call("get_joint_gravity",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public void set_joint_gravity_direction(long index, long joint, Vector3 gravity_direction) {
		super.call("set_joint_gravity_direction", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(joint), (java.lang.Object) gravity_direction});
	}

	public Vector3 get_joint_gravity_direction(long index, long joint) {
		return (Vector3) super.call("get_joint_gravity_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(joint)});
	}

	public int get_joint_count(long index) {
		return (int) super.call("get_joint_count", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_enable_all_child_collisions(long index, boolean enabled) {
		super.call("set_enable_all_child_collisions",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean are_all_child_collisions_enabled(long index) {
		return (boolean) super.call("are_all_child_collisions_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_exclude_collision_path(long index, long collision, String node_path) {
		super.call("set_exclude_collision_path", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(collision), (java.lang.Object) node_path});
	}

	public String get_exclude_collision_path(long index, long collision) {
		return (String) super.call("get_exclude_collision_path",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(collision)});
	}

	public void set_exclude_collision_count(long index, long count) {
		super.call("set_exclude_collision_count",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(count)});
	}

	public int get_exclude_collision_count(long index) {
		return (int) super.call("get_exclude_collision_count", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_exclude_collisions(long index) {
		super.call("clear_exclude_collisions", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_collision_path(long index, long collision, String node_path) {
		super.call("set_collision_path", new java.lang.Object[]{java.lang.Long.valueOf(index),
				java.lang.Long.valueOf(collision), (java.lang.Object) node_path});
	}

	public String get_collision_path(long index, long collision) {
		return (String) super.call("get_collision_path",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(collision)});
	}

	public void set_collision_count(long index, long count) {
		super.call("set_collision_count",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(count)});
	}

	public int get_collision_count(long index) {
		return (int) super.call("get_collision_count", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_collisions(long index) {
		super.call("clear_collisions", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean are_bone_axes_mutable() {
		return (boolean) super.call("are_bone_axes_mutable");
	}

	public void reset() {
		super.call("reset");
	}

	public Vector3 getExternal_force() {
		return (Vector3) super.call("get_external_force", new java.lang.Object[0]);
	}

	public void setExternal_force(Vector3 value) {
		super.call("set_external_force", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getMutable_bone_axes() {
		return (boolean) super.call("are_bone_axes_mutable", new java.lang.Object[0]);
	}

	public void setMutable_bone_axes(boolean value) {
		super.call("set_mutable_bone_axes", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
