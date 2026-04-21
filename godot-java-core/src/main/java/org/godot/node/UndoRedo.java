package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.core.Callable;

public class UndoRedo extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_undo_property", 1017172818L), java.util.Map.entry("add_do_method", 1611583062L),
			java.util.Map.entry("has_redo", 36873697L),
			java.util.Map.entry("start_force_keep_in_merge_ends", 3218959716L),
			java.util.Map.entry("end_force_keep_in_merge_ends", 3218959716L),
			java.util.Map.entry("add_do_property", 1017172818L), java.util.Map.entry("get_version", 3905245786L),
			java.util.Map.entry("redo", 2240911060L), java.util.Map.entry("has_undo", 36873697L),
			java.util.Map.entry("is_committing_action", 36873697L), java.util.Map.entry("commit_action", 3216645846L),
			java.util.Map.entry("get_current_action_name", 201670096L),
			java.util.Map.entry("add_do_reference", 3975164845L),
			java.util.Map.entry("add_undo_reference", 3975164845L), java.util.Map.entry("undo", 2240911060L),
			java.util.Map.entry("set_max_steps", 1286410249L), java.util.Map.entry("add_undo_method", 1611583062L),
			java.util.Map.entry("clear_history", 3216645846L), java.util.Map.entry("create_action", 3171901514L),
			java.util.Map.entry("get_history_count", 2455072627L),
			java.util.Map.entry("get_current_action", 2455072627L), java.util.Map.entry("get_max_steps", 3905245786L),
			java.util.Map.entry("get_action_name", 990163283L));

	UndoRedo(MemorySegment nativePointer) {
		super(nativePointer);
	}

	UndoRedo(long nativePointer) {
		super(nativePointer);
	}

	public void create_action(String name, int merge_mode, boolean backward_undo_ops) {
		super.call("create_action", new java.lang.Object[]{(java.lang.Object) name,
				java.lang.Integer.valueOf(merge_mode), java.lang.Boolean.valueOf(backward_undo_ops)});
	}

	public void commit_action(boolean execute) {
		super.call("commit_action", new java.lang.Object[]{java.lang.Boolean.valueOf(execute)});
	}

	public boolean is_committing_action() {
		return (boolean) super.call("is_committing_action");
	}

	public void add_do_method(Callable callable) {
		super.call("add_do_method", new java.lang.Object[]{(java.lang.Object) callable});
	}

	public void add_undo_method(Callable callable) {
		super.call("add_undo_method", new java.lang.Object[]{(java.lang.Object) callable});
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

	public void start_force_keep_in_merge_ends() {
		super.call("start_force_keep_in_merge_ends");
	}

	public void end_force_keep_in_merge_ends() {
		super.call("end_force_keep_in_merge_ends");
	}

	public String get_action_name(long id) {
		return (String) super.call("get_action_name", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void clear_history(boolean increase_version) {
		super.call("clear_history", new java.lang.Object[]{java.lang.Boolean.valueOf(increase_version)});
	}

	public boolean has_undo() {
		return (boolean) super.call("has_undo");
	}

	public boolean has_redo() {
		return (boolean) super.call("has_redo");
	}

	public boolean redo() {
		return (boolean) super.call("redo");
	}

	public boolean undo() {
		return (boolean) super.call("undo");
	}

	public long getMax_steps() {
		return (long) super.call("get_max_steps", new java.lang.Object[0]);
	}

	public void setMax_steps(long value) {
		super.call("set_max_steps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
