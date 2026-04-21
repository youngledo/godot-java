package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRRenderModel extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_top_level_path", 201670096L), java.util.Map.entry("get_render_model", 2944877500L),
			java.util.Map.entry("set_render_model", 2722037293L));

	OpenXRRenderModel(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRRenderModel(long nativePointer) {
		super(nativePointer);
	}

	public long getRender_model() {
		return (long) super.call("get_render_model", new java.lang.Object[0]);
	}

	public void setRender_model(long value) {
		super.call("set_render_model", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
