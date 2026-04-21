package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class LabelSettings extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_stacked_shadow_offset", 163021252L),
			java.util.Map.entry("get_outline_size", 3905245786L),
			java.util.Map.entry("get_stacked_outline_size", 923996154L),
			java.util.Map.entry("set_shadow_size", 1286410249L), java.util.Map.entry("set_shadow_offset", 743155724L),
			java.util.Map.entry("set_font_color", 2920490490L), java.util.Map.entry("get_shadow_size", 3905245786L),
			java.util.Map.entry("remove_stacked_outline", 1286410249L),
			java.util.Map.entry("get_stacked_shadow_offset", 2299179447L),
			java.util.Map.entry("get_line_spacing", 1740695150L),
			java.util.Map.entry("get_stacked_shadow_color", 3457211756L),
			java.util.Map.entry("set_line_spacing", 373806689L),
			java.util.Map.entry("get_stacked_outline_count", 3905245786L),
			java.util.Map.entry("set_paragraph_spacing", 373806689L),
			java.util.Map.entry("get_paragraph_spacing", 1740695150L), java.util.Map.entry("get_font", 3229501585L),
			java.util.Map.entry("add_stacked_shadow", 1025054187L),
			java.util.Map.entry("get_shadow_offset", 3341600327L), java.util.Map.entry("set_font", 1262170328L),
			java.util.Map.entry("remove_stacked_shadow", 1286410249L),
			java.util.Map.entry("set_outline_color", 2920490490L),
			java.util.Map.entry("add_stacked_outline", 1025054187L),
			java.util.Map.entry("get_outline_color", 3444240500L),
			java.util.Map.entry("set_stacked_outline_count", 1286410249L),
			java.util.Map.entry("get_shadow_color", 3444240500L), java.util.Map.entry("set_font_size", 1286410249L),
			java.util.Map.entry("set_outline_size", 1286410249L),
			java.util.Map.entry("set_stacked_shadow_color", 2878471219L),
			java.util.Map.entry("set_shadow_color", 2920490490L),
			java.util.Map.entry("get_stacked_outline_color", 3457211756L),
			java.util.Map.entry("move_stacked_shadow", 3937882851L), java.util.Map.entry("get_font_color", 3444240500L),
			java.util.Map.entry("get_font_size", 3905245786L),
			java.util.Map.entry("set_stacked_outline_color", 2878471219L),
			java.util.Map.entry("get_stacked_shadow_outline_size", 923996154L),
			java.util.Map.entry("get_stacked_shadow_count", 3905245786L),
			java.util.Map.entry("move_stacked_outline", 3937882851L),
			java.util.Map.entry("set_stacked_outline_size", 3937882851L),
			java.util.Map.entry("set_stacked_shadow_outline_size", 3937882851L),
			java.util.Map.entry("set_stacked_shadow_count", 1286410249L));

	LabelSettings(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LabelSettings(long nativePointer) {
		super(nativePointer);
	}

	public void add_stacked_outline(long index) {
		super.call("add_stacked_outline", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void move_stacked_outline(long from_index, long to_position) {
		super.call("move_stacked_outline",
				new java.lang.Object[]{java.lang.Long.valueOf(from_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_stacked_outline(long index) {
		super.call("remove_stacked_outline", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stacked_outline_size(long index, long size) {
		super.call("set_stacked_outline_size",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(size)});
	}

	public int get_stacked_outline_size(long index) {
		return (int) super.call("get_stacked_outline_size", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stacked_outline_color(long index, Color color) {
		super.call("set_stacked_outline_color",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) color});
	}

	public Color get_stacked_outline_color(long index) {
		return (Color) super.call("get_stacked_outline_color", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_stacked_shadow(long index) {
		super.call("add_stacked_shadow", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void move_stacked_shadow(long from_index, long to_position) {
		super.call("move_stacked_shadow",
				new java.lang.Object[]{java.lang.Long.valueOf(from_index), java.lang.Long.valueOf(to_position)});
	}

	public void remove_stacked_shadow(long index) {
		super.call("remove_stacked_shadow", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stacked_shadow_offset(long index, Vector2 offset) {
		super.call("set_stacked_shadow_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) offset});
	}

	public Vector2 get_stacked_shadow_offset(long index) {
		return (Vector2) super.call("get_stacked_shadow_offset", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stacked_shadow_color(long index, Color color) {
		super.call("set_stacked_shadow_color",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) color});
	}

	public Color get_stacked_shadow_color(long index) {
		return (Color) super.call("get_stacked_shadow_color", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_stacked_shadow_outline_size(long index, long size) {
		super.call("set_stacked_shadow_outline_size",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(size)});
	}

	public int get_stacked_shadow_outline_size(long index) {
		return (int) super.call("get_stacked_shadow_outline_size",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public double getLine_spacing() {
		return (double) super.call("get_line_spacing", new java.lang.Object[0]);
	}

	public void setLine_spacing(double value) {
		super.call("set_line_spacing", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getParagraph_spacing() {
		return (double) super.call("get_paragraph_spacing", new java.lang.Object[0]);
	}

	public void setParagraph_spacing(double value) {
		super.call("set_paragraph_spacing", new java.lang.Object[]{java.lang.Double.valueOf(value)});
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

	public Color getFont_color() {
		return (Color) super.call("get_font_color", new java.lang.Object[0]);
	}

	public void setFont_color(Color value) {
		super.call("set_font_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getOutline_size() {
		return (long) super.call("get_outline_size", new java.lang.Object[0]);
	}

	public void setOutline_size(long value) {
		super.call("set_outline_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getOutline_color() {
		return (Color) super.call("get_outline_color", new java.lang.Object[0]);
	}

	public void setOutline_color(Color value) {
		super.call("set_outline_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getShadow_size() {
		return (long) super.call("get_shadow_size", new java.lang.Object[0]);
	}

	public void setShadow_size(long value) {
		super.call("set_shadow_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getShadow_color() {
		return (Color) super.call("get_shadow_color", new java.lang.Object[0]);
	}

	public void setShadow_color(Color value) {
		super.call("set_shadow_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getShadow_offset() {
		return (Vector2) super.call("get_shadow_offset", new java.lang.Object[0]);
	}

	public void setShadow_offset(Vector2 value) {
		super.call("set_shadow_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getStacked_outline_count() {
		return (long) super.call("get_stacked_outline_count", new java.lang.Object[0]);
	}

	public void setStacked_outline_count(long value) {
		super.call("set_stacked_outline_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStacked_shadow_count() {
		return (long) super.call("get_stacked_shadow_count", new java.lang.Object[0]);
	}

	public void setStacked_shadow_count(long value) {
		super.call("set_stacked_shadow_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
