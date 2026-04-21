package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class SkeletonModification2DJiggle extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_jiggle_joint_use_gravity", 300928843L),
			java.util.Map.entry("set_stiffness", 373806689L), java.util.Map.entry("get_jiggle_joint_mass", 2339986948L),
			java.util.Map.entry("set_jiggle_joint_override", 300928843L),
			java.util.Map.entry("set_target_node", 1348162250L),
			java.util.Map.entry("set_jiggle_joint_gravity", 163021252L),
			java.util.Map.entry("get_jiggle_joint_stiffness", 2339986948L),
			java.util.Map.entry("get_collision_mask", 3905245786L),
			java.util.Map.entry("get_jiggle_data_chain_length", 2455072627L),
			java.util.Map.entry("set_jiggle_joint_bone_index", 3937882851L),
			java.util.Map.entry("set_damping", 373806689L),
			java.util.Map.entry("get_jiggle_joint_bone2d_node", 408788394L),
			java.util.Map.entry("get_stiffness", 1740695150L), java.util.Map.entry("set_collision_mask", 1286410249L),
			java.util.Map.entry("set_jiggle_joint_bone2d_node", 2761262315L),
			java.util.Map.entry("set_use_colliders", 2586408642L), java.util.Map.entry("get_target_node", 4075236667L),
			java.util.Map.entry("set_jiggle_data_chain_length", 1286410249L),
			java.util.Map.entry("get_use_colliders", 36873697L), java.util.Map.entry("set_use_gravity", 2586408642L),
			java.util.Map.entry("get_damping", 1740695150L), java.util.Map.entry("get_gravity", 3341600327L),
			java.util.Map.entry("get_jiggle_joint_use_gravity", 1116898809L),
			java.util.Map.entry("get_jiggle_joint_gravity", 2299179447L),
			java.util.Map.entry("get_jiggle_joint_damping", 2339986948L), java.util.Map.entry("set_mass", 373806689L),
			java.util.Map.entry("set_jiggle_joint_stiffness", 1602489585L),
			java.util.Map.entry("set_gravity", 743155724L), java.util.Map.entry("get_use_gravity", 36873697L),
			java.util.Map.entry("get_jiggle_joint_bone_index", 923996154L),
			java.util.Map.entry("get_mass", 1740695150L), java.util.Map.entry("set_jiggle_joint_damping", 1602489585L),
			java.util.Map.entry("get_jiggle_joint_override", 1116898809L),
			java.util.Map.entry("set_jiggle_joint_mass", 1602489585L));

	SkeletonModification2DJiggle(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DJiggle(long nativePointer) {
		super(nativePointer);
	}

	public void set_jiggle_joint_bone2d_node(long joint_idx, String bone2d_node) {
		super.call("set_jiggle_joint_bone2d_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), (java.lang.Object) bone2d_node});
	}

	public String get_jiggle_joint_bone2d_node(long joint_idx) {
		return (String) super.call("get_jiggle_joint_bone2d_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_bone_index(long joint_idx, long bone_idx) {
		super.call("set_jiggle_joint_bone_index",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Long.valueOf(bone_idx)});
	}

	public int get_jiggle_joint_bone_index(long joint_idx) {
		return (int) super.call("get_jiggle_joint_bone_index",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_override(long joint_idx, boolean override) {
		super.call("set_jiggle_joint_override",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Boolean.valueOf(override)});
	}

	public boolean get_jiggle_joint_override(long joint_idx) {
		return (boolean) super.call("get_jiggle_joint_override",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_stiffness(long joint_idx, double stiffness) {
		super.call("set_jiggle_joint_stiffness",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Double.valueOf(stiffness)});
	}

	public double get_jiggle_joint_stiffness(long joint_idx) {
		return (double) super.call("get_jiggle_joint_stiffness",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_mass(long joint_idx, double mass) {
		super.call("set_jiggle_joint_mass",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Double.valueOf(mass)});
	}

	public double get_jiggle_joint_mass(long joint_idx) {
		return (double) super.call("get_jiggle_joint_mass", new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_damping(long joint_idx, double damping) {
		super.call("set_jiggle_joint_damping",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Double.valueOf(damping)});
	}

	public double get_jiggle_joint_damping(long joint_idx) {
		return (double) super.call("get_jiggle_joint_damping",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_use_gravity(long joint_idx, boolean use_gravity) {
		super.call("set_jiggle_joint_use_gravity",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), java.lang.Boolean.valueOf(use_gravity)});
	}

	public boolean get_jiggle_joint_use_gravity(long joint_idx) {
		return (boolean) super.call("get_jiggle_joint_use_gravity",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void set_jiggle_joint_gravity(long joint_idx, Vector2 gravity) {
		super.call("set_jiggle_joint_gravity",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), (java.lang.Object) gravity});
	}

	public Vector2 get_jiggle_joint_gravity(long joint_idx) {
		return (Vector2) super.call("get_jiggle_joint_gravity",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public String getTarget_nodepath() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_nodepath(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getJiggle_data_chain_length() {
		return (long) super.call("get_jiggle_data_chain_length", new java.lang.Object[0]);
	}

	public void setJiggle_data_chain_length(long value) {
		super.call("set_jiggle_data_chain_length", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getStiffness() {
		return (double) super.call("get_stiffness", new java.lang.Object[0]);
	}

	public void setStiffness(double value) {
		super.call("set_stiffness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMass() {
		return (double) super.call("get_mass", new java.lang.Object[0]);
	}

	public void setMass(double value) {
		super.call("set_mass", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping() {
		return (double) super.call("get_damping", new java.lang.Object[0]);
	}

	public void setDamping(double value) {
		super.call("set_damping", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getUse_gravity() {
		return (boolean) super.call("get_use_gravity", new java.lang.Object[0]);
	}

	public void setUse_gravity(boolean value) {
		super.call("set_use_gravity", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getGravity() {
		return (Vector2) super.call("get_gravity", new java.lang.Object[0]);
	}

	public void setGravity(Vector2 value) {
		super.call("set_gravity", new java.lang.Object[]{(java.lang.Object) value});
	}
}
