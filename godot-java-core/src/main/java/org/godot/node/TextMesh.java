package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Vector2;

public class TextMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_curve_step", 1740695150L),
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("get_text_direction", 2516697328L),
			java.util.Map.entry("get_vertical_alignment", 3274884059L),
			java.util.Map.entry("get_line_spacing", 1740695150L), java.util.Map.entry("get_autowrap_mode", 1549071663L),
			java.util.Map.entry("set_autowrap_mode", 3289138044L),
			java.util.Map.entry("set_justification_flags", 2877345813L),
			java.util.Map.entry("set_line_spacing", 373806689L), java.util.Map.entry("get_width", 1740695150L),
			java.util.Map.entry("is_uppercase", 36873697L), java.util.Map.entry("set_depth", 373806689L),
			java.util.Map.entry("get_language", 201670096L), java.util.Map.entry("get_font", 3229501585L),
			java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("set_uppercase", 2586408642L), java.util.Map.entry("set_curve_step", 373806689L),
			java.util.Map.entry("set_font", 1262170328L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("set_pixel_size", 373806689L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("get_horizontal_alignment", 341400642L),
			java.util.Map.entry("set_font_size", 1286410249L), java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("set_text_direction", 1418190634L),
			java.util.Map.entry("set_horizontal_alignment", 2312603777L), java.util.Map.entry("get_depth", 1740695150L),
			java.util.Map.entry("get_text", 201670096L), java.util.Map.entry("set_width", 373806689L),
			java.util.Map.entry("get_font_size", 3905245786L),
			java.util.Map.entry("get_justification_flags", 1583363614L), java.util.Map.entry("set_text", 83702148L),
			java.util.Map.entry("set_vertical_alignment", 1796458609L), java.util.Map.entry("set_offset", 743155724L),
			java.util.Map.entry("get_pixel_size", 1740695150L));

	TextMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextMesh(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_uppercase() {
		return (boolean) super.call("is_uppercase");
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Font getFont() {
		return (Font) super.call("get_font", new java.lang.Object[0]);
	}

	public void setFont(Font value) {
		super.call("set_font", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFont_size() {
		return (long) super.call("get_font_size", new java.lang.Object[0]);
	}

	public void setFont_size(long value) {
		super.call("set_font_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHorizontal_alignment() {
		return (long) super.call("get_horizontal_alignment", new java.lang.Object[0]);
	}

	public void setHorizontal_alignment(long value) {
		super.call("set_horizontal_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVertical_alignment() {
		return (long) super.call("get_vertical_alignment", new java.lang.Object[0]);
	}

	public void setVertical_alignment(long value) {
		super.call("set_vertical_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUppercase() {
		return (boolean) super.call("is_uppercase", new java.lang.Object[0]);
	}

	public void setUppercase(boolean value) {
		super.call("set_uppercase", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getLine_spacing() {
		return (double) super.call("get_line_spacing", new java.lang.Object[0]);
	}

	public void setLine_spacing(double value) {
		super.call("set_line_spacing", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getAutowrap_mode() {
		return (long) super.call("get_autowrap_mode", new java.lang.Object[0]);
	}

	public void setAutowrap_mode(long value) {
		super.call("set_autowrap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getJustification_flags() {
		return (long) super.call("get_justification_flags", new java.lang.Object[0]);
	}

	public void setJustification_flags(long value) {
		super.call("set_justification_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPixel_size() {
		return (double) super.call("get_pixel_size", new java.lang.Object[0]);
	}

	public void setPixel_size(double value) {
		super.call("set_pixel_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCurve_step() {
		return (double) super.call("get_curve_step", new java.lang.Object[0]);
	}

	public void setCurve_step(double value) {
		super.call("set_curve_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth() {
		return (double) super.call("get_depth", new java.lang.Object[0]);
	}

	public void setDepth(double value) {
		super.call("set_depth", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getWidth() {
		return (double) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(double value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getText_direction() {
		return (long) super.call("get_text_direction", new java.lang.Object[0]);
	}

	public void setText_direction(long value) {
		super.call("set_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getLanguage() {
		return (String) super.call("get_language", new java.lang.Object[0]);
	}

	public void setLanguage(String value) {
		super.call("set_language", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getStructured_text_bidi_override() {
		return (long) super.call("get_structured_text_bidi_override", new java.lang.Object[0]);
	}

	public void setStructured_text_bidi_override(long value) {
		super.call("set_structured_text_bidi_override", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotArray getStructured_text_bidi_override_options() {
		return (GodotArray) super.call("get_structured_text_bidi_override_options", new java.lang.Object[0]);
	}

	public void setStructured_text_bidi_override_options(GodotArray value) {
		super.call("set_structured_text_bidi_override_options", new java.lang.Object[]{(java.lang.Object) value});
	}
}
