package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class OpenXRSpatialComponentMesh3DList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_mesh", 1576363275L), java.util.Map.entry("get_transform", 1965739696L));

	OpenXRSpatialComponentMesh3DList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentMesh3DList(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D get_transform(long index) {
		return (Transform3D) super.call("get_transform", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Mesh get_mesh(long index) {
		return (Mesh) super.call("get_mesh", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
