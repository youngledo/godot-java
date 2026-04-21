package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Rect2i;
import org.godot.math.Vector2i;

public class BitMap extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_bit_rect", 472162941L), java.util.Map.entry("set_bit", 1383440665L),
			java.util.Map.entry("convert_to_image", 4190603485L), java.util.Map.entry("get_bit", 2522259332L),
			java.util.Map.entry("set_bitv", 4153096796L), java.util.Map.entry("get_true_bit_count", 3905245786L),
			java.util.Map.entry("create_from_image_alpha", 106271684L), java.util.Map.entry("grow_mask", 3317281434L),
			java.util.Map.entry("create", 1130785943L), java.util.Map.entry("resize", 1130785943L),
			java.util.Map.entry("opaque_to_polygons", 48478126L), java.util.Map.entry("get_bitv", 3900751641L),
			java.util.Map.entry("get_size", 3690982128L));

	BitMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	BitMap(long nativePointer) {
		super(nativePointer);
	}

	public void create(Vector2i size) {
		super.call("create", new java.lang.Object[]{(java.lang.Object) size});
	}

	public void create_from_image_alpha(Image image, double threshold) {
		super.call("create_from_image_alpha",
				new java.lang.Object[]{(java.lang.Object) image, java.lang.Double.valueOf(threshold)});
	}

	public void set_bitv(Vector2i position, boolean bit) {
		super.call("set_bitv", new java.lang.Object[]{(java.lang.Object) position, java.lang.Boolean.valueOf(bit)});
	}

	public void set_bit(long x, long y, boolean bit) {
		super.call("set_bit", new java.lang.Object[]{java.lang.Long.valueOf(x), java.lang.Long.valueOf(y),
				java.lang.Boolean.valueOf(bit)});
	}

	public boolean get_bitv(Vector2i position) {
		return (boolean) super.call("get_bitv", new java.lang.Object[]{(java.lang.Object) position});
	}

	public boolean get_bit(long x, long y) {
		return (boolean) super.call("get_bit",
				new java.lang.Object[]{java.lang.Long.valueOf(x), java.lang.Long.valueOf(y)});
	}

	public void set_bit_rect(Rect2i rect, boolean bit) {
		super.call("set_bit_rect", new java.lang.Object[]{(java.lang.Object) rect, java.lang.Boolean.valueOf(bit)});
	}

	public void resize(Vector2i new_size) {
		super.call("resize", new java.lang.Object[]{(java.lang.Object) new_size});
	}

	public void grow_mask(long pixels, Rect2i rect) {
		super.call("grow_mask", new java.lang.Object[]{java.lang.Long.valueOf(pixels), (java.lang.Object) rect});
	}

	public Image convert_to_image() {
		return (Image) super.call("convert_to_image");
	}

	public Object[] opaque_to_polygons(Rect2i rect, double epsilon) {
		return (Object[]) super.call("opaque_to_polygons",
				new java.lang.Object[]{(java.lang.Object) rect, java.lang.Double.valueOf(epsilon)});
	}

	public GodotDictionary getData() {
		return (GodotDictionary) super.call("_get_data", new java.lang.Object[0]);
	}

	public void setData(GodotDictionary value) {
		super.call("_set_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
