package com.godot.codegen;

import java.util.Map;
import java.util.Set;

final class TypedAbiModel {

	static final Set<String> BUILTIN_STRUCT_TYPES = Set.of("Vector2", "Vector2i", "Rect2", "Rect2i", "Vector3",
			"Vector3i", "Transform2D", "Vector4", "Vector4i", "Plane", "Quaternion", "AABB", "Basis", "Transform3D",
			"Projection", "Color");

	private static final Map<String, Descriptor> EXACT_TYPES = Map.ofEntries(
			entry("bool", new Descriptor("Bool", param -> "java.lang.Boolean.valueOf(" + param + ")", "boolean")),
			entry("RID", new Descriptor("Rid", param -> "java.lang.Long.valueOf(" + param + ")", "long")),
			entry("String", new Descriptor("String", param -> "typedStringArg(" + param + ")", "String")),
			entry("StringName", new Descriptor("StringName", param -> "typedStringNameArg(" + param + ")", "String")),
			entry("NodePath", new Descriptor("NodePath", param -> "typedNodePathArg(" + param + ")", "String")),
			entry("Variant", new Descriptor("Variant", param -> "typedVariantArg(" + param + ")", null)),
			entry("Array", new Descriptor("Array", param -> "typedArrayArg(" + param + ")", "GodotArray")),
			entry("Dictionary",
					new Descriptor("Dictionary", param -> "typedDictionaryArg(" + param + ")", "GodotDictionary")),
			entry("Callable", new Descriptor(null, param -> "typedCallableArg(" + param + ")", "Callable")),
			entry("Signal", new Descriptor(null, param -> "typedSignalArg(" + param + ")", "Signal")),
			entry("PackedByteArray",
					new Descriptor("PackedByteArray", param -> "typedPackedByteArrayArg(" + param + ")", "byte[]")),
			entry("PackedInt32Array",
					new Descriptor("PackedInt32Array", param -> "typedPackedInt32ArrayArg(" + param + ")", "int[]")),
			entry("PackedInt64Array",
					new Descriptor("PackedInt64Array", param -> "typedPackedInt64ArrayArg(" + param + ")", "long[]")),
			entry("PackedFloat32Array",
					new Descriptor("PackedFloat32Array", param -> "typedPackedFloat32ArrayArg(" + param + ")",
							"double[]")),
			entry("PackedFloat64Array",
					new Descriptor("PackedFloat64Array", param -> "typedPackedFloat64ArrayArg(" + param + ")",
							"double[]")),
			entry("PackedStringArray",
					new Descriptor("PackedStringArray", param -> "typedPackedStringArrayArg(" + param + ")",
							"String[]")),
			entry("PackedVector2Array",
					new Descriptor("PackedVector2Array", param -> "typedPackedVector2ArrayArg(" + param + ")",
							"double[][]")),
			entry("PackedVector3Array",
					new Descriptor("PackedVector3Array", param -> "typedPackedVector3ArrayArg(" + param + ")",
							"double[][]")),
			entry("PackedVector4Array",
					new Descriptor("PackedVector4Array", param -> "typedPackedVector4ArrayArg(" + param + ")",
							"double[][]")),
			entry("PackedColorArray", new Descriptor("PackedColorArray",
					param -> "typedPackedColorArrayArg(" + param + ")", "double[][]")));

	private TypedAbiModel() {
	}

	static Descriptor descriptor(String type, String meta) {
		if (type == null || type.isEmpty()) {
			return new Descriptor("Void", null, "void");
		}
		if (type.startsWith("enum::") || type.startsWith("bitfield::")) {
			return new Descriptor("Int32", param -> "java.lang.Integer.valueOf(" + param + ")", "int", null);
		}
		if (type.startsWith("typedarray::")) {
			return typedArrayDescriptor(type.substring("typedarray::".length()));
		}
		if (type.startsWith("typeddictionary::")) {
			return new Descriptor("Dictionary", param -> "typedDictionaryArg(" + param + ")", "GodotDictionary");
		}
		if ("int".equals(type)) {
			return integerDescriptor(meta);
		}
		if ("float".equals(type)) {
			return floatDescriptor(meta);
		}
		if (BUILTIN_STRUCT_TYPES.contains(type)) {
			return new Descriptor(type, param -> param, type);
		}
		return EXACT_TYPES.get(type);
	}

