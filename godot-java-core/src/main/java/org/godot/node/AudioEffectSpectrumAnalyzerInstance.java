package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class AudioEffectSpectrumAnalyzerInstance extends AudioEffectInstance {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_magnitude_for_frequency_range", 797993915L));

	AudioEffectSpectrumAnalyzerInstance(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectSpectrumAnalyzerInstance(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 get_magnitude_for_frequency_range(double from_hz, double to_hz, int mode) {
		return (Vector2) super.call("get_magnitude_for_frequency_range", new java.lang.Object[]{
				java.lang.Double.valueOf(from_hz), java.lang.Double.valueOf(to_hz), java.lang.Integer.valueOf(mode)});
	}
}
