package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;

public class OpenXRSpatialEntityExtension extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_spatial_context_handle", 2198884583L),
			java.util.Map.entry("get_string", 1464764419L), java.util.Map.entry("update_spatial_entities", 3446086438L),
			java.util.Map.entry("get_uint32_buffer", 3393655756L),
			java.util.Map.entry("get_spatial_snapshot_handle", 2198884583L),
			java.util.Map.entry("query_snapshot", 641015484L),
			java.util.Map.entry("supports_component_type", 26842779L),
			java.util.Map.entry("find_spatial_entity", 937000113L),
			java.util.Map.entry("discover_spatial_entities", 2252833536L),
			java.util.Map.entry("get_uint16_buffer", 3393655756L),
			java.util.Map.entry("add_spatial_entity", 2256026069L),
			java.util.Map.entry("make_spatial_entity", 2233757277L),
			java.util.Map.entry("supports_capability", 1940837202L),
			java.util.Map.entry("free_spatial_entity", 2722037293L),
			java.util.Map.entry("get_vector2_buffer", 110850971L),
			java.util.Map.entry("get_vector3_buffer", 1166453791L),
			java.util.Map.entry("create_spatial_context", 1874506473L),
			java.util.Map.entry("get_spatial_entity_id", 2198884583L),
			java.util.Map.entry("get_float_buffer", 2313216651L),
			java.util.Map.entry("free_spatial_context", 2722037293L),
			java.util.Map.entry("free_spatial_snapshot", 2722037293L),
			java.util.Map.entry("get_uint8_buffer", 3570600051L),
			java.util.Map.entry("get_spatial_snapshot_context", 3814569979L),
			java.util.Map.entry("get_spatial_context_ready", 4155700596L),
			java.util.Map.entry("get_spatial_entity_context", 3814569979L));

	OpenXRSpatialEntityExtension(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialEntityExtension(long nativePointer) {
		super(nativePointer);
	}

	public boolean supports_capability(int capability) {
		return (boolean) super.call("supports_capability",
				new java.lang.Object[]{java.lang.Integer.valueOf(capability)});
	}

	public boolean supports_component_type(int capability, int component_type) {
		return (boolean) super.call("supports_component_type", new java.lang.Object[]{
				java.lang.Integer.valueOf(capability), java.lang.Integer.valueOf(component_type)});
	}

	public OpenXRFutureResult create_spatial_context(
			OpenXRSpatialCapabilityConfigurationBaseHeader[] capability_configurations, OpenXRStructureBase next,
			Callable user_callback) {
		return (OpenXRFutureResult) super.call("create_spatial_context",
				new java.lang.Object[]{(java.lang.Object) capability_configurations, (java.lang.Object) next,
						(java.lang.Object) user_callback});
	}

	public boolean get_spatial_context_ready(long spatial_context) {
		return (boolean) super.call("get_spatial_context_ready",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_context)});
	}

	public void free_spatial_context(long spatial_context) {
		super.call("free_spatial_context", new java.lang.Object[]{java.lang.Long.valueOf(spatial_context)});
	}

	public java.math.BigInteger get_spatial_context_handle(long spatial_context) {
		return (java.math.BigInteger) super.call("get_spatial_context_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_context)});
	}

	public OpenXRFutureResult discover_spatial_entities(long spatial_context, long[] component_types,
			OpenXRStructureBase next, Callable user_callback) {
		return (OpenXRFutureResult) super.call("discover_spatial_entities",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_context), (java.lang.Object) component_types,
						(java.lang.Object) next, (java.lang.Object) user_callback});
	}

	public long update_spatial_entities(long spatial_context, long[] entities, long[] component_types,
			OpenXRStructureBase next) {
		return (long) super.call("update_spatial_entities",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_context), (java.lang.Object) entities,
						(java.lang.Object) component_types, (java.lang.Object) next});
	}

	public void free_spatial_snapshot(long spatial_snapshot) {
		super.call("free_spatial_snapshot", new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot)});
	}

	public java.math.BigInteger get_spatial_snapshot_handle(long spatial_snapshot) {
		return (java.math.BigInteger) super.call("get_spatial_snapshot_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot)});
	}

	public long get_spatial_snapshot_context(long spatial_snapshot) {
		return (long) super.call("get_spatial_snapshot_context",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot)});
	}

	public boolean query_snapshot(long spatial_snapshot, OpenXRSpatialComponentData[] component_data,
			OpenXRStructureBase next) {
		return (boolean) super.call("query_snapshot", new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot),
				(java.lang.Object) component_data, (java.lang.Object) next});
	}

	public String get_string(long spatial_snapshot, long buffer_id) {
		return (String) super.call("get_string",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public byte[] get_uint8_buffer(long spatial_snapshot, long buffer_id) {
		return (byte[]) super.call("get_uint8_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public int[] get_uint16_buffer(long spatial_snapshot, long buffer_id) {
		return (int[]) super.call("get_uint16_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public int[] get_uint32_buffer(long spatial_snapshot, long buffer_id) {
		return (int[]) super.call("get_uint32_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public double[] get_float_buffer(long spatial_snapshot, long buffer_id) {
		return (double[]) super.call("get_float_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public double[][] get_vector2_buffer(long spatial_snapshot, long buffer_id) {
		return (double[][]) super.call("get_vector2_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public double[][] get_vector3_buffer(long spatial_snapshot, long buffer_id) {
		return (double[][]) super.call("get_vector3_buffer",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_snapshot), java.lang.Long.valueOf(buffer_id)});
	}

	public long find_spatial_entity(long entity_id) {
		return (long) super.call("find_spatial_entity", new java.lang.Object[]{java.lang.Long.valueOf(entity_id)});
	}

	public long add_spatial_entity(long spatial_context, long entity_id, long entity) {
		return (long) super.call("add_spatial_entity", new java.lang.Object[]{java.lang.Long.valueOf(spatial_context),
				java.lang.Long.valueOf(entity_id), java.lang.Long.valueOf(entity)});
	}

	public long make_spatial_entity(long spatial_context, long entity_id) {
		return (long) super.call("make_spatial_entity",
				new java.lang.Object[]{java.lang.Long.valueOf(spatial_context), java.lang.Long.valueOf(entity_id)});
	}

	public java.math.BigInteger get_spatial_entity_id(long entity) {
		return (java.math.BigInteger) super.call("get_spatial_entity_id",
				new java.lang.Object[]{java.lang.Long.valueOf(entity)});
	}

	public long get_spatial_entity_context(long entity) {
		return (long) super.call("get_spatial_entity_context", new java.lang.Object[]{java.lang.Long.valueOf(entity)});
	}

	public void free_spatial_entity(long entity) {
		super.call("free_spatial_entity", new java.lang.Object[]{java.lang.Long.valueOf(entity)});
	}
}
