package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SphereMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_radial_segments", 3905245786L),
			java.util.Map.entry("set_is_hemisphere", 2586408642L), java.util.Map.entry("get_is_hemisphere", 36873697L),
			java.util.Map.entry("set_radial_segments", 1286410249L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_height", 373806689L), java.util.Map.entry("set_radius", 373806689L),
			java.util.Map.entry("get_rings", 3905245786L), java.util.Map.entry("get_height", 1740695150L),
			java.util.Map.entry("set_rings", 1286410249L));

	SphereMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SphereMesh(long nativePointer) {
		super(nativePointer);
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

	public long getRadial_segments() {
		return (long) super.call("get_radial_segments", new java.lang.Object[0]);
	}

	public void setRadial_segments(long value) {
		super.call("set_radial_segments", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRings() {
		return (long) super.call("get_rings", new java.lang.Object[0]);
	}

	public void setRings(long value) {
		super.call("set_rings", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getIs_hemisphere() {
		return (boolean) super.call("get_is_hemisphere", new java.lang.Object[0]);
	}

	public void setIs_hemisphere(boolean value) {
		super.call("set_is_hemisphere", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
