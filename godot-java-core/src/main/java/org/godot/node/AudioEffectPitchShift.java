package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectPitchShift extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_oversampling", 3905245786L), java.util.Map.entry("set_oversampling", 1286410249L),
			java.util.Map.entry("set_fft_size", 2323518741L), java.util.Map.entry("get_fft_size", 2361246789L),
			java.util.Map.entry("set_pitch_scale", 373806689L), java.util.Map.entry("get_pitch_scale", 1740695150L));

	AudioEffectPitchShift(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectPitchShift(long nativePointer) {
		super(nativePointer);
	}

	public double getPitch_scale() {
		return (double) super.call("get_pitch_scale", new java.lang.Object[0]);
	}

	public void setPitch_scale(double value) {
		super.call("set_pitch_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getOversampling() {
		return (double) super.call("get_oversampling", new java.lang.Object[0]);
	}

	public void setOversampling(double value) {
		super.call("set_oversampling", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getFft_size() {
		return (long) super.call("get_fft_size", new java.lang.Object[0]);
	}

	public void setFft_size(long value) {
		super.call("set_fft_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
