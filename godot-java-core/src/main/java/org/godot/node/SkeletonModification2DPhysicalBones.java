package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class SkeletonModification2DPhysicalBones extends SkeletonModification2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("stop_simulation", 2787316981L),
			java.util.Map.entry("get_physical_bone_chain_length", 2455072627L),
			java.util.Map.entry("start_simulation", 2787316981L),
			java.util.Map.entry("get_physical_bone_node", 408788394L),
			java.util.Map.entry("set_physical_bone_chain_length", 1286410249L),
			java.util.Map.entry("set_physical_bone_node", 2761262315L),
			java.util.Map.entry("fetch_physical_bones", 3218959716L));

	SkeletonModification2DPhysicalBones(MemorySegment nativePointer) {
		super(nativePointer);
	}

	SkeletonModification2DPhysicalBones(long nativePointer) {
		super(nativePointer);
	}

	public void set_physical_bone_node(long joint_idx, String physicalbone2d_node) {
		super.call("set_physical_bone_node",
				new java.lang.Object[]{java.lang.Long.valueOf(joint_idx), (java.lang.Object) physicalbone2d_node});
	}

	public String get_physical_bone_node(long joint_idx) {
		return (String) super.call("get_physical_bone_node", new java.lang.Object[]{java.lang.Long.valueOf(joint_idx)});
	}

	public void fetch_physical_bones() {
		super.call("fetch_physical_bones");
	}

	public void start_simulation(String[] bones) {
		super.call("start_simulation", new java.lang.Object[]{(java.lang.Object) bones});
	}

	public void stop_simulation(String[] bones) {
		super.call("stop_simulation", new java.lang.Object[]{(java.lang.Object) bones});
	}

	public long getPhysical_bone_chain_length() {
		return (long) super.call("get_physical_bone_chain_length", new java.lang.Object[0]);
	}

	public void setPhysical_bone_chain_length(long value) {
		super.call("set_physical_bone_chain_length", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
