package com.godot.codegen;

import com.squareup.javapoet.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Generates singleton wrapper classes for Godot singletons.
 *
 * Each singleton extends its corresponding engine class in org.godot.node and
 * adds a singleton() accessor with double-checked locking.
 *
 * The singleton wrapper lives in org.godot.singleton package.
 */
public class SingletonGenerator {

	private static final String SINGLETON_PACKAGE = "org.godot.singleton";
	private static final String NODE_PACKAGE = "org.godot.node";

	/**
	 * Generate singleton classes for all given singleton entries.
	 *
	 * @param singletons
	 *            list of (name, type) pairs from extension_api.json
	 * @param classMap
	 *            parsed class data keyed by Godot class name
	 * @param outputDir
	 *            root output directory
	 */
	public static void generate(List<ExtensionApiParser.SingletonEntry> singletons, Map<String, ClassInfo> classMap,
			String outputDir) throws IOException {

		String packagePath = SINGLETON_PACKAGE.replace('.', '/');
		Path dirPath = Path.of(outputDir, packagePath);
		Files.createDirectories(dirPath);

		for (ExtensionApiParser.SingletonEntry entry : singletons) {
			String name = entry.name();
			String type = entry.type();

			// Check if the engine class exists
			if (!classMap.containsKey(type)) {
				System.out.println("Skipping singleton " + name + ": class " + type + " not found in API");
				continue;
			}

			ClassInfo classInfo = classMap.get(type);
			String source = generateSingletonClass(name, classInfo);
			Path filePath = dirPath.resolve(name + ".java");
			try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
				writer.write(source);
			}
			System.out.println("Generated singleton: " + name + ".java");
		}
	}

	private static String generateSingletonClass(String singletonName, ClassInfo classInfo) {
		StringBuilder sb = new StringBuilder();

		sb.append("package ").append(SINGLETON_PACKAGE).append(";\n\n");

		sb.append("import java.lang.foreign.MemorySegment;\n");
		sb.append("import org.godot.Godot;\n");
		sb.append("import org.godot.bridge.Bridge;\n");
		sb.append("import org.godot.core.GodotStringName;\n");
		sb.append("import org.godot.internal.api.ApiIndex;\n");
		sb.append("\n");

		sb.append("/**\n");
		sb.append(" * Singleton wrapper for Godot's ").append(singletonName).append(".\n");
		sb.append(" * Auto-generated from extension_api.json. DO NOT EDIT.\n");
		sb.append(" */\n");
		sb.append("public final class ").append(singletonName).append(" extends ").append(NODE_PACKAGE).append(".")
				.append(classInfo.name()).append(" {\n\n");

		// Cached singleton instance
		sb.append("\tprivate static volatile ").append(singletonName).append(" instance;\n\n");

		// Constructors
		sb.append("\tpublic ").append(singletonName).append("(MemorySegment nativePointer) {\n");
		sb.append("\t\tsuper(nativePointer);\n");
		sb.append("\t}\n\n");

		sb.append("\tpublic ").append(singletonName).append("(long nativePointer) {\n");
		sb.append("\t\tsuper(nativePointer);\n");
		sb.append("\t}\n\n");

		// Singleton accessor with double-checked locking
		sb.append("\t/**\n");
		sb.append("\t * Get the ").append(singletonName).append(" singleton instance.\n");
		sb.append("\t * Uses double-checked locking for thread safety.\n");
		sb.append("\t */\n");
		sb.append("\tpublic static ").append(singletonName).append(" singleton() {\n");
		sb.append("\t\tif (instance == null) {\n");
		sb.append("\t\t\tsynchronized (").append(singletonName).append(".class) {\n");
		sb.append("\t\t\t\tif (instance == null) {\n");
		sb.append("\t\t\t\t\tGodotStringName name = GodotStringName.fromJavaString(\"").append(singletonName)
				.append("\");\n");
		sb.append("\t\t\t\t\tMemorySegment ptr = Bridge.callPtr(ApiIndex.GLOBAL_GET_SINGLETON, name.segment());\n");
		sb.append("\t\t\t\t\tif (ptr.address() == 0) {\n");
		sb.append("\t\t\t\t\t\tthrow new RuntimeException(\"Failed to get ").append(singletonName)
				.append(" singleton\");\n");
		sb.append("\t\t\t\t\t}\n");
		sb.append("\t\t\t\t\tinstance = new ").append(singletonName).append("(ptr);\n");
		sb.append("\t\t\t\t}\n");
		sb.append("\t\t\t}\n");
		sb.append("\t\t}\n");
		sb.append("\t\treturn instance;\n");
		sb.append("\t}\n");

		sb.append("}\n");
		return sb.toString();
	}
}
