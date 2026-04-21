package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OfflineMultiplayerPeer extends MultiplayerPeer {
	OfflineMultiplayerPeer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OfflineMultiplayerPeer(long nativePointer) {
		super(nativePointer);
	}
}
