package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class LinkButton extends BaseButton {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_text_direction", 119160795L),
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("get_text_direction", 797257663L), java.util.Map.entry("get_text", 201670096L),
			java.util.Map.entry("set_ellipsis_char", 83702148L), java.util.Map.entry("get_uri", 201670096L),
			java.util.Map.entry("get_text_overrun_behavior", 3779142101L),
			java.util.Map.entry("set_underline_mode", 4032947085L),
			java.util.Map.entry("get_ellipsis_char", 201670096L), java.util.Map.entry("get_language", 201670096L),
			java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("set_text", 83702148L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("get_underline_mode", 568343738L), java.util.Map.entry("set_uri", 83702148L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("set_text_overrun_behavior", 1008890932L));

	LinkButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	LinkButton(long nativePointer) {
		super(nativePointer);
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getUnderline() {
		return (long) super.call("get_underline_mode", new java.lang.Object[0]);
	}

	public void setUnderline(long value) {
		super.call("set_underline_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getUri() {
		return (String) super.call("get_uri", new java.lang.Object[0]);
	}

	public void setUri(String value) {
		super.call("set_uri", new java.lang.Object[]{(java.lang.Object) value});
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
