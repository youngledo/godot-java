package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class Slider extends Range {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_ticks_on_borders", 2586408642L),
			java.util.Map.entry("set_ticks_position", 2952822224L), java.util.Map.entry("set_editable", 2586408642L),
			java.util.Map.entry("is_editable", 36873697L), java.util.Map.entry("get_ticks_position", 3567635531L),
			java.util.Map.entry("set_scrollable", 2586408642L), java.util.Map.entry("set_ticks", 1286410249L),
			java.util.Map.entry("is_scrollable", 36873697L), java.util.Map.entry("get_ticks", 3905245786L),
			java.util.Map.entry("get_ticks_on_borders", 36873697L));

	Slider(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Slider(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_editable() {
		return (boolean) super.call("is_editable");
	}

	public boolean is_scrollable() {
		return (boolean) super.call("is_scrollable");
	}

	public boolean isEditable() {
		return (boolean) super.call("is_editable", new java.lang.Object[0]);
	}

	public void setEditable(boolean value) {
		super.call("set_editable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isScrollable() {
		return (boolean) super.call("is_scrollable", new java.lang.Object[0]);
	}

	public void setScrollable(boolean value) {
		super.call("set_scrollable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTick_count() {
		return (long) super.call("get_ticks", new java.lang.Object[0]);
	}

	public void setTick_count(long value) {
		super.call("set_ticks", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getTicks_on_borders() {
		return (boolean) super.call("get_ticks_on_borders", new java.lang.Object[0]);
	}

	public void setTicks_on_borders(boolean value) {
		super.call("set_ticks_on_borders", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getTicks_position() {
		return (long) super.call("get_ticks_position", new java.lang.Object[0]);
	}

	public void setTicks_position(long value) {
		super.call("set_ticks_position", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
