package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CylinderMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_radial_segments", 3905245786L), java.util.Map.entry("is_cap_top", 36873697L),
			java.util.Map.entry("get_top_radius", 1740695150L), java.util.Map.entry("set_cap_top", 2586408642L),
			java.util.Map.entry("set_height", 373806689L), java.util.Map.entry("get_height", 1740695150L),
			java.util.Map.entry("is_cap_bottom", 36873697L), java.util.Map.entry("set_cap_bottom", 2586408642L),
			java.util.Map.entry("set_radial_segments", 1286410249L), java.util.Map.entry("set_top_radius", 373806689L),
			java.util.Map.entry("get_rings", 3905245786L), java.util.Map.entry("get_bottom_radius", 1740695150L),
			java.util.Map.entry("set_rings", 1286410249L), java.util.Map.entry("set_bottom_radius", 373806689L));

	CylinderMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CylinderMesh(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_cap_top() {
		return (boolean) super.call("is_cap_top");
	}

	public boolean is_cap_bottom() {
		return (boolean) super.call("is_cap_bottom");
	}

	public double getTop_radius() {
		return (double) super.call("get_top_radius", new java.lang.Object[0]);
	}

	public void setTop_radius(double value) {
		super.call("set_top_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBottom_radius() {
		return (double) super.call("get_bottom_radius", new java.lang.Object[0]);
	}

	public void setBottom_radius(double value) {
		super.call("set_bottom_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
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

	public boolean isCap_top() {
		return (boolean) super.call("is_cap_top", new java.lang.Object[0]);
	}

	public void setCap_top(boolean value) {
		super.call("set_cap_top", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCap_bottom() {
		return (boolean) super.call("is_cap_bottom", new java.lang.Object[0]);
	}

	public void setCap_bottom(boolean value) {
		super.call("set_cap_bottom", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
