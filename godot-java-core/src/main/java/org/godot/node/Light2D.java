package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class Light2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_shadow_filter", 1973619177L),
			java.util.Map.entry("set_item_shadow_cull_mask", 1286410249L),
			java.util.Map.entry("set_shadow_enabled", 2586408642L), java.util.Map.entry("get_blend_mode", 936255250L),
			java.util.Map.entry("set_energy", 373806689L), java.util.Map.entry("get_energy", 1740695150L),
			java.util.Map.entry("set_height", 373806689L), java.util.Map.entry("set_editor_only", 2586408642L),
			java.util.Map.entry("set_blend_mode", 2916638796L), java.util.Map.entry("get_height", 1740695150L),
			java.util.Map.entry("get_color", 3444240500L), java.util.Map.entry("is_enabled", 36873697L),
			java.util.Map.entry("set_z_range_max", 1286410249L),
			java.util.Map.entry("get_layer_range_min", 3905245786L),
			java.util.Map.entry("get_shadow_color", 3444240500L), java.util.Map.entry("set_shadow_filter", 3209356555L),
			java.util.Map.entry("set_layer_range_min", 1286410249L), java.util.Map.entry("is_editor_only", 36873697L),
			java.util.Map.entry("set_shadow_color", 2920490490L), java.util.Map.entry("get_z_range_min", 3905245786L),
			java.util.Map.entry("set_color", 2920490490L), java.util.Map.entry("get_layer_range_max", 3905245786L),
			java.util.Map.entry("set_item_cull_mask", 1286410249L), java.util.Map.entry("is_shadow_enabled", 36873697L),
			java.util.Map.entry("get_item_cull_mask", 3905245786L), java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("get_shadow_smooth", 1740695150L),
			java.util.Map.entry("set_layer_range_max", 1286410249L),
			java.util.Map.entry("get_item_shadow_cull_mask", 3905245786L),
			java.util.Map.entry("set_z_range_min", 1286410249L), java.util.Map.entry("get_z_range_max", 3905245786L),
			java.util.Map.entry("set_shadow_smooth", 373806689L));

	Light2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Light2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public boolean is_editor_only() {
		return (boolean) super.call("is_editor_only");
	}

	public boolean is_shadow_enabled() {
		return (boolean) super.call("is_shadow_enabled");
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEditor_only() {
		return (boolean) super.call("is_editor_only", new java.lang.Object[0]);
	}

	public void setEditor_only(boolean value) {
		super.call("set_editor_only", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getEnergy() {
		return (double) super.call("get_energy", new java.lang.Object[0]);
	}

	public void setEnergy(double value) {
		super.call("set_energy", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getBlend_mode() {
		return (long) super.call("get_blend_mode", new java.lang.Object[0]);
	}

	public void setBlend_mode(long value) {
		super.call("set_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRange_z_min() {
		return (long) super.call("get_z_range_min", new java.lang.Object[0]);
	}

	public void setRange_z_min(long value) {
		super.call("set_z_range_min", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRange_z_max() {
		return (long) super.call("get_z_range_max", new java.lang.Object[0]);
	}

	public void setRange_z_max(long value) {
		super.call("set_z_range_max", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRange_layer_min() {
		return (long) super.call("get_layer_range_min", new java.lang.Object[0]);
	}

	public void setRange_layer_min(long value) {
		super.call("set_layer_range_min", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRange_layer_max() {
		return (long) super.call("get_layer_range_max", new java.lang.Object[0]);
	}

	public void setRange_layer_max(long value) {
		super.call("set_layer_range_max", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRange_item_cull_mask() {
		return (long) super.call("get_item_cull_mask", new java.lang.Object[0]);
	}

	public void setRange_item_cull_mask(long value) {
		super.call("set_item_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isShadow_enabled() {
		return (boolean) super.call("is_shadow_enabled", new java.lang.Object[0]);
	}

	public void setShadow_enabled(boolean value) {
		super.call("set_shadow_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getShadow_color() {
		return (Color) super.call("get_shadow_color", new java.lang.Object[0]);
	}

	public void setShadow_color(Color value) {
		super.call("set_shadow_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getShadow_filter() {
		return (long) super.call("get_shadow_filter", new java.lang.Object[0]);
	}

	public void setShadow_filter(long value) {
		super.call("set_shadow_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getShadow_filter_smooth() {
		return (double) super.call("get_shadow_smooth", new java.lang.Object[0]);
	}

	public void setShadow_filter_smooth(double value) {
		super.call("set_shadow_smooth", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getShadow_item_cull_mask() {
		return (long) super.call("get_item_shadow_cull_mask", new java.lang.Object[0]);
	}

	public void setShadow_item_cull_mask(long value) {
		super.call("set_item_shadow_cull_mask", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
