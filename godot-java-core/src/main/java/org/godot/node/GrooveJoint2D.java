package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GrooveJoint2D extends Joint2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_initial_offset", 373806689L),
			java.util.Map.entry("get_initial_offset", 1740695150L), java.util.Map.entry("set_length", 373806689L),
			java.util.Map.entry("get_length", 1740695150L));

	GrooveJoint2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GrooveJoint2D(long nativePointer) {
		super(nativePointer);
	}

	public double getLength() {
		return (double) super.call("get_length", new java.lang.Object[0]);
	}

	public void setLength(double value) {
		super.call("set_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getInitial_offset() {
		return (double) super.call("get_initial_offset", new java.lang.Object[0]);
	}

	public void setInitial_offset(double value) {
		super.call("set_initial_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
