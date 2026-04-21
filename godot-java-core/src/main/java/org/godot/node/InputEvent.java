package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class InputEvent extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_match", 1754951977L), java.util.Map.entry("xformed_by", 1282766827L),
			java.util.Map.entry("is_released", 36873697L), java.util.Map.entry("is_action_type", 36873697L),
			java.util.Map.entry("is_echo", 36873697L), java.util.Map.entry("get_device", 3905245786L),
			java.util.Map.entry("as_text", 201670096L), java.util.Map.entry("set_device", 1286410249L),
			java.util.Map.entry("is_action", 1558498928L), java.util.Map.entry("is_canceled", 36873697L),
			java.util.Map.entry("is_action_pressed", 1631499404L), java.util.Map.entry("is_pressed", 36873697L),
			java.util.Map.entry("accumulate", 1062211774L), java.util.Map.entry("is_action_released", 1558498928L),
			java.util.Map.entry("get_action_strength", 801543509L));

	InputEvent(MemorySegment nativePointer) {
		super(nativePointer);
	}

	InputEvent(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_action(String action, boolean exact_match) {
		return (boolean) super.call("is_action",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_pressed(String action, boolean allow_echo, boolean exact_match) {
		return (boolean) super.call("is_action_pressed", new java.lang.Object[]{(java.lang.Object) action,
				java.lang.Boolean.valueOf(allow_echo), java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_released(String action, boolean exact_match) {
		return (boolean) super.call("is_action_released",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public double get_action_strength(String action, boolean exact_match) {
		return (double) super.call("get_action_strength",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_canceled() {
		return (boolean) super.call("is_canceled");
	}

	public boolean is_pressed() {
		return (boolean) super.call("is_pressed");
	}

	public boolean is_released() {
		return (boolean) super.call("is_released");
	}

	public boolean is_echo() {
		return (boolean) super.call("is_echo");
	}

	public String as_text() {
		return (String) super.call("as_text");
	}

	public boolean is_match(InputEvent event, boolean exact_match) {
		return (boolean) super.call("is_match",
				new java.lang.Object[]{(java.lang.Object) event, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_type() {
		return (boolean) super.call("is_action_type");
	}

	public boolean accumulate(InputEvent with_event) {
		return (boolean) super.call("accumulate", new java.lang.Object[]{(java.lang.Object) with_event});
	}

	public InputEvent xformed_by(Transform2D xform, Vector2 local_ofs) {
		return (InputEvent) super.call("xformed_by",
				new java.lang.Object[]{(java.lang.Object) xform, (java.lang.Object) local_ofs});
	}

	public long getDevice() {
		return (long) super.call("get_device", new java.lang.Object[0]);
	}

	public void setDevice(long value) {
		super.call("set_device", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
