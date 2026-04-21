package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class FileAccess extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_position", 3905245786L), java.util.Map.entry("set_hidden_attribute", 2892558115L),
			java.util.Map.entry("store_64", 3067735520L), java.util.Map.entry("get_pascal_string", 2841200299L),
			java.util.Map.entry("get_extended_attributes_list", 3538744774L),
			java.util.Map.entry("set_read_only_attribute", 2892558115L),
			java.util.Map.entry("store_double", 330693286L), java.util.Map.entry("store_var", 117357437L),
			java.util.Map.entry("get_sha256", 1703090593L), java.util.Map.entry("store_16", 3067735520L),
			java.util.Map.entry("get_size", 1597066294L), java.util.Map.entry("open_encrypted_with_pass", 790283377L),
			java.util.Map.entry("open_compressed", 3686439335L), java.util.Map.entry("get_md5", 1703090593L),
			java.util.Map.entry("get_path", 201670096L), java.util.Map.entry("create_temp", 171914364L),
			java.util.Map.entry("store_32", 3067735520L), java.util.Map.entry("is_open", 36873697L),
			java.util.Map.entry("get_16", 3905245786L), java.util.Map.entry("get_double", 1740695150L),
			java.util.Map.entry("remove_extended_attribute", 852856452L),
			java.util.Map.entry("get_buffer", 4131300905L), java.util.Map.entry("store_csv_line", 1611473434L),
			java.util.Map.entry("get_float", 1740695150L),
			java.util.Map.entry("set_extended_attribute_string", 699024349L),
			java.util.Map.entry("get_half", 1740695150L), java.util.Map.entry("get_var", 189129690L),
			java.util.Map.entry("get_modified_time", 1597066294L), java.util.Map.entry("get_path_absolute", 201670096L),
			java.util.Map.entry("get_real", 1740695150L), java.util.Map.entry("store_half", 330693286L),
			java.util.Map.entry("store_buffer", 114037665L), java.util.Map.entry("eof_reached", 36873697L),
			java.util.Map.entry("open_encrypted", 788003459L), java.util.Map.entry("set_big_endian", 2586408642L),
			java.util.Map.entry("store_float", 330693286L), java.util.Map.entry("get_as_text", 201670096L),
			java.util.Map.entry("get_error", 3185525595L), java.util.Map.entry("seek", 1286410249L),
			java.util.Map.entry("store_real", 330693286L), java.util.Map.entry("get_64", 3905245786L),
			java.util.Map.entry("set_extended_attribute", 2643421469L), java.util.Map.entry("flush", 3218959716L),
			java.util.Map.entry("get_8", 3905245786L), java.util.Map.entry("get_access_time", 1597066294L),
			java.util.Map.entry("is_big_endian", 36873697L), java.util.Map.entry("get_file_as_bytes", 659035735L),
			java.util.Map.entry("get_file_as_string", 1703090593L),
			java.util.Map.entry("get_unix_permissions", 524341837L), java.util.Map.entry("close", 3218959716L),
			java.util.Map.entry("get_32", 3905245786L), java.util.Map.entry("get_extended_attribute", 955893464L),
			java.util.Map.entry("get_open_error", 166280745L),
			java.util.Map.entry("get_extended_attribute_string", 1218461987L),
			java.util.Map.entry("set_unix_permissions", 846038644L), java.util.Map.entry("store_8", 3067735520L),
			java.util.Map.entry("get_line", 201670096L), java.util.Map.entry("store_pascal_string", 2323990056L),
			java.util.Map.entry("seek_end", 1995695955L), java.util.Map.entry("store_string", 2323990056L),
			java.util.Map.entry("file_exists", 2323990056L),
			java.util.Map.entry("get_read_only_attribute", 2323990056L), java.util.Map.entry("resize", 844576869L),
			java.util.Map.entry("get_csv_line", 2358116058L), java.util.Map.entry("get_length", 3905245786L),
			java.util.Map.entry("store_line", 2323990056L), java.util.Map.entry("open", 1247358404L),
			java.util.Map.entry("get_hidden_attribute", 2323990056L));

	FileAccess(MemorySegment nativePointer) {
		super(nativePointer);
	}

	FileAccess(long nativePointer) {
		super(nativePointer);
	}

	public FileAccess open(String path, int flags) {
		return (FileAccess) super.call("open",
				new java.lang.Object[]{(java.lang.Object) path, java.lang.Integer.valueOf(flags)});
	}

	public FileAccess open_encrypted(String path, int mode_flags, byte[] key, byte[] iv) {
		return (FileAccess) super.call("open_encrypted", new java.lang.Object[]{(java.lang.Object) path,
				java.lang.Integer.valueOf(mode_flags), (java.lang.Object) key, (java.lang.Object) iv});
	}

	public FileAccess open_encrypted_with_pass(String path, int mode_flags, String pass) {
		return (FileAccess) super.call("open_encrypted_with_pass", new java.lang.Object[]{(java.lang.Object) path,
				java.lang.Integer.valueOf(mode_flags), (java.lang.Object) pass});
	}

	public FileAccess open_compressed(String path, int mode_flags, int compression_mode) {
		return (FileAccess) super.call("open_compressed", new java.lang.Object[]{(java.lang.Object) path,
				java.lang.Integer.valueOf(mode_flags), java.lang.Integer.valueOf(compression_mode)});
	}

	public FileAccess create_temp(int mode_flags, String prefix, String extension, boolean keep) {
		return (FileAccess) super.call("create_temp", new java.lang.Object[]{java.lang.Integer.valueOf(mode_flags),
				(java.lang.Object) prefix, (java.lang.Object) extension, java.lang.Boolean.valueOf(keep)});
	}

	public byte[] get_file_as_bytes(String path) {
		return (byte[]) super.call("get_file_as_bytes", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String get_file_as_string(String path) {
		return (String) super.call("get_file_as_string", new java.lang.Object[]{(java.lang.Object) path});
	}

	public int resize(long length) {
		return (int) super.call("resize", new java.lang.Object[]{java.lang.Long.valueOf(length)});
	}

	public void flush() {
		super.call("flush");
	}

	public boolean is_open() {
		return (boolean) super.call("is_open");
	}

	public void seek(long position) {
		super.call("seek", new java.lang.Object[]{java.lang.Long.valueOf(position)});
	}

	public void seek_end(long position) {
		super.call("seek_end", new java.lang.Object[]{java.lang.Long.valueOf(position)});
	}

	public boolean eof_reached() {
		return (boolean) super.call("eof_reached");
	}

	public byte[] get_buffer(long length) {
		return (byte[]) super.call("get_buffer", new java.lang.Object[]{java.lang.Long.valueOf(length)});
	}

	public String[] get_csv_line(String delim) {
		return (String[]) super.call("get_csv_line", new java.lang.Object[]{(java.lang.Object) delim});
	}

	public String get_md5(String path) {
		return (String) super.call("get_md5", new java.lang.Object[]{(java.lang.Object) path});
	}

	public String get_sha256(String path) {
		return (String) super.call("get_sha256", new java.lang.Object[]{(java.lang.Object) path});
	}

	public boolean is_big_endian() {
		return (boolean) super.call("is_big_endian");
	}

	public Object get_var(boolean allow_objects) {
		return (Object) super.call("get_var", new java.lang.Object[]{java.lang.Boolean.valueOf(allow_objects)});
	}

	public boolean store_8(long value) {
		return (boolean) super.call("store_8", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean store_16(long value) {
		return (boolean) super.call("store_16", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean store_32(long value) {
		return (boolean) super.call("store_32", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean store_64(long value) {
		return (boolean) super.call("store_64", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean store_half(double value) {
		return (boolean) super.call("store_half", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean store_float(double value) {
		return (boolean) super.call("store_float", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean store_double(double value) {
		return (boolean) super.call("store_double", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean store_real(double value) {
		return (boolean) super.call("store_real", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean store_buffer(byte[] buffer) {
		return (boolean) super.call("store_buffer", new java.lang.Object[]{(java.lang.Object) buffer});
	}

	public boolean store_line(String line) {
		return (boolean) super.call("store_line", new java.lang.Object[]{(java.lang.Object) line});
	}

	public boolean store_csv_line(String[] values, String delim) {
		return (boolean) super.call("store_csv_line",
				new java.lang.Object[]{(java.lang.Object) values, (java.lang.Object) delim});
	}

	public boolean store_string(String string) {
		return (boolean) super.call("store_string", new java.lang.Object[]{(java.lang.Object) string});
	}

	public boolean store_var(Object value, boolean full_objects) {
		return (boolean) super.call("store_var",
				new java.lang.Object[]{(java.lang.Object) value, java.lang.Boolean.valueOf(full_objects)});
	}

	public boolean store_pascal_string(String string) {
		return (boolean) super.call("store_pascal_string", new java.lang.Object[]{(java.lang.Object) string});
	}

	public void close() {
		super.call("close");
	}

	public boolean file_exists(String path) {
		return (boolean) super.call("file_exists", new java.lang.Object[]{(java.lang.Object) path});
	}

	public java.math.BigInteger get_modified_time(String file) {
		return (java.math.BigInteger) super.call("get_modified_time", new java.lang.Object[]{(java.lang.Object) file});
	}

	public java.math.BigInteger get_access_time(String file) {
		return (java.math.BigInteger) super.call("get_access_time", new java.lang.Object[]{(java.lang.Object) file});
	}

	public long get_size(String file) {
		return (long) super.call("get_size", new java.lang.Object[]{(java.lang.Object) file});
	}

	public int get_unix_permissions(String file) {
		return (int) super.call("get_unix_permissions", new java.lang.Object[]{(java.lang.Object) file});
	}

	public int set_unix_permissions(String file, int permissions) {
		return (int) super.call("set_unix_permissions",
				new java.lang.Object[]{(java.lang.Object) file, java.lang.Integer.valueOf(permissions)});
	}

	public boolean get_hidden_attribute(String file) {
		return (boolean) super.call("get_hidden_attribute", new java.lang.Object[]{(java.lang.Object) file});
	}

	public int set_hidden_attribute(String file, boolean hidden) {
		return (int) super.call("set_hidden_attribute",
				new java.lang.Object[]{(java.lang.Object) file, java.lang.Boolean.valueOf(hidden)});
	}

	public int set_read_only_attribute(String file, boolean ro) {
		return (int) super.call("set_read_only_attribute",
				new java.lang.Object[]{(java.lang.Object) file, java.lang.Boolean.valueOf(ro)});
	}

	public boolean get_read_only_attribute(String file) {
		return (boolean) super.call("get_read_only_attribute", new java.lang.Object[]{(java.lang.Object) file});
	}

	public byte[] get_extended_attribute(String file, String attribute_name) {
		return (byte[]) super.call("get_extended_attribute",
				new java.lang.Object[]{(java.lang.Object) file, (java.lang.Object) attribute_name});
	}

	public String get_extended_attribute_string(String file, String attribute_name) {
		return (String) super.call("get_extended_attribute_string",
				new java.lang.Object[]{(java.lang.Object) file, (java.lang.Object) attribute_name});
	}

	public int set_extended_attribute(String file, String attribute_name, byte[] data) {
		return (int) super.call("set_extended_attribute", new java.lang.Object[]{(java.lang.Object) file,
				(java.lang.Object) attribute_name, (java.lang.Object) data});
	}

	public int set_extended_attribute_string(String file, String attribute_name, String data) {
		return (int) super.call("set_extended_attribute_string", new java.lang.Object[]{(java.lang.Object) file,
				(java.lang.Object) attribute_name, (java.lang.Object) data});
	}

	public int remove_extended_attribute(String file, String attribute_name) {
		return (int) super.call("remove_extended_attribute",
				new java.lang.Object[]{(java.lang.Object) file, (java.lang.Object) attribute_name});
	}

	public String[] get_extended_attributes_list(String file) {
		return (String[]) super.call("get_extended_attributes_list", new java.lang.Object[]{(java.lang.Object) file});
	}

	public boolean isBig_endian() {
		return (boolean) super.call("is_big_endian", new java.lang.Object[0]);
	}

	public void setBig_endian(boolean value) {
		super.call("set_big_endian", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
