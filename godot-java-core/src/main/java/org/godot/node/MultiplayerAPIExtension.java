package org.godot.node;

import java.lang.foreign.MemorySegment;

public class MultiplayerAPIExtension extends MultiplayerAPI {
	MultiplayerAPIExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MultiplayerAPIExtension(long nativePointer) {
		super(nativePointer);
	}
}
