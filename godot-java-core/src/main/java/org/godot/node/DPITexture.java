package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class DPITexture extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_color_map", 3102165223L), java.util.Map.entry("get_source", 201670096L),
			java.util.Map.entry("create_from_string", 755140520L), java.util.Map.entry("get_saturation", 1740695150L),
			java.util.Map.entry("get_base_scale", 1740695150L), java.util.Map.entry("set_color_map", 4155329257L),
			java.util.Map.entry("get_scaled_rid", 2944877500L), java.util.Map.entry("set_saturation", 373806689L),
			java.util.Map.entry("set_size_override", 1130785943L), java.util.Map.entry("set_source", 83702148L),
			java.util.Map.entry("set_base_scale", 373806689L));

	DPITexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	DPITexture(long nativePointer) {
		super(nativePointer);
	}

	public DPITexture create_from_string(String source, double scale, double saturation, GodotDictionary color_map) {
		return (DPITexture) super.call("create_from_string", new java.lang.Object[]{(java.lang.Object) source,
				java.lang.Double.valueOf(scale), java.lang.Double.valueOf(saturation), (java.lang.Object) color_map});
	}

	public double getBase_scale() {
		return (double) super.call("get_base_scale", new java.lang.Object[0]);
	}

	public void setBase_scale(double value) {
		super.call("set_base_scale", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSaturation() {
		return (double) super.call("get_saturation", new java.lang.Object[0]);
	}

	public void setSaturation(double value) {
		super.call("set_saturation", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public Object getColor_map() {
		return (Object) super.call("get_color_map", new java.lang.Object[0]);
	}

	public void setColor_map(Object value) {
		super.call("set_color_map", new java.lang.Object[]{(java.lang.Object) value});
	}
}
