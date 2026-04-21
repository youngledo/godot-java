package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterOBJ extends ResourceImporter {
	ResourceImporterOBJ(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterOBJ(long nativePointer) {
		super(nativePointer);
	}
}
