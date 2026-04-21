package com.godot.codegen;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Generates {@code StructOffsets.java} containing auto-computed struct field
 * offsets from gdextension_interface.json type definitions.
 */
public class StructOffsetsGenerator {

	// Structs to generate offsets for
	private static final List<String> STRUCTS = List.of("GDExtensionClassCreationInfo4", "GDExtensionPropertyInfo",
			"GDExtensionClassMethodInfo");

	// Prefix mapping for constant names
	private static final Map<String, String> PREFIX_MAP = Map.of("GDExtensionClassCreationInfo4", "CREATION_INFO4",
			"GDExtensionPropertyInfo", "PROPERTY_INFO", "GDExtensionClassMethodInfo", "METHOD_INFO");

	public static void generate(StructLayoutComputer computer, String outputDir, String packageName)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("/**\n");
		sb.append(" * Auto-generated struct field offsets computed from gdextension_interface.json.\n");
		sb.append(" * DO NOT EDIT.\n");
		sb.append(" */\n");
		sb.append("public final class StructOffsets {\n\n");
		sb.append("\tprivate StructOffsets() {}\n\n");

		for (String structName : STRUCTS) {
			StructLayoutComputer.StructLayout layout;
			try {
				layout = computer.compute(structName);
			} catch (Exception e) {
				System.err.println("Warning: Failed to compute layout for " + structName + ": " + e.getMessage());
				continue;
			}

			String prefix = PREFIX_MAP.getOrDefault(structName, structName.toUpperCase());
			Map<String, Long> offsets = layout.fieldOffsets();

			sb.append("\t// ").append(structName).append(" (").append(layout.size()).append(" bytes)\n");
			sb.append("\tpublic static final long ").append(prefix).append("_SIZE = ").append(layout.size())
					.append("L;\n");

			for (Map.Entry<String, Long> entry : offsets.entrySet()) {
				String constName = prefix + "_OFF_" + toConstCase(entry.getKey());
				sb.append("\tpublic static final long ").append(constName).append(" = ").append(entry.getValue())
						.append("L;\n");
			}
			sb.append("\n");
		}

		sb.append("}\n");

		ApiIndexGenerator.writeFile(outputDir, packageName, "StructOffsets.java", sb.toString());
		System.out.println("Generated: StructOffsets.java (" + STRUCTS.size() + " structs)");
	}

	private static String toConstCase(String name) {
		// Convert camelCase/snake_case to UPPER_SNAKE_CASE
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (Character.isUpperCase(c) && i > 0) {
				result.append('_');
			}
			result.append(Character.toUpperCase(c));
		}
		return result.toString();
	}
}
