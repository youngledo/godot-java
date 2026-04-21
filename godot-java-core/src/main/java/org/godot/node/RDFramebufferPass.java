package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class RDFramebufferPass extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_preserve_attachments", 1930428628L),
			java.util.Map.entry("set_resolve_attachments", 3614634198L),
			java.util.Map.entry("set_preserve_attachments", 3614634198L),
			java.util.Map.entry("get_color_attachments", 1930428628L),
			java.util.Map.entry("set_input_attachments", 3614634198L),
			java.util.Map.entry("get_depth_attachment", 3905245786L),
			java.util.Map.entry("get_resolve_attachments", 1930428628L),
			java.util.Map.entry("set_color_attachments", 3614634198L),
			java.util.Map.entry("get_input_attachments", 1930428628L),
			java.util.Map.entry("set_depth_attachment", 1286410249L));

	RDFramebufferPass(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDFramebufferPass(long nativePointer) {
		super(nativePointer);
	}

	public int[] getColor_attachments() {
		return (int[]) super.call("get_color_attachments", new java.lang.Object[0]);
	}

	public void setColor_attachments(int[] value) {
		super.call("set_color_attachments", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getInput_attachments() {
		return (int[]) super.call("get_input_attachments", new java.lang.Object[0]);
	}

	public void setInput_attachments(int[] value) {
		super.call("set_input_attachments", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getResolve_attachments() {
		return (int[]) super.call("get_resolve_attachments", new java.lang.Object[0]);
	}

	public void setResolve_attachments(int[] value) {
		super.call("set_resolve_attachments", new java.lang.Object[]{(java.lang.Object) value});
	}

	public int[] getPreserve_attachments() {
		return (int[]) super.call("get_preserve_attachments", new java.lang.Object[0]);
	}

	public void setPreserve_attachments(int[] value) {
		super.call("set_preserve_attachments", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDepth_attachment() {
		return (long) super.call("get_depth_attachment", new java.lang.Object[0]);
	}

	public void setDepth_attachment(long value) {
		super.call("set_depth_attachment", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
