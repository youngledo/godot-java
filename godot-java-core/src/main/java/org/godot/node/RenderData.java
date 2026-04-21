package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class RenderData extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_render_scene_data", 1288715698L),
			java.util.Map.entry("get_camera_attributes", 2944877500L),
			java.util.Map.entry("get_environment", 2944877500L),
			java.util.Map.entry("get_render_scene_buffers", 2793216201L));

	RenderData(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderData(long nativePointer) {
		super(nativePointer);
	}
}
