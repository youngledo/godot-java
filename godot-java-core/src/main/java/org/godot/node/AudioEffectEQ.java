package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectEQ extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_band_count", 3905245786L), java.util.Map.entry("get_band_gain_db", 2339986948L),
			java.util.Map.entry("set_band_gain_db", 1602489585L));

	AudioEffectEQ(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectEQ(long nativePointer) {
		super(nativePointer);
	}

	public void set_band_gain_db(long band_idx, double volume_db) {
		super.call("set_band_gain_db",
				new java.lang.Object[]{java.lang.Long.valueOf(band_idx), java.lang.Double.valueOf(volume_db)});
	}

	public double get_band_gain_db(long band_idx) {
		return (double) super.call("get_band_gain_db", new java.lang.Object[]{java.lang.Long.valueOf(band_idx)});
	}
}
