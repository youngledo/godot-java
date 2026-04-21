package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.math.Color;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3;

public class OpenXRCompositionLayer extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_green_swizzle", 2334776767L), java.util.Map.entry("get_border_color", 3444240500L),
			java.util.Map.entry("set_min_filter", 3653437593L), java.util.Map.entry("set_red_swizzle", 741598951L),
			java.util.Map.entry("set_use_android_surface", 2586408642L),
			java.util.Map.entry("get_enable_hole_punch", 36873697L),
			java.util.Map.entry("get_use_android_surface", 36873697L),
			java.util.Map.entry("set_blue_swizzle", 741598951L), java.util.Map.entry("set_alpha_blend", 2586408642L),
			java.util.Map.entry("get_red_swizzle", 2334776767L),
			java.util.Map.entry("get_android_surface_size", 3690982128L),
			java.util.Map.entry("set_sort_order", 1286410249L), java.util.Map.entry("get_layer_viewport", 3750751911L),
			java.util.Map.entry("set_alpha_swizzle", 741598951L), java.util.Map.entry("get_sort_order", 3905245786L),
			java.util.Map.entry("get_vertical_wrap", 2798816834L), java.util.Map.entry("set_mag_filter", 3653437593L),
			java.util.Map.entry("get_alpha_blend", 36873697L), java.util.Map.entry("get_min_filter", 845677307L),
			java.util.Map.entry("set_vertical_wrap", 15634990L), java.util.Map.entry("get_blue_swizzle", 2334776767L),
			java.util.Map.entry("set_android_surface_size", 1130785943L),
			java.util.Map.entry("set_protected_content", 2586408642L),
			java.util.Map.entry("intersects_ray", 1091262597L), java.util.Map.entry("set_horizontal_wrap", 15634990L),
			java.util.Map.entry("is_natively_supported", 36873697L),
			java.util.Map.entry("get_alpha_swizzle", 2334776767L),
			java.util.Map.entry("is_protected_content", 36873697L),
			java.util.Map.entry("get_horizontal_wrap", 2798816834L),
			java.util.Map.entry("set_mipmap_mode", 3271133183L), java.util.Map.entry("set_max_anisotropy", 373806689L),
			java.util.Map.entry("set_layer_viewport", 3888077664L),
			java.util.Map.entry("set_green_swizzle", 741598951L),
			java.util.Map.entry("get_android_surface", 3277089691L),
			java.util.Map.entry("set_enable_hole_punch", 2586408642L),
			java.util.Map.entry("set_border_color", 2920490490L), java.util.Map.entry("get_mag_filter", 845677307L),
			java.util.Map.entry("get_mipmap_mode", 3962697095L),
			java.util.Map.entry("get_max_anisotropy", 1740695150L));

	OpenXRCompositionLayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRCompositionLayer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_natively_supported() {
		return (boolean) super.call("is_natively_supported");
	}

	public boolean is_protected_content() {
		return (boolean) super.call("is_protected_content");
	}

	public Vector2 intersects_ray(Vector3 origin, Vector3 direction) {
		return (Vector2) super.call("intersects_ray",
				new java.lang.Object[]{(java.lang.Object) origin, (java.lang.Object) direction});
	}

	public GodotObject getLayer_viewport() {
		return (GodotObject) super.call("get_layer_viewport", new java.lang.Object[0]);
	}

	public void setLayer_viewport(GodotObject value) {
		super.call("set_layer_viewport", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getUse_android_surface() {
		return (boolean) super.call("get_use_android_surface", new java.lang.Object[0]);
	}

	public void setUse_android_surface(boolean value) {
		super.call("set_use_android_surface", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isProtected_content() {
		return (boolean) super.call("is_protected_content", new java.lang.Object[0]);
	}

	public void setProtected_content(boolean value) {
		super.call("set_protected_content", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2i getAndroid_surface_size() {
		return (Vector2i) super.call("get_android_surface_size", new java.lang.Object[0]);
	}

	public void setAndroid_surface_size(Vector2i value) {
		super.call("set_android_surface_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSort_order() {
		return (long) super.call("get_sort_order", new java.lang.Object[0]);
	}

	public void setSort_order(long value) {
		super.call("set_sort_order", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAlpha_blend() {
		return (boolean) super.call("get_alpha_blend", new java.lang.Object[0]);
	}

	public void setAlpha_blend(boolean value) {
		super.call("set_alpha_blend", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getEnable_hole_punch() {
		return (boolean) super.call("get_enable_hole_punch", new java.lang.Object[0]);
	}

	public void setEnable_hole_punch(boolean value) {
		super.call("set_enable_hole_punch", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSwapchain_state_min_filter() {
		return (long) super.call("get_min_filter", new java.lang.Object[0]);
	}

	public void setSwapchain_state_min_filter(long value) {
		super.call("set_min_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_mag_filter() {
		return (long) super.call("get_mag_filter", new java.lang.Object[0]);
	}

	public void setSwapchain_state_mag_filter(long value) {
		super.call("set_mag_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_mipmap_mode() {
		return (long) super.call("get_mipmap_mode", new java.lang.Object[0]);
	}

	public void setSwapchain_state_mipmap_mode(long value) {
		super.call("set_mipmap_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_horizontal_wrap() {
		return (long) super.call("get_horizontal_wrap", new java.lang.Object[0]);
	}

	public void setSwapchain_state_horizontal_wrap(long value) {
		super.call("set_horizontal_wrap", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_vertical_wrap() {
		return (long) super.call("get_vertical_wrap", new java.lang.Object[0]);
	}

	public void setSwapchain_state_vertical_wrap(long value) {
		super.call("set_vertical_wrap", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_red_swizzle() {
		return (long) super.call("get_red_swizzle", new java.lang.Object[0]);
	}

	public void setSwapchain_state_red_swizzle(long value) {
		super.call("set_red_swizzle", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_green_swizzle() {
		return (long) super.call("get_green_swizzle", new java.lang.Object[0]);
	}

	public void setSwapchain_state_green_swizzle(long value) {
		super.call("set_green_swizzle", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_blue_swizzle() {
		return (long) super.call("get_blue_swizzle", new java.lang.Object[0]);
	}

	public void setSwapchain_state_blue_swizzle(long value) {
		super.call("set_blue_swizzle", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSwapchain_state_alpha_swizzle() {
		return (long) super.call("get_alpha_swizzle", new java.lang.Object[0]);
	}

	public void setSwapchain_state_alpha_swizzle(long value) {
		super.call("set_alpha_swizzle", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSwapchain_state_max_anisotropy() {
		return (double) super.call("get_max_anisotropy", new java.lang.Object[0]);
	}

	public void setSwapchain_state_max_anisotropy(double value) {
		super.call("set_max_anisotropy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getSwapchain_state_border_color() {
		return (Color) super.call("get_border_color", new java.lang.Object[0]);
	}

	public void setSwapchain_state_border_color(Color value) {
		super.call("set_border_color", new java.lang.Object[]{(java.lang.Object) value});
	}
}
