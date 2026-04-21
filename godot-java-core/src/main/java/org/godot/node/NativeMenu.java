package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class NativeMenu extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_popup_open_callback", 3379118538L), java.util.Map.entry("has_menu", 4155700596L),
			java.util.Map.entry("set_item_text", 4153150897L), java.util.Map.entry("get_system_menu", 469707506L),
			java.util.Map.entry("get_item_submenu", 1066463050L),
			java.util.Map.entry("add_multistate_item", 2674635658L), java.util.Map.entry("remove_item", 3411492887L),
			java.util.Map.entry("set_interface_direction", 1265174801L), java.util.Map.entry("get_size", 2440833711L),
			java.util.Map.entry("set_item_radio_checkable", 2658558584L),
			java.util.Map.entry("get_item_indentation_level", 1120910005L),
			java.util.Map.entry("is_item_checkable", 3120086654L), java.util.Map.entry("get_item_state", 1120910005L),
			java.util.Map.entry("add_item", 980552939L), java.util.Map.entry("get_item_text", 1464764419L),
			java.util.Map.entry("get_item_tag", 4069510997L),
			java.util.Map.entry("is_item_radio_checkable", 3120086654L),
			java.util.Map.entry("set_item_callback", 2779810226L), java.util.Map.entry("set_item_checked", 2658558584L),
			java.util.Map.entry("set_item_icon", 1388763257L), java.util.Map.entry("is_item_disabled", 3120086654L),
			java.util.Map.entry("set_item_key_callback", 2779810226L),
			java.util.Map.entry("get_system_menu_text", 1281499290L),
			java.util.Map.entry("set_item_accelerator", 786300043L), java.util.Map.entry("add_separator", 448810126L),
			java.util.Map.entry("get_popup_close_callback", 3170603026L),
			java.util.Map.entry("get_item_accelerator", 316800700L),
			java.util.Map.entry("get_minimum_width", 866169185L), java.util.Map.entry("get_item_callback", 1639989698L),
			java.util.Map.entry("set_item_state", 4288446313L), java.util.Map.entry("set_minimum_width", 1794382983L),
			java.util.Map.entry("add_submenu_item", 1002030223L),
			java.util.Map.entry("add_icon_check_item", 1372188274L),
			java.util.Map.entry("get_item_tooltip", 1464764419L),
			java.util.Map.entry("set_popup_close_callback", 3379118538L),
			java.util.Map.entry("set_system_menu_text", 3925225603L),
			java.util.Map.entry("has_system_menu", 718213027L), java.util.Map.entry("set_item_submenu", 2310537182L),
			java.util.Map.entry("add_icon_item", 1372188274L), java.util.Map.entry("set_item_tag", 2706844827L),
			java.util.Map.entry("get_popup_open_callback", 3170603026L),
			java.util.Map.entry("find_item_index_with_text", 1362438794L),
			java.util.Map.entry("get_system_menu_name", 1281499290L),
			java.util.Map.entry("is_item_hidden", 3120086654L), java.util.Map.entry("create_menu", 529393457L),
			java.util.Map.entry("set_item_checkable", 2658558584L),
			java.util.Map.entry("add_radio_check_item", 980552939L),
			java.util.Map.entry("set_item_hidden", 2658558584L), java.util.Map.entry("set_item_disabled", 2658558584L),
			java.util.Map.entry("is_item_checked", 3120086654L), java.util.Map.entry("add_check_item", 980552939L),
			java.util.Map.entry("get_item_key_callback", 1639989698L),
			java.util.Map.entry("add_icon_radio_check_item", 1372188274L),
			java.util.Map.entry("get_item_count", 2198884583L), java.util.Map.entry("get_item_max_states", 1120910005L),
			java.util.Map.entry("is_system_menu", 4155700596L), java.util.Map.entry("clear", 2722037293L),
			java.util.Map.entry("set_item_max_states", 4288446313L), java.util.Map.entry("popup", 2450610377L),
			java.util.Map.entry("is_opened", 4155700596L), java.util.Map.entry("free_menu", 2722037293L),
			java.util.Map.entry("find_item_index_with_submenu", 893635918L),
			java.util.Map.entry("get_item_icon", 3391850701L), java.util.Map.entry("set_item_tooltip", 4153150897L),
			java.util.Map.entry("find_item_index_with_tag", 1260085030L),
			java.util.Map.entry("set_item_indentation_level", 4288446313L),
			java.util.Map.entry("has_feature", 1708975490L),
			java.util.Map.entry("set_item_hover_callbacks", 2779810226L));

	NativeMenu(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NativeMenu(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_feature(int feature) {
		return (boolean) super.call("has_feature", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public boolean has_system_menu(int menu_id) {
		return (boolean) super.call("has_system_menu", new java.lang.Object[]{java.lang.Integer.valueOf(menu_id)});
	}

	public long get_system_menu(int menu_id) {
		return (long) super.call("get_system_menu", new java.lang.Object[]{java.lang.Integer.valueOf(menu_id)});
	}

	public String get_system_menu_name(int menu_id) {
		return (String) super.call("get_system_menu_name", new java.lang.Object[]{java.lang.Integer.valueOf(menu_id)});
	}

	public String get_system_menu_text(int menu_id) {
		return (String) super.call("get_system_menu_text", new java.lang.Object[]{java.lang.Integer.valueOf(menu_id)});
	}

	public void set_system_menu_text(int menu_id, String name) {
		super.call("set_system_menu_text",
				new java.lang.Object[]{java.lang.Integer.valueOf(menu_id), (java.lang.Object) name});
	}

	public long create_menu() {
		return (long) super.call("create_menu");
	}

	public boolean has_menu(long rid) {
		return (boolean) super.call("has_menu", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void free_menu(long rid) {
		super.call("free_menu", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public Vector2 get_size(long rid) {
		return (Vector2) super.call("get_size", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void popup(long rid, Vector2i position) {
		super.call("popup", new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) position});
	}

	public void set_interface_direction(long rid, boolean is_rtl) {
		super.call("set_interface_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Boolean.valueOf(is_rtl)});
	}

	public void set_popup_open_callback(long rid, Callable callback) {
		super.call("set_popup_open_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) callback});
	}

	public Callable get_popup_open_callback(long rid) {
		return (Callable) super.call("get_popup_open_callback", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void set_popup_close_callback(long rid, Callable callback) {
		super.call("set_popup_close_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) callback});
	}

	public Callable get_popup_close_callback(long rid) {
		return (Callable) super.call("get_popup_close_callback", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void set_minimum_width(long rid, double width) {
		super.call("set_minimum_width",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Double.valueOf(width)});
	}

	public double get_minimum_width(long rid) {
		return (double) super.call("get_minimum_width", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public boolean is_opened(long rid) {
		return (boolean) super.call("is_opened", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public int add_submenu_item(long rid, String label, long submenu_rid, Object tag, long index) {
		return (int) super.call("add_submenu_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) label,
						java.lang.Long.valueOf(submenu_rid), (java.lang.Object) tag, java.lang.Long.valueOf(index)});
	}

	public int add_item(long rid, String label, Callable callback, Callable key_callback, Object tag, int accelerator,
			long index) {
		return (int) super.call("add_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_check_item(long rid, String label, Callable callback, Callable key_callback, Object tag,
			int accelerator, long index) {
		return (int) super.call("add_check_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_icon_item(long rid, Texture2D icon, String label, Callable callback, Callable key_callback,
			Object tag, int accelerator, long index) {
		return (int) super.call("add_icon_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) icon, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_icon_check_item(long rid, Texture2D icon, String label, Callable callback, Callable key_callback,
			Object tag, int accelerator, long index) {
		return (int) super.call("add_icon_check_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) icon, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_radio_check_item(long rid, String label, Callable callback, Callable key_callback, Object tag,
			int accelerator, long index) {
		return (int) super.call("add_radio_check_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_icon_radio_check_item(long rid, Texture2D icon, String label, Callable callback,
			Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("add_icon_radio_check_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) icon, (java.lang.Object) label,
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_multistate_item(long rid, String label, long max_states, long default_state, Callable callback,
			Callable key_callback, Object tag, int accelerator, long index) {
		return (int) super.call("add_multistate_item",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) label,
						java.lang.Long.valueOf(max_states), java.lang.Long.valueOf(default_state),
						(java.lang.Object) callback, (java.lang.Object) key_callback, (java.lang.Object) tag,
						java.lang.Integer.valueOf(accelerator), java.lang.Long.valueOf(index)});
	}

	public int add_separator(long rid, long index) {
		return (int) super.call("add_separator",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(index)});
	}

	public int find_item_index_with_text(long rid, String text) {
		return (int) super.call("find_item_index_with_text",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) text});
	}

	public int find_item_index_with_tag(long rid, Object tag) {
		return (int) super.call("find_item_index_with_tag",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), (java.lang.Object) tag});
	}

	public int find_item_index_with_submenu(long rid, long submenu_rid) {
		return (int) super.call("find_item_index_with_submenu",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(submenu_rid)});
	}

	public boolean is_item_checked(long rid, long idx) {
		return (boolean) super.call("is_item_checked",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public boolean is_item_checkable(long rid, long idx) {
		return (boolean) super.call("is_item_checkable",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public boolean is_item_radio_checkable(long rid, long idx) {
		return (boolean) super.call("is_item_radio_checkable",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public Callable get_item_callback(long rid, long idx) {
		return (Callable) super.call("get_item_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public Callable get_item_key_callback(long rid, long idx) {
		return (Callable) super.call("get_item_key_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public Object get_item_tag(long rid, long idx) {
		return (Object) super.call("get_item_tag",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public String get_item_text(long rid, long idx) {
		return (String) super.call("get_item_text",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public long get_item_submenu(long rid, long idx) {
		return (long) super.call("get_item_submenu",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public int get_item_accelerator(long rid, long idx) {
		return (int) super.call("get_item_accelerator",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public boolean is_item_disabled(long rid, long idx) {
		return (boolean) super.call("is_item_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public boolean is_item_hidden(long rid, long idx) {
		return (boolean) super.call("is_item_hidden",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public String get_item_tooltip(long rid, long idx) {
		return (String) super.call("get_item_tooltip",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public int get_item_state(long rid, long idx) {
		return (int) super.call("get_item_state",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public int get_item_max_states(long rid, long idx) {
		return (int) super.call("get_item_max_states",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public Texture2D get_item_icon(long rid, long idx) {
		return (Texture2D) super.call("get_item_icon",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public int get_item_indentation_level(long rid, long idx) {
		return (int) super.call("get_item_indentation_level",
				new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public void set_item_checked(long rid, long idx, boolean checked) {
		super.call("set_item_checked", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				java.lang.Boolean.valueOf(checked)});
	}

	public void set_item_checkable(long rid, long idx, boolean checkable) {
		super.call("set_item_checkable", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(checkable)});
	}

	public void set_item_radio_checkable(long rid, long idx, boolean checkable) {
		super.call("set_item_radio_checkable", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), java.lang.Boolean.valueOf(checkable)});
	}

	public void set_item_callback(long rid, long idx, Callable callback) {
		super.call("set_item_callback", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				(java.lang.Object) callback});
	}

	public void set_item_hover_callbacks(long rid, long idx, Callable callback) {
		super.call("set_item_hover_callbacks", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), (java.lang.Object) callback});
	}

	public void set_item_key_callback(long rid, long idx, Callable key_callback) {
		super.call("set_item_key_callback", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), (java.lang.Object) key_callback});
	}

	public void set_item_tag(long rid, long idx, Object tag) {
		super.call("set_item_tag", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				(java.lang.Object) tag});
	}

	public void set_item_text(long rid, long idx, String text) {
		super.call("set_item_text", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				(java.lang.Object) text});
	}

	public void set_item_submenu(long rid, long idx, long submenu_rid) {
		super.call("set_item_submenu", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				java.lang.Long.valueOf(submenu_rid)});
	}

	public void set_item_accelerator(long rid, long idx, int keycode) {
		super.call("set_item_accelerator", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), java.lang.Integer.valueOf(keycode)});
	}

	public void set_item_disabled(long rid, long idx, boolean disabled) {
		super.call("set_item_disabled", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				java.lang.Boolean.valueOf(disabled)});
	}

	public void set_item_hidden(long rid, long idx, boolean hidden) {
		super.call("set_item_hidden", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				java.lang.Boolean.valueOf(hidden)});
	}

	public void set_item_tooltip(long rid, long idx, String tooltip) {
		super.call("set_item_tooltip", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				(java.lang.Object) tooltip});
	}

	public void set_item_state(long rid, long idx, long state) {
		super.call("set_item_state", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				java.lang.Long.valueOf(state)});
	}

	public void set_item_max_states(long rid, long idx, long max_states) {
		super.call("set_item_max_states", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), java.lang.Long.valueOf(max_states)});
	}

	public void set_item_icon(long rid, long idx, Texture2D icon) {
		super.call("set_item_icon", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx),
				(java.lang.Object) icon});
	}

	public void set_item_indentation_level(long rid, long idx, long level) {
		super.call("set_item_indentation_level", new java.lang.Object[]{java.lang.Long.valueOf(rid),
				java.lang.Long.valueOf(idx), java.lang.Long.valueOf(level)});
	}

	public int get_item_count(long rid) {
		return (int) super.call("get_item_count", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public boolean is_system_menu(long rid) {
		return (boolean) super.call("is_system_menu", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void remove_item(long rid, long idx) {
		super.call("remove_item", new java.lang.Object[]{java.lang.Long.valueOf(rid), java.lang.Long.valueOf(idx)});
	}

	public void clear(long rid) {
		super.call("clear", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}
}
