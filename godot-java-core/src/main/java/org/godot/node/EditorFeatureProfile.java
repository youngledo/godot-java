package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class EditorFeatureProfile extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_disable_class_editor", 2524380260L),
			java.util.Map.entry("is_feature_disabled", 2974403161L),
			java.util.Map.entry("is_class_property_disabled", 471820014L),
			java.util.Map.entry("set_disable_feature", 1884871044L),
			java.util.Map.entry("is_class_disabled", 2619796661L),
			java.util.Map.entry("is_class_editor_disabled", 2619796661L),
			java.util.Map.entry("save_to_file", 166001499L), java.util.Map.entry("load_from_file", 166001499L),
			java.util.Map.entry("set_disable_class_property", 865197084L),
			java.util.Map.entry("set_disable_class", 2524380260L),
			java.util.Map.entry("get_feature_name", 3401335809L));

	EditorFeatureProfile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	EditorFeatureProfile(long nativePointer) {
		super(nativePointer);
	}

	public void set_disable_class(String class_name, boolean disable) {
		super.call("set_disable_class",
				new java.lang.Object[]{(java.lang.Object) class_name, java.lang.Boolean.valueOf(disable)});
	}

	public boolean is_class_disabled(String class_name) {
		return (boolean) super.call("is_class_disabled", new java.lang.Object[]{(java.lang.Object) class_name});
	}

	public void set_disable_class_editor(String class_name, boolean disable) {
		super.call("set_disable_class_editor",
				new java.lang.Object[]{(java.lang.Object) class_name, java.lang.Boolean.valueOf(disable)});
	}

	public boolean is_class_editor_disabled(String class_name) {
		return (boolean) super.call("is_class_editor_disabled", new java.lang.Object[]{(java.lang.Object) class_name});
	}

	public void set_disable_class_property(String class_name, String property, boolean disable) {
		super.call("set_disable_class_property", new java.lang.Object[]{(java.lang.Object) class_name,
				(java.lang.Object) property, java.lang.Boolean.valueOf(disable)});
	}

	public boolean is_class_property_disabled(String class_name, String property) {
		return (boolean) super.call("is_class_property_disabled",
				new java.lang.Object[]{(java.lang.Object) class_name, (java.lang.Object) property});
	}

	public void set_disable_feature(int feature, boolean disable) {
		super.call("set_disable_feature",
				new java.lang.Object[]{java.lang.Integer.valueOf(feature), java.lang.Boolean.valueOf(disable)});
	}

	public boolean is_feature_disabled(int feature) {
		return (boolean) super.call("is_feature_disabled", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public String get_feature_name(int feature) {
		return (String) super.call("get_feature_name", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public int save_to_file(String path) {
		return (int) super.call("save_to_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int load_from_file(String path) {
		return (int) super.call("load_from_file", new java.lang.Object[]{(java.lang.Object) path});
	}
}
