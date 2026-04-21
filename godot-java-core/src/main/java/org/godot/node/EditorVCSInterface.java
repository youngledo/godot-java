package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;

public class EditorVCSInterface extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("create_status_file", 1083471673L),
			java.util.Map.entry("create_diff_line", 2901184053L), java.util.Map.entry("create_commit", 1075983584L),
			java.util.Map.entry("create_diff_hunk", 3784842090L), java.util.Map.entry("create_diff_file", 2723227684L),
			java.util.Map.entry("popup_error", 83702148L),
			java.util.Map.entry("add_diff_hunks_into_diff_file", 4015243225L),
			java.util.Map.entry("add_line_diffs_into_diff_hunk", 4015243225L));

	EditorVCSInterface(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorVCSInterface(long nativePointer) {
		super(nativePointer);
	}

	public GodotDictionary create_diff_line(long new_line_no, long old_line_no, String content, String status) {
		return (GodotDictionary) super.call("create_diff_line",
				new java.lang.Object[]{java.lang.Long.valueOf(new_line_no), java.lang.Long.valueOf(old_line_no),
						(java.lang.Object) content, (java.lang.Object) status});
	}

	public GodotDictionary create_diff_hunk(long old_start, long new_start, long old_lines, long new_lines) {
		return (GodotDictionary) super.call("create_diff_hunk",
				new java.lang.Object[]{java.lang.Long.valueOf(old_start), java.lang.Long.valueOf(new_start),
						java.lang.Long.valueOf(old_lines), java.lang.Long.valueOf(new_lines)});
	}

	public GodotDictionary create_diff_file(String new_file, String old_file) {
		return (GodotDictionary) super.call("create_diff_file",
				new java.lang.Object[]{(java.lang.Object) new_file, (java.lang.Object) old_file});
	}

	public GodotDictionary create_commit(String msg, String author, String id, long unix_timestamp,
			long offset_minutes) {
		return (GodotDictionary) super.call("create_commit",
				new java.lang.Object[]{(java.lang.Object) msg, (java.lang.Object) author, (java.lang.Object) id,
						java.lang.Long.valueOf(unix_timestamp), java.lang.Long.valueOf(offset_minutes)});
	}

	public GodotDictionary create_status_file(String file_path, int change_type, int area) {
		return (GodotDictionary) super.call("create_status_file", new java.lang.Object[]{(java.lang.Object) file_path,
				java.lang.Integer.valueOf(change_type), java.lang.Integer.valueOf(area)});
	}

	public GodotDictionary add_diff_hunks_into_diff_file(GodotDictionary diff_file, GodotDictionary[] diff_hunks) {
		return (GodotDictionary) super.call("add_diff_hunks_into_diff_file",
				new java.lang.Object[]{(java.lang.Object) diff_file, (java.lang.Object) diff_hunks});
	}

	public GodotDictionary add_line_diffs_into_diff_hunk(GodotDictionary diff_hunk, GodotDictionary[] line_diffs) {
		return (GodotDictionary) super.call("add_line_diffs_into_diff_hunk",
				new java.lang.Object[]{(java.lang.Object) diff_hunk, (java.lang.Object) line_diffs});
	}

	public void popup_error(String msg) {
		super.call("popup_error", new java.lang.Object[]{(java.lang.Object) msg});
	}
}
