package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorSpinSlider extends Range {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_label", 201670096L), java.util.Map.entry("set_control_state", 1324557109L),
			java.util.Map.entry("set_hide_slider", 2586408642L), java.util.Map.entry("get_control_state", 3406006200L),
			java.util.Map.entry("set_read_only", 2586408642L), java.util.Map.entry("set_flat", 2586408642L),
			java.util.Map.entry("set_label", 83702148L), java.util.Map.entry("set_editing_integer", 2586408642L),
			java.util.Map.entry("get_suffix", 201670096L), java.util.Map.entry("is_flat", 36873697L),
			java.util.Map.entry("is_read_only", 36873697L), java.util.Map.entry("is_hiding_slider", 36873697L),
			java.util.Map.entry("set_suffix", 83702148L), java.util.Map.entry("is_editing_integer", 36873697L));

	EditorSpinSlider(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorSpinSlider(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_read_only() {
		return (boolean) super.call("is_read_only");
	}

	public boolean is_flat() {
		return (boolean) super.call("is_flat");
	}

	public boolean is_hiding_slider() {
		return (boolean) super.call("is_hiding_slider");
	}

	public boolean is_editing_integer() {
		return (boolean) super.call("is_editing_integer");
	}

	public String getLabel() {
		return (String) super.call("get_label", new java.lang.Object[0]);
	}

	public void setLabel(String value) {
		super.call("set_label", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSuffix() {
		return (String) super.call("get_suffix", new java.lang.Object[0]);
	}

	public void setSuffix(String value) {
		super.call("set_suffix", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRead_only() {
		return (boolean) super.call("is_read_only", new java.lang.Object[0]);
	}

	public void setRead_only(boolean value) {
		super.call("set_read_only", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFlat() {
		return (boolean) super.call("is_flat", new java.lang.Object[0]);
	}

	public void setFlat(boolean value) {
		super.call("set_flat", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getControl_state() {
		return (boolean) super.call("get_control_state", new java.lang.Object[0]);
	}

	public void setControl_state(boolean value) {
		super.call("set_control_state", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isHide_slider() {
		return (boolean) super.call("is_hiding_slider", new java.lang.Object[0]);
	}

	public void setHide_slider(boolean value) {
		super.call("set_hide_slider", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEditing_integer() {
		return (boolean) super.call("is_editing_integer", new java.lang.Object[0]);
	}

	public void setEditing_integer(boolean value) {
		super.call("set_editing_integer", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
