package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class SpriteFrames extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("rename_animation", 3740211285L), java.util.Map.entry("remove_animation", 3304788590L),
			java.util.Map.entry("remove_frame", 2415702435L), java.util.Map.entry("set_frame", 56804795L),
			java.util.Map.entry("clear", 3304788590L), java.util.Map.entry("get_frame_texture", 2900517879L),
			java.util.Map.entry("get_frame_duration", 1129309260L),
			java.util.Map.entry("get_animation_names", 1139954409L), java.util.Map.entry("clear_all", 3218959716L),
			java.util.Map.entry("add_animation", 3304788590L), java.util.Map.entry("has_animation", 2619796661L),
			java.util.Map.entry("add_frame", 1351332740L), java.util.Map.entry("set_animation_loop", 2524380260L),
			java.util.Map.entry("duplicate_animation", 3740211285L),
			java.util.Map.entry("set_animation_speed", 4135858297L),
			java.util.Map.entry("get_frame_count", 2458036349L), java.util.Map.entry("get_animation_loop", 2619796661L),
			java.util.Map.entry("get_animation_speed", 2349060816L));

	SpriteFrames(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpriteFrames(long nativePointer) {
		super(nativePointer);
	}

	public void add_animation(String anim) {
		super.call("add_animation", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public boolean has_animation(String anim) {
		return (boolean) super.call("has_animation", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public void duplicate_animation(String anim_from, String anim_to) {
		super.call("duplicate_animation",
				new java.lang.Object[]{(java.lang.Object) anim_from, (java.lang.Object) anim_to});
	}

	public void remove_animation(String anim) {
		super.call("remove_animation", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public void rename_animation(String anim, String newname) {
		super.call("rename_animation", new java.lang.Object[]{(java.lang.Object) anim, (java.lang.Object) newname});
	}

	public void set_animation_speed(String anim, double fps) {
		super.call("set_animation_speed",
				new java.lang.Object[]{(java.lang.Object) anim, java.lang.Double.valueOf(fps)});
	}

	public double get_animation_speed(String anim) {
		return (double) super.call("get_animation_speed", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public void set_animation_loop(String anim, boolean loop) {
		super.call("set_animation_loop",
				new java.lang.Object[]{(java.lang.Object) anim, java.lang.Boolean.valueOf(loop)});
	}

	public boolean get_animation_loop(String anim) {
		return (boolean) super.call("get_animation_loop", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public void add_frame(String anim, Texture2D texture, double duration, long at_position) {
		super.call("add_frame", new java.lang.Object[]{(java.lang.Object) anim, (java.lang.Object) texture,
				java.lang.Double.valueOf(duration), java.lang.Long.valueOf(at_position)});
	}

	public void set_frame(String anim, long idx, Texture2D texture, double duration) {
		super.call("set_frame", new java.lang.Object[]{(java.lang.Object) anim, java.lang.Long.valueOf(idx),
				(java.lang.Object) texture, java.lang.Double.valueOf(duration)});
	}

	public void remove_frame(String anim, long idx) {
		super.call("remove_frame", new java.lang.Object[]{(java.lang.Object) anim, java.lang.Long.valueOf(idx)});
	}

	public int get_frame_count(String anim) {
		return (int) super.call("get_frame_count", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public Texture2D get_frame_texture(String anim, long idx) {
		return (Texture2D) super.call("get_frame_texture",
				new java.lang.Object[]{(java.lang.Object) anim, java.lang.Long.valueOf(idx)});
	}

	public double get_frame_duration(String anim, long idx) {
		return (double) super.call("get_frame_duration",
				new java.lang.Object[]{(java.lang.Object) anim, java.lang.Long.valueOf(idx)});
	}

	public void clear(String anim) {
		super.call("clear", new java.lang.Object[]{(java.lang.Object) anim});
	}

	public void clear_all() {
		super.call("clear_all");
	}

	public GodotArray getAnimations() {
		return (GodotArray) super.call("_get_animations", new java.lang.Object[0]);
	}

	public void setAnimations(GodotArray value) {
		super.call("_set_animations", new java.lang.Object[]{(java.lang.Object) value});
	}
}
