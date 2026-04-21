package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStream extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("instantiate_playback", 210135309L),
			java.util.Map.entry("generate_sample", 2646048999L), java.util.Map.entry("is_monophonic", 36873697L),
			java.util.Map.entry("is_meta_stream", 36873697L), java.util.Map.entry("can_be_sampled", 36873697L),
			java.util.Map.entry("get_length", 1740695150L));

	AudioStream(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStream(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_monophonic() {
		return (boolean) super.call("is_monophonic");
	}

	public AudioStreamPlayback instantiate_playback() {
		return (AudioStreamPlayback) super.call("instantiate_playback");
	}

	public boolean can_be_sampled() {
		return (boolean) super.call("can_be_sampled");
	}

	public AudioSample generate_sample() {
		return (AudioSample) super.call("generate_sample");
	}

	public boolean is_meta_stream() {
		return (boolean) super.call("is_meta_stream");
	}
}
