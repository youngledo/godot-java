package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ProgressBar extends Range {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_show_percentage", 2586408642L),
			java.util.Map.entry("is_percentage_shown", 36873697L),
			java.util.Map.entry("set_editor_preview_indeterminate", 2586408642L),
			java.util.Map.entry("is_indeterminate", 36873697L),
			java.util.Map.entry("is_editor_preview_indeterminate_enabled", 36873697L),
			java.util.Map.entry("set_fill_mode", 1286410249L), java.util.Map.entry("set_indeterminate", 2586408642L),
			java.util.Map.entry("get_fill_mode", 2455072627L));

	ProgressBar(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ProgressBar(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_percentage_shown() {
		return (boolean) super.call("is_percentage_shown");
	}

	public boolean is_indeterminate() {
		return (boolean) super.call("is_indeterminate");
	}

	public boolean is_editor_preview_indeterminate_enabled() {
		return (boolean) super.call("is_editor_preview_indeterminate_enabled");
	}

	public long getFill_mode() {
		return (long) super.call("get_fill_mode", new java.lang.Object[0]);
	}

	public void setFill_mode(long value) {
		super.call("set_fill_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isShow_percentage() {
		return (boolean) super.call("is_percentage_shown", new java.lang.Object[0]);
	}

	public void setShow_percentage(boolean value) {
		super.call("set_show_percentage", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isIndeterminate() {
		return (boolean) super.call("is_indeterminate", new java.lang.Object[0]);
	}

	public void setIndeterminate(boolean value) {
		super.call("set_indeterminate", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isEditor_preview_indeterminate() {
		return (boolean) super.call("is_editor_preview_indeterminate_enabled", new java.lang.Object[0]);
	}

	public void setEditor_preview_indeterminate(boolean value) {
		super.call("set_editor_preview_indeterminate", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
