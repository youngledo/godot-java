package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformWindows extends EditorExportPlatformPC {
	EditorExportPlatformWindows(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformWindows(long nativePointer) {
		super(nativePointer);
	}
}
