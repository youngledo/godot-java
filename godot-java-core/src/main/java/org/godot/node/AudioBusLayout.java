package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioBusLayout extends Resource {
	AudioBusLayout(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioBusLayout(long nativePointer) {
		super(nativePointer);
	}
}
