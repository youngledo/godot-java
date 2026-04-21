package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector3;

public class PhysicsDirectSpaceState3D extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("intersect_point", 975173756L), java.util.Map.entry("collide_shape", 3762137681L),
			java.util.Map.entry("intersect_ray", 3957970750L), java.util.Map.entry("get_rest_info", 1376751592L),
			java.util.Map.entry("cast_motion", 1778757334L), java.util.Map.entry("intersect_shape", 3762137681L));

	PhysicsDirectSpaceState3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsDirectSpaceState3D(long nativePointer) {
		super(nativePointer);
	}

	public GodotDictionary[] intersect_point(PhysicsPointQueryParameters3D parameters, long max_results) {
		return (GodotDictionary[]) super.call("intersect_point",
				new java.lang.Object[]{(java.lang.Object) parameters, java.lang.Long.valueOf(max_results)});
	}

	public GodotDictionary intersect_ray(PhysicsRayQueryParameters3D parameters) {
		return (GodotDictionary) super.call("intersect_ray", new java.lang.Object[]{(java.lang.Object) parameters});
	}

	public GodotDictionary[] intersect_shape(PhysicsShapeQueryParameters3D parameters, long max_results) {
		return (GodotDictionary[]) super.call("intersect_shape",
				new java.lang.Object[]{(java.lang.Object) parameters, java.lang.Long.valueOf(max_results)});
	}

	public double[] cast_motion(PhysicsShapeQueryParameters3D parameters) {
		return (double[]) super.call("cast_motion", new java.lang.Object[]{(java.lang.Object) parameters});
	}

	public Vector3[] collide_shape(PhysicsShapeQueryParameters3D parameters, long max_results) {
		return (Vector3[]) super.call("collide_shape",
				new java.lang.Object[]{(java.lang.Object) parameters, java.lang.Long.valueOf(max_results)});
	}

	public GodotDictionary get_rest_info(PhysicsShapeQueryParameters3D parameters) {
		return (GodotDictionary) super.call("get_rest_info", new java.lang.Object[]{(java.lang.Object) parameters});
	}
}
