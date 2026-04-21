package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Plane;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class ImmediateMesh extends Mesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("surface_set_uv2", 743155724L), java.util.Map.entry("surface_set_uv", 743155724L),
			java.util.Map.entry("surface_set_normal", 3460891852L), java.util.Map.entry("surface_begin", 2794442543L),
			java.util.Map.entry("surface_set_tangent", 3505987427L),
			java.util.Map.entry("surface_add_vertex_2d", 743155724L),
			java.util.Map.entry("clear_surfaces", 3218959716L), java.util.Map.entry("surface_set_color", 2920490490L),
			java.util.Map.entry("surface_add_vertex", 3460891852L), java.util.Map.entry("surface_end", 3218959716L));

	ImmediateMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ImmediateMesh(long nativePointer) {
		super(nativePointer);
	}

	public void surface_begin(int primitive, Material material) {
		super.call("surface_begin",
				new java.lang.Object[]{java.lang.Integer.valueOf(primitive), (java.lang.Object) material});
	}

	public void surface_set_color(Color color) {
		super.call("surface_set_color", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void surface_set_normal(Vector3 normal) {
		super.call("surface_set_normal", new java.lang.Object[]{(java.lang.Object) normal});
	}

	public void surface_set_tangent(Plane tangent) {
		super.call("surface_set_tangent", new java.lang.Object[]{(java.lang.Object) tangent});
	}

	public void surface_set_uv(Vector2 uv) {
		super.call("surface_set_uv", new java.lang.Object[]{(java.lang.Object) uv});
	}

	public void surface_set_uv2(Vector2 uv2) {
		super.call("surface_set_uv2", new java.lang.Object[]{(java.lang.Object) uv2});
	}

	public void surface_add_vertex(Vector3 vertex) {
		super.call("surface_add_vertex", new java.lang.Object[]{(java.lang.Object) vertex});
	}

	public void surface_add_vertex_2d(Vector2 vertex) {
		super.call("surface_add_vertex_2d", new java.lang.Object[]{(java.lang.Object) vertex});
	}

	public void surface_end() {
		super.call("surface_end");
	}

	public void clear_surfaces() {
		super.call("clear_surfaces");
	}
}
