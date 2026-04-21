package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class Mutex extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("unlock", 3218959716L), java.util.Map.entry("lock", 3218959716L),
			java.util.Map.entry("try_lock", 2240911060L));

	Mutex(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Mutex(long nativePointer) {
		super(nativePointer);
	}

	public void lock() {
		super.call("lock");
	}

	public boolean try_lock() {
		return (boolean) super.call("try_lock");
	}

	public void unlock() {
		super.call("unlock");
	}
}
