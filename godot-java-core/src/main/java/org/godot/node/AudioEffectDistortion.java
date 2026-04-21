package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class AudioEffectDistortion extends AudioEffect {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_keep_hf_hz", 1740695150L), java.util.Map.entry("set_post_gain", 373806689L),
			java.util.Map.entry("get_mode", 809118343L), java.util.Map.entry("get_drive", 1740695150L),
			java.util.Map.entry("set_drive", 373806689L), java.util.Map.entry("get_post_gain", 1740695150L),
			java.util.Map.entry("set_pre_gain", 373806689L), java.util.Map.entry("get_pre_gain", 1740695150L),
			java.util.Map.entry("set_mode", 1314744793L), java.util.Map.entry("set_keep_hf_hz", 373806689L));

	AudioEffectDistortion(MemorySegment nativePointer) {
		super(nativePointer);
	}

	AudioEffectDistortion(long nativePointer) {
		super(nativePointer);
	}

	public long getMode() {
		return (long) super.call("get_mode", new java.lang.Object[0]);
	}

	public void setMode(long value) {
		super.call("set_mode", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public double getPre_gain() {
		return (double) super.call("get_pre_gain", new java.lang.Object[0]);
	}

	public void setPre_gain(double value) {
		super.call("set_pre_gain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getKeep_hf_hz() {
		return (double) super.call("get_keep_hf_hz", new java.lang.Object[0]);
	}

	public void setKeep_hf_hz(double value) {
		super.call("set_keep_hf_hz", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getDrive() {
		return (double) super.call("get_drive", new java.lang.Object[0]);
	}

	public void setDrive(double value) {
		super.call("set_drive", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getPost_gain() {
		return (double) super.call("get_post_gain", new java.lang.Object[0]);
	}

	public void setPost_gain(double value) {
		super.call("set_post_gain", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}
}
