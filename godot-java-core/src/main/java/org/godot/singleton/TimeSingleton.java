package org.godot.singleton;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;

/**
 * Typed wrapper for Godot's Time singleton.
 *
 * <pre>
 * TimeSingleton time = TimeSingleton.getInstance();
 * long msec = time.get_ticks_msec();
 * </pre>
 */
public class TimeSingleton extends Godot {

	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_ticks_msec", 2455072627L), java.util.Map.entry("get_ticks_usec", 2455072627L),
			java.util.Map.entry("get_unix_time_from_system", 1740695150L),
			java.util.Map.entry("get_datetime_dict_from_system", 1740695150L),
			java.util.Map.entry("get_date_dict_from_system", 1740695150L),
			java.util.Map.entry("get_time_dict_from_system", 1740695150L),
			java.util.Map.entry("get_datetime_string_from_system", 4275516303L),
			java.util.Map.entry("get_date_string_from_system", 1740695150L),
			java.util.Map.entry("get_time_string_from_system", 1740695150L),
			java.util.Map.entry("get_time_zone_from_system", 3102165223L),
			java.util.Map.entry("get_datetime_dict_from_unix_time", 1286410249L),
			java.util.Map.entry("get_date_dict_from_unix_time", 1286410249L),
			java.util.Map.entry("get_time_dict_from_unix_time", 1286410249L),
			java.util.Map.entry("get_datetime_string_from_unix_time", 4275516303L),
			java.util.Map.entry("get_date_string_from_unix_time", 1286410249L),
			java.util.Map.entry("get_time_string_from_unix_time", 1286410249L),
			java.util.Map.entry("get_datetime_dict_from_datetime_string", 4275516303L),
			java.util.Map.entry("get_datetime_string_from_datetime_dict", 4275516303L),
			java.util.Map.entry("get_unix_time_from_datetime_dict", 1016888095L),
			java.util.Map.entry("get_unix_time_from_datetime_string", 201670096L),
			java.util.Map.entry("get_offset_string_from_offset_minutes", 1286410249L));

	private static volatile TimeSingleton instance;

	public TimeSingleton(MemorySegment nativePointer) {
		super(nativePointer);
	}

	public TimeSingleton(long nativePointer) {
		super(nativePointer);
	}

	public static TimeSingleton getInstance() {
		if (instance == null) {
			synchronized (TimeSingleton.class) {
				if (instance == null) {
					GodotStringName name = GodotStringName.fromJavaString("Time");
					MemorySegment ptr = Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());
					if (ptr.address() == 0) {
						throw new RuntimeException("Failed to get Time singleton");
					}
					instance = new TimeSingleton(ptr);
				}
			}
		}
		return instance;
	}

	// ----------------------------------------------------------------
	// Ticks (game time)
	// ----------------------------------------------------------------

	public long get_ticks_msec() {
		return (long) call("get_ticks_msec");
	}

	public long get_ticks_usec() {
		return (long) call("get_ticks_usec");
	}

	// ----------------------------------------------------------------
	// System time
	// ----------------------------------------------------------------

	public double get_unix_time_from_system() {
		return (double) call("get_unix_time_from_system");
	}

	public Object get_datetime_dict_from_system() {
		return call("get_datetime_dict_from_system", false);
	}

	public Object get_datetime_dict_from_system(boolean utc) {
		return call("get_datetime_dict_from_system", utc);
	}

	public Object get_date_dict_from_system() {
		return call("get_date_dict_from_system", false);
	}

	public Object get_date_dict_from_system(boolean utc) {
		return call("get_date_dict_from_system", utc);
	}

	public Object get_time_dict_from_system() {
		return call("get_time_dict_from_system", false);
	}

	public Object get_time_dict_from_system(boolean utc) {
		return call("get_time_dict_from_system", utc);
	}

	public String get_datetime_string_from_system() {
		return (String) call("get_datetime_string_from_system", false, true);
	}

	public String get_datetime_string_from_system(boolean utc, boolean use_space) {
		return (String) call("get_datetime_string_from_system", utc, use_space);
	}

	public String get_date_string_from_system() {
		return (String) call("get_date_string_from_system", false);
	}

	public String get_date_string_from_system(boolean utc) {
		return (String) call("get_date_string_from_system", utc);
	}

	public String get_time_string_from_system() {
		return (String) call("get_time_string_from_system", false);
	}

	public String get_time_string_from_system(boolean utc) {
		return (String) call("get_time_string_from_system", utc);
	}

	public Object get_time_zone_from_system() {
		return call("get_time_zone_from_system");
	}

	// ----------------------------------------------------------------
	// Unix time conversion
	// ----------------------------------------------------------------

	public Object get_datetime_dict_from_unix_time(long unix_time) {
		return call("get_datetime_dict_from_unix_time", unix_time);
	}

	public Object get_date_dict_from_unix_time(long unix_time) {
		return call("get_date_dict_from_unix_time", unix_time);
	}

	public Object get_time_dict_from_unix_time(long unix_time) {
		return call("get_time_dict_from_unix_time", unix_time);
	}

	public String get_datetime_string_from_unix_time(long unix_time) {
		return (String) call("get_datetime_string_from_unix_time", unix_time, true);
	}

	public String get_datetime_string_from_unix_time(long unix_time, boolean use_space) {
		return (String) call("get_datetime_string_from_unix_time", unix_time, use_space);
	}

	public String get_date_string_from_unix_time(long unix_time) {
		return (String) call("get_date_string_from_unix_time", unix_time);
	}

	public String get_time_string_from_unix_time(long unix_time) {
		return (String) call("get_time_string_from_unix_time", unix_time);
	}

	// ----------------------------------------------------------------
	// Datetime string/dict conversion
	// ----------------------------------------------------------------

	public Object get_datetime_dict_from_datetime_string(String datetime, boolean weekday) {
		return call("get_datetime_dict_from_datetime_string", datetime, weekday);
	}

	public String get_datetime_string_from_datetime_dict(Object datetime, boolean use_space) {
		return (String) call("get_datetime_string_from_datetime_dict", datetime, use_space);
	}

	public long get_unix_time_from_datetime_dict(Object datetime) {
		return (long) call("get_unix_time_from_datetime_dict", datetime);
	}

	public long get_unix_time_from_datetime_string(String datetime) {
		return (long) call("get_unix_time_from_datetime_string", datetime);
	}

	public String get_offset_string_from_offset_minutes(int offset_minutes) {
		return (String) call("get_offset_string_from_offset_minutes", offset_minutes);
	}
}
