package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class StatusIndicator extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_menu", 1348162250L), java.util.Map.entry("get_tooltip", 201670096L),
			java.util.Map.entry("is_visible", 36873697L), java.util.Map.entry("set_tooltip", 83702148L),
			java.util.Map.entry("get_menu", 4075236667L), java.util.Map.entry("set_icon", 4051416890L),
			java.util.Map.entry("set_visible", 2586408642L), java.util.Map.entry("get_rect", 1639390495L),
			java.util.Map.entry("get_icon", 3635182373L));

	StatusIndicator(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StatusIndicator(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_visible() {
		return (boolean) super.call("is_visible");
	}

	public String getTooltip() {
		return (String) super.call("get_tooltip", new java.lang.Object[0]);
	}

	public void setTooltip(String value) {
		super.call("set_tooltip", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getIcon() {
		return (Texture2D) super.call("get_icon", new java.lang.Object[0]);
	}

	public void setIcon(Texture2D value) {
		super.call("set_icon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getMenu() {
		return (String) super.call("get_menu", new java.lang.Object[0]);
	}

	public void setMenu(String value) {
		super.call("set_menu", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isVisible() {
		return (boolean) super.call("is_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
