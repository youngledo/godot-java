package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector2;

public class PolygonPathFinder extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_point_inside", 556197845L), java.util.Map.entry("get_intersections", 3932192302L),
			java.util.Map.entry("get_point_penalty", 2339986948L),
			java.util.Map.entry("get_closest_point", 2656412154L),
			java.util.Map.entry("set_point_penalty", 1602489585L), java.util.Map.entry("setup", 3251786936L),
			java.util.Map.entry("find_path", 1562168077L), java.util.Map.entry("get_bounds", 1639390495L));

	PolygonPathFinder(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PolygonPathFinder(long nativePointer) {
		super(nativePointer);
	}

	public void setup(double[][] points, int[] connections) {
		super.call("setup", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) connections});
	}

	public double[][] find_path(Vector2 from, Vector2 to) {
		return (double[][]) super.call("find_path",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}

	public double[][] get_intersections(Vector2 from, Vector2 to) {
		return (double[][]) super.call("get_intersections",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}

	public Vector2 get_closest_point(Vector2 point) {
		return (Vector2) super.call("get_closest_point", new java.lang.Object[]{(java.lang.Object) point});
	}

	public boolean is_point_inside(Vector2 point) {
		return (boolean) super.call("is_point_inside", new java.lang.Object[]{(java.lang.Object) point});
	}

	public void set_point_penalty(long idx, double penalty) {
		super.call("set_point_penalty",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Double.valueOf(penalty)});
	}

	public double get_point_penalty(long idx) {
		return (double) super.call("get_point_penalty", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public GodotDictionary getData() {
		return (GodotDictionary) super.call("_get_data", new java.lang.Object[0]);
	}

	public void setData(GodotDictionary value) {
		super.call("_set_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
