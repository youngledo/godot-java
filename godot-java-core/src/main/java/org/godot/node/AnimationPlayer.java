package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationPlayer extends AnimationMixer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("play", 3118260607L), java.util.Map.entry("is_movie_quit_on_finish_enabled", 36873697L),
			java.util.Map.entry("set_auto_capture_transition_type", 1058637742L),
			java.util.Map.entry("get_autoplay", 2002593661L), java.util.Map.entry("play_section", 284774635L),
			java.util.Map.entry("set_section_with_markers", 794792241L),
			java.util.Map.entry("set_auto_capture", 2586408642L),
			java.util.Map.entry("play_section_with_markers", 1421431412L),
			java.util.Map.entry("set_process_callback", 1663839457L),
			java.util.Map.entry("set_movie_quit_on_finish_enabled", 2586408642L),
			java.util.Map.entry("get_default_blend_time", 1740695150L),
			java.util.Map.entry("set_auto_capture_duration", 373806689L),
			java.util.Map.entry("get_playing_speed", 1740695150L), java.util.Map.entry("is_playing", 36873697L),
			java.util.Map.entry("get_process_callback", 4207496604L),
			java.util.Map.entry("get_section_end_time", 1740695150L),
			java.util.Map.entry("play_with_capture", 1572969103L),
			java.util.Map.entry("animation_get_next", 1965194235L),
			java.util.Map.entry("set_default_blend_time", 373806689L), java.util.Map.entry("set_autoplay", 3304788590L),
			java.util.Map.entry("get_blend_time", 1958752504L),
			java.util.Map.entry("set_assigned_animation", 3304788590L),
			java.util.Map.entry("get_current_animation_position", 1740695150L),
			java.util.Map.entry("is_auto_capture", 36873697L), java.util.Map.entry("pause", 3218959716L),
			java.util.Map.entry("play_section_backwards", 831955981L),
			java.util.Map.entry("set_auto_capture_ease_type", 1208105857L), java.util.Map.entry("stop", 107499316L),
			java.util.Map.entry("get_current_animation", 2002593661L),
			java.util.Map.entry("get_current_animation_length", 1740695150L),
			java.util.Map.entry("has_section", 36873697L), java.util.Map.entry("get_speed_scale", 1740695150L),
			java.util.Map.entry("set_section", 3749779719L), java.util.Map.entry("set_root", 1348162250L),
			java.util.Map.entry("animation_set_next", 3740211285L),
			java.util.Map.entry("is_animation_active", 36873697L), java.util.Map.entry("seek", 1807872683L),
			java.util.Map.entry("play_section_with_markers_backwards", 910195100L),
			java.util.Map.entry("clear_queue", 3218959716L), java.util.Map.entry("reset_section", 3218959716L),
			java.util.Map.entry("get_queue", 2915620761L),
			java.util.Map.entry("get_auto_capture_ease_type", 631880200L),
			java.util.Map.entry("get_section_start_time", 1740695150L),
			java.util.Map.entry("set_speed_scale", 373806689L),
			java.util.Map.entry("set_current_animation", 3304788590L),
			java.util.Map.entry("get_assigned_animation", 2002593661L),
			java.util.Map.entry("get_method_call_mode", 3583380054L),
			java.util.Map.entry("get_auto_capture_transition_type", 3842314528L),
			java.util.Map.entry("play_backwards", 2787282401L),
			java.util.Map.entry("set_method_call_mode", 3413514846L),
			java.util.Map.entry("get_auto_capture_duration", 1740695150L), java.util.Map.entry("get_root", 4075236667L),
			java.util.Map.entry("set_blend_time", 3231131886L), java.util.Map.entry("queue", 3304788590L));

	AnimationPlayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationPlayer(long nativePointer) {
		super(nativePointer);
	}

	public void animation_set_next(String animation_from, String animation_to) {
		super.call("animation_set_next",
				new java.lang.Object[]{(java.lang.Object) animation_from, (java.lang.Object) animation_to});
	}

	public String animation_get_next(String animation_from) {
		return (String) super.call("animation_get_next", new java.lang.Object[]{(java.lang.Object) animation_from});
	}

	public void set_blend_time(String animation_from, String animation_to, double sec) {
		super.call("set_blend_time", new java.lang.Object[]{(java.lang.Object) animation_from,
				(java.lang.Object) animation_to, java.lang.Double.valueOf(sec)});
	}

	public double get_blend_time(String animation_from, String animation_to) {
		return (double) super.call("get_blend_time",
				new java.lang.Object[]{(java.lang.Object) animation_from, (java.lang.Object) animation_to});
	}

	public boolean is_auto_capture() {
		return (boolean) super.call("is_auto_capture");
	}

	public void play(String name, double custom_blend, double custom_speed, boolean from_end) {
		super.call("play", new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(custom_blend),
				java.lang.Double.valueOf(custom_speed), java.lang.Boolean.valueOf(from_end)});
	}

	public void play_section_with_markers(String name, String start_marker, String end_marker, double custom_blend,
			double custom_speed, boolean from_end) {
		super.call("play_section_with_markers",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) start_marker,
						(java.lang.Object) end_marker, java.lang.Double.valueOf(custom_blend),
						java.lang.Double.valueOf(custom_speed), java.lang.Boolean.valueOf(from_end)});
	}

	public void play_section(String name, double start_time, double end_time, double custom_blend, double custom_speed,
			boolean from_end) {
		super.call("play_section",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(start_time),
						java.lang.Double.valueOf(end_time), java.lang.Double.valueOf(custom_blend),
						java.lang.Double.valueOf(custom_speed), java.lang.Boolean.valueOf(from_end)});
	}

	public void play_backwards(String name, double custom_blend) {
		super.call("play_backwards",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(custom_blend)});
	}

	public void play_section_with_markers_backwards(String name, String start_marker, String end_marker,
			double custom_blend) {
		super.call("play_section_with_markers_backwards",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) start_marker,
						(java.lang.Object) end_marker, java.lang.Double.valueOf(custom_blend)});
	}

	public void play_section_backwards(String name, double start_time, double end_time, double custom_blend) {
		super.call("play_section_backwards",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(start_time),
						java.lang.Double.valueOf(end_time), java.lang.Double.valueOf(custom_blend)});
	}

	public void play_with_capture(String name, double duration, double custom_blend, double custom_speed,
			boolean from_end, int trans_type, int ease_type) {
		super.call("play_with_capture",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(duration),
						java.lang.Double.valueOf(custom_blend), java.lang.Double.valueOf(custom_speed),
						java.lang.Boolean.valueOf(from_end), java.lang.Integer.valueOf(trans_type),
						java.lang.Integer.valueOf(ease_type)});
	}

	public void pause() {
		super.call("pause");
	}

	public void stop(boolean keep_state) {
		super.call("stop", new java.lang.Object[]{java.lang.Boolean.valueOf(keep_state)});
	}

	public boolean is_playing() {
		return (boolean) super.call("is_playing");
	}

	public boolean is_animation_active() {
		return (boolean) super.call("is_animation_active");
	}

	public void queue(String name) {
		super.call("queue", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void clear_queue() {
		super.call("clear_queue");
	}

	public boolean is_movie_quit_on_finish_enabled() {
		return (boolean) super.call("is_movie_quit_on_finish_enabled");
	}

	public void set_section_with_markers(String start_marker, String end_marker) {
		super.call("set_section_with_markers",
				new java.lang.Object[]{(java.lang.Object) start_marker, (java.lang.Object) end_marker});
	}

	public void set_section(double start_time, double end_time) {
		super.call("set_section",
				new java.lang.Object[]{java.lang.Double.valueOf(start_time), java.lang.Double.valueOf(end_time)});
	}

	public void reset_section() {
		super.call("reset_section");
	}

	public boolean has_section() {
		return (boolean) super.call("has_section");
	}

	public void seek(double seconds, boolean update, boolean update_only) {
		super.call("seek", new java.lang.Object[]{java.lang.Double.valueOf(seconds), java.lang.Boolean.valueOf(update),
				java.lang.Boolean.valueOf(update_only)});
	}

	public String getCurrent_animation() {
		return (String) super.call("get_current_animation", new java.lang.Object[0]);
	}

	public void setCurrent_animation(String value) {
		super.call("set_current_animation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAssigned_animation() {
		return (String) super.call("get_assigned_animation", new java.lang.Object[0]);
	}

	public void setAssigned_animation(String value) {
		super.call("set_assigned_animation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAutoplay() {
		return (String) super.call("get_autoplay", new java.lang.Object[0]);
	}

	public void setAutoplay(String value) {
		super.call("set_autoplay", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getCurrent_animation_length() {
		return (double) super.call("get_current_animation_length", new java.lang.Object[0]);
	}

	public void setCurrent_animation_length(double value) {
		super.call("set_current_animation_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCurrent_animation_position() {
		return (double) super.call("get_current_animation_position", new java.lang.Object[0]);
	}

	public void setCurrent_animation_position(double value) {
		super.call("set_current_animation_position", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isPlayback_auto_capture() {
		return (boolean) super.call("is_auto_capture", new java.lang.Object[0]);
	}

	public void setPlayback_auto_capture(boolean value) {
		super.call("set_auto_capture", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPlayback_auto_capture_duration() {
		return (double) super.call("get_auto_capture_duration", new java.lang.Object[0]);
	}

	public void setPlayback_auto_capture_duration(double value) {
		super.call("set_auto_capture_duration", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getPlayback_auto_capture_transition_type() {
		return (long) super.call("get_auto_capture_transition_type", new java.lang.Object[0]);
	}

	public void setPlayback_auto_capture_transition_type(long value) {
		super.call("set_auto_capture_transition_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPlayback_auto_capture_ease_type() {
		return (long) super.call("get_auto_capture_ease_type", new java.lang.Object[0]);
	}

	public void setPlayback_auto_capture_ease_type(long value) {
		super.call("set_auto_capture_ease_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPlayback_default_blend_time() {
		return (double) super.call("get_default_blend_time", new java.lang.Object[0]);
	}

	public void setPlayback_default_blend_time(double value) {
		super.call("set_default_blend_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpeed_scale() {
		return (double) super.call("get_speed_scale", new java.lang.Object[0]);
	}

	public void setSpeed_scale(double value) {
		super.call("set_speed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isMovie_quit_on_finish() {
		return (boolean) super.call("is_movie_quit_on_finish_enabled", new java.lang.Object[0]);
	}

	public void setMovie_quit_on_finish(boolean value) {
		super.call("set_movie_quit_on_finish_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
