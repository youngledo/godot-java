package org.godot.node;

import java.lang.foreign.MemorySegment;

public class EditorSyntaxHighlighter extends SyntaxHighlighter {
	EditorSyntaxHighlighter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorSyntaxHighlighter(long nativePointer) {
		super(nativePointer);
	}
}
