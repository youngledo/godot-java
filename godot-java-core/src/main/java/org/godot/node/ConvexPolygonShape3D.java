package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class ConvexPolygonShape3D extends Shape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_points", 334873810L), java.util.Map.entry("get_points", 497664490L));

	ConvexPolygonShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConvexPolygonShape3D(long nativePointer) {
		super(nativePointer);
	}

	public GodotArray getPoints() {
		return (GodotArray) super.call("get_points", new java.lang.Object[0]);
	}

	public void setPoints(GodotArray value) {
		super.call("set_points", new java.lang.Object[]{(java.lang.Object) value});
	}
}
