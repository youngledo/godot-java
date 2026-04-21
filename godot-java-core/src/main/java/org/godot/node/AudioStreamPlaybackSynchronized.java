package org.godot.node;

import java.lang.foreign.MemorySegment;

public class AudioStreamPlaybackSynchronized extends AudioStreamPlayback {
	AudioStreamPlaybackSynchronized(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioStreamPlaybackSynchronized(long nativePointer) {
		super(nativePointer);
	}
}
