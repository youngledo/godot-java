package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SpinBox extends Range {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_prefix", 201670096L), java.util.Map.entry("set_horizontal_alignment", 2312603777L),
			java.util.Map.entry("set_prefix", 83702148L), java.util.Map.entry("set_select_all_on_focus", 2586408642L),
			java.util.Map.entry("apply", 3218959716L), java.util.Map.entry("set_update_on_text_changed", 2586408642L),
			java.util.Map.entry("get_custom_arrow_step", 1740695150L),
			java.util.Map.entry("is_custom_arrow_rounding", 36873697L), java.util.Map.entry("is_editable", 36873697L),
			java.util.Map.entry("get_update_on_text_changed", 36873697L),
			java.util.Map.entry("is_select_all_on_focus", 36873697L), java.util.Map.entry("set_editable", 2586408642L),
			java.util.Map.entry("set_custom_arrow_round", 2586408642L),
			java.util.Map.entry("get_line_edit", 4071694264L), java.util.Map.entry("get_suffix", 201670096L),
			java.util.Map.entry("get_horizontal_alignment", 341400642L), java.util.Map.entry("set_suffix", 83702148L),
			java.util.Map.entry("set_custom_arrow_step", 373806689L));

	SpinBox(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SpinBox(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_custom_arrow_rounding() {
		return (boolean) super.call("is_custom_arrow_rounding");
	}

	public boolean is_editable() {
		return (boolean) super.call("is_editable");
	}

	public boolean is_select_all_on_focus() {
		return (boolean) super.call("is_select_all_on_focus");
	}

	public void apply() {
		super.call("apply");
	}

	public long getAlignment() {
		return (long) super.call("get_horizontal_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_horizontal_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isEditable() {
		return (boolean) super.call("is_editable", new java.lang.Object[0]);
	}

	public void setEditable(boolean value) {
		super.call("set_editable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getUpdate_on_text_changed() {
		return (boolean) super.call("get_update_on_text_changed", new java.lang.Object[0]);
	}

	public void setUpdate_on_text_changed(boolean value) {
		super.call("set_update_on_text_changed", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getPrefix() {
		return (String) super.call("get_prefix", new java.lang.Object[0]);
	}

	public void setPrefix(String value) {
		super.call("set_prefix", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSuffix() {
		return (String) super.call("get_suffix", new java.lang.Object[0]);
	}

	public void setSuffix(String value) {
		super.call("set_suffix", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getCustom_arrow_step() {
		return (double) super.call("get_custom_arrow_step", new java.lang.Object[0]);
	}

	public void setCustom_arrow_step(double value) {
		super.call("set_custom_arrow_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isCustom_arrow_round() {
		return (boolean) super.call("is_custom_arrow_rounding", new java.lang.Object[0]);
	}

	public void setCustom_arrow_round(boolean value) {
		super.call("set_custom_arrow_round", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSelect_all_on_focus() {
		return (boolean) super.call("is_select_all_on_focus", new java.lang.Object[0]);
	}

	public void setSelect_all_on_focus(boolean value) {
		super.call("set_select_all_on_focus", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
