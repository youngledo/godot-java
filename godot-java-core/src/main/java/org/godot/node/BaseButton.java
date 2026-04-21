package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class BaseButton extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_shortcut_in_tooltip", 2586408642L),
			java.util.Map.entry("get_button_mask", 2512161324L), java.util.Map.entry("set_disabled", 2586408642L),
			java.util.Map.entry("is_keep_pressed_outside", 36873697L),
			java.util.Map.entry("set_button_mask", 3950145251L), java.util.Map.entry("get_button_group", 281644053L),
			java.util.Map.entry("is_disabled", 36873697L), java.util.Map.entry("set_shortcut", 857163497L),
			java.util.Map.entry("set_pressed", 2586408642L), java.util.Map.entry("is_hovered", 36873697L),
			java.util.Map.entry("is_shortcut_in_tooltip_enabled", 36873697L),
			java.util.Map.entry("set_toggle_mode", 2586408642L), java.util.Map.entry("set_action_mode", 1985162088L),
			java.util.Map.entry("set_pressed_no_signal", 2586408642L),
			java.util.Map.entry("get_action_mode", 2589712189L), java.util.Map.entry("is_shortcut_feedback", 36873697L),
			java.util.Map.entry("set_keep_pressed_outside", 2586408642L), java.util.Map.entry("is_pressed", 36873697L),
			java.util.Map.entry("get_draw_mode", 2492721305L),
			java.util.Map.entry("set_shortcut_feedback", 2586408642L), java.util.Map.entry("get_shortcut", 3415666916L),
			java.util.Map.entry("is_toggle_mode", 36873697L), java.util.Map.entry("set_button_group", 1794463739L));

	BaseButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BaseButton(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_pressed() {
		return (boolean) super.call("is_pressed");
	}

	public boolean is_hovered() {
		return (boolean) super.call("is_hovered");
	}

	public boolean is_toggle_mode() {
		return (boolean) super.call("is_toggle_mode");
	}

	public boolean is_shortcut_in_tooltip_enabled() {
		return (boolean) super.call("is_shortcut_in_tooltip_enabled");
	}

	public boolean is_disabled() {
		return (boolean) super.call("is_disabled");
	}

	public boolean is_keep_pressed_outside() {
		return (boolean) super.call("is_keep_pressed_outside");
	}

	public boolean is_shortcut_feedback() {
		return (boolean) super.call("is_shortcut_feedback");
	}

	public boolean isDisabled() {
		return (boolean) super.call("is_disabled", new java.lang.Object[0]);
	}

	public void setDisabled(boolean value) {
		super.call("set_disabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isToggle_mode() {
		return (boolean) super.call("is_toggle_mode", new java.lang.Object[0]);
	}

	public void setToggle_mode(boolean value) {
		super.call("set_toggle_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isButton_pressed() {
		return (boolean) super.call("is_pressed", new java.lang.Object[0]);
	}

	public void setButton_pressed(boolean value) {
		super.call("set_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAction_mode() {
		return (long) super.call("get_action_mode", new java.lang.Object[0]);
	}

	public void setAction_mode(long value) {
		super.call("set_action_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getButton_mask() {
		return (long) super.call("get_button_mask", new java.lang.Object[0]);
	}

	public void setButton_mask(long value) {
		super.call("set_button_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isKeep_pressed_outside() {
		return (boolean) super.call("is_keep_pressed_outside", new java.lang.Object[0]);
	}

	public void setKeep_pressed_outside(boolean value) {
		super.call("set_keep_pressed_outside", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public ButtonGroup getButton_group() {
		return (ButtonGroup) super.call("get_button_group", new java.lang.Object[0]);
	}

	public void setButton_group(ButtonGroup value) {
		super.call("set_button_group", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Shortcut getShortcut() {
		return (Shortcut) super.call("get_shortcut", new java.lang.Object[0]);
	}

	public void setShortcut(Shortcut value) {
		super.call("set_shortcut", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isShortcut_feedback() {
		return (boolean) super.call("is_shortcut_feedback", new java.lang.Object[0]);
	}

	public void setShortcut_feedback(boolean value) {
		super.call("set_shortcut_feedback", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShortcut_in_tooltip() {
		return (boolean) super.call("is_shortcut_in_tooltip_enabled", new java.lang.Object[0]);
	}

	public void setShortcut_in_tooltip(boolean value) {
		super.call("set_shortcut_in_tooltip", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
