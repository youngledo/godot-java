package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class RDShaderSPIRV extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_stage_compile_error", 3354920045L),
			java.util.Map.entry("set_stage_bytecode", 3514097977L),
			java.util.Map.entry("get_stage_bytecode", 3816765404L),
			java.util.Map.entry("set_stage_compile_error", 620821314L));

	RDShaderSPIRV(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDShaderSPIRV(long nativePointer) {
		super(nativePointer);
	}

	public void set_stage_bytecode(int stage, byte[] bytecode) {
		super.call("set_stage_bytecode",
				new java.lang.Object[]{java.lang.Integer.valueOf(stage), (java.lang.Object) bytecode});
	}

	public byte[] get_stage_bytecode(int stage) {
		return (byte[]) super.call("get_stage_bytecode", new java.lang.Object[]{java.lang.Integer.valueOf(stage)});
	}

	public void set_stage_compile_error(int stage, String compile_error) {
		super.call("set_stage_compile_error",
				new java.lang.Object[]{java.lang.Integer.valueOf(stage), (java.lang.Object) compile_error});
	}

	public String get_stage_compile_error(int stage) {
		return (String) super.call("get_stage_compile_error", new java.lang.Object[]{java.lang.Integer.valueOf(stage)});
	}

	public byte[] getBytecode_vertex() {
		return (byte[]) super.call("get_stage_bytecode", new java.lang.Object[0]);
	}

	public void setBytecode_vertex(byte[] value) {
		super.call("set_stage_bytecode", new java.lang.Object[]{(java.lang.Object) value});
	}

	public byte[] getBytecode_fragment() {
		return (byte[]) super.call("get_stage_bytecode", new java.lang.Object[0]);
	}

	public void setBytecode_fragment(byte[] value) {
		super.call("set_stage_bytecode", new java.lang.Object[]{(java.lang.Object) value});
	}

	public byte[] getBytecode_tesselation_control() {
		return (byte[]) super.call("get_stage_bytecode", new java.lang.Object[0]);
	}

	public void setBytecode_tesselation_control(byte[] value) {
		super.call("set_stage_bytecode", new java.lang.Object[]{(java.lang.Object) value});
	}

	public byte[] getBytecode_tesselation_evaluation() {
		return (byte[]) super.call("get_stage_bytecode", new java.lang.Object[0]);
	}

	public void setBytecode_tesselation_evaluation(byte[] value) {
		super.call("set_stage_bytecode", new java.lang.Object[]{(java.lang.Object) value});
	}

	public byte[] getBytecode_compute() {
		return (byte[]) super.call("get_stage_bytecode", new java.lang.Object[0]);
	}

	public void setBytecode_compute(byte[] value) {
		super.call("set_stage_bytecode", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCompile_error_vertex() {
		return (String) super.call("get_stage_compile_error", new java.lang.Object[0]);
	}

	public void setCompile_error_vertex(String value) {
		super.call("set_stage_compile_error", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCompile_error_fragment() {
		return (String) super.call("get_stage_compile_error", new java.lang.Object[0]);
	}

	public void setCompile_error_fragment(String value) {
		super.call("set_stage_compile_error", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCompile_error_tesselation_control() {
		return (String) super.call("get_stage_compile_error", new java.lang.Object[0]);
	}

	public void setCompile_error_tesselation_control(String value) {
		super.call("set_stage_compile_error", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCompile_error_tesselation_evaluation() {
		return (String) super.call("get_stage_compile_error", new java.lang.Object[0]);
	}

	public void setCompile_error_tesselation_evaluation(String value) {
		super.call("set_stage_compile_error", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getCompile_error_compute() {
		return (String) super.call("get_stage_compile_error", new java.lang.Object[0]);
	}

	public void setCompile_error_compute(String value) {
		super.call("set_stage_compile_error", new java.lang.Object[]{(java.lang.Object) value});
	}
}
