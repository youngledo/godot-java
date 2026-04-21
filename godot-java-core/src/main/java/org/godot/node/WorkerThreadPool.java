package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;

public class WorkerThreadPool extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_group_task_completed", 1116898809L),
			java.util.Map.entry("get_group_processed_element_count", 923996154L),
			java.util.Map.entry("get_caller_group_id", 3905245786L),
			java.util.Map.entry("wait_for_group_task_completion", 1286410249L),
			java.util.Map.entry("add_task", 3745067146L), java.util.Map.entry("wait_for_task_completion", 844576869L),
			java.util.Map.entry("is_task_completed", 1116898809L),
			java.util.Map.entry("get_caller_task_id", 3905245786L), java.util.Map.entry("add_group_task", 1801953219L));

	WorkerThreadPool(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WorkerThreadPool(long nativePointer) {
		super(nativePointer);
	}

	public long add_task(Callable action, boolean high_priority, String description) {
		return (long) super.call("add_task", new java.lang.Object[]{(java.lang.Object) action,
				java.lang.Boolean.valueOf(high_priority), (java.lang.Object) description});
	}

	public boolean is_task_completed(long task_id) {
		return (boolean) super.call("is_task_completed", new java.lang.Object[]{java.lang.Long.valueOf(task_id)});
	}

	public int wait_for_task_completion(long task_id) {
		return (int) super.call("wait_for_task_completion", new java.lang.Object[]{java.lang.Long.valueOf(task_id)});
	}

	public long add_group_task(Callable action, long elements, long tasks_needed, boolean high_priority,
			String description) {
		return (long) super.call("add_group_task",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Long.valueOf(elements),
						java.lang.Long.valueOf(tasks_needed), java.lang.Boolean.valueOf(high_priority),
						(java.lang.Object) description});
	}

	public boolean is_group_task_completed(long group_id) {
		return (boolean) super.call("is_group_task_completed",
				new java.lang.Object[]{java.lang.Long.valueOf(group_id)});
	}

	public long get_group_processed_element_count(long group_id) {
		return (long) super.call("get_group_processed_element_count",
				new java.lang.Object[]{java.lang.Long.valueOf(group_id)});
	}

	public void wait_for_group_task_completion(long group_id) {
		super.call("wait_for_group_task_completion", new java.lang.Object[]{java.lang.Long.valueOf(group_id)});
	}
}
