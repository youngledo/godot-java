package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Transform2D;

public class FontVariation extends Font {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_variation_embolden", 1740695150L),
			java.util.Map.entry("set_base_font", 1262170328L),
			java.util.Map.entry("set_variation_opentype", 4155329257L),
			java.util.Map.entry("set_variation_embolden", 373806689L),
			java.util.Map.entry("set_variation_face_index", 1286410249L),
			java.util.Map.entry("get_base_font", 3229501585L),
			java.util.Map.entry("get_variation_face_index", 3905245786L),
			java.util.Map.entry("get_baseline_offset", 1740695150L),
			java.util.Map.entry("set_opentype_features", 4155329257L),
			java.util.Map.entry("get_variation_opentype", 3102165223L),
			java.util.Map.entry("set_baseline_offset", 373806689L), java.util.Map.entry("set_spacing", 3122339690L),
			java.util.Map.entry("set_variation_transform", 2761652528L),
			java.util.Map.entry("get_variation_transform", 3814499831L));

	FontVariation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FontVariation(long nativePointer) {
		super(nativePointer);
	}

	public void set_spacing(int spacing, long value) {
		super.call("set_spacing",
				new java.lang.Object[]{java.lang.Integer.valueOf(spacing), java.lang.Long.valueOf(value)});
	}

	public Font getBase_font() {
		return (Font) super.call("get_base_font", new java.lang.Object[0]);
	}

	public void setBase_font(Font value) {
		super.call("set_base_font", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getVariation_opentype() {
		return (GodotDictionary) super.call("get_variation_opentype", new java.lang.Object[0]);
	}

	public void setVariation_opentype(GodotDictionary value) {
		super.call("set_variation_opentype", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getVariation_face_index() {
		return (long) super.call("get_variation_face_index", new java.lang.Object[0]);
	}

	public void setVariation_face_index(long value) {
		super.call("set_variation_face_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getVariation_embolden() {
		return (double) super.call("get_variation_embolden", new java.lang.Object[0]);
	}

	public void setVariation_embolden(double value) {
		super.call("set_variation_embolden", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Transform2D getVariation_transform() {
		return (Transform2D) super.call("get_variation_transform", new java.lang.Object[0]);
	}

	public void setVariation_transform(Transform2D value) {
		super.call("set_variation_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getOpentype_features() {
		return (GodotDictionary) super.call("get_opentype_features", new java.lang.Object[0]);
	}

	public void setOpentype_features(GodotDictionary value) {
		super.call("set_opentype_features", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSpacing_glyph() {
		return (long) super.call("get_spacing", new java.lang.Object[0]);
	}

	public void setSpacing_glyph(long value) {
		super.call("set_spacing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSpacing_space() {
		return (long) super.call("get_spacing", new java.lang.Object[0]);
	}

	public void setSpacing_space(long value) {
		super.call("set_spacing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSpacing_top() {
		return (long) super.call("get_spacing", new java.lang.Object[0]);
	}

	public void setSpacing_top(long value) {
		super.call("set_spacing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSpacing_bottom() {
		return (long) super.call("get_spacing", new java.lang.Object[0]);
	}

	public void setSpacing_bottom(long value) {
		super.call("set_spacing", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getBaseline_offset() {
		return (double) super.call("get_baseline_offset", new java.lang.Object[0]);
	}

	public void setBaseline_offset(double value) {
		super.call("set_baseline_offset", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
