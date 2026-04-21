package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRAndroidThreadSettingsExtension extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_application_thread_type", 1558751158L));

	OpenXRAndroidThreadSettingsExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRAndroidThreadSettingsExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean set_application_thread_type(int thread_type, long thread_id) {
		return (boolean) super.call("set_application_thread_type",
				new java.lang.Object[]{java.lang.Integer.valueOf(thread_type), java.lang.Long.valueOf(thread_id)});
	}
}
