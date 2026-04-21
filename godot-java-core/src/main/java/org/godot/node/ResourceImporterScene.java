package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterScene extends ResourceImporter {
	ResourceImporterScene(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterScene(long nativePointer) {
		super(nativePointer);
	}
}
