package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioListener2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("make_current", 3218959716L), java.util.Map.entry("clear_current", 3218959716L),
			java.util.Map.entry("is_current", 36873697L));

	AudioListener2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioListener2D(long nativePointer) {
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
}
