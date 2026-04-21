package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class RibbonTrailMesh extends PrimitiveMesh {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 373806689L), java.util.Map.entry("set_section_segments", 1286410249L),
			java.util.Map.entry("get_section_length", 1740695150L), java.util.Map.entry("get_sections", 3905245786L),
			java.util.Map.entry("set_section_length", 373806689L), java.util.Map.entry("get_size", 1740695150L),
			java.util.Map.entry("get_shape", 1317484155L), java.util.Map.entry("get_section_segments", 3905245786L),
			java.util.Map.entry("set_shape", 1684440262L), java.util.Map.entry("get_curve", 2460114913L),
			java.util.Map.entry("set_sections", 1286410249L), java.util.Map.entry("set_curve", 270443179L));

	RibbonTrailMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RibbonTrailMesh(long nativePointer) {
		super(nativePointer);
	}

	public long getShape() {
		return (long) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(long value) {
		super.call("set_shape", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSize() {
		return (double) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(double value) {
		super.call("set_size", new java.lang.Object[]{java.lang.Double.valueOf(value)});
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

	public long getSection_segments() {
		return (long) super.call("get_section_segments", new java.lang.Object[0]);
	}

	public void setSection_segments(long value) {
		super.call("set_section_segments", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Curve getCurve() {
		return (Curve) super.call("get_curve", new java.lang.Object[0]);
	}

	public void setCurve(Curve value) {
		super.call("set_curve", new java.lang.Object[]{(java.lang.Object) value});
	}
}
