package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2i;

public class RenderSceneBuffersRD extends RenderSceneBuffers {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_texture_samples", 407791724L),
			java.util.Map.entry("get_render_target", 2944877500L),
			java.util.Map.entry("get_texture_slice_view", 682451778L),
			java.util.Map.entry("get_fsr_sharpness", 1740695150L), java.util.Map.entry("get_use_debanding", 36873697L),
			java.util.Map.entry("get_depth_layer", 3087988589L),
			java.util.Map.entry("create_texture_from_format", 3344669382L),
			java.util.Map.entry("get_texture_slice", 588440706L), java.util.Map.entry("get_target_size", 3690982128L),
			java.util.Map.entry("clear_context", 3304788590L), java.util.Map.entry("get_velocity_texture", 3050822880L),
			java.util.Map.entry("get_msaa_3d", 3109158617L), java.util.Map.entry("get_depth_texture", 3050822880L),
			java.util.Map.entry("get_internal_size", 3690982128L),
			java.util.Map.entry("get_texture_format", 371461758L), java.util.Map.entry("create_texture", 2950875024L),
			java.util.Map.entry("get_view_count", 3905245786L), java.util.Map.entry("get_velocity_layer", 3087988589L),
			java.util.Map.entry("get_texture_slice_size", 2617625368L),
			java.util.Map.entry("get_color_layer", 3087988589L), java.util.Map.entry("has_texture", 471820014L),
			java.util.Map.entry("get_screen_space_aa", 641513172L), java.util.Map.entry("get_use_taa", 36873697L),
			java.util.Map.entry("get_scaling_3d_mode", 976778074L),
			java.util.Map.entry("create_texture_view", 283055834L),
			java.util.Map.entry("get_color_texture", 3050822880L), java.util.Map.entry("get_texture", 750006389L));

	RenderSceneBuffersRD(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RenderSceneBuffersRD(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_texture(String context, String name) {
		return (boolean) super.call("has_texture",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name});
	}

	public long create_texture(String context, String name, int data_format, long usage_bits, int texture_samples,
			Vector2i size, long layers, long mipmaps, boolean unique, boolean discardable) {
		return (long) super.call("create_texture",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name,
						java.lang.Integer.valueOf(data_format), java.lang.Long.valueOf(usage_bits),
						java.lang.Integer.valueOf(texture_samples), (java.lang.Object) size,
						java.lang.Long.valueOf(layers), java.lang.Long.valueOf(mipmaps),
						java.lang.Boolean.valueOf(unique), java.lang.Boolean.valueOf(discardable)});
	}

	public long create_texture_from_format(String context, String name, RDTextureFormat format, RDTextureView view,
			boolean unique) {
		return (long) super.call("create_texture_from_format",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name, (java.lang.Object) format,
						(java.lang.Object) view, java.lang.Boolean.valueOf(unique)});
	}

	public long create_texture_view(String context, String name, String view_name, RDTextureView view) {
		return (long) super.call("create_texture_view", new java.lang.Object[]{(java.lang.Object) context,
				(java.lang.Object) name, (java.lang.Object) view_name, (java.lang.Object) view});
	}

	public long get_texture(String context, String name) {
		return (long) super.call("get_texture",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name});
	}

	public RDTextureFormat get_texture_format(String context, String name) {
		return (RDTextureFormat) super.call("get_texture_format",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name});
	}

	public long get_texture_slice(String context, String name, long layer, long mipmap, long layers, long mipmaps) {
		return (long) super.call("get_texture_slice",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name,
						java.lang.Long.valueOf(layer), java.lang.Long.valueOf(mipmap), java.lang.Long.valueOf(layers),
						java.lang.Long.valueOf(mipmaps)});
	}

	public long get_texture_slice_view(String context, String name, long layer, long mipmap, long layers, long mipmaps,
			RDTextureView view) {
		return (long) super.call("get_texture_slice_view",
				new java.lang.Object[]{(java.lang.Object) context, (java.lang.Object) name,
						java.lang.Long.valueOf(layer), java.lang.Long.valueOf(mipmap), java.lang.Long.valueOf(layers),
						java.lang.Long.valueOf(mipmaps), (java.lang.Object) view});
	}

	public Vector2i get_texture_slice_size(String context, String name, long mipmap) {
		return (Vector2i) super.call("get_texture_slice_size", new java.lang.Object[]{(java.lang.Object) context,
				(java.lang.Object) name, java.lang.Long.valueOf(mipmap)});
	}

	public void clear_context(String context) {
		super.call("clear_context", new java.lang.Object[]{(java.lang.Object) context});
	}

	public long get_color_texture(boolean msaa) {
		return (long) super.call("get_color_texture", new java.lang.Object[]{java.lang.Boolean.valueOf(msaa)});
	}

	public long get_color_layer(long layer, boolean msaa) {
		return (long) super.call("get_color_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(msaa)});
	}

	public long get_depth_texture(boolean msaa) {
		return (long) super.call("get_depth_texture", new java.lang.Object[]{java.lang.Boolean.valueOf(msaa)});
	}

	public long get_depth_layer(long layer, boolean msaa) {
		return (long) super.call("get_depth_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(msaa)});
	}

	public long get_velocity_texture(boolean msaa) {
		return (long) super.call("get_velocity_texture", new java.lang.Object[]{java.lang.Boolean.valueOf(msaa)});
	}

	public long get_velocity_layer(long layer, boolean msaa) {
		return (long) super.call("get_velocity_layer",
				new java.lang.Object[]{java.lang.Long.valueOf(layer), java.lang.Boolean.valueOf(msaa)});
	}
}
