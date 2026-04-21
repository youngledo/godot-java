package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CompositorEffect extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_access_resolved_depth", 36873697L),
			java.util.Map.entry("get_needs_separate_specular", 36873697L),
			java.util.Map.entry("get_enabled", 36873697L), java.util.Map.entry("set_effect_callback_type", 1390728419L),
			java.util.Map.entry("get_access_resolved_color", 36873697L),
			java.util.Map.entry("get_needs_normal_roughness", 36873697L),
			java.util.Map.entry("set_enabled", 2586408642L),
			java.util.Map.entry("set_access_resolved_depth", 2586408642L),
			java.util.Map.entry("set_needs_normal_roughness", 2586408642L),
			java.util.Map.entry("get_effect_callback_type", 1221912590L),
			java.util.Map.entry("get_needs_motion_vectors", 36873697L),
			java.util.Map.entry("set_needs_motion_vectors", 2586408642L),
			java.util.Map.entry("set_access_resolved_color", 2586408642L),
			java.util.Map.entry("set_needs_separate_specular", 2586408642L));

	CompositorEffect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CompositorEffect(long nativePointer) {
		super(nativePointer);
	}

	public boolean getEnabled() {
		return (boolean) super.call("get_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getEffect_callback_type() {
		return (long) super.call("get_effect_callback_type", new java.lang.Object[0]);
	}

	public void setEffect_callback_type(long value) {
		super.call("set_effect_callback_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getAccess_resolved_color() {
		return (boolean) super.call("get_access_resolved_color", new java.lang.Object[0]);
	}

	public void setAccess_resolved_color(boolean value) {
		super.call("set_access_resolved_color", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getAccess_resolved_depth() {
		return (boolean) super.call("get_access_resolved_depth", new java.lang.Object[0]);
	}

	public void setAccess_resolved_depth(boolean value) {
		super.call("set_access_resolved_depth", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getNeeds_motion_vectors() {
		return (boolean) super.call("get_needs_motion_vectors", new java.lang.Object[0]);
	}

	public void setNeeds_motion_vectors(boolean value) {
		super.call("set_needs_motion_vectors", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getNeeds_normal_roughness() {
		return (boolean) super.call("get_needs_normal_roughness", new java.lang.Object[0]);
	}

	public void setNeeds_normal_roughness(boolean value) {
		super.call("set_needs_normal_roughness", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getNeeds_separate_specular() {
		return (boolean) super.call("get_needs_separate_specular", new java.lang.Object[0]);
	}

	public void setNeeds_separate_specular(boolean value) {
		super.call("set_needs_separate_specular", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
