package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class BoneAttachment3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_use_external_skeleton", 36873697L),
			java.util.Map.entry("set_bone_idx", 1286410249L), java.util.Map.entry("get_bone_idx", 3905245786L),
			java.util.Map.entry("get_bone_name", 201670096L), java.util.Map.entry("set_override_pose", 2586408642L),
			java.util.Map.entry("set_bone_name", 83702148L), java.util.Map.entry("get_override_pose", 36873697L),
			java.util.Map.entry("get_external_skeleton", 4075236667L),
			java.util.Map.entry("set_use_external_skeleton", 2586408642L),
			java.util.Map.entry("get_skeleton", 1814733083L), java.util.Map.entry("on_skeleton_update", 3218959716L),
			java.util.Map.entry("set_external_skeleton", 1348162250L));

	BoneAttachment3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BoneAttachment3D(long nativePointer) {
		super(nativePointer);
	}

	public void on_skeleton_update() {
		super.call("on_skeleton_update");
	}

	public String getBone_name() {
		return (String) super.call("get_bone_name", new java.lang.Object[0]);
	}

	public void setBone_name(String value) {
		super.call("set_bone_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBone_idx() {
		return (long) super.call("get_bone_idx", new java.lang.Object[0]);
	}

	public void setBone_idx(long value) {
		super.call("set_bone_idx", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getOverride_pose() {
		return (boolean) super.call("get_override_pose", new java.lang.Object[0]);
	}

	public void setOverride_pose(boolean value) {
		super.call("set_override_pose", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUse_external_skeleton() {
		return (boolean) super.call("get_use_external_skeleton", new java.lang.Object[0]);
	}

	public void setUse_external_skeleton(boolean value) {
		super.call("set_use_external_skeleton", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getExternal_skeleton() {
		return (String) super.call("get_external_skeleton", new java.lang.Object[0]);
	}

	public void setExternal_skeleton(String value) {
		super.call("set_external_skeleton", new java.lang.Object[]{(java.lang.Object) value});
	}
}
