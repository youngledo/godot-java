package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class ShaderInclude extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map
			.ofEntries(java.util.Map.entry("set_code", 83702148L), java.util.Map.entry("get_code", 201670096L));

	ShaderInclude(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ShaderInclude(long nativePointer) {
		super(nativePointer);
	}

	public String getCode() {
		return (String) super.call("get_code", new java.lang.Object[0]);
	}

	public void setCode(String value) {
		super.call("set_code", new java.lang.Object[]{(java.lang.Object) value});
	}
}
