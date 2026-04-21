package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class DampedSpringJoint2D extends Joint2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_damping", 1740695150L), java.util.Map.entry("get_rest_length", 1740695150L),
			java.util.Map.entry("set_damping", 373806689L), java.util.Map.entry("set_stiffness", 373806689L),
			java.util.Map.entry("get_stiffness", 1740695150L), java.util.Map.entry("set_rest_length", 373806689L),
			java.util.Map.entry("set_length", 373806689L), java.util.Map.entry("get_length", 1740695150L));

	DampedSpringJoint2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DampedSpringJoint2D(long nativePointer) {
		super(nativePointer);
	}

	public double getLength() {
		return (double) super.call("get_length", new java.lang.Object[0]);
	}

	public void setLength(double value) {
		super.call("set_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getRest_length() {
		return (double) super.call("get_rest_length", new java.lang.Object[0]);
	}

	public void setRest_length(double value) {
		super.call("set_rest_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getStiffness() {
		return (double) super.call("get_stiffness", new java.lang.Object[0]);
	}

	public void setStiffness(double value) {
		super.call("set_stiffness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDamping() {
		return (double) super.call("get_damping", new java.lang.Object[0]);
	}

	public void setDamping(double value) {
		super.call("set_damping", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
