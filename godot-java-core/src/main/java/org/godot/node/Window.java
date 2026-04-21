package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Rect2i;
import org.godot.math.Vector2i;

public class Window extends Viewport {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_position", 3690982128L), java.util.Map.entry("set_current_screen", 1286410249L),
			java.util.Map.entry("end_bulk_theme_override", 3218959716L),
			java.util.Map.entry("remove_theme_color_override", 3304788590L),
			java.util.Map.entry("get_theme_color", 2798751242L),
			java.util.Map.entry("remove_theme_icon_override", 3304788590L),
			java.util.Map.entry("get_layout_direction", 3909617982L),
			java.util.Map.entry("get_theme_default_font_size", 3905245786L),
			java.util.Map.entry("set_wrap_controls", 2586408642L),
			java.util.Map.entry("child_controls_changed", 3218959716L),
			java.util.Map.entry("get_keep_title_visible", 36873697L), java.util.Map.entry("set_position", 1130785943L),
			java.util.Map.entry("get_theme_default_base_scale", 1740695150L),
			java.util.Map.entry("get_mode", 2566346114L), java.util.Map.entry("set_min_size", 1130785943L),
			java.util.Map.entry("popup_centered_ratio", 1014814997L),
			java.util.Map.entry("set_ime_active", 2586408642L), java.util.Map.entry("popup_centered", 3447975422L),
			java.util.Map.entry("popup_exclusive_centered_ratio", 2284776287L),
			java.util.Map.entry("is_transient", 36873697L), java.util.Map.entry("has_theme_font_size", 866386512L),
			java.util.Map.entry("get_force_native", 36873697L), java.util.Map.entry("set_nonclient_area", 1763793166L),
			java.util.Map.entry("set_mouse_passthrough_polygon", 1509147220L),
			java.util.Map.entry("add_theme_font_size_override", 2415702435L),
			java.util.Map.entry("add_theme_stylebox_override", 4188838905L),
			java.util.Map.entry("add_theme_font_override", 3518018674L), java.util.Map.entry("set_theme", 2326690814L),
			java.util.Map.entry("set_mode", 3095236531L), java.util.Map.entry("can_draw", 36873697L),
			java.util.Map.entry("get_content_scale_mode", 161585230L), java.util.Map.entry("set_max_size", 1130785943L),
			java.util.Map.entry("get_min_size", 3690982128L),
			java.util.Map.entry("set_keep_title_visible", 2586408642L),
			java.util.Map.entry("get_accessibility_name", 201670096L),
			java.util.Map.entry("set_content_scale_aspect", 2370399418L),
			java.util.Map.entry("popup_exclusive", 2134721627L),
			java.util.Map.entry("add_theme_icon_override", 1373065600L), java.util.Map.entry("get_title", 201670096L),
			java.util.Map.entry("grab_focus", 3218959716L), java.util.Map.entry("has_theme_stylebox", 866386512L),
			java.util.Map.entry("has_theme_font_size_override", 2619796661L),
			java.util.Map.entry("popup_centered_clamped", 2613752477L),
			java.util.Map.entry("get_content_scale_size", 3690982128L),
			java.util.Map.entry("get_content_scale_factor", 1740695150L),
			java.util.Map.entry("set_exclusive", 2586408642L),
			java.util.Map.entry("set_content_scale_size", 1130785943L),
			java.util.Map.entry("get_accessibility_description", 201670096L),
			java.util.Map.entry("set_transient_to_focused", 2586408642L), java.util.Map.entry("is_visible", 36873697L),
			java.util.Map.entry("has_theme_constant_override", 2619796661L),
			java.util.Map.entry("get_content_scale_stretch", 536857316L),
			java.util.Map.entry("popup_exclusive_on_parent", 2344671043L),
			java.util.Map.entry("get_current_screen", 3905245786L), java.util.Map.entry("set_flag", 3426449779L),
			java.util.Map.entry("has_theme_font_override", 2619796661L),
			java.util.Map.entry("popup_exclusive_centered", 3357594017L), java.util.Map.entry("hide", 3218959716L),
			java.util.Map.entry("begin_bulk_theme_override", 3218959716L),
			java.util.Map.entry("set_force_native", 2586408642L), java.util.Map.entry("get_max_size", 3690982128L),
			java.util.Map.entry("get_theme_type_variation", 2002593661L), java.util.Map.entry("get_flag", 3062752289L),
			java.util.Map.entry("set_transient", 2586408642L),
			java.util.Map.entry("add_theme_color_override", 4260178595L),
			java.util.Map.entry("has_theme_icon_override", 2619796661L),
			java.util.Map.entry("set_theme_type_variation", 3304788590L), java.util.Map.entry("has_focus", 36873697L),
			java.util.Map.entry("set_visible", 2586408642L),
			java.util.Map.entry("is_using_font_oversampling", 36873697L),
			java.util.Map.entry("remove_theme_constant_override", 3304788590L),
			java.util.Map.entry("get_theme_font", 2826986490L),
			java.util.Map.entry("set_use_font_oversampling", 2586408642L),
			java.util.Map.entry("get_theme_constant", 1327056374L),
			java.util.Map.entry("set_accessibility_description", 83702148L),
			java.util.Map.entry("popup_exclusive_centered_clamped", 2612708785L),
			java.util.Map.entry("get_size", 3690982128L), java.util.Map.entry("get_size_with_decorations", 3690982128L),
			java.util.Map.entry("set_auto_translate", 2586408642L),
			java.util.Map.entry("set_content_scale_stretch", 349355940L),
			java.util.Map.entry("is_exclusive", 36873697L), java.util.Map.entry("set_title", 83702148L),
			java.util.Map.entry("has_theme_color", 866386512L),
			java.util.Map.entry("get_contents_minimum_size", 3341600327L),
			java.util.Map.entry("start_resize", 122288853L), java.util.Map.entry("set_accessibility_name", 83702148L),
			java.util.Map.entry("popup_on_parent", 1763793166L), java.util.Map.entry("get_theme_icon", 3163973443L),
			java.util.Map.entry("is_wrapping_controls", 36873697L),
			java.util.Map.entry("has_theme_stylebox_override", 2619796661L),
			java.util.Map.entry("is_maximize_allowed", 36873697L), java.util.Map.entry("set_ime_position", 1130785943L),
			java.util.Map.entry("is_layout_rtl", 36873697L), java.util.Map.entry("get_theme", 3846893731L),
			java.util.Map.entry("get_position_with_decorations", 3690982128L),
			java.util.Map.entry("set_unparent_when_invisible", 2586408642L),
			java.util.Map.entry("start_drag", 3218959716L), java.util.Map.entry("move_to_center", 3218959716L),
			java.util.Map.entry("show", 3218959716L),
			java.util.Map.entry("remove_theme_font_size_override", 3304788590L),
			java.util.Map.entry("remove_theme_font_override", 3304788590L),
			java.util.Map.entry("get_theme_font_size", 1327056374L),
			java.util.Map.entry("get_focused_window", 1835468782L),
			java.util.Map.entry("has_theme_constant", 866386512L),
			java.util.Map.entry("is_transient_to_focused", 36873697L),
			java.util.Map.entry("has_theme_icon", 866386512L), java.util.Map.entry("get_nonclient_area", 410525958L),
			java.util.Map.entry("get_content_scale_aspect", 4158790715L),
			java.util.Map.entry("get_theme_stylebox", 604739069L),
			java.util.Map.entry("set_content_scale_factor", 373806689L),
			java.util.Map.entry("request_attention", 3218959716L), java.util.Map.entry("set_size", 1130785943L),
			java.util.Map.entry("get_window_id", 3905245786L), java.util.Map.entry("reset_size", 3218959716L),
			java.util.Map.entry("get_mouse_passthrough_polygon", 2961356807L),
			java.util.Map.entry("has_theme_color_override", 2619796661L),
			java.util.Map.entry("get_initial_position", 4294066647L), java.util.Map.entry("has_theme_font", 866386512L),
			java.util.Map.entry("get_theme_default_font", 3229501585L),
			java.util.Map.entry("move_to_foreground", 3218959716L), java.util.Map.entry("popup", 1680304321L),
			java.util.Map.entry("set_layout_direction", 3094704184L),
			java.util.Map.entry("is_auto_translating", 36873697L), java.util.Map.entry("is_embedded", 36873697L),
			java.util.Map.entry("set_initial_position", 4084468099L),
			java.util.Map.entry("set_content_scale_mode", 2937716473L),
			java.util.Map.entry("add_theme_constant_override", 2415702435L),
			java.util.Map.entry("remove_theme_stylebox_override", 3304788590L));

	Window(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Window(long nativePointer) {
		super(nativePointer);
	}

	public void move_to_center() {
		super.call("move_to_center");
	}

	public void reset_size() {
		super.call("reset_size");
	}

	public void set_flag(int flag, boolean enabled) {
		super.call("set_flag",
				new java.lang.Object[]{java.lang.Integer.valueOf(flag), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean get_flag(int flag) {
		return (boolean) super.call("get_flag", new java.lang.Object[]{java.lang.Integer.valueOf(flag)});
	}

	public boolean is_maximize_allowed() {
		return (boolean) super.call("is_maximize_allowed");
	}

	public void request_attention() {
		super.call("request_attention");
	}

	public void move_to_foreground() {
		super.call("move_to_foreground");
	}

	public boolean is_visible() {
		return (boolean) super.call("is_visible");
	}

	public void hide() {
		super.call("hide");
	}

	public void show() {
		super.call("show");
	}

	public boolean is_transient() {
		return (boolean) super.call("is_transient");
	}

	public boolean is_transient_to_focused() {
		return (boolean) super.call("is_transient_to_focused");
	}

	public boolean is_exclusive() {
		return (boolean) super.call("is_exclusive");
	}

	public boolean can_draw() {
		return (boolean) super.call("can_draw");
	}

	public boolean has_focus() {
		return (boolean) super.call("has_focus");
	}

	public void grab_focus() {
		super.call("grab_focus");
	}

	public void start_drag() {
		super.call("start_drag");
	}

	public void start_resize(int edge) {
		super.call("start_resize", new java.lang.Object[]{java.lang.Integer.valueOf(edge)});
	}

	public boolean is_embedded() {
		return (boolean) super.call("is_embedded");
	}

	public boolean is_wrapping_controls() {
		return (boolean) super.call("is_wrapping_controls");
	}

	public void child_controls_changed() {
		super.call("child_controls_changed");
	}

	public void begin_bulk_theme_override() {
		super.call("begin_bulk_theme_override");
	}

	public void end_bulk_theme_override() {
		super.call("end_bulk_theme_override");
	}

	public void add_theme_icon_override(String name, Texture2D texture) {
		super.call("add_theme_icon_override",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) texture});
	}

	public void add_theme_stylebox_override(String name, StyleBox stylebox) {
		super.call("add_theme_stylebox_override",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) stylebox});
	}

	public void add_theme_font_override(String name, Font font) {
		super.call("add_theme_font_override", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) font});
	}

	public void add_theme_font_size_override(String name, long font_size) {
		super.call("add_theme_font_size_override",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Long.valueOf(font_size)});
	}

	public void add_theme_color_override(String name, Color color) {
		super.call("add_theme_color_override",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) color});
	}

	public void add_theme_constant_override(String name, long constant) {
		super.call("add_theme_constant_override",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Long.valueOf(constant)});
	}

	public void remove_theme_icon_override(String name) {
		super.call("remove_theme_icon_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_theme_stylebox_override(String name) {
		super.call("remove_theme_stylebox_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_theme_font_override(String name) {
		super.call("remove_theme_font_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_theme_font_size_override(String name) {
		super.call("remove_theme_font_size_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_theme_color_override(String name) {
		super.call("remove_theme_color_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_theme_constant_override(String name) {
		super.call("remove_theme_constant_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Texture2D get_theme_icon(String name, String theme_type) {
		return (Texture2D) super.call("get_theme_icon",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public StyleBox get_theme_stylebox(String name, String theme_type) {
		return (StyleBox) super.call("get_theme_stylebox",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public Font get_theme_font(String name, String theme_type) {
		return (Font) super.call("get_theme_font",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public int get_theme_font_size(String name, String theme_type) {
		return (int) super.call("get_theme_font_size",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public Color get_theme_color(String name, String theme_type) {
		return (Color) super.call("get_theme_color",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public int get_theme_constant(String name, String theme_type) {
		return (int) super.call("get_theme_constant",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_icon_override(String name) {
		return (boolean) super.call("has_theme_icon_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_theme_stylebox_override(String name) {
		return (boolean) super.call("has_theme_stylebox_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_theme_font_override(String name) {
		return (boolean) super.call("has_theme_font_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_theme_font_size_override(String name) {
		return (boolean) super.call("has_theme_font_size_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_theme_color_override(String name) {
		return (boolean) super.call("has_theme_color_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_theme_constant_override(String name) {
		return (boolean) super.call("has_theme_constant_override", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_theme_icon(String name, String theme_type) {
		return (boolean) super.call("has_theme_icon",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_stylebox(String name, String theme_type) {
		return (boolean) super.call("has_theme_stylebox",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_font(String name, String theme_type) {
		return (boolean) super.call("has_theme_font",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_font_size(String name, String theme_type) {
		return (boolean) super.call("has_theme_font_size",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_color(String name, String theme_type) {
		return (boolean) super.call("has_theme_color",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean has_theme_constant(String name, String theme_type) {
		return (boolean) super.call("has_theme_constant",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) theme_type});
	}

	public boolean is_layout_rtl() {
		return (boolean) super.call("is_layout_rtl");
	}

	public boolean is_auto_translating() {
		return (boolean) super.call("is_auto_translating");
	}

	public boolean is_using_font_oversampling() {
		return (boolean) super.call("is_using_font_oversampling");
	}

	public void popup(Rect2i rect) {
		super.call("popup", new java.lang.Object[]{(java.lang.Object) rect});
	}

	public void popup_on_parent(Rect2i parent_rect) {
		super.call("popup_on_parent", new java.lang.Object[]{(java.lang.Object) parent_rect});
	}

	public void popup_centered(Vector2i minsize) {
		super.call("popup_centered", new java.lang.Object[]{(java.lang.Object) minsize});
	}

	public void popup_centered_ratio(double ratio) {
		super.call("popup_centered_ratio", new java.lang.Object[]{java.lang.Double.valueOf(ratio)});
	}

	public void popup_centered_clamped(Vector2i minsize, double fallback_ratio) {
		super.call("popup_centered_clamped",
				new java.lang.Object[]{(java.lang.Object) minsize, java.lang.Double.valueOf(fallback_ratio)});
	}

	public void popup_exclusive(Node from_node, Rect2i rect) {
		super.call("popup_exclusive", new java.lang.Object[]{(java.lang.Object) from_node, (java.lang.Object) rect});
	}

	public void popup_exclusive_on_parent(Node from_node, Rect2i parent_rect) {
		super.call("popup_exclusive_on_parent",
				new java.lang.Object[]{(java.lang.Object) from_node, (java.lang.Object) parent_rect});
	}

	public void popup_exclusive_centered(Node from_node, Vector2i minsize) {
		super.call("popup_exclusive_centered",
				new java.lang.Object[]{(java.lang.Object) from_node, (java.lang.Object) minsize});
	}

	public void popup_exclusive_centered_ratio(Node from_node, double ratio) {
		super.call("popup_exclusive_centered_ratio",
				new java.lang.Object[]{(java.lang.Object) from_node, java.lang.Double.valueOf(ratio)});
	}

	public void popup_exclusive_centered_clamped(Node from_node, Vector2i minsize, double fallback_ratio) {
		super.call("popup_exclusive_centered_clamped", new java.lang.Object[]{(java.lang.Object) from_node,
				(java.lang.Object) minsize, java.lang.Double.valueOf(fallback_ratio)});
	}

	public long getMode() {
		return (long) super.call("get_mode", new java.lang.Object[0]);
	}

	public void setMode(long value) {
		super.call("set_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getTitle() {
		return (String) super.call("get_title", new java.lang.Object[0]);
	}

	public void setTitle(String value) {
		super.call("set_title", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getInitial_position() {
		return (long) super.call("get_initial_position", new java.lang.Object[0]);
	}

	public void setInitial_position(long value) {
		super.call("set_initial_position", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2i getPosition() {
		return (Vector2i) super.call("get_position", new java.lang.Object[0]);
	}

	public void setPosition(Vector2i value) {
		super.call("set_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getSize() {
		return (Vector2i) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector2i value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getCurrent_screen() {
		return (long) super.call("get_current_screen", new java.lang.Object[0]);
	}

	public void setCurrent_screen(long value) {
		super.call("set_current_screen", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Rect2i getNonclient_area() {
		return (Rect2i) super.call("get_nonclient_area", new java.lang.Object[0]);
	}

	public void setNonclient_area(Rect2i value) {
		super.call("set_nonclient_area", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getMouse_passthrough_polygon() {
		return (double[][]) super.call("get_mouse_passthrough_polygon", new java.lang.Object[0]);
	}

	public void setMouse_passthrough_polygon(double[][] value) {
		super.call("set_mouse_passthrough_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isVisible() {
		return (boolean) super.call("is_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isWrap_controls() {
		return (boolean) super.call("is_wrapping_controls", new java.lang.Object[0]);
	}

	public void setWrap_controls(boolean value) {
		super.call("set_wrap_controls", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isTransient_() {
		return (boolean) super.call("is_transient", new java.lang.Object[0]);
	}

	public void setTransient_(boolean value) {
		super.call("set_transient", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isTransient_to_focused() {
		return (boolean) super.call("is_transient_to_focused", new java.lang.Object[0]);
	}

	public void setTransient_to_focused(boolean value) {
		super.call("set_transient_to_focused", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isExclusive() {
		return (boolean) super.call("is_exclusive", new java.lang.Object[0]);
	}

	public void setExclusive(boolean value) {
		super.call("set_exclusive", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUnresizable() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUnresizable(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getBorderless() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setBorderless(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAlways_on_top() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setAlways_on_top(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getTransparent() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setTransparent(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUnfocusable() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setUnfocusable(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getPopup_window() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setPopup_window(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getExtend_to_title() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setExtend_to_title(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getMouse_passthrough() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setMouse_passthrough(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSharp_corners() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setSharp_corners(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getExclude_from_capture() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setExclude_from_capture(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getPopup_wm_hint() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setPopup_wm_hint(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getMinimize_disabled() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setMinimize_disabled(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getMaximize_disabled() {
		return (boolean) super.call("get_flag", new java.lang.Object[0]);
	}

	public void setMaximize_disabled(boolean value) {
		super.call("set_flag", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getForce_native() {
		return (boolean) super.call("get_force_native", new java.lang.Object[0]);
	}

	public void setForce_native(boolean value) {
		super.call("set_force_native", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2i getMin_size() {
		return (Vector2i) super.call("get_min_size", new java.lang.Object[0]);
	}

	public void setMin_size(Vector2i value) {
		super.call("set_min_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getMax_size() {
		return (Vector2i) super.call("get_max_size", new java.lang.Object[0]);
	}

	public void setMax_size(Vector2i value) {
		super.call("set_max_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getKeep_title_visible() {
		return (boolean) super.call("get_keep_title_visible", new java.lang.Object[0]);
	}

	public void setKeep_title_visible(boolean value) {
		super.call("set_keep_title_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2i getContent_scale_size() {
		return (Vector2i) super.call("get_content_scale_size", new java.lang.Object[0]);
	}

	public void setContent_scale_size(Vector2i value) {
		super.call("set_content_scale_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getContent_scale_mode() {
		return (long) super.call("get_content_scale_mode", new java.lang.Object[0]);
	}

	public void setContent_scale_mode(long value) {
		super.call("set_content_scale_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getContent_scale_aspect() {
		return (long) super.call("get_content_scale_aspect", new java.lang.Object[0]);
	}

	public void setContent_scale_aspect(long value) {
		super.call("set_content_scale_aspect", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getContent_scale_stretch() {
		return (long) super.call("get_content_scale_stretch", new java.lang.Object[0]);
	}

	public void setContent_scale_stretch(long value) {
		super.call("set_content_scale_stretch", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getContent_scale_factor() {
		return (double) super.call("get_content_scale_factor", new java.lang.Object[0]);
	}

	public void setContent_scale_factor(double value) {
		super.call("set_content_scale_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isAuto_translate() {
		return (boolean) super.call("is_auto_translating", new java.lang.Object[0]);
	}

	public void setAuto_translate(boolean value) {
		super.call("set_auto_translate", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getAccessibility_name() {
		return (String) super.call("get_accessibility_name", new java.lang.Object[0]);
	}

	public void setAccessibility_name(String value) {
		super.call("set_accessibility_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAccessibility_description() {
		return (String) super.call("get_accessibility_description", new java.lang.Object[0]);
	}

	public void setAccessibility_description(String value) {
		super.call("set_accessibility_description", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Theme getTheme() {
		return (Theme) super.call("get_theme", new java.lang.Object[0]);
	}

	public void setTheme(Theme value) {
		super.call("set_theme", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getTheme_type_variation() {
		return (String) super.call("get_theme_type_variation", new java.lang.Object[0]);
	}

	public void setTheme_type_variation(String value) {
		super.call("set_theme_type_variation", new java.lang.Object[]{(java.lang.Object) value});
	}
}
