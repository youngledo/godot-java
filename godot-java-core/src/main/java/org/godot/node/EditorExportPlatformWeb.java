package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformWeb extends EditorExportPlatform {
	EditorExportPlatformWeb(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformWeb(long nativePointer) {
		super(nativePointer);
	}
}
