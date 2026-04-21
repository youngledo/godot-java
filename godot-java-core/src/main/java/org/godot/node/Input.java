package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class Input extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_emulate_mouse_from_touch", 2586408642L),
			java.util.Map.entry("is_anything_pressed", 36873697L),
			java.util.Map.entry("get_action_raw_strength", 801543509L), java.util.Map.entry("get_joy_name", 990163283L),
			java.util.Map.entry("get_joy_vibration_strength", 3114997196L),
			java.util.Map.entry("get_joy_guid", 844755477L), java.util.Map.entry("is_key_label_pressed", 1938909964L),
			java.util.Map.entry("should_ignore_device", 2522259332L), java.util.Map.entry("set_joy_light", 2878471219L),
			java.util.Map.entry("get_accelerometer", 3360562783L),
			java.util.Map.entry("get_connected_joypads", 2915620761L),
			java.util.Map.entry("set_emulate_touch_from_mouse", 2586408642L),
			java.util.Map.entry("has_joy_light", 1116898809L), java.util.Map.entry("set_magnetometer", 3460891852L),
			java.util.Map.entry("is_action_just_released_by_event", 551972873L),
			java.util.Map.entry("is_joy_known", 3067735520L), java.util.Map.entry("vibrate_handheld", 544894297L),
			java.util.Map.entry("set_accelerometer", 3460891852L),
			java.util.Map.entry("is_action_just_released", 1558498928L),
			java.util.Map.entry("get_gravity", 3360562783L), java.util.Map.entry("get_axis", 1958752504L),
			java.util.Map.entry("get_joy_axis", 4063175957L), java.util.Map.entry("stop_joy_vibration", 1286410249L),
			java.util.Map.entry("set_default_cursor_shape", 2124816902L),
			java.util.Map.entry("is_physical_key_pressed", 1938909964L),
			java.util.Map.entry("action_release", 3304788590L), java.util.Map.entry("parse_input_event", 3754044979L),
			java.util.Map.entry("is_using_accumulated_input", 2240911060L),
			java.util.Map.entry("is_action_pressed", 1558498928L),
			java.util.Map.entry("start_joy_vibration", 2576575033L),
			java.util.Map.entry("is_action_just_pressed", 1558498928L),
			java.util.Map.entry("set_use_accumulated_input", 2586408642L),
			java.util.Map.entry("get_last_mouse_screen_velocity", 1497962370L),
			java.util.Map.entry("get_current_cursor_shape", 3455658929L),
			java.util.Map.entry("is_joy_button_pressed", 787208542L),
			java.util.Map.entry("set_mouse_mode", 2228490894L), java.util.Map.entry("get_gyroscope", 3360562783L),
			java.util.Map.entry("get_last_mouse_velocity", 1497962370L),
			java.util.Map.entry("is_action_just_pressed_by_event", 551972873L),
			java.util.Map.entry("flush_buffered_events", 3218959716L), java.util.Map.entry("warp_mouse", 743155724L),
			java.util.Map.entry("is_mouse_button_pressed", 1821097125L),
			java.util.Map.entry("get_magnetometer", 3360562783L), java.util.Map.entry("get_vector", 2479607902L),
			java.util.Map.entry("get_joy_info", 3485342025L),
			java.util.Map.entry("get_joy_vibration_duration", 4025615559L),
			java.util.Map.entry("set_gyroscope", 3460891852L), java.util.Map.entry("remove_joy_mapping", 83702148L),
			java.util.Map.entry("get_mouse_mode", 965286182L), java.util.Map.entry("action_press", 1713091165L),
			java.util.Map.entry("get_mouse_button_mask", 2512161324L),
			java.util.Map.entry("set_custom_mouse_cursor", 703945977L),
			java.util.Map.entry("is_emulating_mouse_from_touch", 36873697L),
			java.util.Map.entry("is_key_pressed", 1938909964L), java.util.Map.entry("set_gravity", 3460891852L),
			java.util.Map.entry("is_emulating_touch_from_mouse", 36873697L),
			java.util.Map.entry("add_joy_mapping", 1168363258L),
			java.util.Map.entry("get_action_strength", 801543509L));

	Input(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Input(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_anything_pressed() {
		return (boolean) super.call("is_anything_pressed");
	}

	public boolean is_key_pressed(int keycode) {
		return (boolean) super.call("is_key_pressed", new java.lang.Object[]{java.lang.Integer.valueOf(keycode)});
	}

	public boolean is_physical_key_pressed(int keycode) {
		return (boolean) super.call("is_physical_key_pressed",
				new java.lang.Object[]{java.lang.Integer.valueOf(keycode)});
	}

	public boolean is_key_label_pressed(int keycode) {
		return (boolean) super.call("is_key_label_pressed", new java.lang.Object[]{java.lang.Integer.valueOf(keycode)});
	}

	public boolean is_mouse_button_pressed(int button) {
		return (boolean) super.call("is_mouse_button_pressed",
				new java.lang.Object[]{java.lang.Integer.valueOf(button)});
	}

	public boolean is_joy_button_pressed(long device, int button) {
		return (boolean) super.call("is_joy_button_pressed",
				new java.lang.Object[]{java.lang.Long.valueOf(device), java.lang.Integer.valueOf(button)});
	}

	public boolean is_action_pressed(String action, boolean exact_match) {
		return (boolean) super.call("is_action_pressed",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_just_pressed(String action, boolean exact_match) {
		return (boolean) super.call("is_action_just_pressed",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_just_released(String action, boolean exact_match) {
		return (boolean) super.call("is_action_just_released",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_just_pressed_by_event(String action, InputEvent event, boolean exact_match) {
		return (boolean) super.call("is_action_just_pressed_by_event", new java.lang.Object[]{(java.lang.Object) action,
				(java.lang.Object) event, java.lang.Boolean.valueOf(exact_match)});
	}

	public boolean is_action_just_released_by_event(String action, InputEvent event, boolean exact_match) {
		return (boolean) super.call("is_action_just_released_by_event", new java.lang.Object[]{
				(java.lang.Object) action, (java.lang.Object) event, java.lang.Boolean.valueOf(exact_match)});
	}

	public double get_action_strength(String action, boolean exact_match) {
		return (double) super.call("get_action_strength",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public double get_action_raw_strength(String action, boolean exact_match) {
		return (double) super.call("get_action_raw_strength",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(exact_match)});
	}

	public double get_axis(String negative_action, String positive_action) {
		return (double) super.call("get_axis",
				new java.lang.Object[]{(java.lang.Object) negative_action, (java.lang.Object) positive_action});
	}

	public Vector2 get_vector(String negative_x, String positive_x, String negative_y, String positive_y,
			double deadzone) {
		return (Vector2) super.call("get_vector",
				new java.lang.Object[]{(java.lang.Object) negative_x, (java.lang.Object) positive_x,
						(java.lang.Object) negative_y, (java.lang.Object) positive_y,
						java.lang.Double.valueOf(deadzone)});
	}

	public void add_joy_mapping(String mapping, boolean update_existing) {
		super.call("add_joy_mapping",
				new java.lang.Object[]{(java.lang.Object) mapping, java.lang.Boolean.valueOf(update_existing)});
	}

	public void remove_joy_mapping(String guid) {
		super.call("remove_joy_mapping", new java.lang.Object[]{(java.lang.Object) guid});
	}

	public boolean is_joy_known(long device) {
		return (boolean) super.call("is_joy_known", new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public double get_joy_axis(long device, int axis) {
		return (double) super.call("get_joy_axis",
				new java.lang.Object[]{java.lang.Long.valueOf(device), java.lang.Integer.valueOf(axis)});
	}

	public String get_joy_name(long device) {
		return (String) super.call("get_joy_name", new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public String get_joy_guid(long device) {
		return (String) super.call("get_joy_guid", new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public GodotDictionary get_joy_info(long device) {
		return (GodotDictionary) super.call("get_joy_info", new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public boolean should_ignore_device(long vendor_id, long product_id) {
		return (boolean) super.call("should_ignore_device",
				new java.lang.Object[]{java.lang.Long.valueOf(vendor_id), java.lang.Long.valueOf(product_id)});
	}

	public Vector2 get_joy_vibration_strength(long device) {
		return (Vector2) super.call("get_joy_vibration_strength",
				new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public double get_joy_vibration_duration(long device) {
		return (double) super.call("get_joy_vibration_duration",
				new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public void start_joy_vibration(long device, double weak_magnitude, double strong_magnitude, double duration) {
		super.call("start_joy_vibration",
				new java.lang.Object[]{java.lang.Long.valueOf(device), java.lang.Double.valueOf(weak_magnitude),
						java.lang.Double.valueOf(strong_magnitude), java.lang.Double.valueOf(duration)});
	}

	public void stop_joy_vibration(long device) {
		super.call("stop_joy_vibration", new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public void vibrate_handheld(long duration_ms, double amplitude) {
		super.call("vibrate_handheld",
				new java.lang.Object[]{java.lang.Long.valueOf(duration_ms), java.lang.Double.valueOf(amplitude)});
	}

	public void set_joy_light(long device, Color color) {
		super.call("set_joy_light", new java.lang.Object[]{java.lang.Long.valueOf(device), (java.lang.Object) color});
	}

	public boolean has_joy_light(long device) {
		return (boolean) super.call("has_joy_light", new java.lang.Object[]{java.lang.Long.valueOf(device)});
	}

	public void warp_mouse(Vector2 position) {
		super.call("warp_mouse", new java.lang.Object[]{(java.lang.Object) position});
	}

	public void action_press(String action, double strength) {
		super.call("action_press",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Double.valueOf(strength)});
	}

	public void action_release(String action) {
		super.call("action_release", new java.lang.Object[]{(java.lang.Object) action});
	}

	public void set_custom_mouse_cursor(Resource image, int shape, Vector2 hotspot) {
		super.call("set_custom_mouse_cursor", new java.lang.Object[]{(java.lang.Object) image,
				java.lang.Integer.valueOf(shape), (java.lang.Object) hotspot});
	}

	public void parse_input_event(InputEvent event) {
		super.call("parse_input_event", new java.lang.Object[]{(java.lang.Object) event});
	}

	public boolean is_using_accumulated_input() {
		return (boolean) super.call("is_using_accumulated_input");
	}

	public void flush_buffered_events() {
		super.call("flush_buffered_events");
	}

	public boolean is_emulating_mouse_from_touch() {
		return (boolean) super.call("is_emulating_mouse_from_touch");
	}

	public boolean is_emulating_touch_from_mouse() {
		return (boolean) super.call("is_emulating_touch_from_mouse");
	}

	public long getMouse_mode() {
		return (long) super.call("get_mouse_mode", new java.lang.Object[0]);
	}

	public void setMouse_mode(long value) {
		super.call("set_mouse_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_accumulated_input() {
		return (boolean) super.call("is_using_accumulated_input", new java.lang.Object[0]);
	}

	public void setUse_accumulated_input(boolean value) {
		super.call("set_use_accumulated_input", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEmulate_mouse_from_touch() {
		return (boolean) super.call("is_emulating_mouse_from_touch", new java.lang.Object[0]);
	}

	public void setEmulate_mouse_from_touch(boolean value) {
		super.call("set_emulate_mouse_from_touch", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEmulate_touch_from_mouse() {
		return (boolean) super.call("is_emulating_touch_from_mouse", new java.lang.Object[0]);
	}

	public void setEmulate_touch_from_mouse(boolean value) {
		super.call("set_emulate_touch_from_mouse", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
