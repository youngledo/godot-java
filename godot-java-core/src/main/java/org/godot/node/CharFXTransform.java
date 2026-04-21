package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;
import org.godot.math.Color;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class CharFXTransform extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_environment", 4155329257L), java.util.Map.entry("get_color", 3200896285L),
			java.util.Map.entry("is_outline", 2240911060L), java.util.Map.entry("get_font", 2944877500L),
			java.util.Map.entry("set_font", 2722037293L), java.util.Map.entry("get_range", 2741790807L),
			java.util.Map.entry("set_range", 1130785943L), java.util.Map.entry("get_glyph_index", 3905245786L),
			java.util.Map.entry("set_glyph_count", 1286410249L), java.util.Map.entry("set_transform", 2761652528L),
			java.util.Map.entry("get_environment", 2382534195L), java.util.Map.entry("get_offset", 1497962370L),
			java.util.Map.entry("is_visible", 2240911060L), java.util.Map.entry("get_glyph_count", 3905245786L),
			java.util.Map.entry("get_glyph_flags", 3905245786L), java.util.Map.entry("set_visibility", 2586408642L),
			java.util.Map.entry("set_color", 2920490490L), java.util.Map.entry("get_transform", 3761352769L),
			java.util.Map.entry("set_relative_index", 1286410249L), java.util.Map.entry("get_elapsed_time", 191475506L),
			java.util.Map.entry("set_outline", 2586408642L), java.util.Map.entry("get_relative_index", 3905245786L),
			java.util.Map.entry("set_elapsed_time", 373806689L), java.util.Map.entry("set_glyph_index", 1286410249L),
			java.util.Map.entry("set_glyph_flags", 1286410249L), java.util.Map.entry("set_offset", 743155724L));

	CharFXTransform(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CharFXTransform(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_visible() {
		return (boolean) super.call("is_visible");
	}

	public boolean is_outline() {
		return (boolean) super.call("is_outline");
	}

	public Transform2D getTransform() {
		return (Transform2D) super.call("get_transform", new java.lang.Object[0]);
	}

	public void setTransform(Transform2D value) {
		super.call("set_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2i getRange() {
		return (Vector2i) super.call("get_range", new java.lang.Object[0]);
	}

	public void setRange(Vector2i value) {
		super.call("set_range", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getElapsed_time() {
		return (double) super.call("get_elapsed_time", new java.lang.Object[0]);
	}

	public void setElapsed_time(double value) {
		super.call("set_elapsed_time", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isVisible() {
		return (boolean) super.call("is_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visibility", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isOutline() {
		return (boolean) super.call("is_outline", new java.lang.Object[0]);
	}

	public void setOutline(boolean value) {
		super.call("set_outline", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getEnv() {
		return (GodotDictionary) super.call("get_environment", new java.lang.Object[0]);
	}

	public void setEnv(GodotDictionary value) {
		super.call("set_environment", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getGlyph_index() {
		return (long) super.call("get_glyph_index", new java.lang.Object[0]);
	}

	public void setGlyph_index(long value) {
		super.call("set_glyph_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getGlyph_count() {
		return (long) super.call("get_glyph_count", new java.lang.Object[0]);
	}

	public void setGlyph_count(long value) {
		super.call("set_glyph_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getGlyph_flags() {
		return (long) super.call("get_glyph_flags", new java.lang.Object[0]);
	}

	public void setGlyph_flags(long value) {
		super.call("set_glyph_flags", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getRelative_index() {
		return (long) super.call("get_relative_index", new java.lang.Object[0]);
	}

	public void setRelative_index(long value) {
		super.call("set_relative_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFont() {
		return (long) super.call("get_font", new java.lang.Object[0]);
	}

	public void setFont(long value) {
		super.call("set_font", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
