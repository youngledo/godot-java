package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class Curve extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_value_range", 1740695150L), java.util.Map.entry("set_max_value", 373806689L),
			java.util.Map.entry("set_point_offset", 3780573764L),
			java.util.Map.entry("set_point_left_tangent", 1602489585L),
			java.util.Map.entry("get_point_count", 3905245786L), java.util.Map.entry("set_point_value", 1602489585L),
			java.util.Map.entry("set_point_right_tangent", 1602489585L),
			java.util.Map.entry("get_min_domain", 1740695150L),
			java.util.Map.entry("set_point_right_mode", 1217242874L), java.util.Map.entry("set_min_domain", 373806689L),
			java.util.Map.entry("get_point_left_tangent", 2339986948L),
			java.util.Map.entry("set_bake_resolution", 1286410249L),
			java.util.Map.entry("get_point_right_tangent", 2339986948L),
			java.util.Map.entry("get_point_left_mode", 426950354L), java.util.Map.entry("get_max_domain", 1740695150L),
			java.util.Map.entry("get_point_right_mode", 426950354L), java.util.Map.entry("set_max_domain", 373806689L),
			java.util.Map.entry("clear_points", 3218959716L), java.util.Map.entry("sample", 3919130443L),
			java.util.Map.entry("set_min_value", 373806689L), java.util.Map.entry("set_point_count", 1286410249L),
			java.util.Map.entry("set_point_left_mode", 1217242874L),
			java.util.Map.entry("get_domain_range", 1740695150L), java.util.Map.entry("get_max_value", 1740695150L),
			java.util.Map.entry("get_point_position", 2299179447L), java.util.Map.entry("remove_point", 1286410249L),
			java.util.Map.entry("clean_dupes", 3218959716L), java.util.Map.entry("bake", 3218959716L),
			java.util.Map.entry("sample_baked", 3919130443L), java.util.Map.entry("get_bake_resolution", 3905245786L),
			java.util.Map.entry("add_point", 434072736L), java.util.Map.entry("get_min_value", 1740695150L));

	Curve(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Curve(long nativePointer) {
		super(nativePointer);
	}

	public int add_point(Vector2 position, double left_tangent, double right_tangent, int left_mode, int right_mode) {
		return (int) super.call("add_point",
				new java.lang.Object[]{(java.lang.Object) position, java.lang.Double.valueOf(left_tangent),
						java.lang.Double.valueOf(right_tangent), java.lang.Integer.valueOf(left_mode),
						java.lang.Integer.valueOf(right_mode)});
	}

	public void remove_point(long index) {
		super.call("remove_point", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_points() {
		super.call("clear_points");
	}

	public Vector2 get_point_position(long index) {
		return (Vector2) super.call("get_point_position", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_point_value(long index, double y) {
		super.call("set_point_value",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(y)});
	}

	public int set_point_offset(long index, double offset) {
		return (int) super.call("set_point_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(offset)});
	}

	public double sample(double offset) {
		return (double) super.call("sample", new java.lang.Object[]{java.lang.Double.valueOf(offset)});
	}

	public double sample_baked(double offset) {
		return (double) super.call("sample_baked", new java.lang.Object[]{java.lang.Double.valueOf(offset)});
	}

	public double get_point_left_tangent(long index) {
		return (double) super.call("get_point_left_tangent", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public double get_point_right_tangent(long index) {
		return (double) super.call("get_point_right_tangent", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_point_left_mode(long index) {
		return (int) super.call("get_point_left_mode", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_point_right_mode(long index) {
		return (int) super.call("get_point_right_mode", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_point_left_tangent(long index, double tangent) {
		super.call("set_point_left_tangent",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(tangent)});
	}

	public void set_point_right_tangent(long index, double tangent) {
		super.call("set_point_right_tangent",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(tangent)});
	}

	public void set_point_left_mode(long index, int mode) {
		super.call("set_point_left_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(mode)});
	}

	public void set_point_right_mode(long index, int mode) {
		super.call("set_point_right_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(mode)});
	}

	public void clean_dupes() {
		super.call("clean_dupes");
	}

	public void bake() {
		super.call("bake");
	}

	public double getMin_domain() {
		return (double) super.call("get_min_domain", new java.lang.Object[0]);
	}

	public void setMin_domain(double value) {
		super.call("set_min_domain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_domain() {
		return (double) super.call("get_max_domain", new java.lang.Object[0]);
	}

	public void setMax_domain(double value) {
		super.call("set_max_domain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMin_value() {
		return (double) super.call("get_min_value", new java.lang.Object[0]);
	}

	public void setMin_value(double value) {
		super.call("set_min_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMax_value() {
		return (double) super.call("get_max_value", new java.lang.Object[0]);
	}

	public void setMax_value(double value) {
		super.call("set_max_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBake_resolution() {
		return (long) super.call("get_bake_resolution", new java.lang.Object[0]);
	}

	public void setBake_resolution(long value) {
		super.call("set_bake_resolution", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPoint_count() {
		return (long) super.call("get_point_count", new java.lang.Object[0]);
	}

	public void setPoint_count(long value) {
		super.call("set_point_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
