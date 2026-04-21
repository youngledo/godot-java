package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class Marshalls extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("base64_to_raw", 659035735L), java.util.Map.entry("base64_to_utf8", 1703090593L),
			java.util.Map.entry("base64_to_variant", 218087648L), java.util.Map.entry("raw_to_base64", 3999417757L),
			java.util.Map.entry("utf8_to_base64", 1703090593L), java.util.Map.entry("variant_to_base64", 3876248563L));

	Marshalls(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Marshalls(long nativePointer) {
		super(nativePointer);
	}

	public String variant_to_base64(Object variant, boolean full_objects) {
		return (String) super.call("variant_to_base64",
				new java.lang.Object[]{(java.lang.Object) variant, java.lang.Boolean.valueOf(full_objects)});
	}

	public Object base64_to_variant(String base64_str, boolean allow_objects) {
		return (Object) super.call("base64_to_variant",
				new java.lang.Object[]{(java.lang.Object) base64_str, java.lang.Boolean.valueOf(allow_objects)});
	}

	public String raw_to_base64(byte[] array) {
		return (String) super.call("raw_to_base64", new java.lang.Object[]{(java.lang.Object) array});
	}

	public byte[] base64_to_raw(String base64_str) {
		return (byte[]) super.call("base64_to_raw", new java.lang.Object[]{(java.lang.Object) base64_str});
	}

	public String utf8_to_base64(String utf8_str) {
		return (String) super.call("utf8_to_base64", new java.lang.Object[]{(java.lang.Object) utf8_str});
	}

	public String base64_to_utf8(String base64_str) {
		return (String) super.call("base64_to_utf8", new java.lang.Object[]{(java.lang.Object) base64_str});
	}
}
