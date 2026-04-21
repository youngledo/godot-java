package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;
import org.godot.math.Color;

public class RDPipelineColorBlendState extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_attachments", 3995934104L), java.util.Map.entry("set_attachments", 381264803L),
			java.util.Map.entry("get_logic_op", 988254690L), java.util.Map.entry("set_blend_constant", 2920490490L),
			java.util.Map.entry("get_enable_logic_op", 36873697L),
			java.util.Map.entry("get_blend_constant", 3444240500L),
			java.util.Map.entry("set_enable_logic_op", 2586408642L), java.util.Map.entry("set_logic_op", 3610841058L));

	RDPipelineColorBlendState(MemorySegment nativePointer) {
		super(nativePointer);
	}

	RDPipelineColorBlendState(long nativePointer) {
		super(nativePointer);
	}

	public boolean getEnable_logic_op() {
		return (boolean) super.call("get_enable_logic_op", new java.lang.Object[0]);
	}

	public void setEnable_logic_op(boolean value) {
		super.call("set_enable_logic_op", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getLogic_op() {
		return (long) super.call("get_logic_op", new java.lang.Object[0]);
	}

	public void setLogic_op(long value) {
		super.call("set_logic_op", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public Color getBlend_constant() {
		return (Color) super.call("get_blend_constant", new java.lang.Object[0]);
	}

	public void setBlend_constant(Color value) {
		super.call("set_blend_constant", new java.lang.Object[]{(java.lang.Object) value});
	}

	public RDPipelineColorBlendStateAttachment[] getAttachments() {
		return (RDPipelineColorBlendStateAttachment[]) super.call("get_attachments", new java.lang.Object[0]);
	}

	public void setAttachments(RDPipelineColorBlendStateAttachment[] value) {
		super.call("set_attachments", new java.lang.Object[]{(java.lang.Object) value});
	}
}
