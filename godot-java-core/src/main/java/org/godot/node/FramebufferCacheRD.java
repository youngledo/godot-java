package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class FramebufferCacheRD extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_cache_multipass", 3437881813L));

	FramebufferCacheRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FramebufferCacheRD(long nativePointer) {
		super(nativePointer);
	}

	public long get_cache_multipass(long[] textures, RDFramebufferPass[] passes, long views) {
		return (long) super.call("get_cache_multipass", new java.lang.Object[]{(java.lang.Object) textures,
				(java.lang.Object) passes, java.lang.Long.valueOf(views)});
	}
}
