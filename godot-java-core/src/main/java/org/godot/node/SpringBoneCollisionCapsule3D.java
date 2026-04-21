package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SpringBoneCollisionCapsule3D extends SpringBoneCollision3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_radius", 1740695150L), java.util.Map.entry("get_mid_height", 1740695150L),
			java.util.Map.entry("is_inside", 36873697L), java.util.Map.entry("set_height", 373806689L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("get_height", 1740695150L),
			java.util.Map.entry("set_mid_height", 373806689L), java.util.Map.entry("set_inside", 2586408642L));

	SpringBoneCollisionCapsule3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpringBoneCollisionCapsule3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_inside() {
		return (boolean) super.call("is_inside");
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getHeight() {
		return (double) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(double value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getMid_height() {
		return (double) super.call("get_mid_height", new java.lang.Object[0]);
	}

	public void setMid_height(double value) {
		super.call("set_mid_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isInside() {
		return (boolean) super.call("is_inside", new java.lang.Object[0]);
	}

	public void setInside(boolean value) {
		super.call("set_inside", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
