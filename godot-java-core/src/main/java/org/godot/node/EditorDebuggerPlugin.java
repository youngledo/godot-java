package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorDebuggerPlugin extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_sessions", 2915620761L), java.util.Map.entry("get_session", 3061968499L));

	EditorDebuggerPlugin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorDebuggerPlugin(long nativePointer) {
		super(nativePointer);
	}

	public EditorDebuggerSession get_session(long id) {
		return (EditorDebuggerSession) super.call("get_session", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}
}
