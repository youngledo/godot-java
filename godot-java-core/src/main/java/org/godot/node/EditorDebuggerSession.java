package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.core.RefCounted;

public class EditorDebuggerSession extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("toggle_profiler", 1198443697L), java.util.Map.entry("add_session_tab", 1496901182L),
			java.util.Map.entry("remove_session_tab", 1496901182L), java.util.Map.entry("set_breakpoint", 4108344793L),
			java.util.Map.entry("is_debuggable", 2240911060L), java.util.Map.entry("is_active", 2240911060L),
			java.util.Map.entry("send_message", 85656714L), java.util.Map.entry("is_breaked", 2240911060L));

	EditorDebuggerSession(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorDebuggerSession(long nativePointer) {
		super(nativePointer);
	}

	public void send_message(String message, GodotArray data) {
		super.call("send_message", new java.lang.Object[]{(java.lang.Object) message, (java.lang.Object) data});
	}

	public void toggle_profiler(String profiler, boolean enable, GodotArray data) {
		super.call("toggle_profiler", new java.lang.Object[]{(java.lang.Object) profiler,
				java.lang.Boolean.valueOf(enable), (java.lang.Object) data});
	}

	public boolean is_breaked() {
		return (boolean) super.call("is_breaked");
	}

	public boolean is_debuggable() {
		return (boolean) super.call("is_debuggable");
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public void add_session_tab(Control control) {
		super.call("add_session_tab", new java.lang.Object[]{(java.lang.Object) control});
	}

	public void remove_session_tab(Control control) {
		super.call("remove_session_tab", new java.lang.Object[]{(java.lang.Object) control});
	}

	public void set_breakpoint(String path, long line, boolean enabled) {
		super.call("set_breakpoint", new java.lang.Object[]{(java.lang.Object) path, java.lang.Long.valueOf(line),
				java.lang.Boolean.valueOf(enabled)});
	}
}
