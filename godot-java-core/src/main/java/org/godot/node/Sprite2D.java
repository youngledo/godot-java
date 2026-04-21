package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;

public class Sprite2D extends Node2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_vframes", 3905245786L), java.util.Map.entry("get_frame_coords", 3690982128L),
			java.util.Map.entry("set_flip_v", 2586408642L), java.util.Map.entry("set_frame", 1286410249L),
			java.util.Map.entry("is_centered", 36873697L), java.util.Map.entry("is_pixel_opaque", 556197845L),
			java.util.Map.entry("is_region_enabled", 36873697L), java.util.Map.entry("is_flipped_h", 36873697L),
			java.util.Map.entry("set_centered", 2586408642L), java.util.Map.entry("set_vframes", 1286410249L),
			java.util.Map.entry("set_region_enabled", 2586408642L), java.util.Map.entry("get_offset", 3341600327L),
			java.util.Map.entry("is_flipped_v", 36873697L), java.util.Map.entry("set_hframes", 1286410249L),
			java.util.Map.entry("get_frame", 3905245786L), java.util.Map.entry("get_region_rect", 1639390495L),
			java.util.Map.entry("set_region_filter_clip_enabled", 2586408642L),
			java.util.Map.entry("set_flip_h", 2586408642L), java.util.Map.entry("set_region_rect", 2046264180L),
			java.util.Map.entry("set_texture", 4051416890L), java.util.Map.entry("set_offset", 743155724L),
			java.util.Map.entry("is_region_filter_clip_enabled", 36873697L),
			java.util.Map.entry("get_rect", 1639390495L), java.util.Map.entry("set_frame_coords", 1130785943L),
			java.util.Map.entry("get_texture", 3635182373L), java.util.Map.entry("get_hframes", 3905245786L));

	Sprite2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Sprite2D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_centered() {
		return (boolean) super.call("is_centered");
	}

	public boolean is_flipped_h() {
		return (boolean) super.call("is_flipped_h");
	}

	public boolean is_flipped_v() {
		return (boolean) super.call("is_flipped_v");
	}

	public boolean is_region_enabled() {
		return (boolean) super.call("is_region_enabled");
	}

	public boolean is_pixel_opaque(Vector2 pos) {
		return (boolean) super.call("is_pixel_opaque", new java.lang.Object[]{(java.lang.Object) pos});
	}

	public boolean is_region_filter_clip_enabled() {
		return (boolean) super.call("is_region_filter_clip_enabled");
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isCentered() {
		return (boolean) super.call("is_centered", new java.lang.Object[0]);
	}

	public void setCentered(boolean value) {
		super.call("set_centered", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getOffset() {
		return (Vector2) super.call("get_offset", new java.lang.Object[0]);
	}

	public void setOffset(Vector2 value) {
		super.call("set_offset", new java.lang.Object[]{(java.lang.Object) value});
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

	public long getHframes() {
		return (long) super.call("get_hframes", new java.lang.Object[0]);
	}

	public void setHframes(long value) {
		super.call("set_hframes", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getVframes() {
		return (long) super.call("get_vframes", new java.lang.Object[0]);
	}

	public void setVframes(long value) {
		super.call("set_vframes", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getFrame() {
		return (long) super.call("get_frame", new java.lang.Object[0]);
	}

	public void setFrame(long value) {
		super.call("set_frame", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector2i getFrame_coords() {
		return (Vector2i) super.call("get_frame_coords", new java.lang.Object[0]);
	}

	public void setFrame_coords(Vector2i value) {
		super.call("set_frame_coords", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRegion_enabled() {
		return (boolean) super.call("is_region_enabled", new java.lang.Object[0]);
	}

	public void setRegion_enabled(boolean value) {
		super.call("set_region_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Rect2 getRegion_rect() {
		return (Rect2) super.call("get_region_rect", new java.lang.Object[0]);
	}

	public void setRegion_rect(Rect2 value) {
		super.call("set_region_rect", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRegion_filter_clip_enabled() {
		return (boolean) super.call("is_region_filter_clip_enabled", new java.lang.Object[0]);
	}

	public void setRegion_filter_clip_enabled(boolean value) {
		super.call("set_region_filter_clip_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
