package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class Texture2D extends Texture {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_width", 3905245786L), java.util.Map.entry("draw_rect", 3499451691L),
			java.util.Map.entry("draw_rect_region", 2963678660L), java.util.Map.entry("create_placeholder", 121922552L),
			java.util.Map.entry("has_alpha", 36873697L), java.util.Map.entry("get_size", 3341600327L),
			java.util.Map.entry("draw", 2729649137L), java.util.Map.entry("get_image", 4190603485L),
			java.util.Map.entry("get_height", 3905245786L));

	Texture2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Texture2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_alpha() {
		return (boolean) super.call("has_alpha");
	}

	public void draw(long canvas_item, Vector2 position, Color modulate, boolean transpose) {
		super.call("draw", new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) position,
				(java.lang.Object) modulate, java.lang.Boolean.valueOf(transpose)});
	}

	public void draw_rect(long canvas_item, Rect2 rect, boolean tile, Color modulate, boolean transpose) {
		super.call("draw_rect", new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) rect,
				java.lang.Boolean.valueOf(tile), (java.lang.Object) modulate, java.lang.Boolean.valueOf(transpose)});
	}

	public void draw_rect_region(long canvas_item, Rect2 rect, Rect2 src_rect, Color modulate, boolean transpose,
			boolean clip_uv) {
		super.call("draw_rect_region",
				new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) rect,
						(java.lang.Object) src_rect, (java.lang.Object) modulate, java.lang.Boolean.valueOf(transpose),
						java.lang.Boolean.valueOf(clip_uv)});
	}

	public Resource create_placeholder() {
		return (Resource) super.call("create_placeholder");
	}
}
