package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeTextureParameter extends VisualShaderNodeParameter {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_texture_type", 2227296876L), java.util.Map.entry("get_texture_type", 367922070L),
			java.util.Map.entry("set_texture_source", 1212687372L),
			java.util.Map.entry("get_texture_repeat", 1690132794L),
			java.util.Map.entry("get_texture_filter", 4184490817L),
			java.util.Map.entry("set_texture_filter", 2147684752L),
			java.util.Map.entry("set_texture_repeat", 2036143070L),
			java.util.Map.entry("get_texture_source", 2039092262L),
			java.util.Map.entry("get_color_default", 3837060134L),
			java.util.Map.entry("set_color_default", 4217624432L));

	VisualShaderNodeTextureParameter(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeTextureParameter(long nativePointer) {
		super(nativePointer);
	}

	public long getTexture_type() {
		return (long) super.call("get_texture_type", new java.lang.Object[0]);
	}

	public void setTexture_type(long value) {
		super.call("set_texture_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getColor_default() {
		return (long) super.call("get_color_default", new java.lang.Object[0]);
	}

	public void setColor_default(long value) {
		super.call("set_color_default", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_filter() {
		return (long) super.call("get_texture_filter", new java.lang.Object[0]);
	}

	public void setTexture_filter(long value) {
		super.call("set_texture_filter", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_repeat() {
		return (long) super.call("get_texture_repeat", new java.lang.Object[0]);
	}

	public void setTexture_repeat(long value) {
		super.call("set_texture_repeat", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getTexture_source() {
		return (long) super.call("get_texture_source", new java.lang.Object[0]);
	}

	public void setTexture_source(long value) {
		super.call("set_texture_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
