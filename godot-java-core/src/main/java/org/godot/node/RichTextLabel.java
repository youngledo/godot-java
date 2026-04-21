package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class RichTextLabel extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_structured_text_bidi_override", 55961453L),
			java.util.Map.entry("reload_effects", 3218959716L), java.util.Map.entry("set_fit_content", 2586408642L),
			java.util.Map.entry("set_tab_size", 1286410249L), java.util.Map.entry("is_scroll_active", 36873697L),
			java.util.Map.entry("set_cell_border_color", 2920490490L), java.util.Map.entry("get_tab_stops", 675695659L),
			java.util.Map.entry("get_selection_to", 3905245786L), java.util.Map.entry("get_language", 201670096L),
			java.util.Map.entry("get_structured_text_bidi_override", 3385126229L),
			java.util.Map.entry("set_language", 83702148L), java.util.Map.entry("is_fit_content_enabled", 36873697L),
			java.util.Map.entry("push_customfx", 2337942958L), java.util.Map.entry("is_ready", 36873697L),
			java.util.Map.entry("get_structured_text_bidi_override_options", 3995934104L),
			java.util.Map.entry("set_tab_stops", 2899603908L), java.util.Map.entry("push_font_size", 1286410249L),
			java.util.Map.entry("push_strikethrough", 1458098034L),
			java.util.Map.entry("set_table_column_expand", 117236061L),
			java.util.Map.entry("remove_paragraph", 3262369265L),
			java.util.Map.entry("is_deselect_on_focus_loss_enabled", 36873697L),
			java.util.Map.entry("push_color", 2920490490L), java.util.Map.entry("push_meta", 3765356747L),
			java.util.Map.entry("get_effects", 2915620761L), java.util.Map.entry("push_bold_italics", 3218959716L),
			java.util.Map.entry("get_selection_line_offset", 1740695150L),
			java.util.Map.entry("set_deselect_on_focus_loss_enabled", 2586408642L),
			java.util.Map.entry("set_scroll_follow", 2586408642L),
			java.util.Map.entry("set_context_menu_enabled", 2586408642L),
			java.util.Map.entry("push_bgcolor", 2920490490L), java.util.Map.entry("push_dropcap", 4061635501L),
			java.util.Map.entry("set_shortcut_keys_enabled", 2586408642L),
			java.util.Map.entry("get_line_count", 3905245786L), java.util.Map.entry("push_cell", 3218959716L),
			java.util.Map.entry("get_line_offset", 4025615559L),
			java.util.Map.entry("get_paragraph_offset", 4025615559L),
			java.util.Map.entry("invalidate_paragraph", 3067735520L),
			java.util.Map.entry("is_drag_and_drop_selection_enabled", 36873697L),
			java.util.Map.entry("get_v_scroll_bar", 2630340773L), java.util.Map.entry("get_autowrap_mode", 1549071663L),
			java.util.Map.entry("push_underline", 1458098034L), java.util.Map.entry("get_paragraph_count", 3905245786L),
			java.util.Map.entry("install_effect", 1114965689L), java.util.Map.entry("set_autowrap_mode", 3289138044L),
			java.util.Map.entry("pop", 3218959716L), java.util.Map.entry("is_meta_underlined", 36873697L),
			java.util.Map.entry("set_cell_size_override", 3108078480L),
			java.util.Map.entry("get_selected_text", 201670096L),
			java.util.Map.entry("set_selection_enabled", 2586408642L),
			java.util.Map.entry("get_character_paragraph", 3744713108L),
			java.util.Map.entry("get_horizontal_alignment", 341400642L), java.util.Map.entry("add_text", 83702148L),
			java.util.Map.entry("add_hr", 16816895L),
			java.util.Map.entry("set_drag_and_drop_selection_enabled", 2586408642L),
			java.util.Map.entry("set_text_direction", 119160795L), java.util.Map.entry("get_tab_size", 3905245786L),
			java.util.Map.entry("get_visible_characters", 3905245786L), java.util.Map.entry("get_menu", 229722558L),
			java.util.Map.entry("is_scroll_following_visible_characters", 36873697L),
			java.util.Map.entry("is_selection_enabled", 36873697L),
			java.util.Map.entry("get_justification_flags", 1583363614L),
			java.util.Map.entry("scroll_to_paragraph", 1286410249L),
			java.util.Map.entry("get_content_height", 3905245786L), java.util.Map.entry("deselect", 3218959716L),
			java.util.Map.entry("set_hint_underline", 2586408642L), java.util.Map.entry("push_font", 2347424842L),
			java.util.Map.entry("get_visible_characters_behavior", 258789322L),
			java.util.Map.entry("get_progress_bar_delay", 3905245786L),
			java.util.Map.entry("get_visible_ratio", 1740695150L),
			java.util.Map.entry("set_scroll_follow_visible_characters", 2586408642L),
			java.util.Map.entry("get_vertical_alignment", 3274884059L),
			java.util.Map.entry("get_line_width", 923996154L), java.util.Map.entry("select_all", 3218959716L),
			java.util.Map.entry("push_list", 3017143144L), java.util.Map.entry("set_cell_padding", 2046264180L),
			java.util.Map.entry("push_language", 83702148L), java.util.Map.entry("newline", 3218959716L),
			java.util.Map.entry("parse_expressions_for_values", 1522900837L),
			java.util.Map.entry("is_threaded", 36873697L),
			java.util.Map.entry("get_total_character_count", 3905245786L),
			java.util.Map.entry("push_paragraph", 3089306873L),
			java.util.Map.entry("set_structured_text_bidi_override_options", 381264803L),
			java.util.Map.entry("push_italics", 3218959716L),
			java.util.Map.entry("set_visible_characters", 1286410249L),
			java.util.Map.entry("get_content_width", 3905245786L), java.util.Map.entry("append_text", 83702148L),
			java.util.Map.entry("set_cell_row_background_color", 3465483165L),
			java.util.Map.entry("push_fgcolor", 2920490490L), java.util.Map.entry("push_hint", 83702148L),
			java.util.Map.entry("get_text", 201670096L), java.util.Map.entry("is_scroll_following", 36873697L),
			java.util.Map.entry("set_visible_ratio", 373806689L), java.util.Map.entry("push_bold", 3218959716L),
			java.util.Map.entry("push_table", 3426862026L), java.util.Map.entry("menu_option", 1286410249L),
			java.util.Map.entry("get_parsed_text", 201670096L), java.util.Map.entry("update_image", 6389170L),
			java.util.Map.entry("push_outline_color", 2920490490L), java.util.Map.entry("set_text", 83702148L),
			java.util.Map.entry("is_using_bbcode", 36873697L),
			java.util.Map.entry("get_visible_content_rect", 410525958L),
			java.util.Map.entry("set_autowrap_trim_flags", 2809697122L),
			java.util.Map.entry("push_indent", 1286410249L), java.util.Map.entry("scroll_to_selection", 3218959716L),
			java.util.Map.entry("is_hint_underlined", 36873697L), java.util.Map.entry("push_mono", 3218959716L),
			java.util.Map.entry("get_line_range", 3665014314L), java.util.Map.entry("push_context", 3218959716L),
			java.util.Map.entry("get_text_direction", 797257663L),
			java.util.Map.entry("is_context_menu_enabled", 36873697L),
			java.util.Map.entry("set_table_column_name", 501894301L), java.util.Map.entry("pop_all", 3218959716L),
			java.util.Map.entry("get_visible_line_count", 3905245786L),
			java.util.Map.entry("set_scroll_active", 2586408642L),
			java.util.Map.entry("set_justification_flags", 2877345813L),
			java.util.Map.entry("get_autowrap_trim_flags", 2340632602L),
			java.util.Map.entry("set_progress_bar_delay", 1286410249L),
			java.util.Map.entry("get_character_line", 3744713108L), java.util.Map.entry("is_menu_visible", 36873697L),
			java.util.Map.entry("add_image", 1390915033L), java.util.Map.entry("is_shortcut_keys_enabled", 36873697L),
			java.util.Map.entry("pop_context", 3218959716L), java.util.Map.entry("set_effects", 381264803L),
			java.util.Map.entry("parse_bbcode", 83702148L), java.util.Map.entry("scroll_to_line", 1286410249L),
			java.util.Map.entry("set_visible_characters_behavior", 3383839701L),
			java.util.Map.entry("push_normal", 3218959716L),
			java.util.Map.entry("set_horizontal_alignment", 2312603777L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("push_outline_size", 1286410249L),
			java.util.Map.entry("set_meta_underline", 2586408642L), java.util.Map.entry("set_threaded", 2586408642L),
			java.util.Map.entry("is_finished", 36873697L), java.util.Map.entry("get_selection_from", 3905245786L),
			java.util.Map.entry("set_use_bbcode", 2586408642L),
			java.util.Map.entry("get_visible_paragraph_count", 3905245786L),
			java.util.Map.entry("set_vertical_alignment", 1796458609L),
			java.util.Map.entry("get_line_height", 923996154L));

	RichTextLabel(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RichTextLabel(long nativePointer) {
		super(nativePointer);
	}

	public void add_text(String text) {
		super.call("add_text", new java.lang.Object[]{(java.lang.Object) text});
	}

	public void add_hr(long width, long height, Color color, int alignment, boolean width_in_percent,
			boolean height_in_percent) {
		super.call("add_hr",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						(java.lang.Object) color, java.lang.Integer.valueOf(alignment),
						java.lang.Boolean.valueOf(width_in_percent), java.lang.Boolean.valueOf(height_in_percent)});
	}

	public void add_image(Texture2D image, long width, long height, Color color, int inline_align, Rect2 region,
			Object key, boolean pad, String tooltip, boolean width_in_percent, boolean height_in_percent,
			String alt_text) {
		super.call("add_image", new java.lang.Object[]{(java.lang.Object) image, java.lang.Long.valueOf(width),
				java.lang.Long.valueOf(height), (java.lang.Object) color, java.lang.Integer.valueOf(inline_align),
				(java.lang.Object) region, (java.lang.Object) key, java.lang.Boolean.valueOf(pad),
				(java.lang.Object) tooltip, java.lang.Boolean.valueOf(width_in_percent),
				java.lang.Boolean.valueOf(height_in_percent), (java.lang.Object) alt_text});
	}

	public void update_image(Object key, int mask, Texture2D image, long width, long height, Color color,
			int inline_align, Rect2 region, boolean pad, String tooltip, boolean width_in_percent,
			boolean height_in_percent) {
		super.call("update_image",
				new java.lang.Object[]{(java.lang.Object) key, java.lang.Integer.valueOf(mask),
						(java.lang.Object) image, java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						(java.lang.Object) color, java.lang.Integer.valueOf(inline_align), (java.lang.Object) region,
						java.lang.Boolean.valueOf(pad), (java.lang.Object) tooltip,
						java.lang.Boolean.valueOf(width_in_percent), java.lang.Boolean.valueOf(height_in_percent)});
	}

	public void newline() {
		super.call("newline");
	}

	public boolean remove_paragraph(long paragraph, boolean no_invalidate) {
		return (boolean) super.call("remove_paragraph",
				new java.lang.Object[]{java.lang.Long.valueOf(paragraph), java.lang.Boolean.valueOf(no_invalidate)});
	}

	public boolean invalidate_paragraph(long paragraph) {
		return (boolean) super.call("invalidate_paragraph", new java.lang.Object[]{java.lang.Long.valueOf(paragraph)});
	}

	public void push_font(Font font, long font_size) {
		super.call("push_font", new java.lang.Object[]{(java.lang.Object) font, java.lang.Long.valueOf(font_size)});
	}

	public void push_font_size(long font_size) {
		super.call("push_font_size", new java.lang.Object[]{java.lang.Long.valueOf(font_size)});
	}

	public void push_normal() {
		super.call("push_normal");
	}

	public void push_bold() {
		super.call("push_bold");
	}

	public void push_bold_italics() {
		super.call("push_bold_italics");
	}

	public void push_italics() {
		super.call("push_italics");
	}

	public void push_mono() {
		super.call("push_mono");
	}

	public void push_color(Color color) {
		super.call("push_color", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void push_outline_size(long outline_size) {
		super.call("push_outline_size", new java.lang.Object[]{java.lang.Long.valueOf(outline_size)});
	}

	public void push_outline_color(Color color) {
		super.call("push_outline_color", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void push_paragraph(int alignment, int base_direction, String language, int st_parser,
			int justification_flags, double[] tab_stops) {
		super.call("push_paragraph",
				new java.lang.Object[]{java.lang.Integer.valueOf(alignment), java.lang.Integer.valueOf(base_direction),
						(java.lang.Object) language, java.lang.Integer.valueOf(st_parser),
						java.lang.Integer.valueOf(justification_flags), (java.lang.Object) tab_stops});
	}

	public void push_indent(long level) {
		super.call("push_indent", new java.lang.Object[]{java.lang.Long.valueOf(level)});
	}

	public void push_list(long level, int type, boolean capitalize, String bullet) {
		super.call("push_list", new java.lang.Object[]{java.lang.Long.valueOf(level), java.lang.Integer.valueOf(type),
				java.lang.Boolean.valueOf(capitalize), (java.lang.Object) bullet});
	}

	public void push_meta(Object data, int underline_mode, String tooltip) {
		super.call("push_meta", new java.lang.Object[]{(java.lang.Object) data,
				java.lang.Integer.valueOf(underline_mode), (java.lang.Object) tooltip});
	}

	public void push_hint(String description) {
		super.call("push_hint", new java.lang.Object[]{(java.lang.Object) description});
	}

	public void push_language(String language) {
		super.call("push_language", new java.lang.Object[]{(java.lang.Object) language});
	}

	public void push_underline(Color color) {
		super.call("push_underline", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void push_strikethrough(Color color) {
		super.call("push_strikethrough", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void push_table(long columns, int inline_align, long align_to_row, String name) {
		super.call("push_table",
				new java.lang.Object[]{java.lang.Long.valueOf(columns), java.lang.Integer.valueOf(inline_align),
						java.lang.Long.valueOf(align_to_row), (java.lang.Object) name});
	}

	public void push_dropcap(String string, Font font, long size, Rect2 dropcap_margins, Color color, long outline_size,
			Color outline_color) {
		super.call("push_dropcap",
				new java.lang.Object[]{(java.lang.Object) string, (java.lang.Object) font, java.lang.Long.valueOf(size),
						(java.lang.Object) dropcap_margins, (java.lang.Object) color,
						java.lang.Long.valueOf(outline_size), (java.lang.Object) outline_color});
	}

	public void set_table_column_expand(long column, boolean expand, long ratio, boolean shrink) {
		super.call("set_table_column_expand", new java.lang.Object[]{java.lang.Long.valueOf(column),
				java.lang.Boolean.valueOf(expand), java.lang.Long.valueOf(ratio), java.lang.Boolean.valueOf(shrink)});
	}

	public void set_table_column_name(long column, String name) {
		super.call("set_table_column_name",
				new java.lang.Object[]{java.lang.Long.valueOf(column), (java.lang.Object) name});
	}

	public void set_cell_row_background_color(Color odd_row_bg, Color even_row_bg) {
		super.call("set_cell_row_background_color",
				new java.lang.Object[]{(java.lang.Object) odd_row_bg, (java.lang.Object) even_row_bg});
	}

	public void set_cell_size_override(Vector2 min_size, Vector2 max_size) {
		super.call("set_cell_size_override",
				new java.lang.Object[]{(java.lang.Object) min_size, (java.lang.Object) max_size});
	}

	public void push_cell() {
		super.call("push_cell");
	}

	public void push_fgcolor(Color fgcolor) {
		super.call("push_fgcolor", new java.lang.Object[]{(java.lang.Object) fgcolor});
	}

	public void push_bgcolor(Color bgcolor) {
		super.call("push_bgcolor", new java.lang.Object[]{(java.lang.Object) bgcolor});
	}

	public void push_customfx(RichTextEffect effect, GodotDictionary env) {
		super.call("push_customfx", new java.lang.Object[]{(java.lang.Object) effect, (java.lang.Object) env});
	}

	public void push_context() {
		super.call("push_context");
	}

	public void pop_context() {
		super.call("pop_context");
	}

	public void pop() {
		super.call("pop");
	}

	public void pop_all() {
		super.call("pop_all");
	}

	public void clear() {
		super.call("clear");
	}

	public boolean is_meta_underlined() {
		return (boolean) super.call("is_meta_underlined");
	}

	public boolean is_hint_underlined() {
		return (boolean) super.call("is_hint_underlined");
	}

	public boolean is_scroll_active() {
		return (boolean) super.call("is_scroll_active");
	}

	public boolean is_scroll_following_visible_characters() {
		return (boolean) super.call("is_scroll_following_visible_characters");
	}

	public boolean is_scroll_following() {
		return (boolean) super.call("is_scroll_following");
	}

	public void scroll_to_line(long line) {
		super.call("scroll_to_line", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void scroll_to_paragraph(long paragraph) {
		super.call("scroll_to_paragraph", new java.lang.Object[]{java.lang.Long.valueOf(paragraph)});
	}

	public void scroll_to_selection() {
		super.call("scroll_to_selection");
	}

	public boolean is_fit_content_enabled() {
		return (boolean) super.call("is_fit_content_enabled");
	}

	public boolean is_selection_enabled() {
		return (boolean) super.call("is_selection_enabled");
	}

	public boolean is_context_menu_enabled() {
		return (boolean) super.call("is_context_menu_enabled");
	}

	public boolean is_shortcut_keys_enabled() {
		return (boolean) super.call("is_shortcut_keys_enabled");
	}

	public boolean is_deselect_on_focus_loss_enabled() {
		return (boolean) super.call("is_deselect_on_focus_loss_enabled");
	}

	public boolean is_drag_and_drop_selection_enabled() {
		return (boolean) super.call("is_drag_and_drop_selection_enabled");
	}

	public void select_all() {
		super.call("select_all");
	}

	public void deselect() {
		super.call("deselect");
	}

	public void parse_bbcode(String bbcode) {
		super.call("parse_bbcode", new java.lang.Object[]{(java.lang.Object) bbcode});
	}

	public void append_text(String bbcode) {
		super.call("append_text", new java.lang.Object[]{(java.lang.Object) bbcode});
	}

	public boolean is_ready() {
		return (boolean) super.call("is_ready");
	}

	public boolean is_finished() {
		return (boolean) super.call("is_finished");
	}

	public boolean is_threaded() {
		return (boolean) super.call("is_threaded");
	}

	public int get_character_line(long character) {
		return (int) super.call("get_character_line", new java.lang.Object[]{java.lang.Long.valueOf(character)});
	}

	public int get_character_paragraph(long character) {
		return (int) super.call("get_character_paragraph", new java.lang.Object[]{java.lang.Long.valueOf(character)});
	}

	public boolean is_using_bbcode() {
		return (boolean) super.call("is_using_bbcode");
	}

	public Vector2i get_line_range(long line) {
		return (Vector2i) super.call("get_line_range", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public int get_line_height(long line) {
		return (int) super.call("get_line_height", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public int get_line_width(long line) {
		return (int) super.call("get_line_width", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_line_offset(long line) {
		return (double) super.call("get_line_offset", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public double get_paragraph_offset(long paragraph) {
		return (double) super.call("get_paragraph_offset", new java.lang.Object[]{java.lang.Long.valueOf(paragraph)});
	}

	public GodotDictionary parse_expressions_for_values(String[] expressions) {
		return (GodotDictionary) super.call("parse_expressions_for_values",
				new java.lang.Object[]{(java.lang.Object) expressions});
	}

	public void install_effect(Object effect) {
		super.call("install_effect", new java.lang.Object[]{(java.lang.Object) effect});
	}

	public void reload_effects() {
		super.call("reload_effects");
	}

	public boolean is_menu_visible() {
		return (boolean) super.call("is_menu_visible");
	}

	public void menu_option(long option) {
		super.call("menu_option", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public boolean isBbcode_enabled() {
		return (boolean) super.call("is_using_bbcode", new java.lang.Object[0]);
	}

	public void setBbcode_enabled(boolean value) {
		super.call("set_use_bbcode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getText() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setText(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFit_content() {
		return (boolean) super.call("is_fit_content_enabled", new java.lang.Object[0]);
	}

	public void setFit_content(boolean value) {
		super.call("set_fit_content", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_active() {
		return (boolean) super.call("is_scroll_active", new java.lang.Object[0]);
	}

	public void setScroll_active(boolean value) {
		super.call("set_scroll_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_following() {
		return (boolean) super.call("is_scroll_following", new java.lang.Object[0]);
	}

	public void setScroll_following(boolean value) {
		super.call("set_scroll_follow", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScroll_following_visible_characters() {
		return (boolean) super.call("is_scroll_following_visible_characters", new java.lang.Object[0]);
	}

	public void setScroll_following_visible_characters(boolean value) {
		super.call("set_scroll_follow_visible_characters", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getTab_size() {
		return (long) super.call("get_tab_size", new java.lang.Object[0]);
	}

	public void setTab_size(long value) {
		super.call("set_tab_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isContext_menu_enabled() {
		return (boolean) super.call("is_context_menu_enabled", new java.lang.Object[0]);
	}

	public void setContext_menu_enabled(boolean value) {
		super.call("set_context_menu_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShortcut_keys_enabled() {
		return (boolean) super.call("is_shortcut_keys_enabled", new java.lang.Object[0]);
	}

	public void setShortcut_keys_enabled(boolean value) {
		super.call("set_shortcut_keys_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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

	public long getJustification_flags() {
		return (long) super.call("get_justification_flags", new java.lang.Object[0]);
	}

	public void setJustification_flags(long value) {
		super.call("set_justification_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double[] getTab_stops() {
		return (double[]) super.call("get_tab_stops", new java.lang.Object[0]);
	}

	public void setTab_stops(double[] value) {
		super.call("set_tab_stops", new java.lang.Object[]{(java.lang.Object) value});
	}

	public RichTextEffect[] getCustom_effects() {
		return (RichTextEffect[]) super.call("get_effects", new java.lang.Object[0]);
	}

	public void setCustom_effects(RichTextEffect[] value) {
		super.call("set_effects", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isMeta_underlined() {
		return (boolean) super.call("is_meta_underlined", new java.lang.Object[0]);
	}

	public void setMeta_underlined(boolean value) {
		super.call("set_meta_underline", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHint_underlined() {
		return (boolean) super.call("is_hint_underlined", new java.lang.Object[0]);
	}

	public void setHint_underlined(boolean value) {
		super.call("set_hint_underline", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isThreaded() {
		return (boolean) super.call("is_threaded", new java.lang.Object[0]);
	}

	public void setThreaded(boolean value) {
		super.call("set_threaded", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getProgress_bar_delay() {
		return (long) super.call("get_progress_bar_delay", new java.lang.Object[0]);
	}

	public void setProgress_bar_delay(long value) {
		super.call("set_progress_bar_delay", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isSelection_enabled() {
		return (boolean) super.call("is_selection_enabled", new java.lang.Object[0]);
	}

	public void setSelection_enabled(boolean value) {
		super.call("set_selection_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDeselect_on_focus_loss_enabled() {
		return (boolean) super.call("is_deselect_on_focus_loss_enabled", new java.lang.Object[0]);
	}

	public void setDeselect_on_focus_loss_enabled(boolean value) {
		super.call("set_deselect_on_focus_loss_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDrag_and_drop_selection_enabled() {
		return (boolean) super.call("is_drag_and_drop_selection_enabled", new java.lang.Object[0]);
	}

	public void setDrag_and_drop_selection_enabled(boolean value) {
		super.call("set_drag_and_drop_selection_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
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
