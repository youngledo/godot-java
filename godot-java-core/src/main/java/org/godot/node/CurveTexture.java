package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CurveTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_texture_mode", 715756376L), java.util.Map.entry("set_texture_mode", 1321955367L),
			java.util.Map.entry("set_width", 1286410249L), java.util.Map.entry("get_curve", 2460114913L),
			java.util.Map.entry("set_curve", 270443179L));

	CurveTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CurveTexture(long nativePointer) {
		super(nativePointer);
	}

	public long getWidth() {
		return (long) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(long value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_mode() {
		return (long) super.call("get_texture_mode", new java.lang.Object[0]);
	}

	public void setTexture_mode(long value) {
		super.call("set_texture_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Curve getCurve() {
		return (Curve) super.call("get_curve", new java.lang.Object[0]);
	}

	public void setCurve(Curve value) {
		super.call("set_curve", new java.lang.Object[]{(java.lang.Object) value});
	}
}
