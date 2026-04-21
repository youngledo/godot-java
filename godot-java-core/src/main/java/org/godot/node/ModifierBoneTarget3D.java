package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ModifierBoneTarget3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_bone_name", 201670096L), java.util.Map.entry("get_bone", 3905245786L),
			java.util.Map.entry("set_bone", 1286410249L), java.util.Map.entry("set_bone_name", 83702148L));

	ModifierBoneTarget3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ModifierBoneTarget3D(long nativePointer) {
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
}
