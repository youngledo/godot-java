package org.godot.node;

import java.lang.foreign.MemorySegment;

public class OpenXRExtensionWrapperExtension extends OpenXRExtensionWrapper {
	OpenXRExtensionWrapperExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRExtensionWrapperExtension(long nativePointer) {
		super(nativePointer);
	}
}
