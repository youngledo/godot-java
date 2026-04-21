package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;

public class JavaScriptBridge extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("eval", 218087648L), java.util.Map.entry("create_callback", 422818440L),
			java.util.Map.entry("is_js_buffer", 821968997L), java.util.Map.entry("pwa_needs_update", 36873697L),
			java.util.Map.entry("get_interface", 1355533281L),
			java.util.Map.entry("js_buffer_to_packed_byte_array", 64409880L),
			java.util.Map.entry("download_buffer", 3352272093L), java.util.Map.entry("force_fs_sync", 3218959716L),
			java.util.Map.entry("create_object", 3093893586L), java.util.Map.entry("pwa_update", 166280745L));

	JavaScriptBridge(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JavaScriptBridge(long nativePointer) {
		super(nativePointer);
	}

	public Object eval(String code, boolean use_global_execution_context) {
		return (Object) super.call("eval", new java.lang.Object[]{(java.lang.Object) code,
				java.lang.Boolean.valueOf(use_global_execution_context)});
	}

	public JavaScriptObject get_interface(String interface_) {
		return (JavaScriptObject) super.call("get_interface", new java.lang.Object[]{(java.lang.Object) interface_});
	}

	public JavaScriptObject create_callback(Callable callable) {
		return (JavaScriptObject) super.call("create_callback", new java.lang.Object[]{(java.lang.Object) callable});
	}

	public boolean is_js_buffer(JavaScriptObject javascript_object) {
		return (boolean) super.call("is_js_buffer", new java.lang.Object[]{(java.lang.Object) javascript_object});
	}

	public byte[] js_buffer_to_packed_byte_array(JavaScriptObject javascript_buffer) {
		return (byte[]) super.call("js_buffer_to_packed_byte_array",
				new java.lang.Object[]{(java.lang.Object) javascript_buffer});
	}

	public Object create_object(String object) {
		return (Object) super.call("create_object", new java.lang.Object[]{(java.lang.Object) object});
	}

	public void download_buffer(byte[] buffer, String name, String mime) {
		super.call("download_buffer",
				new java.lang.Object[]{(java.lang.Object) buffer, (java.lang.Object) name, (java.lang.Object) mime});
	}

	public boolean pwa_needs_update() {
		return (boolean) super.call("pwa_needs_update");
	}

	public int pwa_update() {
		return (int) super.call("pwa_update");
	}

	public void force_fs_sync() {
		super.call("force_fs_sync");
	}
}
