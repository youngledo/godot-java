package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ScriptEditor extends PanelContainer {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("register_syntax_highlighter", 1092774468L),
			java.util.Map.entry("get_breakpoints", 2981934095L),
			java.util.Map.entry("open_script_create_dialog", 3186203200L),
			java.util.Map.entry("goto_line", 1286410249L), java.util.Map.entry("get_open_script_editors", 3995934104L),
			java.util.Map.entry("get_open_scripts", 3995934104L),
			java.util.Map.entry("clear_docs_from_script", 3657522847L),
			java.util.Map.entry("get_current_editor", 1906266726L),
			java.util.Map.entry("update_docs_from_script", 3657522847L),
			java.util.Map.entry("unregister_syntax_highlighter", 1092774468L),
			java.util.Map.entry("goto_help", 83702148L), java.util.Map.entry("get_current_script", 2146468882L));

	ScriptEditor(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptEditor(long nativePointer) {
		super(nativePointer);
	}

	public void register_syntax_highlighter(EditorSyntaxHighlighter syntax_highlighter) {
		super.call("register_syntax_highlighter", new java.lang.Object[]{(java.lang.Object) syntax_highlighter});
	}

	public void unregister_syntax_highlighter(EditorSyntaxHighlighter syntax_highlighter) {
		super.call("unregister_syntax_highlighter", new java.lang.Object[]{(java.lang.Object) syntax_highlighter});
	}

	public void goto_line(long line_number) {
		super.call("goto_line", new java.lang.Object[]{java.lang.Long.valueOf(line_number)});
	}

	public void open_script_create_dialog(String base_name, String base_path) {
		super.call("open_script_create_dialog",
				new java.lang.Object[]{(java.lang.Object) base_name, (java.lang.Object) base_path});
	}

	public void goto_help(String topic) {
		super.call("goto_help", new java.lang.Object[]{(java.lang.Object) topic});
	}

	public void update_docs_from_script(Script script) {
		super.call("update_docs_from_script", new java.lang.Object[]{(java.lang.Object) script});
	}

	public void clear_docs_from_script(Script script) {
		super.call("clear_docs_from_script", new java.lang.Object[]{(java.lang.Object) script});
	}
}
