package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRDpadBindingModifier extends OpenXRIPBindingModifier {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_action_set", 2093310581L), java.util.Map.entry("set_center_region", 373806689L),
			java.util.Map.entry("set_input_path", 83702148L), java.util.Map.entry("get_off_haptic", 922310751L),
			java.util.Map.entry("get_threshold_released", 1740695150L),
			java.util.Map.entry("set_is_sticky", 2586408642L), java.util.Map.entry("set_on_haptic", 2998020150L),
			java.util.Map.entry("get_action_set", 619941079L), java.util.Map.entry("get_input_path", 201670096L),
			java.util.Map.entry("get_threshold", 1740695150L), java.util.Map.entry("get_wedge_angle", 1740695150L),
			java.util.Map.entry("set_threshold", 373806689L), java.util.Map.entry("set_threshold_released", 373806689L),
			java.util.Map.entry("get_is_sticky", 36873697L), java.util.Map.entry("set_off_haptic", 2998020150L),
			java.util.Map.entry("set_wedge_angle", 373806689L), java.util.Map.entry("get_on_haptic", 922310751L),
			java.util.Map.entry("get_center_region", 1740695150L));

	OpenXRDpadBindingModifier(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRDpadBindingModifier(long nativePointer) {
		super(nativePointer);
	}

	public OpenXRActionSet getAction_set() {
		return (OpenXRActionSet) super.call("get_action_set", new java.lang.Object[0]);
	}

	public void setAction_set(OpenXRActionSet value) {
		super.call("set_action_set", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getInput_path() {
		return (String) super.call("get_input_path", new java.lang.Object[0]);
	}

	public void setInput_path(String value) {
		super.call("set_input_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getThreshold() {
		return (double) super.call("get_threshold", new java.lang.Object[0]);
	}

	public void setThreshold(double value) {
		super.call("set_threshold", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getThreshold_released() {
		return (double) super.call("get_threshold_released", new java.lang.Object[0]);
	}

	public void setThreshold_released(double value) {
		super.call("set_threshold_released", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCenter_region() {
		return (double) super.call("get_center_region", new java.lang.Object[0]);
	}

	public void setCenter_region(double value) {
		super.call("set_center_region", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWedge_angle() {
		return (double) super.call("get_wedge_angle", new java.lang.Object[0]);
	}

	public void setWedge_angle(double value) {
		super.call("set_wedge_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getIs_sticky() {
		return (boolean) super.call("get_is_sticky", new java.lang.Object[0]);
	}

	public void setIs_sticky(boolean value) {
		super.call("set_is_sticky", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
