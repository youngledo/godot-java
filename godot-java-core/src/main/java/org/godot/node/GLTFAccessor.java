package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class GLTFAccessor extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_sparse_indices_byte_offset", 1286410249L),
			java.util.Map.entry("get_sparse_indices_component_type", 852227802L),
			java.util.Map.entry("set_component_type", 1780020221L), java.util.Map.entry("set_byte_offset", 1286410249L),
			java.util.Map.entry("get_type", 3905245786L), java.util.Map.entry("set_max", 2576592201L),
			java.util.Map.entry("set_sparse_indices_buffer_view", 1286410249L),
			java.util.Map.entry("get_count", 3905245786L), java.util.Map.entry("set_normalized", 2586408642L),
			java.util.Map.entry("get_sparse_indices_buffer_view", 3905245786L),
			java.util.Map.entry("set_sparse_values_byte_offset", 1286410249L),
			java.util.Map.entry("get_byte_offset", 3905245786L),
			java.util.Map.entry("set_sparse_values_buffer_view", 1286410249L),
			java.util.Map.entry("set_count", 1286410249L),
			java.util.Map.entry("get_sparse_values_byte_offset", 3905245786L),
			java.util.Map.entry("get_accessor_type", 1998183368L),
			java.util.Map.entry("get_sparse_values_buffer_view", 3905245786L),
			java.util.Map.entry("set_accessor_type", 2347728198L), java.util.Map.entry("set_min", 2576592201L),
			java.util.Map.entry("set_buffer_view", 1286410249L), java.util.Map.entry("get_min", 547233126L),
			java.util.Map.entry("get_sparse_indices_byte_offset", 3905245786L),
			java.util.Map.entry("get_buffer_view", 3905245786L), java.util.Map.entry("set_type", 1286410249L),
			java.util.Map.entry("from_dictionary", 3495091019L), java.util.Map.entry("get_component_type", 852227802L),
			java.util.Map.entry("get_max", 547233126L), java.util.Map.entry("get_sparse_count", 3905245786L),
			java.util.Map.entry("set_sparse_count", 1286410249L), java.util.Map.entry("to_dictionary", 3102165223L),
			java.util.Map.entry("get_normalized", 36873697L),
			java.util.Map.entry("set_sparse_indices_component_type", 1780020221L));

	GLTFAccessor(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFAccessor(long nativePointer) {
		super(nativePointer);
	}

	public GLTFAccessor from_dictionary(GodotDictionary dictionary) {
		return (GLTFAccessor) super.call("from_dictionary", new java.lang.Object[]{(java.lang.Object) dictionary});
	}

	public GodotDictionary to_dictionary() {
		return (GodotDictionary) super.call("to_dictionary");
	}

	public long getBuffer_view() {
		return (long) super.call("get_buffer_view", new java.lang.Object[0]);
	}

	public void setBuffer_view(long value) {
		super.call("set_buffer_view", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getByte_offset() {
		return (long) super.call("get_byte_offset", new java.lang.Object[0]);
	}

	public void setByte_offset(long value) {
		super.call("set_byte_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getComponent_type() {
		return (long) super.call("get_component_type", new java.lang.Object[0]);
	}

	public void setComponent_type(long value) {
		super.call("set_component_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getNormalized() {
		return (boolean) super.call("get_normalized", new java.lang.Object[0]);
	}

	public void setNormalized(boolean value) {
		super.call("set_normalized", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getCount() {
		return (long) super.call("get_count", new java.lang.Object[0]);
	}

	public void setCount(long value) {
		super.call("set_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getAccessor_type() {
		return (long) super.call("get_accessor_type", new java.lang.Object[0]);
	}

	public void setAccessor_type(long value) {
		super.call("set_accessor_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getType() {
		return (long) super.call("get_type", new java.lang.Object[0]);
	}

	public void setType(long value) {
		super.call("set_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double[] getMin() {
		return (double[]) super.call("get_min", new java.lang.Object[0]);
	}

	public void setMin(double[] value) {
		super.call("set_min", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double[] getMax() {
		return (double[]) super.call("get_max", new java.lang.Object[0]);
	}

	public void setMax(double[] value) {
		super.call("set_max", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getSparse_count() {
		return (long) super.call("get_sparse_count", new java.lang.Object[0]);
	}

	public void setSparse_count(long value) {
		super.call("set_sparse_count", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSparse_indices_buffer_view() {
		return (long) super.call("get_sparse_indices_buffer_view", new java.lang.Object[0]);
	}

	public void setSparse_indices_buffer_view(long value) {
		super.call("set_sparse_indices_buffer_view", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSparse_indices_byte_offset() {
		return (long) super.call("get_sparse_indices_byte_offset", new java.lang.Object[0]);
	}

	public void setSparse_indices_byte_offset(long value) {
		super.call("set_sparse_indices_byte_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSparse_indices_component_type() {
		return (long) super.call("get_sparse_indices_component_type", new java.lang.Object[0]);
	}

	public void setSparse_indices_component_type(long value) {
		super.call("set_sparse_indices_component_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSparse_values_buffer_view() {
		return (long) super.call("get_sparse_values_buffer_view", new java.lang.Object[0]);
	}

	public void setSparse_values_buffer_view(long value) {
		super.call("set_sparse_values_buffer_view", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSparse_values_byte_offset() {
		return (long) super.call("get_sparse_values_byte_offset", new java.lang.Object[0]);
	}

	public void setSparse_values_byte_offset(long value) {
		super.call("set_sparse_values_byte_offset", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
