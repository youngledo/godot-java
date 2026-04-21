package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModification2DLookAt extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_bone_index", 3905245786L), java.util.Map.entry("get_bone2d_node", 4075236667L),
			java.util.Map.entry("set_bone2d_node", 1348162250L), java.util.Map.entry("set_target_node", 1348162250L),
			java.util.Map.entry("get_enable_constraint", 36873697L),
			java.util.Map.entry("set_constraint_angle_max", 373806689L),
			java.util.Map.entry("get_constraint_angle_min", 1740695150L),
			java.util.Map.entry("get_additional_rotation", 1740695150L),
			java.util.Map.entry("set_additional_rotation", 373806689L),
			java.util.Map.entry("set_constraint_angle_invert", 2586408642L),
			java.util.Map.entry("get_target_node", 4075236667L),
			java.util.Map.entry("set_constraint_angle_min", 373806689L),
			java.util.Map.entry("set_enable_constraint", 2586408642L),
			java.util.Map.entry("get_constraint_angle_max", 1740695150L),
			java.util.Map.entry("set_bone_index", 1286410249L),
			java.util.Map.entry("get_constraint_angle_invert", 36873697L));

	SkeletonModification2DLookAt(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DLookAt(long nativePointer) {
		super(nativePointer);
	}

	public long getBone_index() {
		return (long) super.call("get_bone_index", new java.lang.Object[0]);
	}

	public void setBone_index(long value) {
		super.call("set_bone_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getBone2d_node() {
		return (String) super.call("get_bone2d_node", new java.lang.Object[0]);
	}

	public void setBone2d_node(String value) {
		super.call("set_bone2d_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTarget_nodepath() {
		return (String) super.call("get_target_node", new java.lang.Object[0]);
	}

	public void setTarget_nodepath(String value) {
		super.call("set_target_node", new java.lang.Object[]{(java.lang.Object) value});
	}
}
