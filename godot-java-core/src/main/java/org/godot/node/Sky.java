package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Sky extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_process_mode", 731245043L), java.util.Map.entry("set_process_mode", 875986769L),
			java.util.Map.entry("set_material", 2757459619L), java.util.Map.entry("get_material", 5934680L),
			java.util.Map.entry("set_radiance_size", 1512957179L),
			java.util.Map.entry("get_radiance_size", 2708733976L));

	Sky(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Sky(long nativePointer) {
		super(nativePointer);
	}

	public Object getSky_material() {
		return (Object) super.call("get_material", new java.lang.Object[0]);
	}

	public void setSky_material(Object value) {
		super.call("set_material", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getProcess_mode() {
		return (long) super.call("get_process_mode", new java.lang.Object[0]);
	}

	public void setProcess_mode(long value) {
		super.call("set_process_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRadiance_size() {
		return (long) super.call("get_radiance_size", new java.lang.Object[0]);
	}

	public void setRadiance_size(long value) {
		super.call("set_radiance_size", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
