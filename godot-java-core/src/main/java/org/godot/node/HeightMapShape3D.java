package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class HeightMapShape3D extends Shape3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_map_width", 3905245786L), java.util.Map.entry("set_map_depth", 1286410249L),
			java.util.Map.entry("set_map_data", 2899603908L), java.util.Map.entry("get_map_data", 675695659L),
			java.util.Map.entry("get_min_height", 1740695150L), java.util.Map.entry("get_max_height", 1740695150L),
			java.util.Map.entry("set_map_width", 1286410249L), java.util.Map.entry("get_map_depth", 3905245786L),
			java.util.Map.entry("update_map_data_from_image", 2636652979L));

	HeightMapShape3D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	HeightMapShape3D(long nativePointer) {
		super(nativePointer);
	}

	public void update_map_data_from_image(Image image, double height_min, double height_max) {
		super.call("update_map_data_from_image", new java.lang.Object[]{(java.lang.Object) image,
				java.lang.Double.valueOf(height_min), java.lang.Double.valueOf(height_max)});
	}

	public long getMap_width() {
		return (long) super.call("get_map_width", new java.lang.Object[0]);
	}

	public void setMap_width(long value) {
		super.call("set_map_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMap_depth() {
		return (long) super.call("get_map_depth", new java.lang.Object[0]);
	}

	public void setMap_depth(long value) {
		super.call("set_map_depth", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double[] getMap_data() {
		return (double[]) super.call("get_map_data", new java.lang.Object[0]);
	}

	public void setMap_data(double[] value) {
		super.call("set_map_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
