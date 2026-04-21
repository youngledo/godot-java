package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRInteractionProfile extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_binding", 3934429652L),
			java.util.Map.entry("set_interaction_profile_path", 83702148L),
			java.util.Map.entry("set_binding_modifiers", 381264803L),
			java.util.Map.entry("get_binding_modifiers", 3995934104L), java.util.Map.entry("set_bindings", 381264803L),
			java.util.Map.entry("get_binding_modifier", 2419896583L),
			java.util.Map.entry("get_interaction_profile_path", 201670096L),
			java.util.Map.entry("get_binding_count", 3905245786L),
			java.util.Map.entry("get_binding_modifier_count", 3905245786L),
			java.util.Map.entry("get_bindings", 3995934104L));

	OpenXRInteractionProfile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRInteractionProfile(long nativePointer) {
		super(nativePointer);
	}

	public OpenXRIPBinding get_binding(long index) {
		return (OpenXRIPBinding) super.call("get_binding", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public OpenXRIPBindingModifier get_binding_modifier(long index) {
		return (OpenXRIPBindingModifier) super.call("get_binding_modifier",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String getInteraction_profile_path() {
		return (String) super.call("get_interaction_profile_path", new java.lang.Object[0]);
	}

	public void setInteraction_profile_path(String value) {
		super.call("set_interaction_profile_path", new java.lang.Object[]{(java.lang.Object) value});
	}

	public OpenXRIPBinding getBindings() {
		return (OpenXRIPBinding) super.call("get_bindings", new java.lang.Object[0]);
	}

	public void setBindings(OpenXRIPBinding value) {
		super.call("set_bindings", new java.lang.Object[]{(java.lang.Object) value});
	}

	public OpenXRIPBindingModifier getBinding_modifiers() {
		return (OpenXRIPBindingModifier) super.call("get_binding_modifiers", new java.lang.Object[0]);
	}

	public void setBinding_modifiers(OpenXRIPBindingModifier value) {
		super.call("set_binding_modifiers", new java.lang.Object[]{(java.lang.Object) value});
	}
}
