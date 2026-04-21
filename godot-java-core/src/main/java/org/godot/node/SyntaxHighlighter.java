package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class SyntaxHighlighter extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_line_syntax_highlighting", 3554694381L),
			java.util.Map.entry("get_text_edit", 1893027089L),
			java.util.Map.entry("clear_highlighting_cache", 3218959716L),
			java.util.Map.entry("update_cache", 3218959716L));

	SyntaxHighlighter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SyntaxHighlighter(long nativePointer) {
		super(nativePointer);
	}

	public GodotDictionary get_line_syntax_highlighting(long line) {
		return (GodotDictionary) super.call("get_line_syntax_highlighting",
				new java.lang.Object[]{java.lang.Long.valueOf(line)});
	}

	public void update_cache() {
		super.call("update_cache");
	}

	public void clear_highlighting_cache() {
		super.call("clear_highlighting_cache");
	}
}
