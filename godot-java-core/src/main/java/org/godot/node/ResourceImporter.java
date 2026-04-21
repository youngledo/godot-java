package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class ResourceImporter extends RefCounted {
	ResourceImporter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporter(long nativePointer) {
		super(nativePointer);
	}
}
