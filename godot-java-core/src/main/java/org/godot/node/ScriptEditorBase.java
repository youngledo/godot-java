package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ScriptEditorBase extends VBoxContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_base_editor", 2783021301L),
			java.util.Map.entry("add_syntax_highlighter", 1092774468L));

	ScriptEditorBase(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptEditorBase(long nativePointer) {
		super(nativePointer);
	}

	public void add_syntax_highlighter(EditorSyntaxHighlighter highlighter) {
		super.call("add_syntax_highlighter", new java.lang.Object[]{(java.lang.Object) highlighter});
	}
}
