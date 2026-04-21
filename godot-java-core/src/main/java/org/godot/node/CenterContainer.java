package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CenterContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_using_top_left", 36873697L), java.util.Map.entry("set_use_top_left", 2586408642L));

	CenterContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CenterContainer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_top_left() {
		return (boolean) super.call("is_using_top_left");
	}

	public boolean isUse_top_left() {
		return (boolean) super.call("is_using_top_left", new java.lang.Object[0]);
	}

	public void setUse_top_left(boolean value) {
		super.call("set_use_top_left", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
