package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OptionButton extends Button {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_icon_item", 3781678508L), java.util.Map.entry("set_item_id", 3937882851L),
			java.util.Map.entry("get_selected", 3905245786L), java.util.Map.entry("set_allow_reselect", 2586408642L),
			java.util.Map.entry("select", 1286410249L), java.util.Map.entry("show_popup", 3218959716L),
			java.util.Map.entry("set_item_text", 501894301L), java.util.Map.entry("get_item_index", 923996154L),
			java.util.Map.entry("is_fit_to_longest_item", 36873697L),
			java.util.Map.entry("set_disable_shortcuts", 2586408642L),
			java.util.Map.entry("set_item_count", 1286410249L), java.util.Map.entry("remove_item", 1286410249L),
			java.util.Map.entry("set_item_disabled", 300928843L),
			java.util.Map.entry("get_selectable_item", 894402480L),
			java.util.Map.entry("is_item_separator", 1116898809L),
			java.util.Map.entry("set_item_metadata", 2152698145L),
			java.util.Map.entry("get_item_metadata", 4227898402L),
			java.util.Map.entry("has_selectable_items", 36873697L), java.util.Map.entry("add_item", 2697778442L),
			java.util.Map.entry("get_item_text", 844755477L), java.util.Map.entry("get_item_count", 3905245786L),
			java.util.Map.entry("set_fit_to_longest_item", 2586408642L),
			java.util.Map.entry("get_allow_reselect", 36873697L), java.util.Map.entry("set_item_icon", 666127730L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("is_item_disabled", 1116898809L),
			java.util.Map.entry("get_item_id", 923996154L), java.util.Map.entry("add_separator", 3005725572L),
			java.util.Map.entry("get_selected_id", 3905245786L), java.util.Map.entry("get_popup", 229722558L),
			java.util.Map.entry("get_item_tooltip", 844755477L), java.util.Map.entry("get_item_icon", 3536238170L),
			java.util.Map.entry("set_item_tooltip", 501894301L),
			java.util.Map.entry("set_item_auto_translate_mode", 287402019L),
			java.util.Map.entry("get_selected_metadata", 1214101251L),
			java.util.Map.entry("get_item_auto_translate_mode", 906302372L));

	OptionButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OptionButton(long nativePointer) {
		super(nativePointer);
	}

	public void add_item(String label, long id) {
		super.call("add_item", new java.lang.Object[]{(java.lang.Object) label, java.lang.Long.valueOf(id)});
	}

	public void add_icon_item(Texture2D texture, String label, long id) {
		super.call("add_icon_item", new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) label,
				java.lang.Long.valueOf(id)});
	}

	public void set_item_text(long idx, String text) {
		super.call("set_item_text", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) text});
	}

	public void set_item_icon(long idx, Texture2D texture) {
		super.call("set_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) texture});
	}

	public void set_item_disabled(long idx, boolean disabled) {
		super.call("set_item_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(disabled)});
	}

	public void set_item_id(long idx, long id) {
		super.call("set_item_id", new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Long.valueOf(id)});
	}

	public void set_item_metadata(long idx, Object metadata) {
		super.call("set_item_metadata",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) metadata});
	}

	public void set_item_tooltip(long idx, String tooltip) {
		super.call("set_item_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(idx), (java.lang.Object) tooltip});
	}

	public void set_item_auto_translate_mode(long idx, int mode) {
		super.call("set_item_auto_translate_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(idx), java.lang.Integer.valueOf(mode)});
	}

	public String get_item_text(long idx) {
		return (String) super.call("get_item_text", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public Texture2D get_item_icon(long idx) {
		return (Texture2D) super.call("get_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_item_id(long idx) {
		return (int) super.call("get_item_id", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_item_index(long id) {
		return (int) super.call("get_item_index", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public Object get_item_metadata(long idx) {
		return (Object) super.call("get_item_metadata", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_item_tooltip(long idx) {
		return (String) super.call("get_item_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int get_item_auto_translate_mode(long idx) {
		return (int) super.call("get_item_auto_translate_mode", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean is_item_disabled(long idx) {
		return (boolean) super.call("is_item_disabled", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean is_item_separator(long idx) {
		return (boolean) super.call("is_item_separator", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void add_separator(String text) {
		super.call("add_separator", new java.lang.Object[]{(java.lang.Object) text});
	}

	public void clear() {
		super.call("clear");
	}

	public void select(long idx) {
		super.call("select", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void remove_item(long idx) {
		super.call("remove_item", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void show_popup() {
		super.call("show_popup");
	}

	public boolean has_selectable_items() {
		return (boolean) super.call("has_selectable_items");
	}

	public int get_selectable_item(boolean from_last) {
		return (int) super.call("get_selectable_item", new java.lang.Object[]{java.lang.Boolean.valueOf(from_last)});
	}

	public boolean is_fit_to_longest_item() {
		return (boolean) super.call("is_fit_to_longest_item");
	}

	public long getSelected() {
		return (long) super.call("get_selected", new java.lang.Object[0]);
	}

	public void setSelected(long value) {
		super.call("_select_int", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isFit_to_longest_item() {
		return (boolean) super.call("is_fit_to_longest_item", new java.lang.Object[0]);
	}

	public void setFit_to_longest_item(boolean value) {
		super.call("set_fit_to_longest_item", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAllow_reselect() {
		return (boolean) super.call("get_allow_reselect", new java.lang.Object[0]);
	}

	public void setAllow_reselect(boolean value) {
		super.call("set_allow_reselect", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getItem_count() {
		return (long) super.call("get_item_count", new java.lang.Object[0]);
	}

	public void setItem_count(long value) {
		super.call("set_item_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
