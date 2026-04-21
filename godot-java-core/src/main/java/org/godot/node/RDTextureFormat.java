package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDTextureFormat extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_format", 565531219L), java.util.Map.entry("get_mipmaps", 3905245786L),
			java.util.Map.entry("set_texture_type", 652343381L), java.util.Map.entry("get_usage_bits", 1313398998L),
			java.util.Map.entry("set_samples", 3774171498L), java.util.Map.entry("get_format", 2235804183L),
			java.util.Map.entry("get_texture_type", 4036357416L), java.util.Map.entry("get_depth", 3905245786L),
			java.util.Map.entry("set_width", 1286410249L), java.util.Map.entry("add_shareable_format", 565531219L),
			java.util.Map.entry("set_height", 1286410249L), java.util.Map.entry("remove_shareable_format", 565531219L),
			java.util.Map.entry("get_height", 3905245786L), java.util.Map.entry("set_is_discardable", 2586408642L),
			java.util.Map.entry("get_is_resolve_buffer", 36873697L),
			java.util.Map.entry("set_is_resolve_buffer", 2586408642L), java.util.Map.entry("get_width", 3905245786L),
			java.util.Map.entry("set_depth", 1286410249L), java.util.Map.entry("get_array_layers", 3905245786L),
			java.util.Map.entry("set_usage_bits", 245642367L), java.util.Map.entry("get_samples", 407791724L),
			java.util.Map.entry("set_mipmaps", 1286410249L), java.util.Map.entry("get_is_discardable", 36873697L),
			java.util.Map.entry("set_array_layers", 1286410249L));

	RDTextureFormat(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDTextureFormat(long nativePointer) {
		super(nativePointer);
	}

	public void add_shareable_format(int format) {
		super.call("add_shareable_format", new java.lang.Object[]{java.lang.Integer.valueOf(format)});
	}

	public void remove_shareable_format(int format) {
		super.call("remove_shareable_format", new java.lang.Object[]{java.lang.Integer.valueOf(format)});
	}

	public long getFormat() {
		return (long) super.call("get_format", new java.lang.Object[0]);
	}

	public void setFormat(long value) {
		super.call("set_format", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getWidth() {
		return (long) super.call("get_width", new java.lang.Object[0]);
	}

	public void setWidth(long value) {
		super.call("set_width", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getHeight() {
		return (long) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(long value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getDepth() {
		return (long) super.call("get_depth", new java.lang.Object[0]);
	}

	public void setDepth(long value) {
		super.call("set_depth", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getArray_layers() {
		return (long) super.call("get_array_layers", new java.lang.Object[0]);
	}

	public void setArray_layers(long value) {
		super.call("set_array_layers", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getMipmaps() {
		return (long) super.call("get_mipmaps", new java.lang.Object[0]);
	}

	public void setMipmaps(long value) {
		super.call("set_mipmaps", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_type() {
		return (long) super.call("get_texture_type", new java.lang.Object[0]);
	}

	public void setTexture_type(long value) {
		super.call("set_texture_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getSamples() {
		return (long) super.call("get_samples", new java.lang.Object[0]);
	}

	public void setSamples(long value) {
		super.call("set_samples", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getUsage_bits() {
		return (long) super.call("get_usage_bits", new java.lang.Object[0]);
	}

	public void setUsage_bits(long value) {
		super.call("set_usage_bits", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean getIs_resolve_buffer() {
		return (boolean) super.call("get_is_resolve_buffer", new java.lang.Object[0]);
	}

	public void setIs_resolve_buffer(boolean value) {
		super.call("set_is_resolve_buffer", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean getIs_discardable() {
		return (boolean) super.call("get_is_discardable", new java.lang.Object[0]);
	}

	public void setIs_discardable(boolean value) {
		super.call("set_is_discardable", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
