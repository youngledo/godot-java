package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class SegmentShape2D extends Shape2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_a", 743155724L), java.util.Map.entry("set_b", 743155724L),
			java.util.Map.entry("get_b", 3341600327L), java.util.Map.entry("get_a", 3341600327L));

	SegmentShape2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SegmentShape2D(long nativePointer) {
		super(nativePointer);
	}

	public Vector2 getA() {
		return (Vector2) super.call("get_a", new java.lang.Object[0]);
	}

	public void setA(Vector2 value) {
		super.call("set_a", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getB() {
		return (Vector2) super.call("get_b", new java.lang.Object[0]);
	}

	public void setB(Vector2 value) {
		super.call("set_b", new java.lang.Object[]{(java.lang.Object) value});
	}
}
