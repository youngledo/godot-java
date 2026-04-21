package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Color;
import org.godot.math.Plane;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class MeshDataTool extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_vertex_uv2", 2299179447L), java.util.Map.entry("commit_to_surface", 2021686445L),
			java.util.Map.entry("get_material", 5934680L), java.util.Map.entry("get_vertex_count", 3905245786L),
			java.util.Map.entry("get_vertex_normal", 711720468L), java.util.Map.entry("get_vertex", 711720468L),
			java.util.Map.entry("set_vertex_tangent", 1104099133L), java.util.Map.entry("set_vertex_uv", 163021252L),
			java.util.Map.entry("set_vertex_color", 2878471219L), java.util.Map.entry("set_vertex_bones", 3500328261L),
			java.util.Map.entry("get_edge_meta", 4227898402L), java.util.Map.entry("get_edge_vertex", 3175239445L),
			java.util.Map.entry("get_vertex_edges", 1706082319L), java.util.Map.entry("get_vertex_meta", 4227898402L),
			java.util.Map.entry("set_vertex_uv2", 163021252L), java.util.Map.entry("set_edge_meta", 2152698145L),
			java.util.Map.entry("create_from_surface", 2727020678L), java.util.Map.entry("get_face_count", 3905245786L),
			java.util.Map.entry("get_vertex_uv", 2299179447L), java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("get_format", 3905245786L), java.util.Map.entry("get_edge_count", 3905245786L),
			java.util.Map.entry("get_face_edge", 3175239445L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("get_vertex_color", 3457211756L), java.util.Map.entry("set_vertex_meta", 2152698145L),
			java.util.Map.entry("get_edge_faces", 1706082319L), java.util.Map.entry("get_face_meta", 4227898402L),
			java.util.Map.entry("get_vertex_tangent", 1372055458L), java.util.Map.entry("get_face_normal", 711720468L),
			java.util.Map.entry("get_vertex_weights", 1542882410L), java.util.Map.entry("set_face_meta", 2152698145L),
			java.util.Map.entry("set_vertex_weights", 1345852415L),
			java.util.Map.entry("get_vertex_bones", 1706082319L), java.util.Map.entry("set_vertex", 1530502735L),
			java.util.Map.entry("set_vertex_normal", 1530502735L), java.util.Map.entry("get_face_vertex", 3175239445L),
			java.util.Map.entry("get_vertex_faces", 1706082319L));

	MeshDataTool(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MeshDataTool(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public int create_from_surface(ArrayMesh mesh, long surface) {
		return (int) super.call("create_from_surface",
				new java.lang.Object[]{(java.lang.Object) mesh, java.lang.Long.valueOf(surface)});
	}

	public int commit_to_surface(ArrayMesh mesh, long compression_flags) {
		return (int) super.call("commit_to_surface",
				new java.lang.Object[]{(java.lang.Object) mesh, java.lang.Long.valueOf(compression_flags)});
	}

	public void set_vertex(long idx, Vector3 vertex) {
		super.call("set_vertex", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) vertex});
	}

	public Vector3 get_vertex(long idx) {
		return (Vector3) super.call("get_vertex", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_normal(long idx, Vector3 normal) {
		super.call("set_vertex_normal", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) normal});
	}

	public Vector3 get_vertex_normal(long idx) {
		return (Vector3) super.call("get_vertex_normal", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_tangent(long idx, Plane tangent) {
		super.call("set_vertex_tangent",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) tangent});
	}

	public Plane get_vertex_tangent(long idx) {
		return (Plane) super.call("get_vertex_tangent", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_uv(long idx, Vector2 uv) {
		super.call("set_vertex_uv", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) uv});
	}

	public Vector2 get_vertex_uv(long idx) {
		return (Vector2) super.call("get_vertex_uv", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_uv2(long idx, Vector2 uv2) {
		super.call("set_vertex_uv2", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) uv2});
	}

	public Vector2 get_vertex_uv2(long idx) {
		return (Vector2) super.call("get_vertex_uv2", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_color(long idx, Color color) {
		super.call("set_vertex_color", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) color});
	}

	public Color get_vertex_color(long idx) {
		return (Color) super.call("get_vertex_color", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_bones(long idx, int[] bones) {
		super.call("set_vertex_bones", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) bones});
	}

	public int[] get_vertex_bones(long idx) {
		return (int[]) super.call("get_vertex_bones", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_weights(long idx, double[] weights) {
		super.call("set_vertex_weights",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) weights});
	}

	public double[] get_vertex_weights(long idx) {
		return (double[]) super.call("get_vertex_weights", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_vertex_meta(long idx, Object meta) {
		super.call("set_vertex_meta", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) meta});
	}

	public Object get_vertex_meta(long idx) {
		return (Object) super.call("get_vertex_meta", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int[] get_vertex_edges(long idx) {
		return (int[]) super.call("get_vertex_edges", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int[] get_vertex_faces(long idx) {
		return (int[]) super.call("get_vertex_faces", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_edge_vertex(long idx, long vertex) {
		return (int) super.call("get_edge_vertex",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Long.valueOf(vertex)});
	}

	public int[] get_edge_faces(long idx) {
		return (int[]) super.call("get_edge_faces", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void set_edge_meta(long idx, Object meta) {
		super.call("set_edge_meta", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) meta});
	}

	public Object get_edge_meta(long idx) {
		return (Object) super.call("get_edge_meta", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_face_vertex(long idx, long vertex) {
		return (int) super.call("get_face_vertex",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Long.valueOf(vertex)});
	}

	public int get_face_edge(long idx, long edge) {
		return (int) super.call("get_face_edge",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Long.valueOf(edge)});
	}

	public void set_face_meta(long idx, Object meta) {
		super.call("set_face_meta", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) meta});
	}

	public Object get_face_meta(long idx) {
		return (Object) super.call("get_face_meta", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public Vector3 get_face_normal(long idx) {
		return (Vector3) super.call("get_face_normal", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}
}
