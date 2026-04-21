package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform2D;

public class Bone2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_bone_angle", 1740695150L),
			java.util.Map.entry("get_index_in_skeleton", 3905245786L),
			java.util.Map.entry("get_autocalculate_length_and_angle", 36873697L),
			java.util.Map.entry("set_bone_angle", 373806689L), java.util.Map.entry("apply_rest", 3218959716L),
			java.util.Map.entry("set_length", 373806689L),
			java.util.Map.entry("set_autocalculate_length_and_angle", 2586408642L),
			java.util.Map.entry("get_rest", 3814499831L), java.util.Map.entry("get_length", 1740695150L),
			java.util.Map.entry("set_rest", 2761652528L), java.util.Map.entry("get_skeleton_rest", 3814499831L));

	Bone2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Bone2D(long nativePointer) {
		super(nativePointer);
	}

	public void apply_rest() {
		super.call("apply_rest");
	}

	public Transform2D getRest() {
		return (Transform2D) super.call("get_rest", new java.lang.Object[0]);
	}

	public void setRest(Transform2D value) {
		super.call("set_rest", new java.lang.Object[]{(java.lang.Object) value});
	}
}
