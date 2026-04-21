package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;
import org.godot.GodotObject;
import org.godot.collection.GodotDictionary;

public class ClassDB extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("class_call_static", 3344196419L),
			java.util.Map.entry("class_get_method_argument_count", 3885694822L),
			java.util.Map.entry("class_get_enum_constants", 661528303L),
			java.util.Map.entry("class_get_signal_list", 3504980660L),
			java.util.Map.entry("is_class_enum_bitfield", 3860701026L),
			java.util.Map.entry("class_get_method_list", 3504980660L), java.util.Map.entry("instantiate", 2760726917L),
			java.util.Map.entry("class_has_signal", 471820014L),
			java.util.Map.entry("class_get_integer_constant_enum", 2457504236L),
			java.util.Map.entry("class_get_property_getter", 3770832642L),
			java.util.Map.entry("class_set_property", 1690314931L),
			java.util.Map.entry("class_get_api_type", 2475317043L),
			java.util.Map.entry("class_get_signal", 3061114238L),
			java.util.Map.entry("class_get_property", 2498641674L),
			java.util.Map.entry("class_get_property_list", 3504980660L),
			java.util.Map.entry("class_get_enum_list", 3031669221L),
			java.util.Map.entry("get_parent_class", 1965194235L), java.util.Map.entry("class_has_method", 3860701026L),
			java.util.Map.entry("class_get_integer_constant", 2419549490L),
			java.util.Map.entry("get_inheriters_from_class", 1761182771L),
			java.util.Map.entry("class_get_integer_constant_list", 3031669221L),
			java.util.Map.entry("is_parent_class", 471820014L),
			java.util.Map.entry("class_get_property_setter", 3770832642L),
			java.util.Map.entry("class_has_integer_constant", 471820014L),
			java.util.Map.entry("class_has_enum", 3860701026L), java.util.Map.entry("get_class_list", 1139954409L),
			java.util.Map.entry("is_class_enabled", 2619796661L),
			java.util.Map.entry("class_get_property_default_value", 2718203076L),
			java.util.Map.entry("class_exists", 2619796661L), java.util.Map.entry("can_instantiate", 2619796661L));

	ClassDB(MemorySegment nativePointer) {
		super(nativePointer);
	}

	ClassDB(long nativePointer) {
		super(nativePointer);
	}

	public String[] get_inheriters_from_class(String class_) {
		return (String[]) super.call("get_inheriters_from_class", new java.lang.Object[]{(java.lang.Object) class_});
	}

	public String get_parent_class(String class_) {
		return (String) super.call("get_parent_class", new java.lang.Object[]{(java.lang.Object) class_});
	}

	public boolean class_exists(String class_) {
		return (boolean) super.call("class_exists", new java.lang.Object[]{(java.lang.Object) class_});
	}

	public boolean is_parent_class(String class_, String inherits) {
		return (boolean) super.call("is_parent_class",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) inherits});
	}

	public boolean can_instantiate(String class_) {
		return (boolean) super.call("can_instantiate", new java.lang.Object[]{(java.lang.Object) class_});
	}

	public Object instantiate(String class_) {
		return (Object) super.call("instantiate", new java.lang.Object[]{(java.lang.Object) class_});
	}

	public int class_get_api_type(String class_) {
		return (int) super.call("class_get_api_type", new java.lang.Object[]{(java.lang.Object) class_});
	}

	public boolean class_has_signal(String class_, String signal) {
		return (boolean) super.call("class_has_signal",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) signal});
	}

	public GodotDictionary class_get_signal(String class_, String signal) {
		return (GodotDictionary) super.call("class_get_signal",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) signal});
	}

	public GodotDictionary[] class_get_signal_list(String class_, boolean no_inheritance) {
		return (GodotDictionary[]) super.call("class_get_signal_list",
				new java.lang.Object[]{(java.lang.Object) class_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public GodotDictionary[] class_get_property_list(String class_, boolean no_inheritance) {
		return (GodotDictionary[]) super.call("class_get_property_list",
				new java.lang.Object[]{(java.lang.Object) class_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public String class_get_property_getter(String class_, String property) {
		return (String) super.call("class_get_property_getter",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) property});
	}

	public String class_get_property_setter(String class_, String property) {
		return (String) super.call("class_get_property_setter",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) property});
	}

	public Object class_get_property(GodotObject object, String property) {
		return (Object) super.call("class_get_property",
				new java.lang.Object[]{(java.lang.Object) object, (java.lang.Object) property});
	}

	public int class_set_property(GodotObject object, String property, Object value) {
		return (int) super.call("class_set_property", new java.lang.Object[]{(java.lang.Object) object,
				(java.lang.Object) property, (java.lang.Object) value});
	}

	public Object class_get_property_default_value(String class_, String property) {
		return (Object) super.call("class_get_property_default_value",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) property});
	}

	public boolean class_has_method(String class_, String method, boolean no_inheritance) {
		return (boolean) super.call("class_has_method", new java.lang.Object[]{(java.lang.Object) class_,
				(java.lang.Object) method, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public int class_get_method_argument_count(String class_, String method, boolean no_inheritance) {
		return (int) super.call("class_get_method_argument_count", new java.lang.Object[]{(java.lang.Object) class_,
				(java.lang.Object) method, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public GodotDictionary[] class_get_method_list(String class_, boolean no_inheritance) {
		return (GodotDictionary[]) super.call("class_get_method_list",
				new java.lang.Object[]{(java.lang.Object) class_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public Object class_call_static(String class_, String method) {
		return (Object) super.call("class_call_static",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) method});
	}

	public String[] class_get_integer_constant_list(String class_, boolean no_inheritance) {
		return (String[]) super.call("class_get_integer_constant_list",
				new java.lang.Object[]{(java.lang.Object) class_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public boolean class_has_integer_constant(String class_, String name) {
		return (boolean) super.call("class_has_integer_constant",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) name});
	}

	public long class_get_integer_constant(String class_, String name) {
		return (long) super.call("class_get_integer_constant",
				new java.lang.Object[]{(java.lang.Object) class_, (java.lang.Object) name});
	}

	public boolean class_has_enum(String class_, String name, boolean no_inheritance) {
		return (boolean) super.call("class_has_enum", new java.lang.Object[]{(java.lang.Object) class_,
				(java.lang.Object) name, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public String[] class_get_enum_list(String class_, boolean no_inheritance) {
		return (String[]) super.call("class_get_enum_list",
				new java.lang.Object[]{(java.lang.Object) class_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public String[] class_get_enum_constants(String class_, String enum_, boolean no_inheritance) {
		return (String[]) super.call("class_get_enum_constants", new java.lang.Object[]{(java.lang.Object) class_,
				(java.lang.Object) enum_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public String class_get_integer_constant_enum(String class_, String name, boolean no_inheritance) {
		return (String) super.call("class_get_integer_constant_enum", new java.lang.Object[]{(java.lang.Object) class_,
				(java.lang.Object) name, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public boolean is_class_enum_bitfield(String class_, String enum_, boolean no_inheritance) {
		return (boolean) super.call("is_class_enum_bitfield", new java.lang.Object[]{(java.lang.Object) class_,
				(java.lang.Object) enum_, java.lang.Boolean.valueOf(no_inheritance)});
	}

	public boolean is_class_enabled(String class_) {
		return (boolean) super.call("is_class_enabled", new java.lang.Object[]{(java.lang.Object) class_});
	}
}
