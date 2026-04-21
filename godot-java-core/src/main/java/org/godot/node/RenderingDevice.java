package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.core.Callable;
import org.godot.math.Color;
import org.godot.math.Rect2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3;

public class RenderingDevice extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("texture_update", 1349464008L),
			java.util.Map.entry("framebuffer_is_valid", 4155700596L),
			java.util.Map.entry("get_driver_allocs_by_object_type", 923996154L),
			java.util.Map.entry("set_resource_name", 2726140452L),
			java.util.Map.entry("get_captured_timestamp_gpu_time", 923996154L),
			java.util.Map.entry("get_captured_timestamp_cpu_time", 923996154L),
			java.util.Map.entry("draw_list_bind_vertex_array", 4040184819L),
			java.util.Map.entry("get_captured_timestamps_count", 3905245786L),
			java.util.Map.entry("get_driver_resource", 501815484L),
			java.util.Map.entry("compute_pipeline_is_valid", 3521089500L),
			java.util.Map.entry("sampler_create", 2327892535L),
			java.util.Map.entry("texture_set_discardable", 1265174801L),
			java.util.Map.entry("get_captured_timestamps_frame", 3905245786L),
			java.util.Map.entry("compute_list_dispatch", 4275841770L),
			java.util.Map.entry("draw_list_switch_to_next_pass_split", 2865087369L),
			java.util.Map.entry("get_memory_usage", 251690689L),
			java.util.Map.entry("draw_command_end_label", 3218959716L),
			java.util.Map.entry("framebuffer_format_create", 697032759L),
			java.util.Map.entry("uniform_set_create", 2280795797L), java.util.Map.entry("limit_get", 1559202131L),
			java.util.Map.entry("get_driver_total_memory", 3905245786L),
			java.util.Map.entry("uniform_buffer_create", 2089548973L),
			java.util.Map.entry("draw_list_switch_to_next_pass", 2455072627L),
			java.util.Map.entry("compute_list_set_push_constant", 2772371345L),
			java.util.Map.entry("compute_list_bind_compute_pipeline", 4040184819L),
			java.util.Map.entry("texture_clear", 3477703247L),
			java.util.Map.entry("texture_create_shared", 3178156134L),
			java.util.Map.entry("get_device_allocation_count", 3905245786L),
			java.util.Map.entry("texture_copy", 2859522160L), java.util.Map.entry("framebuffer_create", 3284231055L),
			java.util.Map.entry("framebuffer_format_create_multipass", 2647479094L),
			java.util.Map.entry("shader_get_vertex_input_attribute_mask", 3917799429L),
			java.util.Map.entry("texture_create_shared_from_slice", 1808971279L),
			java.util.Map.entry("draw_list_set_push_constant", 2772371345L),
			java.util.Map.entry("vertex_array_create", 3799816279L),
			java.util.Map.entry("draw_list_bind_vertex_buffers_format", 2008628980L),
			java.util.Map.entry("draw_command_begin_label", 1636512886L),
			java.util.Map.entry("index_buffer_create", 2368684885L),
			java.util.Map.entry("framebuffer_create_multipass", 1750306695L),
			java.util.Map.entry("texture_get_format", 1374471690L),
			java.util.Map.entry("get_tracked_object_type_count", 3905245786L),
			java.util.Map.entry("buffer_get_data", 3101830688L),
			java.util.Map.entry("get_device_total_memory", 3905245786L),
			java.util.Map.entry("sampler_is_format_supported_for_filter", 2247922238L),
			java.util.Map.entry("render_pipeline_is_valid", 3521089500L),
			java.util.Map.entry("draw_list_begin", 1317926357L), java.util.Map.entry("capture_timestamp", 83702148L),
			java.util.Map.entry("framebuffer_create_empty", 3058360618L),
			java.util.Map.entry("texture_create", 3709173589L),
			java.util.Map.entry("vertex_format_create", 1242678479L),
			java.util.Map.entry("get_device_name", 201670096L),
			java.util.Map.entry("draw_list_bind_index_array", 4040184819L),
			java.util.Map.entry("compute_pipeline_create", 1448838280L),
			java.util.Map.entry("screen_get_width", 1591665591L),
			java.util.Map.entry("screen_get_framebuffer_format", 1591665591L),
			java.util.Map.entry("compute_list_end", 3218959716L),
			java.util.Map.entry("uniform_set_is_valid", 3521089500L),
			java.util.Map.entry("texture_get_native_handle", 3917799429L),
			java.util.Map.entry("get_captured_timestamp_name", 844755477L),
			java.util.Map.entry("get_device_pipeline_cache_uuid", 201670096L),
			java.util.Map.entry("get_device_memory_by_object_type", 923996154L),
			java.util.Map.entry("draw_command_insert_label", 1636512886L),
			java.util.Map.entry("framebuffer_format_create_empty", 555930169L),
			java.util.Map.entry("barrier", 3718155691L),
			java.util.Map.entry("compute_list_bind_uniform_set", 749655778L),
			java.util.Map.entry("shader_compile_spirv_from_source", 1178973306L),
			java.util.Map.entry("get_frame_delay", 3905245786L),
			java.util.Map.entry("draw_list_disable_scissor", 1286410249L),
			java.util.Map.entry("get_device_vendor_name", 201670096L), java.util.Map.entry("buffer_clear", 2452320800L),
			java.util.Map.entry("shader_create_from_spirv", 342949005L),
			java.util.Map.entry("texture_get_data", 1859412099L),
			java.util.Map.entry("draw_list_bind_render_pipeline", 4040184819L),
			java.util.Map.entry("sync", 3218959716L), java.util.Map.entry("shader_create_from_bytecode", 1687031350L),
			java.util.Map.entry("storage_buffer_create", 1609052553L),
			java.util.Map.entry("get_driver_allocation_count", 3905245786L),
			java.util.Map.entry("texture_is_format_supported_for_usage", 2592520478L),
			java.util.Map.entry("texture_is_valid", 3521089500L),
			java.util.Map.entry("get_tracked_object_name", 844755477L),
			java.util.Map.entry("texture_is_discardable", 3521089500L),
			java.util.Map.entry("get_device_allocs_by_object_type", 923996154L),
			java.util.Map.entry("buffer_get_device_address", 3917799429L),
			java.util.Map.entry("compute_list_begin", 2455072627L), java.util.Map.entry("submit", 3218959716L),
			java.util.Map.entry("texture_resolve_multisample", 3181288260L),
			java.util.Map.entry("get_driver_memory_by_object_type", 923996154L),
			java.util.Map.entry("texture_create_from_extension", 3732868568L),
			java.util.Map.entry("buffer_get_data_async", 2370287848L),
			java.util.Map.entry("vertex_buffer_create", 2089548973L),
			java.util.Map.entry("compute_list_dispatch_indirect", 749655778L),
			java.util.Map.entry("shader_create_placeholder", 529393457L),
			java.util.Map.entry("framebuffer_get_format", 3917799429L),
			java.util.Map.entry("texture_is_shared", 3521089500L),
			java.util.Map.entry("draw_list_begin_split", 2406300660L),
			java.util.Map.entry("draw_list_draw", 4230067973L),
			java.util.Map.entry("draw_list_draw_indirect", 1092133571L),
			java.util.Map.entry("buffer_update", 3454956949L),
			java.util.Map.entry("texture_buffer_create", 1470338698L), java.util.Map.entry("full_barrier", 3218959716L),
			java.util.Map.entry("draw_list_begin_for_screen", 3988079995L),
			java.util.Map.entry("draw_list_end", 3218959716L),
			java.util.Map.entry("shader_compile_binary_from_spirv", 134910450L),
			java.util.Map.entry("draw_list_set_blend_constants", 2878471219L),
			java.util.Map.entry("get_perf_report", 201670096L), java.util.Map.entry("free_rid", 2722037293L),
			java.util.Map.entry("framebuffer_format_get_texture_samples", 4223391010L),
			java.util.Map.entry("screen_get_height", 1591665591L),
			java.util.Map.entry("index_array_create", 2256026069L),
			java.util.Map.entry("render_pipeline_create", 2385451958L), java.util.Map.entry("buffer_copy", 864257779L),
			java.util.Map.entry("get_driver_and_device_memory_report", 201670096L),
			java.util.Map.entry("texture_get_data_async", 498832090L),
			java.util.Map.entry("compute_list_add_barrier", 1286410249L),
			java.util.Map.entry("create_local_device", 2846302423L),
			java.util.Map.entry("draw_list_enable_scissor", 244650101L),
			java.util.Map.entry("draw_list_bind_uniform_set", 749655778L),
			java.util.Map.entry("has_feature", 1772728326L));

	RenderingDevice(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderingDevice(long nativePointer) {
		super(nativePointer);
	}

	public long texture_create(RDTextureFormat format, RDTextureView view, Object[] data) {
		return (long) super.call("texture_create",
				new java.lang.Object[]{(java.lang.Object) format, (java.lang.Object) view, (java.lang.Object) data});
	}

	public long texture_create_shared(RDTextureView view, long with_texture) {
		return (long) super.call("texture_create_shared",
				new java.lang.Object[]{(java.lang.Object) view, java.lang.Long.valueOf(with_texture)});
	}

	public long texture_create_shared_from_slice(RDTextureView view, long with_texture, long layer, long mipmap,
			long mipmaps, int slice_type) {
		return (long) super.call("texture_create_shared_from_slice",
				new java.lang.Object[]{(java.lang.Object) view, java.lang.Long.valueOf(with_texture),
						java.lang.Long.valueOf(layer), java.lang.Long.valueOf(mipmap), java.lang.Long.valueOf(mipmaps),
						java.lang.Integer.valueOf(slice_type)});
	}

	public long texture_create_from_extension(int type, int format, int samples, int usage_flags, long image,
			long width, long height, long depth, long layers, long mipmaps) {
		return (long) super.call("texture_create_from_extension",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Integer.valueOf(format),
						java.lang.Integer.valueOf(samples), java.lang.Integer.valueOf(usage_flags),
						java.lang.Long.valueOf(image), java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Long.valueOf(depth), java.lang.Long.valueOf(layers),
						java.lang.Long.valueOf(mipmaps)});
	}

	public int texture_update(long texture, long layer, byte[] data) {
		return (int) super.call("texture_update", new java.lang.Object[]{java.lang.Long.valueOf(texture),
				java.lang.Long.valueOf(layer), (java.lang.Object) data});
	}

	public byte[] texture_get_data(long texture, long layer) {
		return (byte[]) super.call("texture_get_data",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Long.valueOf(layer)});
	}

	public int texture_get_data_async(long texture, long layer, Callable callback) {
		return (int) super.call("texture_get_data_async", new java.lang.Object[]{java.lang.Long.valueOf(texture),
				java.lang.Long.valueOf(layer), (java.lang.Object) callback});
	}

	public boolean texture_is_format_supported_for_usage(int format, int usage_flags) {
		return (boolean) super.call("texture_is_format_supported_for_usage",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Integer.valueOf(usage_flags)});
	}

	public boolean texture_is_shared(long texture) {
		return (boolean) super.call("texture_is_shared", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public boolean texture_is_valid(long texture) {
		return (boolean) super.call("texture_is_valid", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public void texture_set_discardable(long texture, boolean discardable) {
		super.call("texture_set_discardable",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), java.lang.Boolean.valueOf(discardable)});
	}

	public boolean texture_is_discardable(long texture) {
		return (boolean) super.call("texture_is_discardable", new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public int texture_copy(long from_texture, long to_texture, Vector3 from_pos, Vector3 to_pos, Vector3 size,
			long src_mipmap, long dst_mipmap, long src_layer, long dst_layer) {
		return (int) super.call("texture_copy",
				new java.lang.Object[]{java.lang.Long.valueOf(from_texture), java.lang.Long.valueOf(to_texture),
						(java.lang.Object) from_pos, (java.lang.Object) to_pos, (java.lang.Object) size,
						java.lang.Long.valueOf(src_mipmap), java.lang.Long.valueOf(dst_mipmap),
						java.lang.Long.valueOf(src_layer), java.lang.Long.valueOf(dst_layer)});
	}

	public int texture_clear(long texture, Color color, long base_mipmap, long mipmap_count, long base_layer,
			long layer_count) {
		return (int) super.call("texture_clear",
				new java.lang.Object[]{java.lang.Long.valueOf(texture), (java.lang.Object) color,
						java.lang.Long.valueOf(base_mipmap), java.lang.Long.valueOf(mipmap_count),
						java.lang.Long.valueOf(base_layer), java.lang.Long.valueOf(layer_count)});
	}

	public int texture_resolve_multisample(long from_texture, long to_texture) {
		return (int) super.call("texture_resolve_multisample",
				new java.lang.Object[]{java.lang.Long.valueOf(from_texture), java.lang.Long.valueOf(to_texture)});
	}

	public RDTextureFormat texture_get_format(long texture) {
		return (RDTextureFormat) super.call("texture_get_format",
				new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public java.math.BigInteger texture_get_native_handle(long texture) {
		return (java.math.BigInteger) super.call("texture_get_native_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(texture)});
	}

	public long framebuffer_format_create(RDAttachmentFormat[] attachments, long view_count) {
		return (long) super.call("framebuffer_format_create",
				new java.lang.Object[]{(java.lang.Object) attachments, java.lang.Long.valueOf(view_count)});
	}

	public long framebuffer_format_create_multipass(RDAttachmentFormat[] attachments, RDFramebufferPass[] passes,
			long view_count) {
		return (long) super.call("framebuffer_format_create_multipass", new java.lang.Object[]{
				(java.lang.Object) attachments, (java.lang.Object) passes, java.lang.Long.valueOf(view_count)});
	}

	public long framebuffer_format_create_empty(int samples) {
		return (long) super.call("framebuffer_format_create_empty",
				new java.lang.Object[]{java.lang.Integer.valueOf(samples)});
	}

	public int framebuffer_format_get_texture_samples(long format, long render_pass) {
		return (int) super.call("framebuffer_format_get_texture_samples",
				new java.lang.Object[]{java.lang.Long.valueOf(format), java.lang.Long.valueOf(render_pass)});
	}

	public long framebuffer_create(long[] textures, long validate_with_format, long view_count) {
		return (long) super.call("framebuffer_create", new java.lang.Object[]{(java.lang.Object) textures,
				java.lang.Long.valueOf(validate_with_format), java.lang.Long.valueOf(view_count)});
	}

	public long framebuffer_create_multipass(long[] textures, RDFramebufferPass[] passes, long validate_with_format,
			long view_count) {
		return (long) super.call("framebuffer_create_multipass",
				new java.lang.Object[]{(java.lang.Object) textures, (java.lang.Object) passes,
						java.lang.Long.valueOf(validate_with_format), java.lang.Long.valueOf(view_count)});
	}

	public long framebuffer_create_empty(Vector2i size, int samples, long validate_with_format) {
		return (long) super.call("framebuffer_create_empty", new java.lang.Object[]{(java.lang.Object) size,
				java.lang.Integer.valueOf(samples), java.lang.Long.valueOf(validate_with_format)});
	}

	public long framebuffer_get_format(long framebuffer) {
		return (long) super.call("framebuffer_get_format", new java.lang.Object[]{java.lang.Long.valueOf(framebuffer)});
	}

	public boolean framebuffer_is_valid(long framebuffer) {
		return (boolean) super.call("framebuffer_is_valid",
				new java.lang.Object[]{java.lang.Long.valueOf(framebuffer)});
	}

	public long sampler_create(RDSamplerState state) {
		return (long) super.call("sampler_create", new java.lang.Object[]{(java.lang.Object) state});
	}

	public boolean sampler_is_format_supported_for_filter(int format, int sampler_filter) {
		return (boolean) super.call("sampler_is_format_supported_for_filter",
				new java.lang.Object[]{java.lang.Integer.valueOf(format), java.lang.Integer.valueOf(sampler_filter)});
	}

	public long vertex_buffer_create(long size_bytes, byte[] data, int creation_bits) {
		return (long) super.call("vertex_buffer_create", new java.lang.Object[]{java.lang.Long.valueOf(size_bytes),
				(java.lang.Object) data, java.lang.Integer.valueOf(creation_bits)});
	}

	public long vertex_format_create(RDVertexAttribute[] vertex_descriptions) {
		return (long) super.call("vertex_format_create",
				new java.lang.Object[]{(java.lang.Object) vertex_descriptions});
	}

	public long vertex_array_create(long vertex_count, long vertex_format, long[] src_buffers, long[] offsets) {
		return (long) super.call("vertex_array_create", new java.lang.Object[]{java.lang.Long.valueOf(vertex_count),
				java.lang.Long.valueOf(vertex_format), (java.lang.Object) src_buffers, (java.lang.Object) offsets});
	}

	public long index_buffer_create(long size_indices, int format, byte[] data, boolean use_restart_indices,
			int creation_bits) {
		return (long) super.call("index_buffer_create",
				new java.lang.Object[]{java.lang.Long.valueOf(size_indices), java.lang.Integer.valueOf(format),
						(java.lang.Object) data, java.lang.Boolean.valueOf(use_restart_indices),
						java.lang.Integer.valueOf(creation_bits)});
	}

	public long index_array_create(long index_buffer, long index_offset, long index_count) {
		return (long) super.call("index_array_create", new java.lang.Object[]{java.lang.Long.valueOf(index_buffer),
				java.lang.Long.valueOf(index_offset), java.lang.Long.valueOf(index_count)});
	}

	public RDShaderSPIRV shader_compile_spirv_from_source(RDShaderSource shader_source, boolean allow_cache) {
		return (RDShaderSPIRV) super.call("shader_compile_spirv_from_source",
				new java.lang.Object[]{(java.lang.Object) shader_source, java.lang.Boolean.valueOf(allow_cache)});
	}

	public byte[] shader_compile_binary_from_spirv(RDShaderSPIRV spirv_data, String name) {
		return (byte[]) super.call("shader_compile_binary_from_spirv",
				new java.lang.Object[]{(java.lang.Object) spirv_data, (java.lang.Object) name});
	}

	public long shader_create_from_spirv(RDShaderSPIRV spirv_data, String name) {
		return (long) super.call("shader_create_from_spirv",
				new java.lang.Object[]{(java.lang.Object) spirv_data, (java.lang.Object) name});
	}

	public long shader_create_from_bytecode(byte[] binary_data, long placeholder_rid) {
		return (long) super.call("shader_create_from_bytecode",
				new java.lang.Object[]{(java.lang.Object) binary_data, java.lang.Long.valueOf(placeholder_rid)});
	}

	public long shader_create_placeholder() {
		return (long) super.call("shader_create_placeholder");
	}

	public java.math.BigInteger shader_get_vertex_input_attribute_mask(long shader) {
		return (java.math.BigInteger) super.call("shader_get_vertex_input_attribute_mask",
				new java.lang.Object[]{java.lang.Long.valueOf(shader)});
	}

	public long uniform_buffer_create(long size_bytes, byte[] data, int creation_bits) {
		return (long) super.call("uniform_buffer_create", new java.lang.Object[]{java.lang.Long.valueOf(size_bytes),
				(java.lang.Object) data, java.lang.Integer.valueOf(creation_bits)});
	}

	public long storage_buffer_create(long size_bytes, byte[] data, int usage, int creation_bits) {
		return (long) super.call("storage_buffer_create", new java.lang.Object[]{java.lang.Long.valueOf(size_bytes),
				(java.lang.Object) data, java.lang.Integer.valueOf(usage), java.lang.Integer.valueOf(creation_bits)});
	}

	public long texture_buffer_create(long size_bytes, int format, byte[] data) {
		return (long) super.call("texture_buffer_create", new java.lang.Object[]{java.lang.Long.valueOf(size_bytes),
				java.lang.Integer.valueOf(format), (java.lang.Object) data});
	}

	public long uniform_set_create(RDUniform[] uniforms, long shader, long shader_set) {
		return (long) super.call("uniform_set_create", new java.lang.Object[]{(java.lang.Object) uniforms,
				java.lang.Long.valueOf(shader), java.lang.Long.valueOf(shader_set)});
	}

	public boolean uniform_set_is_valid(long uniform_set) {
		return (boolean) super.call("uniform_set_is_valid",
				new java.lang.Object[]{java.lang.Long.valueOf(uniform_set)});
	}

	public int buffer_copy(long src_buffer, long dst_buffer, long src_offset, long dst_offset, long size) {
		return (int) super.call("buffer_copy",
				new java.lang.Object[]{java.lang.Long.valueOf(src_buffer), java.lang.Long.valueOf(dst_buffer),
						java.lang.Long.valueOf(src_offset), java.lang.Long.valueOf(dst_offset),
						java.lang.Long.valueOf(size)});
	}

	public int buffer_update(long buffer, long offset, long size_bytes, byte[] data) {
		return (int) super.call("buffer_update", new java.lang.Object[]{java.lang.Long.valueOf(buffer),
				java.lang.Long.valueOf(offset), java.lang.Long.valueOf(size_bytes), (java.lang.Object) data});
	}

	public int buffer_clear(long buffer, long offset, long size_bytes) {
		return (int) super.call("buffer_clear", new java.lang.Object[]{java.lang.Long.valueOf(buffer),
				java.lang.Long.valueOf(offset), java.lang.Long.valueOf(size_bytes)});
	}

	public byte[] buffer_get_data(long buffer, long offset_bytes, long size_bytes) {
		return (byte[]) super.call("buffer_get_data", new java.lang.Object[]{java.lang.Long.valueOf(buffer),
				java.lang.Long.valueOf(offset_bytes), java.lang.Long.valueOf(size_bytes)});
	}

	public int buffer_get_data_async(long buffer, Callable callback, long offset_bytes, long size_bytes) {
		return (int) super.call("buffer_get_data_async", new java.lang.Object[]{java.lang.Long.valueOf(buffer),
				(java.lang.Object) callback, java.lang.Long.valueOf(offset_bytes), java.lang.Long.valueOf(size_bytes)});
	}

	public java.math.BigInteger buffer_get_device_address(long buffer) {
		return (java.math.BigInteger) super.call("buffer_get_device_address",
				new java.lang.Object[]{java.lang.Long.valueOf(buffer)});
	}

	public long render_pipeline_create(long shader, long framebuffer_format, long vertex_format, int primitive,
			RDPipelineRasterizationState rasterization_state, RDPipelineMultisampleState multisample_state,
			RDPipelineDepthStencilState stencil_state, RDPipelineColorBlendState color_blend_state,
			int dynamic_state_flags, long for_render_pass,
			RDPipelineSpecializationConstant[] specialization_constants) {
		return (long) super.call("render_pipeline_create",
				new java.lang.Object[]{java.lang.Long.valueOf(shader), java.lang.Long.valueOf(framebuffer_format),
						java.lang.Long.valueOf(vertex_format), java.lang.Integer.valueOf(primitive),
						(java.lang.Object) rasterization_state, (java.lang.Object) multisample_state,
						(java.lang.Object) stencil_state, (java.lang.Object) color_blend_state,
						java.lang.Integer.valueOf(dynamic_state_flags), java.lang.Long.valueOf(for_render_pass),
						(java.lang.Object) specialization_constants});
	}

	public boolean render_pipeline_is_valid(long render_pipeline) {
		return (boolean) super.call("render_pipeline_is_valid",
				new java.lang.Object[]{java.lang.Long.valueOf(render_pipeline)});
	}

	public long compute_pipeline_create(long shader, RDPipelineSpecializationConstant[] specialization_constants) {
		return (long) super.call("compute_pipeline_create",
				new java.lang.Object[]{java.lang.Long.valueOf(shader), (java.lang.Object) specialization_constants});
	}

	public boolean compute_pipeline_is_valid(long compute_pipeline) {
		return (boolean) super.call("compute_pipeline_is_valid",
				new java.lang.Object[]{java.lang.Long.valueOf(compute_pipeline)});
	}

	public int screen_get_width(long screen) {
		return (int) super.call("screen_get_width", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public int screen_get_height(long screen) {
		return (int) super.call("screen_get_height", new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public long screen_get_framebuffer_format(long screen) {
		return (long) super.call("screen_get_framebuffer_format",
				new java.lang.Object[]{java.lang.Long.valueOf(screen)});
	}

	public long draw_list_begin_for_screen(long screen, Color clear_color) {
		return (long) super.call("draw_list_begin_for_screen",
				new java.lang.Object[]{java.lang.Long.valueOf(screen), (java.lang.Object) clear_color});
	}

	public long draw_list_begin(long framebuffer, int draw_flags, double[][] clear_color_values,
			double clear_depth_value, long clear_stencil_value, Rect2 region, long breadcrumb) {
		return (long) super.call("draw_list_begin",
				new java.lang.Object[]{java.lang.Long.valueOf(framebuffer), java.lang.Integer.valueOf(draw_flags),
						(java.lang.Object) clear_color_values, java.lang.Double.valueOf(clear_depth_value),
						java.lang.Long.valueOf(clear_stencil_value), (java.lang.Object) region,
						java.lang.Long.valueOf(breadcrumb)});
	}

	public long[] draw_list_begin_split(long framebuffer, long splits, int initial_color_action, int final_color_action,
			int initial_depth_action, int final_depth_action, double[][] clear_color_values, double clear_depth,
			long clear_stencil, Rect2 region, long[] storage_textures) {
		return (long[]) super.call("draw_list_begin_split",
				new java.lang.Object[]{java.lang.Long.valueOf(framebuffer), java.lang.Long.valueOf(splits),
						java.lang.Integer.valueOf(initial_color_action), java.lang.Integer.valueOf(final_color_action),
						java.lang.Integer.valueOf(initial_depth_action), java.lang.Integer.valueOf(final_depth_action),
						(java.lang.Object) clear_color_values, java.lang.Double.valueOf(clear_depth),
						java.lang.Long.valueOf(clear_stencil), (java.lang.Object) region,
						(java.lang.Object) storage_textures});
	}

	public void draw_list_set_blend_constants(long draw_list, Color color) {
		super.call("draw_list_set_blend_constants",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), (java.lang.Object) color});
	}

	public void draw_list_bind_render_pipeline(long draw_list, long render_pipeline) {
		super.call("draw_list_bind_render_pipeline",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), java.lang.Long.valueOf(render_pipeline)});
	}

	public void draw_list_bind_uniform_set(long draw_list, long uniform_set, long set_index) {
		super.call("draw_list_bind_uniform_set", new java.lang.Object[]{java.lang.Long.valueOf(draw_list),
				java.lang.Long.valueOf(uniform_set), java.lang.Long.valueOf(set_index)});
	}

	public void draw_list_bind_vertex_array(long draw_list, long vertex_array) {
		super.call("draw_list_bind_vertex_array",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), java.lang.Long.valueOf(vertex_array)});
	}

	public void draw_list_bind_vertex_buffers_format(long draw_list, long vertex_format, long vertex_count,
			long[] vertex_buffers, long[] offsets) {
		super.call("draw_list_bind_vertex_buffers_format",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), java.lang.Long.valueOf(vertex_format),
						java.lang.Long.valueOf(vertex_count), (java.lang.Object) vertex_buffers,
						(java.lang.Object) offsets});
	}

	public void draw_list_bind_index_array(long draw_list, long index_array) {
		super.call("draw_list_bind_index_array",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), java.lang.Long.valueOf(index_array)});
	}

	public void draw_list_set_push_constant(long draw_list, byte[] buffer, long size_bytes) {
		super.call("draw_list_set_push_constant", new java.lang.Object[]{java.lang.Long.valueOf(draw_list),
				(java.lang.Object) buffer, java.lang.Long.valueOf(size_bytes)});
	}

	public void draw_list_draw(long draw_list, boolean use_indices, long instances, long procedural_vertex_count) {
		super.call("draw_list_draw",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), java.lang.Boolean.valueOf(use_indices),
						java.lang.Long.valueOf(instances), java.lang.Long.valueOf(procedural_vertex_count)});
	}

	public void draw_list_draw_indirect(long draw_list, boolean use_indices, long buffer, long offset, long draw_count,
			long stride) {
		super.call("draw_list_draw_indirect",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), java.lang.Boolean.valueOf(use_indices),
						java.lang.Long.valueOf(buffer), java.lang.Long.valueOf(offset),
						java.lang.Long.valueOf(draw_count), java.lang.Long.valueOf(stride)});
	}

	public void draw_list_enable_scissor(long draw_list, Rect2 rect) {
		super.call("draw_list_enable_scissor",
				new java.lang.Object[]{java.lang.Long.valueOf(draw_list), (java.lang.Object) rect});
	}

	public void draw_list_disable_scissor(long draw_list) {
		super.call("draw_list_disable_scissor", new java.lang.Object[]{java.lang.Long.valueOf(draw_list)});
	}

	public long draw_list_switch_to_next_pass() {
		return (long) super.call("draw_list_switch_to_next_pass");
	}

	public long[] draw_list_switch_to_next_pass_split(long splits) {
		return (long[]) super.call("draw_list_switch_to_next_pass_split",
				new java.lang.Object[]{java.lang.Long.valueOf(splits)});
	}

	public void draw_list_end() {
		super.call("draw_list_end");
	}

	public long compute_list_begin() {
		return (long) super.call("compute_list_begin");
	}

	public void compute_list_bind_compute_pipeline(long compute_list, long compute_pipeline) {
		super.call("compute_list_bind_compute_pipeline",
				new java.lang.Object[]{java.lang.Long.valueOf(compute_list), java.lang.Long.valueOf(compute_pipeline)});
	}

	public void compute_list_set_push_constant(long compute_list, byte[] buffer, long size_bytes) {
		super.call("compute_list_set_push_constant", new java.lang.Object[]{java.lang.Long.valueOf(compute_list),
				(java.lang.Object) buffer, java.lang.Long.valueOf(size_bytes)});
	}

	public void compute_list_bind_uniform_set(long compute_list, long uniform_set, long set_index) {
		super.call("compute_list_bind_uniform_set", new java.lang.Object[]{java.lang.Long.valueOf(compute_list),
				java.lang.Long.valueOf(uniform_set), java.lang.Long.valueOf(set_index)});
	}

	public void compute_list_dispatch(long compute_list, long x_groups, long y_groups, long z_groups) {
		super.call("compute_list_dispatch", new java.lang.Object[]{java.lang.Long.valueOf(compute_list),
				java.lang.Long.valueOf(x_groups), java.lang.Long.valueOf(y_groups), java.lang.Long.valueOf(z_groups)});
	}

	public void compute_list_dispatch_indirect(long compute_list, long buffer, long offset) {
		super.call("compute_list_dispatch_indirect", new java.lang.Object[]{java.lang.Long.valueOf(compute_list),
				java.lang.Long.valueOf(buffer), java.lang.Long.valueOf(offset)});
	}

	public void compute_list_add_barrier(long compute_list) {
		super.call("compute_list_add_barrier", new java.lang.Object[]{java.lang.Long.valueOf(compute_list)});
	}

	public void compute_list_end() {
		super.call("compute_list_end");
	}

	public void free_rid(long rid) {
		super.call("free_rid", new java.lang.Object[]{java.lang.Long.valueOf(rid)});
	}

	public void capture_timestamp(String name) {
		super.call("capture_timestamp", new java.lang.Object[]{(java.lang.Object) name});
	}

	public java.math.BigInteger get_captured_timestamp_gpu_time(long index) {
		return (java.math.BigInteger) super.call("get_captured_timestamp_gpu_time",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public java.math.BigInteger get_captured_timestamp_cpu_time(long index) {
		return (java.math.BigInteger) super.call("get_captured_timestamp_cpu_time",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public String get_captured_timestamp_name(long index) {
		return (String) super.call("get_captured_timestamp_name",
				new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public boolean has_feature(int feature) {
		return (boolean) super.call("has_feature", new java.lang.Object[]{java.lang.Integer.valueOf(feature)});
	}

	public java.math.BigInteger limit_get(int limit) {
		return (java.math.BigInteger) super.call("limit_get", new java.lang.Object[]{java.lang.Integer.valueOf(limit)});
	}

	public void submit() {
		super.call("submit");
	}

	public void sync() {
		super.call("sync");
	}

	public void barrier(int from, int to) {
		super.call("barrier", new java.lang.Object[]{java.lang.Integer.valueOf(from), java.lang.Integer.valueOf(to)});
	}

	public void full_barrier() {
		super.call("full_barrier");
	}

	public RenderingDevice create_local_device() {
		return (RenderingDevice) super.call("create_local_device");
	}

	public void set_resource_name(long id, String name) {
		super.call("set_resource_name", new java.lang.Object[]{java.lang.Long.valueOf(id), (java.lang.Object) name});
	}

	public void draw_command_begin_label(String name, Color color) {
		super.call("draw_command_begin_label",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) color});
	}

	public void draw_command_insert_label(String name, Color color) {
		super.call("draw_command_insert_label",
				new java.lang.Object[]{(java.lang.Object) name, (java.lang.Object) color});
	}

	public void draw_command_end_label() {
		super.call("draw_command_end_label");
	}

	public java.math.BigInteger get_memory_usage(int type) {
		return (java.math.BigInteger) super.call("get_memory_usage",
				new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public java.math.BigInteger get_driver_resource(int resource, long rid, long index) {
		return (java.math.BigInteger) super.call("get_driver_resource", new java.lang.Object[]{
				java.lang.Integer.valueOf(resource), java.lang.Long.valueOf(rid), java.lang.Long.valueOf(index)});
	}

	public String get_tracked_object_name(long type_index) {
		return (String) super.call("get_tracked_object_name",
				new java.lang.Object[]{java.lang.Long.valueOf(type_index)});
	}

	public java.math.BigInteger get_driver_memory_by_object_type(long type) {
		return (java.math.BigInteger) super.call("get_driver_memory_by_object_type",
				new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public java.math.BigInteger get_driver_allocs_by_object_type(long type) {
		return (java.math.BigInteger) super.call("get_driver_allocs_by_object_type",
				new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public java.math.BigInteger get_device_memory_by_object_type(long type) {
		return (java.math.BigInteger) super.call("get_device_memory_by_object_type",
				new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public java.math.BigInteger get_device_allocs_by_object_type(long type) {
		return (java.math.BigInteger) super.call("get_device_allocs_by_object_type",
				new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}
}
