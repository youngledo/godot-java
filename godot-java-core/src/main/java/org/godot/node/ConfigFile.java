package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class ConfigFile extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_value", 2504492430L), java.util.Map.entry("erase_section_key", 3186203200L),
			java.util.Map.entry("save", 166001499L), java.util.Map.entry("save_encrypted_pass", 852856452L),
			java.util.Map.entry("clear", 3218959716L), java.util.Map.entry("parse", 166001499L),
			java.util.Map.entry("get_value", 89809366L), java.util.Map.entry("load_encrypted_pass", 852856452L),
			java.util.Map.entry("load", 166001499L), java.util.Map.entry("get_section_keys", 4291131558L),
			java.util.Map.entry("save_encrypted", 887037711L), java.util.Map.entry("get_sections", 1139954409L),
			java.util.Map.entry("has_section", 3927539163L), java.util.Map.entry("load_encrypted", 887037711L),
			java.util.Map.entry("has_section_key", 820780508L), java.util.Map.entry("erase_section", 83702148L),
			java.util.Map.entry("encode_to_text", 201670096L));

	ConfigFile(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ConfigFile(long nativePointer) {
		super(nativePointer);
	}

	public void set_value(String section, String key, Object value) {
		super.call("set_value",
				new java.lang.Object[]{(java.lang.Object) section, (java.lang.Object) key, (java.lang.Object) value});
	}

	public Object get_value(String section, String key, Object default_) {
		return (Object) super.call("get_value", new java.lang.Object[]{(java.lang.Object) section,
				(java.lang.Object) key, (java.lang.Object) default_});
	}

	public boolean has_section(String section) {
		return (boolean) super.call("has_section", new java.lang.Object[]{(java.lang.Object) section});
	}

	public boolean has_section_key(String section, String key) {
		return (boolean) super.call("has_section_key",
				new java.lang.Object[]{(java.lang.Object) section, (java.lang.Object) key});
	}

	public String[] get_section_keys(String section) {
		return (String[]) super.call("get_section_keys", new java.lang.Object[]{(java.lang.Object) section});
	}

	public void erase_section(String section) {
		super.call("erase_section", new java.lang.Object[]{(java.lang.Object) section});
	}

	public void erase_section_key(String section, String key) {
		super.call("erase_section_key", new java.lang.Object[]{(java.lang.Object) section, (java.lang.Object) key});
	}

	public int load(String path) {
		return (int) super.call("load", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int parse(String data) {
		return (int) super.call("parse", new java.lang.Object[]{(java.lang.Object) data});
	}

	public int save(String path) {
		return (int) super.call("save", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String encode_to_text() {
		return (String) super.call("encode_to_text");
	}

	public int load_encrypted(String path, byte[] key) {
		return (int) super.call("load_encrypted",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) key});
	}

	public int load_encrypted_pass(String path, String password) {
		return (int) super.call("load_encrypted_pass",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) password});
	}

	public int save_encrypted(String path, byte[] key) {
		return (int) super.call("save_encrypted",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) key});
	}

	public int save_encrypted_pass(String path, String password) {
		return (int) super.call("save_encrypted_pass",
				new java.lang.Object[]{(java.lang.Object) path, (java.lang.Object) password});
	}

	public void clear() {
		super.call("clear");
	}
}
