package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamMP3 extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load_from_buffer", 1674970313L), java.util.Map.entry("get_bar_beats", 3905245786L),
			java.util.Map.entry("load_from_file", 4238362998L), java.util.Map.entry("has_loop", 36873697L),
			java.util.Map.entry("set_beat_count", 1286410249L), java.util.Map.entry("set_loop_offset", 373806689L),
			java.util.Map.entry("set_bpm", 373806689L), java.util.Map.entry("get_data", 2362200018L),
			java.util.Map.entry("get_loop_offset", 1740695150L), java.util.Map.entry("set_bar_beats", 1286410249L),
			java.util.Map.entry("get_bpm", 1740695150L), java.util.Map.entry("set_loop", 2586408642L),
			java.util.Map.entry("set_data", 2971499966L), java.util.Map.entry("get_beat_count", 3905245786L));

	AudioStreamMP3(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamMP3(long nativePointer) {
		super(nativePointer);
	}

	public AudioStreamMP3 load_from_buffer(byte[] stream_data) {
		return (AudioStreamMP3) super.call("load_from_buffer", new java.lang.Object[]{(java.lang.Object) stream_data});
	}

	public AudioStreamMP3 load_from_file(String path) {
		return (AudioStreamMP3) super.call("load_from_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean has_loop() {
		return (boolean) super.call("has_loop");
	}

	public byte[] getData() {
		return (byte[]) super.call("get_data", new java.lang.Object[0]);
	}

	public void setData(byte[] value) {
		super.call("set_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getBpm() {
		return (double) super.call("get_bpm", new java.lang.Object[0]);
	}

	public void setBpm(double value) {
		super.call("set_bpm", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBeat_count() {
		return (long) super.call("get_beat_count", new java.lang.Object[0]);
	}

	public void setBeat_count(long value) {
		super.call("set_beat_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBar_beats() {
		return (long) super.call("get_bar_beats", new java.lang.Object[0]);
	}

	public void setBar_beats(long value) {
		super.call("set_bar_beats", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getLoop() {
		return (boolean) super.call("has_loop", new java.lang.Object[0]);
	}

	public void setLoop(boolean value) {
		super.call("set_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getLoop_offset() {
		return (double) super.call("get_loop_offset", new java.lang.Object[0]);
	}

	public void setLoop_offset(double value) {
		super.call("set_loop_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
