package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamInteractive extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_clip_count", 3905245786L),
			java.util.Map.entry("get_transition_fade_beats", 3085491603L),
			java.util.Map.entry("get_transition_fade_mode", 4065396087L),
			java.util.Map.entry("add_transition", 1630280552L),
			java.util.Map.entry("get_transition_from_time", 3453338158L),
			java.util.Map.entry("set_clip_auto_advance", 57217598L),
			java.util.Map.entry("set_initial_clip", 1286410249L),
			java.util.Map.entry("get_transition_list", 1930428628L), java.util.Map.entry("get_clip_name", 659327637L),
			java.util.Map.entry("set_clip_stream", 111075094L),
			java.util.Map.entry("is_transition_holding_previous", 2522259332L),
			java.util.Map.entry("set_clip_count", 1286410249L),
			java.util.Map.entry("get_transition_filler_clip", 3175239445L),
			java.util.Map.entry("is_transition_using_filler_clip", 2522259332L),
			java.util.Map.entry("set_clip_auto_advance_next_clip", 3937882851L),
			java.util.Map.entry("set_clip_name", 3780747571L),
			java.util.Map.entry("get_clip_auto_advance_next_clip", 923996154L),
			java.util.Map.entry("erase_transition", 3937882851L),
			java.util.Map.entry("get_clip_auto_advance", 1778634807L),
			java.util.Map.entry("get_initial_clip", 3905245786L),
			java.util.Map.entry("get_transition_to_time", 1369651373L),
			java.util.Map.entry("get_clip_stream", 2739380747L), java.util.Map.entry("has_transition", 2522259332L));

	AudioStreamInteractive(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamInteractive(long nativePointer) {
		super(nativePointer);
	}

	public void set_clip_name(long clip_index, String name) {
		super.call("set_clip_name",
				new java.lang.Object[]{java.lang.Long.valueOf(clip_index), (java.lang.Object) name});
	}

	public String get_clip_name(long clip_index) {
		return (String) super.call("get_clip_name", new java.lang.Object[]{java.lang.Long.valueOf(clip_index)});
	}

	public void set_clip_stream(long clip_index, AudioStream stream) {
		super.call("set_clip_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(clip_index), (java.lang.Object) stream});
	}

	public AudioStream get_clip_stream(long clip_index) {
		return (AudioStream) super.call("get_clip_stream", new java.lang.Object[]{java.lang.Long.valueOf(clip_index)});
	}

	public void set_clip_auto_advance(long clip_index, int mode) {
		super.call("set_clip_auto_advance",
				new java.lang.Object[]{java.lang.Long.valueOf(clip_index), java.lang.Integer.valueOf(mode)});
	}

	public int get_clip_auto_advance(long clip_index) {
		return (int) super.call("get_clip_auto_advance", new java.lang.Object[]{java.lang.Long.valueOf(clip_index)});
	}

	public void set_clip_auto_advance_next_clip(long clip_index, long auto_advance_next_clip) {
		super.call("set_clip_auto_advance_next_clip", new java.lang.Object[]{java.lang.Long.valueOf(clip_index),
				java.lang.Long.valueOf(auto_advance_next_clip)});
	}

	public int get_clip_auto_advance_next_clip(long clip_index) {
		return (int) super.call("get_clip_auto_advance_next_clip",
				new java.lang.Object[]{java.lang.Long.valueOf(clip_index)});
	}

	public void add_transition(long from_clip, long to_clip, int from_time, int to_time, int fade_mode,
			double fade_beats, boolean use_filler_clip, long filler_clip, boolean hold_previous) {
		super.call("add_transition",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip),
						java.lang.Integer.valueOf(from_time), java.lang.Integer.valueOf(to_time),
						java.lang.Integer.valueOf(fade_mode), java.lang.Double.valueOf(fade_beats),
						java.lang.Boolean.valueOf(use_filler_clip), java.lang.Long.valueOf(filler_clip),
						java.lang.Boolean.valueOf(hold_previous)});
	}

	public boolean has_transition(long from_clip, long to_clip) {
		return (boolean) super.call("has_transition",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public void erase_transition(long from_clip, long to_clip) {
		super.call("erase_transition",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public int get_transition_from_time(long from_clip, long to_clip) {
		return (int) super.call("get_transition_from_time",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public int get_transition_to_time(long from_clip, long to_clip) {
		return (int) super.call("get_transition_to_time",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public int get_transition_fade_mode(long from_clip, long to_clip) {
		return (int) super.call("get_transition_fade_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public double get_transition_fade_beats(long from_clip, long to_clip) {
		return (double) super.call("get_transition_fade_beats",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public boolean is_transition_using_filler_clip(long from_clip, long to_clip) {
		return (boolean) super.call("is_transition_using_filler_clip",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public int get_transition_filler_clip(long from_clip, long to_clip) {
		return (int) super.call("get_transition_filler_clip",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public boolean is_transition_holding_previous(long from_clip, long to_clip) {
		return (boolean) super.call("is_transition_holding_previous",
				new java.lang.Object[]{java.lang.Long.valueOf(from_clip), java.lang.Long.valueOf(to_clip)});
	}

	public long getClip_count() {
		return (long) super.call("get_clip_count", new java.lang.Object[0]);
	}

	public void setClip_count(long value) {
		super.call("set_clip_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getInitial_clip() {
		return (long) super.call("get_initial_clip", new java.lang.Object[0]);
	}

	public void setInitial_clip(long value) {
		super.call("set_initial_clip", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
