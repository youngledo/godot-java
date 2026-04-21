package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.Callable;
import org.godot.math.Transform3D;

public class OpenXRSpatialAnchorCapability extends OpenXRExtensionWrapper {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_persistence_context_handle", 2198884583L),
			java.util.Map.entry("is_spatial_anchor_supported", 2240911060L),
			java.util.Map.entry("unpersist_anchor", 4244202513L),
			java.util.Map.entry("free_persistence_context", 2722037293L),
			java.util.Map.entry("create_new_anchor", 607100373L),
			java.util.Map.entry("is_persistence_scope_supported", 3651771626L),
			java.util.Map.entry("is_spatial_persistence_supported", 2240911060L),
			java.util.Map.entry("persist_anchor", 4244202513L), java.util.Map.entry("remove_anchor", 3579451518L),
			java.util.Map.entry("create_persistence_context", 856276630L));

	OpenXRSpatialAnchorCapability(MemorySegment nativePointer) {
		super(nativePointer);
	}

	OpenXRSpatialAnchorCapability(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_spatial_anchor_supported() {
		return (boolean) super.call("is_spatial_anchor_supported");
	}

	public boolean is_spatial_persistence_supported() {
		return (boolean) super.call("is_spatial_persistence_supported");
	}

	public boolean is_persistence_scope_supported(int scope) {
		return (boolean) super.call("is_persistence_scope_supported",
				new java.lang.Object[]{java.lang.Integer.valueOf(scope)});
	}

	public OpenXRFutureResult create_persistence_context(int scope, Callable user_callback) {
		return (OpenXRFutureResult) super.call("create_persistence_context",
				new java.lang.Object[]{java.lang.Integer.valueOf(scope), (java.lang.Object) user_callback});
	}

	public java.math.BigInteger get_persistence_context_handle(long persistence_context) {
		return (java.math.BigInteger) super.call("get_persistence_context_handle",
				new java.lang.Object[]{java.lang.Long.valueOf(persistence_context)});
	}

	public void free_persistence_context(long persistence_context) {
		super.call("free_persistence_context", new java.lang.Object[]{java.lang.Long.valueOf(persistence_context)});
	}

	public OpenXRAnchorTracker create_new_anchor(Transform3D transform, long spatial_context) {
		return (OpenXRAnchorTracker) super.call("create_new_anchor",
				new java.lang.Object[]{(java.lang.Object) transform, java.lang.Long.valueOf(spatial_context)});
	}

	public void remove_anchor(OpenXRAnchorTracker anchor_tracker) {
		super.call("remove_anchor", new java.lang.Object[]{(java.lang.Object) anchor_tracker});
	}

	public OpenXRFutureResult persist_anchor(OpenXRAnchorTracker anchor_tracker, long persistence_context,
			Callable user_callback) {
		return (OpenXRFutureResult) super.call("persist_anchor",
				new java.lang.Object[]{(java.lang.Object) anchor_tracker, java.lang.Long.valueOf(persistence_context),
						(java.lang.Object) user_callback});
	}

	public OpenXRFutureResult unpersist_anchor(OpenXRAnchorTracker anchor_tracker, long persistence_context,
			Callable user_callback) {
		return (OpenXRFutureResult) super.call("unpersist_anchor",
				new java.lang.Object[]{(java.lang.Object) anchor_tracker, java.lang.Long.valueOf(persistence_context),
						(java.lang.Object) user_callback});
	}
}
