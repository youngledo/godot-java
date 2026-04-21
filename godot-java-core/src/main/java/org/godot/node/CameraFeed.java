package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotArray;
import org.godot.collection.GodotDictionary;
import org.godot.core.RefCounted;
import org.godot.math.Transform2D;

public class CameraFeed extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_position", 611162623L), java.util.Map.entry("get_position", 2711679033L),
			java.util.Map.entry("set_format", 31872775L), java.util.Map.entry("is_active", 36873697L),
			java.util.Map.entry("set_external", 3937882851L), java.util.Map.entry("set_active", 2586408642L),
			java.util.Map.entry("set_ycbcr_image", 532598488L), java.util.Map.entry("get_id", 3905245786L),
			java.util.Map.entry("set_rgb_image", 532598488L), java.util.Map.entry("get_transform", 3814499831L),
			java.util.Map.entry("set_ycbcr_images", 1986484629L), java.util.Map.entry("set_name", 83702148L),
			java.util.Map.entry("get_name", 201670096L), java.util.Map.entry("set_transform", 2761652528L),
			java.util.Map.entry("get_texture_tex_id", 1135699418L), java.util.Map.entry("get_formats", 3995934104L),
			java.util.Map.entry("get_datatype", 1477782850L));

	CameraFeed(MemorySegment nativePointer) {
		super(nativePointer);
	}

	CameraFeed(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_active() {
		return (boolean) super.call("is_active");
	}

	public void set_ycbcr_images(Image y_image, Image cbcr_image) {
		super.call("set_ycbcr_images",
				new java.lang.Object[]{(java.lang.Object) y_image, (java.lang.Object) cbcr_image});
	}

	public void set_external(long width, long height) {
		super.call("set_external",
				new java.lang.Object[]{java.lang.Long.valueOf(width), java.lang.Long.valueOf(height)});
	}

	public java.math.BigInteger get_texture_tex_id(int feed_image_type) {
		return (java.math.BigInteger) super.call("get_texture_tex_id",
				new java.lang.Object[]{java.lang.Integer.valueOf(feed_image_type)});
	}

	public boolean set_format(long index, GodotDictionary parameters) {
		return (boolean) super.call("set_format",
				new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) parameters});
	}

	public boolean isFeed_is_active() {
		return (boolean) super.call("is_active", new java.lang.Object[0]);
	}

	public void setFeed_is_active(boolean value) {
		super.call("set_active", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Transform2D getFeed_transform() {
		return (Transform2D) super.call("get_transform", new java.lang.Object[0]);
	}

	public void setFeed_transform(Transform2D value) {
		super.call("set_transform", new java.lang.Object[]{(java.lang.Object) value});
	}

	public GodotArray getFormats() {
		return (GodotArray) super.call("get_formats", new java.lang.Object[0]);
	}

	public void setFormats(GodotArray value) {
		super.call("set_formats", new java.lang.Object[]{(java.lang.Object) value});
	}
}
