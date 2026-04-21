package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class BoxContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_spacer", 1326660695L), java.util.Map.entry("set_vertical", 2586408642L),
			java.util.Map.entry("set_alignment", 2456745134L), java.util.Map.entry("get_alignment", 1915476527L),
			java.util.Map.entry("is_vertical", 36873697L));

	BoxContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BoxContainer(long nativePointer) {
		super(nativePointer);
	}

	public Control add_spacer(boolean begin) {
		return (Control) super.call("add_spacer", new java.lang.Object[]{java.lang.Boolean.valueOf(begin)});
	}

	public boolean is_vertical() {
		return (boolean) super.call("is_vertical");
	}

	public long getAlignment() {
		return (long) super.call("get_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isVertical() {
		return (boolean) super.call("is_vertical", new java.lang.Object[0]);
	}

	public void setVertical(boolean value) {
		super.call("set_vertical", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
