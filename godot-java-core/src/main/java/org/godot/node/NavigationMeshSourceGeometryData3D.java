package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Transform3D;

public class NavigationMeshSourceGeometryData3D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_faces", 1440358797L), java.util.Map.entry("set_vertices", 2899603908L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("clear_projected_obstructions", 3218959716L),
			java.util.Map.entry("append_arrays", 3117535015L), java.util.Map.entry("get_bounds", 1021181044L),
			java.util.Map.entry("get_projected_obstructions", 3995934104L),
			java.util.Map.entry("has_data", 2240911060L), java.util.Map.entry("add_mesh_array", 4235710913L),
			java.util.Map.entry("set_projected_obstructions", 381264803L),
			java.util.Map.entry("set_indices", 3614634198L), java.util.Map.entry("merge", 655828145L),
			java.util.Map.entry("add_mesh", 975462459L), java.util.Map.entry("get_indices", 1930428628L),
			java.util.Map.entry("add_projected_obstruction", 3351846707L),
			java.util.Map.entry("get_vertices", 675695659L));

	NavigationMeshSourceGeometryData3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationMeshSourceGeometryData3D(long nativePointer) {
		super(nativePointer);
	}

	public void append_arrays(double[] vertices, int[] indices) {
		super.call("append_arrays", new java.lang.Object[]{(java.lang.Object) vertices, (java.lang.Object) indices});
	}

	public void clear() {
		super.call("clear");
	}

	public boolean has_data() {
		return (boolean) super.call("has_data");
	}

	public void add_mesh(Mesh mesh, Transform3D xform) {
		super.call("add_mesh", new java.lang.Object[]{(java.lang.Object) mesh, (java.lang.Object) xform});
	}

	public void add_mesh_array(GodotArray mesh_array, Transform3D xform) {
		super.call("add_mesh_array", new java.lang.Object[]{(java.lang.Object) mesh_array, (java.lang.Object) xform});
	}

	public void add_faces(double[][] faces, Transform3D xform) {
		super.call("add_faces", new java.lang.Object[]{(java.lang.Object) faces, (java.lang.Object) xform});
	}

	public void merge(NavigationMeshSourceGeometryData3D other_geometry) {
		super.call("merge", new java.lang.Object[]{(java.lang.Object) other_geometry});
	}

	public void add_projected_obstruction(double[][] vertices, double elevation, double height, boolean carve) {
		super.call("add_projected_obstruction",
				new java.lang.Object[]{(java.lang.Object) vertices, java.lang.Double.valueOf(elevation),
						java.lang.Double.valueOf(height), java.lang.Boolean.valueOf(carve)});
	}

	public void clear_projected_obstructions() {
		super.call("clear_projected_obstructions");
	}

	public double[][] getVertices() {
		return (double[][]) super.call("get_vertices", new java.lang.Object[0]);
	}

	public void setVertices(double[][] value) {
		super.call("set_vertices", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getIndices() {
		return (int[]) super.call("get_indices", new java.lang.Object[0]);
	}

	public void setIndices(int[] value) {
		super.call("set_indices", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getProjected_obstructions() {
		return (GodotArray) super.call("get_projected_obstructions", new java.lang.Object[0]);
	}

	public void setProjected_obstructions(GodotArray value) {
		super.call("set_projected_obstructions", new java.lang.Object[]{(java.lang.Object) value});
	}
}
