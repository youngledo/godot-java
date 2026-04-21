package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamPlayer2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("play", 1958160172L), java.util.Map.entry("get_max_polyphony", 3905245786L),
			java.util.Map.entry("get_playback_position", 191475506L),
			java.util.Map.entry("get_volume_linear", 1740695150L), java.util.Map.entry("set_attenuation", 373806689L),
			java.util.Map.entry("set_playback_type", 725473817L), java.util.Map.entry("seek", 373806689L),
			java.util.Map.entry("set_playing", 2586408642L), java.util.Map.entry("get_volume_db", 1740695150L),
			java.util.Map.entry("get_stream", 160907539L), java.util.Map.entry("set_area_mask", 1286410249L),
			java.util.Map.entry("get_stream_paused", 36873697L), java.util.Map.entry("set_max_polyphony", 1286410249L),
			java.util.Map.entry("has_stream_playback", 2240911060L),
			java.util.Map.entry("is_autoplay_enabled", 36873697L), java.util.Map.entry("get_max_distance", 1740695150L),
			java.util.Map.entry("is_playing", 36873697L), java.util.Map.entry("get_area_mask", 3905245786L),
			java.util.Map.entry("get_panning_strength", 1740695150L),
			java.util.Map.entry("get_stream_playback", 210135309L),
			java.util.Map.entry("set_panning_strength", 373806689L),
			java.util.Map.entry("set_stream_paused", 2586408642L), java.util.Map.entry("get_pitch_scale", 1740695150L),
			java.util.Map.entry("get_bus", 2002593661L), java.util.Map.entry("set_volume_db", 373806689L),
			java.util.Map.entry("set_autoplay", 2586408642L), java.util.Map.entry("get_playback_type", 4011264623L),
			java.util.Map.entry("set_pitch_scale", 373806689L), java.util.Map.entry("set_max_distance", 373806689L),
			java.util.Map.entry("set_volume_linear", 373806689L), java.util.Map.entry("stop", 3218959716L),
			java.util.Map.entry("set_stream", 2210767741L), java.util.Map.entry("set_bus", 3304788590L),
			java.util.Map.entry("get_attenuation", 1740695150L));

	AudioStreamPlayer2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlayer2D(long nativePointer) {
		super(nativePointer);
	}

	public void play(double from_position) {
		super.call("play", new java.lang.Object[]{java.lang.Double.valueOf(from_position)});
	}

	public void seek(double to_position) {
		super.call("seek", new java.lang.Object[]{java.lang.Double.valueOf(to_position)});
	}

	public void stop() {
		super.call("stop");
	}

	public boolean is_playing() {
		return (boolean) super.call("is_playing");
	}

	public boolean is_autoplay_enabled() {
		return (boolean) super.call("is_autoplay_enabled");
	}

	public boolean has_stream_playback() {
		return (boolean) super.call("has_stream_playback");
	}

	public AudioStream getStream() {
		return (AudioStream) super.call("get_stream", new java.lang.Object[0]);
	}

	public void setStream(AudioStream value) {
		super.call("set_stream", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getVolume_db() {
		return (double) super.call("get_volume_db", new java.lang.Object[0]);
	}

	public void setVolume_db(double value) {
		super.call("set_volume_db", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVolume_linear() {
		return (double) super.call("get_volume_linear", new java.lang.Object[0]);
	}

	public void setVolume_linear(double value) {
		super.call("set_volume_linear", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPitch_scale() {
		return (double) super.call("get_pitch_scale", new java.lang.Object[0]);
	}

	public void setPitch_scale(double value) {
		super.call("set_pitch_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isPlaying() {
		return (boolean) super.call("is_playing", new java.lang.Object[0]);
	}

	public void setPlaying(boolean value) {
		super.call("set_playing", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAutoplay() {
		return (boolean) super.call("is_autoplay_enabled", new java.lang.Object[0]);
	}

	public void setAutoplay(boolean value) {
		super.call("set_autoplay", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getStream_paused() {
		return (boolean) super.call("get_stream_paused", new java.lang.Object[0]);
	}

	public void setStream_paused(boolean value) {
		super.call("set_stream_paused", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getMax_distance() {
		return (double) super.call("get_max_distance", new java.lang.Object[0]);
	}

	public void setMax_distance(double value) {
		super.call("set_max_distance", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAttenuation() {
		return (double) super.call("get_attenuation", new java.lang.Object[0]);
	}

	public void setAttenuation(double value) {
		super.call("set_attenuation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getMax_polyphony() {
		return (long) super.call("get_max_polyphony", new java.lang.Object[0]);
	}

	public void setMax_polyphony(long value) {
		super.call("set_max_polyphony", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPanning_strength() {
		return (double) super.call("get_panning_strength", new java.lang.Object[0]);
	}

	public void setPanning_strength(double value) {
		super.call("set_panning_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getBus() {
		return (String) super.call("get_bus", new java.lang.Object[0]);
	}

	public void setBus(String value) {
		super.call("set_bus", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getArea_mask() {
		return (long) super.call("get_area_mask", new java.lang.Object[0]);
	}

	public void setArea_mask(long value) {
		super.call("set_area_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPlayback_type() {
		return (long) super.call("get_playback_type", new java.lang.Object[0]);
	}

	public void setPlayback_type(long value) {
		super.call("set_playback_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
