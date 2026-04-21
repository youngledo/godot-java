package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TouchScreenButton extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_bitmask", 2459671998L), java.util.Map.entry("get_texture_pressed", 3635182373L),
			java.util.Map.entry("set_texture_normal", 4051416890L), java.util.Map.entry("get_shape", 522005891L),
			java.util.Map.entry("get_action", 201670096L), java.util.Map.entry("set_shape", 771364740L),
			java.util.Map.entry("get_visibility_mode", 2558996468L),
			java.util.Map.entry("is_shape_centered", 36873697L), java.util.Map.entry("set_bitmask", 698588216L),
			java.util.Map.entry("set_shape_visible", 2586408642L),
			java.util.Map.entry("set_shape_centered", 2586408642L),
			java.util.Map.entry("set_visibility_mode", 3031128463L), java.util.Map.entry("set_action", 83702148L),
			java.util.Map.entry("set_texture_pressed", 4051416890L), java.util.Map.entry("is_pressed", 36873697L),
			java.util.Map.entry("set_passby_press", 2586408642L), java.util.Map.entry("is_shape_visible", 36873697L),
			java.util.Map.entry("is_passby_press_enabled", 36873697L),
			java.util.Map.entry("get_texture_normal", 3635182373L));

	TouchScreenButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TouchScreenButton(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_shape_centered() {
		return (boolean) super.call("is_shape_centered");
	}

	public boolean is_shape_visible() {
		return (boolean) super.call("is_shape_visible");
	}

	public boolean is_passby_press_enabled() {
		return (boolean) super.call("is_passby_press_enabled");
	}

	public boolean is_pressed() {
		return (boolean) super.call("is_pressed");
	}

	public Texture2D getTexture_normal() {
		return (Texture2D) super.call("get_texture_normal", new java.lang.Object[0]);
	}

	public void setTexture_normal(Texture2D value) {
		super.call("set_texture_normal", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture_pressed() {
		return (Texture2D) super.call("get_texture_pressed", new java.lang.Object[0]);
	}

	public void setTexture_pressed(Texture2D value) {
		super.call("set_texture_pressed", new java.lang.Object[]{(java.lang.Object) value});
	}

	public BitMap getBitmask() {
		return (BitMap) super.call("get_bitmask", new java.lang.Object[0]);
	}

	public void setBitmask(BitMap value) {
		super.call("set_bitmask", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Shape2D getShape() {
		return (Shape2D) super.call("get_shape", new java.lang.Object[0]);
	}

	public void setShape(Shape2D value) {
		super.call("set_shape", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isShape_centered() {
		return (boolean) super.call("is_shape_centered", new java.lang.Object[0]);
	}

	public void setShape_centered(boolean value) {
		super.call("set_shape_centered", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShape_visible() {
		return (boolean) super.call("is_shape_visible", new java.lang.Object[0]);
	}

	public void setShape_visible(boolean value) {
		super.call("set_shape_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPassby_press() {
		return (boolean) super.call("is_passby_press_enabled", new java.lang.Object[0]);
	}

	public void setPassby_press(boolean value) {
		super.call("set_passby_press", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public String getAction() {
		return (String) super.call("get_action", new java.lang.Object[0]);
	}

	public void setAction(String value) {
		super.call("set_action", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getVisibility_mode() {
		return (long) super.call("get_visibility_mode", new java.lang.Object[0]);
	}

	public void setVisibility_mode(long value) {
		super.call("set_visibility_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
