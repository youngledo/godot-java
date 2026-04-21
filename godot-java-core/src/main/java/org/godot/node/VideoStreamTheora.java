package org.godot.node;

import java.lang.foreign.MemorySegment;

public class VideoStreamTheora extends VideoStream {
	VideoStreamTheora(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VideoStreamTheora(long nativePointer) {
		super(nativePointer);
	}
}
