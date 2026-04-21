package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;

public class BackBufferCopy extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_rect", 1639390495L), java.util.Map.entry("set_rect", 2046264180L),
			java.util.Map.entry("set_copy_mode", 1713538590L), java.util.Map.entry("get_copy_mode", 3271169440L));

	BackBufferCopy(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BackBufferCopy(long nativePointer) {
		super(nativePointer);
	}

	public long getCopy_mode() {
		return (long) super.call("get_copy_mode", new java.lang.Object[0]);
	}

	public void setCopy_mode(long value) {
		super.call("set_copy_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Rect2 getRect() {
		return (Rect2) super.call("get_rect", new java.lang.Object[0]);
	}

	public void setRect(Rect2 value) {
		super.call("set_rect", new java.lang.Object[]{(java.lang.Object) value});
	}
}
