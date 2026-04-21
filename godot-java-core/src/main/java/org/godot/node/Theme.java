package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class Theme extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_default_base_scale", 1740695150L),
			java.util.Map.entry("clear_type_variation", 3304788590L),
			java.util.Map.entry("get_theme_item_list", 3726716710L),
			java.util.Map.entry("get_constant_list", 4291131558L), java.util.Map.entry("get_font_list", 4291131558L),
			java.util.Map.entry("has_font", 471820014L), java.util.Map.entry("get_font_size_list", 4291131558L),
			java.util.Map.entry("rename_icon", 642128662L), java.util.Map.entry("get_icon", 934555193L),
			java.util.Map.entry("get_font_type_list", 1139954409L),
			java.util.Map.entry("rename_theme_item", 3900867553L), java.util.Map.entry("remove_type", 3304788590L),
			java.util.Map.entry("merge_with", 2326690814L), java.util.Map.entry("get_icon_type_list", 1139954409L),
			java.util.Map.entry("set_type_variation", 3740211285L), java.util.Map.entry("has_icon", 471820014L),
			java.util.Map.entry("get_theme_item_type_list", 1316004935L),
			java.util.Map.entry("set_default_font", 1262170328L), java.util.Map.entry("get_color_list", 4291131558L),
			java.util.Map.entry("clear_theme_item", 2965505587L), java.util.Map.entry("has_theme_item", 1739311056L),
			java.util.Map.entry("get_font_size", 2419549490L), java.util.Map.entry("set_theme_item", 2492983623L),
			java.util.Map.entry("get_color_type_list", 1139954409L), java.util.Map.entry("get_icon_list", 4291131558L),
			java.util.Map.entry("has_color", 471820014L), java.util.Map.entry("has_font_size", 471820014L),
			java.util.Map.entry("has_stylebox", 471820014L), java.util.Map.entry("get_stylebox", 3405608165L),
			java.util.Map.entry("rename_constant", 642128662L), java.util.Map.entry("set_constant", 281601298L),
			java.util.Map.entry("get_default_font", 3229501585L), java.util.Map.entry("clear_font_size", 3740211285L),
			java.util.Map.entry("rename_type", 3740211285L), java.util.Map.entry("clear_font", 3740211285L),
			java.util.Map.entry("get_type_variation_base", 1965194235L),
			java.util.Map.entry("has_default_font", 36873697L), java.util.Map.entry("get_color", 2015923404L),
			java.util.Map.entry("get_default_font_size", 3905245786L), java.util.Map.entry("add_type", 3304788590L),
			java.util.Map.entry("get_theme_item", 2191024021L), java.util.Map.entry("get_font", 3445063586L),
			java.util.Map.entry("clear_stylebox", 3740211285L), java.util.Map.entry("set_font", 177292320L),
			java.util.Map.entry("get_stylebox_type_list", 1139954409L),
			java.util.Map.entry("get_stylebox_list", 4291131558L), java.util.Map.entry("clear_constant", 3740211285L),
			java.util.Map.entry("is_type_variation", 471820014L), java.util.Map.entry("set_font_size", 281601298L),
			java.util.Map.entry("get_constant_type_list", 1139954409L),
			java.util.Map.entry("has_default_font_size", 36873697L), java.util.Map.entry("get_constant", 2419549490L),
			java.util.Map.entry("clear_icon", 3740211285L), java.util.Map.entry("rename_font", 642128662L),
			java.util.Map.entry("set_default_font_size", 1286410249L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("rename_color", 642128662L), java.util.Map.entry("set_icon", 2188371082L),
			java.util.Map.entry("set_color", 4111215154L), java.util.Map.entry("set_default_base_scale", 373806689L),
			java.util.Map.entry("has_constant", 471820014L), java.util.Map.entry("clear_color", 3740211285L),
			java.util.Map.entry("get_type_list", 1139954409L),
			java.util.Map.entry("get_font_size_type_list", 1139954409L),
			java.util.Map.entry("rename_stylebox", 642128662L), java.util.Map.entry("rename_font_size", 642128662L),
			java.util.Map.entry("set_stylebox", 2075907568L), java.util.Map.entry("has_default_base_scale", 36873697L),
			java.util.Map.entry("get_type_variation_list", 1761182771L));

	Theme(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Theme(long nativePointer) {
		super(nativePointer);
	}

	public void set_icon(String name, String theme_type, Texture2D texture) {
		super.call("set_icon", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type,
				(java.lang.Object) texture});
	}

	public Texture2D get_icon(String name, String theme_type) {
		return (Texture2D) super.call("get_icon",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_icon(String name, String theme_type) {
		return (boolean) super.call("has_icon",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_icon(String old_name, String name, String theme_type) {
		super.call("rename_icon", new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) name,
				(java.lang.Object) theme_type});
	}

	public void clear_icon(String name, String theme_type) {
		super.call("clear_icon", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_icon_list(String theme_type) {
		return (String[]) super.call("get_icon_list", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void set_stylebox(String name, String theme_type, StyleBox texture) {
		super.call("set_stylebox", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type,
				(java.lang.Object) texture});
	}

	public StyleBox get_stylebox(String name, String theme_type) {
		return (StyleBox) super.call("get_stylebox",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_stylebox(String name, String theme_type) {
		return (boolean) super.call("has_stylebox",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_stylebox(String old_name, String name, String theme_type) {
		super.call("rename_stylebox", new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) name,
				(java.lang.Object) theme_type});
	}

	public void clear_stylebox(String name, String theme_type) {
		super.call("clear_stylebox", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_stylebox_list(String theme_type) {
		return (String[]) super.call("get_stylebox_list", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void set_font(String name, String theme_type, Font font) {
		super.call("set_font", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type,
				(java.lang.Object) font});
	}

	public Font get_font(String name, String theme_type) {
		return (Font) super.call("get_font",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_font(String name, String theme_type) {
		return (boolean) super.call("has_font",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_font(String old_name, String name, String theme_type) {
		super.call("rename_font", new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) name,
				(java.lang.Object) theme_type});
	}

	public void clear_font(String name, String theme_type) {
		super.call("clear_font", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_font_list(String theme_type) {
		return (String[]) super.call("get_font_list", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void set_font_size(String name, String theme_type, long font_size) {
		super.call("set_font_size", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type,
				java.lang.Long.valueOf(font_size)});
	}

	public int get_font_size(String name, String theme_type) {
		return (int) super.call("get_font_size",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_font_size(String name, String theme_type) {
		return (boolean) super.call("has_font_size",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_font_size(String old_name, String name, String theme_type) {
		super.call("rename_font_size", new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) name,
				(java.lang.Object) theme_type});
	}

	public void clear_font_size(String name, String theme_type) {
		super.call("clear_font_size", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_font_size_list(String theme_type) {
		return (String[]) super.call("get_font_size_list", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void set_color(String name, String theme_type, Color color) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type,
				(java.lang.Object) color});
	}

	public Color get_color(String name, String theme_type) {
		return (Color) super.call("get_color",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_color(String name, String theme_type) {
		return (boolean) super.call("has_color",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_color(String old_name, String name, String theme_type) {
		super.call("rename_color", new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) name,
				(java.lang.Object) theme_type});
	}

	public void clear_color(String name, String theme_type) {
		super.call("clear_color", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_color_list(String theme_type) {
		return (String[]) super.call("get_color_list", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void set_constant(String name, String theme_type, long constant) {
		super.call("set_constant", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type,
				java.lang.Long.valueOf(constant)});
	}

	public int get_constant(String name, String theme_type) {
		return (int) super.call("get_constant",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_constant(String name, String theme_type) {
		return (boolean) super.call("has_constant",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_constant(String old_name, String name, String theme_type) {
		super.call("rename_constant", new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) name,
				(java.lang.Object) theme_type});
	}

	public void clear_constant(String name, String theme_type) {
		super.call("clear_constant", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_constant_list(String theme_type) {
		return (String[]) super.call("get_constant_list", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public boolean has_default_base_scale() {
		return (boolean) super.call("has_default_base_scale");
	}

	public boolean has_default_font() {
		return (boolean) super.call("has_default_font");
	}

	public boolean has_default_font_size() {
		return (boolean) super.call("has_default_font_size");
	}

	public void set_theme_item(int data_type, String name, String theme_type, Object value) {
		super.call("set_theme_item", new java.lang.Object[]{java.lang.Integer.valueOf(data_type),
				(java.lang.Object) name, (java.lang.Object) theme_type, (java.lang.Object) value});
	}

	public Object get_theme_item(int data_type, String name, String theme_type) {
		return (Object) super.call("get_theme_item", new java.lang.Object[]{java.lang.Integer.valueOf(data_type),
				(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_item(int data_type, String name, String theme_type) {
		return (boolean) super.call("has_theme_item", new java.lang.Object[]{java.lang.Integer.valueOf(data_type),
				(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void rename_theme_item(int data_type, String old_name, String name, String theme_type) {
		super.call("rename_theme_item", new java.lang.Object[]{java.lang.Integer.valueOf(data_type),
				(java.lang.Object) old_name, (java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public void clear_theme_item(int data_type, String name, String theme_type) {
		super.call("clear_theme_item", new java.lang.Object[]{java.lang.Integer.valueOf(data_type),
				(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public String[] get_theme_item_list(int data_type, String theme_type) {
		return (String[]) super.call("get_theme_item_list",
				new java.lang.Object[]{java.lang.Integer.valueOf(data_type), (java.lang.Object) theme_type});
	}

	public String[] get_theme_item_type_list(int data_type) {
		return (String[]) super.call("get_theme_item_type_list",
				new java.lang.Object[]{java.lang.Integer.valueOf(data_type)});
	}

	public void set_type_variation(String theme_type, String base_type) {
		super.call("set_type_variation",
				new java.lang.Object[]{(java.lang.Object) theme_type, (java.lang.Object) base_type});
	}

	public boolean is_type_variation(String theme_type, String base_type) {
		return (boolean) super.call("is_type_variation",
				new java.lang.Object[]{(java.lang.Object) theme_type, (java.lang.Object) base_type});
	}

	public void clear_type_variation(String theme_type) {
		super.call("clear_type_variation", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public String get_type_variation_base(String theme_type) {
		return (String) super.call("get_type_variation_base", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public String[] get_type_variation_list(String base_type) {
		return (String[]) super.call("get_type_variation_list", new java.lang.Object[]{(java.lang.Object) base_type});
	}

	public void add_type(String theme_type) {
		super.call("add_type", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void remove_type(String theme_type) {
		super.call("remove_type", new java.lang.Object[]{(java.lang.Object) theme_type});
	}

	public void rename_type(String old_theme_type, String theme_type) {
		super.call("rename_type",
				new java.lang.Object[]{(java.lang.Object) old_theme_type, (java.lang.Object) theme_type});
	}

	public void merge_with(Theme other) {
		super.call("merge_with", new java.lang.Object[]{(java.lang.Object) other});
	}

	public void clear() {
		super.call("clear");
	}

	public double getDefault_base_scale() {
		return (double) super.call("get_default_base_scale", new java.lang.Object[0]);
	}

	public void setDefault_base_scale(double value) {
		super.call("set_default_base_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Font getDefault_font() {
		return (Font) super.call("get_default_font", new java.lang.Object[0]);
	}

	public void setDefault_font(Font value) {
		super.call("set_default_font", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDefault_font_size() {
		return (long) super.call("get_default_font_size", new java.lang.Object[0]);
	}

	public void setDefault_font_size(long value) {
		super.call("set_default_font_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
