package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ConfirmationDialog extends AcceptDialog {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_cancel_button_text", 201670096L),
			java.util.Map.entry("get_cancel_button", 1856205918L),
			java.util.Map.entry("set_cancel_button_text", 83702148L));

	ConfirmationDialog(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConfirmationDialog(long nativePointer) {
		super(nativePointer);
	}

	public String getCancel_button_text() {
		return (String) super.call("get_cancel_button_text", new java.lang.Object[0]);
	}

	public void setCancel_button_text(String value) {
		super.call("set_cancel_button_text", new java.lang.Object[]{(java.lang.Object) value});
	}
}