	private static Descriptor integerDescriptor(String meta) {
		if ("int8".equals(meta)) {
			return new Descriptor("Int8", param -> "typedInt8Arg(" + param + ")", "byte");
		}
		if ("uint8".equals(meta)) {
			return new Descriptor("Uint8", param -> "typedUint8Arg(" + param + ")", "short");
		}
		if ("int16".equals(meta)) {
			return new Descriptor("Int16", param -> "typedInt16Arg(" + param + ")", "short");
		}
		if ("uint16".equals(meta)) {
			return new Descriptor("Uint16", param -> "typedUint16Arg(" + param + ")", "int");
		}
		if ("int32".equals(meta)) {
			return new Descriptor("Int32", param -> "java.lang.Integer.valueOf((int) " + param + ")", "int");
		}
		if ("uint32".equals(meta)) {
			return new Descriptor("Uint32", param -> "typedUint32Arg(" + param + ")", "long");
		}
		if ("uint64".equals(meta)) {
			return new Descriptor("Uint64", param -> "typedUint64Arg(" + param + ")", "java.math.BigInteger");
		}
		if (meta == null || meta.isEmpty() || "int64".equals(meta)) {
			return new Descriptor("Int64", param -> "java.lang.Long.valueOf(" + param + ")", "long");
		}
		return null;
	}

	private static Descriptor typedArrayDescriptor(String elementType) {
		return new Descriptor("Array", param -> "typedArrayArg(" + param + ")", "GodotArray");
	}

	private static Descriptor floatDescriptor(String meta) {
		if ("float".equals(meta) || "float32".equals(meta)) {
			return new Descriptor("Float32", param -> "java.lang.Float.valueOf((float) " + param + ")", "float");
		}
		if (meta == null || meta.isEmpty() || "double".equals(meta) || "float64".equals(meta)) {
			return new Descriptor("Float64", param -> "java.lang.Double.valueOf(" + param + ")", "double");
		}
		return null;
	}

	private static Map.Entry<String, Descriptor> entry(String key, Descriptor value) {
		return Map.entry(key, value);
	}

	record Descriptor(String returnHelperSuffix, ArgExpression argExpression, String returnPropertyJavaType,
			String argumentPropertyJavaType) {
		Descriptor(String returnHelperSuffix, ArgExpression argExpression, String propertyJavaType) {
			this(returnHelperSuffix, argExpression, propertyJavaType, propertyJavaType);
		}

		boolean supportsReturn() {
			return returnHelperSuffix != null;
		}

		boolean supportsArgument() {
			return argExpression != null;
		}

		String arg(String paramName) {
			return argExpression.expression(paramName);
		}

		boolean returnCompatibleWithProperty(String javaType) {
			if (returnPropertyJavaType == null) {
				return false;
			}
			if ("byte".equals(returnPropertyJavaType)) {
				return "byte".equals(javaType) || "long".equals(javaType);
			}
			if ("short".equals(returnPropertyJavaType)) {
				return "short".equals(javaType) || "long".equals(javaType);
			}
			if ("int".equals(returnPropertyJavaType)) {
				return "int".equals(javaType) || "long".equals(javaType);
			}
			if ("long".equals(returnPropertyJavaType)) {
				return "long".equals(javaType);
			}
			if ("float".equals(returnPropertyJavaType)) {
				return "float".equals(javaType) || "double".equals(javaType);
			}
			if ("GodotArray".equals(returnPropertyJavaType)) {
				return javaType.startsWith("GodotArray");
			}
			if ("GodotDictionary".equals(returnPropertyJavaType)) {
				return javaType.startsWith("GodotDictionary");
			}
			return returnPropertyJavaType.equals(javaType);
		}

		boolean argumentCompatibleWithProperty(String javaType) {
			if (argumentPropertyJavaType == null) {
				return false;
			}
			if ("java.math.BigInteger".equals(argumentPropertyJavaType)) {
				return "java.math.BigInteger".equals(javaType) || "long".equals(javaType);
			}
			if ("byte".equals(argumentPropertyJavaType) || "short".equals(argumentPropertyJavaType)
					|| "int".equals(argumentPropertyJavaType) || "long".equals(argumentPropertyJavaType)) {
				return "byte".equals(javaType) || "short".equals(javaType) || "int".equals(javaType)
						|| "long".equals(javaType);
			}
			if ("float".equals(argumentPropertyJavaType) || "double".equals(argumentPropertyJavaType)) {
				return "float".equals(javaType) || "double".equals(javaType);
			}
			if ("GodotArray".equals(argumentPropertyJavaType)) {
				return javaType.startsWith("GodotArray");
			}
			if ("GodotDictionary".equals(argumentPropertyJavaType)) {
				return javaType.startsWith("GodotDictionary");
			}
			return argumentPropertyJavaType.equals(javaType);
		}
	}

	private static boolean isIntegral(String javaType) {
		return "byte".equals(javaType) || "short".equals(javaType) || "int".equals(javaType) || "long".equals(javaType);
	}

	private interface ArgExpression {
		String expression(String paramName);
	}
}
