package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class CanvasTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_texture_repeat", 2667158319L),
			java.util.Map.entry("get_texture_filter", 121960042L),
			java.util.Map.entry("set_normal_texture", 4051416890L),
			java.util.Map.entry("get_specular_shininess", 1740695150L),
			java.util.Map.entry("set_diffuse_texture", 4051416890L),
			java.util.Map.entry("get_specular_color", 3444240500L),
			java.util.Map.entry("get_specular_texture", 3635182373L),
			java.util.Map.entry("set_specular_shininess", 373806689L),
			java.util.Map.entry("get_diffuse_texture", 3635182373L),
			java.util.Map.entry("set_texture_filter", 1037999706L),
			java.util.Map.entry("set_texture_repeat", 1716472974L),
			java.util.Map.entry("set_specular_texture", 4051416890L),
			java.util.Map.entry("set_specular_color", 2920490490L),
			java.util.Map.entry("get_normal_texture", 3635182373L));

	CanvasTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CanvasTexture(long nativePointer) {
		super(nativePointer);
	}

	public Texture2D getDiffuse_texture() {
		return (Texture2D) super.call("get_diffuse_texture", new java.lang.Object[0]);
	}

	public void setDiffuse_texture(Texture2D value) {
		super.call("set_diffuse_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getNormal_texture() {
		return (Texture2D) super.call("get_normal_texture", new java.lang.Object[0]);
	}

	public void setNormal_texture(Texture2D value) {
		super.call("set_normal_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getSpecular_texture() {
		return (Texture2D) super.call("get_specular_texture", new java.lang.Object[0]);
	}

	public void setSpecular_texture(Texture2D value) {
		super.call("set_specular_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getSpecular_color() {
		return (Color) super.call("get_specular_color", new java.lang.Object[0]);
	}

	public void setSpecular_color(Color value) {
		super.call("set_specular_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getSpecular_shininess() {
		return (double) super.call("get_specular_shininess", new java.lang.Object[0]);
	}

	public void setSpecular_shininess(double value) {
		super.call("set_specular_shininess", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public long getTexture_filter() {
		return (long) super.call("get_texture_filter", new java.lang.Object[0]);
	}

	public void setTexture_filter(long value) {
		super.call("set_texture_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_repeat() {
		return (long) super.call("get_texture_repeat", new java.lang.Object[0]);
	}

	public void setTexture_repeat(long value) {
		super.call("set_texture_repeat", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
