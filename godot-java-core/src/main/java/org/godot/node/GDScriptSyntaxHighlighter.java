package org.godot.node;

import java.lang.foreign.MemorySegment;

public class GDScriptSyntaxHighlighter extends EditorSyntaxHighlighter {
	GDScriptSyntaxHighlighter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GDScriptSyntaxHighlighter(long nativePointer) {
		super(nativePointer);
	}
}
