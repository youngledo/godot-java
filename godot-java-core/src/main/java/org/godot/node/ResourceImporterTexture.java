package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterTexture extends ResourceImporter {
	ResourceImporterTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterTexture(long nativePointer) {
		super(nativePointer);
	}
}
