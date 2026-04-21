package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class MovieWriter extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("add_writer", 4023702871L));

	MovieWriter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MovieWriter(long nativePointer) {
		super(nativePointer);
	}

	public void add_writer(MovieWriter writer) {
		super.call("add_writer", new java.lang.Object[]{(java.lang.Object) writer});
	}
}
