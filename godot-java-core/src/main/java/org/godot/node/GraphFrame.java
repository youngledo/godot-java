package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class GraphFrame extends GraphElement {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_tint_color_enabled", 36873697L),
			java.util.Map.entry("get_titlebar_hbox", 3590609951L), java.util.Map.entry("set_title", 83702148L),
			java.util.Map.entry("get_title", 201670096L), java.util.Map.entry("get_drag_margin", 3905245786L),
			java.util.Map.entry("is_autoshrink_enabled", 36873697L), java.util.Map.entry("get_tint_color", 3444240500L),
			java.util.Map.entry("get_autoshrink_margin", 3905245786L),
			java.util.Map.entry("set_drag_margin", 1286410249L),
			java.util.Map.entry("set_tint_color_enabled", 2586408642L),
			java.util.Map.entry("set_autoshrink_enabled", 2586408642L),
			java.util.Map.entry("set_tint_color", 2920490490L),
			java.util.Map.entry("set_autoshrink_margin", 1286410249L));

	GraphFrame(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GraphFrame(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_autoshrink_enabled() {
		return (boolean) super.call("is_autoshrink_enabled");
	}

	public boolean is_tint_color_enabled() {
		return (boolean) super.call("is_tint_color_enabled");
	}

	public String getTitle() {
		return (String) super.call("get_title", new java.lang.Object[0]);
	}

	public void setTitle(String value) {
		super.call("set_title", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isAutoshrink_enabled() {
		return (boolean) super.call("is_autoshrink_enabled", new java.lang.Object[0]);
	}

	public void setAutoshrink_enabled(boolean value) {
		super.call("set_autoshrink_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAutoshrink_margin() {
		return (long) super.call("get_autoshrink_margin", new java.lang.Object[0]);
	}

	public void setAutoshrink_margin(long value) {
		super.call("set_autoshrink_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDrag_margin() {
		return (long) super.call("get_drag_margin", new java.lang.Object[0]);
	}

	public void setDrag_margin(long value) {
		super.call("set_drag_margin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isTint_color_enabled() {
		return (boolean) super.call("is_tint_color_enabled", new java.lang.Object[0]);
	}

	public void setTint_color_enabled(boolean value) {
		super.call("set_tint_color_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getTint_color() {
		return (Color) super.call("get_tint_color", new java.lang.Object[0]);
	}

	public void setTint_color(Color value) {
		super.call("set_tint_color", new java.lang.Object[]{(java.lang.Object) value});
	}
}
