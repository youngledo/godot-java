package com.godot.codegen;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Generates *Extensions.java companion classes for builtin math types. Each
 * class contains static methods that dispatch through
 * BuiltinMethodCache/variant_get_ptr_builtin_method.
 */
public class BuiltinMethodGenerator {

	private static final String BUILTIN_PACKAGE = "org.godot.builtin";
	private static final String MATH_PACKAGE = "org.godot.math";
	private static final String CACHE_CLASS = "org.godot.builtin.BuiltinMethodCache";
	private static final String MH_CLASS = "java.lang.invoke.MethodHandle";
	private static final String ARENA_CLASS = "java.lang.foreign.Arena";
	private static final String MS_CLASS = "java.lang.foreign.MemorySegment";
	private static final String VL = "java.lang.foreign.ValueLayout";

	// Types that have toSegment/fromSegment methods in the hand-written code
	private static final Set<String> SEGMENT_CAPABLE_TYPES = Set.of("Vector2", "Vector2i", "Vector3", "Vector3i",
			"Vector4", "Vector4i", "Rect2", "Rect2i", "Transform2D", "Plane", "Quaternion", "AABB", "Basis",
			"Transform3D", "Color");

	// Only generate for types whose storage layout is known here.
	private static final Map<String, Integer> VARIANT_TYPE_IDS = Map.ofEntries(Map.entry("String", 4),
			Map.entry("Vector2", 5), Map.entry("Vector2i", 6), Map.entry("Rect2", 7), Map.entry("Rect2i", 8),
			Map.entry("Vector3", 9), Map.entry("Vector3i", 10), Map.entry("Transform2D", 11), Map.entry("Vector4", 12),
			Map.entry("Vector4i", 13), Map.entry("Plane", 14), Map.entry("Quaternion", 15), Map.entry("AABB", 16),
			Map.entry("Basis", 17), Map.entry("Transform3D", 18), Map.entry("Color", 20));

	private static final Map<String, Integer> TYPE_SIZES = createTypeSizes();

	private static Map<String, Integer> createTypeSizes() {
		// real_t size depends on precision: float (4) or double (8)
		int r = TypeMapper.isDoublePrecision() ? 8 : 4;
		Map<String, Integer> sizes = new HashMap<>();
		sizes.put("String", 16);
		// Math types: member count * real_t size
		sizes.put("Vector2", 2 * r);
		sizes.put("Vector2i", 8);
		sizes.put("Vector3", 3 * r);
		sizes.put("Vector3i", 12);
		sizes.put("Vector4", 4 * r);
		sizes.put("Vector4i", 16);
		sizes.put("Rect2", 2 * 2 * r); // 2 * Vector2
		sizes.put("Rect2i", 16);
		sizes.put("Transform2D", 3 * 2 * r); // 3 * Vector2
		sizes.put("Plane", 4 * r);
		sizes.put("Quaternion", 4 * r);
		sizes.put("AABB", 2 * 3 * r); // 2 * Vector3
		sizes.put("Basis", 3 * 3 * r); // 3 * Vector3
		sizes.put("Transform3D", 3 * 3 * r + 3 * r); // Basis + Vector3
		sizes.put("Color", 4 * r);
		sizes.put("bool", 1);
		sizes.put("int", 8);
		sizes.put("float", r); // Godot real_t
		sizes.put("double", 8);
		return Map.copyOf(sizes);
	}

