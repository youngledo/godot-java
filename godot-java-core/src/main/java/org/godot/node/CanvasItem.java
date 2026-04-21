package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class CanvasItem extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_world_2d", 2339128592L), java.util.Map.entry("draw_polygon", 974537912L),
			java.util.Map.entry("make_canvas_position_local", 2656412154L),
			java.util.Map.entry("is_y_sort_enabled", 36873697L), java.util.Map.entry("draw_string", 719605945L),
			java.util.Map.entry("draw_multiline", 3797364428L),
			java.util.Map.entry("get_global_transform_with_canvas", 3814499831L),
			java.util.Map.entry("get_screen_transform", 3814499831L),
			java.util.Map.entry("get_texture_filter", 121960042L),
			java.util.Map.entry("is_transform_notification_enabled", 36873697L),
			java.util.Map.entry("set_visible", 2586408642L), java.util.Map.entry("get_viewport_rect", 1639390495L),
			java.util.Map.entry("draw_dashed_line", 3653831622L), java.util.Map.entry("set_as_top_level", 2586408642L),
			java.util.Map.entry("set_notify_local_transform", 2586408642L),
			java.util.Map.entry("set_texture_filter", 1037999706L),
			java.util.Map.entry("force_update_transform", 3218959716L),
			java.util.Map.entry("draw_multimesh", 937992368L), java.util.Map.entry("draw_end_animation", 3218959716L),
			java.util.Map.entry("get_canvas", 2944877500L),
			java.util.Map.entry("draw_lcd_texture_rect_region", 3212350954L),
			java.util.Map.entry("draw_polyline", 3797364428L),
			java.util.Map.entry("draw_texture_rect_region", 3883821411L),
			java.util.Map.entry("get_viewport_transform", 3814499831L),
			java.util.Map.entry("set_z_as_relative", 2586408642L),
			java.util.Map.entry("get_use_parent_material", 36873697L),
			java.util.Map.entry("get_light_mask", 3905245786L), java.util.Map.entry("get_texture_repeat", 2667158319L),
			java.util.Map.entry("draw_circle", 3153026596L), java.util.Map.entry("get_visibility_layer", 3905245786L),
			java.util.Map.entry("draw_multiline_colors", 2311979562L),
			java.util.Map.entry("get_transform", 3814499831L), java.util.Map.entry("draw_texture_rect", 3832805018L),
			java.util.Map.entry("get_local_mouse_position", 3341600327L),
			java.util.Map.entry("draw_polyline_colors", 2311979562L),
			java.util.Map.entry("draw_multiline_string_outline", 3050414441L),
			java.util.Map.entry("is_draw_behind_parent_enabled", 36873697L),
			java.util.Map.entry("draw_line", 1562330099L), java.util.Map.entry("draw_mesh", 153818295L),
			java.util.Map.entry("set_use_parent_material", 2586408642L),
			java.util.Map.entry("set_modulate", 2920490490L),
			java.util.Map.entry("get_clip_children_mode", 3581808349L), java.util.Map.entry("get_z_index", 3905245786L),
			java.util.Map.entry("set_visibility_layer", 1286410249L),
			java.util.Map.entry("set_instance_shader_parameter", 3776071444L),
			java.util.Map.entry("make_input_local", 811130057L), java.util.Map.entry("get_canvas_item", 2944877500L),
			java.util.Map.entry("draw_rect", 2773573813L), java.util.Map.entry("get_global_transform", 3814499831L),
			java.util.Map.entry("get_material", 5934680L), java.util.Map.entry("draw_char", 1336210142L),
			java.util.Map.entry("draw_ellipse_arc", 936174114L), java.util.Map.entry("draw_char_outline", 1846384149L),
			java.util.Map.entry("show", 3218959716L), java.util.Map.entry("set_light_mask", 1286410249L),
			java.util.Map.entry("get_canvas_transform", 3814499831L), java.util.Map.entry("draw_texture", 520200117L),
			java.util.Map.entry("set_notify_transform", 2586408642L), java.util.Map.entry("draw_ellipse", 3790774806L),
			java.util.Map.entry("draw_set_transform", 288975085L), java.util.Map.entry("draw_primitive", 3288481815L),
			java.util.Map.entry("is_visible_in_tree", 36873697L),
			java.util.Map.entry("draw_string_outline", 707403449L),
			java.util.Map.entry("get_global_mouse_position", 3341600327L),
			java.util.Map.entry("queue_redraw", 3218959716L),
			java.util.Map.entry("draw_set_transform_matrix", 2761652528L),
			java.util.Map.entry("draw_msdf_texture_rect_region", 4219163252L),
			java.util.Map.entry("is_local_transform_notification_enabled", 36873697L),
			java.util.Map.entry("is_visible", 36873697L), java.util.Map.entry("set_material", 2757459619L),
			java.util.Map.entry("is_z_relative", 36873697L), java.util.Map.entry("draw_animation_slice", 3112831842L),
			java.util.Map.entry("set_z_index", 1286410249L), java.util.Map.entry("get_canvas_layer_node", 2602762519L),
			java.util.Map.entry("set_self_modulate", 2920490490L),
			java.util.Map.entry("is_set_as_top_level", 36873697L), java.util.Map.entry("draw_arc", 4140652635L),
			java.util.Map.entry("draw_colored_polygon", 15245644L),
			java.util.Map.entry("set_y_sort_enabled", 2586408642L), java.util.Map.entry("hide", 3218959716L),
			java.util.Map.entry("get_visibility_layer_bit", 1116898809L),
			java.util.Map.entry("get_self_modulate", 3444240500L),
			java.util.Map.entry("get_instance_shader_parameter", 2760726917L),
			java.util.Map.entry("set_visibility_layer_bit", 300928843L),
			java.util.Map.entry("draw_multiline_string", 2341488182L),
			java.util.Map.entry("move_to_front", 3218959716L), java.util.Map.entry("draw_style_box", 388176283L),
			java.util.Map.entry("set_clip_children_mode", 1319393776L),
			java.util.Map.entry("set_texture_repeat", 1716472974L),
			java.util.Map.entry("set_draw_behind_parent", 2586408642L),
			java.util.Map.entry("get_modulate", 3444240500L));

	CanvasItem(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CanvasItem(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_visible() {
		return (boolean) super.call("is_visible");
	}

	public boolean is_visible_in_tree() {
		return (boolean) super.call("is_visible_in_tree");
	}

	public void show() {
		super.call("show");
	}

	public void hide() {
		super.call("hide");
	}

	public void queue_redraw() {
		super.call("queue_redraw");
	}

	public void move_to_front() {
		super.call("move_to_front");
	}

	public boolean is_set_as_top_level() {
		return (boolean) super.call("is_set_as_top_level");
	}

	public boolean is_z_relative() {
		return (boolean) super.call("is_z_relative");
	}

	public boolean is_y_sort_enabled() {
		return (boolean) super.call("is_y_sort_enabled");
	}

	public boolean is_draw_behind_parent_enabled() {
		return (boolean) super.call("is_draw_behind_parent_enabled");
	}

	public void draw_line(Vector2 from, Vector2 to, Color color, double width, boolean antialiased) {
		super.call("draw_line", new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to,
				(java.lang.Object) color, java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_dashed_line(Vector2 from, Vector2 to, Color color, double width, double dash, boolean aligned,
			boolean antialiased) {
		super.call("draw_dashed_line",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to, (java.lang.Object) color,
						java.lang.Double.valueOf(width), java.lang.Double.valueOf(dash),
						java.lang.Boolean.valueOf(aligned), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_polyline(double[][] points, Color color, double width, boolean antialiased) {
		super.call("draw_polyline", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) color,
				java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_polyline_colors(double[][] points, double[][] colors, double width, boolean antialiased) {
		super.call("draw_polyline_colors", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) colors,
				java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_ellipse_arc(Vector2 center, double major, double minor, double start_angle, double end_angle,
			long point_count, Color color, double width, boolean antialiased) {
		super.call("draw_ellipse_arc", new java.lang.Object[]{(java.lang.Object) center,
				java.lang.Double.valueOf(major), java.lang.Double.valueOf(minor), java.lang.Double.valueOf(start_angle),
				java.lang.Double.valueOf(end_angle), java.lang.Long.valueOf(point_count), (java.lang.Object) color,
				java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_arc(Vector2 center, double radius, double start_angle, double end_angle, long point_count,
			Color color, double width, boolean antialiased) {
		super.call("draw_arc",
				new java.lang.Object[]{(java.lang.Object) center, java.lang.Double.valueOf(radius),
						java.lang.Double.valueOf(start_angle), java.lang.Double.valueOf(end_angle),
						java.lang.Long.valueOf(point_count), (java.lang.Object) color, java.lang.Double.valueOf(width),
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_multiline(double[][] points, Color color, double width, boolean antialiased) {
		super.call("draw_multiline", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) color,
				java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_multiline_colors(double[][] points, double[][] colors, double width, boolean antialiased) {
		super.call("draw_multiline_colors", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) colors,
				java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_rect(Rect2 rect, Color color, boolean filled, double width, boolean antialiased) {
		super.call("draw_rect",
				new java.lang.Object[]{(java.lang.Object) rect, (java.lang.Object) color,
						java.lang.Boolean.valueOf(filled), java.lang.Double.valueOf(width),
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_circle(Vector2 position, double radius, Color color, boolean filled, double width,
			boolean antialiased) {
		super.call("draw_circle",
				new java.lang.Object[]{(java.lang.Object) position, java.lang.Double.valueOf(radius),
						(java.lang.Object) color, java.lang.Boolean.valueOf(filled), java.lang.Double.valueOf(width),
						java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_ellipse(Vector2 position, double major, double minor, Color color, boolean filled, double width,
			boolean antialiased) {
		super.call("draw_ellipse",
				new java.lang.Object[]{(java.lang.Object) position, java.lang.Double.valueOf(major),
						java.lang.Double.valueOf(minor), (java.lang.Object) color, java.lang.Boolean.valueOf(filled),
						java.lang.Double.valueOf(width), java.lang.Boolean.valueOf(antialiased)});
	}

	public void draw_texture(Texture2D texture, Vector2 position, Color modulate) {
		super.call("draw_texture", new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) position,
				(java.lang.Object) modulate});
	}

	public void draw_texture_rect(Texture2D texture, Rect2 rect, boolean tile, Color modulate, boolean transpose) {
		super.call("draw_texture_rect", new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) rect,
				java.lang.Boolean.valueOf(tile), (java.lang.Object) modulate, java.lang.Boolean.valueOf(transpose)});
	}

	public void draw_texture_rect_region(Texture2D texture, Rect2 rect, Rect2 src_rect, Color modulate,
			boolean transpose, boolean clip_uv) {
		super.call("draw_texture_rect_region",
				new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) rect, (java.lang.Object) src_rect,
						(java.lang.Object) modulate, java.lang.Boolean.valueOf(transpose),
						java.lang.Boolean.valueOf(clip_uv)});
	}

	public void draw_msdf_texture_rect_region(Texture2D texture, Rect2 rect, Rect2 src_rect, Color modulate,
			double outline, double pixel_range, double scale) {
		super.call("draw_msdf_texture_rect_region",
				new java.lang.Object[]{(java.lang.Object) texture, (java.lang.Object) rect, (java.lang.Object) src_rect,
						(java.lang.Object) modulate, java.lang.Double.valueOf(outline),
						java.lang.Double.valueOf(pixel_range), java.lang.Double.valueOf(scale)});
	}

	public void draw_lcd_texture_rect_region(Texture2D texture, Rect2 rect, Rect2 src_rect, Color modulate) {
		super.call("draw_lcd_texture_rect_region", new java.lang.Object[]{(java.lang.Object) texture,
				(java.lang.Object) rect, (java.lang.Object) src_rect, (java.lang.Object) modulate});
	}

	public void draw_style_box(StyleBox style_box, Rect2 rect) {
		super.call("draw_style_box", new java.lang.Object[]{(java.lang.Object) style_box, (java.lang.Object) rect});
	}

	public void draw_primitive(double[][] points, double[][] colors, double[][] uvs, Texture2D texture) {
		super.call("draw_primitive", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) colors,
				(java.lang.Object) uvs, (java.lang.Object) texture});
	}

	public void draw_polygon(double[][] points, double[][] colors, double[][] uvs, Texture2D texture) {
		super.call("draw_polygon", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) colors,
				(java.lang.Object) uvs, (java.lang.Object) texture});
	}

	public void draw_colored_polygon(double[][] points, Color color, double[][] uvs, Texture2D texture) {
		super.call("draw_colored_polygon", new java.lang.Object[]{(java.lang.Object) points, (java.lang.Object) color,
				(java.lang.Object) uvs, (java.lang.Object) texture});
	}

	public void draw_string(Font font, Vector2 pos, String text, int alignment, double width, long font_size,
			Color modulate, int justification_flags, int direction, int orientation, double oversampling) {
		super.call("draw_string",
				new java.lang.Object[]{(java.lang.Object) font, (java.lang.Object) pos, (java.lang.Object) text,
						java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), (java.lang.Object) modulate,
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_multiline_string(Font font, Vector2 pos, String text, int alignment, double width, long font_size,
			long max_lines, Color modulate, int brk_flags, int justification_flags, int direction, int orientation,
			double oversampling) {
		super.call("draw_multiline_string",
				new java.lang.Object[]{(java.lang.Object) font, (java.lang.Object) pos, (java.lang.Object) text,
						java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(max_lines),
						(java.lang.Object) modulate, java.lang.Integer.valueOf(brk_flags),
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_string_outline(Font font, Vector2 pos, String text, int alignment, double width, long font_size,
			long size, Color modulate, int justification_flags, int direction, int orientation, double oversampling) {
		super.call("draw_string_outline",
				new java.lang.Object[]{(java.lang.Object) font, (java.lang.Object) pos, (java.lang.Object) text,
						java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(size), (java.lang.Object) modulate,
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_multiline_string_outline(Font font, Vector2 pos, String text, int alignment, double width,
			long font_size, long max_lines, long size, Color modulate, int brk_flags, int justification_flags,
			int direction, int orientation, double oversampling) {
		super.call("draw_multiline_string_outline",
				new java.lang.Object[]{(java.lang.Object) font, (java.lang.Object) pos, (java.lang.Object) text,
						java.lang.Integer.valueOf(alignment), java.lang.Double.valueOf(width),
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(max_lines),
						java.lang.Long.valueOf(size), (java.lang.Object) modulate, java.lang.Integer.valueOf(brk_flags),
						java.lang.Integer.valueOf(justification_flags), java.lang.Integer.valueOf(direction),
						java.lang.Integer.valueOf(orientation), java.lang.Double.valueOf(oversampling)});
	}

	public void draw_char(Font font, Vector2 pos, String char_, long font_size, Color modulate, double oversampling) {
		super.call("draw_char",
				new java.lang.Object[]{(java.lang.Object) font, (java.lang.Object) pos, (java.lang.Object) char_,
						java.lang.Long.valueOf(font_size), (java.lang.Object) modulate,
						java.lang.Double.valueOf(oversampling)});
	}

	public void draw_char_outline(Font font, Vector2 pos, String char_, long font_size, long size, Color modulate,
			double oversampling) {
		super.call("draw_char_outline",
				new java.lang.Object[]{(java.lang.Object) font, (java.lang.Object) pos, (java.lang.Object) char_,
						java.lang.Long.valueOf(font_size), java.lang.Long.valueOf(size), (java.lang.Object) modulate,
						java.lang.Double.valueOf(oversampling)});
	}

	public void draw_mesh(Mesh mesh, Texture2D texture, Transform2D transform, Color modulate) {
		super.call("draw_mesh", new java.lang.Object[]{(java.lang.Object) mesh, (java.lang.Object) texture,
				(java.lang.Object) transform, (java.lang.Object) modulate});
	}

	public void draw_multimesh(MultiMesh multimesh, Texture2D texture) {
		super.call("draw_multimesh", new java.lang.Object[]{(java.lang.Object) multimesh, (java.lang.Object) texture});
	}

	public void draw_set_transform(Vector2 position, double rotation, Vector2 scale) {
		super.call("draw_set_transform", new java.lang.Object[]{(java.lang.Object) position,
				java.lang.Double.valueOf(rotation), (java.lang.Object) scale});
	}

	public void draw_set_transform_matrix(Transform2D xform) {
		super.call("draw_set_transform_matrix", new java.lang.Object[]{(java.lang.Object) xform});
	}

	public void draw_animation_slice(double animation_length, double slice_begin, double slice_end, double offset) {
		super.call("draw_animation_slice",
				new java.lang.Object[]{java.lang.Double.valueOf(animation_length),
						java.lang.Double.valueOf(slice_begin), java.lang.Double.valueOf(slice_end),
						java.lang.Double.valueOf(offset)});
	}

	public void draw_end_animation() {
		super.call("draw_end_animation");
	}

	public void set_instance_shader_parameter(String name, Object value) {
		super.call("set_instance_shader_parameter",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public Object get_instance_shader_parameter(String name) {
		return (Object) super.call("get_instance_shader_parameter", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_local_transform_notification_enabled() {
		return (boolean) super.call("is_local_transform_notification_enabled");
	}

	public boolean is_transform_notification_enabled() {
		return (boolean) super.call("is_transform_notification_enabled");
	}

	public void force_update_transform() {
		super.call("force_update_transform");
	}

	public Vector2 make_canvas_position_local(Vector2 viewport_point) {
		return (Vector2) super.call("make_canvas_position_local",
				new java.lang.Object[]{(java.lang.Object) viewport_point});
	}

	public InputEvent make_input_local(InputEvent event) {
		return (InputEvent) super.call("make_input_local", new java.lang.Object[]{(java.lang.Object) event});
	}

	public void set_visibility_layer_bit(long layer, boolean enabled) {
		super.call("set_visibility_layer_bit",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean get_visibility_layer_bit(long layer) {
		return (boolean) super.call("get_visibility_layer_bit", new java.lang.Object[]{java.lang.Long.valueOf(layer)});
	}

	public boolean isVisible() {
		return (boolean) super.call("is_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getModulate() {
		return (Color) super.call("get_modulate", new java.lang.Object[0]);
	}

	public void setModulate(Color value) {
		super.call("set_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getSelf_modulate() {
		return (Color) super.call("get_self_modulate", new java.lang.Object[0]);
	}

	public void setSelf_modulate(Color value) {
		super.call("set_self_modulate", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isShow_behind_parent() {
		return (boolean) super.call("is_draw_behind_parent_enabled", new java.lang.Object[0]);
	}

	public void setShow_behind_parent(boolean value) {
		super.call("set_draw_behind_parent", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isTop_level() {
		return (boolean) super.call("is_set_as_top_level", new java.lang.Object[0]);
	}

	public void setTop_level(boolean value) {
		super.call("set_as_top_level", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getClip_children() {
		return (long) super.call("get_clip_children_mode", new java.lang.Object[0]);
	}

	public void setClip_children(long value) {
		super.call("set_clip_children_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLight_mask() {
		return (long) super.call("get_light_mask", new java.lang.Object[0]);
	}

	public void setLight_mask(long value) {
		super.call("set_light_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVisibility_layer() {
		return (long) super.call("get_visibility_layer", new java.lang.Object[0]);
	}

	public void setVisibility_layer(long value) {
		super.call("set_visibility_layer", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getZ_index() {
		return (long) super.call("get_z_index", new java.lang.Object[0]);
	}

	public void setZ_index(long value) {
		super.call("set_z_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isZ_as_relative() {
		return (boolean) super.call("is_z_relative", new java.lang.Object[0]);
	}

	public void setZ_as_relative(boolean value) {
		super.call("set_z_as_relative", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isY_sort_enabled() {
		return (boolean) super.call("is_y_sort_enabled", new java.lang.Object[0]);
	}

	public void setY_sort_enabled(boolean value) {
		super.call("set_y_sort_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTexture_filter() {
		return (long) super.call("get_texture_filter", new java.lang.Object[0]);
	}

	public void setTexture_filter(long value) {
		super.call("set_texture_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_repeat() {
		return (long) super.call("get_texture_repeat", new java.lang.Object[0]);
	}

	public void setTexture_repeat(long value) {
		super.call("set_texture_repeat", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Object getMaterial() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setMaterial(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUse_parent_material() {
		return (boolean) super.call("get_use_parent_material", new java.lang.Object[0]);
	}

	public void setUse_parent_material(boolean value) {
		super.call("set_use_parent_material", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
