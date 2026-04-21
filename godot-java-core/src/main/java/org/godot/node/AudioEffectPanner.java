package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectPanner extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_pan", 373806689L), java.util.Map.entry("get_pan", 1740695150L));

	AudioEffectPanner(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectPanner(long nativePointer) {
		super(nativePointer);
	}

	public double getPan() {
		return (double) super.call("get_pan", new java.lang.Object[0]);
	}

	public void setPan(double value) {
		super.call("set_pan", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
