package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRCompositionLayerEquirect extends OpenXRCompositionLayer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_upper_vertical_angle", 373806689L),
			java.util.Map.entry("get_upper_vertical_angle", 1740695150L),
			java.util.Map.entry("get_lower_vertical_angle", 1740695150L),
			java.util.Map.entry("set_lower_vertical_angle", 373806689L),
			java.util.Map.entry("get_fallback_segments", 3905245786L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_radius", 373806689L), java.util.Map.entry("set_fallback_segments", 1286410249L),
			java.util.Map.entry("set_central_horizontal_angle", 373806689L),
			java.util.Map.entry("get_central_horizontal_angle", 1740695150L));

	OpenXRCompositionLayerEquirect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRCompositionLayerEquirect(long nativePointer) {
		super(nativePointer);
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCentral_horizontal_angle() {
		return (double) super.call("get_central_horizontal_angle", new java.lang.Object[0]);
	}

	public void setCentral_horizontal_angle(double value) {
		super.call("set_central_horizontal_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getUpper_vertical_angle() {
		return (double) super.call("get_upper_vertical_angle", new java.lang.Object[0]);
	}

	public void setUpper_vertical_angle(double value) {
		super.call("set_upper_vertical_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getLower_vertical_angle() {
		return (double) super.call("get_lower_vertical_angle", new java.lang.Object[0]);
	}

	public void setLower_vertical_angle(double value) {
		super.call("set_lower_vertical_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getFallback_segments() {
		return (long) super.call("get_fallback_segments", new java.lang.Object[0]);
	}

	public void setFallback_segments(long value) {
		super.call("set_fallback_segments", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
