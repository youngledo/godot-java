package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRInteractionProfileEditorBase extends HBoxContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("setup", 421962938L));

	OpenXRInteractionProfileEditorBase(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRInteractionProfileEditorBase(long nativePointer) {
		super(nativePointer);
	}

	public void setup(OpenXRActionMap action_map, OpenXRInteractionProfile interaction_profile) {
		super.call("setup",
				new java.lang.Object[]{(java.lang.Object) action_map, (java.lang.Object) interaction_profile});
	}
}
