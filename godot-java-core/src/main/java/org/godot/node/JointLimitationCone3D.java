package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class JointLimitationCone3D extends JointLimitation3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_angle", 1740695150L), java.util.Map.entry("set_angle", 373806689L));

	JointLimitationCone3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JointLimitationCone3D(long nativePointer) {
		super(nativePointer);
	}

	public double getAngle() {
		return (double) super.call("get_angle", new java.lang.Object[0]);
	}

	public void setAngle(double value) {
		super.call("set_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
