package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class EditorFileDialog extends FileDialog {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_disable_overwrite_warning", 2586408642L),
			java.util.Map.entry("add_side_menu", 402368861L),
			java.util.Map.entry("is_overwrite_warning_disabled", 36873697L));

	EditorFileDialog(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorFileDialog(long nativePointer) {
		super(nativePointer);
	}

	public void add_side_menu(Control menu, String title) {
		super.call("add_side_menu", new java.lang.Object[]{(java.lang.Object) menu, (java.lang.Object) title});
	}

	public boolean is_overwrite_warning_disabled() {
		return (boolean) super.call("is_overwrite_warning_disabled");
	}

	public boolean isDisable_overwrite_warning() {
		return (boolean) super.call("is_overwrite_warning_disabled", new java.lang.Object[0]);
	}

	public void setDisable_overwrite_warning(boolean value) {
		super.call("set_disable_overwrite_warning", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
