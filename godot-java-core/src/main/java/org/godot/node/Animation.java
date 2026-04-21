package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Color;
import org.godot.math.Quaternion;
import org.godot.math.Vector2;
import org.godot.math.Vector3;

public class Animation extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("bezier_track_interpolate", 1900462983L),
			java.util.Map.entry("track_move_up", 1286410249L),
			java.util.Map.entry("method_track_get_params", 2345056839L),
			java.util.Map.entry("track_is_imported", 1116898809L),
			java.util.Map.entry("track_set_imported", 300928843L), java.util.Map.entry("optimize", 3303583852L),
			java.util.Map.entry("track_remove_key_at_time", 1602489585L),
			java.util.Map.entry("has_marker", 2619796661L), java.util.Map.entry("method_track_get_name", 351665558L),
			java.util.Map.entry("add_marker", 4135858297L), java.util.Map.entry("track_get_key_time", 3085491603L),
			java.util.Map.entry("track_is_compressed", 1116898809L),
			java.util.Map.entry("scale_track_interpolate", 3530011197L),
			java.util.Map.entry("track_set_key_time", 3506521499L), java.util.Map.entry("copy_track", 148001024L),
			java.util.Map.entry("track_get_key_transition", 3085491603L),
			java.util.Map.entry("value_track_set_update_mode", 2854058312L),
			java.util.Map.entry("track_set_key_transition", 3506521499L),
			java.util.Map.entry("audio_track_insert_key", 4021027286L),
			java.util.Map.entry("track_set_interpolation_loop_wrap", 300928843L),
			java.util.Map.entry("get_loop_mode", 1988889481L), java.util.Map.entry("track_swap", 3937882851L),
			java.util.Map.entry("animation_track_insert_key", 158676774L), java.util.Map.entry("compress", 3608408117L),
			java.util.Map.entry("is_capture_included", 36873697L), java.util.Map.entry("add_track", 3843682357L),
			java.util.Map.entry("set_marker_color", 4260178595L), java.util.Map.entry("track_set_enabled", 300928843L),
			java.util.Map.entry("track_get_interpolation_type", 1530756894L),
			java.util.Map.entry("value_track_interpolate", 747269075L),
			java.util.Map.entry("bezier_track_get_key_out_handle", 3016396712L),
			java.util.Map.entry("rotation_track_insert_key", 4165004800L),
			java.util.Map.entry("track_get_key_count", 923996154L),
			java.util.Map.entry("bezier_track_set_key_value", 3506521499L),
			java.util.Map.entry("track_remove_key", 3937882851L), java.util.Map.entry("track_is_enabled", 1116898809L),
			java.util.Map.entry("get_prev_marker", 4079494655L),
			java.util.Map.entry("audio_track_set_use_blend", 300928843L),
			java.util.Map.entry("track_get_key_value", 678354945L), java.util.Map.entry("get_step", 1740695150L),
			java.util.Map.entry("track_set_interpolation_type", 4112932513L),
			java.util.Map.entry("remove_track", 1286410249L),
			java.util.Map.entry("rotation_track_interpolate", 2915876792L),
			java.util.Map.entry("remove_marker", 3304788590L),
			java.util.Map.entry("audio_track_set_key_start_offset", 3506521499L),
			java.util.Map.entry("audio_track_get_key_start_offset", 3085491603L),
			java.util.Map.entry("track_move_down", 1286410249L),
			java.util.Map.entry("track_set_key_value", 2060538656L),
			java.util.Map.entry("position_track_insert_key", 2540608232L), java.util.Map.entry("set_step", 373806689L),
			java.util.Map.entry("bezier_track_insert_key", 3656773645L),
			java.util.Map.entry("audio_track_set_key_end_offset", 3506521499L),
			java.util.Map.entry("track_set_path", 2761262315L), java.util.Map.entry("get_track_count", 3905245786L),
			java.util.Map.entry("audio_track_set_key_stream", 3886397084L),
			java.util.Map.entry("track_get_interpolation_loop_wrap", 1116898809L),
			java.util.Map.entry("bezier_track_get_key_value", 3085491603L),
			java.util.Map.entry("track_get_path", 408788394L),
			java.util.Map.entry("animation_track_get_key_animation", 351665558L),
			java.util.Map.entry("scale_track_insert_key", 2540608232L),
			java.util.Map.entry("get_marker_names", 1139954409L), java.util.Map.entry("get_marker_time", 2349060816L),
			java.util.Map.entry("audio_track_is_use_blend", 1116898809L),
			java.util.Map.entry("track_move_to", 3937882851L), java.util.Map.entry("set_length", 373806689L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("position_track_interpolate", 3530011197L),
			java.util.Map.entry("track_insert_key", 808952278L),
			java.util.Map.entry("value_track_get_update_mode", 1440326473L),
			java.util.Map.entry("audio_track_get_key_end_offset", 3085491603L),
			java.util.Map.entry("track_find_key", 4230953007L), java.util.Map.entry("set_loop_mode", 3155355575L),
			java.util.Map.entry("track_get_type", 3445944217L),
			java.util.Map.entry("bezier_track_get_key_in_handle", 3016396712L),
			java.util.Map.entry("bezier_track_set_key_out_handle", 1719223284L),
			java.util.Map.entry("get_next_marker", 4079494655L),
			java.util.Map.entry("bezier_track_set_key_in_handle", 1719223284L),
			java.util.Map.entry("audio_track_get_key_stream", 635277205L),
			java.util.Map.entry("get_marker_at_time", 4079494655L),
			java.util.Map.entry("blend_shape_track_insert_key", 1534913637L),
			java.util.Map.entry("find_track", 245376003L),
			java.util.Map.entry("animation_track_set_key_animation", 117615382L),
			java.util.Map.entry("blend_shape_track_interpolate", 2482365182L),
			java.util.Map.entry("get_marker_color", 3742943038L), java.util.Map.entry("get_length", 1740695150L));

	Animation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Animation(long nativePointer) {
		super(nativePointer);
	}

	public int add_track(int type, long at_position) {
		return (int) super.call("add_track",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(at_position)});
	}

	public void remove_track(long track_idx) {
		super.call("remove_track", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public int track_get_type(long track_idx) {
		return (int) super.call("track_get_type", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public String track_get_path(long track_idx) {
		return (String) super.call("track_get_path", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public void track_set_path(long track_idx, String path) {
		super.call("track_set_path",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), (java.lang.Object) path});
	}

	public int find_track(String path, int type) {
		return (int) super.call("find_track",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Integer.valueOf(type)});
	}

	public void track_move_up(long track_idx) {
		super.call("track_move_up", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public void track_move_down(long track_idx) {
		super.call("track_move_down", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public void track_move_to(long track_idx, long to_idx) {
		super.call("track_move_to",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(to_idx)});
	}

	public void track_swap(long track_idx, long with_idx) {
		super.call("track_swap",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(with_idx)});
	}

	public void track_set_imported(long track_idx, boolean imported) {
		super.call("track_set_imported",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Boolean.valueOf(imported)});
	}

	public boolean track_is_imported(long track_idx) {
		return (boolean) super.call("track_is_imported", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public void track_set_enabled(long track_idx, boolean enabled) {
		super.call("track_set_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean track_is_enabled(long track_idx) {
		return (boolean) super.call("track_is_enabled", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public int position_track_insert_key(long track_idx, double time, Vector3 position) {
		return (int) super.call("position_track_insert_key", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time), (java.lang.Object) position});
	}

	public int rotation_track_insert_key(long track_idx, double time, Quaternion rotation) {
		return (int) super.call("rotation_track_insert_key", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time), (java.lang.Object) rotation});
	}

	public int scale_track_insert_key(long track_idx, double time, Vector3 scale) {
		return (int) super.call("scale_track_insert_key", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time), (java.lang.Object) scale});
	}

	public int blend_shape_track_insert_key(long track_idx, double time, double amount) {
		return (int) super.call("blend_shape_track_insert_key", new java.lang.Object[]{
				java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time), java.lang.Double.valueOf(amount)});
	}

	public Vector3 position_track_interpolate(long track_idx, double time_sec, boolean backward) {
		return (Vector3) super.call("position_track_interpolate",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time_sec),
						java.lang.Boolean.valueOf(backward)});
	}

	public Quaternion rotation_track_interpolate(long track_idx, double time_sec, boolean backward) {
		return (Quaternion) super.call("rotation_track_interpolate",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time_sec),
						java.lang.Boolean.valueOf(backward)});
	}

	public Vector3 scale_track_interpolate(long track_idx, double time_sec, boolean backward) {
		return (Vector3) super.call("scale_track_interpolate", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time_sec), java.lang.Boolean.valueOf(backward)});
	}

	public double blend_shape_track_interpolate(long track_idx, double time_sec, boolean backward) {
		return (double) super.call("blend_shape_track_interpolate",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time_sec),
						java.lang.Boolean.valueOf(backward)});
	}

	public int track_insert_key(long track_idx, double time, Object key, double transition) {
		return (int) super.call("track_insert_key", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time), (java.lang.Object) key, java.lang.Double.valueOf(transition)});
	}

	public void track_remove_key(long track_idx, long key_idx) {
		super.call("track_remove_key",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public void track_remove_key_at_time(long track_idx, double time) {
		super.call("track_remove_key_at_time",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time)});
	}

	public void track_set_key_value(long track_idx, long key, Object value) {
		super.call("track_set_key_value", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key), (java.lang.Object) value});
	}

	public void track_set_key_transition(long track_idx, long key_idx, double transition) {
		super.call("track_set_key_transition", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), java.lang.Double.valueOf(transition)});
	}

	public void track_set_key_time(long track_idx, long key_idx, double time) {
		super.call("track_set_key_time", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), java.lang.Double.valueOf(time)});
	}

	public double track_get_key_transition(long track_idx, long key_idx) {
		return (double) super.call("track_get_key_transition",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public int track_get_key_count(long track_idx) {
		return (int) super.call("track_get_key_count", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public Object track_get_key_value(long track_idx, long key_idx) {
		return (Object) super.call("track_get_key_value",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public double track_get_key_time(long track_idx, long key_idx) {
		return (double) super.call("track_get_key_time",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public int track_find_key(long track_idx, double time, int find_mode, boolean limit, boolean backward) {
		return (int) super.call("track_find_key",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time),
						java.lang.Integer.valueOf(find_mode), java.lang.Boolean.valueOf(limit),
						java.lang.Boolean.valueOf(backward)});
	}

	public void track_set_interpolation_type(long track_idx, int interpolation) {
		super.call("track_set_interpolation_type",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Integer.valueOf(interpolation)});
	}

	public int track_get_interpolation_type(long track_idx) {
		return (int) super.call("track_get_interpolation_type",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public void track_set_interpolation_loop_wrap(long track_idx, boolean interpolation) {
		super.call("track_set_interpolation_loop_wrap",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Boolean.valueOf(interpolation)});
	}

	public boolean track_get_interpolation_loop_wrap(long track_idx) {
		return (boolean) super.call("track_get_interpolation_loop_wrap",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public boolean track_is_compressed(long track_idx) {
		return (boolean) super.call("track_is_compressed", new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public void value_track_set_update_mode(long track_idx, int mode) {
		super.call("value_track_set_update_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Integer.valueOf(mode)});
	}

	public int value_track_get_update_mode(long track_idx) {
		return (int) super.call("value_track_get_update_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public Object value_track_interpolate(long track_idx, double time_sec, boolean backward) {
		return (Object) super.call("value_track_interpolate", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time_sec), java.lang.Boolean.valueOf(backward)});
	}

	public String method_track_get_name(long track_idx, long key_idx) {
		return (String) super.call("method_track_get_name",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public GodotArray method_track_get_params(long track_idx, long key_idx) {
		return (GodotArray) super.call("method_track_get_params",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public int bezier_track_insert_key(long track_idx, double time, double value, Vector2 in_handle,
			Vector2 out_handle) {
		return (int) super.call("bezier_track_insert_key",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time),
						java.lang.Double.valueOf(value), (java.lang.Object) in_handle, (java.lang.Object) out_handle});
	}

	public void bezier_track_set_key_value(long track_idx, long key_idx, double value) {
		super.call("bezier_track_set_key_value", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), java.lang.Double.valueOf(value)});
	}

	public void bezier_track_set_key_in_handle(long track_idx, long key_idx, Vector2 in_handle,
			double balanced_value_time_ratio) {
		super.call("bezier_track_set_key_in_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx),
						(java.lang.Object) in_handle, java.lang.Double.valueOf(balanced_value_time_ratio)});
	}

	public void bezier_track_set_key_out_handle(long track_idx, long key_idx, Vector2 out_handle,
			double balanced_value_time_ratio) {
		super.call("bezier_track_set_key_out_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx),
						(java.lang.Object) out_handle, java.lang.Double.valueOf(balanced_value_time_ratio)});
	}

	public double bezier_track_get_key_value(long track_idx, long key_idx) {
		return (double) super.call("bezier_track_get_key_value",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public Vector2 bezier_track_get_key_in_handle(long track_idx, long key_idx) {
		return (Vector2) super.call("bezier_track_get_key_in_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public Vector2 bezier_track_get_key_out_handle(long track_idx, long key_idx) {
		return (Vector2) super.call("bezier_track_get_key_out_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public double bezier_track_interpolate(long track_idx, double time) {
		return (double) super.call("bezier_track_interpolate",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time)});
	}

	public int audio_track_insert_key(long track_idx, double time, Resource stream, double start_offset,
			double end_offset) {
		return (int) super.call("audio_track_insert_key",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Double.valueOf(time),
						(java.lang.Object) stream, java.lang.Double.valueOf(start_offset),
						java.lang.Double.valueOf(end_offset)});
	}

	public void audio_track_set_key_stream(long track_idx, long key_idx, Resource stream) {
		super.call("audio_track_set_key_stream", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), (java.lang.Object) stream});
	}

	public void audio_track_set_key_start_offset(long track_idx, long key_idx, double offset) {
		super.call("audio_track_set_key_start_offset", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), java.lang.Double.valueOf(offset)});
	}

	public void audio_track_set_key_end_offset(long track_idx, long key_idx, double offset) {
		super.call("audio_track_set_key_end_offset", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), java.lang.Double.valueOf(offset)});
	}

	public Resource audio_track_get_key_stream(long track_idx, long key_idx) {
		return (Resource) super.call("audio_track_get_key_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public double audio_track_get_key_start_offset(long track_idx, long key_idx) {
		return (double) super.call("audio_track_get_key_start_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public double audio_track_get_key_end_offset(long track_idx, long key_idx) {
		return (double) super.call("audio_track_get_key_end_offset",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public void audio_track_set_use_blend(long track_idx, boolean enable) {
		super.call("audio_track_set_use_blend",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Boolean.valueOf(enable)});
	}

	public boolean audio_track_is_use_blend(long track_idx) {
		return (boolean) super.call("audio_track_is_use_blend",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx)});
	}

	public int animation_track_insert_key(long track_idx, double time, String animation) {
		return (int) super.call("animation_track_insert_key", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Double.valueOf(time), (java.lang.Object) animation});
	}

	public void animation_track_set_key_animation(long track_idx, long key_idx, String animation) {
		super.call("animation_track_set_key_animation", new java.lang.Object[]{java.lang.Long.valueOf(track_idx),
				java.lang.Long.valueOf(key_idx), (java.lang.Object) animation});
	}

	public String animation_track_get_key_animation(long track_idx, long key_idx) {
		return (String) super.call("animation_track_get_key_animation",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), java.lang.Long.valueOf(key_idx)});
	}

	public void add_marker(String name, double time) {
		super.call("add_marker", new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(time)});
	}

	public void remove_marker(String name) {
		super.call("remove_marker", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_marker(String name) {
		return (boolean) super.call("has_marker", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_marker_at_time(double time) {
		return (String) super.call("get_marker_at_time", new java.lang.Object[]{java.lang.Double.valueOf(time)});
	}

	public String get_next_marker(double time) {
		return (String) super.call("get_next_marker", new java.lang.Object[]{java.lang.Double.valueOf(time)});
	}

	public String get_prev_marker(double time) {
		return (String) super.call("get_prev_marker", new java.lang.Object[]{java.lang.Double.valueOf(time)});
	}

	public double get_marker_time(String name) {
		return (double) super.call("get_marker_time", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Color get_marker_color(String name) {
		return (Color) super.call("get_marker_color", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void set_marker_color(String name, Color color) {
		super.call("set_marker_color", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) color});
	}

	public void clear() {
		super.call("clear");
	}

	public void copy_track(long track_idx, Animation to_animation) {
		super.call("copy_track",
				new java.lang.Object[]{java.lang.Long.valueOf(track_idx), (java.lang.Object) to_animation});
	}

	public void optimize(double allowed_velocity_err, double allowed_angular_err, long precision) {
		super.call("optimize", new java.lang.Object[]{java.lang.Double.valueOf(allowed_velocity_err),
				java.lang.Double.valueOf(allowed_angular_err), java.lang.Long.valueOf(precision)});
	}

	public void compress(long page_size, long fps, double split_tolerance) {
		super.call("compress", new java.lang.Object[]{java.lang.Long.valueOf(page_size), java.lang.Long.valueOf(fps),
				java.lang.Double.valueOf(split_tolerance)});
	}

	public boolean is_capture_included() {
		return (boolean) super.call("is_capture_included");
	}

	public double getLength() {
		return (double) super.call("get_length", new java.lang.Object[0]);
	}

	public void setLength(double value) {
		super.call("set_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getLoop_mode() {
		return (long) super.call("get_loop_mode", new java.lang.Object[0]);
	}

	public void setLoop_mode(long value) {
		super.call("set_loop_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getStep() {
		return (double) super.call("get_step", new java.lang.Object[0]);
	}

	public void setStep(double value) {
		super.call("set_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCapture_included() {
		return (boolean) super.call("is_capture_included", new java.lang.Object[0]);
	}

	public void setCapture_included(boolean value) {
		super.call("set_capture_included", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
