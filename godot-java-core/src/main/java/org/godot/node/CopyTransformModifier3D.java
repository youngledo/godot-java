package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CopyTransformModifier3D extends BoneConstraint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_axis_y_enabled", 300928843L), java.util.Map.entry("set_copy_scale", 300928843L),
			java.util.Map.entry("set_axis_y_inverted", 300928843L), java.util.Map.entry("get_invert_flags", 992162046L),
			java.util.Map.entry("set_axis_z_enabled", 300928843L), java.util.Map.entry("is_scale_copying", 1116898809L),
			java.util.Map.entry("set_axis_x_enabled", 300928843L),
			java.util.Map.entry("is_axis_y_inverted", 1116898809L),
			java.util.Map.entry("is_position_copying", 1116898809L), java.util.Map.entry("get_axis_flags", 992162046L),
			java.util.Map.entry("set_copy_position", 300928843L), java.util.Map.entry("is_additive", 1116898809L),
			java.util.Map.entry("set_axis_z_inverted", 300928843L), java.util.Map.entry("get_copy_flags", 1685185931L),
			java.util.Map.entry("set_additive", 300928843L), java.util.Map.entry("set_copy_rotation", 300928843L),
			java.util.Map.entry("is_axis_x_inverted", 1116898809L), java.util.Map.entry("set_relative", 300928843L),
			java.util.Map.entry("is_rotation_copying", 1116898809L), java.util.Map.entry("is_relative", 1116898809L),
			java.util.Map.entry("set_axis_flags", 2044211897L), java.util.Map.entry("set_invert_flags", 2044211897L),
			java.util.Map.entry("set_axis_x_inverted", 300928843L),
			java.util.Map.entry("is_axis_x_enabled", 1116898809L),
			java.util.Map.entry("is_axis_z_inverted", 1116898809L),
			java.util.Map.entry("is_axis_y_enabled", 1116898809L),
			java.util.Map.entry("is_axis_z_enabled", 1116898809L), java.util.Map.entry("set_copy_flags", 2252507859L));

	CopyTransformModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CopyTransformModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_copy_flags(long index, int copy_flags) {
		super.call("set_copy_flags",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(copy_flags)});
	}

	public int get_copy_flags(long index) {
		return (int) super.call("get_copy_flags", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_flags(long index, int axis_flags) {
		super.call("set_axis_flags",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis_flags)});
	}

	public int get_axis_flags(long index) {
		return (int) super.call("get_axis_flags", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_invert_flags(long index, int axis_flags) {
		super.call("set_invert_flags",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis_flags)});
	}

	public int get_invert_flags(long index) {
		return (int) super.call("get_invert_flags", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_copy_position(long index, boolean enabled) {
		super.call("set_copy_position",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_position_copying(long index) {
		return (boolean) super.call("is_position_copying", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_copy_rotation(long index, boolean enabled) {
		super.call("set_copy_rotation",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_rotation_copying(long index) {
		return (boolean) super.call("is_rotation_copying", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_copy_scale(long index, boolean enabled) {
		super.call("set_copy_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_scale_copying(long index) {
		return (boolean) super.call("is_scale_copying", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_x_enabled(long index, boolean enabled) {
		super.call("set_axis_x_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_axis_x_enabled(long index) {
		return (boolean) super.call("is_axis_x_enabled", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_y_enabled(long index, boolean enabled) {
		super.call("set_axis_y_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_axis_y_enabled(long index) {
		return (boolean) super.call("is_axis_y_enabled", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_z_enabled(long index, boolean enabled) {
		super.call("set_axis_z_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_axis_z_enabled(long index) {
		return (boolean) super.call("is_axis_z_enabled", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_x_inverted(long index, boolean enabled) {
		super.call("set_axis_x_inverted",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_axis_x_inverted(long index) {
		return (boolean) super.call("is_axis_x_inverted", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_y_inverted(long index, boolean enabled) {
		super.call("set_axis_y_inverted",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_axis_y_inverted(long index) {
		return (boolean) super.call("is_axis_y_inverted", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_axis_z_inverted(long index, boolean enabled) {
		super.call("set_axis_z_inverted",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_axis_z_inverted(long index) {
		return (boolean) super.call("is_axis_z_inverted", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_relative(long index, boolean enabled) {
		super.call("set_relative",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_relative(long index) {
		return (boolean) super.call("is_relative", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_additive(long index, boolean enabled) {
		super.call("set_additive",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_additive(long index) {
		return (boolean) super.call("is_additive", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
