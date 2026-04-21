package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;
import org.godot.math.Vector3;

public class SpringBoneCollision3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_rotation_offset", 1727505552L),
			java.util.Map.entry("get_rotation_offset", 1222331677L), java.util.Map.entry("get_bone_name", 201670096L),
			java.util.Map.entry("get_bone", 3905245786L), java.util.Map.entry("set_position_offset", 3460891852L),
			java.util.Map.entry("set_bone", 1286410249L), java.util.Map.entry("set_bone_name", 83702148L),
			java.util.Map.entry("get_skeleton", 1488626673L), java.util.Map.entry("get_position_offset", 3360562783L));

	SpringBoneCollision3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpringBoneCollision3D(long nativePointer) {
		super(nativePointer);
	}

	public String getBone_name() {
		return (String) super.call("get_bone_name", new java.lang.Object[0]);
	}

	public void setBone_name(String value) {
		super.call("set_bone_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getBone() {
		return (long) super.call("get_bone", new java.lang.Object[0]);
	}

	public void setBone(long value) {
		super.call("set_bone", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getPosition_offset() {
		return (Vector3) super.call("get_position_offset", new java.lang.Object[0]);
	}

	public void setPosition_offset(Vector3 value) {
		super.call("set_position_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Quaternion getRotation_offset() {
		return (Quaternion) super.call("get_rotation_offset", new java.lang.Object[0]);
	}

	public void setRotation_offset(Quaternion value) {
		super.call("set_rotation_offset", new java.lang.Object[]{(java.lang.Object) value});
	}
}
