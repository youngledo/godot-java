package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDTextureView extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_swizzle_r", 3833362581L), java.util.Map.entry("set_swizzle_b", 3833362581L),
			java.util.Map.entry("set_swizzle_a", 3833362581L), java.util.Map.entry("set_format_override", 565531219L),
			java.util.Map.entry("get_swizzle_a", 4150792614L), java.util.Map.entry("get_format_override", 2235804183L),
			java.util.Map.entry("get_swizzle_r", 4150792614L), java.util.Map.entry("get_swizzle_b", 4150792614L),
			java.util.Map.entry("set_swizzle_g", 3833362581L), java.util.Map.entry("get_swizzle_g", 4150792614L));

	RDTextureView(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDTextureView(long nativePointer) {
		super(nativePointer);
	}

	public long getFormat_override() {
		return (long) super.call("get_format_override", new java.lang.Object[0]);
	}

	public void setFormat_override(long value) {
		super.call("set_format_override", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwizzle_r() {
		return (long) super.call("get_swizzle_r", new java.lang.Object[0]);
	}

	public void setSwizzle_r(long value) {
		super.call("set_swizzle_r", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwizzle_g() {
		return (long) super.call("get_swizzle_g", new java.lang.Object[0]);
	}

	public void setSwizzle_g(long value) {
		super.call("set_swizzle_g", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwizzle_b() {
		return (long) super.call("get_swizzle_b", new java.lang.Object[0]);
	}

	public void setSwizzle_b(long value) {
		super.call("set_swizzle_b", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwizzle_a() {
		return (long) super.call("get_swizzle_a", new java.lang.Object[0]);
	}

	public void setSwizzle_a(long value) {
		super.call("set_swizzle_a", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
