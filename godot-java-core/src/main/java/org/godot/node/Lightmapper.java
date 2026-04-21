package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class Lightmapper extends RefCounted {
	Lightmapper(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Lightmapper(long nativePointer) {
		super(nativePointer);
	}
}
