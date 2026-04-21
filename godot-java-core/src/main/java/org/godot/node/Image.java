package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Color;
import org.godot.math.Rect2i;
import org.godot.math.Vector2i;

public class Image extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("load_png_from_buffer", 680677267L),
			java.util.Map.entry("save_webp_to_buffer", 1214628238L),
			java.util.Map.entry("get_mipmap_count", 3905245786L), java.util.Map.entry("normal_map_to_xy", 3218959716L),
			java.util.Map.entry("convert", 2120693146L), java.util.Map.entry("copy_from", 532598488L),
			java.util.Map.entry("get_height", 3905245786L), java.util.Map.entry("get_width", 3905245786L),
			java.util.Map.entry("decompress", 166280745L), java.util.Map.entry("flip_y", 3218959716L),
			java.util.Map.entry("flip_x", 3218959716L), java.util.Map.entry("create", 986942177L),
			java.util.Map.entry("create_from_data", 299398494L), java.util.Map.entry("get_pixelv", 1532707496L),
			java.util.Map.entry("get_size", 3690982128L), java.util.Map.entry("shrink_x2", 3218959716L),
			java.util.Map.entry("save_png", 2113323047L), java.util.Map.entry("load_exr_from_buffer", 680677267L),
			java.util.Map.entry("blend_rect_mask", 3383581145L), java.util.Map.entry("save_exr_to_buffer", 3178917920L),
			java.util.Map.entry("load_bmp_from_buffer", 680677267L), java.util.Map.entry("compress", 2975424957L),
			java.util.Map.entry("load_jpg_from_buffer", 680677267L), java.util.Map.entry("save_exr", 3108122999L),
			java.util.Map.entry("is_invisible", 36873697L), java.util.Map.entry("premultiply_alpha", 3218959716L),
			java.util.Map.entry("fill", 2920490490L), java.util.Map.entry("load_ktx_from_buffer", 680677267L),
			java.util.Map.entry("get_mipmap_offset", 923996154L), java.util.Map.entry("detect_alpha", 2030116505L),
			java.util.Map.entry("get_region", 2601441065L), java.util.Map.entry("set_pixel", 3733378741L),
			java.util.Map.entry("blit_rect_mask", 3383581145L), java.util.Map.entry("get_data", 2362200018L),
			java.util.Map.entry("set_pixelv", 287851464L), java.util.Map.entry("crop", 3937882851L),
			java.util.Map.entry("clear_mipmaps", 3218959716L), java.util.Map.entry("set_data", 2740482212L),
			java.util.Map.entry("compute_image_metrics", 3080961247L),
			java.util.Map.entry("load_svg_from_buffer", 311853421L), java.util.Map.entry("blend_rect", 2903928755L),
			java.util.Map.entry("load_from_file", 736337515L), java.util.Map.entry("save_jpg_to_buffer", 592235273L),
			java.util.Map.entry("save_dds", 2113323047L), java.util.Map.entry("get_data_size", 3905245786L),
			java.util.Map.entry("generate_mipmaps", 1633102583L), java.util.Map.entry("linear_to_srgb", 3218959716L),
			java.util.Map.entry("compress_from_channels", 4212890953L), java.util.Map.entry("rgbe_to_srgb", 564927088L),
			java.util.Map.entry("resize_to_po2", 4189212329L), java.util.Map.entry("load", 166001499L),
			java.util.Map.entry("is_compressed", 36873697L), java.util.Map.entry("rotate_180", 3218959716L),
			java.util.Map.entry("bump_map_to_normal_map", 3423495036L), java.util.Map.entry("fill_rect", 514693913L),
			java.util.Map.entry("has_mipmaps", 36873697L), java.util.Map.entry("is_empty", 36873697L),
			java.util.Map.entry("detect_used_channels", 2703139984L), java.util.Map.entry("get_format", 3847873762L),
			java.util.Map.entry("create_empty", 986942177L), java.util.Map.entry("save_jpg", 2800019068L),
			java.util.Map.entry("save_webp", 2781156876L), java.util.Map.entry("load_tga_from_buffer", 680677267L),
			java.util.Map.entry("load_dds_from_buffer", 680677267L),
			java.util.Map.entry("fix_alpha_edges", 3218959716L),
			java.util.Map.entry("load_svg_from_string", 3254053600L), java.util.Map.entry("blit_rect", 2903928755L),
			java.util.Map.entry("save_png_to_buffer", 2362200018L),
			java.util.Map.entry("load_webp_from_buffer", 680677267L), java.util.Map.entry("adjust_bcs", 2385087082L),
			java.util.Map.entry("save_dds_to_buffer", 2362200018L), java.util.Map.entry("get_pixel", 2165839948L),
			java.util.Map.entry("srgb_to_linear", 3218959716L), java.util.Map.entry("resize", 994498151L),
			java.util.Map.entry("get_used_rect", 410525958L), java.util.Map.entry("rotate_90", 1901204267L));

	Image(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Image(long nativePointer) {
		super(nativePointer);
	}

	public boolean has_mipmaps() {
		return (boolean) super.call("has_mipmaps");
	}

	public void convert(int format) {
		super.call("convert", new java.lang.Object[]{java.lang.Integer.valueOf(format)});
	}

	public long get_mipmap_offset(long mipmap) {
		return (long) super.call("get_mipmap_offset", new java.lang.Object[]{java.lang.Long.valueOf(mipmap)});
	}

	public void resize_to_po2(boolean square, int interpolation) {
		super.call("resize_to_po2",
				new java.lang.Object[]{java.lang.Boolean.valueOf(square), java.lang.Integer.valueOf(interpolation)});
	}

	public void resize(long width, long height, int interpolation) {
		super.call("resize", new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
				java.lang.Integer.valueOf(interpolation)});
	}

	public void shrink_x2() {
		super.call("shrink_x2");
	}

	public void crop(long width, long height) {
		super.call("crop", new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height)});
	}

	public void flip_x() {
		super.call("flip_x");
	}

	public void flip_y() {
		super.call("flip_y");
	}

	public int generate_mipmaps(boolean renormalize) {
		return (int) super.call("generate_mipmaps", new java.lang.Object[]{java.lang.Boolean.valueOf(renormalize)});
	}

	public void clear_mipmaps() {
		super.call("clear_mipmaps");
	}

	public Image create(long width, long height, boolean use_mipmaps, int format) {
		return (Image) super.call("create",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Boolean.valueOf(use_mipmaps), java.lang.Integer.valueOf(format)});
	}

	public Image create_empty(long width, long height, boolean use_mipmaps, int format) {
		return (Image) super.call("create_empty",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Boolean.valueOf(use_mipmaps), java.lang.Integer.valueOf(format)});
	}

	public Image create_from_data(long width, long height, boolean use_mipmaps, int format, byte[] data) {
		return (Image) super.call("create_from_data",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
						java.lang.Boolean.valueOf(use_mipmaps), java.lang.Integer.valueOf(format),
						(java.lang.Object) data});
	}

	public void set_data(long width, long height, boolean use_mipmaps, int format, byte[] data) {
		super.call("set_data", new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height),
				java.lang.Boolean.valueOf(use_mipmaps), java.lang.Integer.valueOf(format), (java.lang.Object) data});
	}

	public boolean is_empty() {
		return (boolean) super.call("is_empty");
	}

	public int load(String path) {
		return (int) super.call("load", new java.lang.Object[]{(java.lang.Object) path});
	}

	public Image load_from_file(String path) {
		return (Image) super.call("load_from_file", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int save_png(String path) {
		return (int) super.call("save_png", new java.lang.Object[]{(java.lang.Object) path});
	}

	public byte[] save_png_to_buffer() {
		return (byte[]) super.call("save_png_to_buffer");
	}

	public int save_jpg(String path, double quality) {
		return (int) super.call("save_jpg",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Double.valueOf(quality)});
	}

	public byte[] save_jpg_to_buffer(double quality) {
		return (byte[]) super.call("save_jpg_to_buffer", new java.lang.Object[]{java.lang.Double.valueOf(quality)});
	}

	public int save_exr(String path, boolean grayscale) {
		return (int) super.call("save_exr",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Boolean.valueOf(grayscale)});
	}

	public byte[] save_exr_to_buffer(boolean grayscale) {
		return (byte[]) super.call("save_exr_to_buffer", new java.lang.Object[]{java.lang.Boolean.valueOf(grayscale)});
	}

	public int save_dds(String path) {
		return (int) super.call("save_dds", new java.lang.Object[]{(java.lang.Object) path});
	}

	public byte[] save_dds_to_buffer() {
		return (byte[]) super.call("save_dds_to_buffer");
	}

	public int save_webp(String path, boolean lossy, double quality) {
		return (int) super.call("save_webp", new java.lang.Object[]{(java.lang.Object) path,
				java.lang.Boolean.valueOf(lossy), java.lang.Double.valueOf(quality)});
	}

	public byte[] save_webp_to_buffer(boolean lossy, double quality) {
		return (byte[]) super.call("save_webp_to_buffer",
				new java.lang.Object[]{java.lang.Boolean.valueOf(lossy), java.lang.Double.valueOf(quality)});
	}

	public int detect_alpha() {
		return (int) super.call("detect_alpha");
	}

	public boolean is_invisible() {
		return (boolean) super.call("is_invisible");
	}

	public int detect_used_channels(int source) {
		return (int) super.call("detect_used_channels", new java.lang.Object[]{java.lang.Integer.valueOf(source)});
	}

	public int compress(int mode, int source, int astc_format) {
		return (int) super.call("compress", new java.lang.Object[]{java.lang.Integer.valueOf(mode),
				java.lang.Integer.valueOf(source), java.lang.Integer.valueOf(astc_format)});
	}

	public int compress_from_channels(int mode, int channels, int astc_format) {
		return (int) super.call("compress_from_channels", new java.lang.Object[]{java.lang.Integer.valueOf(mode),
				java.lang.Integer.valueOf(channels), java.lang.Integer.valueOf(astc_format)});
	}

	public int decompress() {
		return (int) super.call("decompress");
	}

	public boolean is_compressed() {
		return (boolean) super.call("is_compressed");
	}

	public void rotate_90(int direction) {
		super.call("rotate_90", new java.lang.Object[]{java.lang.Integer.valueOf(direction)});
	}

	public void rotate_180() {
		super.call("rotate_180");
	}

	public void fix_alpha_edges() {
		super.call("fix_alpha_edges");
	}

	public void premultiply_alpha() {
		super.call("premultiply_alpha");
	}

	public void srgb_to_linear() {
		super.call("srgb_to_linear");
	}

	public void linear_to_srgb() {
		super.call("linear_to_srgb");
	}

	public void normal_map_to_xy() {
		super.call("normal_map_to_xy");
	}

	public Image rgbe_to_srgb() {
		return (Image) super.call("rgbe_to_srgb");
	}

	public void bump_map_to_normal_map(double bump_scale) {
		super.call("bump_map_to_normal_map", new java.lang.Object[]{java.lang.Double.valueOf(bump_scale)});
	}

	public GodotDictionary compute_image_metrics(Image compared_image, boolean use_luma) {
		return (GodotDictionary) super.call("compute_image_metrics",
				new java.lang.Object[]{(java.lang.Object) compared_image, java.lang.Boolean.valueOf(use_luma)});
	}

	public void blit_rect(Image src, Rect2i src_rect, Vector2i dst) {
		super.call("blit_rect",
				new java.lang.Object[]{(java.lang.Object) src, (java.lang.Object) src_rect, (java.lang.Object) dst});
	}

	public void blit_rect_mask(Image src, Image mask, Rect2i src_rect, Vector2i dst) {
		super.call("blit_rect_mask", new java.lang.Object[]{(java.lang.Object) src, (java.lang.Object) mask,
				(java.lang.Object) src_rect, (java.lang.Object) dst});
	}

	public void blend_rect(Image src, Rect2i src_rect, Vector2i dst) {
		super.call("blend_rect",
				new java.lang.Object[]{(java.lang.Object) src, (java.lang.Object) src_rect, (java.lang.Object) dst});
	}

	public void blend_rect_mask(Image src, Image mask, Rect2i src_rect, Vector2i dst) {
		super.call("blend_rect_mask", new java.lang.Object[]{(java.lang.Object) src, (java.lang.Object) mask,
				(java.lang.Object) src_rect, (java.lang.Object) dst});
	}

	public void fill(Color color) {
		super.call("fill", new java.lang.Object[]{(java.lang.Object) color});
	}

	public void fill_rect(Rect2i rect, Color color) {
		super.call("fill_rect", new java.lang.Object[]{(java.lang.Object) rect, (java.lang.Object) color});
	}

	public Image get_region(Rect2i region) {
		return (Image) super.call("get_region", new java.lang.Object[]{(java.lang.Object) region});
	}

	public void copy_from(Image src) {
		super.call("copy_from", new java.lang.Object[]{(java.lang.Object) src});
	}

	public Color get_pixelv(Vector2i point) {
		return (Color) super.call("get_pixelv", new java.lang.Object[]{(java.lang.Object) point});
	}

	public Color get_pixel(long x, long y) {
		return (Color) super.call("get_pixel",
				new java.lang.Object[]{java.lang.Long.valueOf(x), java.lang.Long.valueOf(y)});
	}

	public void set_pixelv(Vector2i point, Color color) {
		super.call("set_pixelv", new java.lang.Object[]{(java.lang.Object) point, (java.lang.Object) color});
	}

	public void set_pixel(long x, long y, Color color) {
		super.call("set_pixel",
				new java.lang.Object[]{java.lang.Long.valueOf(x), java.lang.Long.valueOf(y), (java.lang.Object) color});
	}

	public void adjust_bcs(double brightness, double contrast, double saturation) {
		super.call("adjust_bcs", new java.lang.Object[]{java.lang.Double.valueOf(brightness),
				java.lang.Double.valueOf(contrast), java.lang.Double.valueOf(saturation)});
	}

	public int load_png_from_buffer(byte[] buffer) {
		return (int) super.call("load_png_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_jpg_from_buffer(byte[] buffer) {
		return (int) super.call("load_jpg_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_webp_from_buffer(byte[] buffer) {
		return (int) super.call("load_webp_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_tga_from_buffer(byte[] buffer) {
		return (int) super.call("load_tga_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_bmp_from_buffer(byte[] buffer) {
		return (int) super.call("load_bmp_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_ktx_from_buffer(byte[] buffer) {
		return (int) super.call("load_ktx_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_dds_from_buffer(byte[] buffer) {
		return (int) super.call("load_dds_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_exr_from_buffer(byte[] buffer) {
		return (int) super.call("load_exr_from_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public int load_svg_from_buffer(byte[] buffer, double scale) {
		return (int) super.call("load_svg_from_buffer",
				new java.lang.Object[]{(java.lang.Object) buffer, java.lang.Double.valueOf(scale)});
	}

	public int load_svg_from_string(String svg_str, double scale) {
		return (int) super.call("load_svg_from_string",
				new java.lang.Object[]{(java.lang.Object) svg_str, java.lang.Double.valueOf(scale)});
	}

	public GodotDictionary getData() {
		return (GodotDictionary) super.call("_get_data", new java.lang.Object[0]);
	}

	public void setData(GodotDictionary value) {
		super.call("_set_data", new java.lang.Object[]{(java.lang.Object) value});
	}
}
