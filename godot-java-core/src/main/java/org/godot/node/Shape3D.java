package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Shape3D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_margin", 1740695150L), java.util.Map.entry("set_margin", 373806689L),
			java.util.Map.entry("get_debug_mesh", 1605880883L),
			java.util.Map.entry("set_custom_solver_bias", 373806689L),
			java.util.Map.entry("get_custom_solver_bias", 1740695150L));

	Shape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Shape3D(long nativePointer) {
		super(nativePointer);
	}

	public double getCustom_solver_bias() {
		return (double) super.call("get_custom_solver_bias", new java.lang.Object[0]);
	}

	public void setCustom_solver_bias(double value) {
		super.call("set_custom_solver_bias", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMargin() {
		return (double) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(double value) {
		super.call("set_margin", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
