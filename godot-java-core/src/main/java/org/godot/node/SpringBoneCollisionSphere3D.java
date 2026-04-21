package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SpringBoneCollisionSphere3D extends SpringBoneCollision3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_radius", 1740695150L), java.util.Map.entry("is_inside", 36873697L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("set_inside", 2586408642L));

	SpringBoneCollisionSphere3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpringBoneCollisionSphere3D(long nativePointer) {
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

	public boolean isInside() {
		return (boolean) super.call("is_inside", new java.lang.Object[0]);
	}

	public void setInside(boolean value) {
		super.call("set_inside", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
