package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class OpenXRCompositionLayerQuad extends OpenXRCompositionLayer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_quad_size", 3341600327L), java.util.Map.entry("set_quad_size", 743155724L));

	OpenXRCompositionLayerQuad(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRCompositionLayerQuad(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getQuad_size() {
		return (Vector2) super.call("get_quad_size", new java.lang.Object[0]);
	}

	public void setQuad_size(Vector2 value) {
		super.call("set_quad_size", new java.lang.Object[]{(java.lang.Object) value});
	}
}
