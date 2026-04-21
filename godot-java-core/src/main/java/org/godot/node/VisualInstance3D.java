package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualInstance3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_layer_mask_value", 1116898809L), java.util.Map.entry("get_aabb", 1068685055L),
			java.util.Map.entry("get_base", 2944877500L), java.util.Map.entry("set_layer_mask_value", 300928843L),
			java.util.Map.entry("set_layer_mask", 1286410249L), java.util.Map.entry("get_sorting_offset", 1740695150L),
			java.util.Map.entry("set_base", 2722037293L), java.util.Map.entry("get_instance", 2944877500L),
			java.util.Map.entry("is_sorting_use_aabb_center", 36873697L),
			java.util.Map.entry("set_sorting_offset", 373806689L), java.util.Map.entry("get_layer_mask", 3905245786L),
			java.util.Map.entry("set_sorting_use_aabb_center", 2586408642L));

	VisualInstance3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualInstance3D(long nativePointer) {
		super(nativePointer);
	}

	public void set_layer_mask_value(long layer_number, boolean value) {
		super.call("set_layer_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number), java.lang.Boolean.valueOf(value)});
	}

	public boolean get_layer_mask_value(long layer_number) {
		return (boolean) super.call("get_layer_mask_value",
				new java.lang.Object[]{java.lang.Long.valueOf(layer_number)});
	}

	public boolean is_sorting_use_aabb_center() {
		return (boolean) super.call("is_sorting_use_aabb_center");
	}

	public long getLayers() {
		return (long) super.call("get_layer_mask", new java.lang.Object[0]);
	}

	public void setLayers(long value) {
		super.call("set_layer_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getSorting_offset() {
		return (double) super.call("get_sorting_offset", new java.lang.Object[0]);
	}

	public void setSorting_offset(double value) {
		super.call("set_sorting_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isSorting_use_aabb_center() {
		return (boolean) super.call("is_sorting_use_aabb_center", new java.lang.Object[0]);
	}

	public void setSorting_use_aabb_center(boolean value) {
		super.call("set_sorting_use_aabb_center", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
