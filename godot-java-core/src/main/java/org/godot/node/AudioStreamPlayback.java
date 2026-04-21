package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class AudioStreamPlayback extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("stop", 3218959716L), java.util.Map.entry("get_playback_position", 1740695150L),
			java.util.Map.entry("mix_audio", 3341291446L), java.util.Map.entry("start", 1958160172L),
			java.util.Map.entry("is_playing", 36873697L), java.util.Map.entry("set_sample_playback", 3195455091L),
			java.util.Map.entry("get_sample_playback", 3482738536L), java.util.Map.entry("seek", 1958160172L),
			java.util.Map.entry("get_loop_count", 3905245786L));

	AudioStreamPlayback(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlayback(long nativePointer) {
		super(nativePointer);
	}

	public double[][] mix_audio(double rate_scale, long frames) {
		return (double[][]) super.call("mix_audio",
				new java.lang.Object[]{java.lang.Double.valueOf(rate_scale), java.lang.Long.valueOf(frames)});
	}

	public void start(double from_pos) {
		super.call("start", new java.lang.Object[]{java.lang.Double.valueOf(from_pos)});
	}

	public void seek(double time) {
		super.call("seek", new java.lang.Object[]{java.lang.Double.valueOf(time)});
	}

	public void stop() {
		super.call("stop");
	}

	public boolean is_playing() {
		return (boolean) super.call("is_playing");
	}
}
