package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.math.Rect2i;
import org.godot.math.Vector2;

public class XRVRS extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_vrs_strength", 1740695150L),
			java.util.Map.entry("set_vrs_render_region", 1763793166L),
			java.util.Map.entry("get_vrs_min_radius", 1740695150L),
			java.util.Map.entry("get_vrs_render_region", 410525958L),
			java.util.Map.entry("set_vrs_min_radius", 373806689L), java.util.Map.entry("make_vrs_texture", 3647044786L),
			java.util.Map.entry("set_vrs_strength", 373806689L));

	XRVRS(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XRVRS(long nativePointer) {
		super(nativePointer);
	}

	public long make_vrs_texture(Vector2 target_size, double[][] eye_foci) {
		return (long) super.call("make_vrs_texture",
				new java.lang.Object[]{(java.lang.Object) target_size, (java.lang.Object) eye_foci});
	}

	public double getVrs_min_radius() {
		return (double) super.call("get_vrs_min_radius", new java.lang.Object[0]);
	}

	public void setVrs_min_radius(double value) {
		super.call("set_vrs_min_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getVrs_strength() {
		return (double) super.call("get_vrs_strength", new java.lang.Object[0]);
	}

	public void setVrs_strength(double value) {
		super.call("set_vrs_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Rect2i getVrs_render_region() {
		return (Rect2i) super.call("get_vrs_render_region", new java.lang.Object[0]);
	}

	public void setVrs_render_region(Rect2i value) {
		super.call("set_vrs_render_region", new java.lang.Object[]{(java.lang.Object) value});
	}
}
