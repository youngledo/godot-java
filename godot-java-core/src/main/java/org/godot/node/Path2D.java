package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Path2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_curve", 660369445L), java.util.Map.entry("set_curve", 659985499L));

	Path2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Path2D(long nativePointer) {
		super(nativePointer);
	}

	public Curve2D getCurve() {
		return (Curve2D) super.call("get_curve", new java.lang.Object[0]);
	}

	public void setCurve(Curve2D value) {
		super.call("set_curve", new java.lang.Object[]{(java.lang.Object) value});
	}
}
