package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Quaternion;
import org.godot.math.Transform3D;
import org.godot.math.Vector3;

public class GLTFNode extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_position", 3783033775L), java.util.Map.entry("get_children", 969006518L),
			java.util.Map.entry("set_parent", 1286410249L), java.util.Map.entry("set_additional_data", 3776071444L),
			java.util.Map.entry("set_height", 1286410249L), java.util.Map.entry("get_xform", 4183770049L),
			java.util.Map.entry("set_visible", 2586408642L), java.util.Map.entry("get_height", 2455072627L),
			java.util.Map.entry("set_camera", 1286410249L), java.util.Map.entry("get_camera", 2455072627L),
			java.util.Map.entry("set_xform", 2952846383L), java.util.Map.entry("get_skin", 2455072627L),
			java.util.Map.entry("set_skeleton", 1286410249L), java.util.Map.entry("get_parent", 2455072627L),
			java.util.Map.entry("get_light", 2455072627L), java.util.Map.entry("set_light", 1286410249L),
			java.util.Map.entry("set_position", 3460891852L), java.util.Map.entry("set_children", 3614634198L),
			java.util.Map.entry("set_skin", 1286410249L), java.util.Map.entry("get_visible", 2240911060L),
			java.util.Map.entry("get_scene_node_path", 573359477L), java.util.Map.entry("get_skeleton", 2455072627L),
			java.util.Map.entry("set_scale", 3460891852L), java.util.Map.entry("get_scale", 3783033775L),
			java.util.Map.entry("append_child_index", 1286410249L), java.util.Map.entry("set_mesh", 1286410249L),
			java.util.Map.entry("set_rotation", 1727505552L), java.util.Map.entry("get_mesh", 2455072627L),
			java.util.Map.entry("get_original_name", 2841200299L), java.util.Map.entry("get_rotation", 2916281908L),
			java.util.Map.entry("set_original_name", 83702148L),
			java.util.Map.entry("get_additional_data", 2138907829L));

	GLTFNode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFNode(long nativePointer) {
		super(nativePointer);
	}

	public void append_child_index(long child_index) {
		super.call("append_child_index", new java.lang.Object[]{java.lang.Long.valueOf(child_index)});
	}

	public Object get_additional_data(String extension_name) {
		return (Object) super.call("get_additional_data", new java.lang.Object[]{(java.lang.Object) extension_name});
	}

	public void set_additional_data(String extension_name, Object additional_data) {
		super.call("set_additional_data",
				new java.lang.Object[]{(java.lang.Object) extension_name, (java.lang.Object) additional_data});
	}

	public String get_scene_node_path(GLTFState gltf_state, boolean handle_skeletons) {
		return (String) super.call("get_scene_node_path",
				new java.lang.Object[]{(java.lang.Object) gltf_state, java.lang.Boolean.valueOf(handle_skeletons)});
	}

	public String getOriginal_name() {
		return (String) super.call("get_original_name", new java.lang.Object[0]);
	}

	public void setOriginal_name(String value) {
		super.call("set_original_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getParent() {
		return (long) super.call("get_parent", new java.lang.Object[0]);
	}

	public void setParent(long value) {
		super.call("set_parent", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHeight() {
		return (long) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(long value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Transform3D getXform() {
		return (Transform3D) super.call("get_xform", new java.lang.Object[0]);
	}

	public void setXform(Transform3D value) {
		super.call("set_xform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getMesh() {
		return (long) super.call("get_mesh", new java.lang.Object[0]);
	}

	public void setMesh(long value) {
		super.call("set_mesh", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getCamera() {
		return (long) super.call("get_camera", new java.lang.Object[0]);
	}

	public void setCamera(long value) {
		super.call("set_camera", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSkin() {
		return (long) super.call("get_skin", new java.lang.Object[0]);
	}

	public void setSkin(long value) {
		super.call("set_skin", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSkeleton() {
		return (long) super.call("get_skeleton", new java.lang.Object[0]);
	}

	public void setSkeleton(long value) {
		super.call("set_skeleton", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Vector3 getPosition() {
		return (Vector3) super.call("get_position", new java.lang.Object[0]);
	}

	public void setPosition(Vector3 value) {
		super.call("set_position", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Quaternion getRotation() {
		return (Quaternion) super.call("get_rotation", new java.lang.Object[0]);
	}

	public void setRotation(Quaternion value) {
		super.call("set_rotation", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getScale() {
		return (Vector3) super.call("get_scale", new java.lang.Object[0]);
	}

	public void setScale(Vector3 value) {
		super.call("set_scale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getChildren() {
		return (int[]) super.call("get_children", new java.lang.Object[0]);
	}

	public void setChildren(int[] value) {
		super.call("set_children", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getLight() {
		return (long) super.call("get_light", new java.lang.Object[0]);
	}

	public void setLight(long value) {
		super.call("set_light", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getVisible() {
		return (boolean) super.call("get_visible", new java.lang.Object[0]);
	}

	public void setVisible(boolean value) {
		super.call("set_visible", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
