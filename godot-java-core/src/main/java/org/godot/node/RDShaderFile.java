package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class RDShaderFile extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_spirv", 2689310080L), java.util.Map.entry("get_base_error", 201670096L),
			java.util.Map.entry("set_bytecode", 1526857008L), java.util.Map.entry("get_version_list", 3995934104L),
			java.util.Map.entry("set_base_error", 83702148L));

	RDShaderFile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDShaderFile(long nativePointer) {
		super(nativePointer);
	}

	public void set_bytecode(RDShaderSPIRV bytecode, String version) {
		super.call("set_bytecode", new java.lang.Object[]{(java.lang.Object) bytecode, (java.lang.Object) version});
	}

	public RDShaderSPIRV get_spirv(String version) {
		return (RDShaderSPIRV) super.call("get_spirv", new java.lang.Object[]{(java.lang.Object) version});
	}

	public String getBase_error() {
		return (String) super.call("get_base_error", new java.lang.Object[0]);
	}

	public void setBase_error(String value) {
		super.call("set_base_error", new java.lang.Object[]{(java.lang.Object) value});
	}
}
