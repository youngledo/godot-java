package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Vector2i;

public class Mesh extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_aabb", 1068685055L), java.util.Map.entry("create_trimesh_shape", 4160111210L),
			java.util.Map.entry("generate_triangle_mesh", 3476533166L),
			java.util.Map.entry("create_convex_shape", 2529984628L),
			java.util.Map.entry("surface_get_material", 2897466400L),
			java.util.Map.entry("surface_get_arrays", 663333327L),
			java.util.Map.entry("get_lightmap_size_hint", 3690982128L),
			java.util.Map.entry("surface_set_material", 3671737478L),
			java.util.Map.entry("set_lightmap_size_hint", 1130785943L),
			java.util.Map.entry("surface_get_blend_shape_arrays", 663333327L),
			java.util.Map.entry("get_faces", 497664490L), java.util.Map.entry("create_placeholder", 121922552L),
			java.util.Map.entry("get_surface_count", 3905245786L), java.util.Map.entry("create_outline", 1208642001L));

	Mesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Mesh(long nativePointer) {
		super(nativePointer);
	}

	public GodotArray surface_get_arrays(long surf_idx) {
		return (GodotArray) super.call("surface_get_arrays", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public GodotArray[] surface_get_blend_shape_arrays(long surf_idx) {
		return (GodotArray[]) super.call("surface_get_blend_shape_arrays",
				new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public void surface_set_material(long surf_idx, Material material) {
		super.call("surface_set_material",
				new java.lang.Object[]{java.lang.Long.valueOf(surf_idx), (java.lang.Object) material});
	}

	public Material surface_get_material(long surf_idx) {
		return (Material) super.call("surface_get_material", new java.lang.Object[]{java.lang.Long.valueOf(surf_idx)});
	}

	public Resource create_placeholder() {
		return (Resource) super.call("create_placeholder");
	}

	public ConcavePolygonShape3D create_trimesh_shape() {
		return (ConcavePolygonShape3D) super.call("create_trimesh_shape");
	}

	public ConvexPolygonShape3D create_convex_shape(boolean clean, boolean simplify) {
		return (ConvexPolygonShape3D) super.call("create_convex_shape",
				new java.lang.Object[]{java.lang.Boolean.valueOf(clean), java.lang.Boolean.valueOf(simplify)});
	}

	public Mesh create_outline(double margin) {
		return (Mesh) super.call("create_outline", new java.lang.Object[]{java.lang.Double.valueOf(margin)});
	}

	public TriangleMesh generate_triangle_mesh() {
		return (TriangleMesh) super.call("generate_triangle_mesh");
	}

	public Vector2i getLightmap_size_hint() {
		return (Vector2i) super.call("get_lightmap_size_hint", new java.lang.Object[0]);
	}

	public void setLightmap_size_hint(Vector2i value) {
		super.call("set_lightmap_size_hint", new java.lang.Object[]{(java.lang.Object) value});
	}
}
