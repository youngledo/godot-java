package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioEffect extends Resource {
	AudioEffect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffect(long nativePointer) {
		super(nativePointer);
	}
}
