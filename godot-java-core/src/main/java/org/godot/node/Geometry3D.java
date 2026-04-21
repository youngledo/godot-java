package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.math.Plane;
import org.godot.math.Vector3;

public class Geometry3D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("segment_intersects_sphere", 4080141172L),
			java.util.Map.entry("get_closest_points_between_segments", 1056373962L),
			java.util.Map.entry("segment_intersects_triangle", 1718655448L),
			java.util.Map.entry("build_cylinder_planes", 449920067L),
			java.util.Map.entry("ray_intersects_triangle", 1718655448L),
			java.util.Map.entry("compute_convex_mesh_points", 1936902142L),
			java.util.Map.entry("get_triangle_barycentric_coords", 1362048029L),
			java.util.Map.entry("tetrahedralize_delaunay", 1230191221L),
			java.util.Map.entry("segment_intersects_convex", 537425332L),
			java.util.Map.entry("get_closest_point_to_segment", 2168193209L),
			java.util.Map.entry("get_closest_point_to_segment_uncapped", 2168193209L),
			java.util.Map.entry("build_capsule_planes", 2113592876L), java.util.Map.entry("clip_polygon", 2603188319L),
			java.util.Map.entry("build_box_planes", 3622277145L),
			java.util.Map.entry("segment_intersects_cylinder", 2361316491L));

	Geometry3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Geometry3D(long nativePointer) {
		super(nativePointer);
	}

	public double[][] compute_convex_mesh_points(Plane[] planes) {
		return (double[][]) super.call("compute_convex_mesh_points", new java.lang.Object[]{(java.lang.Object) planes});
	}

	public Plane[] build_box_planes(Vector3 extents) {
		return (Plane[]) super.call("build_box_planes", new java.lang.Object[]{(java.lang.Object) extents});
	}

	public Plane[] build_cylinder_planes(double radius, double height, long sides, int axis) {
		return (Plane[]) super.call("build_cylinder_planes", new java.lang.Object[]{java.lang.Double.valueOf(radius),
				java.lang.Double.valueOf(height), java.lang.Long.valueOf(sides), java.lang.Integer.valueOf(axis)});
	}

	public Plane[] build_capsule_planes(double radius, double height, long sides, long lats, int axis) {
		return (Plane[]) super.call("build_capsule_planes",
				new java.lang.Object[]{java.lang.Double.valueOf(radius), java.lang.Double.valueOf(height),
						java.lang.Long.valueOf(sides), java.lang.Long.valueOf(lats), java.lang.Integer.valueOf(axis)});
	}

	public double[][] get_closest_points_between_segments(Vector3 p1, Vector3 p2, Vector3 q1, Vector3 q2) {
		return (double[][]) super.call("get_closest_points_between_segments", new java.lang.Object[]{
				(java.lang.Object) p1, (java.lang.Object) p2, (java.lang.Object) q1, (java.lang.Object) q2});
	}

	public Vector3 get_closest_point_to_segment(Vector3 point, Vector3 s1, Vector3 s2) {
		return (Vector3) super.call("get_closest_point_to_segment",
				new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) s1, (java.lang.Object) s2});
	}

	public Vector3 get_closest_point_to_segment_uncapped(Vector3 point, Vector3 s1, Vector3 s2) {
		return (Vector3) super.call("get_closest_point_to_segment_uncapped",
				new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) s1, (java.lang.Object) s2});
	}

	public Vector3 get_triangle_barycentric_coords(Vector3 point, Vector3 a, Vector3 b, Vector3 c) {
		return (Vector3) super.call("get_triangle_barycentric_coords", new java.lang.Object[]{(java.lang.Object) point,
				(java.lang.Object) a, (java.lang.Object) b, (java.lang.Object) c});
	}

	public Object ray_intersects_triangle(Vector3 from, Vector3 dir, Vector3 a, Vector3 b, Vector3 c) {
		return (Object) super.call("ray_intersects_triangle", new java.lang.Object[]{(java.lang.Object) from,
				(java.lang.Object) dir, (java.lang.Object) a, (java.lang.Object) b, (java.lang.Object) c});
	}

	public Object segment_intersects_triangle(Vector3 from, Vector3 to, Vector3 a, Vector3 b, Vector3 c) {
		return (Object) super.call("segment_intersects_triangle", new java.lang.Object[]{(java.lang.Object) from,
				(java.lang.Object) to, (java.lang.Object) a, (java.lang.Object) b, (java.lang.Object) c});
	}

	public double[][] segment_intersects_sphere(Vector3 from, Vector3 to, Vector3 sphere_position,
			double sphere_radius) {
		return (double[][]) super.call("segment_intersects_sphere", new java.lang.Object[]{(java.lang.Object) from,
				(java.lang.Object) to, (java.lang.Object) sphere_position, java.lang.Double.valueOf(sphere_radius)});
	}

	public double[][] segment_intersects_cylinder(Vector3 from, Vector3 to, double height, double radius) {
		return (double[][]) super.call("segment_intersects_cylinder", new java.lang.Object[]{(java.lang.Object) from,
				(java.lang.Object) to, java.lang.Double.valueOf(height), java.lang.Double.valueOf(radius)});
	}

	public double[][] segment_intersects_convex(Vector3 from, Vector3 to, Plane[] planes) {
		return (double[][]) super.call("segment_intersects_convex",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to, (java.lang.Object) planes});
	}

	public double[][] clip_polygon(double[][] points, Plane plane) {
		return (double[][]) super.call("clip_polygon",
				new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) plane});
	}

	public int[] tetrahedralize_delaunay(double[][] points) {
		return (int[]) super.call("tetrahedralize_delaunay", new java.lang.Object[]{(java.lang.Object) points});
	}
}
