package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.collection.GodotDictionary;

public class Time extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_time_string_from_unix_time", 844755477L),
			java.util.Map.entry("get_ticks_msec", 3905245786L),
			java.util.Map.entry("get_datetime_dict_from_unix_time", 3485342025L),
			java.util.Map.entry("get_time_dict_from_unix_time", 3485342025L),
			java.util.Map.entry("get_unix_time_from_datetime_dict", 3021115443L),
			java.util.Map.entry("get_time_dict_from_system", 205769976L),
			java.util.Map.entry("get_date_string_from_system", 1162154673L),
			java.util.Map.entry("get_time_zone_from_system", 3102165223L),
			java.util.Map.entry("get_datetime_dict_from_system", 205769976L),
			java.util.Map.entry("get_ticks_usec", 3905245786L),
			java.util.Map.entry("get_time_string_from_system", 1162154673L),
			java.util.Map.entry("get_unix_time_from_system", 1740695150L),
			java.util.Map.entry("get_datetime_string_from_datetime_dict", 1898123706L),
			java.util.Map.entry("get_offset_string_from_offset_minutes", 844755477L),
			java.util.Map.entry("get_unix_time_from_datetime_string", 1321353865L),
			java.util.Map.entry("get_date_dict_from_unix_time", 3485342025L),
			java.util.Map.entry("get_datetime_string_from_system", 1136425492L),
			java.util.Map.entry("get_datetime_string_from_unix_time", 2311239925L),
			java.util.Map.entry("get_datetime_dict_from_datetime_string", 3253569256L),
			java.util.Map.entry("get_date_dict_from_system", 205769976L),
			java.util.Map.entry("get_date_string_from_unix_time", 844755477L));

	Time(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Time(long nativePointer) {
		super(nativePointer);
	}

	public GodotDictionary get_datetime_dict_from_unix_time(long unix_time_val) {
		return (GodotDictionary) super.call("get_datetime_dict_from_unix_time",
				new java.lang.Object[]{java.lang.Long.valueOf(unix_time_val)});
	}

	public GodotDictionary get_date_dict_from_unix_time(long unix_time_val) {
		return (GodotDictionary) super.call("get_date_dict_from_unix_time",
				new java.lang.Object[]{java.lang.Long.valueOf(unix_time_val)});
	}

	public GodotDictionary get_time_dict_from_unix_time(long unix_time_val) {
		return (GodotDictionary) super.call("get_time_dict_from_unix_time",
				new java.lang.Object[]{java.lang.Long.valueOf(unix_time_val)});
	}

	public String get_datetime_string_from_unix_time(long unix_time_val, boolean use_space) {
		return (String) super.call("get_datetime_string_from_unix_time",
				new java.lang.Object[]{java.lang.Long.valueOf(unix_time_val), java.lang.Boolean.valueOf(use_space)});
	}

	public String get_date_string_from_unix_time(long unix_time_val) {
		return (String) super.call("get_date_string_from_unix_time",
				new java.lang.Object[]{java.lang.Long.valueOf(unix_time_val)});
	}

	public String get_time_string_from_unix_time(long unix_time_val) {
		return (String) super.call("get_time_string_from_unix_time",
				new java.lang.Object[]{java.lang.Long.valueOf(unix_time_val)});
	}

	public GodotDictionary get_datetime_dict_from_datetime_string(String datetime, boolean weekday) {
		return (GodotDictionary) super.call("get_datetime_dict_from_datetime_string",
				new java.lang.Object[]{(java.lang.Object) datetime, java.lang.Boolean.valueOf(weekday)});
	}

	public String get_datetime_string_from_datetime_dict(GodotDictionary datetime, boolean use_space) {
		return (String) super.call("get_datetime_string_from_datetime_dict",
				new java.lang.Object[]{(java.lang.Object) datetime, java.lang.Boolean.valueOf(use_space)});
	}

	public long get_unix_time_from_datetime_dict(GodotDictionary datetime) {
		return (long) super.call("get_unix_time_from_datetime_dict",
				new java.lang.Object[]{(java.lang.Object) datetime});
	}

	public long get_unix_time_from_datetime_string(String datetime) {
		return (long) super.call("get_unix_time_from_datetime_string",
				new java.lang.Object[]{(java.lang.Object) datetime});
	}

	public String get_offset_string_from_offset_minutes(long offset_minutes) {
		return (String) super.call("get_offset_string_from_offset_minutes",
				new java.lang.Object[]{java.lang.Long.valueOf(offset_minutes)});
	}

	public GodotDictionary get_datetime_dict_from_system(boolean utc) {
		return (GodotDictionary) super.call("get_datetime_dict_from_system",
				new java.lang.Object[]{java.lang.Boolean.valueOf(utc)});
	}

	public GodotDictionary get_date_dict_from_system(boolean utc) {
		return (GodotDictionary) super.call("get_date_dict_from_system",
				new java.lang.Object[]{java.lang.Boolean.valueOf(utc)});
	}

	public GodotDictionary get_time_dict_from_system(boolean utc) {
		return (GodotDictionary) super.call("get_time_dict_from_system",
				new java.lang.Object[]{java.lang.Boolean.valueOf(utc)});
	}

	public String get_datetime_string_from_system(boolean utc, boolean use_space) {
		return (String) super.call("get_datetime_string_from_system",
				new java.lang.Object[]{java.lang.Boolean.valueOf(utc), java.lang.Boolean.valueOf(use_space)});
	}

	public String get_date_string_from_system(boolean utc) {
		return (String) super.call("get_date_string_from_system",
				new java.lang.Object[]{java.lang.Boolean.valueOf(utc)});
	}

	public String get_time_string_from_system(boolean utc) {
		return (String) super.call("get_time_string_from_system",
				new java.lang.Object[]{java.lang.Boolean.valueOf(utc)});
	}
}
