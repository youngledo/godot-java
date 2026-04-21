package org.godot.node;

import java.lang.foreign.MemorySegment;

public class FBXDocument extends GLTFDocument {
	FBXDocument(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FBXDocument(long nativePointer) {
		super(nativePointer);
	}
}
