package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimatedTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pause", 2586408642L), java.util.Map.entry("get_one_shot", 36873697L),
			java.util.Map.entry("get_frames", 3905245786L), java.util.Map.entry("get_frame_texture", 3536238170L),
			java.util.Map.entry("set_current_frame", 1286410249L), java.util.Map.entry("set_speed_scale", 373806689L),
			java.util.Map.entry("get_frame_duration", 2339986948L), java.util.Map.entry("get_pause", 36873697L),
			java.util.Map.entry("set_frame_texture", 666127730L), java.util.Map.entry("get_current_frame", 3905245786L),
			java.util.Map.entry("set_frames", 1286410249L), java.util.Map.entry("set_one_shot", 2586408642L),
			java.util.Map.entry("get_speed_scale", 1740695150L),
			java.util.Map.entry("set_frame_duration", 1602489585L));

	AnimatedTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimatedTexture(long nativePointer) {
		super(nativePointer);
	}

	public void set_frame_texture(long frame, Texture2D texture) {
		super.call("set_frame_texture",
				new java.lang.Object[]{java.lang.Long.valueOf(frame), (java.lang.Object) texture});
	}

	public Texture2D get_frame_texture(long frame) {
		return (Texture2D) super.call("get_frame_texture", new java.lang.Object[]{java.lang.Long.valueOf(frame)});
	}

	public void set_frame_duration(long frame, double duration) {
		super.call("set_frame_duration",
				new java.lang.Object[]{java.lang.Long.valueOf(frame), java.lang.Double.valueOf(duration)});
	}

	public double get_frame_duration(long frame) {
		return (double) super.call("get_frame_duration", new java.lang.Object[]{java.lang.Long.valueOf(frame)});
	}

	public long getFrames() {
		return (long) super.call("get_frames", new java.lang.Object[0]);
	}

	public void setFrames(long value) {
		super.call("set_frames", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCurrent_frame() {
		return (long) super.call("get_current_frame", new java.lang.Object[0]);
	}

	public void setCurrent_frame(long value) {
		super.call("set_current_frame", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getPause() {
		return (boolean) super.call("get_pause", new java.lang.Object[0]);
	}

	public void setPause(boolean value) {
		super.call("set_pause", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getOne_shot() {
		return (boolean) super.call("get_one_shot", new java.lang.Object[0]);
	}

	public void setOne_shot(boolean value) {
		super.call("set_one_shot", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSpeed_scale() {
		return (double) super.call("get_speed_scale", new java.lang.Object[0]);
	}

	public void setSpeed_scale(double value) {
		super.call("set_speed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
