package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class EditorFileSystemDirectory extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_path", 201670096L), java.util.Map.entry("find_file_index", 1321353865L),
			java.util.Map.entry("get_file_count", 3905245786L), java.util.Map.entry("get_file_path", 844755477L),
			java.util.Map.entry("find_dir_index", 1321353865L),
			java.util.Map.entry("get_file_script_class_name", 844755477L),
			java.util.Map.entry("get_file_script_class_extends", 844755477L),
			java.util.Map.entry("get_file", 844755477L), java.util.Map.entry("get_file_type", 659327637L),
			java.util.Map.entry("get_subdir", 2330964164L), java.util.Map.entry("get_subdir_count", 3905245786L),
			java.util.Map.entry("get_name", 2841200299L), java.util.Map.entry("get_parent", 842323275L),
			java.util.Map.entry("get_file_import_is_valid", 1116898809L));

	EditorFileSystemDirectory(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorFileSystemDirectory(long nativePointer) {
		super(nativePointer);
	}

	public EditorFileSystemDirectory get_subdir(long idx) {
		return (EditorFileSystemDirectory) super.call("get_subdir",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_file(long idx) {
		return (String) super.call("get_file", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_file_path(long idx) {
		return (String) super.call("get_file_path", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_file_type(long idx) {
		return (String) super.call("get_file_type", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_file_script_class_name(long idx) {
		return (String) super.call("get_file_script_class_name", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_file_script_class_extends(long idx) {
		return (String) super.call("get_file_script_class_extends",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean get_file_import_is_valid(long idx) {
		return (boolean) super.call("get_file_import_is_valid", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int find_file_index(String name) {
		return (int) super.call("find_file_index", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int find_dir_index(String name) {
		return (int) super.call("find_dir_index", new java.lang.Object[]{(java.lang.Object) name});
	}
}
