package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OmniLight3D extends Light3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_shadow_mode", 121862228L), java.util.Map.entry("get_shadow_mode", 4181586331L));

	OmniLight3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OmniLight3D(long nativePointer) {
		super(nativePointer);
	}

	public double getOmni_range() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setOmni_range(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getOmni_attenuation() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setOmni_attenuation(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getOmni_shadow_mode() {
		return (long) super.call("get_shadow_mode", new java.lang.Object[0]);
	}

	public void setOmni_shadow_mode(long value) {
		super.call("set_shadow_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
