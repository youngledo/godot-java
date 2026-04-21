package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class ResourceFormatLoader extends RefCounted {
	ResourceFormatLoader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceFormatLoader(long nativePointer) {
		super(nativePointer);
	}
}
