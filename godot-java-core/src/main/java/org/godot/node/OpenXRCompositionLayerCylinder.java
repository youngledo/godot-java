package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRCompositionLayerCylinder extends OpenXRCompositionLayer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_fallback_segments", 3905245786L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("get_aspect_ratio", 1740695150L), java.util.Map.entry("set_aspect_ratio", 373806689L),
			java.util.Map.entry("set_central_angle", 373806689L), java.util.Map.entry("set_radius", 373806689L),
			java.util.Map.entry("set_fallback_segments", 1286410249L),
			java.util.Map.entry("get_central_angle", 1740695150L));

	OpenXRCompositionLayerCylinder(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRCompositionLayerCylinder(long nativePointer) {
		super(nativePointer);
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getAspect_ratio() {
		return (double) super.call("get_aspect_ratio", new java.lang.Object[0]);
	}

	public void setAspect_ratio(double value) {
		super.call("set_aspect_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getCentral_angle() {
		return (double) super.call("get_central_angle", new java.lang.Object[0]);
	}

	public void setCentral_angle(double value) {
		super.call("set_central_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getFallback_segments() {
		return (long) super.call("get_fallback_segments", new java.lang.Object[0]);
	}

	public void setFallback_segments(long value) {
		super.call("set_fallback_segments", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
