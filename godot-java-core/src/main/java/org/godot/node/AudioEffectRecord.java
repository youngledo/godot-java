package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectRecord extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_recording", 2964110865L), java.util.Map.entry("set_format", 60648488L),
			java.util.Map.entry("get_format", 3151724922L), java.util.Map.entry("is_recording_active", 36873697L),
			java.util.Map.entry("set_recording_active", 2586408642L));

	AudioEffectRecord(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectRecord(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_recording_active() {
		return (boolean) super.call("is_recording_active");
	}

	public long getFormat() {
		return (long) super.call("get_format", new java.lang.Object[0]);
	}

	public void setFormat(long value) {
		super.call("set_format", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
