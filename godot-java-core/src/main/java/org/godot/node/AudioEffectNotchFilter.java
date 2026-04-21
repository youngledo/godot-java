package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectNotchFilter extends AudioEffectFilter {
	AudioEffectNotchFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectNotchFilter(long nativePointer) {
		super(nativePointer);
	}
}
