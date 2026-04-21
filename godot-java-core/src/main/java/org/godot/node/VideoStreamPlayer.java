package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VideoStreamPlayer extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("play", 3218959716L), java.util.Map.entry("get_stream_position", 1740695150L),
			java.util.Map.entry("get_video_texture", 3635182373L), java.util.Map.entry("has_loop", 36873697L),
			java.util.Map.entry("set_paused", 2586408642L), java.util.Map.entry("set_expand", 2586408642L),
			java.util.Map.entry("get_stream_length", 1740695150L), java.util.Map.entry("get_volume", 1740695150L),
			java.util.Map.entry("get_volume_db", 1740695150L), java.util.Map.entry("get_stream", 438621487L),
			java.util.Map.entry("set_buffering_msec", 1286410249L),
			java.util.Map.entry("get_buffering_msec", 3905245786L), java.util.Map.entry("get_audio_track", 3905245786L),
			java.util.Map.entry("get_stream_name", 201670096L), java.util.Map.entry("is_playing", 36873697L),
			java.util.Map.entry("has_expand", 36873697L), java.util.Map.entry("get_bus", 2002593661L),
			java.util.Map.entry("set_volume_db", 373806689L), java.util.Map.entry("set_autoplay", 2586408642L),
			java.util.Map.entry("set_speed_scale", 373806689L), java.util.Map.entry("has_autoplay", 36873697L),
			java.util.Map.entry("stop", 3218959716L), java.util.Map.entry("set_stream", 2317102564L),
			java.util.Map.entry("is_paused", 36873697L), java.util.Map.entry("set_audio_track", 1286410249L),
			java.util.Map.entry("set_bus", 3304788590L), java.util.Map.entry("set_volume", 373806689L),
			java.util.Map.entry("set_loop", 2586408642L), java.util.Map.entry("set_stream_position", 373806689L),
			java.util.Map.entry("get_speed_scale", 1740695150L));

	VideoStreamPlayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VideoStreamPlayer(long nativePointer) {
		super(nativePointer);
	}

	public void play() {
		super.call("play");
	}

	public void stop() {
		super.call("stop");
	}

	public boolean is_playing() {
		return (boolean) super.call("is_playing");
	}

	public boolean is_paused() {
		return (boolean) super.call("is_paused");
	}

	public boolean has_loop() {
		return (boolean) super.call("has_loop");
	}

	public boolean has_autoplay() {
		return (boolean) super.call("has_autoplay");
	}

	public boolean has_expand() {
		return (boolean) super.call("has_expand");
	}

	public long getAudio_track() {
		return (long) super.call("get_audio_track", new java.lang.Object[0]);
	}

	public void setAudio_track(long value) {
		super.call("set_audio_track", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public VideoStream getStream() {
		return (VideoStream) super.call("get_stream", new java.lang.Object[0]);
	}

	public void setStream(VideoStream value) {
		super.call("set_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getVolume_db() {
		return (double) super.call("get_volume_db", new java.lang.Object[0]);
	}

	public void setVolume_db(double value) {
		super.call("set_volume_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolume() {
		return (double) super.call("get_volume", new java.lang.Object[0]);
	}

	public void setVolume(double value) {
		super.call("set_volume", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSpeed_scale() {
		return (double) super.call("get_speed_scale", new java.lang.Object[0]);
	}

	public void setSpeed_scale(double value) {
		super.call("set_speed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getAutoplay() {
		return (boolean) super.call("has_autoplay", new java.lang.Object[0]);
	}

	public void setAutoplay(boolean value) {
		super.call("set_autoplay", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPaused() {
		return (boolean) super.call("is_paused", new java.lang.Object[0]);
	}

	public void setPaused(boolean value) {
		super.call("set_paused", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getExpand() {
		return (boolean) super.call("has_expand", new java.lang.Object[0]);
	}

	public void setExpand(boolean value) {
		super.call("set_expand", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getLoop() {
		return (boolean) super.call("has_loop", new java.lang.Object[0]);
	}

	public void setLoop(boolean value) {
		super.call("set_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getBuffering_msec() {
		return (long) super.call("get_buffering_msec", new java.lang.Object[0]);
	}

	public void setBuffering_msec(long value) {
		super.call("set_buffering_msec", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getStream_position() {
		return (double) super.call("get_stream_position", new java.lang.Object[0]);
	}

	public void setStream_position(double value) {
		super.call("set_stream_position", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getBus() {
		return (String) super.call("get_bus", new java.lang.Object[0]);
	}

	public void setBus(String value) {
		super.call("set_bus", new java.lang.Object[]{(java.lang.Object) value});
	}
}
