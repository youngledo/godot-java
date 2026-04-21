package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class StyleBox extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_content_margin_all", 373806689L), java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("get_minimum_size", 3341600327L),
			java.util.Map.entry("get_content_margin", 2869120046L),
			java.util.Map.entry("set_content_margin", 4290182280L), java.util.Map.entry("get_margin", 2869120046L),
			java.util.Map.entry("get_current_item_drawn", 3213695180L), java.util.Map.entry("draw", 2275962004L),
			java.util.Map.entry("test_mask", 3735564539L));

	StyleBox(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StyleBox(long nativePointer) {
		super(nativePointer);
	}

	public void set_content_margin(int margin, double offset) {
		super.call("set_content_margin",
				new java.lang.Object[]{java.lang.Integer.valueOf(margin), java.lang.Double.valueOf(offset)});
	}

	public double get_content_margin(int margin) {
		return (double) super.call("get_content_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public double get_margin(int margin) {
		return (double) super.call("get_margin", new java.lang.Object[]{java.lang.Integer.valueOf(margin)});
	}

	public void draw(long canvas_item, Rect2 rect) {
		super.call("draw", new java.lang.Object[]{java.lang.Long.valueOf(canvas_item), (java.lang.Object) rect});
	}

	public boolean test_mask(Vector2 point, Rect2 rect) {
		return (boolean) super.call("test_mask",
				new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) rect});
	}

	public double getContent_margin_left() {
		return (double) super.call("get_content_margin", new java.lang.Object[0]);
	}

	public void setContent_margin_left(double value) {
		super.call("set_content_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getContent_margin_top() {
		return (double) super.call("get_content_margin", new java.lang.Object[0]);
	}

	public void setContent_margin_top(double value) {
		super.call("set_content_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getContent_margin_right() {
		return (double) super.call("get_content_margin", new java.lang.Object[0]);
	}

	public void setContent_margin_right(double value) {
		super.call("set_content_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getContent_margin_bottom() {
		return (double) super.call("get_content_margin", new java.lang.Object[0]);
	}

	public void setContent_margin_bottom(double value) {
		super.call("set_content_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
