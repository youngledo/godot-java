package org.godot.node;

import java.lang.foreign.MemorySegment;

public class WebRTCPeerConnectionExtension extends WebRTCPeerConnection {
	WebRTCPeerConnectionExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebRTCPeerConnectionExtension(long nativePointer) {
		super(nativePointer);
	}
}
