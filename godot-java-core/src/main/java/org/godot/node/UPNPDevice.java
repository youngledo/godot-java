package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class UPNPDevice extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("query_external_address", 201670096L),
			java.util.Map.entry("set_igd_our_addr", 83702148L), java.util.Map.entry("set_igd_status", 519504122L),
			java.util.Map.entry("get_igd_our_addr", 201670096L), java.util.Map.entry("set_igd_control_url", 83702148L),
			java.util.Map.entry("get_igd_service_type", 201670096L), java.util.Map.entry("is_valid_gateway", 36873697L),
			java.util.Map.entry("set_service_type", 83702148L), java.util.Map.entry("get_igd_status", 180887011L),
			java.util.Map.entry("set_description_url", 83702148L),
			java.util.Map.entry("delete_port_mapping", 3444187325L),
			java.util.Map.entry("get_igd_control_url", 201670096L), java.util.Map.entry("get_service_type", 201670096L),
			java.util.Map.entry("get_description_url", 201670096L),
			java.util.Map.entry("set_igd_service_type", 83702148L),
			java.util.Map.entry("add_port_mapping", 818314583L));

	UPNPDevice(MemorySegment nativePointer) {
		super(nativePointer);
	}

	UPNPDevice(long nativePointer) {
		super(nativePointer);
	}

	public boolean is_valid_gateway() {
		return (boolean) super.call("is_valid_gateway");
	}

	public String query_external_address() {
		return (String) super.call("query_external_address");
	}

	public int add_port_mapping(long port, long port_internal, String desc, String proto, long duration) {
		return (int) super.call("add_port_mapping",
				new java.lang.Object[]{java.lang.Long.valueOf(port), java.lang.Long.valueOf(port_internal),
						(java.lang.Object) desc, (java.lang.Object) proto, java.lang.Long.valueOf(duration)});
	}

	public int delete_port_mapping(long port, String proto) {
		return (int) super.call("delete_port_mapping",
				new java.lang.Object[]{java.lang.Long.valueOf(port), (java.lang.Object) proto});
	}

	public String getDescription_url() {
		return (String) super.call("get_description_url", new java.lang.Object[0]);
	}

	public void setDescription_url(String value) {
		super.call("set_description_url", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getService_type() {
		return (String) super.call("get_service_type", new java.lang.Object[0]);
	}

	public void setService_type(String value) {
		super.call("set_service_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getIgd_control_url() {
		return (String) super.call("get_igd_control_url", new java.lang.Object[0]);
	}

	public void setIgd_control_url(String value) {
		super.call("set_igd_control_url", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getIgd_service_type() {
		return (String) super.call("get_igd_service_type", new java.lang.Object[0]);
	}

	public void setIgd_service_type(String value) {
		super.call("set_igd_service_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getIgd_our_addr() {
		return (String) super.call("get_igd_our_addr", new java.lang.Object[0]);
	}

	public void setIgd_our_addr(String value) {
		super.call("set_igd_our_addr", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getIgd_status() {
		return (long) super.call("get_igd_status", new java.lang.Object[0]);
	}

	public void setIgd_status(long value) {
		super.call("set_igd_status", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}
}
