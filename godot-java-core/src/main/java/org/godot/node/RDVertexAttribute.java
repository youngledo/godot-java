package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDVertexAttribute extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_binding", 3905245786L), java.util.Map.entry("get_offset", 3905245786L),
			java.util.Map.entry("get_frequency", 4154106413L), java.util.Map.entry("set_location", 1286410249L),
			java.util.Map.entry("set_format", 565531219L), java.util.Map.entry("get_format", 2235804183L),
			java.util.Map.entry("set_frequency", 522141836L), java.util.Map.entry("get_stride", 3905245786L),
			java.util.Map.entry("set_binding", 1286410249L), java.util.Map.entry("set_offset", 1286410249L),
			java.util.Map.entry("set_stride", 1286410249L), java.util.Map.entry("get_location", 3905245786L));

	RDVertexAttribute(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDVertexAttribute(long nativePointer) {
		super(nativePointer);
	}

	public long getBinding() {
		return (long) super.call("get_binding", new java.lang.Object[0]);
	}

	public void setBinding(long value) {
		super.call("set_binding", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLocation() {
		return (long) super.call("get_location", new java.lang.Object[0]);
	}

	public void setLocation(long value) {
		super.call("set_location", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getOffset() {
		return (long) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(long value) {
		super.call("set_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFormat() {
		return (long) super.call("get_format", new java.lang.Object[0]);
	}

	public void setFormat(long value) {
		super.call("set_format", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getStride() {
		return (long) super.call("get_stride", new java.lang.Object[0]);
	}

	public void setStride(long value) {
		super.call("set_stride", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFrequency() {
		return (long) super.call("get_frequency", new java.lang.Object[0]);
	}

	public void setFrequency(long value) {
		super.call("set_frequency", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
