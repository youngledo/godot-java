package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;

public class RegExMatch extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_string", 687115856L), java.util.Map.entry("get_start", 490464691L),
			java.util.Map.entry("get_names", 3102165223L), java.util.Map.entry("get_end", 490464691L),
			java.util.Map.entry("get_group_count", 3905245786L), java.util.Map.entry("get_subject", 201670096L),
			java.util.Map.entry("get_strings", 1139954409L));

	RegExMatch(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RegExMatch(long nativePointer) {
		super(nativePointer);
	}

	public String get_string(Object name) {
		return (String) super.call("get_string", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int get_start(Object name) {
		return (int) super.call("get_start", new java.lang.Object[]{(java.lang.Object) name});
	}

	public int get_end(Object name) {
		return (int) super.call("get_end", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String getSubject() {
		return (String) super.call("get_subject", new java.lang.Object[0]);
	}

	public void setSubject(String value) {
		super.call("set_subject", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotDictionary getNames() {
		return (GodotDictionary) super.call("get_names", new java.lang.Object[0]);
	}

	public void setNames(GodotDictionary value) {
		super.call("set_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getStrings() {
		return (GodotArray) super.call("get_strings", new java.lang.Object[0]);
	}

	public void setStrings(GodotArray value) {
		super.call("set_strings", new java.lang.Object[]{(java.lang.Object) value});
	}
}
