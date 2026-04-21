package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class TranslationDomain extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_pseudolocalization_accents_enabled", 2586408642L),
			java.util.Map.entry("get_pseudolocalization_expansion_ratio", 1740695150L),
			java.util.Map.entry("translate_plural", 229954002L),
			java.util.Map.entry("is_pseudolocalization_override_enabled", 36873697L),
			java.util.Map.entry("set_pseudolocalization_skip_placeholders_enabled", 2586408642L),
			java.util.Map.entry("get_translation_object", 606768082L), java.util.Map.entry("translate", 1829228469L),
			java.util.Map.entry("is_enabled", 36873697L),
			java.util.Map.entry("set_pseudolocalization_fake_bidi_enabled", 2586408642L),
			java.util.Map.entry("get_pseudolocalization_prefix", 201670096L),
			java.util.Map.entry("is_pseudolocalization_enabled", 36873697L),
			java.util.Map.entry("set_pseudolocalization_suffix", 83702148L),
			java.util.Map.entry("is_pseudolocalization_double_vowels_enabled", 36873697L),
			java.util.Map.entry("is_pseudolocalization_fake_bidi_enabled", 36873697L),
			java.util.Map.entry("set_pseudolocalization_prefix", 83702148L),
			java.util.Map.entry("get_pseudolocalization_suffix", 201670096L), java.util.Map.entry("clear", 3218959716L),
			java.util.Map.entry("find_translations", 2109650934L),
			java.util.Map.entry("set_pseudolocalization_override_enabled", 2586408642L),
			java.util.Map.entry("remove_translation", 1466479800L),
			java.util.Map.entry("has_translation_for_locale", 2034713381L),
			java.util.Map.entry("set_pseudolocalization_enabled", 2586408642L),
			java.util.Map.entry("set_locale_override", 83702148L),
			java.util.Map.entry("set_pseudolocalization_expansion_ratio", 373806689L),
			java.util.Map.entry("pseudolocalize", 1965194235L), java.util.Map.entry("has_translation", 2696976312L),
			java.util.Map.entry("is_pseudolocalization_skip_placeholders_enabled", 36873697L),
			java.util.Map.entry("set_enabled", 2586408642L), java.util.Map.entry("get_locale_override", 201670096L),
			java.util.Map.entry("add_translation", 1466479800L),
			java.util.Map.entry("set_pseudolocalization_double_vowels_enabled", 2586408642L),
			java.util.Map.entry("is_pseudolocalization_accents_enabled", 36873697L),
			java.util.Map.entry("get_translations", 3995934104L));

	TranslationDomain(MemorySegment nativePointer) {
		super(nativePointer);
	}

	TranslationDomain(long nativePointer) {
		super(nativePointer);
	}

	public Translation get_translation_object(String locale) {
		return (Translation) super.call("get_translation_object", new java.lang.Object[]{(java.lang.Object) locale});
	}

	public void add_translation(Translation translation) {
		super.call("add_translation", new java.lang.Object[]{(java.lang.Object) translation});
	}

	public void remove_translation(Translation translation) {
		super.call("remove_translation", new java.lang.Object[]{(java.lang.Object) translation});
	}

	public void clear() {
		super.call("clear");
	}

	public boolean has_translation_for_locale(String locale, boolean exact) {
		return (boolean) super.call("has_translation_for_locale",
				new java.lang.Object[]{(java.lang.Object) locale, java.lang.Boolean.valueOf(exact)});
	}

	public boolean has_translation(Translation translation) {
		return (boolean) super.call("has_translation", new java.lang.Object[]{(java.lang.Object) translation});
	}

	public Translation[] find_translations(String locale, boolean exact) {
		return (Translation[]) super.call("find_translations",
				new java.lang.Object[]{(java.lang.Object) locale, java.lang.Boolean.valueOf(exact)});
	}

	public String translate(String message, String context) {
		return (String) super.call("translate",
				new java.lang.Object[]{(java.lang.Object) message, (java.lang.Object) context});
	}

	public String translate_plural(String message, String message_plural, long n, String context) {
		return (String) super.call("translate_plural", new java.lang.Object[]{(java.lang.Object) message,
				(java.lang.Object) message_plural, java.lang.Long.valueOf(n), (java.lang.Object) context});
	}

	public boolean is_enabled() {
		return (boolean) super.call("is_enabled");
	}

	public boolean is_pseudolocalization_enabled() {
		return (boolean) super.call("is_pseudolocalization_enabled");
	}

	public boolean is_pseudolocalization_accents_enabled() {
		return (boolean) super.call("is_pseudolocalization_accents_enabled");
	}

	public boolean is_pseudolocalization_double_vowels_enabled() {
		return (boolean) super.call("is_pseudolocalization_double_vowels_enabled");
	}

	public boolean is_pseudolocalization_fake_bidi_enabled() {
		return (boolean) super.call("is_pseudolocalization_fake_bidi_enabled");
	}

	public boolean is_pseudolocalization_override_enabled() {
		return (boolean) super.call("is_pseudolocalization_override_enabled");
	}

	public boolean is_pseudolocalization_skip_placeholders_enabled() {
		return (boolean) super.call("is_pseudolocalization_skip_placeholders_enabled");
	}

	public String pseudolocalize(String message) {
		return (String) super.call("pseudolocalize", new java.lang.Object[]{(java.lang.Object) message});
	}

	public boolean isEnabled() {
		return (boolean) super.call("is_enabled", new java.lang.Object[0]);
	}

	public void setEnabled(boolean value) {
		super.call("set_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPseudolocalization_enabled() {
		return (boolean) super.call("is_pseudolocalization_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_enabled(boolean value) {
		super.call("set_pseudolocalization_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPseudolocalization_accents_enabled() {
		return (boolean) super.call("is_pseudolocalization_accents_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_accents_enabled(boolean value) {
		super.call("set_pseudolocalization_accents_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPseudolocalization_double_vowels_enabled() {
		return (boolean) super.call("is_pseudolocalization_double_vowels_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_double_vowels_enabled(boolean value) {
		super.call("set_pseudolocalization_double_vowels_enabled",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPseudolocalization_fake_bidi_enabled() {
		return (boolean) super.call("is_pseudolocalization_fake_bidi_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_fake_bidi_enabled(boolean value) {
		super.call("set_pseudolocalization_fake_bidi_enabled",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPseudolocalization_override_enabled() {
		return (boolean) super.call("is_pseudolocalization_override_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_override_enabled(boolean value) {
		super.call("set_pseudolocalization_override_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isPseudolocalization_skip_placeholders_enabled() {
		return (boolean) super.call("is_pseudolocalization_skip_placeholders_enabled", new java.lang.Object[0]);
	}

	public void setPseudolocalization_skip_placeholders_enabled(boolean value) {
		super.call("set_pseudolocalization_skip_placeholders_enabled",
				new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public double getPseudolocalization_expansion_ratio() {
		return (double) super.call("get_pseudolocalization_expansion_ratio", new java.lang.Object[0]);
	}

	public void setPseudolocalization_expansion_ratio(double value) {
		super.call("set_pseudolocalization_expansion_ratio", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public String getPseudolocalization_prefix() {
		return (String) super.call("get_pseudolocalization_prefix", new java.lang.Object[0]);
	}

	public void setPseudolocalization_prefix(String value) {
		super.call("set_pseudolocalization_prefix", new java.lang.Object[]{(java.lang.Object) value});
	}

	public String getPseudolocalization_suffix() {
		return (String) super.call("get_pseudolocalization_suffix", new java.lang.Object[0]);
	}

	public void setPseudolocalization_suffix(String value) {
		super.call("set_pseudolocalization_suffix", new java.lang.Object[]{(java.lang.Object) value});
	}
}
