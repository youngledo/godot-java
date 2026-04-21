package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformMacOS extends EditorExportPlatform {
	EditorExportPlatformMacOS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformMacOS(long nativePointer) {
		super(nativePointer);
	}
}
