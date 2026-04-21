package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class OpenXRSpatialComponentPolygon2DList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_transform", 1965739696L), java.util.Map.entry("get_vertices", 110850971L));

	OpenXRSpatialComponentPolygon2DList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentPolygon2DList(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D get_transform(long index) {
		return (Transform3D) super.call("get_transform", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public double[][] get_vertices(long snapshot, long index) {
		return (double[][]) super.call("get_vertices",
				new java.lang.Object[]{java.lang.Long.valueOf(snapshot), java.lang.Long.valueOf(index)});
	}
}
