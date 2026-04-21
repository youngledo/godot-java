package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CameraAttributesPhysical extends CameraAttributes {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_auto_exposure_max_exposure_value", 373806689L),
			java.util.Map.entry("set_focal_length", 373806689L), java.util.Map.entry("get_far", 1740695150L),
			java.util.Map.entry("get_auto_exposure_max_exposure_value", 1740695150L),
			java.util.Map.entry("get_focal_length", 1740695150L), java.util.Map.entry("get_fov", 1740695150L),
			java.util.Map.entry("set_far", 373806689L), java.util.Map.entry("get_focus_distance", 1740695150L),
			java.util.Map.entry("set_focus_distance", 373806689L), java.util.Map.entry("set_shutter_speed", 373806689L),
			java.util.Map.entry("get_auto_exposure_min_exposure_value", 1740695150L),
			java.util.Map.entry("set_near", 373806689L), java.util.Map.entry("set_aperture", 373806689L),
			java.util.Map.entry("get_aperture", 1740695150L), java.util.Map.entry("get_shutter_speed", 1740695150L),
			java.util.Map.entry("set_auto_exposure_min_exposure_value", 373806689L),
			java.util.Map.entry("get_near", 1740695150L));

	CameraAttributesPhysical(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CameraAttributesPhysical(long nativePointer) {
		super(nativePointer);
	}

	public double getFrustum_focus_distance() {
		return (double) super.call("get_focus_distance", new java.lang.Object[0]);
	}

	public void setFrustum_focus_distance(double value) {
		super.call("set_focus_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFrustum_focal_length() {
		return (double) super.call("get_focal_length", new java.lang.Object[0]);
	}

	public void setFrustum_focal_length(double value) {
		super.call("set_focal_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFrustum_near() {
		return (double) super.call("get_near", new java.lang.Object[0]);
	}

	public void setFrustum_near(double value) {
		super.call("set_near", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getFrustum_far() {
		return (double) super.call("get_far", new java.lang.Object[0]);
	}

	public void setFrustum_far(double value) {
		super.call("set_far", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExposure_aperture() {
		return (double) super.call("get_aperture", new java.lang.Object[0]);
	}

	public void setExposure_aperture(double value) {
		super.call("set_aperture", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getExposure_shutter_speed() {
		return (double) super.call("get_shutter_speed", new java.lang.Object[0]);
	}

	public void setExposure_shutter_speed(double value) {
		super.call("set_shutter_speed", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAuto_exposure_min_exposure_value() {
		return (double) super.call("get_auto_exposure_min_exposure_value", new java.lang.Object[0]);
	}

	public void setAuto_exposure_min_exposure_value(double value) {
		super.call("set_auto_exposure_min_exposure_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAuto_exposure_max_exposure_value() {
		return (double) super.call("get_auto_exposure_max_exposure_value", new java.lang.Object[0]);
	}

	public void setAuto_exposure_max_exposure_value(double value) {
		super.call("set_auto_exposure_max_exposure_value", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
