package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamSynchronized extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_stream_count", 3905245786L), java.util.Map.entry("set_sync_stream", 111075094L),
			java.util.Map.entry("set_stream_count", 1286410249L),
			java.util.Map.entry("set_sync_stream_volume", 1602489585L),
			java.util.Map.entry("get_sync_stream", 2739380747L),
			java.util.Map.entry("get_sync_stream_volume", 2339986948L));

	AudioStreamSynchronized(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamSynchronized(long nativePointer) {
		super(nativePointer);
	}

	public void set_sync_stream(long stream_index, AudioStream audio_stream) {
		super.call("set_sync_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(stream_index), (java.lang.Object) audio_stream});
	}

	public AudioStream get_sync_stream(long stream_index) {
		return (AudioStream) super.call("get_sync_stream",
				new java.lang.Object[]{java.lang.Long.valueOf(stream_index)});
	}

	public void set_sync_stream_volume(long stream_index, double volume_db) {
		super.call("set_sync_stream_volume",
				new java.lang.Object[]{java.lang.Long.valueOf(stream_index), java.lang.Double.valueOf(volume_db)});
	}

	public double get_sync_stream_volume(long stream_index) {
		return (double) super.call("get_sync_stream_volume",
				new java.lang.Object[]{java.lang.Long.valueOf(stream_index)});
	}

	public long getStream_count() {
		return (long) super.call("get_stream_count", new java.lang.Object[0]);
	}

	public void setStream_count(long value) {
		super.call("set_stream_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
