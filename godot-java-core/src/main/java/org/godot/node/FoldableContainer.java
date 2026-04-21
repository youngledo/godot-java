package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class FoldableContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_foldable_group", 3001390597L),
			java.util.Map.entry("get_title_text_direction", 797257663L),
			java.util.Map.entry("add_title_bar_control", 1496901182L), java.util.Map.entry("set_title", 83702148L),
			java.util.Map.entry("get_foldable_group", 66499518L), java.util.Map.entry("get_title", 201670096L),
			java.util.Map.entry("remove_title_bar_control", 1496901182L),
			java.util.Map.entry("set_folded", 2586408642L),
			java.util.Map.entry("get_title_text_overrun_behavior", 3779142101L),
			java.util.Map.entry("is_folded", 36873697L), java.util.Map.entry("fold", 3218959716L),
			java.util.Map.entry("expand", 3218959716L), java.util.Map.entry("get_language", 201670096L),
			java.util.Map.entry("set_language", 83702148L),
			java.util.Map.entry("set_title_text_overrun_behavior", 1008890932L),
			java.util.Map.entry("get_title_alignment", 341400642L),
			java.util.Map.entry("set_title_position", 2276829442L),
			java.util.Map.entry("set_title_text_direction", 119160795L),
			java.util.Map.entry("get_title_position", 3028840207L),
			java.util.Map.entry("set_title_alignment", 2312603777L));

	FoldableContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FoldableContainer(long nativePointer) {
		super(nativePointer);
	}

	public void fold() {
		super.call("fold");
	}

	public void expand() {
		super.call("expand");
	}

	public boolean is_folded() {
		return (boolean) super.call("is_folded");
	}

	public void add_title_bar_control(Control control) {
		super.call("add_title_bar_control", new java.lang.Object[]{(java.lang.Object) control});
	}

	public void remove_title_bar_control(Control control) {
		super.call("remove_title_bar_control", new java.lang.Object[]{(java.lang.Object) control});
	}

	public boolean isFolded() {
		return (boolean) super.call("is_folded", new java.lang.Object[0]);
	}

	public void setFolded(boolean value) {
		super.call("set_folded", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getTitle() {
		return (String) super.call("get_title", new java.lang.Object[0]);
	}

	public void setTitle(String value) {
		super.call("set_title", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getTitle_alignment() {
		return (long) super.call("get_title_alignment", new java.lang.Object[0]);
	}

	public void setTitle_alignment(long value) {
		super.call("set_title_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTitle_position() {
		return (long) super.call("get_title_position", new java.lang.Object[0]);
	}

	public void setTitle_position(long value) {
		super.call("set_title_position", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTitle_text_overrun_behavior() {
		return (long) super.call("get_title_text_overrun_behavior", new java.lang.Object[0]);
	}

	public void setTitle_text_overrun_behavior(long value) {
		super.call("set_title_text_overrun_behavior", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public FoldableGroup getFoldable_group() {
		return (FoldableGroup) super.call("get_foldable_group", new java.lang.Object[0]);
	}

	public void setFoldable_group(FoldableGroup value) {
		super.call("set_foldable_group", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getTitle_text_direction() {
		return (long) super.call("get_title_text_direction", new java.lang.Object[0]);
	}

	public void setTitle_text_direction(long value) {
		super.call("set_title_text_direction", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public String getLanguage() {
		return (String) super.call("get_language", new java.lang.Object[0]);
	}

	public void setLanguage(String value) {
		super.call("set_language", new java.lang.Object[]{(java.lang.Object) value});
	}
}
