package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class VisualShaderNodeTexture extends VisualShaderNode {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_source", 2896297444L), java.util.Map.entry("set_texture_type", 986314081L),
			java.util.Map.entry("get_texture_type", 3290430153L), java.util.Map.entry("set_texture", 4051416890L),
			java.util.Map.entry("set_source", 905262939L), java.util.Map.entry("get_texture", 3635182373L));

	VisualShaderNodeTexture(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShaderNodeTexture(long nativePointer) {
		super(nativePointer);
	}

	public long getSource() {
		return (long) super.call("get_source", new java.lang.Object[0]);
	}

	public void setSource(long value) {
		super.call("set_source", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Texture2D getTexture() {
		return (Texture2D) super.call("get_texture", new java.lang.Object[0]);
	}

	public void setTexture(Texture2D value) {
		super.call("set_texture", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getTexture_type() {
		return (long) super.call("get_texture_type", new java.lang.Object[0]);
	}

	public void setTexture_type(long value) {
		super.call("set_texture_type", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
