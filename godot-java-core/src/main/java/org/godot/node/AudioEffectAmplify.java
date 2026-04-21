package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectAmplify extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_volume_linear", 373806689L), java.util.Map.entry("get_volume_linear", 1740695150L),
			java.util.Map.entry("get_volume_db", 1740695150L), java.util.Map.entry("set_volume_db", 373806689L));

	AudioEffectAmplify(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectAmplify(long nativePointer) {
		super(nativePointer);
	}

	public double getVolume_db() {
		return (double) super.call("get_volume_db", new java.lang.Object[0]);
	}

	public void setVolume_db(double value) {
		super.call("set_volume_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolume_linear() {
		return (double) super.call("get_volume_linear", new java.lang.Object[0]);
	}

	public void setVolume_linear(double value) {
		super.call("set_volume_linear", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
