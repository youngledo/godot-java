package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class OpenXRSpatialComponentMesh2DList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_indices", 3393655756L), java.util.Map.entry("get_transform", 1965739696L),
			java.util.Map.entry("get_vertices", 110850971L));

	OpenXRSpatialComponentMesh2DList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentMesh2DList(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D get_transform(long index) {
		return (Transform3D) super.call("get_transform", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public double[][] get_vertices(long snapshot, long index) {
		return (double[][]) super.call("get_vertices",
				new java.lang.Object[]{java.lang.Long.valueOf(snapshot), java.lang.Long.valueOf(index)});
	}

	public int[] get_indices(long snapshot, long index) {
		return (int[]) super.call("get_indices",
				new java.lang.Object[]{java.lang.Long.valueOf(snapshot), java.lang.Long.valueOf(index)});
	}
}
