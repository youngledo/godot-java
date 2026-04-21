package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AnimationLibrary extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_animation", 2933122410L), java.util.Map.entry("rename_animation", 3740211285L),
			java.util.Map.entry("remove_animation", 3304788590L),
			java.util.Map.entry("get_animation_list", 3995934104L), java.util.Map.entry("add_animation", 1811855551L),
			java.util.Map.entry("has_animation", 2619796661L),
			java.util.Map.entry("get_animation_list_size", 3905245786L));

	AnimationLibrary(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AnimationLibrary(long nativePointer) {
		super(nativePointer);
	}

	public int add_animation(String name, Animation animation) {
		return (int) super.call("add_animation",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) animation});
	}

	public void remove_animation(String name) {
		super.call("remove_animation", new java.lang.Object[]{(java.lang.Object) name});
	}

	public void rename_animation(String name, String newname) {
		super.call("rename_animation", new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) newname});
	}

	public boolean has_animation(String name) {
		return (boolean) super.call("has_animation", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Animation get_animation(String name) {
		return (Animation) super.call("get_animation", new java.lang.Object[]{(java.lang.Object) name});
	}
}
