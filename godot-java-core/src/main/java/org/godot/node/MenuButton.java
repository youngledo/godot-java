package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MenuButton extends Button {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_switch_on_hover", 2240911060L),
			java.util.Map.entry("set_disable_shortcuts", 2586408642L),
			java.util.Map.entry("get_item_count", 3905245786L), java.util.Map.entry("set_item_count", 1286410249L),
			java.util.Map.entry("set_switch_on_hover", 2586408642L), java.util.Map.entry("show_popup", 3218959716L),
			java.util.Map.entry("get_popup", 229722558L));

	MenuButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MenuButton(long nativePointer) {
		super(nativePointer);
	}

	public void show_popup() {
		super.call("show_popup");
	}

	public boolean is_switch_on_hover() {
		return (boolean) super.call("is_switch_on_hover");
	}

	public boolean isSwitch_on_hover() {
		return (boolean) super.call("is_switch_on_hover", new java.lang.Object[0]);
	}

	public void setSwitch_on_hover(boolean value) {
		super.call("set_switch_on_hover", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getItem_count() {
		return (long) super.call("get_item_count", new java.lang.Object[0]);
	}

	public void setItem_count(long value) {
		super.call("set_item_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
