package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRFrameSynthesisExtension extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_enabled", 36873697L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("skip_next_frame", 3218959716L),
			java.util.Map.entry("set_relax_frame_interval", 2586408642L),
			java.util.Map.entry("get_relax_frame_interval", 36873697L), java.util.Map.entry("is_available", 36873697L));

	OpenXRFrameSynthesisExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRFrameSynthesisExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_available() {
		return (boolean) super.call("is_available");
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public void skip_next_frame() {
		super.call("skip_next_frame");
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getRelax_frame_interval() {
		return (boolean) super.call("get_relax_frame_interval", new java.lang.Object[0]);
	}

	public void setRelax_frame_interval(boolean value) {
		super.call("set_relax_frame_interval", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
