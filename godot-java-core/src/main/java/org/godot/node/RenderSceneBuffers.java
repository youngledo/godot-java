package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RenderSceneBuffers extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("configure", 3072623270L));

	RenderSceneBuffers(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneBuffers(long nativePointer) {
		super(nativePointer);
	}

	public void configure(RenderSceneBuffersConfiguration config) {
		super.call("configure", new java.lang.Object[]{(java.lang.Object) config});
	}
}
