package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class CanvasItemMaterial extends Material {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_particles_anim_h_frames", 3905245786L),
			java.util.Map.entry("set_particles_anim_loop", 2586408642L),
			java.util.Map.entry("set_particles_animation", 2586408642L),
			java.util.Map.entry("get_particles_animation", 36873697L),
			java.util.Map.entry("get_particles_anim_v_frames", 3905245786L),
			java.util.Map.entry("get_blend_mode", 3318684035L), java.util.Map.entry("set_light_mode", 628074070L),
			java.util.Map.entry("get_particles_anim_loop", 36873697L),
			java.util.Map.entry("get_light_mode", 3863292382L),
			java.util.Map.entry("set_particles_anim_h_frames", 1286410249L),
			java.util.Map.entry("set_blend_mode", 1786054936L),
			java.util.Map.entry("set_particles_anim_v_frames", 1286410249L));

	CanvasItemMaterial(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CanvasItemMaterial(long nativePointer) {
		super(nativePointer);
	}

	public long getBlend_mode() {
		return (long) super.call("get_blend_mode", new java.lang.Object[0]);
	}

	public void setBlend_mode(long value) {
		super.call("set_blend_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getLight_mode() {
		return (long) super.call("get_light_mode", new java.lang.Object[0]);
	}

	public void setLight_mode(long value) {
		super.call("set_light_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getParticles_animation() {
		return (boolean) super.call("get_particles_animation", new java.lang.Object[0]);
	}

	public void setParticles_animation(boolean value) {
		super.call("set_particles_animation", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getParticles_anim_h_frames() {
		return (long) super.call("get_particles_anim_h_frames", new java.lang.Object[0]);
	}

	public void setParticles_anim_h_frames(long value) {
		super.call("set_particles_anim_h_frames", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getParticles_anim_v_frames() {
		return (long) super.call("get_particles_anim_v_frames", new java.lang.Object[0]);
	}

	public void setParticles_anim_v_frames(long value) {
		super.call("set_particles_anim_v_frames", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getParticles_anim_loop() {
		return (boolean) super.call("get_particles_anim_loop", new java.lang.Object[0]);
	}

	public void setParticles_anim_loop(boolean value) {
		super.call("set_particles_anim_loop", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
