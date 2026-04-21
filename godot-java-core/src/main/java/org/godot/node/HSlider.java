package org.godot.node;

import java.lang.foreign.MemorySegment;

public class HSlider extends Slider {
	HSlider(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HSlider(long nativePointer) {
		super(nativePointer);
	}
}
