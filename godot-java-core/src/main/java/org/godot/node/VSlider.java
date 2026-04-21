package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VSlider extends Slider {
	VSlider(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VSlider(long nativePointer) {
		super(nativePointer);
	}
}
