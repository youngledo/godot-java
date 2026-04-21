package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectCapture extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_buffer_length", 191475506L),
			java.util.Map.entry("get_buffer_length_frames", 3905245786L),
			java.util.Map.entry("clear_buffer", 3218959716L), java.util.Map.entry("can_get_buffer", 1116898809L),
			java.util.Map.entry("get_buffer", 2649534757L), java.util.Map.entry("set_buffer_length", 373806689L),
			java.util.Map.entry("get_frames_available", 3905245786L),
			java.util.Map.entry("get_discarded_frames", 3905245786L),
			java.util.Map.entry("get_pushed_frames", 3905245786L));

	AudioEffectCapture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectCapture(long nativePointer) {
		super(nativePointer);
	}

	public boolean can_get_buffer(long frames) {
		return (boolean) super.call("can_get_buffer", new java.lang.Object[]{java.lang.Long.valueOf(frames)});
	}

	public double[][] get_buffer(long frames) {
		return (double[][]) super.call("get_buffer", new java.lang.Object[]{java.lang.Long.valueOf(frames)});
	}

	public void clear_buffer() {
		super.call("clear_buffer");
	}

	public double getBuffer_length() {
		return (double) super.call("get_buffer_length", new java.lang.Object[0]);
	}

	public void setBuffer_length(double value) {
		super.call("set_buffer_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
