package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformPC extends EditorExportPlatform {
	EditorExportPlatformPC(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformPC(long nativePointer) {
		super(nativePointer);
	}
}
