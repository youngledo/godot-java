package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class FlowContainer extends Container {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_reverse_fill", 2586408642L), java.util.Map.entry("set_vertical", 2586408642L),
			java.util.Map.entry("is_reverse_fill", 36873697L), java.util.Map.entry("set_alignment", 575250951L),
			java.util.Map.entry("get_alignment", 3749743559L), java.util.Map.entry("is_vertical", 36873697L),
			java.util.Map.entry("set_last_wrap_alignment", 2899697495L),
			java.util.Map.entry("get_last_wrap_alignment", 3743456014L),
			java.util.Map.entry("get_line_count", 3905245786L));

	FlowContainer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FlowContainer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_vertical() {
		return (boolean) super.call("is_vertical");
	}

	public boolean is_reverse_fill() {
		return (boolean) super.call("is_reverse_fill");
	}

	public long getAlignment() {
		return (long) super.call("get_alignment", new java.lang.Object[0]);
	}

	public void setAlignment(long value) {
		super.call("set_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLast_wrap_alignment() {
		return (long) super.call("get_last_wrap_alignment", new java.lang.Object[0]);
	}

	public void setLast_wrap_alignment(long value) {
		super.call("set_last_wrap_alignment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isVertical() {
		return (boolean) super.call("is_vertical", new java.lang.Object[0]);
	}

	public void setVertical(boolean value) {
		super.call("set_vertical", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isReverse_fill() {
		return (boolean) super.call("is_reverse_fill", new java.lang.Object[0]);
	}

	public void setReverse_fill(boolean value) {
		super.call("set_reverse_fill", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
