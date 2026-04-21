package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class EditorCommandPalette extends ConfirmationDialog {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("remove_command", 83702148L), java.util.Map.entry("add_command", 864043298L));

	EditorCommandPalette(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorCommandPalette(long nativePointer) {
		super(nativePointer);
	}

	public void add_command(String command_name, String key_name, Callable binded_callable, String shortcut_text) {
		super.call("add_command", new java.lang.Object[]{(java.lang.Object) command_name, (java.lang.Object) key_name,
				(java.lang.Object) binded_callable, (java.lang.Object) shortcut_text});
	}

	public void remove_command(String key_name) {
		super.call("remove_command", new java.lang.Object[]{(java.lang.Object) key_name});
	}
}
