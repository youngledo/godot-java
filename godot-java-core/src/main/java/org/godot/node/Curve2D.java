package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class Curve2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_point_out", 2299179447L), java.util.Map.entry("tessellate", 958145977L),
			java.util.Map.entry("sample_baked_with_rotation", 3296056341L),
			java.util.Map.entry("set_bake_interval", 373806689L), java.util.Map.entry("get_baked_points", 2961356807L),
			java.util.Map.entry("set_point_in", 163021252L), java.util.Map.entry("clear_points", 3218959716L),
			java.util.Map.entry("sample", 26514310L), java.util.Map.entry("get_baked_length", 1740695150L),
			java.util.Map.entry("get_bake_interval", 1740695150L),
			java.util.Map.entry("tessellate_even_length", 2319761637L),
			java.util.Map.entry("set_point_count", 1286410249L), java.util.Map.entry("get_closest_offset", 2276447920L),
			java.util.Map.entry("get_point_count", 3905245786L), java.util.Map.entry("get_point_position", 2299179447L),
			java.util.Map.entry("get_point_in", 2299179447L), java.util.Map.entry("get_closest_point", 2656412154L),
			java.util.Map.entry("remove_point", 1286410249L), java.util.Map.entry("set_point_out", 163021252L),
			java.util.Map.entry("sample_baked", 3464257706L), java.util.Map.entry("samplef", 3588506812L),
			java.util.Map.entry("add_point", 4175465202L), java.util.Map.entry("set_point_position", 163021252L));

	Curve2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Curve2D(long nativePointer) {
		super(nativePointer);
	}

	public void add_point(Vector2 position, Vector2 in, Vector2 out, long index) {
		super.call("add_point", new java.lang.Object[]{(java.lang.Object) position, (java.lang.Object) in,
				(java.lang.Object) out, java.lang.Long.valueOf(index)});
	}

	public void set_point_position(long idx, Vector2 position) {
		super.call("set_point_position",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) position});
	}

	public Vector2 get_point_position(long idx) {
		return (Vector2) super.call("get_point_position", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_point_in(long idx, Vector2 position) {
		super.call("set_point_in", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) position});
	}

	public Vector2 get_point_in(long idx) {
		return (Vector2) super.call("get_point_in", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_point_out(long idx, Vector2 position) {
		super.call("set_point_out", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) position});
	}

	public Vector2 get_point_out(long idx) {
		return (Vector2) super.call("get_point_out", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void remove_point(long idx) {
		super.call("remove_point", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void clear_points() {
		super.call("clear_points");
	}

	public Vector2 sample(long idx, double t) {
		return (Vector2) super.call("sample",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Double.valueOf(t)});
	}

	public Vector2 samplef(double fofs) {
		return (Vector2) super.call("samplef", new java.lang.Object[]{java.lang.Double.valueOf(fofs)});
	}

	public Vector2 sample_baked(double offset, boolean cubic) {
		return (Vector2) super.call("sample_baked",
				new java.lang.Object[]{java.lang.Double.valueOf(offset), java.lang.Boolean.valueOf(cubic)});
	}

	public Transform2D sample_baked_with_rotation(double offset, boolean cubic) {
		return (Transform2D) super.call("sample_baked_with_rotation",
				new java.lang.Object[]{java.lang.Double.valueOf(offset), java.lang.Boolean.valueOf(cubic)});
	}

	public Vector2 get_closest_point(Vector2 to_point) {
		return (Vector2) super.call("get_closest_point", new java.lang.Object[]{(java.lang.Object) to_point});
	}

	public double get_closest_offset(Vector2 to_point) {
		return (double) super.call("get_closest_offset", new java.lang.Object[]{(java.lang.Object) to_point});
	}

	public double[][] tessellate(long max_stages, double tolerance_degrees) {
		return (double[][]) super.call("tessellate", new java.lang.Object[]{java.lang.Long.valueOf(max_stages),
				java.lang.Double.valueOf(tolerance_degrees)});
	}

	public double[][] tessellate_even_length(long max_stages, double tolerance_length) {
		return (double[][]) super.call("tessellate_even_length",
				new java.lang.Object[]{java.lang.Long.valueOf(max_stages), java.lang.Double.valueOf(tolerance_length)});
	}

	public double getBake_interval() {
		return (double) super.call("get_bake_interval", new java.lang.Object[0]);
	}

	public void setBake_interval(double value) {
		super.call("set_bake_interval", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getPoint_count() {
		return (long) super.call("get_point_count", new java.lang.Object[0]);
	}

	public void setPoint_count(long value) {
		super.call("set_point_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
