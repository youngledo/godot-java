package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDShaderSource extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_stage_source", 620821314L), java.util.Map.entry("get_language", 1063538261L),
			java.util.Map.entry("set_language", 3422186742L), java.util.Map.entry("get_stage_source", 3354920045L));

	RDShaderSource(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDShaderSource(long nativePointer) {
		super(nativePointer);
	}

	public void set_stage_source(int stage, String source) {
		super.call("set_stage_source",
				new java.lang.Object[]{java.lang.Integer.valueOf(stage), (java.lang.Object) source});
	}

	public String get_stage_source(int stage) {
		return (String) super.call("get_stage_source", new java.lang.Object[]{java.lang.Integer.valueOf(stage)});
	}

	public String getSource_vertex() {
		return (String) super.call("get_stage_source", new java.lang.Object[0]);
	}

	public void setSource_vertex(String value) {
		super.call("set_stage_source", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSource_fragment() {
		return (String) super.call("get_stage_source", new java.lang.Object[0]);
	}

	public void setSource_fragment(String value) {
		super.call("set_stage_source", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSource_tesselation_control() {
		return (String) super.call("get_stage_source", new java.lang.Object[0]);
	}

	public void setSource_tesselation_control(String value) {
		super.call("set_stage_source", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSource_tesselation_evaluation() {
		return (String) super.call("get_stage_source", new java.lang.Object[0]);
	}

	public void setSource_tesselation_evaluation(String value) {
		super.call("set_stage_source", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getSource_compute() {
		return (String) super.call("get_stage_source", new java.lang.Object[0]);
	}

	public void setSource_compute(String value) {
		super.call("set_stage_source", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLanguage() {
		return (long) super.call("get_language", new java.lang.Object[0]);
	}

	public void setLanguage(long value) {
		super.call("set_language", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
