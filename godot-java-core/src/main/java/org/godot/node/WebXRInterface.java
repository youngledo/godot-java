package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;

public class WebXRInterface extends XRInterface {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_session_mode", 201670096L),
			java.util.Map.entry("get_optional_features", 201670096L),
			java.util.Map.entry("set_session_mode", 83702148L), java.util.Map.entry("set_optional_features", 83702148L),
			java.util.Map.entry("set_required_features", 83702148L),
			java.util.Map.entry("is_session_supported", 83702148L),
			java.util.Map.entry("get_enabled_features", 201670096L),
			java.util.Map.entry("set_requested_reference_space_types", 83702148L),
			java.util.Map.entry("set_display_refresh_rate", 373806689L),
			java.util.Map.entry("get_required_features", 201670096L),
			java.util.Map.entry("is_input_source_active", 1116898809L),
			java.util.Map.entry("get_reference_space_type", 201670096L),
			java.util.Map.entry("get_available_display_refresh_rates", 3995934104L),
			java.util.Map.entry("get_display_refresh_rate", 1740695150L),
			java.util.Map.entry("get_requested_reference_space_types", 201670096L),
			java.util.Map.entry("get_visibility_state", 201670096L),
			java.util.Map.entry("get_input_source_tracker", 399776966L),
			java.util.Map.entry("get_input_source_target_ray_mode", 2852387453L));

	WebXRInterface(MemorySegment nativePointer) {
		super(nativePointer);
	}

	WebXRInterface(long nativePointer) {
		super(nativePointer);
	}

	public void is_session_supported(String session_mode) {
		super.call("is_session_supported", new java.lang.Object[]{(java.lang.Object) session_mode});
	}

	public boolean is_input_source_active(long input_source_id) {
		return (boolean) super.call("is_input_source_active",
				new java.lang.Object[]{java.lang.Long.valueOf(input_source_id)});
	}

	public XRControllerTracker get_input_source_tracker(long input_source_id) {
		return (XRControllerTracker) super.call("get_input_source_tracker",
				new java.lang.Object[]{java.lang.Long.valueOf(input_source_id)});
	}

	public int get_input_source_target_ray_mode(long input_source_id) {
		return (int) super.call("get_input_source_target_ray_mode",
				new java.lang.Object[]{java.lang.Long.valueOf(input_source_id)});
	}

	public String getSession_mode() {
		return (String) super.call("get_session_mode", new java.lang.Object[0]);
	}

	public void setSession_mode(String value) {
		super.call("set_session_mode", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getRequired_features() {
		return (String) super.call("get_required_features", new java.lang.Object[0]);
	}

	public void setRequired_features(String value) {
		super.call("set_required_features", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getOptional_features() {
		return (String) super.call("get_optional_features", new java.lang.Object[0]);
	}

	public void setOptional_features(String value) {
		super.call("set_optional_features", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getRequested_reference_space_types() {
		return (String) super.call("get_requested_reference_space_types", new java.lang.Object[0]);
	}

	public void setRequested_reference_space_types(String value) {
		super.call("set_requested_reference_space_types", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getReference_space_type() {
		return (String) super.call("get_reference_space_type", new java.lang.Object[0]);
	}

	public void setReference_space_type(String value) {
		super.call("set_reference_space_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getEnabled_features() {
		return (String) super.call("get_enabled_features", new java.lang.Object[0]);
	}

	public void setEnabled_features(String value) {
		super.call("set_enabled_features", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getVisibility_state() {
		return (String) super.call("get_visibility_state", new java.lang.Object[0]);
	}

	public void setVisibility_state(String value) {
		super.call("set_visibility_state", new java.lang.Object[]{(java.lang.Object) value});
	}
}
