package org.godot.node;

import java.lang.foreign.MemorySegment;

public class WebRTCDataChannelExtension extends WebRTCDataChannel {
	WebRTCDataChannelExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebRTCDataChannelExtension(long nativePointer) {
		super(nativePointer);
	}
}
