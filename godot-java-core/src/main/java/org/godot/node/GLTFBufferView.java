package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class GLTFBufferView extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load_buffer_view_data", 3945446907L),
			java.util.Map.entry("set_vertex_attributes", 2586408642L),
			java.util.Map.entry("get_vertex_attributes", 36873697L), java.util.Map.entry("get_buffer", 3905245786L),
			java.util.Map.entry("from_dictionary", 2594413512L), java.util.Map.entry("set_buffer", 1286410249L),
			java.util.Map.entry("set_byte_stride", 1286410249L), java.util.Map.entry("set_byte_offset", 1286410249L),
			java.util.Map.entry("to_dictionary", 3102165223L), java.util.Map.entry("get_byte_stride", 3905245786L),
			java.util.Map.entry("set_byte_length", 1286410249L), java.util.Map.entry("get_byte_offset", 3905245786L),
			java.util.Map.entry("set_indices", 2586408642L), java.util.Map.entry("get_byte_length", 3905245786L),
			java.util.Map.entry("get_indices", 36873697L));

	GLTFBufferView(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFBufferView(long nativePointer) {
		super(nativePointer);
	}

	public byte[] load_buffer_view_data(GLTFState state) {
		return (byte[]) super.call("load_buffer_view_data", new java.lang.Object[]{(java.lang.Object) state});
	}

	public GLTFBufferView from_dictionary(GodotDictionary dictionary) {
		return (GLTFBufferView) super.call("from_dictionary", new java.lang.Object[]{(java.lang.Object) dictionary});
	}

	public GodotDictionary to_dictionary() {
		return (GodotDictionary) super.call("to_dictionary");
	}

	public long getBuffer() {
		return (long) super.call("get_buffer", new java.lang.Object[0]);
	}

	public void setBuffer(long value) {
		super.call("set_buffer", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getByte_offset() {
		return (long) super.call("get_byte_offset", new java.lang.Object[0]);
	}

	public void setByte_offset(long value) {
		super.call("set_byte_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getByte_length() {
		return (long) super.call("get_byte_length", new java.lang.Object[0]);
	}

	public void setByte_length(long value) {
		super.call("set_byte_length", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getByte_stride() {
		return (long) super.call("get_byte_stride", new java.lang.Object[0]);
	}

	public void setByte_stride(long value) {
		super.call("set_byte_stride", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getIndices() {
		return (boolean) super.call("get_indices", new java.lang.Object[0]);
	}

	public void setIndices(boolean value) {
		super.call("set_indices", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getVertex_attributes() {
		return (boolean) super.call("get_vertex_attributes", new java.lang.Object[0]);
	}

	public void setVertex_attributes(boolean value) {
		super.call("set_vertex_attributes", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
