package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class ColorPickerButton extends Button {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_editing_intensity", 36873697L), java.util.Map.entry("set_pick_color", 2920490490L),
			java.util.Map.entry("set_edit_intensity", 2586408642L), java.util.Map.entry("is_editing_alpha", 36873697L),
			java.util.Map.entry("get_pick_color", 3444240500L), java.util.Map.entry("get_picker", 331835996L),
			java.util.Map.entry("get_popup", 1322440207L), java.util.Map.entry("set_edit_alpha", 2586408642L));

	ColorPickerButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ColorPickerButton(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_editing_alpha() {
		return (boolean) super.call("is_editing_alpha");
	}

	public boolean is_editing_intensity() {
		return (boolean) super.call("is_editing_intensity");
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
}
