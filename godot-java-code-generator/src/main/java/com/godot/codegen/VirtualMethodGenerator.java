package com.godot.codegen;

import java.io.IOException;
import java.util.*;

/**
 * Generates {@code VirtualMethods.java} by scanning extension_api.json for
 * virtual methods across all classes.
 *
 * <p>
 * Generates a compact reverse lookup: hash → method names. Different Godot
 * classes may assign different hashes to the same virtual method name (e.g.,
 * {@code Node._process} has a different hash than
 * {@code AudioEffectInstance._process}). All hashes are stored so the runtime
 * can match whichever hash Godot sends.
 */
public class VirtualMethodGenerator {

	public static void generate(Map<String, ClassInfo> classMap, String outputDir, String packageName)
			throws IOException {
		// Collect ALL (hash, method_name) pairs across all classes.
		// Multiple classes may have different hashes for the same method name.
		Map<Long, Set<String>> hashToNames = new LinkedHashMap<>();

		for (String className : classMap.keySet()) {
			ClassInfo cls = classMap.get(className);
			if (cls == null || cls.methods() == null) {
				continue;
			}
			for (MethodInfo method : cls.methods()) {
				if (method.isVirtual() && method.name().startsWith("_") && !method.name().equals("_init")) {
					hashToNames.computeIfAbsent(method.hash(), k -> new LinkedHashSet<>()).add(method.name());
				}
			}
		}

		Set<String> allNames = new LinkedHashSet<>();
		for (Set<String> names : hashToNames.values()) {
			allNames.addAll(names);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("/**\n");
		sb.append(" * Auto-generated virtual method definitions from extension_api.json.\n");
		sb.append(" * DO NOT EDIT.\n");
		sb.append(" *\n");
		sb.append(" * Contains a reverse lookup: compatibility hash → method names.\n");
		sb.append(" * Different Godot classes may assign different hashes to the same\n");
		sb.append(" * virtual method; all hashes are stored here.\n");
		sb.append(" */\n");
		sb.append("public final class VirtualMethods {\n\n");
		sb.append("\tprivate VirtualMethods() {}\n\n");

		sb.append("\t/** Total number of unique virtual method names. */\n");
		sb.append("\tpublic static final int COUNT = ").append(allNames.size()).append(";\n\n");

		// HASH_TO_NAMES: hash → set of method names
		sb.append(
				"\tprivate static final java.util.Map<Long, java.util.Set<String>> _HASH_TO_NAMES = new java.util.HashMap<>();\n");
		sb.append("\tstatic {\n");
		for (Map.Entry<Long, Set<String>> entry : hashToNames.entrySet()) {
			long hash = entry.getKey();
			Set<String> names = entry.getValue();
			if (names.size() == 1) {
				sb.append("\t\t_HASH_TO_NAMES.put(").append(hash).append("L, java.util.Set.of(\"")
						.append(names.iterator().next()).append("\"));\n");
			} else {
				sb.append("\t\t_HASH_TO_NAMES.put(").append(hash).append("L, java.util.Set.of(");
				boolean first = true;
				for (String name : names) {
					if (!first)
						sb.append(", ");
					sb.append("\"").append(name).append("\"");
					first = false;
				}
				sb.append("));\n");
			}
		}
		sb.append("\t}\n");
		sb.append("\t/**\n");
		sb.append("\t * Reverse lookup: compatibility hash → method names (unmodifiable).\n");
		sb.append("\t * Used by get_virtual_func to find the method name from Godot's hash.\n");
		sb.append("\t */\n");
		sb.append("\tpublic static final java.util.Map<Long, java.util.Set<String>> HASH_TO_NAMES =\n");
		sb.append("\t\t\tjava.util.Collections.unmodifiableMap(_HASH_TO_NAMES);\n");

		sb.append("}\n");

		ApiIndexGenerator.writeFile(outputDir, packageName, "VirtualMethods.java", sb.toString());
		System.out.println("Generated: VirtualMethods.java (" + allNames.size() + " virtual methods, "
				+ hashToNames.size() + " unique hashes)");
	}
}
