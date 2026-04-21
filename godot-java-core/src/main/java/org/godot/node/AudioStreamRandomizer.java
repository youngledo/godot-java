package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamRandomizer extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_stream_probability_weight", 1602489585L),
			java.util.Map.entry("get_random_pitch", 1740695150L), java.util.Map.entry("set_playback_mode", 3950967023L),
			java.util.Map.entry("set_random_pitch", 373806689L),
			java.util.Map.entry("set_random_volume_offset_db", 373806689L),
			java.util.Map.entry("get_playback_mode", 3943055077L), java.util.Map.entry("get_stream", 2739380747L),
			java.util.Map.entry("move_stream", 3937882851L), java.util.Map.entry("get_streams_count", 3905245786L),
			java.util.Map.entry("add_stream", 1892018854L), java.util.Map.entry("remove_stream", 1286410249L),
			java.util.Map.entry("set_stream", 111075094L),
			java.util.Map.entry("get_random_volume_offset_db", 1740695150L),
			java.util.Map.entry("set_streams_count", 1286410249L),
			java.util.Map.entry("set_random_pitch_semitones", 373806689L),
			java.util.Map.entry("get_random_pitch_semitones", 1740695150L),
			java.util.Map.entry("get_stream_probability_weight", 2339986948L));

	AudioStreamRandomizer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamRandomizer(long nativePointer) {
		super(nativePointer);
	}

	public void add_stream(long index, AudioStream stream, double weight) {
		super.call("add_stream", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) stream,
				java.lang.Double.valueOf(weight)});
	}

	public void move_stream(long index_from, long index_to) {
		super.call("move_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(index_from), java.lang.Long.valueOf(index_to)});
	}

	public void remove_stream(long index) {
		super.call("remove_stream", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stream(long index, AudioStream stream) {
		super.call("set_stream", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) stream});
	}

	public AudioStream get_stream(long index) {
		return (AudioStream) super.call("get_stream", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stream_probability_weight(long index, double weight) {
		super.call("set_stream_probability_weight",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Double.valueOf(weight)});
	}

	public double get_stream_probability_weight(long index) {
		return (double) super.call("get_stream_probability_weight",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long getPlayback_mode() {
		return (long) super.call("get_playback_mode", new java.lang.Object[0]);
	}

	public void setPlayback_mode(long value) {
		super.call("set_playback_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getRandom_pitch() {
		return (double) super.call("get_random_pitch", new java.lang.Object[0]);
	}

	public void setRandom_pitch(double value) {
		super.call("set_random_pitch", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRandom_pitch_semitones() {
		return (double) super.call("get_random_pitch_semitones", new java.lang.Object[0]);
	}

	public void setRandom_pitch_semitones(double value) {
		super.call("set_random_pitch_semitones", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRandom_volume_offset_db() {
		return (double) super.call("get_random_volume_offset_db", new java.lang.Object[0]);
	}

	public void setRandom_volume_offset_db(double value) {
		super.call("set_random_volume_offset_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getStreams_count() {
		return (long) super.call("get_streams_count", new java.lang.Object[0]);
	}

	public void setStreams_count(long value) {
		super.call("set_streams_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
