package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;
import org.godot.math.Vector2i;

public class Sprite3D extends SpriteBase3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_vframes", 3905245786L), java.util.Map.entry("set_hframes", 1286410249L),
			java.util.Map.entry("get_frame_coords", 3690982128L), java.util.Map.entry("get_frame", 3905245786L),
			java.util.Map.entry("set_frame", 1286410249L), java.util.Map.entry("get_region_rect", 1639390495L),
			java.util.Map.entry("is_region_enabled", 36873697L), java.util.Map.entry("set_vframes", 1286410249L),
			java.util.Map.entry("set_region_rect", 2046264180L), java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("set_region_enabled", 2586408642L),
			java.util.Map.entry("set_frame_coords", 1130785943L), java.util.Map.entry("get_texture", 3635182373L),
			java.util.Map.entry("get_hframes", 3905245786L));

	Sprite3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Sprite3D(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_region_enabled() {
		return (boolean) super.call("is_region_enabled");
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
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
}
