package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRActionMap extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("find_action_set", 1888809267L), java.util.Map.entry("get_action_sets", 3995934104L),
			java.util.Map.entry("get_interaction_profile_count", 3905245786L),
			java.util.Map.entry("get_interaction_profile", 2546151210L),
			java.util.Map.entry("find_interaction_profile", 3095875538L),
			java.util.Map.entry("get_action_set", 1789580336L), java.util.Map.entry("add_action_set", 2093310581L),
			java.util.Map.entry("create_default_action_sets", 3218959716L),
			java.util.Map.entry("remove_interaction_profile", 2697953512L),
			java.util.Map.entry("set_interaction_profiles", 381264803L),
			java.util.Map.entry("remove_action_set", 2093310581L),
			java.util.Map.entry("get_interaction_profiles", 3995934104L),
			java.util.Map.entry("set_action_sets", 381264803L),
			java.util.Map.entry("get_action_set_count", 3905245786L),
			java.util.Map.entry("add_interaction_profile", 2697953512L));

	OpenXRActionMap(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRActionMap(long nativePointer) {
		super(nativePointer);
	}

	public OpenXRActionSet find_action_set(String name) {
		return (OpenXRActionSet) super.call("find_action_set", new java.lang.Object[]{(java.lang.Object) name});
	}

	public OpenXRActionSet get_action_set(long idx) {
		return (OpenXRActionSet) super.call("get_action_set", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void add_action_set(OpenXRActionSet action_set) {
		super.call("add_action_set", new java.lang.Object[]{(java.lang.Object) action_set});
	}

	public void remove_action_set(OpenXRActionSet action_set) {
		super.call("remove_action_set", new java.lang.Object[]{(java.lang.Object) action_set});
	}

	public OpenXRInteractionProfile find_interaction_profile(String name) {
		return (OpenXRInteractionProfile) super.call("find_interaction_profile",
				new java.lang.Object[]{(java.lang.Object) name});
	}

	public OpenXRInteractionProfile get_interaction_profile(long idx) {
		return (OpenXRInteractionProfile) super.call("get_interaction_profile",
				new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public void add_interaction_profile(OpenXRInteractionProfile interaction_profile) {
		super.call("add_interaction_profile", new java.lang.Object[]{(java.lang.Object) interaction_profile});
	}

	public void remove_interaction_profile(OpenXRInteractionProfile interaction_profile) {
		super.call("remove_interaction_profile", new java.lang.Object[]{(java.lang.Object) interaction_profile});
	}

	public void create_default_action_sets() {
		super.call("create_default_action_sets");
	}

	public OpenXRActionSet getAction_sets() {
		return (OpenXRActionSet) super.call("get_action_sets", new java.lang.Object[0]);
	}

	public void setAction_sets(OpenXRActionSet value) {
		super.call("set_action_sets", new java.lang.Object[]{(java.lang.Object) value});
	}

	public OpenXRInteractionProfile getInteraction_profiles() {
		return (OpenXRInteractionProfile) super.call("get_interaction_profiles", new java.lang.Object[0]);
	}

	public void setInteraction_profiles(OpenXRInteractionProfile value) {
		super.call("set_interaction_profiles", new java.lang.Object[]{(java.lang.Object) value});
	}
}
