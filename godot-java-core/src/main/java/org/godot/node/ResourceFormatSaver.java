package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class ResourceFormatSaver extends RefCounted {
	ResourceFormatSaver(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceFormatSaver(long nativePointer) {
		super(nativePointer);
	}
}
