package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector3;

public class VoxelGI extends VisualInstance3D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("set_probe_data", 1637849675L),
			java.util.Map.entry("bake", 2781551026L), java.util.Map.entry("get_subdiv", 4261647950L),
			java.util.Map.entry("set_camera_attributes", 2817810567L),
			java.util.Map.entry("get_camera_attributes", 3921283215L), java.util.Map.entry("get_size", 3360562783L),
			java.util.Map.entry("get_probe_data", 1730645405L), java.util.Map.entry("set_subdiv", 2240898472L),
			java.util.Map.entry("debug_bake", 3218959716L));

	VoxelGI(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VoxelGI(long nativePointer) {
		super(nativePointer);
	}

	public void bake(Node from_node, boolean create_visual_debug) {
		super.call("bake",
				new java.lang.Object[]{(java.lang.Object) from_node, java.lang.Boolean.valueOf(create_visual_debug)});
	}

	public void debug_bake() {
		super.call("debug_bake");
	}

	public long getSubdiv() {
		return (long) super.call("get_subdiv", new java.lang.Object[0]);
	}

	public void setSubdiv(long value) {
		super.call("set_subdiv", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Object getCamera_attributes() {
		return (Object) super.call("get_camera_attributes", new java.lang.Object[0]);
	}

	public void setCamera_attributes(Object value) {
		super.call("set_camera_attributes", new java.lang.Object[]{(java.lang.Object) value});
	}

	public VoxelGIData getData() {
		return (VoxelGIData) super.call("get_probe_data", new java.lang.Object[0]);
	}

	public void setData(VoxelGIData value) {
		super.call("set_probe_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
