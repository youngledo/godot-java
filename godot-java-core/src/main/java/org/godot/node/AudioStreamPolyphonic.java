package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioStreamPolyphonic extends AudioStream {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_polyphony", 1286410249L), java.util.Map.entry("get_polyphony", 3905245786L));

	AudioStreamPolyphonic(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPolyphonic(long nativePointer) {
		super(nativePointer);
	}

	public long getPolyphony() {
		return (long) super.call("get_polyphony", new java.lang.Object[0]);
	}

	public void setPolyphony(long value) {
		super.call("set_polyphony", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
