package org.godot.node;

import java.lang.foreign.MemorySegment;

public class MultiplayerPeerExtension extends MultiplayerPeer {
	MultiplayerPeerExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiplayerPeerExtension(long nativePointer) {
		super(nativePointer);
	}
}
