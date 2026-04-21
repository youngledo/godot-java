package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class Curve3D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_point_out", 711720468L), java.util.Map.entry("tessellate", 1519759391L),
			java.util.Map.entry("sample_baked_up_vector", 1362627031L),
			java.util.Map.entry("get_baked_up_vectors", 497664490L),
			java.util.Map.entry("sample_baked_with_rotation", 1939359131L),
			java.util.Map.entry("is_up_vector_enabled", 36873697L),
			java.util.Map.entry("set_bake_interval", 373806689L), java.util.Map.entry("get_baked_points", 497664490L),
			java.util.Map.entry("set_point_in", 1530502735L), java.util.Map.entry("get_bake_interval", 1740695150L),
			java.util.Map.entry("tessellate_even_length", 133237049L),
			java.util.Map.entry("get_point_tilt", 2339986948L), java.util.Map.entry("get_point_count", 3905245786L),
			java.util.Map.entry("get_point_in", 711720468L), java.util.Map.entry("get_closest_point", 192990374L),
			java.util.Map.entry("set_point_out", 1530502735L), java.util.Map.entry("samplef", 2553580215L),
			java.util.Map.entry("get_baked_tilts", 675695659L), java.util.Map.entry("is_closed", 36873697L),
			java.util.Map.entry("set_closed", 2586408642L), java.util.Map.entry("set_point_tilt", 1602489585L),
			java.util.Map.entry("clear_points", 3218959716L), java.util.Map.entry("sample", 3285246857L),
			java.util.Map.entry("get_baked_length", 1740695150L), java.util.Map.entry("set_point_count", 1286410249L),
			java.util.Map.entry("get_closest_offset", 1109078154L),
			java.util.Map.entry("set_up_vector_enabled", 2586408642L),
			java.util.Map.entry("get_point_position", 711720468L), java.util.Map.entry("remove_point", 1286410249L),
			java.util.Map.entry("sample_baked", 1350085894L), java.util.Map.entry("add_point", 2931053748L),
			java.util.Map.entry("set_point_position", 1530502735L));

	Curve3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Curve3D(long nativePointer) {
		super(nativePointer);
	}

	public void add_point(Vector3 position, Vector3 in, Vector3 out, long index) {
		super.call("add_point", new java.lang.Object[]{(java.lang.Object) position, (java.lang.Object) in,
				(java.lang.Object) out, java.lang.Long.valueOf(index)});
	}

	public void set_point_position(long idx, Vector3 position) {
		super.call("set_point_position",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) position});
	}

	public Vector3 get_point_position(long idx) {
		return (Vector3) super.call("get_point_position", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_point_tilt(long idx, double tilt) {
		super.call("set_point_tilt",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Double.valueOf(tilt)});
	}

	public double get_point_tilt(long idx) {
		return (double) super.call("get_point_tilt", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_point_in(long idx, Vector3 position) {
		super.call("set_point_in", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) position});
	}

	public Vector3 get_point_in(long idx) {
		return (Vector3) super.call("get_point_in", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_point_out(long idx, Vector3 position) {
		super.call("set_point_out", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) position});
	}

	public Vector3 get_point_out(long idx) {
		return (Vector3) super.call("get_point_out", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void remove_point(long idx) {
		super.call("remove_point", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void clear_points() {
		super.call("clear_points");
	}

	public Vector3 sample(long idx, double t) {
		return (Vector3) super.call("sample",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Double.valueOf(t)});
	}

	public Vector3 samplef(double fofs) {
		return (Vector3) super.call("samplef", new java.lang.Object[]{java.lang.Double.valueOf(fofs)});
	}

	public boolean is_closed() {
		return (boolean) super.call("is_closed");
	}

	public boolean is_up_vector_enabled() {
		return (boolean) super.call("is_up_vector_enabled");
	}

	public Vector3 sample_baked(double offset, boolean cubic) {
		return (Vector3) super.call("sample_baked",
				new java.lang.Object[]{java.lang.Double.valueOf(offset), java.lang.Boolean.valueOf(cubic)});
	}

	public Transform3D sample_baked_with_rotation(double offset, boolean cubic, boolean apply_tilt) {
		return (Transform3D) super.call("sample_baked_with_rotation",
				new java.lang.Object[]{java.lang.Double.valueOf(offset), java.lang.Boolean.valueOf(cubic),
						java.lang.Boolean.valueOf(apply_tilt)});
	}

	public Vector3 sample_baked_up_vector(double offset, boolean apply_tilt) {
		return (Vector3) super.call("sample_baked_up_vector",
				new java.lang.Object[]{java.lang.Double.valueOf(offset), java.lang.Boolean.valueOf(apply_tilt)});
	}

	public Vector3 get_closest_point(Vector3 to_point) {
		return (Vector3) super.call("get_closest_point", new java.lang.Object[]{(java.lang.Object) to_point});
	}

	public double get_closest_offset(Vector3 to_point) {
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

	public boolean isClosed() {
		return (boolean) super.call("is_closed", new java.lang.Object[0]);
	}

	public void setClosed(boolean value) {
		super.call("set_closed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public boolean isUp_vector_enabled() {
		return (boolean) super.call("is_up_vector_enabled", new java.lang.Object[0]);
	}

	public void setUp_vector_enabled(boolean value) {
		super.call("set_up_vector_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
