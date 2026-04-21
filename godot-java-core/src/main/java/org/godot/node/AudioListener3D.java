package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioListener3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("make_current", 3218959716L),
			java.util.Map.entry("get_listener_transform", 3229777777L),
			java.util.Map.entry("get_doppler_tracking", 550229039L), java.util.Map.entry("clear_current", 3218959716L),
			java.util.Map.entry("is_current", 36873697L), java.util.Map.entry("set_doppler_tracking", 2365921740L));

	AudioListener3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioListener3D(long nativePointer) {
		super(nativePointer);
	}

	public void make_current() {
		super.call("make_current");
	}

	public void clear_current() {
		super.call("clear_current");
	}

	public boolean is_current() {
		return (boolean) super.call("is_current");
	}

	public long getDoppler_tracking() {
		return (long) super.call("get_doppler_tracking", new java.lang.Object[0]);
	}

	public void setDoppler_tracking(long value) {
		super.call("set_doppler_tracking", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
