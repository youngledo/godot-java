package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Transform3D;

public class Skin extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_bind_name", 3780747571L), java.util.Map.entry("clear_binds", 3218959716L),
			java.util.Map.entry("set_bind_bone", 3937882851L), java.util.Map.entry("add_bind", 3616898986L),
			java.util.Map.entry("set_bind_pose", 3616898986L), java.util.Map.entry("get_bind_pose", 1965739696L),
			java.util.Map.entry("get_bind_bone", 923996154L), java.util.Map.entry("set_bind_count", 1286410249L),
			java.util.Map.entry("get_bind_name", 659327637L), java.util.Map.entry("get_bind_count", 3905245786L),
			java.util.Map.entry("add_named_bind", 3154712474L));

	Skin(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Skin(long nativePointer) {
		super(nativePointer);
	}

	public void add_bind(long bone, Transform3D pose) {
		super.call("add_bind", new java.lang.Object[]{java.lang.Long.valueOf(bone), (java.lang.Object) pose});
	}

	public void add_named_bind(String name, Transform3D pose) {
		super.call("add_named_bind", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) pose});
	}

	public void set_bind_pose(long bind_index, Transform3D pose) {
		super.call("set_bind_pose",
				new java.lang.Object[]{java.lang.Long.valueOf(bind_index), (java.lang.Object) pose});
	}

	public Transform3D get_bind_pose(long bind_index) {
		return (Transform3D) super.call("get_bind_pose", new java.lang.Object[]{java.lang.Long.valueOf(bind_index)});
	}

	public void set_bind_name(long bind_index, String name) {
		super.call("set_bind_name",
				new java.lang.Object[]{java.lang.Long.valueOf(bind_index), (java.lang.Object) name});
	}

	public String get_bind_name(long bind_index) {
		return (String) super.call("get_bind_name", new java.lang.Object[]{java.lang.Long.valueOf(bind_index)});
	}

	public void set_bind_bone(long bind_index, long bone) {
		super.call("set_bind_bone",
				new java.lang.Object[]{java.lang.Long.valueOf(bind_index), java.lang.Long.valueOf(bone)});
	}

	public int get_bind_bone(long bind_index) {
		return (int) super.call("get_bind_bone", new java.lang.Object[]{java.lang.Long.valueOf(bind_index)});
	}

	public void clear_binds() {
		super.call("clear_binds");
	}
}
