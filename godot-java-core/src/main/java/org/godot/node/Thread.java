package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;
import org.godot.core.RefCounted;

public class Thread extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_thread_safety_checks_enabled", 2586408642L),
			java.util.Map.entry("is_started", 36873697L), java.util.Map.entry("is_alive", 36873697L),
			java.util.Map.entry("wait_to_finish", 1460262497L), java.util.Map.entry("start", 1327203254L),
			java.util.Map.entry("get_id", 201670096L), java.util.Map.entry("is_main_thread", 2240911060L));

	Thread(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Thread(long nativePointer) {
		super(nativePointer);
	}

	public int start(Callable callable, int priority) {
		return (int) super.call("start",
				new java.lang.Object[]{(java.lang.Object) callable, java.lang.Integer.valueOf(priority)});
	}

	public boolean is_started() {
		return (boolean) super.call("is_started");
	}

	public boolean is_alive() {
		return (boolean) super.call("is_alive");
	}

	public Object wait_to_finish() {
		return (Object) super.call("wait_to_finish");
	}

	public boolean is_main_thread() {
		return (boolean) super.call("is_main_thread");
	}
}
