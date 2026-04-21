package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PhysicalBone2D extends RigidBody2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_auto_configure_joint", 2586408642L),
			java.util.Map.entry("set_follow_bone_when_simulating", 2586408642L),
			java.util.Map.entry("is_simulating_physics", 36873697L),
			java.util.Map.entry("get_follow_bone_when_simulating", 36873697L),
			java.util.Map.entry("get_simulate_physics", 36873697L),
			java.util.Map.entry("get_auto_configure_joint", 36873697L),
			java.util.Map.entry("set_bone2d_index", 1286410249L),
			java.util.Map.entry("set_bone2d_nodepath", 1348162250L),
			java.util.Map.entry("get_bone2d_nodepath", 4075236667L),
			java.util.Map.entry("get_bone2d_index", 3905245786L), java.util.Map.entry("get_joint", 3582132112L),
			java.util.Map.entry("set_simulate_physics", 2586408642L));

	PhysicalBone2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicalBone2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_simulating_physics() {
		return (boolean) super.call("is_simulating_physics");
	}

	public String getBone2d_nodepath() {
		return (String) super.call("get_bone2d_nodepath", new java.lang.Object[0]);
	}

	public void setBone2d_nodepath(String value) {
		super.call("set_bone2d_nodepath", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBone2d_index() {
		return (long) super.call("get_bone2d_index", new java.lang.Object[0]);
	}

	public void setBone2d_index(long value) {
		super.call("set_bone2d_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAuto_configure_joint() {
		return (boolean) super.call("get_auto_configure_joint", new java.lang.Object[0]);
	}

	public void setAuto_configure_joint(boolean value) {
		super.call("set_auto_configure_joint", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSimulate_physics() {
		return (boolean) super.call("get_simulate_physics", new java.lang.Object[0]);
	}

	public void setSimulate_physics(boolean value) {
		super.call("set_simulate_physics", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getFollow_bone_when_simulating() {
		return (boolean) super.call("get_follow_bone_when_simulating", new java.lang.Object[0]);
	}

	public void setFollow_bone_when_simulating(boolean value) {
		super.call("set_follow_bone_when_simulating", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
