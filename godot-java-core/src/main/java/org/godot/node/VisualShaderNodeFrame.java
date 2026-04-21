package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class VisualShaderNodeFrame extends VisualShaderNodeResizableBase {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_tint_color_enabled", 36873697L),
			java.util.Map.entry("add_attached_node", 1286410249L), java.util.Map.entry("get_tint_color", 3444240500L),
			java.util.Map.entry("is_autoshrink_enabled", 36873697L),
			java.util.Map.entry("set_tint_color_enabled", 2586408642L),
			java.util.Map.entry("set_autoshrink_enabled", 2586408642L),
			java.util.Map.entry("set_attached_nodes", 3614634198L), java.util.Map.entry("set_title", 83702148L),
			java.util.Map.entry("set_tint_color", 2920490490L), java.util.Map.entry("get_title", 201670096L),
			java.util.Map.entry("get_attached_nodes", 1930428628L),
			java.util.Map.entry("remove_attached_node", 1286410249L));

	VisualShaderNodeFrame(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeFrame(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_tint_color_enabled() {
		return (boolean) super.call("is_tint_color_enabled");
	}

	public boolean is_autoshrink_enabled() {
		return (boolean) super.call("is_autoshrink_enabled");
	}

	public void add_attached_node(long node) {
		super.call("add_attached_node", new java.lang.Object[]{java.lang.Long.valueOf(node)});
	}

	public void remove_attached_node(long node) {
		super.call("remove_attached_node", new java.lang.Object[]{java.lang.Long.valueOf(node)});
	}

	public String getTitle() {
		return (String) super.call("get_title", new java.lang.Object[0]);
	}

	public void setTitle(String value) {
		super.call("set_title", new java.lang.Object[]{(java.lang.Object) value});
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

	public boolean isAutoshrink() {
		return (boolean) super.call("is_autoshrink_enabled", new java.lang.Object[0]);
	}

	public void setAutoshrink(boolean value) {
		super.call("set_autoshrink_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public int[] getAttached_nodes() {
		return (int[]) super.call("get_attached_nodes", new java.lang.Object[0]);
	}

	public void setAttached_nodes(int[] value) {
		super.call("set_attached_nodes", new java.lang.Object[]{(java.lang.Object) value});
	}
}
