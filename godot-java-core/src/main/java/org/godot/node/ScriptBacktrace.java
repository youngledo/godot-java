package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class ScriptBacktrace extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_language_name", 201670096L), java.util.Map.entry("get_frame_function", 844755477L),
			java.util.Map.entry("get_member_variable_name", 1391810591L),
			java.util.Map.entry("get_frame_line", 923996154L), java.util.Map.entry("format", 3464456933L),
			java.util.Map.entry("get_local_variable_count", 923996154L),
			java.util.Map.entry("get_local_variable_name", 1391810591L),
			java.util.Map.entry("get_global_variable_value", 4227898402L),
			java.util.Map.entry("get_frame_file", 844755477L),
			java.util.Map.entry("get_global_variable_count", 3905245786L),
			java.util.Map.entry("get_local_variable_value", 678354945L),
			java.util.Map.entry("get_global_variable_name", 844755477L),
			java.util.Map.entry("get_member_variable_count", 923996154L),
			java.util.Map.entry("get_frame_count", 3905245786L),
			java.util.Map.entry("get_member_variable_value", 678354945L), java.util.Map.entry("is_empty", 36873697L));

	ScriptBacktrace(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ScriptBacktrace(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_empty() {
		return (boolean) super.call("is_empty");
	}

	public String get_frame_function(long index) {
		return (String) super.call("get_frame_function", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_frame_file(long index) {
		return (String) super.call("get_frame_file", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public int get_frame_line(long index) {
		return (int) super.call("get_frame_line", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_global_variable_name(long variable_index) {
		return (String) super.call("get_global_variable_name",
				new java.lang.Object[]{java.lang.Long.valueOf(variable_index)});
	}

	public Object get_global_variable_value(long variable_index) {
		return (Object) super.call("get_global_variable_value",
				new java.lang.Object[]{java.lang.Long.valueOf(variable_index)});
	}

	public int get_local_variable_count(long frame_index) {
		return (int) super.call("get_local_variable_count",
				new java.lang.Object[]{java.lang.Long.valueOf(frame_index)});
	}

	public String get_local_variable_name(long frame_index, long variable_index) {
		return (String) super.call("get_local_variable_name",
				new java.lang.Object[]{java.lang.Long.valueOf(frame_index), java.lang.Long.valueOf(variable_index)});
	}

	public Object get_local_variable_value(long frame_index, long variable_index) {
		return (Object) super.call("get_local_variable_value",
				new java.lang.Object[]{java.lang.Long.valueOf(frame_index), java.lang.Long.valueOf(variable_index)});
	}

	public int get_member_variable_count(long frame_index) {
		return (int) super.call("get_member_variable_count",
				new java.lang.Object[]{java.lang.Long.valueOf(frame_index)});
	}

	public String get_member_variable_name(long frame_index, long variable_index) {
		return (String) super.call("get_member_variable_name",
				new java.lang.Object[]{java.lang.Long.valueOf(frame_index), java.lang.Long.valueOf(variable_index)});
	}

	public Object get_member_variable_value(long frame_index, long variable_index) {
		return (Object) super.call("get_member_variable_value",
				new java.lang.Object[]{java.lang.Long.valueOf(frame_index), java.lang.Long.valueOf(variable_index)});
	}

	public String format(long indent_all, long indent_frames) {
		return (String) super.call("format",
				new java.lang.Object[]{java.lang.Long.valueOf(indent_all), java.lang.Long.valueOf(indent_frames)});
	}
}
