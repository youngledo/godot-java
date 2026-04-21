package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2i;

public class SubViewport extends Viewport {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 1130785943L), java.util.Map.entry("get_size_2d_override", 3690982128L),
			java.util.Map.entry("is_size_2d_override_stretch_enabled", 36873697L),
			java.util.Map.entry("get_update_mode", 2980171553L),
			java.util.Map.entry("set_size_2d_override", 1130785943L), java.util.Map.entry("get_clear_mode", 331324495L),
			java.util.Map.entry("set_size_2d_override_stretch", 2586408642L),
			java.util.Map.entry("set_update_mode", 1295690030L), java.util.Map.entry("get_size", 3690982128L),
			java.util.Map.entry("set_clear_mode", 2834454712L));

	SubViewport(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SubViewport(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_size_2d_override_stretch_enabled() {
		return (boolean) super.call("is_size_2d_override_stretch_enabled");
	}

	public Vector2i getSize() {
		return (Vector2i) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector2i value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getSize_2d_override() {
		return (Vector2i) super.call("get_size_2d_override", new java.lang.Object[0]);
	}

	public void setSize_2d_override(Vector2i value) {
		super.call("set_size_2d_override", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isSize_2d_override_stretch() {
		return (boolean) super.call("is_size_2d_override_stretch_enabled", new java.lang.Object[0]);
	}

	public void setSize_2d_override_stretch(boolean value) {
		super.call("set_size_2d_override_stretch", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getRender_target_clear_mode() {
		return (long) super.call("get_clear_mode", new java.lang.Object[0]);
	}

	public void setRender_target_clear_mode(long value) {
		super.call("set_clear_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRender_target_update_mode() {
		return (long) super.call("get_update_mode", new java.lang.Object[0]);
	}

	public void setRender_target_update_mode(long value) {
		super.call("set_update_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
