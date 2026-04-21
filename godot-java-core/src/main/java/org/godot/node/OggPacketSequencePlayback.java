package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class OggPacketSequencePlayback extends RefCounted {
	OggPacketSequencePlayback(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OggPacketSequencePlayback(long nativePointer) {
		super(nativePointer);
	}
}
