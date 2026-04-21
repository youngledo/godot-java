package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;

public class EditorProperty extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_edited_property", 2002593661L),
			java.util.Map.entry("set_label_reference", 1496901182L),
			java.util.Map.entry("get_edited_object", 2050059866L), java.util.Map.entry("select", 1025054187L),
			java.util.Map.entry("set_deletable", 2586408642L), java.util.Map.entry("set_name_split_ratio", 373806689L),
			java.util.Map.entry("is_draw_label", 36873697L), java.util.Map.entry("is_deletable", 36873697L),
			java.util.Map.entry("set_checked", 2586408642L), java.util.Map.entry("update_property", 3218959716L),
			java.util.Map.entry("set_bottom_editor", 1496901182L), java.util.Map.entry("set_selectable", 2586408642L),
			java.util.Map.entry("set_object_and_property", 4157606280L), java.util.Map.entry("is_read_only", 36873697L),
			java.util.Map.entry("set_use_folding", 2586408642L), java.util.Map.entry("set_draw_label", 2586408642L),
			java.util.Map.entry("is_draw_background", 36873697L), java.util.Map.entry("set_checkable", 2586408642L),
			java.util.Map.entry("is_keying", 36873697L), java.util.Map.entry("is_draw_warning", 36873697L),
			java.util.Map.entry("get_label", 201670096L), java.util.Map.entry("is_selected", 36873697L),
			java.util.Map.entry("get_name_split_ratio", 1740695150L), java.util.Map.entry("set_read_only", 2586408642L),
			java.util.Map.entry("is_checkable", 36873697L), java.util.Map.entry("add_focusable", 1496901182L),
			java.util.Map.entry("is_using_folding", 36873697L), java.util.Map.entry("is_selectable", 36873697L),
			java.util.Map.entry("set_label", 83702148L), java.util.Map.entry("set_keying", 2586408642L),
			java.util.Map.entry("set_draw_warning", 2586408642L),
			java.util.Map.entry("set_draw_background", 2586408642L), java.util.Map.entry("deselect", 3218959716L),
			java.util.Map.entry("is_checked", 36873697L), java.util.Map.entry("emit_changed", 1822500399L));

	EditorProperty(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorProperty(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_read_only() {
		return (boolean) super.call("is_read_only");
	}

	public boolean is_draw_label() {
		return (boolean) super.call("is_draw_label");
	}

	public boolean is_draw_background() {
		return (boolean) super.call("is_draw_background");
	}

	public boolean is_checkable() {
		return (boolean) super.call("is_checkable");
	}

	public boolean is_checked() {
		return (boolean) super.call("is_checked");
	}

	public boolean is_draw_warning() {
		return (boolean) super.call("is_draw_warning");
	}

	public boolean is_keying() {
		return (boolean) super.call("is_keying");
	}

	public boolean is_deletable() {
		return (boolean) super.call("is_deletable");
	}

	public void update_property() {
		super.call("update_property");
	}

	public void add_focusable(Control control) {
		super.call("add_focusable", new java.lang.Object[]{(java.lang.Object) control});
	}

	public boolean is_selectable() {
		return (boolean) super.call("is_selectable");
	}

	public boolean is_using_folding() {
		return (boolean) super.call("is_using_folding");
	}

	public void deselect() {
		super.call("deselect");
	}

	public boolean is_selected() {
		return (boolean) super.call("is_selected");
	}

	public void select(long focusable) {
		super.call("select", new java.lang.Object[]{java.lang.Long.valueOf(focusable)});
	}

	public void set_object_and_property(GodotObject object, String property) {
		super.call("set_object_and_property",
				new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) property});
	}

	public void emit_changed(String property, Object value, String field, boolean changing) {
		super.call("emit_changed", new java.lang.Object[]{(java.lang.Object) property, (java.lang.Object) value,
				(java.lang.Object) field, java.lang.Boolean.valueOf(changing)});
	}

	public String getLabel() {
		return (String) super.call("get_label", new java.lang.Object[0]);
	}

	public void setLabel(String value) {
		super.call("set_label", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRead_only() {
		return (boolean) super.call("is_read_only", new java.lang.Object[0]);
	}

	public void setRead_only(boolean value) {
		super.call("set_read_only", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDraw_label() {
		return (boolean) super.call("is_draw_label", new java.lang.Object[0]);
	}

	public void setDraw_label(boolean value) {
		super.call("set_draw_label", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDraw_background() {
		return (boolean) super.call("is_draw_background", new java.lang.Object[0]);
	}

	public void setDraw_background(boolean value) {
		super.call("set_draw_background", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isCheckable() {
		return (boolean) super.call("is_checkable", new java.lang.Object[0]);
	}

	public void setCheckable(boolean value) {
		super.call("set_checkable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isChecked() {
		return (boolean) super.call("is_checked", new java.lang.Object[0]);
	}

	public void setChecked(boolean value) {
		super.call("set_checked", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDraw_warning() {
		return (boolean) super.call("is_draw_warning", new java.lang.Object[0]);
	}

	public void setDraw_warning(boolean value) {
		super.call("set_draw_warning", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isKeying() {
		return (boolean) super.call("is_keying", new java.lang.Object[0]);
	}

	public void setKeying(boolean value) {
		super.call("set_keying", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isDeletable() {
		return (boolean) super.call("is_deletable", new java.lang.Object[0]);
	}

	public void setDeletable(boolean value) {
		super.call("set_deletable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isSelectable() {
		return (boolean) super.call("is_selectable", new java.lang.Object[0]);
	}

	public void setSelectable(boolean value) {
		super.call("set_selectable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isUse_folding() {
		return (boolean) super.call("is_using_folding", new java.lang.Object[0]);
	}

	public void setUse_folding(boolean value) {
		super.call("set_use_folding", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getName_split_ratio() {
		return (double) super.call("get_name_split_ratio", new java.lang.Object[0]);
	}

	public void setName_split_ratio(double value) {
		super.call("set_name_split_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
