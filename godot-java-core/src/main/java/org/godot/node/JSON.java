package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class JSON extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("parse_string", 309047738L), java.util.Map.entry("get_parsed_text", 201670096L),
			java.util.Map.entry("get_error_message", 201670096L), java.util.Map.entry("get_data", 1214101251L),
			java.util.Map.entry("get_error_line", 3905245786L), java.util.Map.entry("parse", 885841341L),
			java.util.Map.entry("stringify", 462733549L), java.util.Map.entry("to_native", 2963479484L),
			java.util.Map.entry("from_native", 2963479484L), java.util.Map.entry("set_data", 1114965689L));

	JSON(MemorySegment nativePointer) {
		super(nativePointer);
	}

	JSON(long nativePointer) {
		super(nativePointer);
	}

	public String stringify(Object data, String indent, boolean sort_keys, boolean full_precision) {
		return (String) super.call("stringify",
				new java.lang.Object[]{(java.lang.Object) data, (java.lang.Object) indent,
						java.lang.Boolean.valueOf(sort_keys), java.lang.Boolean.valueOf(full_precision)});
	}

	public Object parse_string(String json_string) {
		return (Object) super.call("parse_string", new java.lang.Object[]{(java.lang.Object) json_string});
	}

	public int parse(String json_text, boolean keep_text) {
		return (int) super.call("parse",
				new java.lang.Object[]{(java.lang.Object) json_text, java.lang.Boolean.valueOf(keep_text)});
	}

	public Object from_native(Object variant, boolean full_objects) {
		return (Object) super.call("from_native",
				new java.lang.Object[]{(java.lang.Object) variant, java.lang.Boolean.valueOf(full_objects)});
	}

	public Object to_native(Object json, boolean allow_objects) {
		return (Object) super.call("to_native",
				new java.lang.Object[]{(java.lang.Object) json, java.lang.Boolean.valueOf(allow_objects)});
	}

	public Object getData() {
		return (Object) super.call("get_data", new java.lang.Object[0]);
	}

	public void setData(Object value) {
		super.call("set_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
