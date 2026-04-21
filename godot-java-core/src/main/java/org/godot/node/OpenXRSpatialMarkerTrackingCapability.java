package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class OpenXRSpatialMarkerTrackingCapability extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("is_qrcode_supported", 2240911060L),
			java.util.Map.entry("is_aruco_supported", 2240911060L),
			java.util.Map.entry("is_april_tag_supported", 2240911060L),
			java.util.Map.entry("is_micro_qrcode_supported", 2240911060L));

	OpenXRSpatialMarkerTrackingCapability(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialMarkerTrackingCapability(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_qrcode_supported() {
		return (boolean) super.call("is_qrcode_supported");
	}

	public boolean is_micro_qrcode_supported() {
		return (boolean) super.call("is_micro_qrcode_supported");
	}

	public boolean is_aruco_supported() {
		return (boolean) super.call("is_aruco_supported");
	}

	public boolean is_april_tag_supported() {
		return (boolean) super.call("is_april_tag_supported");
	}
}
