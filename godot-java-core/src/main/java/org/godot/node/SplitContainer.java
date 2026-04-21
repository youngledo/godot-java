package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SplitContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_drag_area_highlight_in_editor_enabled", 36873697L),
			java.util.Map.entry("set_vertical", 2586408642L), java.util.Map.entry("is_vertical", 36873697L),
			java.util.Map.entry("set_dragger_visibility", 1168273952L),
			java.util.Map.entry("set_drag_area_margin_begin", 1286410249L),
			java.util.Map.entry("get_drag_area_margin_begin", 3905245786L),
			java.util.Map.entry("set_drag_area_highlight_in_editor", 2586408642L),
			java.util.Map.entry("get_drag_area_margin_end", 3905245786L),
			java.util.Map.entry("get_dragger_visibility", 967297479L),
			java.util.Map.entry("clamp_split_offset", 1995695955L),
			java.util.Map.entry("get_split_offset", 3905245786L), java.util.Map.entry("set_split_offset", 1286410249L),
			java.util.Map.entry("set_collapsed", 2586408642L), java.util.Map.entry("is_dragging_enabled", 36873697L),
			java.util.Map.entry("get_split_offsets", 1930428628L), java.util.Map.entry("is_collapsed", 36873697L),
			java.util.Map.entry("set_drag_area_margin_end", 1286410249L),
			java.util.Map.entry("get_drag_area_offset", 3905245786L),
			java.util.Map.entry("is_touch_dragger_enabled", 36873697L),
			java.util.Map.entry("set_dragging_enabled", 2586408642L),
			java.util.Map.entry("get_drag_area_control", 829782337L),
			java.util.Map.entry("set_split_offsets", 3614634198L),
			java.util.Map.entry("set_drag_area_offset", 1286410249L),
			java.util.Map.entry("get_drag_area_controls", 2915620761L),
			java.util.Map.entry("set_touch_dragger_enabled", 2586408642L));

	SplitContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SplitContainer(long nativePointer) {
		super(nativePointer);
	}

	public void clamp_split_offset(long priority_index) {
		super.call("clamp_split_offset", new java.lang.Object[]{java.lang.Long.valueOf(priority_index)});
	}

	public boolean is_collapsed() {
		return (boolean) super.call("is_collapsed");
	}

	public boolean is_vertical() {
		return (boolean) super.call("is_vertical");
	}

	public boolean is_dragging_enabled() {
		return (boolean) super.call("is_dragging_enabled");
	}

	public boolean is_drag_area_highlight_in_editor_enabled() {
		return (boolean) super.call("is_drag_area_highlight_in_editor_enabled");
	}

	public boolean is_touch_dragger_enabled() {
		return (boolean) super.call("is_touch_dragger_enabled");
	}

	public int[] getSplit_offsets() {
		return (int[]) super.call("get_split_offsets", new java.lang.Object[0]);
	}

	public void setSplit_offsets(int[] value) {
		super.call("set_split_offsets", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCollapsed() {
		return (boolean) super.call("is_collapsed", new java.lang.Object[0]);
	}

	public void setCollapsed(boolean value) {
		super.call("set_collapsed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDragging_enabled() {
		return (boolean) super.call("is_dragging_enabled", new java.lang.Object[0]);
	}

	public void setDragging_enabled(boolean value) {
		super.call("set_dragging_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDragger_visibility() {
		return (long) super.call("get_dragger_visibility", new java.lang.Object[0]);
	}

	public void setDragger_visibility(long value) {
		super.call("set_dragger_visibility", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isVertical() {
		return (boolean) super.call("is_vertical", new java.lang.Object[0]);
	}

	public void setVertical(boolean value) {
		super.call("set_vertical", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isTouch_dragger_enabled() {
		return (boolean) super.call("is_touch_dragger_enabled", new java.lang.Object[0]);
	}

	public void setTouch_dragger_enabled(boolean value) {
		super.call("set_touch_dragger_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getDrag_area_margin_begin() {
		return (long) super.call("get_drag_area_margin_begin", new java.lang.Object[0]);
	}

	public void setDrag_area_margin_begin(long value) {
		super.call("set_drag_area_margin_begin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDrag_area_margin_end() {
		return (long) super.call("get_drag_area_margin_end", new java.lang.Object[0]);
	}

	public void setDrag_area_margin_end(long value) {
		super.call("set_drag_area_margin_end", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDrag_area_offset() {
		return (long) super.call("get_drag_area_offset", new java.lang.Object[0]);
	}

	public void setDrag_area_offset(long value) {
		super.call("set_drag_area_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isDrag_area_highlight_in_editor() {
		return (boolean) super.call("is_drag_area_highlight_in_editor_enabled", new java.lang.Object[0]);
	}

	public void setDrag_area_highlight_in_editor(boolean value) {
		super.call("set_drag_area_highlight_in_editor", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSplit_offset() {
		return (long) super.call("get_split_offset", new java.lang.Object[0]);
	}

	public void setSplit_offset(long value) {
		super.call("set_split_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
