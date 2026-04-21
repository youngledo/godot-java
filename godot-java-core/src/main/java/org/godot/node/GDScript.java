package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GDScript extends Script {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("new", 1545262638L));

	GDScript(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GDScript(long nativePointer) {
		super(nativePointer);
	}

	public Object new_() {
		return (Object) super.call("new");
	}
}
