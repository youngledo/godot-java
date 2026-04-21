package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.math.Color;
import org.godot.math.Vector2;

public class Polygon2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_antialiased", 36873697L), java.util.Map.entry("set_texture_offset", 743155724L),
			java.util.Map.entry("set_polygons", 381264803L), java.util.Map.entry("clear_bones", 3218959716L),
			java.util.Map.entry("erase_bone", 1286410249L), java.util.Map.entry("set_polygon", 1509147220L),
			java.util.Map.entry("get_polygon", 2961356807L), java.util.Map.entry("get_color", 3444240500L),
			java.util.Map.entry("set_texture_scale", 743155724L),
			java.util.Map.entry("set_texture_rotation", 373806689L),
			java.util.Map.entry("set_invert_border", 373806689L),
			java.util.Map.entry("get_texture_rotation", 1740695150L),
			java.util.Map.entry("get_invert_enabled", 36873697L),
			java.util.Map.entry("get_texture_offset", 3341600327L), java.util.Map.entry("set_skeleton", 1348162250L),
			java.util.Map.entry("set_uv", 1509147220L), java.util.Map.entry("set_invert_enabled", 2586408642L),
			java.util.Map.entry("set_antialiased", 2586408642L), java.util.Map.entry("get_polygons", 3995934104L),
			java.util.Map.entry("get_invert_border", 1740695150L), java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("get_uv", 2961356807L), java.util.Map.entry("get_internal_vertex_count", 3905245786L),
			java.util.Map.entry("set_vertex_colors", 3546319833L), java.util.Map.entry("set_bone_weights", 1345852415L),
			java.util.Map.entry("get_skeleton", 4075236667L),
			java.util.Map.entry("set_internal_vertex_count", 1286410249L),
			java.util.Map.entry("set_color", 2920490490L), java.util.Map.entry("add_bone", 703042815L),
			java.util.Map.entry("get_texture_scale", 3341600327L), java.util.Map.entry("get_bone_path", 408788394L),
			java.util.Map.entry("get_bone_count", 3905245786L), java.util.Map.entry("get_vertex_colors", 1392750486L),
			java.util.Map.entry("get_bone_weights", 1542882410L), java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("set_bone_path", 2761262315L), java.util.Map.entry("set_offset", 743155724L),
			java.util.Map.entry("get_texture", 3635182373L));

	Polygon2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Polygon2D(long nativePointer) {
		super(nativePointer);
	}

	public void add_bone(String path, double[] weights) {
		super.call("add_bone", new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) weights});
	}

	public String get_bone_path(long index) {
		return (String) super.call("get_bone_path", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public double[] get_bone_weights(long index) {
		return (double[]) super.call("get_bone_weights", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void erase_bone(long index) {
		super.call("erase_bone", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_bones() {
		super.call("clear_bones");
	}

	public void set_bone_path(long index, String path) {
		super.call("set_bone_path", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) path});
	}

	public void set_bone_weights(long index, double[] weights) {
		super.call("set_bone_weights",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) weights});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getAntialiased() {
		return (boolean) super.call("get_antialiased", new java.lang.Object[0]);
	}

	public void setAntialiased(boolean value) {
		super.call("set_antialiased", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getTexture_offset() {
		return (Vector2) super.call("get_texture_offset", new java.lang.Object[0]);
	}

	public void setTexture_offset(Vector2 value) {
		super.call("set_texture_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector2 getTexture_scale() {
		return (Vector2) super.call("get_texture_scale", new java.lang.Object[0]);
	}

	public void setTexture_scale(Vector2 value) {
		super.call("set_texture_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getTexture_rotation() {
		return (double) super.call("get_texture_rotation", new java.lang.Object[0]);
	}

	public void setTexture_rotation(double value) {
		super.call("set_texture_rotation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getSkeleton() {
		return (String) super.call("get_skeleton", new java.lang.Object[0]);
	}

	public void setSkeleton(String value) {
		super.call("set_skeleton", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getInvert_enabled() {
		return (boolean) super.call("get_invert_enabled", new java.lang.Object[0]);
	}

	public void setInvert_enabled(boolean value) {
		super.call("set_invert_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getInvert_border() {
		return (double) super.call("get_invert_border", new java.lang.Object[0]);
	}

	public void setInvert_border(double value) {
		super.call("set_invert_border", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double[][] getPolygon() {
		return (double[][]) super.call("get_polygon", new java.lang.Object[0]);
	}

	public void setPolygon(double[][] value) {
		super.call("set_polygon", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getUv() {
		return (double[][]) super.call("get_uv", new java.lang.Object[0]);
	}

	public void setUv(double[][] value) {
		super.call("set_uv", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[][] getVertex_colors() {
		return (double[][]) super.call("get_vertex_colors", new java.lang.Object[0]);
	}

	public void setVertex_colors(double[][] value) {
		super.call("set_vertex_colors", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getPolygons() {
		return (GodotArray) super.call("get_polygons", new java.lang.Object[0]);
	}

	public void setPolygons(GodotArray value) {
		super.call("set_polygons", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getBones() {
		return (GodotArray) super.call("_get_bones", new java.lang.Object[0]);
	}

	public void setBones(GodotArray value) {
		super.call("_set_bones", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getInternal_vertex_count() {
		return (long) super.call("get_internal_vertex_count", new java.lang.Object[0]);
	}

	public void setInternal_vertex_count(long value) {
		super.call("set_internal_vertex_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
