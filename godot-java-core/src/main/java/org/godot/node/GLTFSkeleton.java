package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;

public class GLTFSkeleton extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_unique_names", 381264803L), java.util.Map.entry("get_joints", 969006518L),
			java.util.Map.entry("get_roots", 969006518L), java.util.Map.entry("get_bone_attachment", 945440495L),
			java.util.Map.entry("set_joints", 3614634198L), java.util.Map.entry("get_unique_names", 2915620761L),
			java.util.Map.entry("set_godot_bone_node", 4155329257L), java.util.Map.entry("set_roots", 3614634198L),
			java.util.Map.entry("get_godot_skeleton", 1814733083L),
			java.util.Map.entry("get_bone_attachment_count", 2455072627L),
			java.util.Map.entry("get_godot_bone_node", 2382534195L));

	GLTFSkeleton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFSkeleton(long nativePointer) {
		super(nativePointer);
	}

	public BoneAttachment3D get_bone_attachment(long idx) {
		return (BoneAttachment3D) super.call("get_bone_attachment",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public int[] getJoints() {
		return (int[]) super.call("get_joints", new java.lang.Object[0]);
	}

	public void setJoints(int[] value) {
		super.call("set_joints", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getRoots() {
		return (int[]) super.call("get_roots", new java.lang.Object[0]);
	}

	public void setRoots(int[] value) {
		super.call("set_roots", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getUnique_names() {
		return (GodotArray) super.call("get_unique_names", new java.lang.Object[0]);
	}

	public void setUnique_names(GodotArray value) {
		super.call("set_unique_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getGodot_bone_node() {
		return (GodotDictionary) super.call("get_godot_bone_node", new java.lang.Object[0]);
	}

	public void setGodot_bone_node(GodotDictionary value) {
		super.call("set_godot_bone_node", new java.lang.Object[]{(java.lang.Object) value});
	}
}
