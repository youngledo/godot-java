package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class MissingNode extends Node {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_original_scene", 83702148L), java.util.Map.entry("set_original_class", 83702148L),
			java.util.Map.entry("is_recording_signals", 36873697L),
			java.util.Map.entry("set_recording_signals", 2586408642L),
			java.util.Map.entry("get_original_class", 201670096L),
			java.util.Map.entry("is_recording_properties", 36873697L),
			java.util.Map.entry("get_original_scene", 201670096L),
			java.util.Map.entry("set_recording_properties", 2586408642L));

	MissingNode(MemorySegment nativePointer) {
		super(nativePointer);
	}

	MissingNode(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_recording_properties() {
		return (boolean) super.call("is_recording_properties");
	}

	public boolean is_recording_signals() {
		return (boolean) super.call("is_recording_signals");
	}

	public String getOriginal_class() {
		return (String) super.call("get_original_class", new java.lang.Object[0]);
	}

	public void setOriginal_class(String value) {
		super.call("set_original_class", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getOriginal_scene() {
		return (String) super.call("get_original_scene", new java.lang.Object[0]);
	}

	public void setOriginal_scene(String value) {
		super.call("set_original_scene", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isRecording_properties() {
		return (boolean) super.call("is_recording_properties", new java.lang.Object[0]);
	}

	public void setRecording_properties(boolean value) {
		super.call("set_recording_properties", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isRecording_signals() {
		return (boolean) super.call("is_recording_signals", new java.lang.Object[0]);
	}

	public void setRecording_signals(boolean value) {
		super.call("set_recording_signals", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
