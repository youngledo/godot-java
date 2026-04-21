package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectFilter extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_gain", 1740695150L), java.util.Map.entry("set_gain", 373806689L),
			java.util.Map.entry("set_cutoff", 373806689L), java.util.Map.entry("set_resonance", 373806689L),
			java.util.Map.entry("get_resonance", 1740695150L), java.util.Map.entry("set_db", 771740901L),
			java.util.Map.entry("get_cutoff", 1740695150L), java.util.Map.entry("get_db", 3981721890L));

	AudioEffectFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectFilter(long nativePointer) {
		super(nativePointer);
	}

	public double getCutoff_hz() {
		return (double) super.call("get_cutoff", new java.lang.Object[0]);
	}

	public void setCutoff_hz(double value) {
		super.call("set_cutoff", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getResonance() {
		return (double) super.call("get_resonance", new java.lang.Object[0]);
	}

	public void setResonance(double value) {
		super.call("set_resonance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getGain() {
		return (double) super.call("get_gain", new java.lang.Object[0]);
	}

	public void setGain(double value) {
		super.call("set_gain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getDb() {
		return (long) super.call("get_db", new java.lang.Object[0]);
	}

	public void setDb(long value) {
		super.call("set_db", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
