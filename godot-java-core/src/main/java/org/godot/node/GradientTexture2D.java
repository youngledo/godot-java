package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class GradientTexture2D extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_gradient", 2756054477L), java.util.Map.entry("get_gradient", 132272999L),
			java.util.Map.entry("set_fill_from", 743155724L), java.util.Map.entry("is_using_hdr", 36873697L),
			java.util.Map.entry("get_fill", 1876227217L), java.util.Map.entry("set_width", 1286410249L),
			java.util.Map.entry("set_height", 1286410249L), java.util.Map.entry("set_fill_to", 743155724L),
			java.util.Map.entry("get_fill_to", 3341600327L), java.util.Map.entry("get_repeat", 3351758665L),
			java.util.Map.entry("set_fill", 3623927636L), java.util.Map.entry("set_repeat", 1357597002L),
			java.util.Map.entry("set_use_hdr", 2586408642L), java.util.Map.entry("get_fill_from", 3341600327L));

	GradientTexture2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GradientTexture2D(long nativePointer) {
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

	public long getHeight() {
		return (long) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(long value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isUse_hdr() {
		return (boolean) super.call("is_using_hdr", new java.lang.Object[0]);
	}

	public void setUse_hdr(boolean value) {
		super.call("set_use_hdr", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getFill() {
		return (long) super.call("get_fill", new java.lang.Object[0]);
	}

	public void setFill(long value) {
		super.call("set_fill", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2 getFill_from() {
		return (Vector2) super.call("get_fill_from", new java.lang.Object[0]);
	}

	public void setFill_from(Vector2 value) {
		super.call("set_fill_from", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getFill_to() {
		return (Vector2) super.call("get_fill_to", new java.lang.Object[0]);
	}

	public void setFill_to(Vector2 value) {
		super.call("set_fill_to", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getRepeat() {
		return (long) super.call("get_repeat", new java.lang.Object[0]);
	}

	public void setRepeat(long value) {
		super.call("set_repeat", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
