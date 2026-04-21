package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamPlaybackResampled extends AudioStreamPlayback {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("begin_resample", 3218959716L));

	AudioStreamPlaybackResampled(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaybackResampled(long nativePointer) {
		super(nativePointer);
	}

	public void begin_resample() {
		super.call("begin_resample");
	}
}
