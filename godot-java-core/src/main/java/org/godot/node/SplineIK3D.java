package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SplineIK3D extends ChainIK3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_path_3d", 408788394L), java.util.Map.entry("set_tilt_fade_in", 3937882851L),
			java.util.Map.entry("set_tilt_enabled", 300928843L), java.util.Map.entry("get_tilt_fade_in", 923996154L),
			java.util.Map.entry("get_tilt_fade_out", 923996154L), java.util.Map.entry("set_path_3d", 2761262315L),
			java.util.Map.entry("is_tilt_enabled", 1116898809L), java.util.Map.entry("set_tilt_fade_out", 3937882851L));

	SplineIK3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SplineIK3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_path_3d(long index, String path_3d) {
		super.call("set_path_3d", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) path_3d});
	}

	public String get_path_3d(long index) {
		return (String) super.call("get_path_3d", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_tilt_enabled(long index, boolean enabled) {
		super.call("set_tilt_enabled",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Boolean.valueOf(enabled)});
	}

	public boolean is_tilt_enabled(long index) {
		return (boolean) super.call("is_tilt_enabled", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_tilt_fade_in(long index, long size) {
		super.call("set_tilt_fade_in",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(size)});
	}

	public int get_tilt_fade_in(long index) {
		return (int) super.call("get_tilt_fade_in", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void set_tilt_fade_out(long index, long size) {
		super.call("set_tilt_fade_out",
				new java.lang.Object[]{java.lang.Long.valueOf(index), java.lang.Long.valueOf(size)});
	}

	public int get_tilt_fade_out(long index) {
		return (int) super.call("get_tilt_fade_out", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public long getSetting_count() {
		return (long) super.call("get_setting_count", new java.lang.Object[0]);
	}

	public void setSetting_count(long value) {
		super.call("set_setting_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
