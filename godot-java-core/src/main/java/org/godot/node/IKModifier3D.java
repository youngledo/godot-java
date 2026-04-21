package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class IKModifier3D extends SkeletonModifier3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("clear_settings", 3218959716L), java.util.Map.entry("are_bone_axes_mutable", 36873697L),
			java.util.Map.entry("get_setting_count", 3905245786L), java.util.Map.entry("reset", 3218959716L),
			java.util.Map.entry("set_setting_count", 1286410249L),
			java.util.Map.entry("set_mutable_bone_axes", 2586408642L));

	IKModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	IKModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public void clear_settings() {
		super.call("clear_settings");
	}

	public boolean are_bone_axes_mutable() {
		return (boolean) super.call("are_bone_axes_mutable");
	}

	public void reset() {
		super.call("reset");
	}

	public boolean getMutable_bone_axes() {
		return (boolean) super.call("are_bone_axes_mutable", new java.lang.Object[0]);
	}

	public void setMutable_bone_axes(boolean value) {
		super.call("set_mutable_bone_axes", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
