package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.math.Vector3;

public class PhysicsServer3DRenderingServerHandler extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_vertex", 1530502735L), java.util.Map.entry("set_normal", 1530502735L),
			java.util.Map.entry("set_aabb", 259215842L));

	PhysicsServer3DRenderingServerHandler(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PhysicsServer3DRenderingServerHandler(long nativePointer) {
		super(nativePointer);
	}

	public void set_vertex(long vertex_id, Vector3 vertex) {
		super.call("set_vertex", new java.lang.Object[]{java.lang.Long.valueOf(vertex_id), (java.lang.Object) vertex});
	}

	public void set_normal(long vertex_id, Vector3 normal) {
		super.call("set_normal", new java.lang.Object[]{java.lang.Long.valueOf(vertex_id), (java.lang.Object) normal});
	}
}
