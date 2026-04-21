package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ViewportTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_viewport_path_in_scene", 4075236667L),
			java.util.Map.entry("set_viewport_path_in_scene", 1348162250L));

	ViewportTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ViewportTexture(long nativePointer) {
		super(nativePointer);
	}

	public String getViewport_path() {
		return (String) super.call("get_viewport_path_in_scene", new java.lang.Object[0]);
	}

	public void setViewport_path(String value) {
		super.call("set_viewport_path_in_scene", new java.lang.Object[]{(java.lang.Object) value});
	}
}
