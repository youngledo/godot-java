package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class OpenXRExtensionWrapper extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_openxr_api", 1637791613L),
			java.util.Map.entry("register_extension_wrapper", 3218959716L));

	OpenXRExtensionWrapper(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRExtensionWrapper(long nativePointer) {
		super(nativePointer);
	}

	public void register_extension_wrapper() {
		super.call("register_extension_wrapper");
	}
}
