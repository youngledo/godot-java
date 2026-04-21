package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GLTFTextureSampler extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_wrap_s", 1286410249L), java.util.Map.entry("get_wrap_t", 3905245786L),
			java.util.Map.entry("set_min_filter", 1286410249L), java.util.Map.entry("set_mag_filter", 1286410249L),
			java.util.Map.entry("get_min_filter", 3905245786L), java.util.Map.entry("set_wrap_t", 1286410249L),
			java.util.Map.entry("get_mag_filter", 3905245786L), java.util.Map.entry("get_wrap_s", 3905245786L));

	GLTFTextureSampler(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFTextureSampler(long nativePointer) {
		super(nativePointer);
	}

	public long getMag_filter() {
		return (long) super.call("get_mag_filter", new java.lang.Object[0]);
	}

	public void setMag_filter(long value) {
		super.call("set_mag_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMin_filter() {
		return (long) super.call("get_min_filter", new java.lang.Object[0]);
	}

	public void setMin_filter(long value) {
		super.call("set_min_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getWrap_s() {
		return (long) super.call("get_wrap_s", new java.lang.Object[0]);
	}

	public void setWrap_s(long value) {
		super.call("set_wrap_s", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getWrap_t() {
		return (long) super.call("get_wrap_t", new java.lang.Object[0]);
	}

	public void setWrap_t(long value) {
		super.call("set_wrap_t", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
