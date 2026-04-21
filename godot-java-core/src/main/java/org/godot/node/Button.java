package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Button extends BaseButton {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_expand_icon", 36873697L), java.util.Map.entry("set_text_alignment", 2312603777L),
			java.util.Map.entry("get_text_direction", 797257663L),
			java.util.Map.entry("get_autowrap_mode", 1549071663L), java.util.Map.entry("get_button_icon", 3635182373L),
			java.util.Map.entry("get_vertical_icon_alignment", 3274884059L),
			java.util.Map.entry("set_autowrap_mode", 3289138044L),
			java.util.Map.entry("get_autowrap_trim_flags", 2340632602L),
			java.util.Map.entry("get_language", 201670096L), java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("set_clip_text", 2586408642L), java.util.Map.entry("set_text_direction", 119160795L),
			java.util.Map.entry("set_expand_icon", 2586408642L), java.util.Map.entry("get_text", 201670096L),
			java.util.Map.entry("get_text_alignment", 341400642L),
			java.util.Map.entry("get_text_overrun_behavior", 3779142101L),
			java.util.Map.entry("get_icon_alignment", 341400642L), java.util.Map.entry("set_flat", 2586408642L),
			java.util.Map.entry("set_button_icon", 4051416890L), java.util.Map.entry("get_clip_text", 36873697L),
			java.util.Map.entry("set_text", 83702148L), java.util.Map.entry("set_vertical_icon_alignment", 1796458609L),
			java.util.Map.entry("is_flat", 36873697L), java.util.Map.entry("set_autowrap_trim_flags", 2809697122L),
			java.util.Map.entry("set_icon_alignment", 2312603777L),
			java.util.Map.entry("set_text_overrun_behavior", 1008890932L));

	Button(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Button(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_flat() {
		return (boolean) super.call("is_flat");
	}

	public boolean is_expand_icon() {
		return (boolean) super.call("is_expand_icon");
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getIcon() {
		return (Texture2D) super.call("get_button_icon", new java.lang.Object[0]);
	}

	public void setIcon(Texture2D value) {
		super.call("set_button_icon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFlat() {
		return (boolean) super.call("is_flat", new java.lang.Object[0]);
	}

	public void setFlat(boolean value) {
		super.call("set_flat", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAlignment() {
		return (long) super.call("get_text_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_text_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getText_overrun_behavior() {
		return (long) super.call("get_text_overrun_behavior", new java.lang.Object[0]);
	}

	public void setText_overrun_behavior(long value) {
		super.call("set_text_overrun_behavior", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public boolean getClip_text() {
		return (boolean) super.call("get_clip_text", new java.lang.Object[0]);
	}

	public void setClip_text(boolean value) {
		super.call("set_clip_text", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getIcon_alignment() {
		return (long) super.call("get_icon_alignment", new java.lang.Object[0]);
	}

	public void setIcon_alignment(long value) {
		super.call("set_icon_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVertical_icon_alignment() {
		return (long) super.call("get_vertical_icon_alignment", new java.lang.Object[0]);
	}

	public void setVertical_icon_alignment(long value) {
		super.call("set_vertical_icon_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isExpand_icon() {
		return (boolean) super.call("is_expand_icon", new java.lang.Object[0]);
	}

	public void setExpand_icon(boolean value) {
		super.call("set_expand_icon", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
}
