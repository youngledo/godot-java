package com.godot.codegen;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps Godot types to Java types.
 */
public class TypeMapper {

	private static final Map<String, String> TYPE_MAP = new HashMap<>();

	static {
		// Primitive types
		TYPE_MAP.put("void", "void");
		TYPE_MAP.put("bool", "boolean");
		TYPE_MAP.put("int", "long");
		TYPE_MAP.put("float", "double");
		TYPE_MAP.put("String", "String");
		TYPE_MAP.put("StringName", "String");
		TYPE_MAP.put("NodePath", "String");

		// Built-in math types (using proper math classes)
		TYPE_MAP.put("Vector2", "Vector2");
		TYPE_MAP.put("Vector2i", "Vector2i");
		TYPE_MAP.put("Vector3", "Vector3");
		TYPE_MAP.put("Vector3i", "Vector3i");
		TYPE_MAP.put("Vector4", "Vector4");
		TYPE_MAP.put("Vector4i", "Vector4i");
		TYPE_MAP.put("Rect2", "Rect2");
		TYPE_MAP.put("Rect2i", "Rect2i");
		TYPE_MAP.put("Plane", "Plane");
		TYPE_MAP.put("Quaternion", "Quaternion");
		TYPE_MAP.put("AABB", "AABB");
		TYPE_MAP.put("Basis", "Basis");
		TYPE_MAP.put("Transform2D", "Transform2D");
		TYPE_MAP.put("Transform3D", "Transform3D");
		TYPE_MAP.put("Projection", "Projection");
		TYPE_MAP.put("Color", "Color");

		// Collections
		TYPE_MAP.put("Array", "GodotArray");
		TYPE_MAP.put("Dictionary", "GodotDictionary");
		TYPE_MAP.put("PackedByteArray", "byte[]");
		TYPE_MAP.put("PackedInt32Array", "int[]");
		TYPE_MAP.put("PackedInt64Array", "long[]");
		TYPE_MAP.put("PackedFloat32Array", "double[]");
		TYPE_MAP.put("PackedFloat64Array", "double[]");
		TYPE_MAP.put("PackedStringArray", "String[]");
		TYPE_MAP.put("PackedVector2Array", "double[][]");
		TYPE_MAP.put("PackedVector3Array", "double[][]");
		TYPE_MAP.put("PackedColorArray", "double[][]");

		// Special types
		TYPE_MAP.put("Variant", "Object");
		TYPE_MAP.put("Object", "GodotObject");
		TYPE_MAP.put("Callable", "Callable");
		TYPE_MAP.put("Signal", "Signal");
		TYPE_MAP.put("RID", "long");

		// Typed arrays
		TYPE_MAP.put("typedarray::String", "String[]");
		TYPE_MAP.put("typedarray::Vector2", "double[][]");
		TYPE_MAP.put("typedarray::Vector3", "double[][]");
	}

	private static final Map<String, String> META_TYPE_MAP = new HashMap<>();

	static {
		META_TYPE_MAP.put("int8", "byte");
		META_TYPE_MAP.put("uint8", "short");
		META_TYPE_MAP.put("int16", "short");
		META_TYPE_MAP.put("uint16", "int");
		META_TYPE_MAP.put("int32", "int");
		META_TYPE_MAP.put("uint32", "long");
		META_TYPE_MAP.put("int64", "long");
		META_TYPE_MAP.put("uint64", "java.math.BigInteger");
		META_TYPE_MAP.put("float32", "float");
		META_TYPE_MAP.put("double", "double");
	}

