package org.godot.singleton;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;

/**
 * Typed wrapper for Godot's Input singleton.
 *
 * <pre>
 * Input input = Input.getInstance();
 * if (input.is_action_pressed("move_right")) { ... }
 * </pre>
 */
public class Input extends Godot {

	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_anything_pressed", 1740695150L), java.util.Map.entry("is_key_pressed", 2619796661L),
			java.util.Map.entry("is_mouse_button_pressed", 2619796661L),
			java.util.Map.entry("is_action_pressed", 4275516303L),
			java.util.Map.entry("is_action_just_pressed", 4275516303L),
			java.util.Map.entry("is_action_just_released", 4275516303L),
			java.util.Map.entry("get_action_strength", 4275516303L),
			java.util.Map.entry("get_action_raw_strength", 4275516303L), java.util.Map.entry("get_vector", 2988792421L),
			java.util.Map.entry("get_axis", 3287961647L), java.util.Map.entry("get_gravity", 3102165223L),
			java.util.Map.entry("get_accelerometer", 3102165223L), java.util.Map.entry("get_gyroscope", 3102165223L),
			java.util.Map.entry("set_mouse_mode", 2586408642L), java.util.Map.entry("get_mouse_mode", 1740695150L),
			java.util.Map.entry("set_default_cursor_shape", 1286410249L),
			java.util.Map.entry("get_mouse_position", 3102165223L), java.util.Map.entry("warp_mouse", 1286410249L),
			java.util.Map.entry("parse_input_event", 1850254898L),
			java.util.Map.entry("flush_buffered_events", 3102165223L),
			java.util.Map.entry("set_use_accumulated_input", 2586408642L),
			java.util.Map.entry("is_using_accumulated_input", 1740695150L),
			java.util.Map.entry("set_emulate_mouse_from_touch", 2586408642L),
			java.util.Map.entry("is_emulating_mouse_from_touch", 1740695150L),
			java.util.Map.entry("set_emulate_touch_from_mouse", 2586408642L),
			java.util.Map.entry("is_emulating_touch_from_mouse", 1740695150L),
			java.util.Map.entry("vibrate_handheld", 1850254898L),
			java.util.Map.entry("get_connected_joypads", 3102165223L), java.util.Map.entry("get_joy_axis", 3287961647L),
			java.util.Map.entry("get_joy_name", 201670096L), java.util.Map.entry("is_joy_known", 2619796661L),
			java.util.Map.entry("joy_connection_changed", 1850254898L),
			java.util.Map.entry("get_last_mouse_velocity", 3102165223L),
			java.util.Map.entry("get_last_mouse_screen_velocity", 3102165223L),
			java.util.Map.entry("get_last_mouse_button_mask", 2455072627L));

	/** Cached singleton instance. */
	private static volatile Input instance;

	public Input(MemorySegment nativePointer) {
		super(nativePointer);
	}

	public Input(long nativePointer) {
		super(nativePointer);
	}

	/**
	 * Get the Input singleton instance. The first call resolves the native pointer
	 * via {@code global_get_singleton}; subsequent calls return the cached wrapper.
	 */
	public static Input getInstance() {
		if (instance == null) {
			synchronized (Input.class) {
				if (instance == null) {
					GodotStringName name = GodotStringName.fromJavaString("Input");
					MemorySegment ptr = Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());
					if (ptr.address() == 0) {
						throw new RuntimeException("Failed to get Input singleton");
					}
					instance = new Input(ptr);
				}
			}
		}
		return instance;
	}

	// ----------------------------------------------------------------
	// Input queries
	// ----------------------------------------------------------------

	public boolean is_anything_pressed() {
		return (boolean) call("is_anything_pressed");
	}

	public boolean is_key_pressed(long keycode) {
		return (boolean) call("is_key_pressed", keycode);
	}

	public boolean is_mouse_button_pressed(int button) {
		return (boolean) call("is_mouse_button_pressed", button);
	}

	public boolean is_action_pressed(String action) {
		return (boolean) call("is_action_pressed", action, false);
	}

	public boolean is_action_pressed(String action, boolean exact_match) {
		return (boolean) call("is_action_pressed", action, exact_match);
	}

	public boolean is_action_just_pressed(String action) {
		return (boolean) call("is_action_just_pressed", action, false);
	}

	public boolean is_action_just_pressed(String action, boolean exact_match) {
		return (boolean) call("is_action_just_pressed", action, exact_match);
	}

	public boolean is_action_just_released(String action) {
		return (boolean) call("is_action_just_released", action, false);
	}

	public boolean is_action_just_released(String action, boolean exact_match) {
		return (boolean) call("is_action_just_released", action, exact_match);
	}

	public float get_action_strength(String action) {
		return (float) call("get_action_strength", action, false);
	}

	public float get_action_strength(String action, boolean exact_match) {
		return (float) call("get_action_strength", action, exact_match);
	}

	public float get_action_raw_strength(String action) {
		return (float) call("get_action_raw_strength", action, false);
	}

	public float get_action_raw_strength(String action, boolean exact_match) {
		return (float) call("get_action_raw_strength", action, exact_match);
	}

	// ----------------------------------------------------------------
	// Vector/Axis input
	// ----------------------------------------------------------------

	public Object get_vector(String negative_x, String positive_x, String negative_y, String positive_y) {
		return call("get_vector", negative_x, positive_x, negative_y, positive_y, 0.5);
	}

	public Object get_vector(String negative_x, String positive_x, String negative_y, String positive_y,
			double deadzone) {
		return call("get_vector", negative_x, positive_x, negative_y, positive_y, deadzone);
	}

	public Object get_axis(String negative, String positive) {
		return call("get_axis", negative, positive, 0.5);
	}

	public Object get_axis(String negative, String positive, double deadzone) {
		return call("get_axis", negative, positive, deadzone);
	}

	// ----------------------------------------------------------------
	// Mouse
	// ----------------------------------------------------------------

	public void set_mouse_mode(int mode) {
		call("set_mouse_mode", mode);
	}

	public int get_mouse_mode() {
		return (int) call("get_mouse_mode");
	}

	public void set_default_cursor_shape(int shape) {
		call("set_default_cursor_shape", shape);
	}

	public Object get_mouse_position() {
		return call("get_mouse_position");
	}

	public void warp_mouse(Object position) {
		call("warp_mouse", position);
	}

	public Object get_last_mouse_velocity() {
		return call("get_last_mouse_velocity");
	}

	public Object get_last_mouse_screen_velocity() {
		return call("get_last_mouse_screen_velocity");
	}

	public int get_last_mouse_button_mask() {
		return (int) call("get_last_mouse_button_mask");
	}

	// ----------------------------------------------------------------
	// Input event
	// ----------------------------------------------------------------

	public void parse_input_event(Object event) {
		call("parse_input_event", event);
	}

	public void flush_buffered_events() {
		call("flush_buffered_events");
	}

	// ----------------------------------------------------------------
	// Sensor / Joypad
	// ----------------------------------------------------------------

	public Object get_gravity() {
		return call("get_gravity");
	}

	public Object get_accelerometer() {
		return call("get_accelerometer");
	}

	public Object get_gyroscope() {
		return call("get_gyroscope");
	}

	public void vibrate_handheld(int duration_ms, float amplitude) {
		call("vibrate_handheld", duration_ms, amplitude);
	}

	public Object get_connected_joypads() {
		return call("get_connected_joypads");
	}

	public float get_joy_axis(int device, int axis) {
		return (float) call("get_joy_axis", device, axis);
	}

	public String get_joy_name(int device) {
		return (String) call("get_joy_name", device);
	}

	public boolean is_joy_known(int device) {
		return (boolean) call("is_joy_known", device);
	}

	// ----------------------------------------------------------------
	// Accumulated input settings
	// ----------------------------------------------------------------

	public void set_use_accumulated_input(boolean enable) {
		call("set_use_accumulated_input", enable);
	}

	public boolean is_using_accumulated_input() {
		return (boolean) call("is_using_accumulated_input");
	}

	public void set_emulate_mouse_from_touch(boolean enable) {
		call("set_emulate_mouse_from_touch", enable);
	}

	public boolean is_emulating_mouse_from_touch() {
		return (boolean) call("is_emulating_mouse_from_touch");
	}

	public void set_emulate_touch_from_mouse(boolean enable) {
		call("set_emulate_touch_from_mouse", enable);
	}

	public boolean is_emulating_touch_from_mouse() {
		return (boolean) call("is_emulating_touch_from_mouse");
	}
}
