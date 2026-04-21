package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class AnimatedSprite2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("play", 3269405555L), java.util.Map.entry("get_animation", 2002593661L),
			java.util.Map.entry("get_sprite_frames", 3804851214L), java.util.Map.entry("get_autoplay", 201670096L),
			java.util.Map.entry("set_flip_v", 2586408642L), java.util.Map.entry("set_frame", 1286410249L),
			java.util.Map.entry("is_centered", 36873697L), java.util.Map.entry("set_frame_progress", 373806689L),
			java.util.Map.entry("is_flipped_h", 36873697L), java.util.Map.entry("set_centered", 2586408642L),
			java.util.Map.entry("get_playing_speed", 1740695150L), java.util.Map.entry("set_animation", 3304788590L),
			java.util.Map.entry("is_playing", 36873697L), java.util.Map.entry("get_frame_progress", 1740695150L),
			java.util.Map.entry("get_offset", 3341600327L), java.util.Map.entry("is_flipped_v", 36873697L),
			java.util.Map.entry("set_autoplay", 83702148L), java.util.Map.entry("get_frame", 3905245786L),
			java.util.Map.entry("set_speed_scale", 373806689L),
			java.util.Map.entry("set_frame_and_progress", 1602489585L), java.util.Map.entry("pause", 3218959716L),
			java.util.Map.entry("set_sprite_frames", 905781144L), java.util.Map.entry("play_backwards", 3323268493L),
			java.util.Map.entry("stop", 3218959716L), java.util.Map.entry("set_flip_h", 2586408642L),
			java.util.Map.entry("set_offset", 743155724L), java.util.Map.entry("get_speed_scale", 1740695150L));

	AnimatedSprite2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimatedSprite2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_playing() {
		return (boolean) super.call("is_playing");
	}

	public void play(String name, double custom_speed, boolean from_end) {
		super.call("play", new java.lang.Object[]{(java.lang.Object) name, java.lang.Double.valueOf(custom_speed),
				java.lang.Boolean.valueOf(from_end)});
	}

	public void play_backwards(String name) {
		super.call("play_backwards", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void pause() {
		super.call("pause");
	}

	public void stop() {
		super.call("stop");
	}

	public boolean is_centered() {
		return (boolean) super.call("is_centered");
	}

	public boolean is_flipped_h() {
		return (boolean) super.call("is_flipped_h");
	}

	public boolean is_flipped_v() {
		return (boolean) super.call("is_flipped_v");
	}

	public void set_frame_and_progress(long frame, double progress) {
		super.call("set_frame_and_progress",
				new java.lang.Object[]{java.lang.Long.valueOf(frame), java.lang.Double.valueOf(progress)});
	}

	public SpriteFrames getSprite_frames() {
		return (SpriteFrames) super.call("get_sprite_frames", new java.lang.Object[0]);
	}

	public void setSprite_frames(SpriteFrames value) {
		super.call("set_sprite_frames", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAnimation() {
		return (String) super.call("get_animation", new java.lang.Object[0]);
	}

	public void setAnimation(String value) {
		super.call("set_animation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getAutoplay() {
		return (String) super.call("get_autoplay", new java.lang.Object[0]);
	}

	public void setAutoplay(String value) {
		super.call("set_autoplay", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFrame() {
		return (long) super.call("get_frame", new java.lang.Object[0]);
	}

	public void setFrame(long value) {
		super.call("set_frame", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getFrame_progress() {
		return (double) super.call("get_frame_progress", new java.lang.Object[0]);
	}

	public void setFrame_progress(double value) {
		super.call("set_frame_progress", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpeed_scale() {
		return (double) super.call("get_speed_scale", new java.lang.Object[0]);
	}

	public void setSpeed_scale(double value) {
		super.call("set_speed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCentered() {
		return (boolean) super.call("is_centered", new java.lang.Object[0]);
	}

	public void setCentered(boolean value) {
		super.call("set_centered", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFlip_h() {
		return (boolean) super.call("is_flipped_h", new java.lang.Object[0]);
	}

	public void setFlip_h(boolean value) {
		super.call("set_flip_h", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFlip_v() {
		return (boolean) super.call("is_flipped_v", new java.lang.Object[0]);
	}

	public void setFlip_v(boolean value) {
		super.call("set_flip_v", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
