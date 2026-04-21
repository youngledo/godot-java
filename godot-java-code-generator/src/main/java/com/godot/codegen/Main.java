package com.godot.codegen;

import com.godot.codegen.ExtensionApiParser.*;
import com.squareup.javapoet.JavaFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.*;

/**
 * Main entry point for code generator.
 *
 * <p>
 * Usage:
 * {@code java -jar code-generator.jar <path-to-extension_api.json> <output-dir>}
 *
 * <p>
 * Generates Java wrapper classes from extension_api.json
 */
public class Main {

	private static final String DEFAULT_API_PATH = "../godot-api/extension_api.json";
	private static final String DEFAULT_OUTPUT_DIR = "../godot-java-core/target/src-gen/main/java/org/godot/node";
	private static final String PACKAGE_NAME = "org.godot.node";
	private static final String API_PACKAGE = "org.godot.internal.api";
	private static final String BRIDGE_PACKAGE = "org.godot.bridge";

	// Classes that should NOT be generated because they already exist as
	// hand-written
	private static final Set<String> SKIP_CLASSES = Set.of(
			// Hand-written base classes (must have corresponding .java files)
			"Object", "RefCounted", "Node", "Node2D", "Node3D", "Control", "Viewport");

	private static final String DEFAULT_INTERFACE_PATH = "../godot-api/gdextension_interface.json";

	public static void main(String[] args) throws IOException {
		String apiPath = args.length > 0 ? args[0] : DEFAULT_API_PATH;
		String interfacePath = args.length > 1 ? args[1] : DEFAULT_INTERFACE_PATH;
		String outputDir = args.length > 2 ? args[2] : DEFAULT_OUTPUT_DIR;
		boolean generateAll = args.length > 3 && "--all".equals(args[3]);
		boolean force = Arrays.asList(args).contains("--force");

		System.out.println("Godot Java Code Generator");
		System.out.println("=========================");
		System.out.println("API:          " + apiPath);
		System.out.println("Interface:    " + interfacePath);
		System.out.println("Output:       " + outputDir);
		System.out.println("Mode:         " + (generateAll ? "ALL CLASSES" : "CORE CLASSES ONLY"));
		System.out.println();

		// Incremental check: skip if output files are newer than input JSON files
		if (!force && isUpToDate(apiPath, interfacePath, outputDir)) {
			System.out.println("All generated files are up-to-date. Skipping generation.");
			System.out.println("Use --force to regenerate.");
			return;
		}

		// Parse extension_api.json
		System.out.println("Parsing extension_api.json...");
		ExtensionApiParser parser = new ExtensionApiParser(apiPath);
		List<ClassInfo> classes = parser.getClasses();
		System.out.println("Found " + classes.size() + " classes");

		// Map all classes by name for lookup
		Map<String, ClassInfo> classMap = new HashMap<>();
		for (ClassInfo cls : classes) {
			classMap.put(cls.name(), cls);
		}

		Set<String> toGenerate;
		if (generateAll) {
			// Generate all classes except those that already exist
			toGenerate = new LinkedHashSet<>();
			for (ClassInfo cls : classes) {
				if (!SKIP_CLASSES.contains(cls.name())) {
					toGenerate.add(cls.name());
				}
			}
		} else {
			// Filter core classes for initial generation
			// Core classes: Object, Node, Node2D, Node3D, RefCounted, Resource, etc.
			List<String> coreClassNames = Arrays.asList("Object", "Node", "Node2D", "Node3D", "RefCounted", "Resource",
					"CanvasItem", "CanvasLayer", "Control", "Viewport");

			// Filter to include only core classes + their dependencies
			toGenerate = new LinkedHashSet<>();
			Queue<String> pending = new ArrayDeque<>(coreClassNames);

			while (!pending.isEmpty()) {
				String name = pending.poll();
				// Skip classes that already exist as hand-written
				if (toGenerate.contains(name) || !classMap.containsKey(name) || SKIP_CLASSES.contains(name)) {
					continue;
				}
				toGenerate.add(name);

				ClassInfo cls = classMap.get(name);
				if (cls.inherits() != null && !cls.inherits().isEmpty()) {
					String parent = cls.getSimpleParentClass();
					if (parent != null && !toGenerate.contains(parent)) {
						pending.add(parent);
					}
				}
			}
		}

		System.out.println("Generating " + toGenerate.size() + " classes: " + toGenerate);

		// Create output directory
		Files.createDirectories(Path.of(outputDir));

		// Generate Java files
		JavaClassGenerator generator = new JavaClassGenerator(PACKAGE_NAME, classes);

		int generated = 0;
		for (String className : toGenerate) {
			ClassInfo classInfo = classMap.get(className);
			if (classInfo == null) {
				System.err.println("Warning: Class not found: " + className);
				continue;
			}

			try {
				JavaFile javaFile = generator.generateClass(classInfo);

				// Write to file in package subdirectory
				String packagePath = javaFile.packageName.replace('.', '/');
				Path dirPath = Path.of(outputDir, packagePath);
				Files.createDirectories(dirPath);
				Path filePath = dirPath.resolve(className + ".java");
				try (var writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
					javaFile.writeTo(writer);
				}
				System.out.println("Generated: " + className + ".java");
				generated++;
			} catch (Exception e) {
				System.err.println("Error generating " + className + ": " + e.getMessage());
				e.printStackTrace();
			}
		}

		System.out.println();
		System.out.println("Done! Generated " + generated + " classes to " + outputDir);

		// Generate Object method hashes (used by Godot.call() fallback)
		ObjectHashGenerator.genObjectHashes(classMap, outputDir, PACKAGE_NAME);

		// ---------------------------------------------------------------
		// Phase 2: Generate version-specific files from gdextension_interface.json
		// ---------------------------------------------------------------
		System.out.println();
		System.out.println("Parsing gdextension_interface.json...");
		GdExtensionInterfaceParser ifaceParser = new GdExtensionInterfaceParser(interfacePath);
		var typeRegistry = ifaceParser.getTypeRegistry();
		var apiFunctions = ifaceParser.getApiFunctions();
		var types = ifaceParser.getTypes();
		System.out.println("Found " + apiFunctions.size() + " API functions, " + types.size() + " type definitions");

		// Generate ApiIndex, VariantType, ApiSignatures from gdextension_interface.json
		ApiIndexGenerator.generate(apiFunctions, outputDir, API_PACKAGE);
		VariantTypeGenerator.generate(types, outputDir, API_PACKAGE);

		PanamaTypeMapper typeMapper = new PanamaTypeMapper(typeRegistry);
		ApiSignaturesGenerator.generate(apiFunctions, typeMapper, outputDir, API_PACKAGE, BRIDGE_PACKAGE);

		// Generate StructOffsets (safe: computed from struct definitions in JSON)
		StructLayoutComputer layoutComputer = new StructLayoutComputer(typeRegistry);
		StructOffsetsGenerator.generate(layoutComputer, outputDir, API_PACKAGE);

		// Generate VirtualMethods (safe: scanned from extension_api.json)
		VirtualMethodGenerator.generate(classMap, outputDir, API_PACKAGE);

		// Generate compact virtual method index for APT processor
		VirtualMethodIndexGenerator.generate(classMap, outputDir);

		System.out.println();
		System.out.println("Code generation complete!");
	}

