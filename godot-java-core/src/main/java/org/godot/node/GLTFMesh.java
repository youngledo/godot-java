package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.GodotObject;
import org.godot.collection.GodotArray;

public class GLTFMesh extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_blend_weights", 2445143706L),
			java.util.Map.entry("get_instance_materials", 2915620761L),
			java.util.Map.entry("set_instance_materials", 381264803L), java.util.Map.entry("set_mesh", 2255166972L),
			java.util.Map.entry("set_additional_data", 3776071444L), java.util.Map.entry("get_mesh", 3754628756L),
			java.util.Map.entry("set_blend_weights", 2899603908L),
			java.util.Map.entry("get_original_name", 2841200299L), java.util.Map.entry("set_original_name", 83702148L),
			java.util.Map.entry("get_additional_data", 2138907829L));

	GLTFMesh(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFMesh(long nativePointer) {
		super(nativePointer);
	}

	public Object get_additional_data(String extension_name) {
		return (Object) super.call("get_additional_data", new java.lang.Object[]{(java.lang.Object) extension_name});
	}

	public void set_additional_data(String extension_name, Object additional_data) {
		super.call("set_additional_data",
				new java.lang.Object[]{(java.lang.Object) extension_name, (java.lang.Object) additional_data});
	}

	public String getOriginal_name() {
		return (String) super.call("get_original_name", new java.lang.Object[0]);
	}

	public void setOriginal_name(String value) {
		super.call("set_original_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotObject getMesh() {
		return (GodotObject) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(GodotObject value) {
		super.call("set_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[] getBlend_weights() {
		return (double[]) super.call("get_blend_weights", new java.lang.Object[0]);
	}

	public void setBlend_weights(double[] value) {
		super.call("set_blend_weights", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getInstance_materials() {
		return (GodotArray) super.call("get_instance_materials", new java.lang.Object[0]);
	}

	public void setInstance_materials(GodotArray value) {
		super.call("set_instance_materials", new java.lang.Object[]{(java.lang.Object) value});
	}
}
