package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;

public class GLTFSkin extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_inverse_binds", 2915620761L), java.util.Map.entry("get_joints", 969006518L),
			java.util.Map.entry("get_roots", 969006518L), java.util.Map.entry("get_joint_i_to_name", 2382534195L),
			java.util.Map.entry("get_non_joints", 969006518L), java.util.Map.entry("set_joints", 3614634198L),
			java.util.Map.entry("get_skin_root", 2455072627L), java.util.Map.entry("set_skin_root", 1286410249L),
			java.util.Map.entry("set_roots", 3614634198L), java.util.Map.entry("get_joint_i_to_bone_i", 2382534195L),
			java.util.Map.entry("set_joint_i_to_bone_i", 4155329257L), java.util.Map.entry("get_skeleton", 2455072627L),
			java.util.Map.entry("get_godot_skin", 1032037385L), java.util.Map.entry("set_godot_skin", 3971435618L),
			java.util.Map.entry("set_joint_i_to_name", 4155329257L), java.util.Map.entry("set_non_joints", 3614634198L),
			java.util.Map.entry("set_joints_original", 3614634198L), java.util.Map.entry("set_skeleton", 1286410249L),
			java.util.Map.entry("get_joints_original", 969006518L),
			java.util.Map.entry("set_inverse_binds", 381264803L));

	GLTFSkin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFSkin(long nativePointer) {
		super(nativePointer);
	}

	public long getSkin_root() {
		return (long) super.call("get_skin_root", new java.lang.Object[0]);
	}

	public void setSkin_root(long value) {
		super.call("set_skin_root", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public int[] getJoints_original() {
		return (int[]) super.call("get_joints_original", new java.lang.Object[0]);
	}

	public void setJoints_original(int[] value) {
		super.call("set_joints_original", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getInverse_binds() {
		return (GodotArray) super.call("get_inverse_binds", new java.lang.Object[0]);
	}

	public void setInverse_binds(GodotArray value) {
		super.call("set_inverse_binds", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getJoints() {
		return (int[]) super.call("get_joints", new java.lang.Object[0]);
	}

	public void setJoints(int[] value) {
		super.call("set_joints", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getNon_joints() {
		return (int[]) super.call("get_non_joints", new java.lang.Object[0]);
	}

	public void setNon_joints(int[] value) {
		super.call("set_non_joints", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getRoots() {
		return (int[]) super.call("get_roots", new java.lang.Object[0]);
	}

	public void setRoots(int[] value) {
		super.call("set_roots", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSkeleton() {
		return (long) super.call("get_skeleton", new java.lang.Object[0]);
	}

	public void setSkeleton(long value) {
		super.call("set_skeleton", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public GodotDictionary getJoint_i_to_bone_i() {
		return (GodotDictionary) super.call("get_joint_i_to_bone_i", new java.lang.Object[0]);
	}

	public void setJoint_i_to_bone_i(GodotDictionary value) {
		super.call("set_joint_i_to_bone_i", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getJoint_i_to_name() {
		return (GodotDictionary) super.call("get_joint_i_to_name", new java.lang.Object[0]);
	}

	public void setJoint_i_to_name(GodotDictionary value) {
		super.call("set_joint_i_to_name", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Skin getGodot_skin() {
		return (Skin) super.call("get_godot_skin", new java.lang.Object[0]);
	}

	public void setGodot_skin(Skin value) {
		super.call("set_godot_skin", new java.lang.Object[]{(java.lang.Object) value});
	}
}
