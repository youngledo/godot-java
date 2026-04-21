package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterShaderFile extends ResourceImporter {
	ResourceImporterShaderFile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterShaderFile(long nativePointer) {
		super(nativePointer);
	}
}
