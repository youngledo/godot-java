package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class UPNP extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("query_external_address", 201670096L), java.util.Map.entry("discover", 1575334765L),
			java.util.Map.entry("set_discover_ipv6", 2586408642L), java.util.Map.entry("clear_devices", 3218959716L),
			java.util.Map.entry("is_discover_ipv6", 36873697L), java.util.Map.entry("add_device", 986715920L),
			java.util.Map.entry("set_discover_local_port", 1286410249L),
			java.util.Map.entry("set_discover_multicast_if", 83702148L),
			java.util.Map.entry("get_discover_local_port", 3905245786L), java.util.Map.entry("get_device", 2193290270L),
			java.util.Map.entry("set_device", 3015133723L), java.util.Map.entry("get_gateway", 2276800779L),
			java.util.Map.entry("remove_device", 1286410249L), java.util.Map.entry("delete_port_mapping", 3444187325L),
			java.util.Map.entry("get_device_count", 3905245786L),
			java.util.Map.entry("get_discover_multicast_if", 201670096L),
			java.util.Map.entry("add_port_mapping", 818314583L));

	UPNP(MemorySegment nativePointer) {
		super(nativePointer);
	}

	UPNP(long nativePointer) {
		super(nativePointer);
	}

	public UPNPDevice get_device(long index) {
		return (UPNPDevice) super.call("get_device", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void add_device(UPNPDevice device) {
		super.call("add_device", new java.lang.Object[]{(java.lang.Object) device});
	}

	public void set_device(long index, UPNPDevice device) {
		super.call("set_device", new java.lang.Object[]{java.lang.Long.valueOf(index), (java.lang.Object) device});
	}

	public void remove_device(long index) {
		super.call("remove_device", new java.lang.Object[]{java.lang.Long.valueOf(index)});
	}

	public void clear_devices() {
		super.call("clear_devices");
	}

	public int discover(long timeout, long ttl, String device_filter) {
		return (int) super.call("discover", new java.lang.Object[]{java.lang.Long.valueOf(timeout),
				java.lang.Long.valueOf(ttl), (java.lang.Object) device_filter});
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

	public boolean is_discover_ipv6() {
		return (boolean) super.call("is_discover_ipv6");
	}

	public String getDiscover_multicast_if() {
		return (String) super.call("get_discover_multicast_if", new java.lang.Object[0]);
	}

	public void setDiscover_multicast_if(String value) {
		super.call("set_discover_multicast_if", new java.lang.Object[]{(java.lang.Object) value});
	}

	public long getDiscover_local_port() {
		return (long) super.call("get_discover_local_port", new java.lang.Object[0]);
	}

	public void setDiscover_local_port(long value) {
		super.call("set_discover_local_port", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isDiscover_ipv6() {
		return (boolean) super.call("is_discover_ipv6", new java.lang.Object[0]);
	}

	public void setDiscover_ipv6(boolean value) {
		super.call("set_discover_ipv6", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
