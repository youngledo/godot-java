package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;
import org.godot.core.Callable;

public class JSONRPC extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("process_action", 2963479484L), java.util.Map.entry("make_response_error", 928596297L),
			java.util.Map.entry("make_response", 5053918L), java.util.Map.entry("make_notification", 2949127017L),
			java.util.Map.entry("set_method", 2137474292L), java.util.Map.entry("make_request", 3423508980L),
			java.util.Map.entry("process_string", 1703090593L));

	JSONRPC(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JSONRPC(long nativePointer) {
		super(nativePointer);
	}

	public void set_method(String name, Callable callback) {
		super.call("set_method", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) callback});
	}

	public Object process_action(Object action, boolean recurse) {
		return (Object) super.call("process_action",
				new java.lang.Object[]{(java.lang.Object) action, java.lang.Boolean.valueOf(recurse)});
	}

	public String process_string(String action) {
		return (String) super.call("process_string", new java.lang.Object[]{(java.lang.Object) action});
	}

	public GodotDictionary make_request(String method, Object params, Object id) {
		return (GodotDictionary) super.call("make_request",
				new java.lang.Object[]{(java.lang.Object) method, (java.lang.Object) params, (java.lang.Object) id});
	}

	public GodotDictionary make_response(Object result, Object id) {
		return (GodotDictionary) super.call("make_response",
				new java.lang.Object[]{(java.lang.Object) result, (java.lang.Object) id});
	}

	public GodotDictionary make_notification(String method, Object params) {
		return (GodotDictionary) super.call("make_notification",
				new java.lang.Object[]{(java.lang.Object) method, (java.lang.Object) params});
	}

	public GodotDictionary make_response_error(long code, String message, Object id) {
		return (GodotDictionary) super.call("make_response_error", new java.lang.Object[]{java.lang.Long.valueOf(code),
				(java.lang.Object) message, (java.lang.Object) id});
	}
}
