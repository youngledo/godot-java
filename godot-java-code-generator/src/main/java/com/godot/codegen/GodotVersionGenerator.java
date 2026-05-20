package com.godot.codegen;

import com.godot.codegen.ExtensionApiParser.Header;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/// Generates [GodotApiVersion] from the extension_api.json header.
public class GodotVersionGenerator {

	private static final String PACKAGE = "org.godot.internal.api";
	private static final String CLASS_NAME = "GodotApiVersion";

	/// Generates the version constants class.
	///
	/// @param header     the parsed header from extension_api.json
	/// @param outputDir  the base output directory for generated sources
	public static void generate(Header header, String outputDir) throws IOException {
		String packagePath = PACKAGE.replace('.', '/');
		Path dirPath = Path.of(outputDir, packagePath);
		Files.createDirectories(dirPath);
		Path filePath = dirPath.resolve(CLASS_NAME + ".java");

		String precision = "double".equals(System.getProperty("godot.real.type")) ? "double" : "single";
		String fullVersion = header.version_major() + "." + header.version_minor() + "." + header.version_patch() + "-"
				+ header.version_status();

		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(PACKAGE).append(";\n\n");
		sb.append("/// Auto-generated from extension_api.json. DO NOT EDIT.\n");
		sb.append("public final class ").append(CLASS_NAME).append(" {\n");
		sb.append("    private ").append(CLASS_NAME).append("() {}\n\n");
		sb.append("    public static final int MAJOR = ").append(header.version_major()).append(";\n");
		sb.append("    public static final int MINOR = ").append(header.version_minor()).append(";\n");
		sb.append("    public static final int PATCH = ").append(header.version_patch()).append(";\n");
		sb.append("    public static final String STATUS = \"").append(header.version_status()).append("\";\n");
		sb.append("    public static final String PRECISION = \"").append(precision).append("\";\n");
		sb.append("    public static final String FULL_VERSION = \"").append(fullVersion).append("\";\n");
		sb.append("}\n");

		Files.writeString(filePath, sb.toString(), StandardCharsets.UTF_8);
		System.out.println("Generated " + CLASS_NAME + ".java");
	}
}
