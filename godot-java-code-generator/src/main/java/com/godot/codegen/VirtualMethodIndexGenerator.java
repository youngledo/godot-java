package com.godot.codegen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Generates a compact virtual method index from extension_api.json.
 *
 * <p>
 * Output is a line-based text file consumed by the APT processor at compile
 * time. Format:
 *
 * <pre>
 * ClassName:ParentClass
 * methodName=hash
 * ...
 * </pre>
 *
 * Only includes virtual methods (is_virtual=true, name starts with "_",
 * excluding "_init"). This enables the APT processor to generate per-class
 * dispatch data with exact hashes from the parent class hierarchy, aligned with
 * gdext's compile-time approach.
 */
public class VirtualMethodIndexGenerator {

	public static void generate(Map<String, ClassInfo> classMap, String outputDir) throws IOException {
		// Derive resources directory from the java source output directory
		Path resourcesDir = deriveResourcesDir(outputDir);
		Files.createDirectories(resourcesDir);
		Path indexPath = resourcesDir.resolve("virtual_method_index.txt");

		int classCount = 0;
		int methodCount = 0;

		try (BufferedWriter writer = Files.newBufferedWriter(indexPath, StandardCharsets.UTF_8)) {
			writer.write("# Virtual method index generated from extension_api.json\n");
			writer.write("# Format: ClassName:ParentClass followed by methodName=hash lines\n");
			writer.write("# Used by godot-java-processor APT to generate per-class dispatch data\n");
			writer.write("#\n");

			for (String className : classMap.keySet()) {
				ClassInfo cls = classMap.get(className);
				if (cls == null || cls.methods() == null) {
					continue;
				}

				// Collect virtual methods for this class
				Map<String, Long> virtuals = new LinkedHashMap<>();
				for (MethodInfo method : cls.methods()) {
					if (method.isVirtual() && method.name().startsWith("_") && !method.name().equals("_init")) {
						virtuals.put(method.name(), method.hash());
					}
				}

				// Always write the class header (even if no virtuals, for inheritance lookup)
				String parent = cls.inherits() != null && !cls.inherits().isEmpty() ? cls.getSimpleParentClass() : "";
				writer.write(className + ":" + parent + "\n");
				classCount++;

				for (Map.Entry<String, Long> entry : virtuals.entrySet()) {
					writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
					methodCount++;
				}
			}
		}

		System.out.println("Generated: virtual_method_index.txt (" + classCount + " classes, " + methodCount
				+ " virtual methods) -> " + indexPath);
	}

	private static Path deriveResourcesDir(String outputDir) {
		Path dir = Path.of(outputDir);
		// If output is .../src/main/java, replace with .../src/main/resources
		if (dir.endsWith(Path.of("src", "main", "java"))) {
			return dir.getParent().resolve("resources");
		}
		// Otherwise, use a resources subdirectory
		return dir.resolveSibling("resources");
	}
}
