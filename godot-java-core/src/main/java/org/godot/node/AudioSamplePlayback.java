package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class AudioSamplePlayback extends RefCounted {
	AudioSamplePlayback(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioSamplePlayback(long nativePointer) {
		super(nativePointer);
	}
}
