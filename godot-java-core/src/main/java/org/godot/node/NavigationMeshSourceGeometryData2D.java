package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;

public class NavigationMeshSourceGeometryData2D extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("add_obstruction_outline", 1509147220L),
			java.util.Map.entry("get_traversable_outlines", 3995934104L),
			java.util.Map.entry("get_obstruction_outlines", 3995934104L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("clear_projected_obstructions", 3218959716L),
			java.util.Map.entry("get_bounds", 3248174L), java.util.Map.entry("add_traversable_outline", 1509147220L),
			java.util.Map.entry("get_projected_obstructions", 3995934104L),
			java.util.Map.entry("has_data", 2240911060L), java.util.Map.entry("set_projected_obstructions", 381264803L),
			java.util.Map.entry("merge", 742424872L), java.util.Map.entry("append_obstruction_outlines", 381264803L),
			java.util.Map.entry("set_traversable_outlines", 381264803L),
			java.util.Map.entry("add_projected_obstruction", 3882407395L),
			java.util.Map.entry("set_obstruction_outlines", 381264803L),
			java.util.Map.entry("append_traversable_outlines", 381264803L));

	NavigationMeshSourceGeometryData2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	NavigationMeshSourceGeometryData2D(long nativePointer) {
		super(nativePointer);
	}

	public void clear() {
		super.call("clear");
	}

	public boolean has_data() {
		return (boolean) super.call("has_data");
	}

	public void append_traversable_outlines(Object[] traversable_outlines) {
		super.call("append_traversable_outlines", new java.lang.Object[]{(java.lang.Object) traversable_outlines});
	}

	public void append_obstruction_outlines(Object[] obstruction_outlines) {
		super.call("append_obstruction_outlines", new java.lang.Object[]{(java.lang.Object) obstruction_outlines});
	}

	public void add_traversable_outline(double[][] shape_outline) {
		super.call("add_traversable_outline", new java.lang.Object[]{(java.lang.Object) shape_outline});
	}

	public void add_obstruction_outline(double[][] shape_outline) {
		super.call("add_obstruction_outline", new java.lang.Object[]{(java.lang.Object) shape_outline});
	}

	public void merge(NavigationMeshSourceGeometryData2D other_geometry) {
		super.call("merge", new java.lang.Object[]{(java.lang.Object) other_geometry});
	}

	public void add_projected_obstruction(double[][] vertices, boolean carve) {
		super.call("add_projected_obstruction",
				new java.lang.Object[]{(java.lang.Object) vertices, java.lang.Boolean.valueOf(carve)});
	}

	public void clear_projected_obstructions() {
		super.call("clear_projected_obstructions");
	}

	public GodotArray getTraversable_outlines() {
		return (GodotArray) super.call("get_traversable_outlines", new java.lang.Object[0]);
	}

	public void setTraversable_outlines(GodotArray value) {
		super.call("set_traversable_outlines", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getObstruction_outlines() {
		return (GodotArray) super.call("get_obstruction_outlines", new java.lang.Object[0]);
	}

	public void setObstruction_outlines(GodotArray value) {
		super.call("set_obstruction_outlines", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getProjected_obstructions() {
		return (GodotArray) super.call("get_projected_obstructions", new java.lang.Object[0]);
	}

	public void setProjected_obstructions(GodotArray value) {
		super.call("set_projected_obstructions", new java.lang.Object[]{(java.lang.Object) value});
	}
}
