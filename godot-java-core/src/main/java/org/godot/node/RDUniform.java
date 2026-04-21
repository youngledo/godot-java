package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDUniform extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_binding", 3905245786L), java.util.Map.entry("clear_ids", 3218959716L),
			java.util.Map.entry("get_ids", 3995934104L), java.util.Map.entry("set_uniform_type", 1664894931L),
			java.util.Map.entry("set_binding", 1286410249L), java.util.Map.entry("get_uniform_type", 475470040L),
			java.util.Map.entry("add_id", 2722037293L));

	RDUniform(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDUniform(long nativePointer) {
		super(nativePointer);
	}

	public void add_id(long id) {
		super.call("add_id", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void clear_ids() {
		super.call("clear_ids");
	}

	public long getUniform_type() {
		return (long) super.call("get_uniform_type", new java.lang.Object[0]);
	}

	public void setUniform_type(long value) {
		super.call("set_uniform_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getBinding() {
		return (long) super.call("get_binding", new java.lang.Object[0]);
	}

	public void setBinding(long value) {
		super.call("set_binding", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
