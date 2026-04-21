package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamGenerator extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_buffer_length", 1740695150L),
			java.util.Map.entry("set_mix_rate_mode", 3354885803L), java.util.Map.entry("set_mix_rate", 373806689L),
			java.util.Map.entry("get_mix_rate", 1740695150L), java.util.Map.entry("get_mix_rate_mode", 3537132591L),
			java.util.Map.entry("set_buffer_length", 373806689L));

	AudioStreamGenerator(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamGenerator(long nativePointer) {
		super(nativePointer);
	}

	public long getMix_rate_mode() {
		return (long) super.call("get_mix_rate_mode", new java.lang.Object[0]);
	}

	public void setMix_rate_mode(long value) {
		super.call("set_mix_rate_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getMix_rate() {
		return (double) super.call("get_mix_rate", new java.lang.Object[0]);
	}

	public void setMix_rate(double value) {
		super.call("set_mix_rate", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBuffer_length() {
		return (double) super.call("get_buffer_length", new java.lang.Object[0]);
	}

	public void setBuffer_length(double value) {
		super.call("set_buffer_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
