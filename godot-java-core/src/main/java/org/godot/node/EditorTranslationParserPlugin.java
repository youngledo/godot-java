package org.godot.node;

import java.lang.foreign.MemorySegment;
import org.godot.core.RefCounted;

public class EditorTranslationParserPlugin extends RefCounted {
	EditorTranslationParserPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorTranslationParserPlugin(long nativePointer) {
		super(nativePointer);
	}
}
