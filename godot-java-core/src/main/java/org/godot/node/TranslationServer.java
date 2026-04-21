package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.Godot;

public class TranslationServer extends Godot {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("standardize_locale", 4216441673L), java.util.Map.entry("translate_plural", 229954002L),
			java.util.Map.entry("get_or_add_domain", 397200075L), java.util.Map.entry("get_tool_locale", 2841200299L),
			java.util.Map.entry("format_number", 315676799L), java.util.Map.entry("has_domain", 2619796661L),
			java.util.Map.entry("reload_pseudolocalization", 3218959716L),
			java.util.Map.entry("translate", 1829228469L), java.util.Map.entry("get_translation_object", 2065240175L),
			java.util.Map.entry("is_pseudolocalization_enabled", 36873697L),
			java.util.Map.entry("get_loaded_locales", 1139954409L), java.util.Map.entry("set_locale", 83702148L),
			java.util.Map.entry("get_language_name", 3135753539L), java.util.Map.entry("compare_locales", 2878152881L),
			java.util.Map.entry("parse_number", 315676799L), java.util.Map.entry("get_percent_sign", 3135753539L),
			java.util.Map.entry("get_all_languages", 1139954409L),
			java.util.Map.entry("find_translations", 2109650934L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("remove_translation", 1466479800L),
			java.util.Map.entry("has_translation_for_locale", 2034713381L),
			java.util.Map.entry("set_pseudolocalization_enabled", 2586408642L),
			java.util.Map.entry("get_plural_rules", 3135753539L), java.util.Map.entry("pseudolocalize", 1965194235L),
			java.util.Map.entry("get_country_name", 3135753539L), java.util.Map.entry("has_translation", 2696976312L),
			java.util.Map.entry("get_script_name", 3135753539L), java.util.Map.entry("remove_domain", 3304788590L),
			java.util.Map.entry("get_all_scripts", 1139954409L), java.util.Map.entry("get_locale", 201670096L),
			java.util.Map.entry("add_translation", 1466479800L), java.util.Map.entry("get_all_countries", 1139954409L),
			java.util.Map.entry("get_locale_name", 3135753539L), java.util.Map.entry("get_translations", 3995934104L));

	TranslationServer(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TranslationServer(long nativePointer) {
		super(nativePointer);
	}

	public int compare_locales(String locale_a, String locale_b) {
		return (int) super.call("compare_locales",
				new java.lang.Object[]{(java.lang.Object) locale_a, (java.lang.Object) locale_b});
	}

	public String standardize_locale(String locale, boolean add_defaults) {
		return (String) super.call("standardize_locale",
				new java.lang.Object[]{(java.lang.Object) locale, java.lang.Boolean.valueOf(add_defaults)});
	}

	public String get_language_name(String language) {
		return (String) super.call("get_language_name", new java.lang.Object[]{(java.lang.Object) language});
	}

	public String get_script_name(String script) {
		return (String) super.call("get_script_name", new java.lang.Object[]{(java.lang.Object) script});
	}

	public String get_country_name(String country) {
		return (String) super.call("get_country_name", new java.lang.Object[]{(java.lang.Object) country});
	}

	public String get_locale_name(String locale) {
		return (String) super.call("get_locale_name", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public String get_plural_rules(String locale) {
		return (String) super.call("get_plural_rules", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public String translate(String message, String context) {
		return (String) super.call("translate",
				new java.lang.Object[]{(java.lang.Object) message, (java.lang.Object) context});
	}

	public String translate_plural(String message, String plural_message, long n, String context) {
		return (String) super.call("translate_plural", new java.lang.Object[]{(java.lang.Object) message,
				(java.lang.Object) plural_message, java.lang.Long.valueOf(n), (java.lang.Object) context});
	}

	public void add_translation(Translation translation) {
		super.call("add_translation", new java.lang.Object[]{(java.lang.Object) translation});
	}

	public void remove_translation(Translation translation) {
		super.call("remove_translation", new java.lang.Object[]{(java.lang.Object) translation});
	}

	public Translation get_translation_object(String locale) {
		return (Translation) super.call("get_translation_object", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public Translation[] find_translations(String locale, boolean exact) {
		return (Translation[]) super.call("find_translations",
				new java.lang.Object[]{(java.lang.Object) locale, java.lang.Boolean.valueOf(exact)});
	}

	public boolean has_translation_for_locale(String locale, boolean exact) {
		return (boolean) super.call("has_translation_for_locale",
				new java.lang.Object[]{(java.lang.Object) locale, java.lang.Boolean.valueOf(exact)});
	}

	public boolean has_translation(Translation translation) {
		return (boolean) super.call("has_translation", new java.lang.Object[]{(java.lang.Object) translation});
	}

	public boolean has_domain(String domain) {
		return (boolean) super.call("has_domain", new java.lang.Object[]{(java.lang.Object) domain});
	}

	public TranslationDomain get_or_add_domain(String domain) {
		return (TranslationDomain) super.call("get_or_add_domain", new java.lang.Object[]{(java.lang.Object) domain});
	}

	public void remove_domain(String domain) {
		super.call("remove_domain", new java.lang.Object[]{(java.lang.Object) domain});
	}

	public void clear() {
		super.call("clear");
	}

	public String format_number(String number, String locale) {
		return (String) super.call("format_number",
				new java.lang.Object[]{(java.lang.Object) number, (java.lang.Object) locale});
	}

	public String get_percent_sign(String locale) {
		return (String) super.call("get_percent_sign", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public String parse_number(String number, String locale) {
		return (String) super.call("parse_number",
				new java.lang.Object[]{(java.lang.Object) number, (java.lang.Object) locale});
	}

	public boolean is_pseudolocalization_enabled() {
		return (boolean) super.call("is_pseudolocalization_enabled");
	}

	public void reload_pseudolocalization() {
		super.call("reload_pseudolocalization");
	}

	public String pseudolocalize(String message) {
		return (String) super.call("pseudolocalize", new java.lang.Object[]{(java.lang.Object) message});
	}

	public boolean isPseudolocalization_enabled() {
		return (boolean) super.call("is_pseudolocalization_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_enabled(boolean value) {
		super.call("set_pseudolocalization_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
