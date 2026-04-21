package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectChorus extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_voice_delay_ms", 2339986948L),
			java.util.Map.entry("set_voice_delay_ms", 1602489585L),
			java.util.Map.entry("set_voice_rate_hz", 1602489585L),
			java.util.Map.entry("get_voice_depth_ms", 2339986948L), java.util.Map.entry("set_voice_pan", 1602489585L),
			java.util.Map.entry("get_dry", 1740695150L), java.util.Map.entry("set_voice_depth_ms", 1602489585L),
			java.util.Map.entry("get_voice_level_db", 2339986948L), java.util.Map.entry("get_voice_count", 3905245786L),
			java.util.Map.entry("set_voice_cutoff_hz", 1602489585L), java.util.Map.entry("get_voice_pan", 2339986948L),
			java.util.Map.entry("get_voice_rate_hz", 2339986948L),
			java.util.Map.entry("get_voice_cutoff_hz", 2339986948L), java.util.Map.entry("get_wet", 1740695150L),
			java.util.Map.entry("set_voice_count", 1286410249L), java.util.Map.entry("set_voice_level_db", 1602489585L),
			java.util.Map.entry("set_dry", 373806689L), java.util.Map.entry("set_wet", 373806689L));

	AudioEffectChorus(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectChorus(long nativePointer) {
		super(nativePointer);
	}

	public void set_voice_delay_ms(long voice_idx, double delay_ms) {
		super.call("set_voice_delay_ms",
				new java.lang.Object[]{java.lang.Long.valueOf(voice_idx), java.lang.Double.valueOf(delay_ms)});
	}

	public double get_voice_delay_ms(long voice_idx) {
		return (double) super.call("get_voice_delay_ms", new java.lang.Object[]{java.lang.Long.valueOf(voice_idx)});
	}

	public void set_voice_rate_hz(long voice_idx, double rate_hz) {
		super.call("set_voice_rate_hz",
				new java.lang.Object[]{java.lang.Long.valueOf(voice_idx), java.lang.Double.valueOf(rate_hz)});
	}

	public double get_voice_rate_hz(long voice_idx) {
		return (double) super.call("get_voice_rate_hz", new java.lang.Object[]{java.lang.Long.valueOf(voice_idx)});
	}

	public void set_voice_depth_ms(long voice_idx, double depth_ms) {
		super.call("set_voice_depth_ms",
				new java.lang.Object[]{java.lang.Long.valueOf(voice_idx), java.lang.Double.valueOf(depth_ms)});
	}

	public double get_voice_depth_ms(long voice_idx) {
		return (double) super.call("get_voice_depth_ms", new java.lang.Object[]{java.lang.Long.valueOf(voice_idx)});
	}

	public void set_voice_level_db(long voice_idx, double level_db) {
		super.call("set_voice_level_db",
				new java.lang.Object[]{java.lang.Long.valueOf(voice_idx), java.lang.Double.valueOf(level_db)});
	}

	public double get_voice_level_db(long voice_idx) {
		return (double) super.call("get_voice_level_db", new java.lang.Object[]{java.lang.Long.valueOf(voice_idx)});
	}

	public void set_voice_cutoff_hz(long voice_idx, double cutoff_hz) {
		super.call("set_voice_cutoff_hz",
				new java.lang.Object[]{java.lang.Long.valueOf(voice_idx), java.lang.Double.valueOf(cutoff_hz)});
	}

	public double get_voice_cutoff_hz(long voice_idx) {
		return (double) super.call("get_voice_cutoff_hz", new java.lang.Object[]{java.lang.Long.valueOf(voice_idx)});
	}

	public void set_voice_pan(long voice_idx, double pan) {
		super.call("set_voice_pan",
				new java.lang.Object[]{java.lang.Long.valueOf(voice_idx), java.lang.Double.valueOf(pan)});
	}

	public double get_voice_pan(long voice_idx) {
		return (double) super.call("get_voice_pan", new java.lang.Object[]{java.lang.Long.valueOf(voice_idx)});
	}

	public long getVoice_count() {
		return (long) super.call("get_voice_count", new java.lang.Object[0]);
	}

	public void setVoice_count(long value) {
		super.call("set_voice_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getDry() {
		return (double) super.call("get_dry", new java.lang.Object[0]);
	}

	public void setDry(double value) {
		super.call("set_dry", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWet() {
		return (double) super.call("get_wet", new java.lang.Object[0]);
	}

	public void setWet(double value) {
		super.call("set_wet", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
