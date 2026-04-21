package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SliderJoint3D extends Joint3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_param", 959925627L), java.util.Map.entry("set_param", 918243683L));

	SliderJoint3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SliderJoint3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_param(int param, double value) {
		super.call("set_param",
				new java.lang.Object[]{java.lang.Integer.valueOf(param), java.lang.Double.valueOf(value)});
	}

	public double get_param(int param) {
		return (double) super.call("get_param", new java.lang.Object[]{java.lang.Integer.valueOf(param)});
	}
}
