package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.AABB;

public class PlaceholderMesh extends Mesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_aabb", 259215842L));

	PlaceholderMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PlaceholderMesh(long nativePointer) {
		super(nativePointer);
	}

	public AABB getAabb() {
		return (AABB) super.call("get_aabb", new java.lang.Object[0]);
	}

	public void setAabb(AABB value) {
		super.call("set_aabb", new java.lang.Object[]{(java.lang.Object) value});
	}
}
