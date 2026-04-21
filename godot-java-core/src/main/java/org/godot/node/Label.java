package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Rect2;

public class Label extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_visible_characters_behavior", 258789322L),
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("get_label_settings", 826676056L),
			java.util.Map.entry("get_visible_ratio", 1740695150L),
			java.util.Map.entry("set_paragraph_separator", 83702148L),
			java.util.Map.entry("get_vertical_alignment", 3274884059L),
			java.util.Map.entry("get_lines_skipped", 3905245786L), java.util.Map.entry("get_tab_stops", 675695659L),
			java.util.Map.entry("get_language", 201670096L), java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("set_uppercase", 2586408642L),
			java.util.Map.entry("get_max_lines_visible", 3905245786L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("set_lines_skipped", 1286410249L), java.util.Map.entry("set_tab_stops", 2899603908L),
			java.util.Map.entry("get_total_character_count", 3905245786L),
			java.util.Map.entry("is_clipping_text", 36873697L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("set_visible_characters", 1286410249L), java.util.Map.entry("get_text", 201670096L),
			java.util.Map.entry("set_visible_ratio", 373806689L),
			java.util.Map.entry("get_text_overrun_behavior", 3779142101L), java.util.Map.entry("set_text", 83702148L),
			java.util.Map.entry("set_autowrap_trim_flags", 2809697122L),
			java.util.Map.entry("get_line_count", 3905245786L), java.util.Map.entry("get_text_direction", 797257663L),
			java.util.Map.entry("get_paragraph_separator", 201670096L),
			java.util.Map.entry("get_visible_line_count", 3905245786L),
			java.util.Map.entry("get_autowrap_mode", 1549071663L),
			java.util.Map.entry("set_autowrap_mode", 3289138044L),
			java.util.Map.entry("set_justification_flags", 2877345813L),
			java.util.Map.entry("get_autowrap_trim_flags", 2340632602L), java.util.Map.entry("is_uppercase", 36873697L),
			java.util.Map.entry("get_ellipsis_char", 201670096L),
			java.util.Map.entry("set_max_lines_visible", 1286410249L),
			java.util.Map.entry("set_clip_text", 2586408642L),
			java.util.Map.entry("get_horizontal_alignment", 341400642L),
			java.util.Map.entry("set_text_direction", 119160795L),
			java.util.Map.entry("set_visible_characters_behavior", 3383839701L),
			java.util.Map.entry("set_label_settings", 1030653839L),
			java.util.Map.entry("get_visible_characters", 3905245786L),
			java.util.Map.entry("set_horizontal_alignment", 2312603777L),
			java.util.Map.entry("set_ellipsis_char", 83702148L),
			java.util.Map.entry("get_character_bounds", 3327874267L),
			java.util.Map.entry("get_justification_flags", 1583363614L),
			java.util.Map.entry("set_vertical_alignment", 1796458609L),
			java.util.Map.entry("set_text_overrun_behavior", 1008890932L),
			java.util.Map.entry("get_line_height", 181039630L));

	Label(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Label(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_clipping_text() {
		return (boolean) super.call("is_clipping_text");
	}

	public boolean is_uppercase() {
		return (boolean) super.call("is_uppercase");
	}

	public int get_line_height(long line) {
		return (int) super.call("get_line_height", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public Rect2 get_character_bounds(long pos) {
		return (Rect2) super.call("get_character_bounds", new java.lang.Object[]{java.lang.Long.valueOf(pos)});
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public LabelSettings getLabel_settings() {
		return (LabelSettings) super.call("get_label_settings", new java.lang.Object[0]);
	}

	public void setLabel_settings(LabelSettings value) {
		super.call("set_label_settings", new java.lang.Object[]{(java.lang.Object) value});
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

	public long getAutowrap_mode() {
		return (long) super.call("get_autowrap_mode", new java.lang.Object[0]);
	}

	public void setAutowrap_mode(long value) {
		super.call("set_autowrap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAutowrap_trim_flags() {
		return (long) super.call("get_autowrap_trim_flags", new java.lang.Object[0]);
	}

	public void setAutowrap_trim_flags(long value) {
		super.call("set_autowrap_trim_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getJustification_flags() {
		return (long) super.call("get_justification_flags", new java.lang.Object[0]);
	}

	public void setJustification_flags(long value) {
		super.call("set_justification_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getParagraph_separator() {
		return (String) super.call("get_paragraph_separator", new java.lang.Object[0]);
	}

	public void setParagraph_separator(String value) {
		super.call("set_paragraph_separator", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isClip_text() {
		return (boolean) super.call("is_clipping_text", new java.lang.Object[0]);
	}

	public void setClip_text(boolean value) {
		super.call("set_clip_text", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public boolean isUppercase() {
		return (boolean) super.call("is_uppercase", new java.lang.Object[0]);
	}

	public void setUppercase(boolean value) {
		super.call("set_uppercase", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double[] getTab_stops() {
		return (double[]) super.call("get_tab_stops", new java.lang.Object[0]);
	}

	public void setTab_stops(double[] value) {
		super.call("set_tab_stops", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLines_skipped() {
		return (long) super.call("get_lines_skipped", new java.lang.Object[0]);
	}

	public void setLines_skipped(long value) {
		super.call("set_lines_skipped", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMax_lines_visible() {
		return (long) super.call("get_max_lines_visible", new java.lang.Object[0]);
	}

	public void setMax_lines_visible(long value) {
		super.call("set_max_lines_visible", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVisible_characters() {
		return (long) super.call("get_visible_characters", new java.lang.Object[0]);
	}

	public void setVisible_characters(long value) {
		super.call("set_visible_characters", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVisible_characters_behavior() {
		return (long) super.call("get_visible_characters_behavior", new java.lang.Object[0]);
	}

	public void setVisible_characters_behavior(long value) {
		super.call("set_visible_characters_behavior", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getVisible_ratio() {
		return (double) super.call("get_visible_ratio", new java.lang.Object[0]);
	}

	public void setVisible_ratio(double value) {
		super.call("set_visible_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
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
