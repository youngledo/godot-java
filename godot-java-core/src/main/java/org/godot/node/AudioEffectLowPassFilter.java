package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectLowPassFilter extends AudioEffectFilter {
	AudioEffectLowPassFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectLowPassFilter(long nativePointer) {
		super(nativePointer);
	}
}
