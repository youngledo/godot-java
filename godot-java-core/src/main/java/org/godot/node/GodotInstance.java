package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class GodotInstance extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("resume", 3218959716L), java.util.Map.entry("is_started", 2240911060L),
			java.util.Map.entry("start", 2240911060L), java.util.Map.entry("iteration", 2240911060L),
			java.util.Map.entry("focus_in", 3218959716L), java.util.Map.entry("pause", 3218959716L),
			java.util.Map.entry("focus_out", 3218959716L));

	GodotInstance(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GodotInstance(long nativePointer) {
		super(nativePointer);
	}

	public boolean start() {
		return (boolean) super.call("start");
	}

	public boolean is_started() {
		return (boolean) super.call("is_started");
	}

	public boolean iteration() {
		return (boolean) super.call("iteration");
	}

	public void focus_in() {
		super.call("focus_in");
	}

	public void focus_out() {
		super.call("focus_out");
	}

	public void pause() {
		super.call("pause");
	}

	public void resume() {
		super.call("resume");
	}
}
