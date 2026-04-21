package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class PathFollow3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_progress_ratio", 373806689L),
			java.util.Map.entry("set_cubic_interpolation", 2586408642L),
			java.util.Map.entry("set_progress", 373806689L), java.util.Map.entry("get_progress", 1740695150L),
			java.util.Map.entry("is_using_model_front", 36873697L),
			java.util.Map.entry("set_tilt_enabled", 2586408642L), java.util.Map.entry("has_loop", 36873697L),
			java.util.Map.entry("correct_posture", 2686588690L),
			java.util.Map.entry("set_use_model_front", 2586408642L), java.util.Map.entry("get_h_offset", 1740695150L),
			java.util.Map.entry("set_h_offset", 373806689L), java.util.Map.entry("get_v_offset", 1740695150L),
			java.util.Map.entry("get_cubic_interpolation", 36873697L),
			java.util.Map.entry("set_rotation_mode", 1640311967L),
			java.util.Map.entry("get_rotation_mode", 3814010545L),
			java.util.Map.entry("get_progress_ratio", 1740695150L), java.util.Map.entry("set_loop", 2586408642L),
			java.util.Map.entry("is_tilt_enabled", 36873697L), java.util.Map.entry("set_v_offset", 373806689L));

	PathFollow3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PathFollow3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_model_front() {
		return (boolean) super.call("is_using_model_front");
	}

	public boolean has_loop() {
		return (boolean) super.call("has_loop");
	}

	public boolean is_tilt_enabled() {
		return (boolean) super.call("is_tilt_enabled");
	}

	public Transform3D correct_posture(Transform3D transform, int rotation_mode) {
		return (Transform3D) super.call("correct_posture",
				new java.lang.Object[]{(java.lang.Object) transform, java.lang.Integer.valueOf(rotation_mode)});
	}

	public double getProgress() {
		return (double) super.call("get_progress", new java.lang.Object[0]);
	}

	public void setProgress(double value) {
		super.call("set_progress", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getProgress_ratio() {
		return (double) super.call("get_progress_ratio", new java.lang.Object[0]);
	}

	public void setProgress_ratio(double value) {
		super.call("set_progress_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getH_offset() {
		return (double) super.call("get_h_offset", new java.lang.Object[0]);
	}

	public void setH_offset(double value) {
		super.call("set_h_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getV_offset() {
		return (double) super.call("get_v_offset", new java.lang.Object[0]);
	}

	public void setV_offset(double value) {
		super.call("set_v_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getRotation_mode() {
		return (long) super.call("get_rotation_mode", new java.lang.Object[0]);
	}

	public void setRotation_mode(long value) {
		super.call("set_rotation_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_model_front() {
		return (boolean) super.call("is_using_model_front", new java.lang.Object[0]);
	}

	public void setUse_model_front(boolean value) {
		super.call("set_use_model_front", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getCubic_interp() {
		return (boolean) super.call("get_cubic_interpolation", new java.lang.Object[0]);
	}

	public void setCubic_interp(boolean value) {
		super.call("set_cubic_interpolation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getLoop() {
		return (boolean) super.call("has_loop", new java.lang.Object[0]);
	}

	public void setLoop(boolean value) {
		super.call("set_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isTilt_enabled() {
		return (boolean) super.call("is_tilt_enabled", new java.lang.Object[0]);
	}

	public void setTilt_enabled(boolean value) {
		super.call("set_tilt_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
