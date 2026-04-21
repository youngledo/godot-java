package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class OpenXRFutureResult extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("cancel_future", 3218959716L), java.util.Map.entry("get_future", 3905245786L),
			java.util.Map.entry("set_result_value", 1114965689L), java.util.Map.entry("get_status", 2023607463L),
			java.util.Map.entry("get_result_value", 1214101251L));

	OpenXRFutureResult(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRFutureResult(long nativePointer) {
		super(nativePointer);
	}

	public void cancel_future() {
		super.call("cancel_future");
	}
}
