package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.Godot;

public class ScriptLanguage extends Godot {
	ScriptLanguage(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptLanguage(long nativePointer) {
		super(nativePointer);
	}
}
