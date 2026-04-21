package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorScenePostImportPlugin extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_option_value", 2760726917L),
			java.util.Map.entry("add_import_option_advanced", 3674075649L),
			java.util.Map.entry("add_import_option", 402577236L));

	EditorScenePostImportPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorScenePostImportPlugin(long nativePointer) {
		super(nativePointer);
	}

	public Object get_option_value(String name) {
		return (Object) super.call("get_option_value", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void add_import_option(String name, Object value) {
		super.call("add_import_option", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) value});
	}

	public void add_import_option_advanced(int type, String name, Object default_value, int hint, String hint_string,
			long usage_flags) {
		super.call("add_import_option_advanced",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), (java.lang.Object) name,
						(java.lang.Object) default_value, java.lang.Integer.valueOf(hint),
						(java.lang.Object) hint_string, java.lang.Long.valueOf(usage_flags)});
	}
}
