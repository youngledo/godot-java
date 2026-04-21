package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SubViewportContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_stretch", 2586408642L),
			java.util.Map.entry("is_mouse_target_enabled", 2240911060L),
			java.util.Map.entry("get_stretch_shrink", 3905245786L),
			java.util.Map.entry("is_stretch_enabled", 36873697L),
			java.util.Map.entry("set_stretch_shrink", 1286410249L),
			java.util.Map.entry("set_mouse_target", 2586408642L));

	SubViewportContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SubViewportContainer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_stretch_enabled() {
		return (boolean) super.call("is_stretch_enabled");
	}

	public boolean is_mouse_target_enabled() {
		return (boolean) super.call("is_mouse_target_enabled");
	}

	public boolean isStretch() {
		return (boolean) super.call("is_stretch_enabled", new java.lang.Object[0]);
	}

	public void setStretch(boolean value) {
		super.call("set_stretch", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getStretch_shrink() {
		return (long) super.call("get_stretch_shrink", new java.lang.Object[0]);
	}

	public void setStretch_shrink(long value) {
		super.call("set_stretch_shrink", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isMouse_target() {
		return (boolean) super.call("is_mouse_target_enabled", new java.lang.Object[0]);
	}

	public void setMouse_target(boolean value) {
		super.call("set_mouse_target", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
