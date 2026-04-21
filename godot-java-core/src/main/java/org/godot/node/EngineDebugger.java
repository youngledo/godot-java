package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotArray;
import org.godot.core.Callable;

public class EngineDebugger extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("register_message_capture", 1874754934L), java.util.Map.entry("is_active", 2240911060L),
			java.util.Map.entry("debug", 2751962654L), java.util.Map.entry("clear_breakpoints", 3218959716L),
			java.util.Map.entry("profiler_add_frame_data", 1895267858L), java.util.Map.entry("get_depth", 3905245786L),
			java.util.Map.entry("register_profiler", 3651669560L),
			java.util.Map.entry("insert_breakpoint", 3780747571L), java.util.Map.entry("get_lines_left", 3905245786L),
			java.util.Map.entry("unregister_message_capture", 3304788590L),
			java.util.Map.entry("remove_breakpoint", 3780747571L), java.util.Map.entry("is_breakpoint", 921227809L),
			java.util.Map.entry("is_skipping_breakpoints", 36873697L), java.util.Map.entry("set_depth", 1286410249L),
			java.util.Map.entry("profiler_enable", 3192561009L), java.util.Map.entry("has_profiler", 2041966384L),
			java.util.Map.entry("has_capture", 2041966384L), java.util.Map.entry("script_debug", 2442343672L),
			java.util.Map.entry("line_poll", 3218959716L), java.util.Map.entry("set_lines_left", 1286410249L),
			java.util.Map.entry("unregister_profiler", 3304788590L), java.util.Map.entry("send_message", 1209351045L),
			java.util.Map.entry("is_profiling", 2041966384L));

	EngineDebugger(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EngineDebugger(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public void register_profiler(String name, EngineProfiler profiler) {
		super.call("register_profiler", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) profiler});
	}

	public void unregister_profiler(String name) {
		super.call("unregister_profiler", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_profiling(String name) {
		return (boolean) super.call("is_profiling", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_profiler(String name) {
		return (boolean) super.call("has_profiler", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void profiler_add_frame_data(String name, GodotArray data) {
		super.call("profiler_add_frame_data", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) data});
	}

	public void profiler_enable(String name, boolean enable, GodotArray arguments) {
		super.call("profiler_enable", new java.lang.Object[]{(java.lang.Object) name, java.lang.Boolean.valueOf(enable),
				(java.lang.Object) arguments});
	}

	public void register_message_capture(String name, Callable callable) {
		super.call("register_message_capture",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) callable});
	}

	public void unregister_message_capture(String name) {
		super.call("unregister_message_capture", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_capture(String name) {
		return (boolean) super.call("has_capture", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void line_poll() {
		super.call("line_poll");
	}

	public void send_message(String message, GodotArray data) {
		super.call("send_message", new java.lang.Object[]{(java.lang.Object) message, (java.lang.Object) data});
	}

	public void debug(boolean can_continue, boolean is_error_breakpoint) {
		super.call("debug", new java.lang.Object[]{java.lang.Boolean.valueOf(can_continue),
				java.lang.Boolean.valueOf(is_error_breakpoint)});
	}

	public void script_debug(ScriptLanguage language, boolean can_continue, boolean is_error_breakpoint) {
		super.call("script_debug", new java.lang.Object[]{(java.lang.Object) language,
				java.lang.Boolean.valueOf(can_continue), java.lang.Boolean.valueOf(is_error_breakpoint)});
	}

	public boolean is_breakpoint(long line, String source) {
		return (boolean) super.call("is_breakpoint",
				new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) source});
	}

	public boolean is_skipping_breakpoints() {
		return (boolean) super.call("is_skipping_breakpoints");
	}

	public void insert_breakpoint(long line, String source) {
		super.call("insert_breakpoint",
				new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) source});
	}

	public void remove_breakpoint(long line, String source) {
		super.call("remove_breakpoint",
				new java.lang.Object[]{java.lang.Long.valueOf(line), (java.lang.Object) source});
	}

	public void clear_breakpoints() {
		super.call("clear_breakpoints");
	}
}
