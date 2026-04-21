package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CameraAttributesPractical extends CameraAttributes {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_dof_blur_near_distance", 373806689L),
			java.util.Map.entry("set_dof_blur_far_distance", 373806689L),
			java.util.Map.entry("get_dof_blur_far_distance", 1740695150L),
			java.util.Map.entry("get_dof_blur_near_distance", 1740695150L),
			java.util.Map.entry("set_dof_blur_far_transition", 373806689L),
			java.util.Map.entry("set_dof_blur_near_transition", 373806689L),
			java.util.Map.entry("get_dof_blur_near_transition", 1740695150L),
			java.util.Map.entry("set_dof_blur_near_enabled", 2586408642L),
			java.util.Map.entry("set_dof_blur_far_enabled", 2586408642L),
			java.util.Map.entry("get_auto_exposure_max_sensitivity", 1740695150L),
			java.util.Map.entry("get_dof_blur_amount", 1740695150L),
			java.util.Map.entry("get_auto_exposure_min_sensitivity", 1740695150L),
			java.util.Map.entry("get_dof_blur_far_transition", 1740695150L),
			java.util.Map.entry("set_auto_exposure_max_sensitivity", 373806689L),
			java.util.Map.entry("is_dof_blur_near_enabled", 36873697L),
			java.util.Map.entry("set_dof_blur_amount", 373806689L),
			java.util.Map.entry("set_auto_exposure_min_sensitivity", 373806689L),
			java.util.Map.entry("is_dof_blur_far_enabled", 36873697L));

	CameraAttributesPractical(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CameraAttributesPractical(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_dof_blur_far_enabled() {
		return (boolean) super.call("is_dof_blur_far_enabled");
	}

	public boolean is_dof_blur_near_enabled() {
		return (boolean) super.call("is_dof_blur_near_enabled");
	}

	public boolean isDof_blur_far_enabled() {
		return (boolean) super.call("is_dof_blur_far_enabled", new java.lang.Object[0]);
	}

	public void setDof_blur_far_enabled(boolean value) {
		super.call("set_dof_blur_far_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDof_blur_far_distance() {
		return (double) super.call("get_dof_blur_far_distance", new java.lang.Object[0]);
	}

	public void setDof_blur_far_distance(double value) {
		super.call("set_dof_blur_far_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDof_blur_far_transition() {
		return (double) super.call("get_dof_blur_far_transition", new java.lang.Object[0]);
	}

	public void setDof_blur_far_transition(double value) {
		super.call("set_dof_blur_far_transition", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDof_blur_near_enabled() {
		return (boolean) super.call("is_dof_blur_near_enabled", new java.lang.Object[0]);
	}

	public void setDof_blur_near_enabled(boolean value) {
		super.call("set_dof_blur_near_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDof_blur_near_distance() {
		return (double) super.call("get_dof_blur_near_distance", new java.lang.Object[0]);
	}

	public void setDof_blur_near_distance(double value) {
		super.call("set_dof_blur_near_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDof_blur_near_transition() {
		return (double) super.call("get_dof_blur_near_transition", new java.lang.Object[0]);
	}

	public void setDof_blur_near_transition(double value) {
		super.call("set_dof_blur_near_transition", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDof_blur_amount() {
		return (double) super.call("get_dof_blur_amount", new java.lang.Object[0]);
	}

	public void setDof_blur_amount(double value) {
		super.call("set_dof_blur_amount", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAuto_exposure_min_sensitivity() {
		return (double) super.call("get_auto_exposure_min_sensitivity", new java.lang.Object[0]);
	}

	public void setAuto_exposure_min_sensitivity(double value) {
		super.call("set_auto_exposure_min_sensitivity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAuto_exposure_max_sensitivity() {
		return (double) super.call("get_auto_exposure_max_sensitivity", new java.lang.Object[0]);
	}

	public void setAuto_exposure_max_sensitivity(double value) {
		super.call("set_auto_exposure_max_sensitivity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
