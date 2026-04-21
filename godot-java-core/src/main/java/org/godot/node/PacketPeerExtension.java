package org.godot.node;

import java.lang.foreign.MemorySegment;

public class PacketPeerExtension extends PacketPeer {
	PacketPeerExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PacketPeerExtension(long nativePointer) {
		super(nativePointer);
	}
}
