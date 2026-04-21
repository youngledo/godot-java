package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class TextureRect extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_flipped_v", 36873697L), java.util.Map.entry("get_expand_mode", 3863824733L),
			java.util.Map.entry("is_flipped_h", 36873697L), java.util.Map.entry("set_flip_h", 2586408642L),
			java.util.Map.entry("set_flip_v", 2586408642L), java.util.Map.entry("set_stretch_mode", 58788729L),
			java.util.Map.entry("set_texture", 4051416890L), java.util.Map.entry("set_expand_mode", 1870766882L),
			java.util.Map.entry("get_texture", 3635182373L), java.util.Map.entry("get_stretch_mode", 346396079L));

	TextureRect(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TextureRect(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_flipped_h() {
		return (boolean) super.call("is_flipped_h");
	}

	public boolean is_flipped_v() {
		return (boolean) super.call("is_flipped_v");
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getExpand_mode() {
		return (long) super.call("get_expand_mode", new java.lang.Object[0]);
	}

	public void setExpand_mode(long value) {
		super.call("set_expand_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
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
