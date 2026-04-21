package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class AudioSample extends RefCounted {
	AudioSample(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioSample(long nativePointer) {
		super(nativePointer);
	}
}
