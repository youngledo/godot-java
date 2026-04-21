package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Transform3D;

public class EditorNode3DGizmo extends Node3DGizmo {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_subgizmo_selected", 1116898809L), java.util.Map.entry("add_handles", 2254560097L),
			java.util.Map.entry("set_hidden", 2586408642L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("add_unscaled_billboard", 520007164L),
			java.util.Map.entry("add_collision_segments", 334873810L), java.util.Map.entry("get_plugin", 4250544552L),
			java.util.Map.entry("get_node_3d", 151077316L), java.util.Map.entry("add_lines", 2910971437L),
			java.util.Map.entry("add_collision_triangles", 54901064L), java.util.Map.entry("add_mesh", 1579955111L),
			java.util.Map.entry("set_node_3d", 1078189570L),
			java.util.Map.entry("get_subgizmo_selection", 1930428628L));

	EditorNode3DGizmo(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorNode3DGizmo(long nativePointer) {
		super(nativePointer);
	}

	public void add_lines(double[][] lines, Material material, boolean billboard, Color modulate) {
		super.call("add_lines", new java.lang.Object[]{(java.lang.Object) lines, (java.lang.Object) material,
				java.lang.Boolean.valueOf(billboard), (java.lang.Object) modulate});
	}

	public void add_mesh(Mesh mesh, Material material, Transform3D transform, SkinReference skeleton) {
		super.call("add_mesh", new java.lang.Object[]{(java.lang.Object) mesh, (java.lang.Object) material,
				(java.lang.Object) transform, (java.lang.Object) skeleton});
	}

	public void add_collision_segments(double[][] segments) {
		super.call("add_collision_segments", new java.lang.Object[]{(java.lang.Object) segments});
	}

	public void add_collision_triangles(TriangleMesh triangles) {
		super.call("add_collision_triangles", new java.lang.Object[]{(java.lang.Object) triangles});
	}

	public void add_unscaled_billboard(Material material, double default_scale, Color modulate) {
		super.call("add_unscaled_billboard", new java.lang.Object[]{(java.lang.Object) material,
				java.lang.Double.valueOf(default_scale), (java.lang.Object) modulate});
	}

	public void add_handles(double[][] handles, Material material, int[] ids, boolean billboard, boolean secondary) {
		super.call("add_handles", new java.lang.Object[]{(java.lang.Object) handles, (java.lang.Object) material,
				(java.lang.Object) ids, java.lang.Boolean.valueOf(billboard), java.lang.Boolean.valueOf(secondary)});
	}

	public void clear() {
		super.call("clear");
	}

	public boolean is_subgizmo_selected(long id) {
		return (boolean) super.call("is_subgizmo_selected", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}
}
