package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRAnalogThresholdModifier extends OpenXRActionBindingModifier {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_off_threshold", 373806689L), java.util.Map.entry("get_off_haptic", 922310751L),
			java.util.Map.entry("get_on_threshold", 1740695150L), java.util.Map.entry("get_off_threshold", 1740695150L),
			java.util.Map.entry("set_on_threshold", 373806689L), java.util.Map.entry("set_off_haptic", 2998020150L),
			java.util.Map.entry("get_on_haptic", 922310751L), java.util.Map.entry("set_on_haptic", 2998020150L));

	OpenXRAnalogThresholdModifier(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRAnalogThresholdModifier(long nativePointer) {
		super(nativePointer);
	}

	public double getOn_threshold() {
		return (double) super.call("get_on_threshold", new java.lang.Object[0]);
	}

	public void setOn_threshold(double value) {
		super.call("set_on_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getOff_threshold() {
		return (double) super.call("get_off_threshold", new java.lang.Object[0]);
	}

	public void setOff_threshold(double value) {
		super.call("set_off_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public OpenXRHapticBase getOn_haptic() {
		return (OpenXRHapticBase) super.call("get_on_haptic", new java.lang.Object[0]);
	}

	public void setOn_haptic(OpenXRHapticBase value) {
		super.call("set_on_haptic", new java.lang.Object[]{(java.lang.Object) value});
	}

	public OpenXRHapticBase getOff_haptic() {
		return (OpenXRHapticBase) super.call("get_off_haptic", new java.lang.Object[0]);
	}

	public void setOff_haptic(OpenXRHapticBase value) {
		super.call("set_off_haptic", new java.lang.Object[]{(java.lang.Object) value});
	}
}