	/**
	 * Map Godot type to Java type.
	 */
	public static String toJavaType(String godotType) {
		if (godotType == null || godotType.isEmpty()) {
			return "Object";
		}

		// Handle bitfield types BEFORE stripping namespace prefix
		// "bitfield::TextServer.JustificationFlag" -> "int"
		if (godotType.startsWith("bitfield::")) {
			return "int";
		}

		// Handle enum types BEFORE stripping namespace prefix
		// "enum::Error" or "enum::AudioStreamInteractive.AutoAdvanceMode" -> "int"
		if (godotType.startsWith("enum::")) {
			return "int";
		}

		// Handle typed arrays: "typedarray::String" -> String[]
		if (godotType.startsWith("typedarray::")) {
			String innerType = godotType.substring("typedarray::".length());
			// Handle empty inner type (e.g., "typedarray::" with nothing after it)
			if (innerType.isEmpty()) {
				return "Object[]";
			}
			String javaInner = toJavaType(innerType);
			// javaInner may be empty or non-Java-identifier if innerType was something
			// like "27/0:" (numeric class ID) where indexOf(':') lands on the trailing
			// colon, leaving an invalid identifier — fall back to Object[]
			if (javaInner.isEmpty() || !isValidJavaIdentifier(javaInner)) {
				return "Object[]";
			}
			return javaInner + "[]";
		}

		// Handle namespaced Godot types: "24/17:RichTextEffect" -> "RichTextEffect"
		// These prefixes appear in typed arrays and custom types in extension_api.json
		if (godotType.contains(":")) {
			// Handle typeddictionary: "typeddictionary::int;String" -> Object
			if (godotType.startsWith("typeddictionary::")) {
				return "Object";
			}
			int colonIdx = godotType.indexOf(':');
			String stripped = godotType.substring(colonIdx + 1);
			// If stripping the prefix leaves something meaningful, use it.
			// Otherwise (e.g. "27/0:" -> ""), the colon was likely a trailing
			// marker, not a namespace separator — keep godotType as-is.
			if (!stripped.isEmpty()) {
				godotType = stripped;
			}
		}

		// Strip C++ qualifiers: "const void*" -> "void*", "const Object*" -> "Object*"
		godotType = godotType.replace("const ", "");

		// Strip pointer asterisk: "void*" -> "Object", "Object*" -> "Object"
		if (godotType.endsWith("*")) {
			// Pointer to unknown type -> use Object
			return "Object";
		}

		// Handle nested Godot enums/classes:
		// "AudioStreamInteractive.TransitionFromTime"
		// -> "AudioStreamInteractive_TransitionFromTime" (dots are illegal in Java
		// identifiers)
		if (godotType.contains(".")) {
			godotType = godotType.replace('.', '_');
		}

		// Check exact match first
		if (TYPE_MAP.containsKey(godotType)) {
			return TYPE_MAP.get(godotType);
		}

		// For Godot classes, return the class name as-is (they become Java classes)
		return godotType;
	}

	/**
	 * Map meta type to Java type (used for numeric meta types).
	 */
	public static String toJavaTypeFromMeta(String meta) {
		if (meta == null || meta.isEmpty()) {
			return null;
		}
		return META_TYPE_MAP.get(meta);
	}

	/**
	 * Check if a type is a Godot class (not a built-in type).
	 */
	public static boolean isGodotClass(String godotType) {
		if (godotType == null || godotType.isEmpty()) {
			return false;
		}
		// Skip special prefixes
		if (godotType.startsWith("enum::") || godotType.startsWith("typedarray::")) {
			return false;
		}
		// Check if it's a known built-in type
		return !TYPE_MAP.containsKey(godotType);
	}

	/**
	 * Get the Java parameter type, considering both type and meta.
	 */
	public static String getJavaParamType(String type, String meta) {
		if (meta != null && !meta.isEmpty()) {
			String metaType = toJavaTypeFromMeta(meta);
			if (metaType != null) {
				return metaType;
			}
		}
		return toJavaType(type);
	}

	/**
	 * Check if a string is a valid Java identifier. Used to validate type names
	 * before using them in generated code.
	 */
	private static boolean isValidJavaIdentifier(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		if (!Character.isJavaIdentifierStart(s.charAt(0))) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if (!Character.isJavaIdentifierPart(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
