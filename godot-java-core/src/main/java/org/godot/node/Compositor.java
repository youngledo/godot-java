package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Compositor extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_compositor_effects", 3995934104L),
			java.util.Map.entry("set_compositor_effects", 381264803L));

	Compositor(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Compositor(long nativePointer) {
		super(nativePointer);
	}

	public CompositorEffect[] getCompositor_effects() {
		return (CompositorEffect[]) super.call("get_compositor_effects", new java.lang.Object[0]);
	}

	public void setCompositor_effects(CompositorEffect[] value) {
		super.call("set_compositor_effects", new java.lang.Object[]{(java.lang.Object) value});
	}
}
