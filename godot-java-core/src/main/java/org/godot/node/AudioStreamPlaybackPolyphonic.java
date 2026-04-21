package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamPlaybackPolyphonic extends AudioStreamPlayback {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("play_stream", 1846744803L), java.util.Map.entry("set_stream_pitch_scale", 1602489585L),
			java.util.Map.entry("is_stream_playing", 1116898809L), java.util.Map.entry("stop_stream", 1286410249L),
			java.util.Map.entry("set_stream_volume", 1602489585L));

	AudioStreamPlaybackPolyphonic(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaybackPolyphonic(long nativePointer) {
		super(nativePointer);
	}

	public long play_stream(AudioStream stream, double from_offset, double volume_db, double pitch_scale,
			int playback_type, String bus) {
		return (long) super.call("play_stream",
				new java.lang.Object[]{(java.lang.Object) stream, java.lang.Double.valueOf(from_offset),
						java.lang.Double.valueOf(volume_db), java.lang.Double.valueOf(pitch_scale),
						java.lang.Integer.valueOf(playback_type), (java.lang.Object) bus});
	}

	public void set_stream_volume(long stream, double volume_db) {
		super.call("set_stream_volume",
				new java.lang.Object[]{java.lang.Long.valueOf(stream), java.lang.Double.valueOf(volume_db)});
	}

	public void set_stream_pitch_scale(long stream, double pitch_scale) {
		super.call("set_stream_pitch_scale",
				new java.lang.Object[]{java.lang.Long.valueOf(stream), java.lang.Double.valueOf(pitch_scale)});
	}

	public boolean is_stream_playing(long stream) {
		return (boolean) super.call("is_stream_playing", new java.lang.Object[]{java.lang.Long.valueOf(stream)});
	}

	public void stop_stream(long stream) {
		super.call("stop_stream", new java.lang.Object[]{java.lang.Long.valueOf(stream)});
	}
}
