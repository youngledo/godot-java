package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Vector2i;

public class RenderSceneBuffersConfiguration extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_fsr_sharpness", 373806689L),
			java.util.Map.entry("set_screen_space_aa", 139543108L),
			java.util.Map.entry("get_internal_size", 3690982128L),
			java.util.Map.entry("get_render_target", 2944877500L), java.util.Map.entry("get_view_count", 3905245786L),
			java.util.Map.entry("get_fsr_sharpness", 1740695150L), java.util.Map.entry("set_target_size", 1130785943L),
			java.util.Map.entry("set_view_count", 1286410249L),
			java.util.Map.entry("get_texture_mipmap_bias", 1740695150L),
			java.util.Map.entry("set_texture_mipmap_bias", 373806689L),
			java.util.Map.entry("set_render_target", 2722037293L),
			java.util.Map.entry("set_anisotropic_filtering_level", 2559658741L),
			java.util.Map.entry("get_screen_space_aa", 641513172L),
			java.util.Map.entry("get_anisotropic_filtering_level", 1617414954L),
			java.util.Map.entry("set_internal_size", 1130785943L), java.util.Map.entry("get_target_size", 3690982128L),
			java.util.Map.entry("get_scaling_3d_mode", 976778074L), java.util.Map.entry("get_msaa_3d", 3109158617L),
			java.util.Map.entry("set_msaa_3d", 3952630748L), java.util.Map.entry("set_scaling_3d_mode", 447477857L));

	RenderSceneBuffersConfiguration(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneBuffersConfiguration(long nativePointer) {
		super(nativePointer);
	}

	public long getRender_target() {
		return (long) super.call("get_render_target", new java.lang.Object[0]);
	}

	public void setRender_target(long value) {
		super.call("set_render_target", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2i getInternal_size() {
		return (Vector2i) super.call("get_internal_size", new java.lang.Object[0]);
	}

	public void setInternal_size(Vector2i value) {
		super.call("set_internal_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getTarget_size() {
		return (Vector2i) super.call("get_target_size", new java.lang.Object[0]);
	}

	public void setTarget_size(Vector2i value) {
		super.call("set_target_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getView_count() {
		return (long) super.call("get_view_count", new java.lang.Object[0]);
	}

	public void setView_count(long value) {
		super.call("set_view_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getScaling_3d_mode() {
		return (long) super.call("get_scaling_3d_mode", new java.lang.Object[0]);
	}

	public void setScaling_3d_mode(long value) {
		super.call("set_scaling_3d_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMsaa_3d() {
		return (long) super.call("get_msaa_3d", new java.lang.Object[0]);
	}

	public void setMsaa_3d(long value) {
		super.call("set_msaa_3d", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getScreen_space_aa() {
		return (long) super.call("get_screen_space_aa", new java.lang.Object[0]);
	}

	public void setScreen_space_aa(long value) {
		super.call("set_screen_space_aa", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getFsr_sharpness() {
		return (boolean) super.call("get_fsr_sharpness", new java.lang.Object[0]);
	}

	public void setFsr_sharpness(boolean value) {
		super.call("set_fsr_sharpness", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getTexture_mipmap_bias() {
		return (boolean) super.call("get_texture_mipmap_bias", new java.lang.Object[0]);
	}

	public void setTexture_mipmap_bias(boolean value) {
		super.call("set_texture_mipmap_bias", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getAnisotropic_filtering_level() {
		return (long) super.call("get_anisotropic_filtering_level", new java.lang.Object[0]);
	}

	public void setAnisotropic_filtering_level(long value) {
		super.call("set_anisotropic_filtering_level", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
