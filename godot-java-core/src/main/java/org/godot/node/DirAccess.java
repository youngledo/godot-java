package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class DirAccess extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("remove_absolute", 166001499L),
			java.util.Map.entry("set_include_navigational", 2586408642L),
			java.util.Map.entry("get_directories_at", 3538744774L),
			java.util.Map.entry("get_include_hidden", 36873697L), java.util.Map.entry("get_directories", 2981934095L),
			java.util.Map.entry("dir_exists_absolute", 2323990056L), java.util.Map.entry("rename_absolute", 852856452L),
			java.util.Map.entry("is_equivalent", 820780508L), java.util.Map.entry("change_dir", 166001499L),
			java.util.Map.entry("create_link", 852856452L),
			java.util.Map.entry("make_dir_recursive_absolute", 166001499L), java.util.Map.entry("remove", 166001499L),
			java.util.Map.entry("get_files", 2981934095L), java.util.Map.entry("get_files_at", 3538744774L),
			java.util.Map.entry("make_dir", 166001499L), java.util.Map.entry("dir_exists", 2323990056L),
			java.util.Map.entry("get_filesystem_type", 201670096L), java.util.Map.entry("list_dir_end", 3218959716L),
			java.util.Map.entry("set_include_hidden", 2586408642L), java.util.Map.entry("list_dir_begin", 166280745L),
			java.util.Map.entry("copy", 1063198817L), java.util.Map.entry("get_include_navigational", 36873697L),
			java.util.Map.entry("copy_absolute", 1063198817L), java.util.Map.entry("read_link", 1703090593L),
			java.util.Map.entry("make_dir_recursive", 166001499L), java.util.Map.entry("current_is_dir", 36873697L),
			java.util.Map.entry("get_drive_name", 990163283L), java.util.Map.entry("make_dir_absolute", 166001499L),
			java.util.Map.entry("get_drive_count", 2455072627L), java.util.Map.entry("create_temp", 812913566L),
			java.util.Map.entry("get_open_error", 166280745L), java.util.Map.entry("get_current_dir", 1287308131L),
			java.util.Map.entry("is_bundle", 3927539163L), java.util.Map.entry("get_next", 2841200299L),
			java.util.Map.entry("get_space_left", 2455072627L), java.util.Map.entry("is_case_sensitive", 3927539163L),
			java.util.Map.entry("file_exists", 2323990056L), java.util.Map.entry("rename", 852856452L),
			java.util.Map.entry("get_current_drive", 2455072627L), java.util.Map.entry("is_link", 2323990056L),
			java.util.Map.entry("open", 1923528528L));

	DirAccess(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DirAccess(long nativePointer) {
		super(nativePointer);
	}

	public DirAccess open(String path) {
		return (DirAccess) super.call("open", new java.lang.Object[]{(java.lang.Object) path});
	}

	public DirAccess create_temp(String prefix, boolean keep) {
		return (DirAccess) super.call("create_temp",
				new java.lang.Object[]{(java.lang.Object) prefix, java.lang.Boolean.valueOf(keep)});
	}

	public int list_dir_begin() {
		return (int) super.call("list_dir_begin");
	}

	public boolean current_is_dir() {
		return (boolean) super.call("current_is_dir");
	}

	public void list_dir_end() {
		super.call("list_dir_end");
	}

	public String[] get_files_at(String path) {
		return (String[]) super.call("get_files_at", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String[] get_directories_at(String path) {
		return (String[]) super.call("get_directories_at", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String get_drive_name(long idx) {
		return (String) super.call("get_drive_name", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int change_dir(String to_dir) {
		return (int) super.call("change_dir", new java.lang.Object[]{(java.lang.Object) to_dir});
	}

	public String get_current_dir(boolean include_drive) {
		return (String) super.call("get_current_dir", new java.lang.Object[]{java.lang.Boolean.valueOf(include_drive)});
	}

	public int make_dir(String path) {
		return (int) super.call("make_dir", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int make_dir_absolute(String path) {
		return (int) super.call("make_dir_absolute", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int make_dir_recursive(String path) {
		return (int) super.call("make_dir_recursive", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int make_dir_recursive_absolute(String path) {
		return (int) super.call("make_dir_recursive_absolute", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean file_exists(String path) {
		return (boolean) super.call("file_exists", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean dir_exists(String path) {
		return (boolean) super.call("dir_exists", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean dir_exists_absolute(String path) {
		return (boolean) super.call("dir_exists_absolute", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int copy(String from, String to, long chmod_flags) {
		return (int) super.call("copy", new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to,
				java.lang.Long.valueOf(chmod_flags)});
	}

	public int copy_absolute(String from, String to, long chmod_flags) {
		return (int) super.call("copy_absolute", new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to,
				java.lang.Long.valueOf(chmod_flags)});
	}

	public int rename(String from, String to) {
		return (int) super.call("rename", new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}

	public int rename_absolute(String from, String to) {
		return (int) super.call("rename_absolute",
				new java.lang.Object[]{(java.lang.Object) from, (java.lang.Object) to});
	}

	public int remove(String path) {
		return (int) super.call("remove", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int remove_absolute(String path) {
		return (int) super.call("remove_absolute", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_link(String path) {
		return (boolean) super.call("is_link", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String read_link(String path) {
		return (String) super.call("read_link", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int create_link(String source, String target) {
		return (int) super.call("create_link",
				new java.lang.Object[]{(java.lang.Object) source, (java.lang.Object) target});
	}

	public boolean is_bundle(String path) {
		return (boolean) super.call("is_bundle", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_case_sensitive(String path) {
		return (boolean) super.call("is_case_sensitive", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_equivalent(String path_a, String path_b) {
		return (boolean) super.call("is_equivalent",
				new java.lang.Object[]{(java.lang.Object) path_a, (java.lang.Object) path_b});
	}

	public boolean getInclude_navigational() {
		return (boolean) super.call("get_include_navigational", new java.lang.Object[0]);
	}

	public void setInclude_navigational(boolean value) {
		super.call("set_include_navigational", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getInclude_hidden() {
		return (boolean) super.call("get_include_hidden", new java.lang.Object[0]);
	}

	public void setInclude_hidden(boolean value) {
		super.call("set_include_hidden", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
