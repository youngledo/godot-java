package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;

public class Translation extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_plural_rules_override", 83702148L),
			java.util.Map.entry("erase_message", 3959009644L), java.util.Map.entry("add_message", 3898530326L),
			java.util.Map.entry("get_message", 1829228469L), java.util.Map.entry("get_plural_message", 229954002L),
			java.util.Map.entry("add_plural_message", 2356982266L),
			java.util.Map.entry("get_message_count", 3905245786L), java.util.Map.entry("get_locale", 201670096L),
			java.util.Map.entry("get_plural_rules_override", 201670096L),
			java.util.Map.entry("get_message_list", 1139954409L), java.util.Map.entry("set_locale", 83702148L),
			java.util.Map.entry("get_translated_message_list", 1139954409L));

	Translation(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Translation(long nativePointer) {
		super(nativePointer);
	}

	public void add_message(String src_message, String xlated_message, String context) {
		super.call("add_message", new java.lang.Object[]{(java.lang.Object) src_message,
				(java.lang.Object) xlated_message, (java.lang.Object) context});
	}

	public void add_plural_message(String src_message, String[] xlated_messages, String context) {
		super.call("add_plural_message", new java.lang.Object[]{(java.lang.Object) src_message,
				(java.lang.Object) xlated_messages, (java.lang.Object) context});
	}

	public String get_message(String src_message, String context) {
		return (String) super.call("get_message",
				new java.lang.Object[]{(java.lang.Object) src_message, (java.lang.Object) context});
	}

	public String get_plural_message(String src_message, String src_plural_message, long n, String context) {
		return (String) super.call("get_plural_message", new java.lang.Object[]{(java.lang.Object) src_message,
				(java.lang.Object) src_plural_message, java.lang.Long.valueOf(n), (java.lang.Object) context});
	}

	public void erase_message(String src_message, String context) {
		super.call("erase_message", new java.lang.Object[]{(java.lang.Object) src_message, (java.lang.Object) context});
	}

	public GodotDictionary getMessages() {
		return (GodotDictionary) super.call("_get_messages", new java.lang.Object[0]);
	}

	public void setMessages(GodotDictionary value) {
		super.call("_set_messages", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getLocale() {
		return (String) super.call("get_locale", new java.lang.Object[0]);
	}

	public void setLocale(String value) {
		super.call("set_locale", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getPlural_rules_override() {
		return (String) super.call("get_plural_rules_override", new java.lang.Object[0]);
	}

	public void setPlural_rules_override(String value) {
		super.call("set_plural_rules_override", new java.lang.Object[]{(java.lang.Object) value});
	}
}
