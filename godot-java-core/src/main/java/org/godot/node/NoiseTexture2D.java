package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class NoiseTexture2D extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_noise", 185851837L), java.util.Map.entry("set_generate_mipmaps", 2586408642L),
			java.util.Map.entry("set_color_ramp", 2756054477L), java.util.Map.entry("get_bump_strength", 191475506L),
			java.util.Map.entry("set_as_normal_map", 2586408642L), java.util.Map.entry("set_width", 1286410249L),
			java.util.Map.entry("get_invert", 36873697L), java.util.Map.entry("set_height", 1286410249L),
			java.util.Map.entry("is_in_3d_space", 36873697L), java.util.Map.entry("is_normal_map", 2240911060L),
			java.util.Map.entry("get_seamless", 2240911060L),
			java.util.Map.entry("get_seamless_blend_skirt", 191475506L),
			java.util.Map.entry("is_normalized", 36873697L), java.util.Map.entry("set_bump_strength", 373806689L),
			java.util.Map.entry("set_noise", 4135492439L), java.util.Map.entry("set_invert", 2586408642L),
			java.util.Map.entry("set_in_3d_space", 2586408642L),
			java.util.Map.entry("set_seamless_blend_skirt", 373806689L),
			java.util.Map.entry("set_seamless", 2586408642L), java.util.Map.entry("set_normalize", 2586408642L),
			java.util.Map.entry("is_generating_mipmaps", 36873697L), java.util.Map.entry("get_color_ramp", 132272999L));

	NoiseTexture2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NoiseTexture2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_generating_mipmaps() {
		return (boolean) super.call("is_generating_mipmaps");
	}

	public boolean is_in_3d_space() {
		return (boolean) super.call("is_in_3d_space");
	}

	public boolean is_normal_map() {
		return (boolean) super.call("is_normal_map");
	}

	public boolean is_normalized() {
		return (boolean) super.call("is_normalized");
	}

	public long getWidth() {
		return (long) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(long value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHeight() {
		return (long) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(long value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isGenerate_mipmaps() {
		return (boolean) super.call("is_generating_mipmaps", new java.lang.Object[0]);
	}

	public void setGenerate_mipmaps(boolean value) {
		super.call("set_generate_mipmaps", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Noise getNoise() {
		return (Noise) super.call("get_noise", new java.lang.Object[0]);
	}

	public void setNoise(Noise value) {
		super.call("set_noise", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Gradient getColor_ramp() {
		return (Gradient) super.call("get_color_ramp", new java.lang.Object[0]);
	}

	public void setColor_ramp(Gradient value) {
		super.call("set_color_ramp", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getSeamless() {
		return (boolean) super.call("get_seamless", new java.lang.Object[0]);
	}

	public void setSeamless(boolean value) {
		super.call("set_seamless", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getInvert() {
		return (boolean) super.call("get_invert", new java.lang.Object[0]);
	}

	public void setInvert(boolean value) {
		super.call("set_invert", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isIn_3d_space() {
		return (boolean) super.call("is_in_3d_space", new java.lang.Object[0]);
	}

	public void setIn_3d_space(boolean value) {
		super.call("set_in_3d_space", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isAs_normal_map() {
		return (boolean) super.call("is_normal_map", new java.lang.Object[0]);
	}

	public void setAs_normal_map(boolean value) {
		super.call("set_as_normal_map", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isNormalize() {
		return (boolean) super.call("is_normalized", new java.lang.Object[0]);
	}

	public void setNormalize(boolean value) {
		super.call("set_normalize", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getSeamless_blend_skirt() {
		return (double) super.call("get_seamless_blend_skirt", new java.lang.Object[0]);
	}

	public void setSeamless_blend_skirt(double value) {
		super.call("set_seamless_blend_skirt", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getBump_strength() {
		return (double) super.call("get_bump_strength", new java.lang.Object[0]);
	}

	public void setBump_strength(double value) {
		super.call("set_bump_strength", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
