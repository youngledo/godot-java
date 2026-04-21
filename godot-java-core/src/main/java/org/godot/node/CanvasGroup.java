package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CanvasGroup extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_fit_margin", 373806689L), java.util.Map.entry("get_fit_margin", 1740695150L),
			java.util.Map.entry("get_clear_margin", 1740695150L), java.util.Map.entry("set_clear_margin", 373806689L),
			java.util.Map.entry("set_use_mipmaps", 2586408642L), java.util.Map.entry("is_using_mipmaps", 36873697L));

	CanvasGroup(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CanvasGroup(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_mipmaps() {
		return (boolean) super.call("is_using_mipmaps");
	}

	public double getFit_margin() {
		return (double) super.call("get_fit_margin", new java.lang.Object[0]);
	}

	public void setFit_margin(double value) {
		super.call("set_fit_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getClear_margin() {
		return (double) super.call("get_clear_margin", new java.lang.Object[0]);
	}

	public void setClear_margin(double value) {
		super.call("set_clear_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isUse_mipmaps() {
		return (boolean) super.call("is_using_mipmaps", new java.lang.Object[0]);
	}

	public void setUse_mipmaps(boolean value) {
		super.call("set_use_mipmaps", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
