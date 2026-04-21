package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;

public class EditorUndoRedoManager extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_undo_property", 1017172818L), java.util.Map.entry("add_do_method", 1517810467L),
			java.util.Map.entry("add_do_property", 1017172818L), java.util.Map.entry("is_committing_action", 36873697L),
			java.util.Map.entry("commit_action", 3216645846L), java.util.Map.entry("force_fixed_history", 3218959716L),
			java.util.Map.entry("add_do_reference", 3975164845L),
			java.util.Map.entry("add_undo_reference", 3975164845L),
			java.util.Map.entry("get_history_undo_redo", 2417974513L),
			java.util.Map.entry("add_undo_method", 1517810467L), java.util.Map.entry("clear_history", 2020603371L),
			java.util.Map.entry("create_action", 796197507L),
			java.util.Map.entry("get_object_history_id", 1107568780L));

	EditorUndoRedoManager(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorUndoRedoManager(long nativePointer) {
		super(nativePointer);
	}

	public void create_action(String name, int merge_mode, GodotObject custom_context, boolean backward_undo_ops,
			boolean mark_unsaved) {
		super.call("create_action",
				new java.lang.Object[]{(java.lang.Object) name, java.lang.Integer.valueOf(merge_mode),
						(java.lang.Object) custom_context, java.lang.Boolean.valueOf(backward_undo_ops),
						java.lang.Boolean.valueOf(mark_unsaved)});
	}

	public void commit_action(boolean execute) {
		super.call("commit_action", new java.lang.Object[]{java.lang.Boolean.valueOf(execute)});
	}

	public boolean is_committing_action() {
		return (boolean) super.call("is_committing_action");
	}

	public void force_fixed_history() {
		super.call("force_fixed_history");
	}

	public void add_do_method(GodotObject object, String method) {
		super.call("add_do_method", new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) method});
	}

	public void add_undo_method(GodotObject object, String method) {
		super.call("add_undo_method", new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) method});
	}

	public void add_do_property(GodotObject object, String property, Object value) {
		super.call("add_do_property", new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) property,
				(java.lang.Object) value});
	}

	public void add_undo_property(GodotObject object, String property, Object value) {
		super.call("add_undo_property", new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) property,
				(java.lang.Object) value});
	}

	public void add_do_reference(GodotObject object) {
		super.call("add_do_reference", new java.lang.Object[]{(java.lang.Object) object});
	}

	public void add_undo_reference(GodotObject object) {
		super.call("add_undo_reference", new java.lang.Object[]{(java.lang.Object) object});
	}

	public int get_object_history_id(GodotObject object) {
		return (int) super.call("get_object_history_id", new java.lang.Object[]{(java.lang.Object) object});
	}

	public UndoRedo get_history_undo_redo(long id) {
		return (UndoRedo) super.call("get_history_undo_redo", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void clear_history(long id, boolean increase_version) {
		super.call("clear_history",
				new java.lang.Object[]{java.lang.Long.valueOf(id), java.lang.Boolean.valueOf(increase_version)});
	}
}
