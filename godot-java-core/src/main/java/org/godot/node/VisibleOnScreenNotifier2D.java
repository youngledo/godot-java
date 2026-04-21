package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;

public class VisibleOnScreenNotifier2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_show_rect", 2586408642L), java.util.Map.entry("is_showing_rect", 36873697L),
			java.util.Map.entry("is_on_screen", 36873697L), java.util.Map.entry("get_rect", 1639390495L),
			java.util.Map.entry("set_rect", 2046264180L));

	VisibleOnScreenNotifier2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisibleOnScreenNotifier2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_showing_rect() {
		return (boolean) super.call("is_showing_rect");
	}

	public boolean is_on_screen() {
		return (boolean) super.call("is_on_screen");
	}

	public Rect2 getRect() {
		return (Rect2) super.call("get_rect", new java.lang.Object[0]);
	}

	public void setRect(Rect2 value) {
		super.call("set_rect", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isShow_rect() {
		return (boolean) super.call("is_showing_rect", new java.lang.Object[0]);
	}

	public void setShow_rect(boolean value) {
		super.call("set_show_rect", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
