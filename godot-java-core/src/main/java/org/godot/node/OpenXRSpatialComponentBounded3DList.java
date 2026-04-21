package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class OpenXRSpatialComponentBounded3DList extends OpenXRSpatialComponentData {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_center_pose", 1965739696L), java.util.Map.entry("get_size", 711720468L));

	OpenXRSpatialComponentBounded3DList(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialComponentBounded3DList(long nativePointer) {
		super(nativePointer);
	}

	public Transform3D get_center_pose(long index) {
		return (Transform3D) super.call("get_center_pose", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Vector3 get_size(long index) {
		return (Vector3) super.call("get_size", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}
}
