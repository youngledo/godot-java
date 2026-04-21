package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterWAV extends ResourceImporter {
	ResourceImporterWAV(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterWAV(long nativePointer) {
		super(nativePointer);
	}
}
