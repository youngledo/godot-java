package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class InputEventWithModifiers extends InputEventFromWindow {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_modifiers_mask", 1258259499L),
			java.util.Map.entry("set_command_or_control_autoremap", 2586408642L),
			java.util.Map.entry("is_shift_pressed", 36873697L),
			java.util.Map.entry("is_command_or_control_pressed", 36873697L),
			java.util.Map.entry("set_meta_pressed", 2586408642L), java.util.Map.entry("set_alt_pressed", 2586408642L),
			java.util.Map.entry("is_meta_pressed", 36873697L), java.util.Map.entry("is_alt_pressed", 36873697L),
			java.util.Map.entry("is_command_or_control_autoremap", 36873697L),
			java.util.Map.entry("is_ctrl_pressed", 36873697L), java.util.Map.entry("set_shift_pressed", 2586408642L),
			java.util.Map.entry("set_ctrl_pressed", 2586408642L));

	InputEventWithModifiers(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEventWithModifiers(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_command_or_control_autoremap() {
		return (boolean) super.call("is_command_or_control_autoremap");
	}

	public boolean is_command_or_control_pressed() {
		return (boolean) super.call("is_command_or_control_pressed");
	}

	public boolean is_alt_pressed() {
		return (boolean) super.call("is_alt_pressed");
	}

	public boolean is_shift_pressed() {
		return (boolean) super.call("is_shift_pressed");
	}

	public boolean is_ctrl_pressed() {
		return (boolean) super.call("is_ctrl_pressed");
	}

	public boolean is_meta_pressed() {
		return (boolean) super.call("is_meta_pressed");
	}

	public boolean isCommand_or_control_autoremap() {
		return (boolean) super.call("is_command_or_control_autoremap", new java.lang.Object[0]);
	}

	public void setCommand_or_control_autoremap(boolean value) {
		super.call("set_command_or_control_autoremap", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAlt_pressed() {
		return (boolean) super.call("is_alt_pressed", new java.lang.Object[0]);
	}

	public void setAlt_pressed(boolean value) {
		super.call("set_alt_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShift_pressed() {
		return (boolean) super.call("is_shift_pressed", new java.lang.Object[0]);
	}

	public void setShift_pressed(boolean value) {
		super.call("set_shift_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCtrl_pressed() {
		return (boolean) super.call("is_ctrl_pressed", new java.lang.Object[0]);
	}

	public void setCtrl_pressed(boolean value) {
		super.call("set_ctrl_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isMeta_pressed() {
		return (boolean) super.call("is_meta_pressed", new java.lang.Object[0]);
	}

	public void setMeta_pressed(boolean value) {
		super.call("set_meta_pressed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
