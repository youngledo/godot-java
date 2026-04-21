package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformIOS extends EditorExportPlatformAppleEmbedded {
	EditorExportPlatformIOS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformIOS(long nativePointer) {
		super(nativePointer);
	}
}
