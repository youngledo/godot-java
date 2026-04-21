package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector2;

public class PhysicsDirectSpaceState2D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("intersect_point", 2118456068L), java.util.Map.entry("collide_shape", 2488867228L),
			java.util.Map.entry("intersect_ray", 1590275562L), java.util.Map.entry("get_rest_info", 2803666496L),
			java.util.Map.entry("cast_motion", 711275086L), java.util.Map.entry("intersect_shape", 2488867228L));

	PhysicsDirectSpaceState2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsDirectSpaceState2D(long nativePointer) {
		super(nativePointer);
	}

	public GodotDictionary[] intersect_point(PhysicsPointQueryParameters2D parameters, long max_results) {
		return (GodotDictionary[]) super.call("intersect_point",
				new java.lang.Object[]{(java.lang.Object) parameters, java.lang.Long.valueOf(max_results)});
	}

	public GodotDictionary intersect_ray(PhysicsRayQueryParameters2D parameters) {
		return (GodotDictionary) super.call("intersect_ray", new java.lang.Object[]{(java.lang.Object) parameters});
	}

	public GodotDictionary[] intersect_shape(PhysicsShapeQueryParameters2D parameters, long max_results) {
		return (GodotDictionary[]) super.call("intersect_shape",
				new java.lang.Object[]{(java.lang.Object) parameters, java.lang.Long.valueOf(max_results)});
	}

	public double[] cast_motion(PhysicsShapeQueryParameters2D parameters) {
		return (double[]) super.call("cast_motion", new java.lang.Object[]{(java.lang.Object) parameters});
	}

	public Vector2[] collide_shape(PhysicsShapeQueryParameters2D parameters, long max_results) {
		return (Vector2[]) super.call("collide_shape",
				new java.lang.Object[]{(java.lang.Object) parameters, java.lang.Long.valueOf(max_results)});
	}

	public GodotDictionary get_rest_info(PhysicsShapeQueryParameters2D parameters) {
		return (GodotDictionary) super.call("get_rest_info", new java.lang.Object[]{(java.lang.Object) parameters});
	}
}
