package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class GraphNode extends GraphElement {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_slot_custom_icon_right", 666127730L),
			java.util.Map.entry("set_slot_enabled_left", 300928843L),
			java.util.Map.entry("get_slot_color_left", 3457211756L),
			java.util.Map.entry("get_input_port_position", 3114997196L),
			java.util.Map.entry("get_input_port_color", 2624840992L),
			java.util.Map.entry("is_slot_enabled_right", 1116898809L),
			java.util.Map.entry("get_slot_type_left", 923996154L),
			java.util.Map.entry("is_ignoring_valid_connection_type", 36873697L),
			java.util.Map.entry("get_output_port_count", 2455072627L), java.util.Map.entry("get_title", 201670096L),
			java.util.Map.entry("get_slot_metadata_right", 4227898402L),
			java.util.Map.entry("get_output_port_color", 2624840992L),
			java.util.Map.entry("clear_all_slots", 3218959716L),
			java.util.Map.entry("get_slots_focus_mode", 2132829277L),
			java.util.Map.entry("get_slot_metadata_left", 4227898402L),
			java.util.Map.entry("set_slot_type_right", 3937882851L),
			java.util.Map.entry("set_slot_custom_icon_left", 666127730L),
			java.util.Map.entry("set_slot_metadata_left", 2152698145L),
			java.util.Map.entry("get_slot_custom_icon_right", 3536238170L),
			java.util.Map.entry("get_slot_type_right", 923996154L), java.util.Map.entry("clear_slot", 1286410249L),
			java.util.Map.entry("get_output_port_type", 3744713108L),
			java.util.Map.entry("get_slot_color_right", 3457211756L),
			java.util.Map.entry("get_titlebar_hbox", 3590609951L), java.util.Map.entry("set_slot", 2873310869L),
			java.util.Map.entry("get_output_port_slot", 3744713108L),
			java.util.Map.entry("set_slot_draw_stylebox", 300928843L),
			java.util.Map.entry("get_input_port_count", 2455072627L),
			java.util.Map.entry("get_output_port_position", 3114997196L), java.util.Map.entry("set_title", 83702148L),
			java.util.Map.entry("get_slot_custom_icon_left", 3536238170L),
			java.util.Map.entry("set_ignore_invalid_connection_type", 2586408642L),
			java.util.Map.entry("is_slot_draw_stylebox", 1116898809L),
			java.util.Map.entry("set_slot_enabled_right", 300928843L),
			java.util.Map.entry("set_slots_focus_mode", 3232914922L),
			java.util.Map.entry("set_slot_metadata_right", 2152698145L),
			java.util.Map.entry("get_input_port_type", 3744713108L),
			java.util.Map.entry("set_slot_color_left", 2878471219L),
			java.util.Map.entry("set_slot_type_left", 3937882851L),
			java.util.Map.entry("get_input_port_slot", 3744713108L),
			java.util.Map.entry("set_slot_color_right", 2878471219L),
			java.util.Map.entry("is_slot_enabled_left", 1116898809L));

	GraphNode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GraphNode(long nativePointer) {
		super(nativePointer);
	}

	public void set_slot(long slot_index, boolean enable_left_port, long type_left, Color color_left,
			boolean enable_right_port, long type_right, Color color_right, Texture2D custom_icon_left,
			Texture2D custom_icon_right, boolean draw_stylebox) {
		super.call("set_slot",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), java.lang.Boolean.valueOf(enable_left_port),
						java.lang.Long.valueOf(type_left), (java.lang.Object) color_left,
						java.lang.Boolean.valueOf(enable_right_port), java.lang.Long.valueOf(type_right),
						(java.lang.Object) color_right, (java.lang.Object) custom_icon_left,
						(java.lang.Object) custom_icon_right, java.lang.Boolean.valueOf(draw_stylebox)});
	}

	public void clear_slot(long slot_index) {
		super.call("clear_slot", new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void clear_all_slots() {
		super.call("clear_all_slots");
	}

	public boolean is_slot_enabled_left(long slot_index) {
		return (boolean) super.call("is_slot_enabled_left", new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_enabled_left(long slot_index, boolean enable) {
		super.call("set_slot_enabled_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), java.lang.Boolean.valueOf(enable)});
	}

	public void set_slot_type_left(long slot_index, long type) {
		super.call("set_slot_type_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), java.lang.Long.valueOf(type)});
	}

	public int get_slot_type_left(long slot_index) {
		return (int) super.call("get_slot_type_left", new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_color_left(long slot_index, Color color) {
		super.call("set_slot_color_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), (java.lang.Object) color});
	}

	public Color get_slot_color_left(long slot_index) {
		return (Color) super.call("get_slot_color_left", new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_custom_icon_left(long slot_index, Texture2D custom_icon) {
		super.call("set_slot_custom_icon_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), (java.lang.Object) custom_icon});
	}

	public Texture2D get_slot_custom_icon_left(long slot_index) {
		return (Texture2D) super.call("get_slot_custom_icon_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_metadata_left(long slot_index, Object value) {
		super.call("set_slot_metadata_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), (java.lang.Object) value});
	}

	public Object get_slot_metadata_left(long slot_index) {
		return (Object) super.call("get_slot_metadata_left",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public boolean is_slot_enabled_right(long slot_index) {
		return (boolean) super.call("is_slot_enabled_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_enabled_right(long slot_index, boolean enable) {
		super.call("set_slot_enabled_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), java.lang.Boolean.valueOf(enable)});
	}

	public void set_slot_type_right(long slot_index, long type) {
		super.call("set_slot_type_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), java.lang.Long.valueOf(type)});
	}

	public int get_slot_type_right(long slot_index) {
		return (int) super.call("get_slot_type_right", new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_color_right(long slot_index, Color color) {
		super.call("set_slot_color_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), (java.lang.Object) color});
	}

	public Color get_slot_color_right(long slot_index) {
		return (Color) super.call("get_slot_color_right", new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_custom_icon_right(long slot_index, Texture2D custom_icon) {
		super.call("set_slot_custom_icon_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), (java.lang.Object) custom_icon});
	}

	public Texture2D get_slot_custom_icon_right(long slot_index) {
		return (Texture2D) super.call("get_slot_custom_icon_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_metadata_right(long slot_index, Object value) {
		super.call("set_slot_metadata_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), (java.lang.Object) value});
	}

	public Object get_slot_metadata_right(long slot_index) {
		return (Object) super.call("get_slot_metadata_right",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public boolean is_slot_draw_stylebox(long slot_index) {
		return (boolean) super.call("is_slot_draw_stylebox",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index)});
	}

	public void set_slot_draw_stylebox(long slot_index, boolean enable) {
		super.call("set_slot_draw_stylebox",
				new java.lang.Object[]{java.lang.Long.valueOf(slot_index), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_ignoring_valid_connection_type() {
		return (boolean) super.call("is_ignoring_valid_connection_type");
	}

	public Vector2 get_input_port_position(long port_idx) {
		return (Vector2) super.call("get_input_port_position",
				new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public int get_input_port_type(long port_idx) {
		return (int) super.call("get_input_port_type", new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public Color get_input_port_color(long port_idx) {
		return (Color) super.call("get_input_port_color", new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public int get_input_port_slot(long port_idx) {
		return (int) super.call("get_input_port_slot", new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public Vector2 get_output_port_position(long port_idx) {
		return (Vector2) super.call("get_output_port_position",
				new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public int get_output_port_type(long port_idx) {
		return (int) super.call("get_output_port_type", new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public Color get_output_port_color(long port_idx) {
		return (Color) super.call("get_output_port_color", new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public int get_output_port_slot(long port_idx) {
		return (int) super.call("get_output_port_slot", new java.lang.Object[]{java.lang.Long.valueOf(port_idx)});
	}

	public String getTitle() {
		return (String) super.call("get_title", new java.lang.Object[0]);
	}

	public void setTitle(String value) {
		super.call("set_title", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isIgnore_invalid_connection_type() {
		return (boolean) super.call("is_ignoring_valid_connection_type", new java.lang.Object[0]);
	}

	public void setIgnore_invalid_connection_type(boolean value) {
		super.call("set_ignore_invalid_connection_type", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSlots_focus_mode() {
		return (long) super.call("get_slots_focus_mode", new java.lang.Object[0]);
	}

	public void setSlots_focus_mode(long value) {
		super.call("set_slots_focus_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
