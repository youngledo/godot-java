package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class GraphElement extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_selectable", 2240911060L), java.util.Map.entry("set_selectable", 2586408642L),
			java.util.Map.entry("set_selected", 2586408642L), java.util.Map.entry("is_scaling_menus", 36873697L),
			java.util.Map.entry("set_position_offset", 743155724L), java.util.Map.entry("is_selected", 2240911060L),
			java.util.Map.entry("set_scaling_menus", 2586408642L), java.util.Map.entry("set_resizable", 2586408642L),
			java.util.Map.entry("is_draggable", 2240911060L), java.util.Map.entry("get_position_offset", 3341600327L),
			java.util.Map.entry("is_resizable", 36873697L), java.util.Map.entry("set_draggable", 2586408642L));

	GraphElement(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GraphElement(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_resizable() {
		return (boolean) super.call("is_resizable");
	}

	public boolean is_draggable() {
		return (boolean) super.call("is_draggable");
	}

	public boolean is_selectable() {
		return (boolean) super.call("is_selectable");
	}

	public boolean is_selected() {
		return (boolean) super.call("is_selected");
	}

	public boolean is_scaling_menus() {
		return (boolean) super.call("is_scaling_menus");
	}

	public Vector2 getPosition_offset() {
		return (Vector2) super.call("get_position_offset", new java.lang.Object[0]);
	}

	public void setPosition_offset(Vector2 value) {
		super.call("set_position_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isResizable() {
		return (boolean) super.call("is_resizable", new java.lang.Object[0]);
	}

	public void setResizable(boolean value) {
		super.call("set_resizable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDraggable() {
		return (boolean) super.call("is_draggable", new java.lang.Object[0]);
	}

	public void setDraggable(boolean value) {
		super.call("set_draggable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSelectable() {
		return (boolean) super.call("is_selectable", new java.lang.Object[0]);
	}

	public void setSelectable(boolean value) {
		super.call("set_selectable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSelected() {
		return (boolean) super.call("is_selected", new java.lang.Object[0]);
	}

	public void setSelected(boolean value) {
		super.call("set_selected", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScaling_menus() {
		return (boolean) super.call("is_scaling_menus", new java.lang.Object[0]);
	}

	public void setScaling_menus(boolean value) {
		super.call("set_scaling_menus", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
