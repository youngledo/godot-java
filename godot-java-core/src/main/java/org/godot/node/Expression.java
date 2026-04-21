package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class Expression extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("parse", 3069722906L), java.util.Map.entry("has_execute_failed", 36873697L),
			java.util.Map.entry("get_error_text", 201670096L), java.util.Map.entry("execute", 3712471238L));

	Expression(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Expression(long nativePointer) {
		super(nativePointer);
	}

	public int parse(String expression, String[] input_names) {
		return (int) super.call("parse",
				new java.lang.Object[]{(java.lang.Object) expression, (java.lang.Object) input_names});
	}

	public Object execute(GodotArray inputs, GodotObject base_instance, boolean show_error, boolean const_calls_only) {
		return (Object) super.call("execute",
				new java.lang.Object[]{(java.lang.Object) inputs, (java.lang.Object) base_instance,
						java.lang.Boolean.valueOf(show_error), java.lang.Boolean.valueOf(const_calls_only)});
	}

	public boolean has_execute_failed() {
		return (boolean) super.call("has_execute_failed");
	}
}
