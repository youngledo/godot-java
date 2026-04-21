package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.math.Color;

public class GLTFSpecGloss extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_spec_gloss_img", 564927088L),
			java.util.Map.entry("set_specular_factor", 2920490490L),
			java.util.Map.entry("get_gloss_factor", 191475506L), java.util.Map.entry("set_diffuse_img", 532598488L),
			java.util.Map.entry("get_diffuse_factor", 3200896285L), java.util.Map.entry("get_diffuse_img", 564927088L),
			java.util.Map.entry("set_diffuse_factor", 2920490490L), java.util.Map.entry("set_gloss_factor", 373806689L),
			java.util.Map.entry("get_specular_factor", 3200896285L),
			java.util.Map.entry("set_spec_gloss_img", 532598488L));

	GLTFSpecGloss(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFSpecGloss(long nativePointer) {
		super(nativePointer);
	}

	public GodotObject getDiffuse_img() {
		return (GodotObject) super.call("get_diffuse_img", new java.lang.Object[0]);
	}

	public void setDiffuse_img(GodotObject value) {
		super.call("set_diffuse_img", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getDiffuse_factor() {
		return (Color) super.call("get_diffuse_factor", new java.lang.Object[0]);
	}

	public void setDiffuse_factor(Color value) {
		super.call("set_diffuse_factor", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getGloss_factor() {
		return (double) super.call("get_gloss_factor", new java.lang.Object[0]);
	}

	public void setGloss_factor(double value) {
		super.call("set_gloss_factor", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Color getSpecular_factor() {
		return (Color) super.call("get_specular_factor", new java.lang.Object[0]);
	}

	public void setSpecular_factor(Color value) {
		super.call("set_specular_factor", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotObject getSpec_gloss_img() {
		return (GodotObject) super.call("get_spec_gloss_img", new java.lang.Object[0]);
	}

	public void setSpec_gloss_img(GodotObject value) {
		super.call("set_spec_gloss_img", new java.lang.Object[]{(java.lang.Object) value});
	}
}
