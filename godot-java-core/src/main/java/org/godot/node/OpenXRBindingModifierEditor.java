package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRBindingModifierEditor extends PanelContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_binding_modifier", 2930765082L), java.util.Map.entry("setup", 1284787389L));

	OpenXRBindingModifierEditor(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRBindingModifierEditor(long nativePointer) {
		super(nativePointer);
	}

	public void setup(OpenXRActionMap action_map, OpenXRBindingModifier binding_modifier) {
		super.call("setup", new java.lang.Object[]{(java.lang.Object) action_map, (java.lang.Object) binding_modifier});
	}
}
