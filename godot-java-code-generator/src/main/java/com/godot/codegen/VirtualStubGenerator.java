package com.godot.codegen;

import com.godot.codegen.ExtensionApiParser.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generates VirtualStubs.java for user-overridable Godot virtual methods.
 */
public final class VirtualStubGenerator {

	private static final Set<String> EXCLUDE_SUFFIXES = Set.of("Extension", "Dummy", "Virtual");
	private static final Set<String> JAVA_KEYWORDS = Set.of("abstract", "assert", "boolean", "break", "byte", "case",
			"catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
			"volatile", "while", "var", "yield", "record", "sealed", "permits", "non-sealed");

	private VirtualStubGenerator() {
	}

	public static void generate(Map<String, ClassInfo> classMap, String outputDir) throws IOException {
		List<MethodInfo> virtuals = new ArrayList<>();
		for (ClassInfo cls : classMap.values()) {
			if (!isUserRelevant(cls) || cls.methods() == null) {
				continue;
			}
			for (MethodInfo method : cls.methods()) {
				if (method.isVirtual() && method.name().startsWith("_") && !method.name().equals("_init")) {
					virtuals.add(method);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("package org.godot;\n\n");
		sb.append("import org.godot.collection.*;\n");
		sb.append("import org.godot.core.*;\n");
		sb.append("import org.godot.math.*;\n");
		sb.append("import org.godot.node.*;\n\n");
		sb.append("/**\n");
		sb.append(" * Auto-generated default stubs for user-overridable Godot virtual methods.\n");
		sb.append(" * DO NOT EDIT.\n");
		sb.append(" */\n");
		sb.append("public interface VirtualStubs {\n\n");

		Set<String> signatures = new HashSet<>();
		for (MethodInfo method : virtuals) {
			String javaName = toJavaVirtualName(method.name());
			String returnType = returnType(method);
			StringBuilder params = new StringBuilder();
			StringBuilder signatureTypes = new StringBuilder();
			Set<String> usedParamNames = new HashSet<>();
			for (int i = 0; i < method.arguments().size(); i++) {
				ArgInfo arg = method.arguments().get(i);
				String type = paramType(arg);
				String name = paramName(arg.name(), i, usedParamNames);
				if (i > 0) {
					params.append(", ");
					signatureTypes.append(",");
				}
				params.append(type).append(' ').append(name);
				signatureTypes.append(type);
			}
			String signature = javaName + "(" + signatureTypes + ")";
			if (!signatures.add(signature)) {
				continue;
			}

			sb.append("\tdefault ").append(returnType).append(' ').append(javaName).append('(').append(params)
					.append(") ");
			appendDefaultBody(sb, returnType);
			sb.append("\n\n");
		}

		sb.append("}\n");
		ApiIndexGenerator.writeFile(outputDir, "org.godot", "VirtualStubs.java", sb.toString());
		System.out.println("Generated: VirtualStubs.java (" + signatures.size() + " virtual stubs)");
	}

	private static boolean isUserRelevant(ClassInfo cls) {
		String name = cls.name();
		for (String suffix : EXCLUDE_SUFFIXES) {
			if (name.endsWith(suffix)) {
				return false;
			}
		}
		return true;
	}

	private static String returnType(MethodInfo method) {
		if (method.returnType() == null || method.returnType().isEmpty()) {
			return "void";
		}
		String metaType = TypeMapper.toJavaTypeFromMeta(method.returnMeta());
		return normalizeType(metaType != null ? metaType : TypeMapper.toJavaType(method.returnType()));
	}

	private static String paramType(ArgInfo arg) {
		String metaType = TypeMapper.toJavaTypeFromMeta(arg.meta());
		return normalizeType(metaType != null ? metaType : TypeMapper.toJavaType(arg.type()));
	}

	private static String normalizeType(String type) {
		return "Object".equals(type) ? "java.lang.Object" : type;
	}

	private static void appendDefaultBody(StringBuilder sb, String returnType) {
		if ("void".equals(returnType)) {
			sb.append("{} ");
			return;
		}
		if ("boolean".equals(returnType)) {
			sb.append("{ return false; }");
			return;
		}
		if (isNumeric(returnType)) {
			sb.append("{ return 0; }");
			return;
		}
		if ("java.math.BigInteger".equals(returnType)) {
			sb.append("{ return java.math.BigInteger.ZERO; }");
			return;
		}
		if (returnType.startsWith("GodotArray")) {
			sb.append("{ return new GodotArray(); }");
			return;
		}
		sb.append("{ return null; }");
	}

	private static boolean isNumeric(String type) {
		return "byte".equals(type) || "short".equals(type) || "int".equals(type) || "long".equals(type)
				|| "float".equals(type) || "double".equals(type);
	}

	private static String toJavaVirtualName(String godotName) {
		StringBuilder result = new StringBuilder();
		boolean upperNext = false;
		for (int i = 0; i < godotName.length(); i++) {
			char c = godotName.charAt(i);
			if (c == '_') {
				if (i == 0) {
					result.append(c);
				} else {
					upperNext = true;
				}
				continue;
			}
			if (upperNext) {
				result.append(Character.toUpperCase(c));
				upperNext = false;
			} else {
				result.append(c);
			}
		}
		String name = result.toString();
		return JAVA_KEYWORDS.contains(name) ? name + "_" : name;
	}

	private static String paramName(String godotName, int index, Set<String> usedNames) {
		String name = godotName == null || godotName.isBlank() ? "arg" + index : toJavaParamName(godotName);
		if (JAVA_KEYWORDS.contains(name)) {
			name += "_";
		}
		String unique = name;
		int suffix = 1;
		while (!usedNames.add(unique)) {
			unique = name + suffix++;
		}
		return unique;
	}

	private static String toJavaParamName(String godotName) {
		StringBuilder result = new StringBuilder();
		boolean upperNext = false;
		for (int i = 0; i < godotName.length(); i++) {
			char c = godotName.charAt(i);
			if (c == '_' || c == '/' || c == '-' || c == '.') {
				upperNext = result.length() > 0;
				continue;
			}
			if (!Character.isJavaIdentifierPart(c)) {
				continue;
			}
			if (result.isEmpty()) {
				if (!Character.isJavaIdentifierStart(c)) {
					result.append("arg");
				}
				result.append(Character.toLowerCase(c));
			} else if (upperNext) {
				result.append(Character.toUpperCase(c));
				upperNext = false;
			} else {
				result.append(c);
			}
		}
		return result.isEmpty() ? "arg" : result.toString();
	}
}
