package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CurveXYZTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_curve_x", 2460114913L), java.util.Map.entry("set_width", 1286410249L),
			java.util.Map.entry("set_curve_z", 270443179L), java.util.Map.entry("set_curve_y", 270443179L),
			java.util.Map.entry("get_curve_z", 2460114913L), java.util.Map.entry("get_curve_y", 2460114913L),
			java.util.Map.entry("set_curve_x", 270443179L));

	CurveXYZTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CurveXYZTexture(long nativePointer) {
		super(nativePointer);
	}

	public long getWidth() {
		return (long) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(long value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Curve getCurve_x() {
		return (Curve) super.call("get_curve_x", new java.lang.Object[0]);
	}

	public void setCurve_x(Curve value) {
		super.call("set_curve_x", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Curve getCurve_y() {
		return (Curve) super.call("get_curve_y", new java.lang.Object[0]);
	}

	public void setCurve_y(Curve value) {
		super.call("set_curve_y", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Curve getCurve_z() {
		return (Curve) super.call("get_curve_z", new java.lang.Object[0]);
	}

	public void setCurve_z(Curve value) {
		super.call("set_curve_z", new java.lang.Object[]{(java.lang.Object) value});
	}
}
