package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class Geometry2D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("segment_intersects_segment", 2058025344L),
			java.util.Map.entry("get_closest_points_between_segments", 3344690961L),
			java.util.Map.entry("is_polygon_clockwise", 1361156557L),
			java.util.Map.entry("offset_polyline", 2328231778L), java.util.Map.entry("clip_polygons", 3637387053L),
			java.util.Map.entry("triangulate_polygon", 1389921771L), java.util.Map.entry("convex_hull", 2004331998L),
			java.util.Map.entry("make_atlas", 1337682371L), java.util.Map.entry("is_point_in_polygon", 738277916L),
			java.util.Map.entry("segment_intersects_circle", 1356928167L),
			java.util.Map.entry("exclude_polygons", 3637387053L),
			java.util.Map.entry("triangulate_delaunay", 1389921771L),
			java.util.Map.entry("decompose_polygon_in_convex", 3982393695L),
			java.util.Map.entry("line_intersects_line", 2058025344L),
			java.util.Map.entry("point_is_inside_triangle", 1025948137L),
			java.util.Map.entry("offset_polygon", 1275354010L), java.util.Map.entry("is_point_in_circle", 2929491703L),
			java.util.Map.entry("get_closest_point_to_segment", 4172901909L),
			java.util.Map.entry("get_closest_point_to_segment_uncapped", 4172901909L),
			java.util.Map.entry("intersect_polygons", 3637387053L),
			java.util.Map.entry("clip_polyline_with_polygon", 3637387053L),
			java.util.Map.entry("intersect_polyline_with_polygon", 3637387053L),
			java.util.Map.entry("merge_polygons", 3637387053L), java.util.Map.entry("bresenham_line", 1989391000L));

	Geometry2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Geometry2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_point_in_circle(Vector2 point, Vector2 circle_position, double circle_radius) {
		return (boolean) super.call("is_point_in_circle", new java.lang.Object[]{(java.lang.Object) point,
				(java.lang.Object) circle_position, java.lang.Double.valueOf(circle_radius)});
	}

	public double segment_intersects_circle(Vector2 segment_from, Vector2 segment_to, Vector2 circle_position,
			double circle_radius) {
		return (double) super.call("segment_intersects_circle",
				new java.lang.Object[]{(java.lang.Object) segment_from, (java.lang.Object) segment_to,
						(java.lang.Object) circle_position, java.lang.Double.valueOf(circle_radius)});
	}

	public Object segment_intersects_segment(Vector2 from_a, Vector2 to_a, Vector2 from_b, Vector2 to_b) {
		return (Object) super.call("segment_intersects_segment", new java.lang.Object[]{(java.lang.Object) from_a,
				(java.lang.Object) to_a, (java.lang.Object) from_b, (java.lang.Object) to_b});
	}

	public Object line_intersects_line(Vector2 from_a, Vector2 dir_a, Vector2 from_b, Vector2 dir_b) {
		return (Object) super.call("line_intersects_line", new java.lang.Object[]{(java.lang.Object) from_a,
				(java.lang.Object) dir_a, (java.lang.Object) from_b, (java.lang.Object) dir_b});
	}

	public double[][] get_closest_points_between_segments(Vector2 p1, Vector2 q1, Vector2 p2, Vector2 q2) {
		return (double[][]) super.call("get_closest_points_between_segments", new java.lang.Object[]{
				(java.lang.Object) p1, (java.lang.Object) q1, (java.lang.Object) p2, (java.lang.Object) q2});
	}

	public Vector2 get_closest_point_to_segment(Vector2 point, Vector2 s1, Vector2 s2) {
		return (Vector2) super.call("get_closest_point_to_segment",
				new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) s1, (java.lang.Object) s2});
	}

	public Vector2 get_closest_point_to_segment_uncapped(Vector2 point, Vector2 s1, Vector2 s2) {
		return (Vector2) super.call("get_closest_point_to_segment_uncapped",
				new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) s1, (java.lang.Object) s2});
	}

	public boolean point_is_inside_triangle(Vector2 point, Vector2 a, Vector2 b, Vector2 c) {
		return (boolean) super.call("point_is_inside_triangle", new java.lang.Object[]{(java.lang.Object) point,
				(java.lang.Object) a, (java.lang.Object) b, (java.lang.Object) c});
	}

	public boolean is_polygon_clockwise(double[][] polygon) {
		return (boolean) super.call("is_polygon_clockwise", new java.lang.Object[]{(java.lang.Object) polygon});
	}

	public boolean is_point_in_polygon(Vector2 point, double[][] polygon) {
		return (boolean) super.call("is_point_in_polygon",
				new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) polygon});
	}

	public int[] triangulate_polygon(double[][] polygon) {
		return (int[]) super.call("triangulate_polygon", new java.lang.Object[]{(java.lang.Object) polygon});
	}

	public int[] triangulate_delaunay(double[][] points) {
		return (int[]) super.call("triangulate_delaunay", new java.lang.Object[]{(java.lang.Object) points});
	}

	public double[][] convex_hull(double[][] points) {
		return (double[][]) super.call("convex_hull", new java.lang.Object[]{(java.lang.Object) points});
	}

	public Object[] decompose_polygon_in_convex(double[][] polygon) {
		return (Object[]) super.call("decompose_polygon_in_convex", new java.lang.Object[]{(java.lang.Object) polygon});
	}

	public Object[] merge_polygons(double[][] polygon_a, double[][] polygon_b) {
		return (Object[]) super.call("merge_polygons",
				new java.lang.Object[]{(java.lang.Object) polygon_a, (java.lang.Object) polygon_b});
	}

	public Object[] clip_polygons(double[][] polygon_a, double[][] polygon_b) {
		return (Object[]) super.call("clip_polygons",
				new java.lang.Object[]{(java.lang.Object) polygon_a, (java.lang.Object) polygon_b});
	}

	public Object[] intersect_polygons(double[][] polygon_a, double[][] polygon_b) {
		return (Object[]) super.call("intersect_polygons",
				new java.lang.Object[]{(java.lang.Object) polygon_a, (java.lang.Object) polygon_b});
	}

	public Object[] exclude_polygons(double[][] polygon_a, double[][] polygon_b) {
		return (Object[]) super.call("exclude_polygons",
				new java.lang.Object[]{(java.lang.Object) polygon_a, (java.lang.Object) polygon_b});
	}

	public Object[] clip_polyline_with_polygon(double[][] polyline, double[][] polygon) {
		return (Object[]) super.call("clip_polyline_with_polygon",
				new java.lang.Object[]{(java.lang.Object) polyline, (java.lang.Object) polygon});
	}

	public Object[] intersect_polyline_with_polygon(double[][] polyline, double[][] polygon) {
		return (Object[]) super.call("intersect_polyline_with_polygon",
				new java.lang.Object[]{(java.lang.Object) polyline, (java.lang.Object) polygon});
	}

	public Object[] offset_polygon(double[][] polygon, double delta, int join_type) {
		return (Object[]) super.call("offset_polygon", new java.lang.Object[]{(java.lang.Object) polygon,
				java.lang.Double.valueOf(delta), java.lang.Integer.valueOf(join_type)});
	}

	public Object[] offset_polyline(double[][] polyline, double delta, int join_type, int end_type) {
		return (Object[]) super.call("offset_polyline",
				new java.lang.Object[]{(java.lang.Object) polyline, java.lang.Double.valueOf(delta),
						java.lang.Integer.valueOf(join_type), java.lang.Integer.valueOf(end_type)});
	}

	public GodotDictionary make_atlas(double[][] sizes) {
		return (GodotDictionary) super.call("make_atlas", new java.lang.Object[]{(java.lang.Object) sizes});
	}

	public Vector2i[] bresenham_line(Vector2i from, Vector2i to) {
		return (Vector2i[]) super.call("bresenham_line",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}
}
