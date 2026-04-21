package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class EditorResourceConversionPlugin extends RefCounted {
	EditorResourceConversionPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorResourceConversionPlugin(long nativePointer) {
		super(nativePointer);
	}
}
