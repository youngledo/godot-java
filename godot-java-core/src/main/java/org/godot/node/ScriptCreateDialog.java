package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ScriptCreateDialog extends ConfirmationDialog {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("config", 869314288L));

	ScriptCreateDialog(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptCreateDialog(long nativePointer) {
		super(nativePointer);
	}

	public void config(String inherits, String path, boolean built_in_enabled, boolean load_enabled) {
		super.call("config", new java.lang.Object[]{(java.lang.Object) inherits, (java.lang.Object) path,
				java.lang.Boolean.valueOf(built_in_enabled), java.lang.Boolean.valueOf(load_enabled)});
	}
}
