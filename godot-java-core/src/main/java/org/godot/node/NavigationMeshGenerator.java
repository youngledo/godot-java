package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;

public class NavigationMeshGenerator extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("parse_source_geometry_data", 3172802542L), java.util.Map.entry("bake", 1401173477L),
			java.util.Map.entry("clear", 2923361153L),
			java.util.Map.entry("bake_from_source_geometry_data", 1286748856L));

	NavigationMeshGenerator(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationMeshGenerator(long nativePointer) {
		super(nativePointer);
	}

	public void bake(NavigationMesh navigation_mesh, Node root_node) {
		super.call("bake", new java.lang.Object[]{(java.lang.Object) navigation_mesh, (java.lang.Object) root_node});
	}

	public void clear(NavigationMesh navigation_mesh) {
		super.call("clear", new java.lang.Object[]{(java.lang.Object) navigation_mesh});
	}

	public void parse_source_geometry_data(NavigationMesh navigation_mesh,
			NavigationMeshSourceGeometryData3D source_geometry_data, Node root_node, Callable callback) {
		super.call("parse_source_geometry_data", new java.lang.Object[]{(java.lang.Object) navigation_mesh,
				(java.lang.Object) source_geometry_data, (java.lang.Object) root_node, (java.lang.Object) callback});
	}

	public void bake_from_source_geometry_data(NavigationMesh navigation_mesh,
			NavigationMeshSourceGeometryData3D source_geometry_data, Callable callback) {
		super.call("bake_from_source_geometry_data", new java.lang.Object[]{(java.lang.Object) navigation_mesh,
				(java.lang.Object) source_geometry_data, (java.lang.Object) callback});
	}
}
