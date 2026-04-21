package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioStreamMicrophone extends AudioStream {
	AudioStreamMicrophone(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamMicrophone(long nativePointer) {
		super(nativePointer);
	}
}
