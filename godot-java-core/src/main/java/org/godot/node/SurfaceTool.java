package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;
import org.godot.math.Color;
import org.godot.math.Plane;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class SurfaceTool extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_weights", 2899603908L), java.util.Map.entry("set_uv2", 743155724L),
			java.util.Map.entry("create_from_blend_shape", 1306185582L),
			java.util.Map.entry("create_from_arrays", 1894639680L), java.util.Map.entry("create_from", 1767024570L),
			java.util.Map.entry("generate_lod", 1938056459L), java.util.Map.entry("get_custom_format", 839863283L),
			java.util.Map.entry("generate_normals", 107499316L), java.util.Map.entry("commit", 4107864055L),
			java.util.Map.entry("set_bones", 3614634198L), java.util.Map.entry("get_skin_weight_count", 1072401130L),
			java.util.Map.entry("optimize_indices_for_cache", 3218959716L),
			java.util.Map.entry("add_vertex", 3460891852L), java.util.Map.entry("set_normal", 3460891852L),
			java.util.Map.entry("get_primitive_type", 768822145L), java.util.Map.entry("set_uv", 743155724L),
			java.util.Map.entry("set_smooth_group", 1286410249L), java.util.Map.entry("add_index", 1286410249L),
			java.util.Map.entry("get_aabb", 1068685055L), java.util.Map.entry("set_custom", 2878471219L),
			java.util.Map.entry("append_from", 2217967155L), java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("index", 3218959716L),
			java.util.Map.entry("set_color", 2920490490L), java.util.Map.entry("commit_to_arrays", 2915620761L),
			java.util.Map.entry("add_triangle_fan", 2235017613L),
			java.util.Map.entry("set_skin_weight_count", 618679515L), java.util.Map.entry("deindex", 3218959716L),
			java.util.Map.entry("generate_tangents", 3218959716L), java.util.Map.entry("set_tangent", 3505987427L),
			java.util.Map.entry("set_custom_format", 4087759856L), java.util.Map.entry("begin", 2230304113L));

	SurfaceTool(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SurfaceTool(long nativePointer) {
		super(nativePointer);
	}

	public void set_custom_format(long channel_index, int format) {
		super.call("set_custom_format",
				new java.lang.Object[]{java.lang.Long.valueOf(channel_index), java.lang.Integer.valueOf(format)});
	}

	public int get_custom_format(long channel_index) {
		return (int) super.call("get_custom_format", new java.lang.Object[]{java.lang.Long.valueOf(channel_index)});
	}

	public void begin(int primitive) {
		super.call("begin", new java.lang.Object[]{java.lang.Integer.valueOf(primitive)});
	}

	public void add_vertex(Vector3 vertex) {
		super.call("add_vertex", new java.lang.Object[]{(java.lang.Object) vertex});
	}

	public void set_custom(long channel_index, Color custom_color) {
		super.call("set_custom",
				new java.lang.Object[]{java.lang.Long.valueOf(channel_index), (java.lang.Object) custom_color});
	}

	public void add_triangle_fan(double[][] vertices, double[][] uvs, double[][] colors, double[][] uv2s,
			double[][] normals, Plane[] tangents) {
		super.call("add_triangle_fan",
				new java.lang.Object[]{(java.lang.Object) vertices, (java.lang.Object) uvs, (java.lang.Object) colors,
						(java.lang.Object) uv2s, (java.lang.Object) normals, (java.lang.Object) tangents});
	}

	public void add_index(long index) {
		super.call("add_index", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void index() {
		super.call("index");
	}

	public void deindex() {
		super.call("deindex");
	}

	public void generate_normals(boolean flip) {
		super.call("generate_normals", new java.lang.Object[]{java.lang.Boolean.valueOf(flip)});
	}

	public void generate_tangents() {
		super.call("generate_tangents");
	}

	public void optimize_indices_for_cache() {
		super.call("optimize_indices_for_cache");
	}

	public int[] generate_lod(double nd_threshold, long target_index_count) {
		return (int[]) super.call("generate_lod", new java.lang.Object[]{java.lang.Double.valueOf(nd_threshold),
				java.lang.Long.valueOf(target_index_count)});
	}

	public void clear() {
		super.call("clear");
	}

	public void create_from(Mesh existing, long surface) {
		super.call("create_from", new java.lang.Object[]{(java.lang.Object) existing, java.lang.Long.valueOf(surface)});
	}

	public void create_from_arrays(GodotArray arrays, int primitive_type) {
		super.call("create_from_arrays",
				new java.lang.Object[]{(java.lang.Object) arrays, java.lang.Integer.valueOf(primitive_type)});
	}

	public void create_from_blend_shape(Mesh existing, long surface, String blend_shape) {
		super.call("create_from_blend_shape", new java.lang.Object[]{(java.lang.Object) existing,
				java.lang.Long.valueOf(surface), (java.lang.Object) blend_shape});
	}

	public void append_from(Mesh existing, long surface, Transform3D transform) {
		super.call("append_from", new java.lang.Object[]{(java.lang.Object) existing, java.lang.Long.valueOf(surface),
				(java.lang.Object) transform});
	}

	public ArrayMesh commit(ArrayMesh existing, long flags) {
		return (ArrayMesh) super.call("commit",
				new java.lang.Object[]{(java.lang.Object) existing, java.lang.Long.valueOf(flags)});
	}

	public GodotArray commit_to_arrays() {
		return (GodotArray) super.call("commit_to_arrays");
	}
}
