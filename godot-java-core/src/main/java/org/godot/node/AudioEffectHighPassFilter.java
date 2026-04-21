package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectHighPassFilter extends AudioEffectFilter {
	AudioEffectHighPassFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectHighPassFilter(long nativePointer) {
		super(nativePointer);
	}
}
