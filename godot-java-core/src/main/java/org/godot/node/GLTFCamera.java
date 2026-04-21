package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class GLTFCamera extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_fov", 373806689L), java.util.Map.entry("get_depth_far", 1740695150L),
			java.util.Map.entry("set_depth_far", 373806689L), java.util.Map.entry("set_size_mag", 373806689L),
			java.util.Map.entry("get_perspective", 36873697L), java.util.Map.entry("from_dictionary", 2495512509L),
			java.util.Map.entry("to_node", 2285090890L), java.util.Map.entry("get_fov", 1740695150L),
			java.util.Map.entry("to_dictionary", 3102165223L), java.util.Map.entry("get_depth_near", 1740695150L),
			java.util.Map.entry("from_node", 237784L), java.util.Map.entry("set_depth_near", 373806689L),
			java.util.Map.entry("set_perspective", 2586408642L), java.util.Map.entry("get_size_mag", 1740695150L));

	GLTFCamera(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFCamera(long nativePointer) {
		super(nativePointer);
	}

	public GLTFCamera from_node(Camera3D camera_node) {
		return (GLTFCamera) super.call("from_node", new java.lang.Object[]{(java.lang.Object) camera_node});
	}

	public Camera3D to_node() {
		return (Camera3D) super.call("to_node");
	}

	public GLTFCamera from_dictionary(GodotDictionary dictionary) {
		return (GLTFCamera) super.call("from_dictionary", new java.lang.Object[]{(java.lang.Object) dictionary});
	}

	public GodotDictionary to_dictionary() {
		return (GodotDictionary) super.call("to_dictionary");
	}

	public boolean getPerspective() {
		return (boolean) super.call("get_perspective", new java.lang.Object[0]);
	}

	public void setPerspective(boolean value) {
		super.call("set_perspective", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getFov() {
		return (double) super.call("get_fov", new java.lang.Object[0]);
	}

	public void setFov(double value) {
		super.call("set_fov", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getSize_mag() {
		return (double) super.call("get_size_mag", new java.lang.Object[0]);
	}

	public void setSize_mag(double value) {
		super.call("set_size_mag", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth_far() {
		return (double) super.call("get_depth_far", new java.lang.Object[0]);
	}

	public void setDepth_far(double value) {
		super.call("set_depth_far", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDepth_near() {
		return (double) super.call("get_depth_near", new java.lang.Object[0]);
	}

	public void setDepth_near(double value) {
		super.call("set_depth_near", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
