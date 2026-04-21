package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterCSVTranslation extends ResourceImporter {
	ResourceImporterCSVTranslation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterCSVTranslation(long nativePointer) {
		super(nativePointer);
	}
}
