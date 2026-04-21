package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.math.Vector2;

public class PortableCompressedTexture2D extends Texture2D {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_format", 3847873762L),
			java.util.Map.entry("is_keeping_compressed_buffer", 36873697L),
			java.util.Map.entry("set_keep_all_compressed_buffers", 2586408642L),
			java.util.Map.entry("create_from_image", 3679243433L),
			java.util.Map.entry("get_size_override", 3341600327L),
			java.util.Map.entry("is_keeping_all_compressed_buffers", 2240911060L),
			java.util.Map.entry("set_size_override", 743155724L),
			java.util.Map.entry("get_compression_mode", 3265612739L),
			java.util.Map.entry("set_keep_compressed_buffer", 2586408642L),
			java.util.Map.entry("set_basisu_compressor_params", 1602489585L));

	PortableCompressedTexture2D(MemorySegment nativePointer) {
		super(nativePointer);
	}

	PortableCompressedTexture2D(long nativePointer) {
		super(nativePointer);
	}

	public void create_from_image(Image image, int compression_mode, boolean normal_map, double lossy_quality) {
		super.call("create_from_image",
				new java.lang.Object[]{(java.lang.Object) image, java.lang.Integer.valueOf(compression_mode),
						java.lang.Boolean.valueOf(normal_map), java.lang.Double.valueOf(lossy_quality)});
	}

	public boolean is_keeping_compressed_buffer() {
		return (boolean) super.call("is_keeping_compressed_buffer");
	}

	public void set_basisu_compressor_params(long uastc_level, double rdo_quality_loss) {
		super.call("set_basisu_compressor_params", new java.lang.Object[]{java.lang.Long.valueOf(uastc_level),
				java.lang.Double.valueOf(rdo_quality_loss)});
	}

	public boolean is_keeping_all_compressed_buffers() {
		return (boolean) super.call("is_keeping_all_compressed_buffers");
	}

	public Vector2 getSize_override() {
		return (Vector2) super.call("get_size_override", new java.lang.Object[0]);
	}

	public void setSize_override(Vector2 value) {
		super.call("set_size_override", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isKeep_compressed_buffer() {
		return (boolean) super.call("is_keeping_compressed_buffer", new java.lang.Object[0]);
	}

	public void setKeep_compressed_buffer(boolean value) {
		super.call("set_keep_compressed_buffer", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
