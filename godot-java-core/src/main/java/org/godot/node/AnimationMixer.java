package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationMixer extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_animation", 2933122410L), java.util.Map.entry("set_root_node", 1348162250L),
			java.util.Map.entry("set_root_motion_local", 2586408642L),
			java.util.Map.entry("get_animation_library", 147342321L),
			java.util.Map.entry("find_animation", 1559484580L),
			java.util.Map.entry("get_root_motion_rotation_accumulator", 1222331677L),
			java.util.Map.entry("set_audio_max_polyphony", 1286410249L),
			java.util.Map.entry("get_audio_max_polyphony", 3905245786L), java.util.Map.entry("advance", 373806689L),
			java.util.Map.entry("set_callback_mode_process", 2153733086L),
			java.util.Map.entry("set_root_motion_track", 1348162250L),
			java.util.Map.entry("get_root_motion_position_accumulator", 3360562783L),
			java.util.Map.entry("set_callback_mode_discrete", 1998944670L),
			java.util.Map.entry("has_animation_library", 2619796661L),
			java.util.Map.entry("set_deterministic", 2586408642L),
			java.util.Map.entry("get_callback_mode_method", 489449656L),
			java.util.Map.entry("find_animation_library", 1559484580L),
			java.util.Map.entry("add_animation_library", 618909818L),
			java.util.Map.entry("get_root_motion_track", 4075236667L),
			java.util.Map.entry("set_reset_on_save_enabled", 2586408642L),
			java.util.Map.entry("remove_animation_library", 3304788590L),
			java.util.Map.entry("is_root_motion_local", 36873697L),
			java.util.Map.entry("get_root_motion_position", 3360562783L),
			java.util.Map.entry("clear_caches", 3218959716L),
			java.util.Map.entry("get_animation_library_list", 3995934104L), java.util.Map.entry("is_active", 36873697L),
			java.util.Map.entry("get_root_motion_scale", 3360562783L), java.util.Map.entry("set_active", 2586408642L),
			java.util.Map.entry("get_root_node", 4075236667L),
			java.util.Map.entry("set_callback_mode_method", 742218271L), java.util.Map.entry("capture", 1333632127L),
			java.util.Map.entry("is_reset_on_save_enabled", 36873697L),
			java.util.Map.entry("rename_animation_library", 3740211285L),
			java.util.Map.entry("has_animation", 2619796661L),
			java.util.Map.entry("get_root_motion_scale_accumulator", 3360562783L),
			java.util.Map.entry("get_root_motion_rotation", 1222331677L),
			java.util.Map.entry("is_deterministic", 36873697L), java.util.Map.entry("get_animation_list", 1139954409L),
			java.util.Map.entry("get_callback_mode_process", 1394468472L),
			java.util.Map.entry("get_callback_mode_discrete", 3493168860L));

	AnimationMixer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationMixer(long nativePointer) {
		super(nativePointer);
	}

	public int add_animation_library(String name, AnimationLibrary library) {
		return (int) super.call("add_animation_library",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) library});
	}

	public void remove_animation_library(String name) {
		super.call("remove_animation_library", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void rename_animation_library(String name, String newname) {
		super.call("rename_animation_library",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) newname});
	}

	public boolean has_animation_library(String name) {
		return (boolean) super.call("has_animation_library", new java.lang.Object[]{(java.lang.Object) name});
	}

	public AnimationLibrary get_animation_library(String name) {
		return (AnimationLibrary) super.call("get_animation_library", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_animation(String name) {
		return (boolean) super.call("has_animation", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Animation get_animation(String name) {
		return (Animation) super.call("get_animation", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public boolean is_deterministic() {
		return (boolean) super.call("is_deterministic");
	}

	public boolean is_root_motion_local() {
		return (boolean) super.call("is_root_motion_local");
	}

	public void clear_caches() {
		super.call("clear_caches");
	}

	public void advance(double delta) {
		super.call("advance", new java.lang.Object[]{java.lang.Double.valueOf(delta)});
	}

	public void capture(String name, double duration, int trans_type, int ease_type) {
		super.call("capture", new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(duration),
				java.lang.Integer.valueOf(trans_type), java.lang.Integer.valueOf(ease_type)});
	}

	public boolean is_reset_on_save_enabled() {
		return (boolean) super.call("is_reset_on_save_enabled");
	}

	public String find_animation(Animation animation) {
		return (String) super.call("find_animation", new java.lang.Object[]{(java.lang.Object) animation});
	}

	public String find_animation_library(Animation animation) {
		return (String) super.call("find_animation_library", new java.lang.Object[]{(java.lang.Object) animation});
	}

	public boolean isActive() {
		return (boolean) super.call("is_active", new java.lang.Object[0]);
	}

	public void setActive(boolean value) {
		super.call("set_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDeterministic() {
		return (boolean) super.call("is_deterministic", new java.lang.Object[0]);
	}

	public void setDeterministic(boolean value) {
		super.call("set_deterministic", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isReset_on_save() {
		return (boolean) super.call("is_reset_on_save_enabled", new java.lang.Object[0]);
	}

	public void setReset_on_save(boolean value) {
		super.call("set_reset_on_save_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getRoot_node() {
		return (String) super.call("get_root_node", new java.lang.Object[0]);
	}

	public void setRoot_node(String value) {
		super.call("set_root_node", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getRoot_motion_track() {
		return (String) super.call("get_root_motion_track", new java.lang.Object[0]);
	}

	public void setRoot_motion_track(String value) {
		super.call("set_root_motion_track", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRoot_motion_local() {
		return (boolean) super.call("is_root_motion_local", new java.lang.Object[0]);
	}

	public void setRoot_motion_local(boolean value) {
		super.call("set_root_motion_local", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAudio_max_polyphony() {
		return (long) super.call("get_audio_max_polyphony", new java.lang.Object[0]);
	}

	public void setAudio_max_polyphony(long value) {
		super.call("set_audio_max_polyphony", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCallback_mode_process() {
		return (long) super.call("get_callback_mode_process", new java.lang.Object[0]);
	}

	public void setCallback_mode_process(long value) {
		super.call("set_callback_mode_process", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCallback_mode_method() {
		return (long) super.call("get_callback_mode_method", new java.lang.Object[0]);
	}

	public void setCallback_mode_method(long value) {
		super.call("set_callback_mode_method", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCallback_mode_discrete() {
		return (long) super.call("get_callback_mode_discrete", new java.lang.Object[0]);
	}

	public void setCallback_mode_discrete(long value) {
		super.call("set_callback_mode_discrete", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
