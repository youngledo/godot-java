package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ScriptExtension extends Script {
	ScriptExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptExtension(long nativePointer) {
		super(nativePointer);
	}
}
