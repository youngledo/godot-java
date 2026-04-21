package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class PopupMenu extends Popup {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_item_id", 3937882851L), java.util.Map.entry("set_item_submenu_node", 1068370740L),
			java.util.Map.entry("set_submenu_popup_delay", 373806689L),
			java.util.Map.entry("set_item_text", 501894301L), java.util.Map.entry("get_system_menu", 1222557358L),
			java.util.Map.entry("get_item_submenu", 844755477L), java.util.Map.entry("get_item_indent", 923996154L),
			java.util.Map.entry("toggle_item_checked", 1286410249L),
			java.util.Map.entry("add_multistate_item", 150780458L), java.util.Map.entry("set_item_count", 1286410249L),
			java.util.Map.entry("remove_item", 1286410249L), java.util.Map.entry("is_item_separator", 1116898809L),
			java.util.Map.entry("set_item_shortcut", 825127832L),
			java.util.Map.entry("add_icon_check_shortcut", 3856247530L),
			java.util.Map.entry("is_item_checkable", 1116898809L),
			java.util.Map.entry("get_item_shortcut", 1449483325L), java.util.Map.entry("add_item", 3674230041L),
			java.util.Map.entry("add_radio_check_shortcut", 1642193386L),
			java.util.Map.entry("get_item_text", 844755477L),
			java.util.Map.entry("get_item_icon_max_width", 923996154L),
			java.util.Map.entry("add_submenu_node_item", 1325455216L),
			java.util.Map.entry("is_item_shortcut_disabled", 1116898809L),
			java.util.Map.entry("set_allow_search", 2586408642L),
			java.util.Map.entry("is_item_radio_checkable", 1116898809L),
			java.util.Map.entry("is_hide_on_state_item_selection", 36873697L),
			java.util.Map.entry("get_item_text_direction", 4235602388L),
			java.util.Map.entry("set_item_icon", 666127730L), java.util.Map.entry("set_item_checked", 300928843L),
			java.util.Map.entry("get_focused_item", 3905245786L),
			java.util.Map.entry("set_item_icon_modulate", 2878471219L),
			java.util.Map.entry("is_item_disabled", 1116898809L),
			java.util.Map.entry("get_item_submenu_node", 2100501353L),
			java.util.Map.entry("set_item_accelerator", 2992817551L),
			java.util.Map.entry("is_hide_on_item_selection", 36873697L),
			java.util.Map.entry("add_separator", 2266703459L), java.util.Map.entry("is_prefer_native_menu", 36873697L),
			java.util.Map.entry("get_item_multistate_max", 923996154L),
			java.util.Map.entry("get_item_accelerator", 253789942L),
			java.util.Map.entry("activate_item_by_event", 3716412023L),
			java.util.Map.entry("toggle_item_multistate", 1286410249L),
			java.util.Map.entry("add_icon_check_item", 1086190128L),
			java.util.Map.entry("add_submenu_item", 2979222410L), java.util.Map.entry("get_item_tooltip", 844755477L),
			java.util.Map.entry("set_item_submenu", 501894301L),
			java.util.Map.entry("get_item_auto_translate_mode", 906302372L),
			java.util.Map.entry("get_shrink_height", 36873697L),
			java.util.Map.entry("set_item_multistate", 3937882851L), java.util.Map.entry("add_icon_item", 1086190128L),
			java.util.Map.entry("scroll_to_item", 1286410249L), java.util.Map.entry("set_shrink_height", 2586408642L),
			java.util.Map.entry("add_icon_radio_check_shortcut", 3856247530L),
			java.util.Map.entry("set_shrink_width", 2586408642L),
			java.util.Map.entry("get_submenu_popup_delay", 1740695150L),
			java.util.Map.entry("add_check_shortcut", 1642193386L),
			java.util.Map.entry("set_item_as_separator", 300928843L),
			java.util.Map.entry("get_item_multistate", 923996154L),
			java.util.Map.entry("set_item_multistate_max", 3937882851L),
			java.util.Map.entry("get_item_language", 844755477L), java.util.Map.entry("set_system_menu", 600639674L),
			java.util.Map.entry("get_item_index", 923996154L), java.util.Map.entry("get_allow_search", 36873697L),
			java.util.Map.entry("add_icon_shortcut", 2997871092L), java.util.Map.entry("set_item_indent", 3937882851L),
			java.util.Map.entry("add_radio_check_item", 3674230041L),
			java.util.Map.entry("set_item_text_direction", 1707680378L),
			java.util.Map.entry("set_item_disabled", 300928843L),
			java.util.Map.entry("set_hide_on_state_item_selection", 2586408642L),
			java.util.Map.entry("is_item_checked", 1116898809L), java.util.Map.entry("add_check_item", 3674230041L),
			java.util.Map.entry("is_hide_on_checkable_item_selection", 36873697L),
			java.util.Map.entry("set_item_metadata", 2152698145L),
			java.util.Map.entry("set_prefer_native_menu", 2586408642L),
			java.util.Map.entry("add_icon_radio_check_item", 1086190128L),
			java.util.Map.entry("set_item_as_radio_checkable", 300928843L),
			java.util.Map.entry("get_item_metadata", 4227898402L), java.util.Map.entry("get_item_count", 3905245786L),
			java.util.Map.entry("is_system_menu", 36873697L),
			java.util.Map.entry("set_item_icon_max_width", 3937882851L),
			java.util.Map.entry("get_item_icon_modulate", 3457211756L), java.util.Map.entry("clear", 107499316L),
			java.util.Map.entry("get_shrink_width", 36873697L), java.util.Map.entry("get_item_id", 923996154L),
			java.util.Map.entry("is_native_menu", 36873697L), java.util.Map.entry("set_item_language", 501894301L),
			java.util.Map.entry("set_hide_on_checkable_item_selection", 2586408642L),
			java.util.Map.entry("add_shortcut", 3451850107L),
			java.util.Map.entry("set_hide_on_item_selection", 2586408642L),
			java.util.Map.entry("get_item_icon", 3536238170L), java.util.Map.entry("set_item_tooltip", 501894301L),
			java.util.Map.entry("set_item_shortcut_disabled", 300928843L),
			java.util.Map.entry("set_item_auto_translate_mode", 287402019L),
			java.util.Map.entry("set_focused_item", 1286410249L),
			java.util.Map.entry("set_item_as_checkable", 300928843L));

	PopupMenu(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PopupMenu(long nativePointer) {
		super(nativePointer);
	}

	public boolean activate_item_by_event(InputEvent event, boolean for_global_only) {
		return (boolean) super.call("activate_item_by_event",
				new java.lang.Object[]{(java.lang.Object) event, java.lang.Boolean.valueOf(for_global_only)});
	}

	public boolean is_prefer_native_menu() {
		return (boolean) super.call("is_prefer_native_menu");
	}

	public boolean is_native_menu() {
		return (boolean) super.call("is_native_menu");
	}

	public void add_item(String label, long id, int accel) {
		super.call("add_item", new java.lang.Object[]{(java.lang.Object) label, java.lang.Long.valueOf(id),
				java.lang.Integer.valueOf(accel)});
	}

	public void add_icon_item(Texture2D texture, String label, long id, int accel) {
		super.call("add_icon_item", new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) label,
				java.lang.Long.valueOf(id), java.lang.Integer.valueOf(accel)});
	}

	public void add_check_item(String label, long id, int accel) {
		super.call("add_check_item", new java.lang.Object[]{(java.lang.Object) label, java.lang.Long.valueOf(id),
				java.lang.Integer.valueOf(accel)});
	}

	public void add_icon_check_item(Texture2D texture, String label, long id, int accel) {
		super.call("add_icon_check_item", new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) label,
				java.lang.Long.valueOf(id), java.lang.Integer.valueOf(accel)});
	}

	public void add_radio_check_item(String label, long id, int accel) {
		super.call("add_radio_check_item", new java.lang.Object[]{(java.lang.Object) label, java.lang.Long.valueOf(id),
				java.lang.Integer.valueOf(accel)});
	}

	public void add_icon_radio_check_item(Texture2D texture, String label, long id, int accel) {
		super.call("add_icon_radio_check_item", new java.lang.Object[]{(java.lang.Object) texture,
				(java.lang.Object) label, java.lang.Long.valueOf(id), java.lang.Integer.valueOf(accel)});
	}

	public void add_multistate_item(String label, long max_states, long default_state, long id, int accel) {
		super.call("add_multistate_item",
				new java.lang.Object[]{(java.lang.Object) label, java.lang.Long.valueOf(max_states),
						java.lang.Long.valueOf(default_state), java.lang.Long.valueOf(id),
						java.lang.Integer.valueOf(accel)});
	}

	public void add_shortcut(Shortcut shortcut, long id, boolean global, boolean allow_echo) {
		super.call("add_shortcut", new java.lang.Object[]{(java.lang.Object) shortcut, java.lang.Long.valueOf(id),
				java.lang.Boolean.valueOf(global), java.lang.Boolean.valueOf(allow_echo)});
	}

	public void add_icon_shortcut(Texture2D texture, Shortcut shortcut, long id, boolean global, boolean allow_echo) {
		super.call("add_icon_shortcut", new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) shortcut,
				java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(global), java.lang.Boolean.valueOf(allow_echo)});
	}

	public void add_check_shortcut(Shortcut shortcut, long id, boolean global) {
		super.call("add_check_shortcut", new java.lang.Object[]{(java.lang.Object) shortcut, java.lang.Long.valueOf(id),
				java.lang.Boolean.valueOf(global)});
	}

	public void add_icon_check_shortcut(Texture2D texture, Shortcut shortcut, long id, boolean global) {
		super.call("add_icon_check_shortcut", new java.lang.Object[]{(java.lang.Object) texture,
				(java.lang.Object) shortcut, java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(global)});
	}

	public void add_radio_check_shortcut(Shortcut shortcut, long id, boolean global) {
		super.call("add_radio_check_shortcut", new java.lang.Object[]{(java.lang.Object) shortcut,
				java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(global)});
	}

	public void add_icon_radio_check_shortcut(Texture2D texture, Shortcut shortcut, long id, boolean global) {
		super.call("add_icon_radio_check_shortcut", new java.lang.Object[]{(java.lang.Object) texture,
				(java.lang.Object) shortcut, java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(global)});
	}

	public void add_submenu_item(String label, String submenu, long id) {
		super.call("add_submenu_item", new java.lang.Object[]{(java.lang.Object) label, (java.lang.Object) submenu,
				java.lang.Long.valueOf(id)});
	}

	public void add_submenu_node_item(String label, PopupMenu submenu, long id) {
		super.call("add_submenu_node_item", new java.lang.Object[]{(java.lang.Object) label, (java.lang.Object) submenu,
				java.lang.Long.valueOf(id)});
	}

	public void set_item_text(long index, String text) {
		super.call("set_item_text", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) text});
	}

	public void set_item_text_direction(long index, int direction) {
		super.call("set_item_text_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(direction)});
	}

	public void set_item_language(long index, String language) {
		super.call("set_item_language",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) language});
	}

	public void set_item_auto_translate_mode(long index, int mode) {
		super.call("set_item_auto_translate_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(mode)});
	}

	public void set_item_icon(long index, Texture2D icon) {
		super.call("set_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) icon});
	}

	public void set_item_icon_max_width(long index, long width) {
		super.call("set_item_icon_max_width",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(width)});
	}

	public void set_item_icon_modulate(long index, Color modulate) {
		super.call("set_item_icon_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) modulate});
	}

	public void set_item_checked(long index, boolean checked) {
		super.call("set_item_checked",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(checked)});
	}

	public void set_item_id(long index, long id) {
		super.call("set_item_id", new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(id)});
	}

	public void set_item_accelerator(long index, int accel) {
		super.call("set_item_accelerator",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Integer.valueOf(accel)});
	}

	public void set_item_metadata(long index, Object metadata) {
		super.call("set_item_metadata",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) metadata});
	}

	public void set_item_disabled(long index, boolean disabled) {
		super.call("set_item_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(disabled)});
	}

	public void set_item_submenu(long index, String submenu) {
		super.call("set_item_submenu",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) submenu});
	}

	public void set_item_submenu_node(long index, PopupMenu submenu) {
		super.call("set_item_submenu_node",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) submenu});
	}

	public void set_item_as_separator(long index, boolean enable) {
		super.call("set_item_as_separator",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enable)});
	}

	public void set_item_as_checkable(long index, boolean enable) {
		super.call("set_item_as_checkable",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enable)});
	}

	public void set_item_as_radio_checkable(long index, boolean enable) {
		super.call("set_item_as_radio_checkable",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enable)});
	}

	public void set_item_tooltip(long index, String tooltip) {
		super.call("set_item_tooltip",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) tooltip});
	}

	public void set_item_shortcut(long index, Shortcut shortcut, boolean global) {
		super.call("set_item_shortcut", new java.lang.Object[]{java.lang.Long.valueOf(index),
				(java.lang.Object) shortcut, java.lang.Boolean.valueOf(global)});
	}

	public void set_item_indent(long index, long indent) {
		super.call("set_item_indent",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(indent)});
	}

	public void set_item_multistate(long index, long state) {
		super.call("set_item_multistate",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(state)});
	}

	public void set_item_multistate_max(long index, long max_states) {
		super.call("set_item_multistate_max",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(max_states)});
	}

	public void set_item_shortcut_disabled(long index, boolean disabled) {
		super.call("set_item_shortcut_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(disabled)});
	}

	public void toggle_item_checked(long index) {
		super.call("toggle_item_checked", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void toggle_item_multistate(long index) {
		super.call("toggle_item_multistate", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_item_text(long index) {
		return (String) super.call("get_item_text", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_text_direction(long index) {
		return (int) super.call("get_item_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_item_language(long index) {
		return (String) super.call("get_item_language", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_auto_translate_mode(long index) {
		return (int) super.call("get_item_auto_translate_mode", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Texture2D get_item_icon(long index) {
		return (Texture2D) super.call("get_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_icon_max_width(long index) {
		return (int) super.call("get_item_icon_max_width", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Color get_item_icon_modulate(long index) {
		return (Color) super.call("get_item_icon_modulate", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean is_item_checked(long index) {
		return (boolean) super.call("is_item_checked", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_id(long index) {
		return (int) super.call("get_item_id", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_index(long id) {
		return (int) super.call("get_item_index", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public int get_item_accelerator(long index) {
		return (int) super.call("get_item_accelerator", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Object get_item_metadata(long index) {
		return (Object) super.call("get_item_metadata", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean is_item_disabled(long index) {
		return (boolean) super.call("is_item_disabled", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_item_submenu(long index) {
		return (String) super.call("get_item_submenu", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public PopupMenu get_item_submenu_node(long index) {
		return (PopupMenu) super.call("get_item_submenu_node", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean is_item_separator(long index) {
		return (boolean) super.call("is_item_separator", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean is_item_checkable(long index) {
		return (boolean) super.call("is_item_checkable", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean is_item_radio_checkable(long index) {
		return (boolean) super.call("is_item_radio_checkable", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean is_item_shortcut_disabled(long index) {
		return (boolean) super.call("is_item_shortcut_disabled", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_item_tooltip(long index) {
		return (String) super.call("get_item_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public Shortcut get_item_shortcut(long index) {
		return (Shortcut) super.call("get_item_shortcut", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_indent(long index) {
		return (int) super.call("get_item_indent", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_multistate_max(long index) {
		return (int) super.call("get_item_multistate_max", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_item_multistate(long index) {
		return (int) super.call("get_item_multistate", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void scroll_to_item(long index) {
		super.call("scroll_to_item", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void remove_item(long index) {
		super.call("remove_item", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_separator(String label, long id) {
		super.call("add_separator", new java.lang.Object[]{(java.lang.Object) label, java.lang.Long.valueOf(id)});
	}

	public void clear(boolean free_submenus) {
		super.call("clear", new java.lang.Object[]{java.lang.Boolean.valueOf(free_submenus)});
	}

	public boolean is_hide_on_item_selection() {
		return (boolean) super.call("is_hide_on_item_selection");
	}

	public boolean is_hide_on_checkable_item_selection() {
		return (boolean) super.call("is_hide_on_checkable_item_selection");
	}

	public boolean is_hide_on_state_item_selection() {
		return (boolean) super.call("is_hide_on_state_item_selection");
	}

	public boolean is_system_menu() {
		return (boolean) super.call("is_system_menu");
	}

	public boolean isHide_on_item_selection() {
		return (boolean) super.call("is_hide_on_item_selection", new java.lang.Object[0]);
	}

	public void setHide_on_item_selection(boolean value) {
		super.call("set_hide_on_item_selection", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHide_on_checkable_item_selection() {
		return (boolean) super.call("is_hide_on_checkable_item_selection", new java.lang.Object[0]);
	}

	public void setHide_on_checkable_item_selection(boolean value) {
		super.call("set_hide_on_checkable_item_selection", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHide_on_state_item_selection() {
		return (boolean) super.call("is_hide_on_state_item_selection", new java.lang.Object[0]);
	}

	public void setHide_on_state_item_selection(boolean value) {
		super.call("set_hide_on_state_item_selection", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSubmenu_popup_delay() {
		return (double) super.call("get_submenu_popup_delay", new java.lang.Object[0]);
	}

	public void setSubmenu_popup_delay(double value) {
		super.call("set_submenu_popup_delay", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getAllow_search() {
		return (boolean) super.call("get_allow_search", new java.lang.Object[0]);
	}

	public void setAllow_search(boolean value) {
		super.call("set_allow_search", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSystem_menu_id() {
		return (long) super.call("get_system_menu", new java.lang.Object[0]);
	}

	public void setSystem_menu_id(long value) {
		super.call("set_system_menu", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isPrefer_native_menu() {
		return (boolean) super.call("is_prefer_native_menu", new java.lang.Object[0]);
	}

	public void setPrefer_native_menu(boolean value) {
		super.call("set_prefer_native_menu", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getShrink_height() {
		return (boolean) super.call("get_shrink_height", new java.lang.Object[0]);
	}

	public void setShrink_height(boolean value) {
		super.call("set_shrink_height", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getShrink_width() {
		return (boolean) super.call("get_shrink_width", new java.lang.Object[0]);
	}

	public void setShrink_width(boolean value) {
		super.call("set_shrink_width", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getItem_count() {
		return (long) super.call("get_item_count", new java.lang.Object[0]);
	}

	public void setItem_count(long value) {
		super.call("set_item_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
