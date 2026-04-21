package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterLayeredTexture extends ResourceImporter {
	ResourceImporterLayeredTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterLayeredTexture(long nativePointer) {
		super(nativePointer);
	}
}
