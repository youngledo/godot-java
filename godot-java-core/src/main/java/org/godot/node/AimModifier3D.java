package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AimModifier3D extends BoneConstraint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_relative", 300928843L), java.util.Map.entry("is_using_euler", 1116898809L),
			java.util.Map.entry("is_relative", 1116898809L),
			java.util.Map.entry("set_primary_rotation_axis", 776736805L),
			java.util.Map.entry("get_primary_rotation_axis", 4131134770L),
			java.util.Map.entry("set_forward_axis", 2496831085L),
			java.util.Map.entry("is_using_secondary_rotation", 1116898809L),
			java.util.Map.entry("set_use_euler", 300928843L),
			java.util.Map.entry("set_use_secondary_rotation", 300928843L),
			java.util.Map.entry("get_forward_axis", 3949866735L));

	AimModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AimModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_forward_axis(long index, int axis) {
		super.call("set_forward_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis)});
	}

	public int get_forward_axis(long index) {
		return (int) super.call("get_forward_axis", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_use_euler(long index, boolean enabled) {
		super.call("set_use_euler",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_using_euler(long index) {
		return (boolean) super.call("is_using_euler", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_primary_rotation_axis(long index, int axis) {
		super.call("set_primary_rotation_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis)});
	}

	public int get_primary_rotation_axis(long index) {
		return (int) super.call("get_primary_rotation_axis", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_use_secondary_rotation(long index, boolean enabled) {
		super.call("set_use_secondary_rotation",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_using_secondary_rotation(long index) {
		return (boolean) super.call("is_using_secondary_rotation",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_relative(long index, boolean enabled) {
		super.call("set_relative",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_relative(long index) {
		return (boolean) super.call("is_relative", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
