package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectBandLimitFilter extends AudioEffectFilter {
	AudioEffectBandLimitFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectBandLimitFilter(long nativePointer) {
		super(nativePointer);
	}
}
