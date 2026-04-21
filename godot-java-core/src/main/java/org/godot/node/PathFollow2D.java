package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class PathFollow2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_progress_ratio", 373806689L),
			java.util.Map.entry("set_cubic_interpolation", 2586408642L),
			java.util.Map.entry("set_progress", 373806689L), java.util.Map.entry("get_progress", 1740695150L),
			java.util.Map.entry("is_rotating", 36873697L), java.util.Map.entry("has_loop", 36873697L),
			java.util.Map.entry("get_h_offset", 1740695150L), java.util.Map.entry("set_h_offset", 373806689L),
			java.util.Map.entry("set_rotates", 2586408642L), java.util.Map.entry("get_v_offset", 1740695150L),
			java.util.Map.entry("get_cubic_interpolation", 36873697L),
			java.util.Map.entry("get_progress_ratio", 1740695150L), java.util.Map.entry("set_loop", 2586408642L),
			java.util.Map.entry("set_v_offset", 373806689L));

	PathFollow2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PathFollow2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_rotating() {
		return (boolean) super.call("is_rotating");
	}

	public boolean has_loop() {
		return (boolean) super.call("has_loop");
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

	public boolean isRotates() {
		return (boolean) super.call("is_rotating", new java.lang.Object[0]);
	}

	public void setRotates(boolean value) {
		super.call("set_rotates", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
}
