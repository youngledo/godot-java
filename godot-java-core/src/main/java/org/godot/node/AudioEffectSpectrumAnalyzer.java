package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectSpectrumAnalyzer extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_buffer_length", 1740695150L), java.util.Map.entry("set_fft_size", 1202879215L),
			java.util.Map.entry("get_fft_size", 3925405343L), java.util.Map.entry("set_tap_back_pos", 373806689L),
			java.util.Map.entry("set_buffer_length", 373806689L), java.util.Map.entry("get_tap_back_pos", 1740695150L));

	AudioEffectSpectrumAnalyzer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectSpectrumAnalyzer(long nativePointer) {
		super(nativePointer);
	}

	public double getBuffer_length() {
		return (double) super.call("get_buffer_length", new java.lang.Object[0]);
	}

	public void setBuffer_length(double value) {
		super.call("set_buffer_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getTap_back_pos() {
		return (double) super.call("get_tap_back_pos", new java.lang.Object[0]);
	}

	public void setTap_back_pos(double value) {
		super.call("set_tap_back_pos", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getFft_size() {
		return (long) super.call("get_fft_size", new java.lang.Object[0]);
	}

	public void setFft_size(long value) {
		super.call("set_fft_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
