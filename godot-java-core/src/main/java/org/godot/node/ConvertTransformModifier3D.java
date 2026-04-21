package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ConvertTransformModifier3D extends BoneConstraint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_apply_range_min", 2339986948L), java.util.Map.entry("set_relative", 300928843L),
			java.util.Map.entry("get_reference_range_max", 2339986948L),
			java.util.Map.entry("set_reference_range_min", 1602489585L),
			java.util.Map.entry("is_relative", 1116898809L), java.util.Map.entry("set_apply_range_max", 1602489585L),
			java.util.Map.entry("set_reference_range_max", 1602489585L),
			java.util.Map.entry("get_apply_axis", 4131134770L), java.util.Map.entry("get_reference_axis", 4131134770L),
			java.util.Map.entry("set_apply_range_min", 1602489585L),
			java.util.Map.entry("set_reference_transform_mode", 1386463405L),
			java.util.Map.entry("set_apply_axis", 776736805L),
			java.util.Map.entry("get_reference_range_min", 2339986948L),
			java.util.Map.entry("is_additive", 1116898809L), java.util.Map.entry("set_reference_axis", 776736805L),
			java.util.Map.entry("set_apply_transform_mode", 1386463405L),
			java.util.Map.entry("get_apply_transform_mode", 3234663511L),
			java.util.Map.entry("get_reference_transform_mode", 3234663511L),
			java.util.Map.entry("set_additive", 300928843L), java.util.Map.entry("get_apply_range_max", 2339986948L));

	ConvertTransformModifier3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConvertTransformModifier3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_apply_transform_mode(long index, int transform_mode) {
		super.call("set_apply_transform_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(transform_mode)});
	}

	public int get_apply_transform_mode(long index) {
		return (int) super.call("get_apply_transform_mode", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_apply_axis(long index, int axis) {
		super.call("set_apply_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis)});
	}

	public int get_apply_axis(long index) {
		return (int) super.call("get_apply_axis", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_apply_range_min(long index, double range_min) {
		super.call("set_apply_range_min",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(range_min)});
	}

	public double get_apply_range_min(long index) {
		return (double) super.call("get_apply_range_min", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_apply_range_max(long index, double range_max) {
		super.call("set_apply_range_max",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(range_max)});
	}

	public double get_apply_range_max(long index) {
		return (double) super.call("get_apply_range_max", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_transform_mode(long index, int transform_mode) {
		super.call("set_reference_transform_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(transform_mode)});
	}

	public int get_reference_transform_mode(long index) {
		return (int) super.call("get_reference_transform_mode", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_axis(long index, int axis) {
		super.call("set_reference_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(axis)});
	}

	public int get_reference_axis(long index) {
		return (int) super.call("get_reference_axis", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_range_min(long index, double range_min) {
		super.call("set_reference_range_min",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(range_min)});
	}

	public double get_reference_range_min(long index) {
		return (double) super.call("get_reference_range_min", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_reference_range_max(long index, double range_max) {
		super.call("set_reference_range_max",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(range_max)});
	}

	public double get_reference_range_max(long index) {
		return (double) super.call("get_reference_range_max", new java.lang.Object[]{java.lang.Long.valueOf(index)});
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
