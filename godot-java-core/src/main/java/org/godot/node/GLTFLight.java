package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;

public class GLTFLight extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_intensity", 373806689L), java.util.Map.entry("set_light_type", 83702148L),
			java.util.Map.entry("set_additional_data", 3776071444L),
			java.util.Map.entry("set_outer_cone_angle", 373806689L),
			java.util.Map.entry("from_dictionary", 4057087208L), java.util.Map.entry("set_color", 2920490490L),
			java.util.Map.entry("to_node", 2040811672L), java.util.Map.entry("set_inner_cone_angle", 373806689L),
			java.util.Map.entry("get_color", 3200896285L), java.util.Map.entry("get_light_type", 2841200299L),
			java.util.Map.entry("to_dictionary", 3102165223L), java.util.Map.entry("get_inner_cone_angle", 191475506L),
			java.util.Map.entry("get_range", 191475506L), java.util.Map.entry("get_intensity", 191475506L),
			java.util.Map.entry("set_range", 373806689L), java.util.Map.entry("from_node", 3907677874L),
			java.util.Map.entry("get_outer_cone_angle", 191475506L),
			java.util.Map.entry("get_additional_data", 2138907829L));

	GLTFLight(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFLight(long nativePointer) {
		super(nativePointer);
	}

	public GLTFLight from_node(Light3D light_node) {
		return (GLTFLight) super.call("from_node", new java.lang.Object[]{(java.lang.Object) light_node});
	}

	public Light3D to_node() {
		return (Light3D) super.call("to_node");
	}

	public GLTFLight from_dictionary(GodotDictionary dictionary) {
		return (GLTFLight) super.call("from_dictionary", new java.lang.Object[]{(java.lang.Object) dictionary});
	}

	public GodotDictionary to_dictionary() {
		return (GodotDictionary) super.call("to_dictionary");
	}

	public Object get_additional_data(String extension_name) {
		return (Object) super.call("get_additional_data", new java.lang.Object[]{(java.lang.Object) extension_name});
	}

	public void set_additional_data(String extension_name, Object additional_data) {
		super.call("set_additional_data",
				new java.lang.Object[]{(java.lang.Object) extension_name, (java.lang.Object) additional_data});
	}

	public Color getColor() {
		return (Color) super.call("get_color", new java.lang.Object[0]);
	}

	public void setColor(Color value) {
		super.call("set_color", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getIntensity() {
		return (double) super.call("get_intensity", new java.lang.Object[0]);
	}

	public void setIntensity(double value) {
		super.call("set_intensity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getLight_type() {
		return (String) super.call("get_light_type", new java.lang.Object[0]);
	}

	public void setLight_type(String value) {
		super.call("set_light_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getRange() {
		return (double) super.call("get_range", new java.lang.Object[0]);
	}

	public void setRange(double value) {
		super.call("set_range", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getInner_cone_angle() {
		return (double) super.call("get_inner_cone_angle", new java.lang.Object[0]);
	}

	public void setInner_cone_angle(double value) {
		super.call("set_inner_cone_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getOuter_cone_angle() {
		return (double) super.call("get_outer_cone_angle", new java.lang.Object[0]);
	}

	public void setOuter_cone_angle(double value) {
		super.call("set_outer_cone_angle", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
