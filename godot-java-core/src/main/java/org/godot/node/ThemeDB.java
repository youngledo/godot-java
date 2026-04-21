package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class ThemeDB extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_fallback_font", 1262170328L),
			java.util.Map.entry("set_fallback_font_size", 1286410249L),
			java.util.Map.entry("get_fallback_font_size", 2455072627L),
			java.util.Map.entry("set_fallback_base_scale", 373806689L),
			java.util.Map.entry("get_fallback_icon", 255860311L),
			java.util.Map.entry("set_fallback_stylebox", 2797200388L),
			java.util.Map.entry("set_fallback_icon", 4051416890L),
			java.util.Map.entry("get_fallback_stylebox", 496040854L),
			java.util.Map.entry("get_fallback_base_scale", 191475506L),
			java.util.Map.entry("get_fallback_font", 3656929885L), java.util.Map.entry("get_project_theme", 754276358L),
			java.util.Map.entry("get_default_theme", 754276358L));

	ThemeDB(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ThemeDB(long nativePointer) {
		super(nativePointer);
	}

	public double getFallback_base_scale() {
		return (double) super.call("get_fallback_base_scale", new java.lang.Object[0]);
	}

	public void setFallback_base_scale(double value) {
		super.call("set_fallback_base_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Font getFallback_font() {
		return (Font) super.call("get_fallback_font", new java.lang.Object[0]);
	}

	public void setFallback_font(Font value) {
		super.call("set_fallback_font", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFallback_font_size() {
		return (long) super.call("get_fallback_font_size", new java.lang.Object[0]);
	}

	public void setFallback_font_size(long value) {
		super.call("set_fallback_font_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Texture2D getFallback_icon() {
		return (Texture2D) super.call("get_fallback_icon", new java.lang.Object[0]);
	}

	public void setFallback_icon(Texture2D value) {
		super.call("set_fallback_icon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public StyleBox getFallback_stylebox() {
		return (StyleBox) super.call("get_fallback_stylebox", new java.lang.Object[0]);
	}

	public void setFallback_stylebox(StyleBox value) {
		super.call("set_fallback_stylebox", new java.lang.Object[]{(java.lang.Object) value});
	}
}
