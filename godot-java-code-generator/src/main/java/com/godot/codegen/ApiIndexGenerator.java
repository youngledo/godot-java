package com.godot.codegen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Generates {@code ApiIndex.java} from gdextension_interface.json's interface[]
 * array.
 */
public class ApiIndexGenerator {

	private static final int RUNTIME_BASELINE_MAJOR = 4;
	private static final int RUNTIME_BASELINE_MINOR = 6;

	public static void generate(List<GdExtensionInterfaceParser.GdApiFunc> functions, String outputDir,
			String packageName) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("/**\n");
		sb.append(" * Index of all Godot C API functions. Auto-generated from\n");
		sb.append(" * gdextension_interface.json by the code generator.\n");
		sb.append(" * DO NOT EDIT.\n");
		sb.append(" */\n");
		sb.append("public enum ApiIndex {\n\n");

		for (int i = 0; i < functions.size(); i++) {
			GdExtensionInterfaceParser.GdApiFunc func = functions.get(i);
			String enumName = func.name().toUpperCase().replace("-", "_");
			sb.append("\t").append(enumName).append("(").append(i).append(", ");
			if (func.since() == null) {
				sb.append("null");
			} else {
				sb.append("\"").append(func.since()).append("\"");
			}
			sb.append(", ").append(isRequiredAtBoot(func.since())).append(")");
			if (i < functions.size() - 1) {
				sb.append(",");
			}
			sb.append("\n");
		}

		sb.append(";\n\n");
		sb.append("\tprivate final int index;\n");
		sb.append("\tprivate final String since;\n");
		sb.append("\tprivate final boolean requiredAtBoot;\n\n");
		sb.append("\tApiIndex(int index, String since, boolean requiredAtBoot) {\n");
		sb.append("\t\tthis.index = index;\n");
		sb.append("\t\tthis.since = since;\n");
		sb.append("\t\tthis.requiredAtBoot = requiredAtBoot;\n");
		sb.append("\t}\n\n");
		sb.append("\tpublic int index() {\n");
		sb.append("\t\treturn index;\n");
		sb.append("\t}\n");
		sb.append("\n\tpublic String since() {\n");
		sb.append("\t\treturn since;\n");
		sb.append("\t}\n");
		sb.append("\n\tpublic boolean isRequiredAtBoot() {\n");
		sb.append("\t\treturn requiredAtBoot;\n");
		sb.append("\t}\n");
		sb.append("}\n");

		writeFile(outputDir, packageName, "ApiIndex.java", sb.toString());
		System.out.println("Generated: ApiIndex.java (" + functions.size() + " functions)");
	}

	private static boolean isRequiredAtBoot(String since) {
		if (since == null || since.isBlank()) {
			return true;
		}
		String[] parts = since.split("\\.", 3);
		try {
			int major = Integer.parseInt(parts[0]);
			int minor = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
			return major < RUNTIME_BASELINE_MAJOR || major == RUNTIME_BASELINE_MAJOR && minor <= RUNTIME_BASELINE_MINOR;
		} catch (NumberFormatException ignored) {
			return true;
		}
	}

	static void writeFile(String outputDir, String packageName, String fileName, String content) throws IOException {
		String packagePath = packageName.replace('.', '/');
		Path dirPath = Path.of(outputDir, packagePath);
		Files.createDirectories(dirPath);
		Path filePath = dirPath.resolve(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
			writer.write(content);
		}
	}
}
