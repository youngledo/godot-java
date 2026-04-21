package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RegEx extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("search_all", 849021363L), java.util.Map.entry("sub", 54019702L),
			java.util.Map.entry("create_from_string", 4249111514L), java.util.Map.entry("search", 3365977994L),
			java.util.Map.entry("compile", 3565188097L), java.util.Map.entry("get_names", 1139954409L),
			java.util.Map.entry("is_valid", 36873697L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("get_group_count", 3905245786L), java.util.Map.entry("get_pattern", 201670096L));

	RegEx(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RegEx(long nativePointer) {
		super(nativePointer);
	}

	public RegEx create_from_string(String pattern, boolean show_error) {
		return (RegEx) super.call("create_from_string",
				new java.lang.Object[]{(java.lang.Object) pattern, java.lang.Boolean.valueOf(show_error)});
	}

	public void clear() {
		super.call("clear");
	}

	public int compile(String pattern, boolean show_error) {
		return (int) super.call("compile",
				new java.lang.Object[]{(java.lang.Object) pattern, java.lang.Boolean.valueOf(show_error)});
	}

	public RegExMatch search(String subject, long offset, long end) {
		return (RegExMatch) super.call("search", new java.lang.Object[]{(java.lang.Object) subject,
				java.lang.Long.valueOf(offset), java.lang.Long.valueOf(end)});
	}

	public RegExMatch[] search_all(String subject, long offset, long end) {
		return (RegExMatch[]) super.call("search_all", new java.lang.Object[]{(java.lang.Object) subject,
				java.lang.Long.valueOf(offset), java.lang.Long.valueOf(end)});
	}

	public String sub(String subject, String replacement, boolean all, long offset, long end) {
		return (String) super.call("sub",
				new java.lang.Object[]{(java.lang.Object) subject, (java.lang.Object) replacement,
						java.lang.Boolean.valueOf(all), java.lang.Long.valueOf(offset), java.lang.Long.valueOf(end)});
	}

	public boolean is_valid() {
		return (boolean) super.call("is_valid");
	}
}
