package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class Gradient extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_offset", 4025615559L), java.util.Map.entry("set_interpolation_mode", 1971444490L),
			java.util.Map.entry("set_interpolation_color_space", 3685995981L),
			java.util.Map.entry("reverse", 3218959716L), java.util.Map.entry("set_color", 2878471219L),
			java.util.Map.entry("sample", 1250405064L), java.util.Map.entry("get_color", 2624840992L),
			java.util.Map.entry("get_offsets", 675695659L), java.util.Map.entry("get_point_count", 3905245786L),
			java.util.Map.entry("get_interpolation_mode", 3674172981L),
			java.util.Map.entry("remove_point", 1286410249L), java.util.Map.entry("set_colors", 3546319833L),
			java.util.Map.entry("get_colors", 1392750486L),
			java.util.Map.entry("get_interpolation_color_space", 1538296000L),
			java.util.Map.entry("set_offset", 1602489585L), java.util.Map.entry("set_offsets", 2899603908L),
			java.util.Map.entry("add_point", 3629403827L));

	Gradient(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Gradient(long nativePointer) {
		super(nativePointer);
	}

	public void add_point(double offset, Color color) {
		super.call("add_point", new java.lang.Object[]{java.lang.Double.valueOf(offset), (java.lang.Object) color});
	}

	public void remove_point(long point) {
		super.call("remove_point", new java.lang.Object[]{java.lang.Long.valueOf(point)});
	}

	public void set_offset(long point, double offset) {
		super.call("set_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(point), java.lang.Double.valueOf(offset)});
	}

	public double get_offset(long point) {
		return (double) super.call("get_offset", new java.lang.Object[]{java.lang.Long.valueOf(point)});
	}

	public void reverse() {
		super.call("reverse");
	}

	public void set_color(long point, Color color) {
		super.call("set_color", new java.lang.Object[]{java.lang.Long.valueOf(point), (java.lang.Object) color});
	}

	public Color get_color(long point) {
		return (Color) super.call("get_color", new java.lang.Object[]{java.lang.Long.valueOf(point)});
	}

	public Color sample(double offset) {
		return (Color) super.call("sample", new java.lang.Object[]{java.lang.Double.valueOf(offset)});
	}

	public long getInterpolation_mode() {
		return (long) super.call("get_interpolation_mode", new java.lang.Object[0]);
	}

	public void setInterpolation_mode(long value) {
		super.call("set_interpolation_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getInterpolation_color_space() {
		return (long) super.call("get_interpolation_color_space", new java.lang.Object[0]);
	}

	public void setInterpolation_color_space(long value) {
		super.call("set_interpolation_color_space", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double[] getOffsets() {
		return (double[]) super.call("get_offsets", new java.lang.Object[0]);
	}

	public void setOffsets(double[] value) {
		super.call("set_offsets", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getColors() {
		return (double[][]) super.call("get_colors", new java.lang.Object[0]);
	}

	public void setColors(double[][] value) {
		super.call("set_colors", new java.lang.Object[]{(java.lang.Object) value});
	}
}
