package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffectHighShelfFilter extends AudioEffectFilter {
	AudioEffectHighShelfFilter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectHighShelfFilter(long nativePointer) {
		super(nativePointer);
	}
}
