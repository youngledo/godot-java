package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterBitMap extends ResourceImporter {
	ResourceImporterBitMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterBitMap(long nativePointer) {
		super(nativePointer);
	}
}
