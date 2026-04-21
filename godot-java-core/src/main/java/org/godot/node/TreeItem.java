package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.core.Callable;
import org.godot.math.Color;
import org.godot.math.Rect2;

public class TreeItem extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_icon_overlay", 666127730L),
			java.util.Map.entry("set_custom_as_button", 300928843L),
			java.util.Map.entry("set_structured_text_bidi_override", 868756907L),
			java.util.Map.entry("select", 1286410249L), java.util.Map.entry("set_text_alignment", 3276431499L),
			java.util.Map.entry("call_recursive", 2866548813L), java.util.Map.entry("set_custom_stylebox", 1433009359L),
			java.util.Map.entry("remove_child", 1819951137L), java.util.Map.entry("is_indeterminate", 1116898809L),
			java.util.Map.entry("create_child", 954243986L), java.util.Map.entry("clear_custom_color", 1286410249L),
			java.util.Map.entry("set_description", 501894301L), java.util.Map.entry("get_range_config", 3554694381L),
			java.util.Map.entry("get_icon", 3536238170L), java.util.Map.entry("set_custom_color", 2878471219L),
			java.util.Map.entry("get_language", 844755477L),
			java.util.Map.entry("get_structured_text_bidi_override", 3377823772L),
			java.util.Map.entry("set_language", 501894301L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 663333327L),
			java.util.Map.entry("is_button_disabled", 2522259332L),
			java.util.Map.entry("set_collapsed_recursive", 2586408642L), java.util.Map.entry("get_parent", 1514277247L),
			java.util.Map.entry("set_icon_max_width", 3937882851L), java.util.Map.entry("set_expand_right", 300928843L),
			java.util.Map.entry("is_selected", 3067735520L), java.util.Map.entry("set_custom_bg_color", 894174518L),
			java.util.Map.entry("get_text_overrun_behavior", 3782727860L),
			java.util.Map.entry("get_prev_in_tree", 1666920593L),
			java.util.Map.entry("get_custom_stylebox", 3362509644L), java.util.Map.entry("is_selectable", 1116898809L),
			java.util.Map.entry("get_tree", 2243340556L), java.util.Map.entry("is_checked", 1116898809L),
			java.util.Map.entry("get_custom_bg_color", 3457211756L),
			java.util.Map.entry("set_tooltip_text", 501894301L), java.util.Map.entry("set_cell_mode", 289920701L),
			java.util.Map.entry("erase_button", 3937882851L), java.util.Map.entry("add_button", 973481897L),
			java.util.Map.entry("get_icon_max_width", 923996154L),
			java.util.Map.entry("is_edit_multiline", 1116898809L), java.util.Map.entry("set_checked", 300928843L),
			java.util.Map.entry("get_autowrap_mode", 2902757236L),
			java.util.Map.entry("set_autowrap_mode", 3633006561L), java.util.Map.entry("set_selectable", 300928843L),
			java.util.Map.entry("is_visible_in_tree", 36873697L), java.util.Map.entry("get_range", 2339986948L),
			java.util.Map.entry("set_custom_minimum_height", 1286410249L),
			java.util.Map.entry("set_range", 1602489585L), java.util.Map.entry("get_custom_color", 3457211756L),
			java.util.Map.entry("set_collapsed", 2586408642L), java.util.Map.entry("get_cell_mode", 3406114978L),
			java.util.Map.entry("set_text_direction", 1707680378L), java.util.Map.entry("get_index", 2455072627L),
			java.util.Map.entry("get_first_child", 1514277247L), java.util.Map.entry("is_visible", 2240911060L),
			java.util.Map.entry("set_custom_font", 2637609184L),
			java.util.Map.entry("get_custom_font_size", 923996154L),
			java.util.Map.entry("set_disable_folding", 2586408642L),
			java.util.Map.entry("get_custom_draw_callback", 1317077508L),
			java.util.Map.entry("is_collapsed", 2240911060L), java.util.Map.entry("is_editable", 3067735520L),
			java.util.Map.entry("set_icon", 666127730L), java.util.Map.entry("add_child", 1819951137L),
			java.util.Map.entry("get_metadata", 4227898402L), java.util.Map.entry("deselect", 1286410249L),
			java.util.Map.entry("propagate_check", 972357352L), java.util.Map.entry("is_any_collapsed", 2595650253L),
			java.util.Map.entry("get_prev_visible", 1666920593L),
			java.util.Map.entry("set_text_overrun_behavior", 1940772195L),
			java.util.Map.entry("get_icon_region", 3327874267L), java.util.Map.entry("get_expand_right", 1116898809L),
			java.util.Map.entry("set_custom_font_size", 3937882851L),
			java.util.Map.entry("is_folding_disabled", 36873697L), java.util.Map.entry("get_child", 306700752L),
			java.util.Map.entry("get_children", 2915620761L), java.util.Map.entry("get_button_by_id", 3175239445L),
			java.util.Map.entry("set_custom_draw_callback", 957362965L),
			java.util.Map.entry("set_button_color", 3733378741L), java.util.Map.entry("set_visible", 2586408642L),
			java.util.Map.entry("set_metadata", 2152698145L), java.util.Map.entry("get_button_count", 923996154L),
			java.util.Map.entry("uncollapse_tree", 3218959716L), java.util.Map.entry("set_editable", 300928843L),
			java.util.Map.entry("set_custom_draw", 272420368L), java.util.Map.entry("clear_buttons", 3218959716L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 537221740L),
			java.util.Map.entry("set_suffix", 501894301L), java.util.Map.entry("get_icon_modulate", 3457211756L),
			java.util.Map.entry("get_icon_overlay", 3536238170L),
			java.util.Map.entry("set_button_disabled", 1383440665L), java.util.Map.entry("get_text", 844755477L),
			java.util.Map.entry("get_custom_minimum_height", 3905245786L),
			java.util.Map.entry("get_text_alignment", 4171562184L), java.util.Map.entry("move_before", 1819951137L),
			java.util.Map.entry("set_icon_region", 1356297692L),
			java.util.Map.entry("set_button_tooltip_text", 2285447957L),
			java.util.Map.entry("set_edit_multiline", 300928843L), java.util.Map.entry("get_next_visible", 1666920593L),
			java.util.Map.entry("get_auto_translate_mode", 906302372L),
			java.util.Map.entry("is_custom_set_as_button", 1116898809L), java.util.Map.entry("get_prev", 2768121250L),
			java.util.Map.entry("clear_custom_bg_color", 1286410249L), java.util.Map.entry("set_text", 501894301L),
			java.util.Map.entry("get_suffix", 844755477L), java.util.Map.entry("get_text_direction", 4235602388L),
			java.util.Map.entry("set_indeterminate", 300928843L), java.util.Map.entry("set_range_config", 1547181014L),
			java.util.Map.entry("set_auto_translate_mode", 287402019L),
			java.util.Map.entry("get_description", 844755477L), java.util.Map.entry("move_after", 1819951137L),
			java.util.Map.entry("get_button_color", 2165839948L), java.util.Map.entry("set_icon_modulate", 2878471219L),
			java.util.Map.entry("get_button", 2584904275L), java.util.Map.entry("get_child_count", 2455072627L),
			java.util.Map.entry("get_button_tooltip_text", 1391810591L),
			java.util.Map.entry("get_custom_font", 4244553094L), java.util.Map.entry("get_next", 1514277247L),
			java.util.Map.entry("get_next_in_tree", 1666920593L), java.util.Map.entry("set_button", 176101966L),
			java.util.Map.entry("get_tooltip_text", 844755477L), java.util.Map.entry("get_button_id", 3175239445L),
			java.util.Map.entry("set_button_description", 2285447957L));

	TreeItem(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TreeItem(long nativePointer) {
		super(nativePointer);
	}

	public void set_cell_mode(long column, int mode) {
		super.call("set_cell_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(mode)});
	}

	public int get_cell_mode(long column) {
		return (int) super.call("get_cell_mode", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_auto_translate_mode(long column, int mode) {
		super.call("set_auto_translate_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(mode)});
	}

	public int get_auto_translate_mode(long column) {
		return (int) super.call("get_auto_translate_mode", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_edit_multiline(long column, boolean multiline) {
		super.call("set_edit_multiline",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(multiline)});
	}

	public boolean is_edit_multiline(long column) {
		return (boolean) super.call("is_edit_multiline", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_checked(long column, boolean checked) {
		super.call("set_checked",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(checked)});
	}

	public void set_indeterminate(long column, boolean indeterminate) {
		super.call("set_indeterminate",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(indeterminate)});
	}

	public boolean is_checked(long column) {
		return (boolean) super.call("is_checked", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_indeterminate(long column) {
		return (boolean) super.call("is_indeterminate", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void propagate_check(long column, boolean emit_signal) {
		super.call("propagate_check",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(emit_signal)});
	}

	public void set_text(long column, String text) {
		super.call("set_text", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) text});
	}

	public String get_text(long column) {
		return (String) super.call("get_text", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_description(long column, String description) {
		super.call("set_description",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) description});
	}

	public String get_description(long column) {
		return (String) super.call("get_description", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_text_direction(long column, int direction) {
		super.call("set_text_direction",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(direction)});
	}

	public int get_text_direction(long column) {
		return (int) super.call("get_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_autowrap_mode(long column, int autowrap_mode) {
		super.call("set_autowrap_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(autowrap_mode)});
	}

	public int get_autowrap_mode(long column) {
		return (int) super.call("get_autowrap_mode", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_text_overrun_behavior(long column, int overrun_behavior) {
		super.call("set_text_overrun_behavior",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(overrun_behavior)});
	}

	public int get_text_overrun_behavior(long column) {
		return (int) super.call("get_text_overrun_behavior", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_structured_text_bidi_override(long column, int parser) {
		super.call("set_structured_text_bidi_override",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(parser)});
	}

	public int get_structured_text_bidi_override(long column) {
		return (int) super.call("get_structured_text_bidi_override",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_structured_text_bidi_override_options(long column, GodotArray args) {
		super.call("set_structured_text_bidi_override_options",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) args});
	}

	public GodotArray get_structured_text_bidi_override_options(long column) {
		return (GodotArray) super.call("get_structured_text_bidi_override_options",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_language(long column, String language) {
		super.call("set_language", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) language});
	}

	public String get_language(long column) {
		return (String) super.call("get_language", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_suffix(long column, String text) {
		super.call("set_suffix", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) text});
	}

	public String get_suffix(long column) {
		return (String) super.call("get_suffix", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_icon(long column, Texture2D texture) {
		super.call("set_icon", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) texture});
	}

	public Texture2D get_icon(long column) {
		return (Texture2D) super.call("get_icon", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_icon_overlay(long column, Texture2D texture) {
		super.call("set_icon_overlay",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) texture});
	}

	public Texture2D get_icon_overlay(long column) {
		return (Texture2D) super.call("get_icon_overlay", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_icon_region(long column, Rect2 region) {
		super.call("set_icon_region",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) region});
	}

	public Rect2 get_icon_region(long column) {
		return (Rect2) super.call("get_icon_region", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_icon_max_width(long column, long width) {
		super.call("set_icon_max_width",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(width)});
	}

	public int get_icon_max_width(long column) {
		return (int) super.call("get_icon_max_width", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_icon_modulate(long column, Color modulate) {
		super.call("set_icon_modulate",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) modulate});
	}

	public Color get_icon_modulate(long column) {
		return (Color) super.call("get_icon_modulate", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_range(long column, double value) {
		super.call("set_range",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Double.valueOf(value)});
	}

	public double get_range(long column) {
		return (double) super.call("get_range", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_range_config(long column, double min, double max, double step, boolean expr) {
		super.call("set_range_config",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Double.valueOf(min),
						java.lang.Double.valueOf(max), java.lang.Double.valueOf(step),
						java.lang.Boolean.valueOf(expr)});
	}

	public GodotDictionary get_range_config(long column) {
		return (GodotDictionary) super.call("get_range_config", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_metadata(long column, Object meta) {
		super.call("set_metadata", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) meta});
	}

	public Object get_metadata(long column) {
		return (Object) super.call("get_metadata", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_draw(long column, GodotObject object, String callback) {
		super.call("set_custom_draw", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) object,
				(java.lang.Object) callback});
	}

	public void set_custom_draw_callback(long column, Callable callback) {
		super.call("set_custom_draw_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) callback});
	}

	public Callable get_custom_draw_callback(long column) {
		return (Callable) super.call("get_custom_draw_callback",
				new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_stylebox(long column, StyleBox stylebox) {
		super.call("set_custom_stylebox",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) stylebox});
	}

	public StyleBox get_custom_stylebox(long column) {
		return (StyleBox) super.call("get_custom_stylebox", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_collapsed() {
		return (boolean) super.call("is_collapsed");
	}

	public boolean is_any_collapsed(boolean only_visible) {
		return (boolean) super.call("is_any_collapsed",
				new java.lang.Object[]{java.lang.Boolean.valueOf(only_visible)});
	}

	public boolean is_visible() {
		return (boolean) super.call("is_visible");
	}

	public boolean is_visible_in_tree() {
		return (boolean) super.call("is_visible_in_tree");
	}

	public void uncollapse_tree() {
		super.call("uncollapse_tree");
	}

	public void set_selectable(long column, boolean selectable) {
		super.call("set_selectable",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(selectable)});
	}

	public boolean is_selectable(long column) {
		return (boolean) super.call("is_selectable", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_selected(long column) {
		return (boolean) super.call("is_selected", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void select(long column) {
		super.call("select", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void deselect(long column) {
		super.call("deselect", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_editable(long column, boolean enabled) {
		super.call("set_editable",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_editable(long column) {
		return (boolean) super.call("is_editable", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_color(long column, Color color) {
		super.call("set_custom_color",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) color});
	}

	public Color get_custom_color(long column) {
		return (Color) super.call("get_custom_color", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void clear_custom_color(long column) {
		super.call("clear_custom_color", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_font(long column, Font font) {
		super.call("set_custom_font", new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) font});
	}

	public Font get_custom_font(long column) {
		return (Font) super.call("get_custom_font", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_font_size(long column, long font_size) {
		super.call("set_custom_font_size",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(font_size)});
	}

	public int get_custom_font_size(long column) {
		return (int) super.call("get_custom_font_size", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_bg_color(long column, Color color, boolean just_outline) {
		super.call("set_custom_bg_color", new java.lang.Object[]{java.lang.Long.valueOf(column),
				(java.lang.Object) color, java.lang.Boolean.valueOf(just_outline)});
	}

	public void clear_custom_bg_color(long column) {
		super.call("clear_custom_bg_color", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public Color get_custom_bg_color(long column) {
		return (Color) super.call("get_custom_bg_color", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_custom_as_button(long column, boolean enable) {
		super.call("set_custom_as_button",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_custom_set_as_button(long column) {
		return (boolean) super.call("is_custom_set_as_button", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void clear_buttons() {
		super.call("clear_buttons");
	}

	public void add_button(long column, Texture2D button, long id, boolean disabled, String tooltip_text,
			String description) {
		super.call("add_button",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) button,
						java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(disabled),
						(java.lang.Object) tooltip_text, (java.lang.Object) description});
	}

	public int get_button_count(long column) {
		return (int) super.call("get_button_count", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public String get_button_tooltip_text(long column, long button_index) {
		return (String) super.call("get_button_tooltip_text",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(button_index)});
	}

	public int get_button_id(long column, long button_index) {
		return (int) super.call("get_button_id",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(button_index)});
	}

	public int get_button_by_id(long column, long id) {
		return (int) super.call("get_button_by_id",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(id)});
	}

	public Color get_button_color(long column, long id) {
		return (Color) super.call("get_button_color",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(id)});
	}

	public Texture2D get_button(long column, long button_index) {
		return (Texture2D) super.call("get_button",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(button_index)});
	}

	public void set_button_tooltip_text(long column, long button_index, String tooltip) {
		super.call("set_button_tooltip_text", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Long.valueOf(button_index), (java.lang.Object) tooltip});
	}

	public void set_button(long column, long button_index, Texture2D button) {
		super.call("set_button", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Long.valueOf(button_index), (java.lang.Object) button});
	}

	public void erase_button(long column, long button_index) {
		super.call("erase_button",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(button_index)});
	}

	public void set_button_description(long column, long button_index, String description) {
		super.call("set_button_description", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Long.valueOf(button_index), (java.lang.Object) description});
	}

	public void set_button_disabled(long column, long button_index, boolean disabled) {
		super.call("set_button_disabled", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Long.valueOf(button_index), java.lang.Boolean.valueOf(disabled)});
	}

	public void set_button_color(long column, long button_index, Color color) {
		super.call("set_button_color", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Long.valueOf(button_index), (java.lang.Object) color});
	}

	public boolean is_button_disabled(long column, long button_index) {
		return (boolean) super.call("is_button_disabled",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Long.valueOf(button_index)});
	}

	public void set_tooltip_text(long column, String tooltip) {
		super.call("set_tooltip_text",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) tooltip});
	}

	public String get_tooltip_text(long column) {
		return (String) super.call("get_tooltip_text", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_text_alignment(long column, int text_alignment) {
		super.call("set_text_alignment",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Integer.valueOf(text_alignment)});
	}

	public int get_text_alignment(long column) {
		return (int) super.call("get_text_alignment", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public void set_expand_right(long column, boolean enable) {
		super.call("set_expand_right",
				new java.lang.Object[]{java.lang.Long.valueOf(column), java.lang.Boolean.valueOf(enable)});
	}

	public boolean get_expand_right(long column) {
		return (boolean) super.call("get_expand_right", new java.lang.Object[]{java.lang.Long.valueOf(column)});
	}

	public boolean is_folding_disabled() {
		return (boolean) super.call("is_folding_disabled");
	}

	public TreeItem create_child(long index) {
		return (TreeItem) super.call("create_child", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_child(TreeItem child) {
		super.call("add_child", new java.lang.Object[]{(java.lang.Object) child});
	}

	public void remove_child(TreeItem child) {
		super.call("remove_child", new java.lang.Object[]{(java.lang.Object) child});
	}

	public TreeItem get_next_in_tree(boolean wrap) {
		return (TreeItem) super.call("get_next_in_tree", new java.lang.Object[]{java.lang.Boolean.valueOf(wrap)});
	}

	public TreeItem get_prev_in_tree(boolean wrap) {
		return (TreeItem) super.call("get_prev_in_tree", new java.lang.Object[]{java.lang.Boolean.valueOf(wrap)});
	}

	public TreeItem get_next_visible(boolean wrap) {
		return (TreeItem) super.call("get_next_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(wrap)});
	}

	public TreeItem get_prev_visible(boolean wrap) {
		return (TreeItem) super.call("get_prev_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(wrap)});
	}

	public TreeItem get_child(long index) {
		return (TreeItem) super.call("get_child", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void move_before(TreeItem item) {
		super.call("move_before", new java.lang.Object[]{(java.lang.Object) item});
	}

	public void move_after(TreeItem item) {
		super.call("move_after", new java.lang.Object[]{(java.lang.Object) item});
	}

	public void call_recursive(String method) {
		super.call("call_recursive", new java.lang.Object[]{(java.lang.Object) method});
	}

	public boolean isCollapsed() {
		return (boolean) super.call("is_collapsed", new java.lang.Object[0]);
	}

	public void setCollapsed(boolean value) {
		super.call("set_collapsed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isVisible() {
		return (boolean) super.call("is_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDisable_folding() {
		return (boolean) super.call("is_folding_disabled", new java.lang.Object[0]);
	}

	public void setDisable_folding(boolean value) {
		super.call("set_disable_folding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCustom_minimum_height() {
		return (long) super.call("get_custom_minimum_height", new java.lang.Object[0]);
	}

	public void setCustom_minimum_height(long value) {
		super.call("set_custom_minimum_height", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
