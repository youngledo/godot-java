package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectLowShelfFilter extends AudioEffectFilter {
	AudioEffectLowShelfFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectLowShelfFilter(long nativePointer) {
		super(nativePointer);
	}
}
