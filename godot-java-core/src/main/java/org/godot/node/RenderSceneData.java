package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.math.Projection;
import org.godot.math.Vector3;

public class RenderSceneData extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_cam_projection", 2910717950L),
			java.util.Map.entry("get_view_eye_offset", 711720468L), java.util.Map.entry("get_view_count", 3905245786L),
			java.util.Map.entry("get_view_projection", 3179846605L),
			java.util.Map.entry("get_cam_transform", 3229777777L),
			java.util.Map.entry("get_uniform_buffer", 2944877500L));

	RenderSceneData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneData(long nativePointer) {
		super(nativePointer);
	}

	public Vector3 get_view_eye_offset(long view) {
		return (Vector3) super.call("get_view_eye_offset", new java.lang.Object[]{java.lang.Long.valueOf(view)});
	}

	public Projection get_view_projection(long view) {
		return (Projection) super.call("get_view_projection", new java.lang.Object[]{java.lang.Long.valueOf(view)});
	}
}
