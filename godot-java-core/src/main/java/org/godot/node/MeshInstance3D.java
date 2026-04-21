package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MeshInstance3D extends GeometryInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_active_material", 2897466400L),
			java.util.Map.entry("find_blend_shape_by_name", 4150868206L),
			java.util.Map.entry("create_convex_collision", 2751962654L), java.util.Map.entry("set_skin", 3971435618L),
			java.util.Map.entry("get_surface_override_material_count", 3905245786L),
			java.util.Map.entry("set_surface_override_material", 3671737478L),
			java.util.Map.entry("get_skin_reference", 2060603409L),
			java.util.Map.entry("bake_mesh_from_current_skeleton_pose", 1457573577L),
			java.util.Map.entry("create_multiple_convex_collisions", 628789669L),
			java.util.Map.entry("bake_mesh_from_current_blend_shape_mix", 1457573577L),
			java.util.Map.entry("set_mesh", 194775623L), java.util.Map.entry("create_debug_tangents", 3218959716L),
			java.util.Map.entry("get_skin", 2074563878L), java.util.Map.entry("create_trimesh_collision", 3218959716L),
			java.util.Map.entry("get_mesh", 1808005922L), java.util.Map.entry("get_blend_shape_value", 2339986948L),
			java.util.Map.entry("set_blend_shape_value", 1602489585L),
			java.util.Map.entry("get_blend_shape_count", 3905245786L),
			java.util.Map.entry("set_skeleton_path", 1348162250L),
			java.util.Map.entry("get_surface_override_material", 2897466400L),
			java.util.Map.entry("get_skeleton_path", 277076166L));

	MeshInstance3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MeshInstance3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_surface_override_material(long surface, Material material) {
		super.call("set_surface_override_material",
				new java.lang.Object[]{java.lang.Long.valueOf(surface), (java.lang.Object) material});
	}

	public Material get_surface_override_material(long surface) {
		return (Material) super.call("get_surface_override_material",
				new java.lang.Object[]{java.lang.Long.valueOf(surface)});
	}

	public Material get_active_material(long surface) {
		return (Material) super.call("get_active_material", new java.lang.Object[]{java.lang.Long.valueOf(surface)});
	}

	public void create_trimesh_collision() {
		super.call("create_trimesh_collision");
	}

	public void create_convex_collision(boolean clean, boolean simplify) {
		super.call("create_convex_collision",
				new java.lang.Object[]{java.lang.Boolean.valueOf(clean), java.lang.Boolean.valueOf(simplify)});
	}

	public void create_multiple_convex_collisions(MeshConvexDecompositionSettings settings) {
		super.call("create_multiple_convex_collisions", new java.lang.Object[]{(java.lang.Object) settings});
	}

	public int find_blend_shape_by_name(String name) {
		return (int) super.call("find_blend_shape_by_name", new java.lang.Object[]{(java.lang.Object) name});
	}

	public double get_blend_shape_value(long blend_shape_idx) {
		return (double) super.call("get_blend_shape_value",
				new java.lang.Object[]{java.lang.Long.valueOf(blend_shape_idx)});
	}

	public void set_blend_shape_value(long blend_shape_idx, double value) {
		super.call("set_blend_shape_value",
				new java.lang.Object[]{java.lang.Long.valueOf(blend_shape_idx), java.lang.Double.valueOf(value)});
	}

	public void create_debug_tangents() {
		super.call("create_debug_tangents");
	}

	public ArrayMesh bake_mesh_from_current_blend_shape_mix(ArrayMesh existing) {
		return (ArrayMesh) super.call("bake_mesh_from_current_blend_shape_mix",
				new java.lang.Object[]{(java.lang.Object) existing});
	}

	public ArrayMesh bake_mesh_from_current_skeleton_pose(ArrayMesh existing) {
		return (ArrayMesh) super.call("bake_mesh_from_current_skeleton_pose",
				new java.lang.Object[]{(java.lang.Object) existing});
	}

	public Mesh getMesh() {
		return (Mesh) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(Mesh value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Skin getSkin() {
		return (Skin) super.call("get_skin", new java.lang.Object[0]);
	}

	public void setSkin(Skin value) {
		super.call("set_skin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSkeleton() {
		return (String) super.call("get_skeleton_path", new java.lang.Object[0]);
	}

	public void setSkeleton(String value) {
		super.call("set_skeleton_path", new java.lang.Object[]{(java.lang.Object) value});
	}
}
