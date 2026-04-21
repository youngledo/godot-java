package org.godot.node;

import java.lang.foreign.MemorySegment;

public class RichTextEffect extends Resource {
	RichTextEffect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RichTextEffect(long nativePointer) {
		super(nativePointer);
	}
}
