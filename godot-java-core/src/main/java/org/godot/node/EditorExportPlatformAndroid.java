package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorExportPlatformAndroid extends EditorExportPlatform {
	EditorExportPlatformAndroid(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorExportPlatformAndroid(long nativePointer) {
		super(nativePointer);
	}
}
