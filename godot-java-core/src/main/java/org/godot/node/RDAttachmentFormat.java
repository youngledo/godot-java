package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDAttachmentFormat extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_format", 565531219L), java.util.Map.entry("set_samples", 3774171498L),
			java.util.Map.entry("get_format", 2235804183L), java.util.Map.entry("set_usage_flags", 1286410249L),
			java.util.Map.entry("get_samples", 407791724L), java.util.Map.entry("get_usage_flags", 3905245786L));

	RDAttachmentFormat(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDAttachmentFormat(long nativePointer) {
		super(nativePointer);
	}

	public long getFormat() {
		return (long) super.call("get_format", new java.lang.Object[0]);
	}

	public void setFormat(long value) {
		super.call("set_format", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSamples() {
		return (long) super.call("get_samples", new java.lang.Object[0]);
	}

	public void setSamples(long value) {
		super.call("set_samples", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getUsage_flags() {
		return (long) super.call("get_usage_flags", new java.lang.Object[0]);
	}

	public void setUsage_flags(long value) {
		super.call("set_usage_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
