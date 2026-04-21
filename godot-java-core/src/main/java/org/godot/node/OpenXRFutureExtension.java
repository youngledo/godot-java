package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class OpenXRFutureExtension extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("cancel_future", 1286410249L), java.util.Map.entry("is_active", 36873697L),
			java.util.Map.entry("register_future", 1038012256L));

	OpenXRFutureExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRFutureExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public OpenXRFutureResult register_future(long future, Callable on_success) {
		return (OpenXRFutureResult) super.call("register_future",
				new java.lang.Object[]{java.lang.Long.valueOf(future), (java.lang.Object) on_success});
	}

	public void cancel_future(long future) {
		super.call("cancel_future", new java.lang.Object[]{java.lang.Long.valueOf(future)});
	}
}
