package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform2D;
import org.godot.math.Vector2;

public class CanvasLayer extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("get_follow_viewport_scale", 1740695150L), java.util.Map.entry("is_visible", 36873697L),
			java.util.Map.entry("get_custom_viewport", 3160264692L), java.util.Map.entry("get_layer", 3905245786L),
			java.util.Map.entry("show", 3218959716L), java.util.Map.entry("get_final_transform", 3814499831L),
			java.util.Map.entry("set_scale", 743155724L), java.util.Map.entry("set_visible", 2586408642L),
			java.util.Map.entry("is_following_viewport", 36873697L), java.util.Map.entry("get_transform", 3814499831L),
			java.util.Map.entry("get_scale", 3341600327L), java.util.Map.entry("set_follow_viewport", 2586408642L),
			java.util.Map.entry("hide", 3218959716L), java.util.Map.entry("set_rotation", 373806689L),
			java.util.Map.entry("set_layer", 1286410249L), java.util.Map.entry("set_follow_viewport_scale", 373806689L),
			java.util.Map.entry("set_custom_viewport", 1078189570L), java.util.Map.entry("set_transform", 2761652528L),
			java.util.Map.entry("set_offset", 743155724L), java.util.Map.entry("get_rotation", 1740695150L),
			java.util.Map.entry("get_canvas", 2944877500L));

	CanvasLayer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CanvasLayer(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_visible() {
		return (boolean) super.call("is_visible");
	}

	public void show() {
		super.call("show");
	}

	public void hide() {
		super.call("hide");
	}

	public boolean is_following_viewport() {
		return (boolean) super.call("is_following_viewport");
	}

	public long getLayer() {
		return (long) super.call("get_layer", new java.lang.Object[0]);
	}

	public void setLayer(long value) {
		super.call("set_layer", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isVisible() {
		return (boolean) super.call("is_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getRotation() {
		return (double) super.call("get_rotation", new java.lang.Object[0]);
	}

	public void setRotation(double value) {
		super.call("set_rotation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Vector2 getScale() {
		return (Vector2) super.call("get_scale", new java.lang.Object[0]);
	}

	public void setScale(Vector2 value) {
		super.call("set_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Transform2D getTransform() {
		return (Transform2D) super.call("get_transform", new java.lang.Object[0]);
	}

	public void setTransform(Transform2D value) {
		super.call("set_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Viewport getCustom_viewport() {
		return (Viewport) super.call("get_custom_viewport", new java.lang.Object[0]);
	}

	public void setCustom_viewport(Viewport value) {
		super.call("set_custom_viewport", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isFollow_viewport_enabled() {
		return (boolean) super.call("is_following_viewport", new java.lang.Object[0]);
	}

	public void setFollow_viewport_enabled(boolean value) {
		super.call("set_follow_viewport", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFollow_viewport_scale() {
		return (double) super.call("get_follow_viewport_scale", new java.lang.Object[0]);
	}

	public void setFollow_viewport_scale(double value) {
		super.call("set_follow_viewport_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
