package org.godot.node;

import java.lang.foreign.MemorySegment;

public class ScriptLanguageExtension extends ScriptLanguage {
	ScriptLanguageExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptLanguageExtension(long nativePointer) {
		super(nativePointer);
	}
}
