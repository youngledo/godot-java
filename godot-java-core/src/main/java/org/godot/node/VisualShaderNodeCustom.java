package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeCustom extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("get_option_index", 923996154L));

	VisualShaderNodeCustom(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeCustom(long nativePointer) {
		super(nativePointer);
	}

	public int get_option_index(long option) {
		return (int) super.call("get_option_index", new java.lang.Object[]{java.lang.Long.valueOf(option)});
	}

	public boolean getInitialized() {
		return (boolean) super.call("_is_initialized", new java.lang.Object[0]);
	}

	public void setInitialized(boolean value) {
		super.call("_set_initialized", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getProperties() {
		return (String) super.call("_get_properties", new java.lang.Object[0]);
	}

	public void setProperties(String value) {
		super.call("_set_properties", new java.lang.Object[]{(java.lang.Object) value});
	}
}
