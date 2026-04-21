package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class TextLine extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_flags", 1583363614L), java.util.Map.entry("resize_object", 2095776372L),
			java.util.Map.entry("get_line_underline_position", 1740695150L),
			java.util.Map.entry("tab_align", 2899603908L), java.util.Map.entry("get_objects", 3995934104L),
			java.util.Map.entry("get_object_rect", 1742700391L), java.util.Map.entry("get_line_width", 1740695150L),
			java.util.Map.entry("get_preserve_invalid", 36873697L),
			java.util.Map.entry("set_bidi_override", 381264803L), java.util.Map.entry("get_width", 1740695150L),
			java.util.Map.entry("get_ellipsis_char", 201670096L), java.util.Map.entry("set_direction", 1418190634L),
			java.util.Map.entry("set_preserve_invalid", 2586408642L),
			java.util.Map.entry("get_preserve_control", 36873697L), java.util.Map.entry("get_direction", 2516697328L),
			java.util.Map.entry("get_size", 3341600327L), java.util.Map.entry("get_horizontal_alignment", 341400642L),
			java.util.Map.entry("has_object", 77467830L), java.util.Map.entry("get_orientation", 175768116L),
			java.util.Map.entry("add_string", 621426851L), java.util.Map.entry("set_horizontal_alignment", 2312603777L),
			java.util.Map.entry("set_preserve_control", 2586408642L),
			java.util.Map.entry("set_ellipsis_char", 83702148L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("add_object", 1316529304L), java.util.Map.entry("set_width", 373806689L),
			java.util.Map.entry("get_line_underline_thickness", 1740695150L),
			java.util.Map.entry("duplicate", 1912703884L), java.util.Map.entry("draw", 3625105422L),
			java.util.Map.entry("get_text_overrun_behavior", 3779142101L),
			java.util.Map.entry("get_inferred_direction", 2516697328L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("get_line_descent", 1740695150L), java.util.Map.entry("hit_test", 2401831903L),
			java.util.Map.entry("draw_outline", 2592177763L), java.util.Map.entry("set_flags", 2877345813L),
			java.util.Map.entry("get_line_ascent", 1740695150L), java.util.Map.entry("set_orientation", 42823726L),
			java.util.Map.entry("set_text_overrun_behavior", 1008890932L));

	TextLine(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextLine(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public TextLine duplicate() {
		return (TextLine) super.call("duplicate");
	}

	public boolean add_string(String text, Font font, long font_size, String language, Object meta) {
		return (boolean) super.call("add_string",
				new java.lang.Object[]{(java.lang.Object) text, (java.lang.Object) font,
						java.lang.Long.valueOf(font_size), (java.lang.Object) language, (java.lang.Object) meta});
	}

	public boolean add_object(Object key, Vector2 size, int inline_align, long length, double baseline) {
		return (boolean) super.call("add_object",
				new java.lang.Object[]{(java.lang.Object) key, (java.lang.Object) size,
						java.lang.Integer.valueOf(inline_align), java.lang.Long.valueOf(length),
						java.lang.Double.valueOf(baseline)});
	}

	public boolean resize_object(Object key, Vector2 size, int inline_align, double baseline) {
		return (boolean) super.call("resize_object", new java.lang.Object[]{(java.lang.Object) key,
				(java.lang.Object) size, java.lang.Integer.valueOf(inline_align), java.lang.Double.valueOf(baseline)});
	}

	public boolean has_object(Object key) {
		return (boolean) super.call("has_object", new java.lang.Object[]{(java.lang.Object) key});
	}

	public void tab_align(double[] tab_stops) {
		super.call("tab_align", new java.lang.Object[]{(java.lang.Object) tab_stops});
	}

	public Rect2 get_object_rect(Object key) {
		return (Rect2) super.call("get_object_rect", new java.lang.Object[]{(java.lang.Object) key});
	}

	public void draw(long canvas, Vector2 pos, Color color, double oversampling) {
		super.call("draw", new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
				(java.lang.Object) color, java.lang.Double.valueOf(oversampling)});
	}

	public void draw_outline(long canvas, Vector2 pos, long outline_size, Color color, double oversampling) {
		super.call("draw_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
						java.lang.Long.valueOf(outline_size), (java.lang.Object) color,
						java.lang.Double.valueOf(oversampling)});
	}

	public int hit_test(double coords) {
		return (int) super.call("hit_test", new java.lang.Object[]{java.lang.Double.valueOf(coords)});
	}

	public long getDirection() {
		return (long) super.call("get_direction", new java.lang.Object[0]);
	}

	public void setDirection(long value) {
		super.call("set_direction", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getOrientation() {
		return (long) super.call("get_orientation", new java.lang.Object[0]);
	}

	public void setOrientation(long value) {
		super.call("set_orientation", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getPreserve_invalid() {
		return (boolean) super.call("get_preserve_invalid", new java.lang.Object[0]);
	}

	public void setPreserve_invalid(boolean value) {
		super.call("set_preserve_invalid", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getPreserve_control() {
		return (boolean) super.call("get_preserve_control", new java.lang.Object[0]);
	}

	public void setPreserve_control(boolean value) {
		super.call("set_preserve_control", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getWidth() {
		return (double) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(double value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAlignment() {
		return (long) super.call("get_horizontal_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_horizontal_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFlags() {
		return (long) super.call("get_flags", new java.lang.Object[0]);
	}

	public void setFlags(long value) {
		super.call("set_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getText_overrun_behavior() {
		return (long) super.call("get_text_overrun_behavior", new java.lang.Object[0]);
	}

	public void setText_overrun_behavior(long value) {
		super.call("set_text_overrun_behavior", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getEllipsis_char() {
		return (String) super.call("get_ellipsis_char", new java.lang.Object[0]);
	}

	public void setEllipsis_char(String value) {
		super.call("set_ellipsis_char", new java.lang.Object[]{(java.lang.Object) value});
	}
}