	public static void generate(List<BuiltinClassInfo> builtinClasses, String outputDir) throws IOException {
		for (BuiltinClassInfo bc : builtinClasses) {
			if (bc.methods() == null || bc.methods().isEmpty()) {
				continue;
			}
			if (!VARIANT_TYPE_IDS.containsKey(bc.name())) {
				continue;
			}

			List<BuiltinMethodInfo> methods = new ArrayList<>();
			for (BuiltinMethodInfo m : bc.methods()) {
				if (m.isVararg()) {
					continue;
				}
				// Skip methods whose return type is not supported
				String retType = m.returnType();
				if (retType != null && !retType.isEmpty() && !retType.equals("void") && !retType.equals("bool")
						&& !retType.equals("int") && !retType.equals("float") && !retType.equals("double")
						&& !SEGMENT_CAPABLE_TYPES.contains(retType)) {
					continue;
				}
				// Skip methods with unsupported argument types
				boolean hasUnsupportedArg = false;
				for (ArgInfo arg : m.arguments()) {
					String argType = arg.type();
					if (!argType.equals("bool") && !argType.equals("int") && !argType.equals("float")
							&& !argType.equals("double") && !SEGMENT_CAPABLE_TYPES.contains(argType)) {
						hasUnsupportedArg = true;
						break;
					}
				}
				if (hasUnsupportedArg) {
					continue;
				}
				methods.add(m);
			}
			if (methods.isEmpty()) {
				continue;
			}

			TypeSpec.Builder classBuilder = TypeSpec.classBuilder(bc.name() + "Extensions")
					.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
					.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build());

			int variantType = VARIANT_TYPE_IDS.get(bc.name());
			int selfSize = TYPE_SIZES.getOrDefault(bc.name(), 24);

			for (BuiltinMethodInfo method : methods) {
				addBuiltinMethod(classBuilder, bc, method, variantType, selfSize);
			}

			JavaFile javaFile = JavaFile.builder(BUILTIN_PACKAGE, classBuilder.build()).skipJavaLangImports(true)
					.indent("\t").build();

			Path packageDir = Path.of(outputDir, BUILTIN_PACKAGE.replace('.', '/'));
			Files.createDirectories(packageDir);
			Path filePath = packageDir.resolve(bc.name() + "Extensions.java");
			try (var writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
				javaFile.writeTo(writer);
			}
		}
	}

	private static void addBuiltinMethod(TypeSpec.Builder classBuilder, BuiltinClassInfo bc, BuiltinMethodInfo method,
			int variantType, int selfSize) {
		String javaMethodName = toJavaMethodName(method.name());
		boolean isStatic = method.isStatic();
		String selfType = bc.name();

		MethodSpec.Builder mb = MethodSpec.methodBuilder(javaMethodName).addModifiers(Modifier.PUBLIC, Modifier.STATIC);

		if (!isStatic) {
			if (selfType.equals("String")) {
				mb.addParameter(String.class, "self");
			} else {
				mb.addParameter(ClassName.get(MATH_PACKAGE, selfType), "self");
			}
		}

		// Build parameter info
		List<String> paramNames = new ArrayList<>();
		List<String> paramJavaTypes = new ArrayList<>();
		List<String> paramGodotTypes = new ArrayList<>();
		for (ArgInfo arg : method.arguments()) {
			String javaType = TypeMapper.toJavaType(arg.type());
			String javaName = toJavaParamName(arg.name());
			mb.addParameter(toTypeName(javaType), javaName);
			paramNames.add(javaName);
			paramJavaTypes.add(javaType);
			paramGodotTypes.add(arg.type());
		}

		int argc = paramNames.size();
		String returnType = method.returnType();
		boolean hasReturn = returnType != null && !returnType.isEmpty() && !returnType.equals("void");
		String javaRetType = hasReturn ? TypeMapper.toJavaType(returnType) : "void";

		if (hasReturn) {
			mb.returns(toTypeName(javaRetType));
		}

		// Get method handle
		mb.addStatement("$T mh = $T.getMethod($L, $S, $LL)", ClassName.bestGuess(MH_CLASS),
				ClassName.bestGuess(CACHE_CLASS), variantType, method.name(), method.hash());

		// Create arena
		mb.addStatement("$T arena = $T.ofShared()", ClassName.bestGuess(ARENA_CLASS), ClassName.bestGuess(ARENA_CLASS));

		// Allocate base segment (self value for instance methods, NULL for static)
		if (isStatic) {
			mb.addStatement("$T base = $T.NULL", ClassName.bestGuess(MS_CLASS), ClassName.bestGuess(MS_CLASS));
		} else if (selfType.equals("String")) {
			mb.addStatement("$T godotSelf = $T.fromJavaString(self)", ClassName.get("org.godot.core", "GodotString"),
					ClassName.get("org.godot.core", "GodotString"));
			mb.addStatement("$T base = godotSelf.segment()", ClassName.bestGuess(MS_CLASS));
		} else {
			mb.addStatement("$T base = arena.allocate($L, 8)", ClassName.bestGuess(MS_CLASS), selfSize);
			mb.addStatement("self.toSegment(base)");
		}

		// Allocate argument segments
		if (argc > 0) {
			mb.addStatement("$T[] argSegs = new $T[$L]", ClassName.bestGuess(MS_CLASS), ClassName.bestGuess(MS_CLASS),
					argc);
			for (int i = 0; i < argc; i++) {
				int argSize = TYPE_SIZES.getOrDefault(paramGodotTypes.get(i), 24);
				mb.addStatement("argSegs[$L] = arena.allocate($L, 8)", i, argSize);
				addWriteSegment(mb, i, paramNames.get(i), paramJavaTypes.get(i), paramGodotTypes.get(i));
			}
			// Build pointer array
			mb.addStatement("$T argPtrs = arena.allocate((long) $L * 8, 8)", ClassName.bestGuess(MS_CLASS), argc);
			for (int i = 0; i < argc; i++) {
				mb.addStatement("argPtrs.set($T.ADDRESS, (long) $L * 8, argSegs[$L])", ClassName.bestGuess(VL), i, i);
			}
		}

		// Allocate return segment
		if (hasReturn) {
			int retSize = TYPE_SIZES.getOrDefault(returnType, 24);
			mb.addStatement("$T retSeg = arena.allocate($L, 8)", ClassName.bestGuess(MS_CLASS), retSize);
		} else {
			mb.addStatement("$T retSeg = $T.NULL", ClassName.bestGuess(MS_CLASS), ClassName.bestGuess(MS_CLASS));
		}

		// Call
		if (argc > 0) {
			mb.addStatement("$T.invoke(mh, base, argPtrs, retSeg, $L)", ClassName.bestGuess(CACHE_CLASS), argc);
		} else {
			mb.addStatement("$T.invoke(mh, base, $T.NULL, retSeg, 0)", ClassName.bestGuess(CACHE_CLASS),
					ClassName.bestGuess(MS_CLASS));
		}

		// Read return value
		if (hasReturn) {
			mb.addStatement("return " + readSegment("retSeg", javaRetType, returnType));
		}

		classBuilder.addMethod(mb.build());
	}

	private static void addWriteSegment(MethodSpec.Builder mb, int index, String varName, String javaType,
			String godotType) {
		// For builtin math types, use toSegment
		if (TYPE_SIZES.containsKey(godotType) && !godotType.equals("bool") && !godotType.equals("int")
				&& !godotType.equals("float") && !godotType.equals("double") && !godotType.equals("String")) {
			mb.addStatement("$L.toSegment(argSegs[$L])", varName, index);
			return;
		}
		switch (javaType) {
			case "double" :
				mb.addStatement("argSegs[$L].set($T.JAVA_DOUBLE, 0, $L)", index, ClassName.bestGuess(VL), varName);
				break;
			case "float" :
				mb.addStatement("argSegs[$L].set($T.JAVA_FLOAT, 0, $L)", index, ClassName.bestGuess(VL), varName);
				break;
			case "long" :
				mb.addStatement("argSegs[$L].set($T.JAVA_LONG, 0, $L)", index, ClassName.bestGuess(VL), varName);
				break;
			case "int" :
				mb.addStatement("argSegs[$L].set($T.JAVA_INT, 0, $L)", index, ClassName.bestGuess(VL), varName);
				break;
			case "boolean" :
				mb.addStatement("argSegs[$L].set($T.JAVA_BYTE, 0, (byte)($L ? 1 : 0))", index, ClassName.bestGuess(VL),
						varName);
				break;
			default :
				mb.addStatement("argSegs[$L].set($T.JAVA_LONG, 0, $L)", index, ClassName.bestGuess(VL), varName);
				break;
		}
	}

	private static String readSegment(String segName, String javaType, String godotType) {
		// For builtin math types with segment methods, use fromSegment
		if (SEGMENT_CAPABLE_TYPES.contains(godotType)) {
			return godotType + ".fromSegment(" + segName + ")";
		}
		switch (javaType) {
			case "double" :
				return segName + ".get(" + VL + ".JAVA_DOUBLE, 0)";
			case "float" :
				return segName + ".get(" + VL + ".JAVA_FLOAT, 0)";
			case "long" :
				return segName + ".get(" + VL + ".JAVA_LONG, 0)";
			case "int" :
				return segName + ".get(" + VL + ".JAVA_INT, 0)";
			case "boolean" :
				return segName + ".get(" + VL + ".JAVA_BYTE, 0) != 0";
			default :
				return segName + ".get(" + VL + ".JAVA_LONG, 0)";
		}
	}

	private static TypeName toTypeName(String javaType) {
		if (javaType == null || javaType.isEmpty())
			return ClassName.get("java.lang", "Object");
		switch (javaType) {
			case "void" :
				return TypeName.VOID;
			case "boolean" :
				return TypeName.BOOLEAN;
			case "byte" :
				return TypeName.BYTE;
			case "short" :
				return TypeName.SHORT;
			case "int" :
				return TypeName.INT;
			case "long" :
				return TypeName.LONG;
			case "float" :
				return TypeName.FLOAT;
			case "double" :
				return TypeName.DOUBLE;
			case "String" :
				return ClassName.get("java.lang", "String");
			default :
				if (TYPE_SIZES.containsKey(javaType) && !javaType.equals("bool") && !javaType.equals("int")
						&& !javaType.equals("float") && !javaType.equals("double")) {
					return ClassName.get(MATH_PACKAGE, javaType);
				}
				return ClassName.get("", javaType);
		}
	}

	private static String toJavaMethodName(String godotName) {
		if (!godotName.contains("_")) {
			return godotName;
		}
		StringBuilder result = new StringBuilder();
		boolean nextUpper = false;
		for (char c : godotName.toCharArray()) {
			if (c == '_') {
				nextUpper = true;
			} else if (nextUpper) {
				result.append(Character.toUpperCase(c));
				nextUpper = false;
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	private static final Set<String> JAVA_KEYWORDS = Set.of("abstract", "assert", "boolean", "break", "byte", "case",
			"catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
			"volatile", "while", "true", "false", "null");

	private static String toJavaParamName(String name) {
		if (name == null || name.isEmpty())
			return "value";
		String result = name;
		if (Character.isUpperCase(result.charAt(0)))
			result = Character.toLowerCase(result.charAt(0)) + result.substring(1);
		if (JAVA_KEYWORDS.contains(result))
			return result + "_";
		return result;
	}
}
