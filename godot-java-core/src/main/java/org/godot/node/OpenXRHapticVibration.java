package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRHapticVibration extends OpenXRHapticBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_frequency", 1740695150L), java.util.Map.entry("set_amplitude", 373806689L),
			java.util.Map.entry("set_frequency", 373806689L), java.util.Map.entry("set_duration", 1286410249L),
			java.util.Map.entry("get_duration", 3905245786L), java.util.Map.entry("get_amplitude", 1740695150L));

	OpenXRHapticVibration(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRHapticVibration(long nativePointer) {
		super(nativePointer);
	}

	public long getDuration() {
		return (long) super.call("get_duration", new java.lang.Object[0]);
	}

	public void setDuration(long value) {
		super.call("set_duration", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getFrequency() {
		return (double) super.call("get_frequency", new java.lang.Object[0]);
	}

	public void setFrequency(double value) {
		super.call("set_frequency", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAmplitude() {
		return (double) super.call("get_amplitude", new java.lang.Object[0]);
	}

	public void setAmplitude(double value) {
		super.call("set_amplitude", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
