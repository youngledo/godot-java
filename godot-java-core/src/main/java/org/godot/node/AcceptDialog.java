package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AcceptDialog extends Window {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_hide_on_ok", 36873697L), java.util.Map.entry("get_close_on_escape", 36873697L),
			java.util.Map.entry("get_label", 566733104L), java.util.Map.entry("add_button", 3328440682L),
			java.util.Map.entry("get_ok_button", 1856205918L), java.util.Map.entry("get_text", 201670096L),
			java.util.Map.entry("add_cancel_button", 242045556L), java.util.Map.entry("set_hide_on_ok", 2586408642L),
			java.util.Map.entry("set_close_on_escape", 2586408642L), java.util.Map.entry("set_autowrap", 2586408642L),
			java.util.Map.entry("set_text", 83702148L), java.util.Map.entry("remove_button", 2068354942L),
			java.util.Map.entry("get_ok_button_text", 201670096L), java.util.Map.entry("has_autowrap", 2240911060L),
			java.util.Map.entry("set_ok_button_text", 83702148L),
			java.util.Map.entry("register_text_enter", 3714008017L));

	AcceptDialog(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AcceptDialog(long nativePointer) {
		super(nativePointer);
	}

	public Button add_button(String text, boolean right, String action) {
		return (Button) super.call("add_button", new java.lang.Object[]{(java.lang.Object) text,
				java.lang.Boolean.valueOf(right), (java.lang.Object) action});
	}

	public Button add_cancel_button(String name) {
		return (Button) super.call("add_cancel_button", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void remove_button(Button button) {
		super.call("remove_button", new java.lang.Object[]{(java.lang.Object) button});
	}

	public void register_text_enter(LineEdit line_edit) {
		super.call("register_text_enter", new java.lang.Object[]{(java.lang.Object) line_edit});
	}

	public boolean has_autowrap() {
		return (boolean) super.call("has_autowrap");
	}

	public String getOk_button_text() {
		return (String) super.call("get_ok_button_text", new java.lang.Object[0]);
	}

	public void setOk_button_text(String value) {
		super.call("set_ok_button_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getDialog_text() {
		return (String) super.call("get_text", new java.lang.Object[0]);
	}

	public void setDialog_text(String value) {
		super.call("set_text", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getDialog_hide_on_ok() {
		return (boolean) super.call("get_hide_on_ok", new java.lang.Object[0]);
	}

	public void setDialog_hide_on_ok(boolean value) {
		super.call("set_hide_on_ok", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDialog_close_on_escape() {
		return (boolean) super.call("get_close_on_escape", new java.lang.Object[0]);
	}

	public void setDialog_close_on_escape(boolean value) {
		super.call("set_close_on_escape", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getDialog_autowrap() {
		return (boolean) super.call("has_autowrap", new java.lang.Object[0]);
	}

	public void setDialog_autowrap(boolean value) {
		super.call("set_autowrap", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
