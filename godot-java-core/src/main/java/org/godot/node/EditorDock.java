package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class EditorDock extends MarginContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_icon_name", 3304788590L), java.util.Map.entry("get_dock_icon", 3635182373L),
			java.util.Map.entry("get_available_layouts", 495015512L), java.util.Map.entry("is_global", 36873697L),
			java.util.Map.entry("set_default_slot", 4142995464L), java.util.Map.entry("get_title", 201670096L),
			java.util.Map.entry("is_closable", 36873697L), java.util.Map.entry("set_force_show_icon", 2586408642L),
			java.util.Map.entry("set_layout_key", 83702148L), java.util.Map.entry("set_dock_icon", 4051416890L),
			java.util.Map.entry("get_default_slot", 3298961740L), java.util.Map.entry("get_dock_shortcut", 3415666916L),
			java.util.Map.entry("close", 3218959716L), java.util.Map.entry("set_dock_shortcut", 857163497L),
			java.util.Map.entry("get_force_show_icon", 36873697L), java.util.Map.entry("get_icon_name", 2002593661L),
			java.util.Map.entry("set_title_color", 2920490490L), java.util.Map.entry("set_title", 83702148L),
			java.util.Map.entry("is_transient", 36873697L), java.util.Map.entry("set_closable", 2586408642L),
			java.util.Map.entry("set_available_layouts", 3440531249L),
			java.util.Map.entry("get_title_color", 3444240500L), java.util.Map.entry("open", 3218959716L),
			java.util.Map.entry("get_layout_key", 201670096L), java.util.Map.entry("set_global", 2586408642L),
			java.util.Map.entry("set_transient", 2586408642L), java.util.Map.entry("make_visible", 3218959716L));

	EditorDock(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorDock(long nativePointer) {
		super(nativePointer);
	}

	public void open() {
		super.call("open");
	}

	public void make_visible() {
		super.call("make_visible");
	}

	public void close() {
		super.call("close");
	}

	public boolean is_global() {
		return (boolean) super.call("is_global");
	}

	public boolean is_transient() {
		return (boolean) super.call("is_transient");
	}

	public boolean is_closable() {
		return (boolean) super.call("is_closable");
	}

	public String getTitle() {
		return (String) super.call("get_title", new java.lang.Object[0]);
	}

	public void setTitle(String value) {
		super.call("set_title", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getLayout_key() {
		return (String) super.call("get_layout_key", new java.lang.Object[0]);
	}

	public void setLayout_key(String value) {
		super.call("set_layout_key", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isGlobal() {
		return (boolean) super.call("is_global", new java.lang.Object[0]);
	}

	public void setGlobal(boolean value) {
		super.call("set_global", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isTransient_() {
		return (boolean) super.call("is_transient", new java.lang.Object[0]);
	}

	public void setTransient_(boolean value) {
		super.call("set_transient", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isClosable() {
		return (boolean) super.call("is_closable", new java.lang.Object[0]);
	}

	public void setClosable(boolean value) {
		super.call("set_closable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getIcon_name() {
		return (String) super.call("get_icon_name", new java.lang.Object[0]);
	}

	public void setIcon_name(String value) {
		super.call("set_icon_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getDock_icon() {
		return (Texture2D) super.call("get_dock_icon", new java.lang.Object[0]);
	}

	public void setDock_icon(Texture2D value) {
		super.call("set_dock_icon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getForce_show_icon() {
		return (boolean) super.call("get_force_show_icon", new java.lang.Object[0]);
	}

	public void setForce_show_icon(boolean value) {
		super.call("set_force_show_icon", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getTitle_color() {
		return (Color) super.call("get_title_color", new java.lang.Object[0]);
	}

	public void setTitle_color(Color value) {
		super.call("set_title_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Shortcut getDock_shortcut() {
		return (Shortcut) super.call("get_dock_shortcut", new java.lang.Object[0]);
	}

	public void setDock_shortcut(Shortcut value) {
		super.call("set_dock_shortcut", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDefault_slot() {
		return (long) super.call("get_default_slot", new java.lang.Object[0]);
	}

	public void setDefault_slot(long value) {
		super.call("set_default_slot", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAvailable_layouts() {
		return (long) super.call("get_available_layouts", new java.lang.Object[0]);
	}

	public void setAvailable_layouts(long value) {
		super.call("set_available_layouts", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
