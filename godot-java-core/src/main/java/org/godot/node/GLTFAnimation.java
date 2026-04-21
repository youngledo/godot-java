package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class GLTFAnimation extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_loop", 36873697L), java.util.Map.entry("set_additional_data", 3776071444L),
			java.util.Map.entry("get_original_name", 2841200299L), java.util.Map.entry("set_loop", 2586408642L),
			java.util.Map.entry("set_original_name", 83702148L),
			java.util.Map.entry("get_additional_data", 2138907829L));

	GLTFAnimation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFAnimation(long nativePointer) {
		super(nativePointer);
	}

	public Object get_additional_data(String extension_name) {
		return (Object) super.call("get_additional_data", new java.lang.Object[]{(java.lang.Object) extension_name});
	}

	public void set_additional_data(String extension_name, Object additional_data) {
		super.call("set_additional_data",
				new java.lang.Object[]{(java.lang.Object) extension_name, (java.lang.Object) additional_data});
	}

	public String getOriginal_name() {
		return (String) super.call("get_original_name", new java.lang.Object[0]);
	}

	public void setOriginal_name(String value) {
		super.call("set_original_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getLoop() {
		return (boolean) super.call("get_loop", new java.lang.Object[0]);
	}

	public void setLoop(boolean value) {
		super.call("set_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
