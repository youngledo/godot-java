package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Color;

public class CollisionShape3D extends Node3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("resource_changed", 968641751L), java.util.Map.entry("set_disabled", 2586408642L),
			java.util.Map.entry("set_enable_debug_fill", 2586408642L), java.util.Map.entry("is_disabled", 36873697L),
			java.util.Map.entry("set_debug_color", 2920490490L),
			java.util.Map.entry("make_convex_from_siblings", 3218959716L),
			java.util.Map.entry("get_debug_color", 3444240500L), java.util.Map.entry("get_shape", 3214262478L),
			java.util.Map.entry("set_shape", 1549710052L), java.util.Map.entry("get_enable_debug_fill", 36873697L));

	CollisionShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CollisionShape3D(long nativePointer) {
		super(nativePointer);
	}

	public void resource_changed(Resource resource) {
		super.call("resource_changed", new java.lang.Object[]{(java.lang.Object) resource});
	}

	public boolean is_disabled() {
		return (boolean) super.call("is_disabled");
	}

	public void make_convex_from_siblings() {
		super.call("make_convex_from_siblings");
	}

	public Shape3D getShape() {
		return (Shape3D) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(Shape3D value) {
		super.call("set_shape", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isDisabled() {
		return (boolean) super.call("is_disabled", new java.lang.Object[0]);
	}

	public void setDisabled(boolean value) {
		super.call("set_disabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Color getDebug_color() {
		return (Color) super.call("get_debug_color", new java.lang.Object[0]);
	}

	public void setDebug_color(Color value) {
		super.call("set_debug_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getDebug_fill() {
		return (boolean) super.call("get_enable_debug_fill", new java.lang.Object[0]);
	}

	public void setDebug_fill(boolean value) {
		super.call("set_enable_debug_fill", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
