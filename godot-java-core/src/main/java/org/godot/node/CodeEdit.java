package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class CodeEdit extends TextEdit {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_drawing_fold_gutter", 36873697L),
			java.util.Map.entry("is_drawing_executing_lines_gutter", 36873697L),
			java.util.Map.entry("get_code_completion_options", 3995934104L),
			java.util.Map.entry("move_lines_up", 3218959716L),
			java.util.Map.entry("is_drawing_bookmarks_gutter", 36873697L),
			java.util.Map.entry("unindent_lines", 3218959716L), java.util.Map.entry("unfold_all_lines", 3218959716L),
			java.util.Map.entry("toggle_foldable_lines_at_carets", 3218959716L),
			java.util.Map.entry("get_code_completion_option", 3485342025L),
			java.util.Map.entry("is_line_folded", 1116898809L), java.util.Map.entry("convert_indent", 423910286L),
			java.util.Map.entry("remove_comment_delimiter", 83702148L),
			java.util.Map.entry("is_line_breakpointed", 1116898809L),
			java.util.Map.entry("get_code_completion_prefixes", 3995934104L),
			java.util.Map.entry("set_auto_brace_completion_pairs", 4155329257L),
			java.util.Map.entry("get_indent_size", 3905245786L),
			java.util.Map.entry("is_line_folding_enabled", 36873697L),
			java.util.Map.entry("set_symbol_lookup_word_as_valid", 2586408642L),
			java.util.Map.entry("is_drawing_breakpoints_gutter", 36873697L),
			java.util.Map.entry("get_string_delimiters", 3995934104L),
			java.util.Map.entry("get_comment_delimiters", 3995934104L),
			java.util.Map.entry("has_comment_delimiter", 3927539163L),
			java.util.Map.entry("set_string_delimiters", 381264803L),
			java.util.Map.entry("fold_all_lines", 3218959716L), java.util.Map.entry("is_line_bookmarked", 1116898809L),
			java.util.Map.entry("get_executing_lines", 1930428628L),
			java.util.Map.entry("move_lines_down", 3218959716L),
			java.util.Map.entry("get_text_for_code_completion", 201670096L),
			java.util.Map.entry("update_code_completion_options", 2586408642L),
			java.util.Map.entry("add_string_delimiter", 3146098955L),
			java.util.Map.entry("toggle_foldable_line", 1286410249L),
			java.util.Map.entry("set_line_as_bookmarked", 300928843L),
			java.util.Map.entry("clear_comment_delimiters", 3218959716L),
			java.util.Map.entry("is_auto_indent_enabled", 36873697L),
			java.util.Map.entry("get_text_for_symbol_lookup", 201670096L),
			java.util.Map.entry("set_draw_bookmarks_gutter", 2586408642L),
			java.util.Map.entry("set_code_completion_prefixes", 381264803L),
			java.util.Map.entry("get_code_region_end_tag", 201670096L),
			java.util.Map.entry("set_auto_indent_prefixes", 381264803L),
			java.util.Map.entry("get_auto_brace_completion_close_key", 3135753539L),
			java.util.Map.entry("can_fold_line", 1116898809L),
			java.util.Map.entry("is_code_completion_enabled", 36873697L),
			java.util.Map.entry("set_code_hint", 83702148L), java.util.Map.entry("duplicate_lines", 3218959716L),
			java.util.Map.entry("get_code_region_start_tag", 201670096L),
			java.util.Map.entry("get_bookmarked_lines", 1930428628L), java.util.Map.entry("is_in_comment", 688195400L),
			java.util.Map.entry("is_in_string", 688195400L),
			java.util.Map.entry("get_text_with_cursor_char", 1391810591L),
			java.util.Map.entry("clear_bookmarked_lines", 3218959716L),
			java.util.Map.entry("duplicate_selection", 3218959716L), java.util.Map.entry("fold_line", 1286410249L),
			java.util.Map.entry("set_symbol_tooltip_on_hover_enabled", 2586408642L),
			java.util.Map.entry("has_auto_brace_completion_open_key", 3927539163L),
			java.util.Map.entry("set_highlight_matching_braces_enabled", 2586408642L),
			java.util.Map.entry("set_line_numbers_zero_padded", 2586408642L),
			java.util.Map.entry("is_line_code_region_start", 1116898809L),
			java.util.Map.entry("get_delimiter_end_position", 3016396712L),
			java.util.Map.entry("confirm_code_completion", 107499316L),
			java.util.Map.entry("is_symbol_tooltip_on_hover_enabled", 36873697L),
			java.util.Map.entry("set_symbol_lookup_on_click_enabled", 2586408642L),
			java.util.Map.entry("indent_lines", 3218959716L),
			java.util.Map.entry("is_draw_line_numbers_enabled", 36873697L),
			java.util.Map.entry("is_highlight_matching_braces_enabled", 36873697L),
			java.util.Map.entry("get_breakpointed_lines", 1930428628L),
			java.util.Map.entry("has_auto_brace_completion_close_key", 3927539163L),
			java.util.Map.entry("set_draw_fold_gutter", 2586408642L),
			java.util.Map.entry("set_line_numbers_min_digits", 1286410249L),
			java.util.Map.entry("get_line_length_guidelines", 3995934104L),
			java.util.Map.entry("clear_executing_lines", 3218959716L),
			java.util.Map.entry("has_string_delimiter", 3927539163L),
			java.util.Map.entry("get_folded_lines", 3995934104L),
			java.util.Map.entry("set_code_completion_enabled", 2586408642L),
			java.util.Map.entry("clear_breakpointed_lines", 3218959716L),
			java.util.Map.entry("add_comment_delimiter", 3146098955L),
			java.util.Map.entry("request_code_completion", 107499316L),
			java.util.Map.entry("is_line_executing", 1116898809L),
			java.util.Map.entry("create_code_region", 3218959716L),
			java.util.Map.entry("add_auto_brace_completion_pair", 3186203200L),
			java.util.Map.entry("get_line_numbers_min_digits", 3905245786L),
			java.util.Map.entry("get_delimiter_end_key", 844755477L),
			java.util.Map.entry("set_code_hint_draw_below", 2586408642L),
			java.util.Map.entry("set_auto_indent_enabled", 2586408642L),
			java.util.Map.entry("set_auto_brace_completion_enabled", 2586408642L),
			java.util.Map.entry("set_line_as_breakpoint", 300928843L),
			java.util.Map.entry("add_code_completion_option", 3944379502L),
			java.util.Map.entry("set_indent_using_spaces", 2586408642L),
			java.util.Map.entry("is_line_numbers_zero_padded", 36873697L),
			java.util.Map.entry("set_draw_line_numbers", 2586408642L),
			java.util.Map.entry("is_symbol_lookup_on_click_enabled", 36873697L),
			java.util.Map.entry("set_indent_size", 1286410249L),
			java.util.Map.entry("remove_string_delimiter", 83702148L),
			java.util.Map.entry("clear_string_delimiters", 3218959716L),
			java.util.Map.entry("delete_lines", 3218959716L),
			java.util.Map.entry("set_line_folding_enabled", 2586408642L), java.util.Map.entry("do_indent", 3218959716L),
			java.util.Map.entry("unfold_line", 1286410249L),
			java.util.Map.entry("set_draw_breakpoints_gutter", 2586408642L),
			java.util.Map.entry("get_delimiter_start_key", 844755477L),
			java.util.Map.entry("set_code_completion_selected_index", 1286410249L),
			java.util.Map.entry("set_line_as_executing", 300928843L),
			java.util.Map.entry("set_code_region_tags", 708800718L),
			java.util.Map.entry("get_delimiter_start_position", 3016396712L),
			java.util.Map.entry("is_indent_using_spaces", 36873697L),
			java.util.Map.entry("is_auto_brace_completion_enabled", 36873697L),
			java.util.Map.entry("get_auto_brace_completion_pairs", 3102165223L),
			java.util.Map.entry("get_code_completion_selected_index", 3905245786L),
			java.util.Map.entry("cancel_code_completion", 3218959716L),
			java.util.Map.entry("set_draw_executing_lines_gutter", 2586408642L),
			java.util.Map.entry("set_comment_delimiters", 381264803L),
			java.util.Map.entry("get_auto_indent_prefixes", 3995934104L),
			java.util.Map.entry("set_line_length_guidelines", 381264803L),
			java.util.Map.entry("is_line_code_region_end", 1116898809L));

	CodeEdit(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CodeEdit(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_indent_using_spaces() {
		return (boolean) super.call("is_indent_using_spaces");
	}

	public boolean is_auto_indent_enabled() {
		return (boolean) super.call("is_auto_indent_enabled");
	}

	public void do_indent() {
		super.call("do_indent");
	}

	public void indent_lines() {
		super.call("indent_lines");
	}

	public void unindent_lines() {
		super.call("unindent_lines");
	}

	public void convert_indent(long from_line, long to_line) {
		super.call("convert_indent",
				new java.lang.Object[]{java.lang.Long.valueOf(from_line), java.lang.Long.valueOf(to_line)});
	}

	public boolean is_auto_brace_completion_enabled() {
		return (boolean) super.call("is_auto_brace_completion_enabled");
	}

	public boolean is_highlight_matching_braces_enabled() {
		return (boolean) super.call("is_highlight_matching_braces_enabled");
	}

	public void add_auto_brace_completion_pair(String start_key, String end_key) {
		super.call("add_auto_brace_completion_pair",
				new java.lang.Object[]{(java.lang.Object) start_key, (java.lang.Object) end_key});
	}

	public boolean has_auto_brace_completion_open_key(String open_key) {
		return (boolean) super.call("has_auto_brace_completion_open_key",
				new java.lang.Object[]{(java.lang.Object) open_key});
	}

	public boolean has_auto_brace_completion_close_key(String close_key) {
		return (boolean) super.call("has_auto_brace_completion_close_key",
				new java.lang.Object[]{(java.lang.Object) close_key});
	}

	public String get_auto_brace_completion_close_key(String open_key) {
		return (String) super.call("get_auto_brace_completion_close_key",
				new java.lang.Object[]{(java.lang.Object) open_key});
	}

	public boolean is_drawing_breakpoints_gutter() {
		return (boolean) super.call("is_drawing_breakpoints_gutter");
	}

	public boolean is_drawing_bookmarks_gutter() {
		return (boolean) super.call("is_drawing_bookmarks_gutter");
	}

	public boolean is_drawing_executing_lines_gutter() {
		return (boolean) super.call("is_drawing_executing_lines_gutter");
	}

	public void set_line_as_breakpoint(long line, boolean breakpointed) {
		super.call("set_line_as_breakpoint",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Boolean.valueOf(breakpointed)});
	}

	public boolean is_line_breakpointed(long line) {
		return (boolean) super.call("is_line_breakpointed", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void clear_breakpointed_lines() {
		super.call("clear_breakpointed_lines");
	}

	public void set_line_as_bookmarked(long line, boolean bookmarked) {
		super.call("set_line_as_bookmarked",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Boolean.valueOf(bookmarked)});
	}

	public boolean is_line_bookmarked(long line) {
		return (boolean) super.call("is_line_bookmarked", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void clear_bookmarked_lines() {
		super.call("clear_bookmarked_lines");
	}

	public void set_line_as_executing(long line, boolean executing) {
		super.call("set_line_as_executing",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Boolean.valueOf(executing)});
	}

	public boolean is_line_executing(long line) {
		return (boolean) super.call("is_line_executing", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void clear_executing_lines() {
		super.call("clear_executing_lines");
	}

	public boolean is_draw_line_numbers_enabled() {
		return (boolean) super.call("is_draw_line_numbers_enabled");
	}

	public boolean is_line_numbers_zero_padded() {
		return (boolean) super.call("is_line_numbers_zero_padded");
	}

	public boolean is_drawing_fold_gutter() {
		return (boolean) super.call("is_drawing_fold_gutter");
	}

	public boolean is_line_folding_enabled() {
		return (boolean) super.call("is_line_folding_enabled");
	}

	public boolean can_fold_line(long line) {
		return (boolean) super.call("can_fold_line", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void fold_line(long line) {
		super.call("fold_line", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void unfold_line(long line) {
		super.call("unfold_line", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void fold_all_lines() {
		super.call("fold_all_lines");
	}

	public void unfold_all_lines() {
		super.call("unfold_all_lines");
	}

	public void toggle_foldable_line(long line) {
		super.call("toggle_foldable_line", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void toggle_foldable_lines_at_carets() {
		super.call("toggle_foldable_lines_at_carets");
	}

	public boolean is_line_folded(long line) {
		return (boolean) super.call("is_line_folded", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void create_code_region() {
		super.call("create_code_region");
	}

	public void set_code_region_tags(String start, String end) {
		super.call("set_code_region_tags", new java.lang.Object[]{(java.lang.Object) start, (java.lang.Object) end});
	}

	public boolean is_line_code_region_start(long line) {
		return (boolean) super.call("is_line_code_region_start", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public boolean is_line_code_region_end(long line) {
		return (boolean) super.call("is_line_code_region_end", new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void add_string_delimiter(String start_key, String end_key, boolean line_only) {
		super.call("add_string_delimiter", new java.lang.Object[]{(java.lang.Object) start_key,
				(java.lang.Object) end_key, java.lang.Boolean.valueOf(line_only)});
	}

	public void remove_string_delimiter(String start_key) {
		super.call("remove_string_delimiter", new java.lang.Object[]{(java.lang.Object) start_key});
	}

	public boolean has_string_delimiter(String start_key) {
		return (boolean) super.call("has_string_delimiter", new java.lang.Object[]{(java.lang.Object) start_key});
	}

	public void clear_string_delimiters() {
		super.call("clear_string_delimiters");
	}

	public int is_in_string(long line, long column) {
		return (int) super.call("is_in_string",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public void add_comment_delimiter(String start_key, String end_key, boolean line_only) {
		super.call("add_comment_delimiter", new java.lang.Object[]{(java.lang.Object) start_key,
				(java.lang.Object) end_key, java.lang.Boolean.valueOf(line_only)});
	}

	public void remove_comment_delimiter(String start_key) {
		super.call("remove_comment_delimiter", new java.lang.Object[]{(java.lang.Object) start_key});
	}

	public boolean has_comment_delimiter(String start_key) {
		return (boolean) super.call("has_comment_delimiter", new java.lang.Object[]{(java.lang.Object) start_key});
	}

	public void clear_comment_delimiters() {
		super.call("clear_comment_delimiters");
	}

	public int is_in_comment(long line, long column) {
		return (int) super.call("is_in_comment",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public String get_delimiter_start_key(long delimiter_index) {
		return (String) super.call("get_delimiter_start_key",
				new java.lang.Object[]{java.lang.Long.valueOf(delimiter_index)});
	}

	public String get_delimiter_end_key(long delimiter_index) {
		return (String) super.call("get_delimiter_end_key",
				new java.lang.Object[]{java.lang.Long.valueOf(delimiter_index)});
	}

	public Vector2 get_delimiter_start_position(long line, long column) {
		return (Vector2) super.call("get_delimiter_start_position",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public Vector2 get_delimiter_end_position(long line, long column) {
		return (Vector2) super.call("get_delimiter_end_position",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public void request_code_completion(boolean force) {
		super.call("request_code_completion", new java.lang.Object[]{java.lang.Boolean.valueOf(force)});
	}

	public void add_code_completion_option(int type, String display_text, String insert_text, Color text_color,
			Resource icon, Object value, long location) {
		super.call("add_code_completion_option",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), (java.lang.Object) display_text,
						(java.lang.Object) insert_text, (java.lang.Object) text_color, (java.lang.Object) icon,
						(java.lang.Object) value, java.lang.Long.valueOf(location)});
	}

	public void update_code_completion_options(boolean force) {
		super.call("update_code_completion_options", new java.lang.Object[]{java.lang.Boolean.valueOf(force)});
	}

	public GodotDictionary get_code_completion_option(long index) {
		return (GodotDictionary) super.call("get_code_completion_option",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void confirm_code_completion(boolean replace) {
		super.call("confirm_code_completion", new java.lang.Object[]{java.lang.Boolean.valueOf(replace)});
	}

	public void cancel_code_completion() {
		super.call("cancel_code_completion");
	}

	public boolean is_code_completion_enabled() {
		return (boolean) super.call("is_code_completion_enabled");
	}

	public boolean is_symbol_lookup_on_click_enabled() {
		return (boolean) super.call("is_symbol_lookup_on_click_enabled");
	}

	public String get_text_with_cursor_char(long line, long column) {
		return (String) super.call("get_text_with_cursor_char",
				new java.lang.Object[]{java.lang.Long.valueOf(line), java.lang.Long.valueOf(column)});
	}

	public boolean is_symbol_tooltip_on_hover_enabled() {
		return (boolean) super.call("is_symbol_tooltip_on_hover_enabled");
	}

	public void move_lines_up() {
		super.call("move_lines_up");
	}

	public void move_lines_down() {
		super.call("move_lines_down");
	}

	public void delete_lines() {
		super.call("delete_lines");
	}

	public void duplicate_selection() {
		super.call("duplicate_selection");
	}

	public void duplicate_lines() {
		super.call("duplicate_lines");
	}

	public boolean isSymbol_lookup_on_click() {
		return (boolean) super.call("is_symbol_lookup_on_click_enabled", new java.lang.Object[0]);
	}

	public void setSymbol_lookup_on_click(boolean value) {
		super.call("set_symbol_lookup_on_click_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSymbol_tooltip_on_hover() {
		return (boolean) super.call("is_symbol_tooltip_on_hover_enabled", new java.lang.Object[0]);
	}

	public void setSymbol_tooltip_on_hover(boolean value) {
		super.call("set_symbol_tooltip_on_hover_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isLine_folding() {
		return (boolean) super.call("is_line_folding_enabled", new java.lang.Object[0]);
	}

	public void setLine_folding(boolean value) {
		super.call("set_line_folding_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public int[] getLine_length_guidelines() {
		return (int[]) super.call("get_line_length_guidelines", new java.lang.Object[0]);
	}

	public void setLine_length_guidelines(int[] value) {
		super.call("set_line_length_guidelines", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isGutters_draw_breakpoints_gutter() {
		return (boolean) super.call("is_drawing_breakpoints_gutter", new java.lang.Object[0]);
	}

	public void setGutters_draw_breakpoints_gutter(boolean value) {
		super.call("set_draw_breakpoints_gutter", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isGutters_draw_bookmarks() {
		return (boolean) super.call("is_drawing_bookmarks_gutter", new java.lang.Object[0]);
	}

	public void setGutters_draw_bookmarks(boolean value) {
		super.call("set_draw_bookmarks_gutter", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isGutters_draw_executing_lines() {
		return (boolean) super.call("is_drawing_executing_lines_gutter", new java.lang.Object[0]);
	}

	public void setGutters_draw_executing_lines(boolean value) {
		super.call("set_draw_executing_lines_gutter", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isGutters_draw_line_numbers() {
		return (boolean) super.call("is_draw_line_numbers_enabled", new java.lang.Object[0]);
	}

	public void setGutters_draw_line_numbers(boolean value) {
		super.call("set_draw_line_numbers", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isGutters_zero_pad_line_numbers() {
		return (boolean) super.call("is_line_numbers_zero_padded", new java.lang.Object[0]);
	}

	public void setGutters_zero_pad_line_numbers(boolean value) {
		super.call("set_line_numbers_zero_padded", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getGutters_line_numbers_min_digits() {
		return (long) super.call("get_line_numbers_min_digits", new java.lang.Object[0]);
	}

	public void setGutters_line_numbers_min_digits(long value) {
		super.call("set_line_numbers_min_digits", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isGutters_draw_fold_gutter() {
		return (boolean) super.call("is_drawing_fold_gutter", new java.lang.Object[0]);
	}

	public void setGutters_draw_fold_gutter(boolean value) {
		super.call("set_draw_fold_gutter", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String[] getDelimiter_strings() {
		return (String[]) super.call("get_string_delimiters", new java.lang.Object[0]);
	}

	public void setDelimiter_strings(String[] value) {
		super.call("set_string_delimiters", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String[] getDelimiter_comments() {
		return (String[]) super.call("get_comment_delimiters", new java.lang.Object[0]);
	}

	public void setDelimiter_comments(String[] value) {
		super.call("set_comment_delimiters", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCode_completion_enabled() {
		return (boolean) super.call("is_code_completion_enabled", new java.lang.Object[0]);
	}

	public void setCode_completion_enabled(boolean value) {
		super.call("set_code_completion_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String[] getCode_completion_prefixes() {
		return (String[]) super.call("get_code_completion_prefixes", new java.lang.Object[0]);
	}

	public void setCode_completion_prefixes(String[] value) {
		super.call("set_code_completion_prefixes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getIndent_size() {
		return (long) super.call("get_indent_size", new java.lang.Object[0]);
	}

	public void setIndent_size(long value) {
		super.call("set_indent_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isIndent_use_spaces() {
		return (boolean) super.call("is_indent_using_spaces", new java.lang.Object[0]);
	}

	public void setIndent_use_spaces(boolean value) {
		super.call("set_indent_using_spaces", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isIndent_automatic() {
		return (boolean) super.call("is_auto_indent_enabled", new java.lang.Object[0]);
	}

	public void setIndent_automatic(boolean value) {
		super.call("set_auto_indent_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String[] getIndent_automatic_prefixes() {
		return (String[]) super.call("get_auto_indent_prefixes", new java.lang.Object[0]);
	}

	public void setIndent_automatic_prefixes(String[] value) {
		super.call("set_auto_indent_prefixes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isAuto_brace_completion_enabled() {
		return (boolean) super.call("is_auto_brace_completion_enabled", new java.lang.Object[0]);
	}

	public void setAuto_brace_completion_enabled(boolean value) {
		super.call("set_auto_brace_completion_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAuto_brace_completion_highlight_matching() {
		return (boolean) super.call("is_highlight_matching_braces_enabled", new java.lang.Object[0]);
	}

	public void setAuto_brace_completion_highlight_matching(boolean value) {
		super.call("set_highlight_matching_braces_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotDictionary getAuto_brace_completion_pairs() {
		return (GodotDictionary) super.call("get_auto_brace_completion_pairs", new java.lang.Object[0]);
	}

	public void setAuto_brace_completion_pairs(GodotDictionary value) {
		super.call("set_auto_brace_completion_pairs", new java.lang.Object[]{(java.lang.Object) value});
	}
}
