package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformAppleEmbedded extends EditorExportPlatform {
	EditorExportPlatformAppleEmbedded(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformAppleEmbedded(long nativePointer) {
		super(nativePointer);
	}
}
