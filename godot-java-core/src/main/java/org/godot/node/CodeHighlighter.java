package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;

public class CodeHighlighter extends SyntaxHighlighter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_member_keyword_color", 1636512886L),
			java.util.Map.entry("get_symbol_color", 3444240500L), java.util.Map.entry("set_number_color", 2920490490L),
			java.util.Map.entry("remove_member_keyword_color", 83702148L),
			java.util.Map.entry("has_keyword_color", 3927539163L),
			java.util.Map.entry("clear_member_keyword_colors", 3218959716L),
			java.util.Map.entry("get_color_regions", 3102165223L), java.util.Map.entry("add_color_region", 2924977451L),
			java.util.Map.entry("get_keyword_colors", 3102165223L),
			java.util.Map.entry("clear_keyword_colors", 3218959716L),
			java.util.Map.entry("set_member_variable_color", 2920490490L),
			java.util.Map.entry("set_member_keyword_colors", 4155329257L),
			java.util.Map.entry("set_symbol_color", 2920490490L), java.util.Map.entry("get_number_color", 3444240500L),
			java.util.Map.entry("set_color_regions", 4155329257L),
			java.util.Map.entry("get_member_keyword_colors", 3102165223L),
			java.util.Map.entry("get_function_color", 3444240500L),
			java.util.Map.entry("get_member_keyword_color", 3855908743L),
			java.util.Map.entry("get_member_variable_color", 3444240500L),
			java.util.Map.entry("remove_color_region", 83702148L),
			java.util.Map.entry("set_keyword_colors", 4155329257L),
			java.util.Map.entry("remove_keyword_color", 83702148L),
			java.util.Map.entry("clear_color_regions", 3218959716L),
			java.util.Map.entry("add_keyword_color", 1636512886L),
			java.util.Map.entry("get_keyword_color", 3855908743L), java.util.Map.entry("has_color_region", 3927539163L),
			java.util.Map.entry("set_function_color", 2920490490L),
			java.util.Map.entry("has_member_keyword_color", 3927539163L));

	CodeHighlighter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CodeHighlighter(long nativePointer) {
		super(nativePointer);
	}

	public void add_keyword_color(String keyword, Color color) {
		super.call("add_keyword_color", new java.lang.Object[]{(java.lang.Object) keyword, (java.lang.Object) color});
	}

	public void remove_keyword_color(String keyword) {
		super.call("remove_keyword_color", new java.lang.Object[]{(java.lang.Object) keyword});
	}

	public boolean has_keyword_color(String keyword) {
		return (boolean) super.call("has_keyword_color", new java.lang.Object[]{(java.lang.Object) keyword});
	}

	public Color get_keyword_color(String keyword) {
		return (Color) super.call("get_keyword_color", new java.lang.Object[]{(java.lang.Object) keyword});
	}

	public void clear_keyword_colors() {
		super.call("clear_keyword_colors");
	}

	public void add_member_keyword_color(String member_keyword, Color color) {
		super.call("add_member_keyword_color",
				new java.lang.Object[]{(java.lang.Object) member_keyword, (java.lang.Object) color});
	}

	public void remove_member_keyword_color(String member_keyword) {
		super.call("remove_member_keyword_color", new java.lang.Object[]{(java.lang.Object) member_keyword});
	}

	public boolean has_member_keyword_color(String member_keyword) {
		return (boolean) super.call("has_member_keyword_color",
				new java.lang.Object[]{(java.lang.Object) member_keyword});
	}

	public Color get_member_keyword_color(String member_keyword) {
		return (Color) super.call("get_member_keyword_color",
				new java.lang.Object[]{(java.lang.Object) member_keyword});
	}

	public void clear_member_keyword_colors() {
		super.call("clear_member_keyword_colors");
	}

	public void add_color_region(String start_key, String end_key, Color color, boolean line_only) {
		super.call("add_color_region", new java.lang.Object[]{(java.lang.Object) start_key, (java.lang.Object) end_key,
				(java.lang.Object) color, java.lang.Boolean.valueOf(line_only)});
	}

	public void remove_color_region(String start_key) {
		super.call("remove_color_region", new java.lang.Object[]{(java.lang.Object) start_key});
	}

	public boolean has_color_region(String start_key) {
		return (boolean) super.call("has_color_region", new java.lang.Object[]{(java.lang.Object) start_key});
	}

	public void clear_color_regions() {
		super.call("clear_color_regions");
	}

	public Color getNumber_color() {
		return (Color) super.call("get_number_color", new java.lang.Object[0]);
	}

	public void setNumber_color(Color value) {
		super.call("set_number_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getSymbol_color() {
		return (Color) super.call("get_symbol_color", new java.lang.Object[0]);
	}

	public void setSymbol_color(Color value) {
		super.call("set_symbol_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getFunction_color() {
		return (Color) super.call("get_function_color", new java.lang.Object[0]);
	}

	public void setFunction_color(Color value) {
		super.call("set_function_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getMember_variable_color() {
		return (Color) super.call("get_member_variable_color", new java.lang.Object[0]);
	}

	public void setMember_variable_color(Color value) {
		super.call("set_member_variable_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getKeyword_colors() {
		return (GodotDictionary) super.call("get_keyword_colors", new java.lang.Object[0]);
	}

	public void setKeyword_colors(GodotDictionary value) {
		super.call("set_keyword_colors", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getMember_keyword_colors() {
		return (GodotDictionary) super.call("get_member_keyword_colors", new java.lang.Object[0]);
	}

	public void setMember_keyword_colors(GodotDictionary value) {
		super.call("set_member_keyword_colors", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getColor_regions() {
		return (GodotDictionary) super.call("get_color_regions", new java.lang.Object[0]);
	}

	public void setColor_regions(GodotDictionary value) {
		super.call("set_color_regions", new java.lang.Object[]{(java.lang.Object) value});
	}
}
