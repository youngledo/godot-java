package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Rect2;

public class AtlasTexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_region", 1639390495L), java.util.Map.entry("set_filter_clip", 2586408642L),
			java.util.Map.entry("has_filter_clip", 36873697L), java.util.Map.entry("get_margin", 1639390495L),
			java.util.Map.entry("get_atlas", 3635182373L), java.util.Map.entry("set_margin", 2046264180L),
			java.util.Map.entry("set_atlas", 4051416890L), java.util.Map.entry("set_region", 2046264180L));

	AtlasTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AtlasTexture(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_filter_clip() {
		return (boolean) super.call("has_filter_clip");
	}

	public Texture2D getAtlas() {
		return (Texture2D) super.call("get_atlas", new java.lang.Object[0]);
	}

	public void setAtlas(Texture2D value) {
		super.call("set_atlas", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Rect2 getRegion() {
		return (Rect2) super.call("get_region", new java.lang.Object[0]);
	}

	public void setRegion(Rect2 value) {
		super.call("set_region", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Rect2 getMargin() {
		return (Rect2) super.call("get_margin", new java.lang.Object[0]);
	}

	public void setMargin(Rect2 value) {
		super.call("set_margin", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean getFilter_clip() {
		return (boolean) super.call("has_filter_clip", new java.lang.Object[0]);
	}

	public void setFilter_clip(boolean value) {
		super.call("set_filter_clip", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
