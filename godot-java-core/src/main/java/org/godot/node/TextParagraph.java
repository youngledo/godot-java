package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class TextParagraph extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("resize_object", 2095776372L), java.util.Map.entry("draw_line_outline", 2822696703L),
			java.util.Map.entry("get_line_spacing", 1740695150L), java.util.Map.entry("get_line_width", 2339986948L),
			java.util.Map.entry("set_bidi_override", 381264803L), java.util.Map.entry("get_width", 1740695150L),
			java.util.Map.entry("set_line_spacing", 373806689L), java.util.Map.entry("get_break_flags", 2340632602L),
			java.util.Map.entry("get_max_lines_visible", 3905245786L),
			java.util.Map.entry("set_direction", 1418190634L), java.util.Map.entry("get_direction", 2516697328L),
			java.util.Map.entry("get_size", 3341600327L), java.util.Map.entry("get_orientation", 175768116L),
			java.util.Map.entry("get_non_wrapped_size", 3341600327L), java.util.Map.entry("add_string", 621426851L),
			java.util.Map.entry("set_preserve_control", 2586408642L),
			java.util.Map.entry("get_line_object_rect", 204315017L),
			java.util.Map.entry("get_line_underline_thickness", 2339986948L),
			java.util.Map.entry("duplicate", 3607706709L),
			java.util.Map.entry("get_text_overrun_behavior", 3779142101L),
			java.util.Map.entry("get_custom_punctuation", 201670096L), java.util.Map.entry("get_rid", 2944877500L),
			java.util.Map.entry("get_line_descent", 2339986948L), java.util.Map.entry("get_line_rid", 495598643L),
			java.util.Map.entry("draw_line", 828033758L), java.util.Map.entry("get_alignment", 341400642L),
			java.util.Map.entry("set_dropcap", 2498990330L), java.util.Map.entry("draw_outline", 3820500590L),
			java.util.Map.entry("get_line_count", 3905245786L), java.util.Map.entry("draw_dropcap", 3625105422L),
			java.util.Map.entry("get_line_objects", 663333327L), java.util.Map.entry("get_dropcap_size", 3341600327L),
			java.util.Map.entry("get_line_range", 880721226L),
			java.util.Map.entry("get_line_underline_position", 2339986948L),
			java.util.Map.entry("tab_align", 2899603908L), java.util.Map.entry("draw_dropcap_outline", 2592177763L),
			java.util.Map.entry("get_preserve_invalid", 36873697L),
			java.util.Map.entry("set_justification_flags", 2877345813L),
			java.util.Map.entry("get_ellipsis_char", 201670096L),
			java.util.Map.entry("set_max_lines_visible", 1286410249L), java.util.Map.entry("get_range", 3690982128L),
			java.util.Map.entry("set_preserve_invalid", 2586408642L),
			java.util.Map.entry("get_preserve_control", 36873697L), java.util.Map.entry("get_dropcap_rid", 2944877500L),
			java.util.Map.entry("has_object", 77467830L), java.util.Map.entry("get_line_size", 2299179447L),
			java.util.Map.entry("set_ellipsis_char", 83702148L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("add_object", 1316529304L), java.util.Map.entry("set_width", 373806689L),
			java.util.Map.entry("draw", 1492808103L), java.util.Map.entry("get_dropcap_lines", 3905245786L),
			java.util.Map.entry("clear_dropcap", 3218959716L),
			java.util.Map.entry("get_inferred_direction", 2516697328L),
			java.util.Map.entry("get_justification_flags", 1583363614L),
			java.util.Map.entry("set_custom_punctuation", 83702148L), java.util.Map.entry("set_alignment", 2312603777L),
			java.util.Map.entry("hit_test", 3820158470L), java.util.Map.entry("get_line_ascent", 2339986948L),
			java.util.Map.entry("set_orientation", 42823726L), java.util.Map.entry("set_break_flags", 2809697122L),
			java.util.Map.entry("set_text_overrun_behavior", 1008890932L));

	TextParagraph(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextParagraph(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public TextParagraph duplicate() {
		return (TextParagraph) super.call("duplicate");
	}

	public boolean set_dropcap(String text, Font font, long font_size, Rect2 dropcap_margins, String language) {
		return (boolean) super.call("set_dropcap",
				new java.lang.Object[]{(java.lang.Object) text, (java.lang.Object) font,
						java.lang.Long.valueOf(font_size), (java.lang.Object) dropcap_margins,
						(java.lang.Object) language});
	}

	public void clear_dropcap() {
		super.call("clear_dropcap");
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

	public long get_line_rid(long line) {
		return (long) super.call("get_line_rid", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public GodotArray get_line_objects(long line) {
		return (GodotArray) super.call("get_line_objects", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public Rect2 get_line_object_rect(long line, Object key) {
		return (Rect2) super.call("get_line_object_rect",
				new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) key});
	}

	public Vector2 get_line_size(long line) {
		return (Vector2) super.call("get_line_size", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public Vector2i get_line_range(long line) {
		return (Vector2i) super.call("get_line_range", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_line_ascent(long line) {
		return (double) super.call("get_line_ascent", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_line_descent(long line) {
		return (double) super.call("get_line_descent", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_line_width(long line) {
		return (double) super.call("get_line_width", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_line_underline_position(long line) {
		return (double) super.call("get_line_underline_position", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_line_underline_thickness(long line) {
		return (double) super.call("get_line_underline_thickness",
				new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void draw(long canvas, Vector2 pos, Color color, Color dc_color, double oversampling) {
		super.call("draw", new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
				(java.lang.Object) color, (java.lang.Object) dc_color, java.lang.Double.valueOf(oversampling)});
	}

	public void draw_outline(long canvas, Vector2 pos, long outline_size, Color color, Color dc_color,
			double oversampling) {
		super.call("draw_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
						java.lang.Long.valueOf(outline_size), (java.lang.Object) color, (java.lang.Object) dc_color,
						java.lang.Double.valueOf(oversampling)});
	}

	public void draw_line(long canvas, Vector2 pos, long line, Color color, double oversampling) {
		super.call("draw_line", new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
				java.lang.Long.valueOf(line), (java.lang.Object) color, java.lang.Double.valueOf(oversampling)});
	}

	public void draw_line_outline(long canvas, Vector2 pos, long line, long outline_size, Color color,
			double oversampling) {
		super.call("draw_line_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
						java.lang.Long.valueOf(line), java.lang.Long.valueOf(outline_size), (java.lang.Object) color,
						java.lang.Double.valueOf(oversampling)});
	}

	public void draw_dropcap(long canvas, Vector2 pos, Color color, double oversampling) {
		super.call("draw_dropcap", new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
				(java.lang.Object) color, java.lang.Double.valueOf(oversampling)});
	}

	public void draw_dropcap_outline(long canvas, Vector2 pos, long outline_size, Color color, double oversampling) {
		super.call("draw_dropcap_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas), (java.lang.Object) pos,
						java.lang.Long.valueOf(outline_size), (java.lang.Object) color,
						java.lang.Double.valueOf(oversampling)});
	}

	public int hit_test(Vector2 coords) {
		return (int) super.call("hit_test", new java.lang.Object[]{(java.lang.Object) coords});
	}

	public long getDirection() {
		return (long) super.call("get_direction", new java.lang.Object[0]);
	}

	public void setDirection(long value) {
		super.call("set_direction", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getCustom_punctuation() {
		return (String) super.call("get_custom_punctuation", new java.lang.Object[0]);
	}

	public void setCustom_punctuation(String value) {
		super.call("set_custom_punctuation", new java.lang.Object[]{(java.lang.Object) value});
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

	public long getAlignment() {
		return (long) super.call("get_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBreak_flags() {
		return (long) super.call("get_break_flags", new java.lang.Object[0]);
	}

	public void setBreak_flags(long value) {
		super.call("set_break_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getJustification_flags() {
		return (long) super.call("get_justification_flags", new java.lang.Object[0]);
	}

	public void setJustification_flags(long value) {
		super.call("set_justification_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public double getWidth() {
		return (double) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(double value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_lines_visible() {
		return (long) super.call("get_max_lines_visible", new java.lang.Object[0]);
	}

	public void setMax_lines_visible(long value) {
		super.call("set_max_lines_visible", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getLine_spacing() {
		return (double) super.call("get_line_spacing", new java.lang.Object[0]);
	}

	public void setLine_spacing(double value) {
		super.call("set_line_spacing", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
