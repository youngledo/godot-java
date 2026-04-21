package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class AudioServer extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_bus_volume_db", 2339986948L),
			java.util.Map.entry("get_bus_effect_instance", 1829771234L),
			java.util.Map.entry("set_bus_effect_enabled", 1383440665L),
			java.util.Map.entry("remove_bus_effect", 3937882851L),
			java.util.Map.entry("get_playback_speed_scale", 1740695150L),
			java.util.Map.entry("get_input_device_list", 2981934095L),
			java.util.Map.entry("set_input_device", 83702148L),
			java.util.Map.entry("get_input_buffer_length_frames", 2455072627L),
			java.util.Map.entry("add_bus_effect", 4068819785L),
			java.util.Map.entry("set_input_device_active", 1413768114L), java.util.Map.entry("lock", 3218959716L),
			java.util.Map.entry("get_time_since_last_mix", 1740695150L),
			java.util.Map.entry("get_bus_count", 3905245786L),
			java.util.Map.entry("set_enable_tagging_used_audio_streams", 2586408642L),
			java.util.Map.entry("is_stream_registered_as_sample", 500225754L),
			java.util.Map.entry("get_driver_name", 201670096L),
			java.util.Map.entry("get_bus_peak_volume_right_db", 3085491603L),
			java.util.Map.entry("get_speaker_mode", 2549190337L), java.util.Map.entry("get_output_device", 2841200299L),
			java.util.Map.entry("unlock", 3218959716L), java.util.Map.entry("register_stream_as_sample", 2210767741L),
			java.util.Map.entry("is_bus_mute", 1116898809L), java.util.Map.entry("get_input_mix_rate", 1740695150L),
			java.util.Map.entry("get_bus_volume_linear", 2339986948L),
			java.util.Map.entry("get_input_frames_available", 2455072627L),
			java.util.Map.entry("set_bus_solo", 300928843L), java.util.Map.entry("set_output_device", 83702148L),
			java.util.Map.entry("set_bus_volume_db", 1602489585L), java.util.Map.entry("remove_bus", 1286410249L),
			java.util.Map.entry("is_bus_effect_enabled", 2522259332L),
			java.util.Map.entry("set_bus_layout", 3319058824L), java.util.Map.entry("get_mix_rate", 1740695150L),
			java.util.Map.entry("get_bus_send", 659327637L), java.util.Map.entry("get_bus_name", 844755477L),
			java.util.Map.entry("get_time_to_next_mix", 1740695150L),
			java.util.Map.entry("set_bus_volume_linear", 1602489585L),
			java.util.Map.entry("set_bus_count", 1286410249L), java.util.Map.entry("get_bus_effect", 726064442L),
			java.util.Map.entry("get_bus_channels", 923996154L), java.util.Map.entry("move_bus", 3937882851L),
			java.util.Map.entry("set_bus_bypass_effects", 300928843L),
			java.util.Map.entry("generate_bus_layout", 3769973890L),
			java.util.Map.entry("get_input_frames", 2649534757L),
			java.util.Map.entry("is_bus_bypassing_effects", 1116898809L),
			java.util.Map.entry("set_bus_send", 3780747571L), java.util.Map.entry("set_bus_name", 501894301L),
			java.util.Map.entry("add_bus", 1025054187L), java.util.Map.entry("get_output_device_list", 2981934095L),
			java.util.Map.entry("get_bus_effect_count", 3744713108L),
			java.util.Map.entry("get_bus_peak_volume_left_db", 3085491603L),
			java.util.Map.entry("get_output_latency", 1740695150L), java.util.Map.entry("is_bus_solo", 1116898809L),
			java.util.Map.entry("set_playback_speed_scale", 373806689L),
			java.util.Map.entry("get_input_device", 2841200299L), java.util.Map.entry("get_bus_index", 2458036349L),
			java.util.Map.entry("set_bus_mute", 300928843L), java.util.Map.entry("swap_bus_effects", 1649997291L));

	AudioServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioServer(long nativePointer) {
		super(nativePointer);
	}

	public void remove_bus(long index) {
		super.call("remove_bus", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_bus(long at_position) {
		super.call("add_bus", new java.lang.Object[]{java.lang.Long.valueOf(at_position)});
	}

	public void move_bus(long index, long to_index) {
		super.call("move_bus", new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(to_index)});
	}

	public void set_bus_name(long bus_idx, String name) {
		super.call("set_bus_name", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), (java.lang.Object) name});
	}

	public String get_bus_name(long bus_idx) {
		return (String) super.call("get_bus_name", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public int get_bus_index(String bus_name) {
		return (int) super.call("get_bus_index", new java.lang.Object[]{(java.lang.Object) bus_name});
	}

	public int get_bus_channels(long bus_idx) {
		return (int) super.call("get_bus_channels", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void set_bus_volume_db(long bus_idx, double volume_db) {
		super.call("set_bus_volume_db",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Double.valueOf(volume_db)});
	}

	public double get_bus_volume_db(long bus_idx) {
		return (double) super.call("get_bus_volume_db", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void set_bus_volume_linear(long bus_idx, double volume_linear) {
		super.call("set_bus_volume_linear",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Double.valueOf(volume_linear)});
	}

	public double get_bus_volume_linear(long bus_idx) {
		return (double) super.call("get_bus_volume_linear", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void set_bus_send(long bus_idx, String send) {
		super.call("set_bus_send", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), (java.lang.Object) send});
	}

	public String get_bus_send(long bus_idx) {
		return (String) super.call("get_bus_send", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void set_bus_solo(long bus_idx, boolean enable) {
		super.call("set_bus_solo",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_bus_solo(long bus_idx) {
		return (boolean) super.call("is_bus_solo", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void set_bus_mute(long bus_idx, boolean enable) {
		super.call("set_bus_mute",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_bus_mute(long bus_idx) {
		return (boolean) super.call("is_bus_mute", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void set_bus_bypass_effects(long bus_idx, boolean enable) {
		super.call("set_bus_bypass_effects",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Boolean.valueOf(enable)});
	}

	public boolean is_bus_bypassing_effects(long bus_idx) {
		return (boolean) super.call("is_bus_bypassing_effects",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public void add_bus_effect(long bus_idx, AudioEffect effect, long at_position) {
		super.call("add_bus_effect", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), (java.lang.Object) effect,
				java.lang.Long.valueOf(at_position)});
	}

	public void remove_bus_effect(long bus_idx, long effect_idx) {
		super.call("remove_bus_effect",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Long.valueOf(effect_idx)});
	}

	public int get_bus_effect_count(long bus_idx) {
		return (int) super.call("get_bus_effect_count", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx)});
	}

	public AudioEffect get_bus_effect(long bus_idx, long effect_idx) {
		return (AudioEffect) super.call("get_bus_effect",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Long.valueOf(effect_idx)});
	}

	public AudioEffectInstance get_bus_effect_instance(long bus_idx, long effect_idx, long channel) {
		return (AudioEffectInstance) super.call("get_bus_effect_instance", new java.lang.Object[]{
				java.lang.Long.valueOf(bus_idx), java.lang.Long.valueOf(effect_idx), java.lang.Long.valueOf(channel)});
	}

	public void swap_bus_effects(long bus_idx, long effect_idx, long by_effect_idx) {
		super.call("swap_bus_effects", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx),
				java.lang.Long.valueOf(effect_idx), java.lang.Long.valueOf(by_effect_idx)});
	}

	public void set_bus_effect_enabled(long bus_idx, long effect_idx, boolean enabled) {
		super.call("set_bus_effect_enabled", new java.lang.Object[]{java.lang.Long.valueOf(bus_idx),
				java.lang.Long.valueOf(effect_idx), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_bus_effect_enabled(long bus_idx, long effect_idx) {
		return (boolean) super.call("is_bus_effect_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Long.valueOf(effect_idx)});
	}

	public double get_bus_peak_volume_left_db(long bus_idx, long channel) {
		return (double) super.call("get_bus_peak_volume_left_db",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Long.valueOf(channel)});
	}

	public double get_bus_peak_volume_right_db(long bus_idx, long channel) {
		return (double) super.call("get_bus_peak_volume_right_db",
				new java.lang.Object[]{java.lang.Long.valueOf(bus_idx), java.lang.Long.valueOf(channel)});
	}

	public void lock() {
		super.call("lock");
	}

	public void unlock() {
		super.call("unlock");
	}

	public double[][] get_input_frames(long frames) {
		return (double[][]) super.call("get_input_frames", new java.lang.Object[]{java.lang.Long.valueOf(frames)});
	}

	public AudioBusLayout generate_bus_layout() {
		return (AudioBusLayout) super.call("generate_bus_layout");
	}

	public boolean is_stream_registered_as_sample(AudioStream stream) {
		return (boolean) super.call("is_stream_registered_as_sample",
				new java.lang.Object[]{(java.lang.Object) stream});
	}

	public void register_stream_as_sample(AudioStream stream) {
		super.call("register_stream_as_sample", new java.lang.Object[]{(java.lang.Object) stream});
	}

	public long getBus_count() {
		return (long) super.call("get_bus_count", new java.lang.Object[0]);
	}

	public void setBus_count(long value) {
		super.call("set_bus_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getOutput_device() {
		return (String) super.call("get_output_device", new java.lang.Object[0]);
	}

	public void setOutput_device(String value) {
		super.call("set_output_device", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getInput_device() {
		return (String) super.call("get_input_device", new java.lang.Object[0]);
	}

	public void setInput_device(String value) {
		super.call("set_input_device", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getPlayback_speed_scale() {
		return (double) super.call("get_playback_speed_scale", new java.lang.Object[0]);
	}

	public void setPlayback_speed_scale(double value) {
		super.call("set_playback_speed_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
