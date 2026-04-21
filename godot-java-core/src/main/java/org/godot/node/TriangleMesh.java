package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;
import org.godot.math.Vector3;

public class TriangleMesh extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_faces", 497664490L), java.util.Map.entry("create_from_faces", 2637816732L),
			java.util.Map.entry("intersect_segment", 3648293151L), java.util.Map.entry("intersect_ray", 3648293151L));

	TriangleMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TriangleMesh(long nativePointer) {
		super(nativePointer);
	}

	public boolean create_from_faces(double[][] faces) {
		return (boolean) super.call("create_from_faces", new java.lang.Object[]{(java.lang.Object) faces});
	}

	public GodotDictionary intersect_segment(Vector3 begin, Vector3 end) {
		return (GodotDictionary) super.call("intersect_segment",
				new java.lang.Object[]{(java.lang.Object) begin, (java.lang.Object) end});
	}

	public GodotDictionary intersect_ray(Vector3 begin, Vector3 dir) {
		return (GodotDictionary) super.call("intersect_ray",
				new java.lang.Object[]{(java.lang.Object) begin, (java.lang.Object) dir});
	}
}
