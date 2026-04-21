package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class JavaScriptObject extends RefCounted {
	JavaScriptObject(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JavaScriptObject(long nativePointer) {
		super(nativePointer);
	}
}
