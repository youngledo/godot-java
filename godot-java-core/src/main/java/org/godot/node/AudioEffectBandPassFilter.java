package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectBandPassFilter extends AudioEffectFilter {
	AudioEffectBandPassFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectBandPassFilter(long nativePointer) {
		super(nativePointer);
	}
}
