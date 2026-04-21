package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotArray;

public class IP extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("resolve_hostname_addresses", 773767525L),
			java.util.Map.entry("get_resolve_item_address", 844755477L),
			java.util.Map.entry("clear_cache", 3005725572L), java.util.Map.entry("erase_resolve_item", 1286410249L),
			java.util.Map.entry("resolve_hostname", 4283295457L),
			java.util.Map.entry("get_resolve_item_addresses", 663333327L),
			java.util.Map.entry("get_local_addresses", 1139954409L),
			java.util.Map.entry("get_resolve_item_status", 3812250196L),
			java.util.Map.entry("get_local_interfaces", 3995934104L),
			java.util.Map.entry("resolve_hostname_queue_item", 1749894742L));

	IP(MemorySegment nativePointer) {
		super(nativePointer);
	}

	IP(long nativePointer) {
		super(nativePointer);
	}

	public String resolve_hostname(String host, int ip_type) {
		return (String) super.call("resolve_hostname",
				new java.lang.Object[]{(java.lang.Object) host, java.lang.Integer.valueOf(ip_type)});
	}

	public String[] resolve_hostname_addresses(String host, int ip_type) {
		return (String[]) super.call("resolve_hostname_addresses",
				new java.lang.Object[]{(java.lang.Object) host, java.lang.Integer.valueOf(ip_type)});
	}

	public int resolve_hostname_queue_item(String host, int ip_type) {
		return (int) super.call("resolve_hostname_queue_item",
				new java.lang.Object[]{(java.lang.Object) host, java.lang.Integer.valueOf(ip_type)});
	}

	public int get_resolve_item_status(long id) {
		return (int) super.call("get_resolve_item_status", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public String get_resolve_item_address(long id) {
		return (String) super.call("get_resolve_item_address", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public GodotArray get_resolve_item_addresses(long id) {
		return (GodotArray) super.call("get_resolve_item_addresses",
				new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void erase_resolve_item(long id) {
		super.call("erase_resolve_item", new java.lang.Object[]{java.lang.Long.valueOf(id)});
	}

	public void clear_cache(String hostname) {
		super.call("clear_cache", new java.lang.Object[]{(java.lang.Object) hostname});
	}
}