	/**
	 * Check if generated output files are newer than the input JSON files. Returns
	 * true if generation can be skipped.
	 */
	private static boolean isUpToDate(String apiPath, String interfacePath, String outputDir) throws IOException {
		Path apiFile = Path.of(apiPath);
		Path ifaceFile = Path.of(interfacePath);
		Path outputBase = Path.of(outputDir);

		if (!Files.exists(apiFile) || !Files.exists(ifaceFile)) {
			return false;
		}

		FileTime apiTime = Files.getLastModifiedTime(apiFile);
		FileTime ifaceTime = Files.getLastModifiedTime(ifaceFile);
		FileTime inputTime = apiTime.compareTo(ifaceTime) > 0 ? apiTime : ifaceTime;

		// Check key output files — if any is missing or older than input, need
		// regeneration
		String apiPackage = API_PACKAGE.replace('.', '/');
		String bridgePackage = BRIDGE_PACKAGE.replace('.', '/');
		String nodePackage = PACKAGE_NAME.replace('.', '/');

		Path[] keyFiles = {outputBase.resolve(apiPackage).resolve("ApiIndex.java"),
				outputBase.resolve(apiPackage).resolve("VariantType.java"),
				outputBase.resolve(bridgePackage).resolve("ApiSignatures.java"),
				outputBase.resolve(apiPackage).resolve("VirtualMethods.java"),
				outputBase.resolve(apiPackage).resolve("StructOffsets.java"),
				outputBase.resolve(nodePackage).resolve("ObjectMethodHashes.java"),};

		for (Path keyFile : keyFiles) {
			if (!Files.exists(keyFile)) {
				return false;
			}
			if (Files.getLastModifiedTime(keyFile).compareTo(inputTime) < 0) {
				return false;
			}
		}

		// Also check at least one generated node class exists
		if (!Files.exists(outputBase.resolve(nodePackage))) {
			return false;
		}
		try (var stream = Files.list(outputBase.resolve(nodePackage))) {
			if (stream.findAny().isEmpty()) {
				return false;
			}
		}

		return true;
	}
}
