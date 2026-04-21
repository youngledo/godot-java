package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class AudioStreamWAV extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load_from_buffer", 4266838938L), java.util.Map.entry("set_format", 60648488L),
			java.util.Map.entry("get_format", 3151724922L), java.util.Map.entry("get_loop_mode", 393560655L),
			java.util.Map.entry("load_from_file", 4015802384L), java.util.Map.entry("get_mix_rate", 3905245786L),
			java.util.Map.entry("set_tags", 4155329257L), java.util.Map.entry("set_loop_begin", 1286410249L),
			java.util.Map.entry("set_stereo", 2586408642L), java.util.Map.entry("get_tags", 3102165223L),
			java.util.Map.entry("set_loop_mode", 2444882972L), java.util.Map.entry("is_stereo", 36873697L),
			java.util.Map.entry("get_loop_begin", 3905245786L), java.util.Map.entry("save_to_wav", 166001499L),
			java.util.Map.entry("set_mix_rate", 1286410249L), java.util.Map.entry("get_data", 2362200018L),
			java.util.Map.entry("set_loop_end", 1286410249L), java.util.Map.entry("get_loop_end", 3905245786L),
			java.util.Map.entry("set_data", 2971499966L));

	AudioStreamWAV(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamWAV(long nativePointer) {
		super(nativePointer);
	}

	public AudioStreamWAV load_from_buffer(byte[] stream_data, GodotDictionary options) {
		return (AudioStreamWAV) super.call("load_from_buffer",
				new java.lang.Object[]{(java.lang.Object) stream_data, (java.lang.Object) options});
	}

	public AudioStreamWAV load_from_file(String path, GodotDictionary options) {
		return (AudioStreamWAV) super.call("load_from_file",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) options});
	}

	public boolean is_stereo() {
		return (boolean) super.call("is_stereo");
	}

	public int save_to_wav(String path) {
		return (int) super.call("save_to_wav", new java.lang.Object[]{(java.lang.Object) path});
	}

	public byte[] getData() {
		return (byte[]) super.call("get_data", new java.lang.Object[0]);
	}

	public void setData(byte[] value) {
		super.call("set_data", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getFormat() {
		return (long) super.call("get_format", new java.lang.Object[0]);
	}

	public void setFormat(long value) {
		super.call("set_format", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLoop_mode() {
		return (long) super.call("get_loop_mode", new java.lang.Object[0]);
	}

	public void setLoop_mode(long value) {
		super.call("set_loop_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLoop_begin() {
		return (long) super.call("get_loop_begin", new java.lang.Object[0]);
	}

	public void setLoop_begin(long value) {
		super.call("set_loop_begin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLoop_end() {
		return (long) super.call("get_loop_end", new java.lang.Object[0]);
	}

	public void setLoop_end(long value) {
		super.call("set_loop_end", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMix_rate() {
		return (long) super.call("get_mix_rate", new java.lang.Object[0]);
	}

	public void setMix_rate(long value) {
		super.call("set_mix_rate", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isStereo() {
		return (boolean) super.call("is_stereo", new java.lang.Object[0]);
	}

	public void setStereo(boolean value) {
		super.call("set_stereo", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public GodotDictionary getTags() {
		return (GodotDictionary) super.call("get_tags", new java.lang.Object[0]);
	}

	public void setTags(GodotDictionary value) {
		super.call("set_tags", new java.lang.Object[]{(java.lang.Object) value});
	}
}
