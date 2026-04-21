package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorToaster extends HBoxContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("push_toast", 1813923476L));

	EditorToaster(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorToaster(long nativePointer) {
		super(nativePointer);
	}

	public void push_toast(String message, int severity, String tooltip) {
		super.call("push_toast", new java.lang.Object[]{(java.lang.Object) message, java.lang.Integer.valueOf(severity),
				(java.lang.Object) tooltip});
	}
}
