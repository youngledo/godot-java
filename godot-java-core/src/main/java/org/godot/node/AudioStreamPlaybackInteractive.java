package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamPlaybackInteractive extends AudioStreamPlayback {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("switch_to_clip_by_name", 3304788590L),
			java.util.Map.entry("switch_to_clip", 1286410249L),
			java.util.Map.entry("get_current_clip_index", 3905245786L));

	AudioStreamPlaybackInteractive(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaybackInteractive(long nativePointer) {
		super(nativePointer);
	}

	public void switch_to_clip_by_name(String clip_name) {
		super.call("switch_to_clip_by_name", new java.lang.Object[]{(java.lang.Object) clip_name});
	}

	public void switch_to_clip(long clip_index) {
		super.call("switch_to_clip", new java.lang.Object[]{java.lang.Long.valueOf(clip_index)});
	}
}
