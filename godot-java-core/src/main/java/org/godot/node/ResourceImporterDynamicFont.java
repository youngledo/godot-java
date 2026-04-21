package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ResourceImporterDynamicFont extends ResourceImporter {
	ResourceImporterDynamicFont(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ResourceImporterDynamicFont(long nativePointer) {
		super(nativePointer);
	}
}
