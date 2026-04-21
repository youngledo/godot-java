package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MenuBar extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_switch_on_hover", 2240911060L),
			java.util.Map.entry("set_text_direction", 119160795L), java.util.Map.entry("get_menu_tooltip", 844755477L),
			java.util.Map.entry("get_text_direction", 797257663L), java.util.Map.entry("set_menu_tooltip", 501894301L),
			java.util.Map.entry("set_start_index", 1286410249L), java.util.Map.entry("set_menu_disabled", 300928843L),
			java.util.Map.entry("set_menu_hidden", 300928843L), java.util.Map.entry("is_native_menu", 36873697L),
			java.util.Map.entry("set_prefer_global_menu", 2586408642L), java.util.Map.entry("set_flat", 2586408642L),
			java.util.Map.entry("get_menu_popup", 2100501353L),
			java.util.Map.entry("set_disable_shortcuts", 2586408642L), java.util.Map.entry("get_language", 201670096L),
			java.util.Map.entry("set_language", 83702148L), java.util.Map.entry("set_switch_on_hover", 2586408642L),
			java.util.Map.entry("is_prefer_global_menu", 36873697L),
			java.util.Map.entry("is_menu_disabled", 1116898809L), java.util.Map.entry("get_menu_count", 3905245786L),
			java.util.Map.entry("set_menu_title", 501894301L), java.util.Map.entry("is_flat", 36873697L),
			java.util.Map.entry("get_start_index", 3905245786L), java.util.Map.entry("get_menu_title", 844755477L),
			java.util.Map.entry("is_menu_hidden", 1116898809L));

	MenuBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MenuBar(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_switch_on_hover() {
		return (boolean) super.call("is_switch_on_hover");
	}

	public boolean is_prefer_global_menu() {
		return (boolean) super.call("is_prefer_global_menu");
	}

	public boolean is_native_menu() {
		return (boolean) super.call("is_native_menu");
	}

	public boolean is_flat() {
		return (boolean) super.call("is_flat");
	}

	public void set_menu_title(long menu, String title) {
		super.call("set_menu_title", new java.lang.Object[]{java.lang.Long.valueOf(menu), (java.lang.Object) title});
	}

	public String get_menu_title(long menu) {
		return (String) super.call("get_menu_title", new java.lang.Object[]{java.lang.Long.valueOf(menu)});
	}

	public void set_menu_tooltip(long menu, String tooltip) {
		super.call("set_menu_tooltip",
				new java.lang.Object[]{java.lang.Long.valueOf(menu), (java.lang.Object) tooltip});
	}

	public String get_menu_tooltip(long menu) {
		return (String) super.call("get_menu_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(menu)});
	}

	public void set_menu_disabled(long menu, boolean disabled) {
		super.call("set_menu_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(menu), java.lang.Boolean.valueOf(disabled)});
	}

	public boolean is_menu_disabled(long menu) {
		return (boolean) super.call("is_menu_disabled", new java.lang.Object[]{java.lang.Long.valueOf(menu)});
	}

	public void set_menu_hidden(long menu, boolean hidden) {
		super.call("set_menu_hidden",
				new java.lang.Object[]{java.lang.Long.valueOf(menu), java.lang.Boolean.valueOf(hidden)});
	}

	public boolean is_menu_hidden(long menu) {
		return (boolean) super.call("is_menu_hidden", new java.lang.Object[]{java.lang.Long.valueOf(menu)});
	}

	public PopupMenu get_menu_popup(long menu) {
		return (PopupMenu) super.call("get_menu_popup", new java.lang.Object[]{java.lang.Long.valueOf(menu)});
	}

	public boolean isFlat() {
		return (boolean) super.call("is_flat", new java.lang.Object[0]);
	}

	public void setFlat(boolean value) {
		super.call("set_flat", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getStart_index() {
		return (long) super.call("get_start_index", new java.lang.Object[0]);
	}

	public void setStart_index(long value) {
		super.call("set_start_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isSwitch_on_hover() {
		return (boolean) super.call("is_switch_on_hover", new java.lang.Object[0]);
	}

	public void setSwitch_on_hover(boolean value) {
		super.call("set_switch_on_hover", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPrefer_global_menu() {
		return (boolean) super.call("is_prefer_global_menu", new java.lang.Object[0]);
	}

	public void setPrefer_global_menu(boolean value) {
		super.call("set_prefer_global_menu", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
