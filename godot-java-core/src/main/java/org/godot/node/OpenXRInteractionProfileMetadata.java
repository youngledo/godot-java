package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class OpenXRInteractionProfileMetadata extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("register_profile_rename", 3186203200L),
			java.util.Map.entry("register_io_path", 3443511926L),
			java.util.Map.entry("register_path_rename", 3186203200L),
			java.util.Map.entry("register_interaction_profile", 254767734L),
			java.util.Map.entry("register_top_level_path", 254767734L));

	OpenXRInteractionProfileMetadata(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRInteractionProfileMetadata(long nativePointer) {
		super(nativePointer);
	}

	public void register_profile_rename(String old_name, String new_name) {
		super.call("register_profile_rename",
				new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) new_name});
	}

	public void register_path_rename(String old_name, String new_name) {
		super.call("register_path_rename",
				new java.lang.Object[]{(java.lang.Object) old_name, (java.lang.Object) new_name});
	}

	public void register_top_level_path(String display_name, String openxr_path, String openxr_extension_names) {
		super.call("register_top_level_path", new java.lang.Object[]{(java.lang.Object) display_name,
				(java.lang.Object) openxr_path, (java.lang.Object) openxr_extension_names});
	}

	public void register_interaction_profile(String display_name, String openxr_path, String openxr_extension_names) {
		super.call("register_interaction_profile", new java.lang.Object[]{(java.lang.Object) display_name,
				(java.lang.Object) openxr_path, (java.lang.Object) openxr_extension_names});
	}

	public void register_io_path(String interaction_profile, String display_name, String toplevel_path,
			String openxr_path, String openxr_extension_names, int action_type) {
		super.call("register_io_path",
				new java.lang.Object[]{(java.lang.Object) interaction_profile, (java.lang.Object) display_name,
						(java.lang.Object) toplevel_path, (java.lang.Object) openxr_path,
						(java.lang.Object) openxr_extension_names, java.lang.Integer.valueOf(action_type)});
	}
}
