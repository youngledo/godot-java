package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CameraAttributes extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_exposure_sensitivity", 373806689L),
			java.util.Map.entry("get_auto_exposure_speed", 1740695150L),
			java.util.Map.entry("set_auto_exposure_scale", 373806689L),
			java.util.Map.entry("get_exposure_multiplier", 1740695150L),
			java.util.Map.entry("get_exposure_sensitivity", 1740695150L),
			java.util.Map.entry("set_auto_exposure_enabled", 2586408642L),
			java.util.Map.entry("set_auto_exposure_speed", 373806689L),
			java.util.Map.entry("get_auto_exposure_scale", 1740695150L),
			java.util.Map.entry("set_exposure_multiplier", 373806689L),
			java.util.Map.entry("is_auto_exposure_enabled", 36873697L));

	CameraAttributes(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CameraAttributes(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_auto_exposure_enabled() {
		return (boolean) super.call("is_auto_exposure_enabled");
	}

	public double getExposure_sensitivity() {
		return (double) super.call("get_exposure_sensitivity", new java.lang.Object[0]);
	}

	public void setExposure_sensitivity(double value) {
		super.call("set_exposure_sensitivity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExposure_multiplier() {
		return (double) super.call("get_exposure_multiplier", new java.lang.Object[0]);
	}

	public void setExposure_multiplier(double value) {
		super.call("set_exposure_multiplier", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAuto_exposure_enabled() {
		return (boolean) super.call("is_auto_exposure_enabled", new java.lang.Object[0]);
	}

	public void setAuto_exposure_enabled(boolean value) {
		super.call("set_auto_exposure_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getAuto_exposure_scale() {
		return (double) super.call("get_auto_exposure_scale", new java.lang.Object[0]);
	}

	public void setAuto_exposure_scale(double value) {
		super.call("set_auto_exposure_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAuto_exposure_speed() {
		return (double) super.call("get_auto_exposure_speed", new java.lang.Object[0]);
	}

	public void setAuto_exposure_speed(double value) {
		super.call("set_auto_exposure_speed", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
