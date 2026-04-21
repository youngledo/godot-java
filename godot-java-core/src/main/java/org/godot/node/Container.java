package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;

public class Container extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("queue_sort", 3218959716L), java.util.Map.entry("fit_child_in_rect", 1993438598L));

	Container(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Container(long nativePointer) {
		super(nativePointer);
	}

	public void queue_sort() {
		super.call("queue_sort");
	}

	public void fit_child_in_rect(Control child, Rect2 rect) {
		super.call("fit_child_in_rect", new java.lang.Object[]{(java.lang.Object) child, (java.lang.Object) rect});
	}
}
