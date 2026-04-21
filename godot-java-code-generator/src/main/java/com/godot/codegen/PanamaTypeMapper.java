package com.godot.codegen;

import java.util.Map;
import java.util.Set;

/**
 * Maps C type strings from gdextension_interface.json to Panama ValueLayout
 * constant names used in Java source generation.
 *
 * <p>
 * Resolution chain:
 * <ol>
 * <li>Strip const/tabsat qualifiers and trailing *</li>
 * <li>Check if type is a handle → ADDRESS</li>
 * <li>Check if type is an alias → resolve recursively</li>
 * <li>Check if type is an enum → JAVA_INT</li>
 * <li>Check if type is a function pointer → ADDRESS</li>
 * <li>Check primitive types directly</li>
 * </ol>
 */
public class PanamaTypeMapper {

	private static final Set<String> VALID_LAYOUTS = Set.of("JAVA_BYTE", "JAVA_SHORT", "JAVA_INT", "JAVA_LONG",
			"JAVA_FLOAT", "JAVA_DOUBLE", "ADDRESS");

	private final Map<String, GdExtensionInterfaceParser.GdType> typeRegistry;

	public PanamaTypeMapper(Map<String, GdExtensionInterfaceParser.GdType> typeRegistry) {
		this.typeRegistry = typeRegistry;
	}

	/**
	 * Map a C type string to a Panama layout constant name.
	 *
	 * @param cType
	 *            The C type string from JSON (e.g. "GDExtensionBool", "int32_t",
	 *            "void*")
	 * @return The layout constant name (e.g. "JAVA_INT", "ADDRESS", "JAVA_LONG"),
	 *         or null for void return type
	 */
	public String mapType(String cType) {
		if (cType == null || cType.isEmpty()) {
			return null;
		}

		String resolved = cType.replace("const ", "").replace("const", "").trim();

		// void (return only)
		if ("void".equals(resolved)) {
			return null;
		}

		// Pointer types (end with *)
		if (resolved.endsWith("*")) {
			return validate("ADDRESS", cType);
		}

		// Primitive types
		switch (resolved) {
			case "bool" :
			case "uint8_t" :
			case "int8_t" :
				return validate("JAVA_BYTE", cType);
			case "uint16_t" :
			case "int16_t" :
			case "char16_t" :
				return validate("JAVA_SHORT", cType);
			case "uint32_t" :
			case "int32_t" :
			case "char32_t" :
				return validate("JAVA_INT", cType);
			case "float" :
				return validate("JAVA_FLOAT", cType);
			case "int64_t" :
			case "uint64_t" :
			case "size_t" :
				return validate("JAVA_LONG", cType);
			case "double" :
				return validate("JAVA_DOUBLE", cType);
			default :
				break;
		}

		// Look up in type registry
		GdExtensionInterfaceParser.GdType type = typeRegistry.get(resolved);
		if (type == null) {
			// Fallback: treat as pointer
			return validate("ADDRESS", cType);
		}

		switch (type.kind()) {
			case "alias" :
				// GDExtensionBool → uint8_t, but we use JAVA_INT for ABI compatibility
				if ("GDExtensionBool".equals(resolved)) {
					return validate("JAVA_INT", cType);
				}
				return mapType(type.type());
			case "handle" :
				return validate("ADDRESS", cType);
			case "enum" :
				return validate("JAVA_INT", cType);
			case "function" :
				return validate("ADDRESS", cType);
			case "struct" :
				// Structs passed by value are unusual in this API; treat as pointer
				return validate("ADDRESS", cType);
			default :
				return validate("ADDRESS", cType);
		}
	}

	/**
	 * Map a return type string. Returns null for void.
	 */
	public String mapReturnType(String cType) {
		return mapType(cType);
	}

	private String validate(String layout, String cType) {
		if (layout != null && !VALID_LAYOUTS.contains(layout)) {
			throw new IllegalStateException(
					"PanamaTypeMapper: unknown layout '" + layout + "' for C type '" + cType + "'");
		}
		return layout;
	}
}
