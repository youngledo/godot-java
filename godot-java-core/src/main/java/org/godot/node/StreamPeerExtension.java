package org.godot.node;

import java.lang.foreign.MemorySegment;

public class StreamPeerExtension extends StreamPeer {
	StreamPeerExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	StreamPeerExtension(long nativePointer) {
		super(nativePointer);
	}
}
