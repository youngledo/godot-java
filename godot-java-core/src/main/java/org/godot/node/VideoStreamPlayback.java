package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VideoStreamPlayback extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("mix_audio", 93876830L));

	VideoStreamPlayback(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VideoStreamPlayback(long nativePointer) {
		super(nativePointer);
	}

	public int mix_audio(long num_frames, double[] buffer, long offset) {
		return (int) super.call("mix_audio", new java.lang.Object[]{java.lang.Long.valueOf(num_frames),
				(java.lang.Object) buffer, java.lang.Long.valueOf(offset)});
	}
}
