package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class DirectionalLight3D extends Light3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_blend_splits", 2586408642L), java.util.Map.entry("set_sky_mode", 2691194817L),
			java.util.Map.entry("get_sky_mode", 3819982774L), java.util.Map.entry("set_shadow_mode", 1261211726L),
			java.util.Map.entry("get_shadow_mode", 2765228544L),
			java.util.Map.entry("is_blend_splits_enabled", 36873697L));

	DirectionalLight3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DirectionalLight3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_blend_splits_enabled() {
		return (boolean) super.call("is_blend_splits_enabled");
	}

	public long getDirectional_shadow_mode() {
		return (long) super.call("get_shadow_mode", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_mode(long value) {
		super.call("set_shadow_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getDirectional_shadow_split_1() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_split_1(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDirectional_shadow_split_2() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_split_2(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDirectional_shadow_split_3() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_split_3(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isDirectional_shadow_blend_splits() {
		return (boolean) super.call("is_blend_splits_enabled", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_blend_splits(boolean value) {
		super.call("set_blend_splits", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getDirectional_shadow_fade_start() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_fade_start(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDirectional_shadow_max_distance() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_max_distance(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDirectional_shadow_pancake_size() {
		return (double) super.call("get_param", new java.lang.Object[0]);
	}

	public void setDirectional_shadow_pancake_size(double value) {
		super.call("set_param", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getSky_mode() {
		return (long) super.call("get_sky_mode", new java.lang.Object[0]);
	}

	public void setSky_mode(long value) {
		super.call("set_sky_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
