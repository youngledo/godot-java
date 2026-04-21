package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TextureButton extends BaseButton {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_flipped_v", 36873697L), java.util.Map.entry("set_ignore_texture_size", 2586408642L),
			java.util.Map.entry("set_texture_disabled", 4051416890L), java.util.Map.entry("set_flip_v", 2586408642L),
			java.util.Map.entry("get_texture_pressed", 3635182373L),
			java.util.Map.entry("set_texture_normal", 4051416890L),
			java.util.Map.entry("set_texture_hover", 4051416890L), java.util.Map.entry("set_stretch_mode", 252530840L),
			java.util.Map.entry("get_texture_disabled", 3635182373L),
			java.util.Map.entry("get_texture_focused", 3635182373L), java.util.Map.entry("is_flipped_h", 36873697L),
			java.util.Map.entry("set_flip_h", 2586408642L), java.util.Map.entry("get_texture_hover", 3635182373L),
			java.util.Map.entry("get_ignore_texture_size", 36873697L),
			java.util.Map.entry("get_click_mask", 2459671998L), java.util.Map.entry("set_texture_focused", 4051416890L),
			java.util.Map.entry("set_texture_pressed", 4051416890L), java.util.Map.entry("set_click_mask", 698588216L),
			java.util.Map.entry("get_texture_normal", 3635182373L), java.util.Map.entry("get_stretch_mode", 33815122L));

	TextureButton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextureButton(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_flipped_h() {
		return (boolean) super.call("is_flipped_h");
	}

	public boolean is_flipped_v() {
		return (boolean) super.call("is_flipped_v");
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

	public Texture2D getTexture_hover() {
		return (Texture2D) super.call("get_texture_hover", new java.lang.Object[0]);
	}

	public void setTexture_hover(Texture2D value) {
		super.call("set_texture_hover", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture_disabled() {
		return (Texture2D) super.call("get_texture_disabled", new java.lang.Object[0]);
	}

	public void setTexture_disabled(Texture2D value) {
		super.call("set_texture_disabled", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Texture2D getTexture_focused() {
		return (Texture2D) super.call("get_texture_focused", new java.lang.Object[0]);
	}

	public void setTexture_focused(Texture2D value) {
		super.call("set_texture_focused", new java.lang.Object[]{(java.lang.Object) value});
	}

	public BitMap getTexture_click_mask() {
		return (BitMap) super.call("get_click_mask", new java.lang.Object[0]);
	}

	public void setTexture_click_mask(BitMap value) {
		super.call("set_click_mask", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getIgnore_texture_size() {
		return (boolean) super.call("get_ignore_texture_size", new java.lang.Object[0]);
	}

	public void setIgnore_texture_size(boolean value) {
		super.call("set_ignore_texture_size", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getStretch_mode() {
		return (long) super.call("get_stretch_mode", new java.lang.Object[0]);
	}

	public void setStretch_mode(long value) {
		super.call("set_stretch_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isFlip_h() {
		return (boolean) super.call("is_flipped_h", new java.lang.Object[0]);
	}

	public void setFlip_h(boolean value) {
		super.call("set_flip_h", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isFlip_v() {
		return (boolean) super.call("is_flipped_v", new java.lang.Object[0]);
	}

	public void setFlip_v(boolean value) {
		super.call("set_flip_v", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
