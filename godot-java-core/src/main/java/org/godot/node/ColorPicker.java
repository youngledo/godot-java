package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class ColorPicker extends VBoxContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_sampler_visible", 2586408642L), java.util.Map.entry("erase_preset", 2920490490L),
			java.util.Map.entry("are_sliders_visible", 36873697L), java.util.Map.entry("set_hex_visible", 2586408642L),
			java.util.Map.entry("are_modes_visible", 36873697L),
			java.util.Map.entry("set_sliders_visible", 2586408642L),
			java.util.Map.entry("add_recent_preset", 2920490490L),
			java.util.Map.entry("is_editing_intensity", 36873697L),
			java.util.Map.entry("set_can_add_swatches", 2586408642L),
			java.util.Map.entry("set_modes_visible", 2586408642L), java.util.Map.entry("is_sampler_visible", 36873697L),
			java.util.Map.entry("set_picker_shape", 3981373861L), java.util.Map.entry("is_deferred_mode", 36873697L),
			java.util.Map.entry("is_editing_alpha", 36873697L), java.util.Map.entry("get_picker_shape", 1143229889L),
			java.util.Map.entry("get_presets", 1392750486L), java.util.Map.entry("get_pick_color", 3444240500L),
			java.util.Map.entry("are_swatches_enabled", 36873697L),
			java.util.Map.entry("set_presets_visible", 2586408642L), java.util.Map.entry("set_edit_alpha", 2586408642L),
			java.util.Map.entry("get_recent_presets", 1392750486L),
			java.util.Map.entry("erase_recent_preset", 2920490490L), java.util.Map.entry("get_color_mode", 392907674L),
			java.util.Map.entry("is_hex_visible", 36873697L), java.util.Map.entry("set_color_mode", 1579114136L),
			java.util.Map.entry("are_presets_visible", 36873697L), java.util.Map.entry("set_pick_color", 2920490490L),
			java.util.Map.entry("add_preset", 2920490490L), java.util.Map.entry("set_edit_intensity", 2586408642L),
			java.util.Map.entry("set_deferred_mode", 2586408642L));

	ColorPicker(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ColorPicker(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_deferred_mode() {
		return (boolean) super.call("is_deferred_mode");
	}

	public boolean is_editing_alpha() {
		return (boolean) super.call("is_editing_alpha");
	}

	public boolean is_editing_intensity() {
		return (boolean) super.call("is_editing_intensity");
	}

	public boolean are_swatches_enabled() {
		return (boolean) super.call("are_swatches_enabled");
	}

	public boolean are_presets_visible() {
		return (boolean) super.call("are_presets_visible");
	}

	public boolean are_modes_visible() {
		return (boolean) super.call("are_modes_visible");
	}

	public boolean is_sampler_visible() {
		return (boolean) super.call("is_sampler_visible");
	}

	public boolean are_sliders_visible() {
		return (boolean) super.call("are_sliders_visible");
	}

	public boolean is_hex_visible() {
		return (boolean) super.call("is_hex_visible");
	}

	public void add_preset(Color color) {
		super.call("add_preset", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void erase_preset(Color color) {
		super.call("erase_preset", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void add_recent_preset(Color color) {
		super.call("add_recent_preset", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void erase_recent_preset(Color color) {
		super.call("erase_recent_preset", new java.lang.Object[]{(java.lang.Object) color});
	}

	public Color getColor() {
		return (Color) super.call("get_pick_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_pick_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isEdit_alpha() {
		return (boolean) super.call("is_editing_alpha", new java.lang.Object[0]);
	}

	public void setEdit_alpha(boolean value) {
		super.call("set_edit_alpha", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEdit_intensity() {
		return (boolean) super.call("is_editing_intensity", new java.lang.Object[0]);
	}

	public void setEdit_intensity(boolean value) {
		super.call("set_edit_intensity", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getColor_mode() {
		return (long) super.call("get_color_mode", new java.lang.Object[0]);
	}

	public void setColor_mode(long value) {
		super.call("set_color_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isDeferred_mode() {
		return (boolean) super.call("is_deferred_mode", new java.lang.Object[0]);
	}

	public void setDeferred_mode(boolean value) {
		super.call("set_deferred_mode", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getPicker_shape() {
		return (long) super.call("get_picker_shape", new java.lang.Object[0]);
	}

	public void setPicker_shape(long value) {
		super.call("set_picker_shape", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getCan_add_swatches() {
		return (boolean) super.call("are_swatches_enabled", new java.lang.Object[0]);
	}

	public void setCan_add_swatches(boolean value) {
		super.call("set_can_add_swatches", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSampler_visible() {
		return (boolean) super.call("is_sampler_visible", new java.lang.Object[0]);
	}

	public void setSampler_visible(boolean value) {
		super.call("set_sampler_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getColor_modes_visible() {
		return (boolean) super.call("are_modes_visible", new java.lang.Object[0]);
	}

	public void setColor_modes_visible(boolean value) {
		super.call("set_modes_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getSliders_visible() {
		return (boolean) super.call("are_sliders_visible", new java.lang.Object[0]);
	}

	public void setSliders_visible(boolean value) {
		super.call("set_sliders_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHex_visible() {
		return (boolean) super.call("is_hex_visible", new java.lang.Object[0]);
	}

	public void setHex_visible(boolean value) {
		super.call("set_hex_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getPresets_visible() {
		return (boolean) super.call("are_presets_visible", new java.lang.Object[0]);
	}

	public void setPresets_visible(boolean value) {
		super.call("set_presets_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
