package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class XMLParser extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("open_buffer", 680677267L), java.util.Map.entry("read", 166280745L),
			java.util.Map.entry("get_named_attribute_value", 3135753539L),
			java.util.Map.entry("get_named_attribute_value_safe", 3135753539L),
			java.util.Map.entry("get_attribute_count", 3905245786L),
			java.util.Map.entry("get_attribute_name", 844755477L), java.util.Map.entry("get_current_line", 3905245786L),
			java.util.Map.entry("seek", 844576869L), java.util.Map.entry("get_node_offset", 3905245786L),
			java.util.Map.entry("get_node_name", 201670096L), java.util.Map.entry("get_attribute_value", 844755477L),
			java.util.Map.entry("get_node_data", 201670096L), java.util.Map.entry("skip_section", 3218959716L),
			java.util.Map.entry("has_attribute", 3927539163L), java.util.Map.entry("get_node_type", 2984359541L),
			java.util.Map.entry("is_empty", 36873697L), java.util.Map.entry("open", 166001499L));

	XMLParser(MemorySegment nativePointer) {
		super(nativePointer);
	}

	XMLParser(long nativePointer) {
		super(nativePointer);
	}

	public int read() {
		return (int) super.call("read");
	}

	public String get_attribute_name(long idx) {
		return (String) super.call("get_attribute_name", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public String get_attribute_value(long idx) {
		return (String) super.call("get_attribute_value", new java.lang.Object[]{java.lang.Long.valueOf(idx)});
	}

	public boolean has_attribute(String name) {
		return (boolean) super.call("has_attribute", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_named_attribute_value(String name) {
		return (String) super.call("get_named_attribute_value", new java.lang.Object[]{(java.lang.Object) name});
	}

	public String get_named_attribute_value_safe(String name) {
		return (String) super.call("get_named_attribute_value_safe", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean is_empty() {
		return (boolean) super.call("is_empty");
	}

	public void skip_section() {
		super.call("skip_section");
	}

	public int seek(long position) {
		return (int) super.call("seek", new java.lang.Object[]{java.lang.Long.valueOf(position)});
	}

	public int open(String file) {
		return (int) super.call("open", new java.lang.Object[]{(java.lang.Object) file});
	}

	public int open_buffer(byte[] buffer) {
		return (int) super.call("open_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}
}
