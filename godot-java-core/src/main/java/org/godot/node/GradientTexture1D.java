package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GradientTexture1D extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_gradient", 2756054477L), java.util.Map.entry("get_gradient", 132272999L),
			java.util.Map.entry("is_using_hdr", 36873697L), java.util.Map.entry("set_width", 1286410249L),
			java.util.Map.entry("set_use_hdr", 2586408642L));

	GradientTexture1D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GradientTexture1D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_using_hdr() {
		return (boolean) super.call("is_using_hdr");
	}

	public Gradient getGradient() {
		return (Gradient) super.call("get_gradient", new java.lang.Object[0]);
	}

	public void setGradient(Gradient value) {
		super.call("set_gradient", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getWidth() {
		return (long) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(long value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_hdr() {
		return (boolean) super.call("is_using_hdr", new java.lang.Object[0]);
	}

	public void setUse_hdr(boolean value) {
		super.call("set_use_hdr", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
