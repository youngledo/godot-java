package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class Semaphore extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("wait", 3218959716L), java.util.Map.entry("try_wait", 2240911060L),
			java.util.Map.entry("post", 1667783136L));

	Semaphore(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Semaphore(long nativePointer) {
		super(nativePointer);
	}

	public void wait_() {
		super.call("wait");
	}

	public boolean try_wait() {
		return (boolean) super.call("try_wait");
	}

	public void post(long count) {
		super.call("post", new java.lang.Object[]{java.lang.Long.valueOf(count)});
	}
}
