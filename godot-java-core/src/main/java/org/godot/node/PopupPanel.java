package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PopupPanel extends Popup {
	PopupPanel(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PopupPanel(long nativePointer) {
		super(nativePointer);
	}
}
