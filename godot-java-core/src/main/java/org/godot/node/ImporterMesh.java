package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;

public class ImporterMesh extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_surface", 1740448849L), java.util.Map.entry("get_surface_lod_count", 923996154L),
			java.util.Map.entry("get_surface_lod_indices", 1265128013L),
			java.util.Map.entry("get_surface_name", 844755477L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("set_blend_shape_mode", 227983991L), java.util.Map.entry("from_mesh", 283226343L),
			java.util.Map.entry("get_lightmap_size_hint", 3690982128L),
			java.util.Map.entry("get_surface_primitive_type", 3552571330L),
			java.util.Map.entry("generate_lods", 2491878677L),
			java.util.Map.entry("set_lightmap_size_hint", 1130785943L),
			java.util.Map.entry("add_blend_shape", 83702148L), java.util.Map.entry("get_blend_shape_name", 844755477L),
			java.util.Map.entry("get_surface_material", 2897466400L),
			java.util.Map.entry("get_surface_count", 3905245786L),
			java.util.Map.entry("get_surface_blend_shape_arrays", 2345056839L),
			java.util.Map.entry("get_blend_shape_mode", 836485024L),
			java.util.Map.entry("get_surface_arrays", 663333327L), java.util.Map.entry("get_mesh", 1457573577L),
			java.util.Map.entry("get_surface_format", 923996154L),
			java.util.Map.entry("get_blend_shape_count", 3905245786L),
			java.util.Map.entry("get_surface_lod_size", 3085491603L),
			java.util.Map.entry("set_surface_name", 501894301L),
			java.util.Map.entry("set_surface_material", 3671737478L));

	ImporterMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImporterMesh(long nativePointer) {
		super(nativePointer);
	}

	public void add_blend_shape(String name) {
		super.call("add_blend_shape", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_blend_shape_name(long blend_shape_idx) {
		return (String) super.call("get_blend_shape_name",
				new java.lang.Object[]{java.lang.Long.valueOf(blend_shape_idx)});
	}

	public void add_surface(int primitive, GodotArray arrays, GodotArray[] blend_shapes, GodotDictionary lods,
			Material material, String name, long flags) {
		super.call("add_surface",
				new java.lang.Object[]{java.lang.Integer.valueOf(primitive), (java.lang.Object) arrays,
						(java.lang.Object) blend_shapes, (java.lang.Object) lods, (java.lang.Object) material,
						(java.lang.Object) name, java.lang.Long.valueOf(flags)});
	}

	public int get_surface_primitive_type(long surface_idx) {
		return (int) super.call("get_surface_primitive_type",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx)});
	}

	public String get_surface_name(long surface_idx) {
		return (String) super.call("get_surface_name", new java.lang.Object[]{java.lang.Long.valueOf(surface_idx)});
	}

	public GodotArray get_surface_arrays(long surface_idx) {
		return (GodotArray) super.call("get_surface_arrays",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx)});
	}

	public GodotArray get_surface_blend_shape_arrays(long surface_idx, long blend_shape_idx) {
		return (GodotArray) super.call("get_surface_blend_shape_arrays",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx), java.lang.Long.valueOf(blend_shape_idx)});
	}

	public int get_surface_lod_count(long surface_idx) {
		return (int) super.call("get_surface_lod_count", new java.lang.Object[]{java.lang.Long.valueOf(surface_idx)});
	}

	public double get_surface_lod_size(long surface_idx, long lod_idx) {
		return (double) super.call("get_surface_lod_size",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx), java.lang.Long.valueOf(lod_idx)});
	}

	public int[] get_surface_lod_indices(long surface_idx, long lod_idx) {
		return (int[]) super.call("get_surface_lod_indices",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx), java.lang.Long.valueOf(lod_idx)});
	}

	public Material get_surface_material(long surface_idx) {
		return (Material) super.call("get_surface_material",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx)});
	}

	public java.math.BigInteger get_surface_format(long surface_idx) {
		return (java.math.BigInteger) super.call("get_surface_format",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx)});
	}

	public void set_surface_name(long surface_idx, String name) {
		super.call("set_surface_name",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx), (java.lang.Object) name});
	}

	public void set_surface_material(long surface_idx, Material material) {
		super.call("set_surface_material",
				new java.lang.Object[]{java.lang.Long.valueOf(surface_idx), (java.lang.Object) material});
	}

	public void generate_lods(double normal_merge_angle, double normal_split_angle, GodotArray bone_transform_array) {
		super.call("generate_lods", new java.lang.Object[]{java.lang.Double.valueOf(normal_merge_angle),
				java.lang.Double.valueOf(normal_split_angle), (java.lang.Object) bone_transform_array});
	}

	public ArrayMesh get_mesh(ArrayMesh base_mesh) {
		return (ArrayMesh) super.call("get_mesh", new java.lang.Object[]{(java.lang.Object) base_mesh});
	}

	public ImporterMesh from_mesh(Mesh mesh) {
		return (ImporterMesh) super.call("from_mesh", new java.lang.Object[]{(java.lang.Object) mesh});
	}

	public void clear() {
		super.call("clear");
	}
}
