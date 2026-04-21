package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TubeTrailMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_cap_top", 36873697L), java.util.Map.entry("get_section_length", 1740695150L),
			java.util.Map.entry("set_cap_top", 2586408642L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("get_radial_steps", 3905245786L),
			java.util.Map.entry("set_radial_steps", 1286410249L), java.util.Map.entry("is_cap_bottom", 36873697L),
			java.util.Map.entry("set_cap_bottom", 2586408642L), java.util.Map.entry("get_sections", 3905245786L),
			java.util.Map.entry("set_section_length", 373806689L),
			java.util.Map.entry("set_section_rings", 1286410249L), java.util.Map.entry("get_curve", 2460114913L),
			java.util.Map.entry("set_sections", 1286410249L), java.util.Map.entry("get_section_rings", 3905245786L),
			java.util.Map.entry("set_curve", 270443179L));

	TubeTrailMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TubeTrailMesh(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_cap_top() {
		return (boolean) super.call("is_cap_top");
	}

	public boolean is_cap_bottom() {
		return (boolean) super.call("is_cap_bottom");
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getRadial_steps() {
		return (long) super.call("get_radial_steps", new java.lang.Object[0]);
	}

	public void setRadial_steps(long value) {
		super.call("set_radial_steps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSections() {
		return (long) super.call("get_sections", new java.lang.Object[0]);
	}

	public void setSections(long value) {
		super.call("set_sections", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSection_length() {
		return (double) super.call("get_section_length", new java.lang.Object[0]);
	}

	public void setSection_length(double value) {
		super.call("set_section_length", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getSection_rings() {
		return (long) super.call("get_section_rings", new java.lang.Object[0]);
	}

	public void setSection_rings(long value) {
		super.call("set_section_rings", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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

	public Curve getCurve() {
		return (Curve) super.call("get_curve", new java.lang.Object[0]);
	}

	public void setCurve(Curve value) {
		super.call("set_curve", new java.lang.Object[]{(java.lang.Object) value});
	}
}
