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
 * {@code java -jar code-generator.jar <extension_api.json> <gdextension_interface.json> <output-dir> [--force]}
 *
 * <p>
 * Generates ALL engine API classes from extension_api.json, including: - All
 * ~1000 engine classes in org.godot.node - All singleton wrappers in
 * org.godot.singleton - API infrastructure (ApiIndex, VariantType,
 * ApiSignatures, etc.)
 */
public class Main {

	private static final String DEFAULT_API_PATH = "../godot-api/extension_api.json";
	private static final String DEFAULT_INTERFACE_PATH = "../godot-api/gdextension_interface.json";
	private static final String DEFAULT_OUTPUT_DIR = "../godot-java-core/target/generated-sources/codegen";
	private static final String NODE_PACKAGE = "org.godot.node";
	private static final String SINGLETON_PACKAGE = "org.godot.singleton";
	private static final String API_PACKAGE = "org.godot.internal.api";
	private static final String BRIDGE_PACKAGE = "org.godot.bridge";

	public static void main(String[] args) throws IOException {
		String apiPath = args.length > 0 ? args[0] : DEFAULT_API_PATH;
		String interfacePath = args.length > 1 ? args[1] : DEFAULT_INTERFACE_PATH;
		String outputDir = args.length > 2 ? args[2] : DEFAULT_OUTPUT_DIR;
		boolean force = Arrays.asList(args).contains("--force");

		System.out.println("Godot Java Code Generator");
		System.out.println("=========================");
		System.out.println("API:          " + apiPath);
		System.out.println("Interface:    " + interfacePath);
		System.out.println("Output:       " + outputDir);
		System.out.println();

		// Incremental check
		if (!force && isUpToDate(apiPath, interfacePath, outputDir)) {
			System.out.println("All generated files are up-to-date. Skipping generation.");
			System.out.println("Use --force to regenerate.");
			return;
		}

		// ---------------------------------------------------------------
		// Phase 1: Generate engine classes from extension_api.json
		// ---------------------------------------------------------------
		System.out.println("Parsing extension_api.json...");
		ExtensionApiParser parser = new ExtensionApiParser(apiPath);
		List<ClassInfo> classes = parser.getClasses();
		List<SingletonEntry> singletons = parser.getSingletonEntries();
		System.out.println("Found " + classes.size() + " classes, " + singletons.size() + " singletons");

		Map<String, ClassInfo> classMap = new HashMap<>();
		for (ClassInfo cls : classes) {
			classMap.put(cls.name(), cls);
		}

		// Generate ALL engine classes
		System.out.println("Generating " + classes.size() + " engine classes...");
		Files.createDirectories(Path.of(outputDir));

		JavaClassGenerator generator = new JavaClassGenerator(NODE_PACKAGE, classes);
		int generated = 0;
		for (ClassInfo classInfo : classes) {
			try {
				JavaFile javaFile = generator.generateClass(classInfo);
				String packagePath = javaFile.packageName.replace('.', '/');
				Path dirPath = Path.of(outputDir, packagePath);
				Files.createDirectories(dirPath);
				Path filePath = dirPath.resolve(classInfo.name() + ".java");
				try (var writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
					javaFile.writeTo(writer);
				}
				generated++;
			} catch (Exception e) {
				System.err.println("Error generating " + classInfo.name() + ": " + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("Generated " + generated + " engine classes");

		// Generate singleton wrappers
		System.out.println("Generating " + singletons.size() + " singleton wrappers...");
		SingletonGenerator.generate(singletons, classMap, outputDir);

		// ---------------------------------------------------------------
		// Phase 2: Generate API infrastructure from gdextension_interface.json
		// ---------------------------------------------------------------
		System.out.println();
		System.out.println("Parsing gdextension_interface.json...");
		GdExtensionInterfaceParser ifaceParser = new GdExtensionInterfaceParser(interfacePath);
		var typeRegistry = ifaceParser.getTypeRegistry();
		var apiFunctions = ifaceParser.getApiFunctions();
		var types = ifaceParser.getTypes();
		System.out.println("Found " + apiFunctions.size() + " API functions, " + types.size() + " type definitions");

		ApiIndexGenerator.generate(apiFunctions, outputDir, API_PACKAGE);
		VariantTypeGenerator.generate(types, outputDir, API_PACKAGE);

		PanamaTypeMapper typeMapper = new PanamaTypeMapper(typeRegistry);
		ApiSignaturesGenerator.generate(apiFunctions, typeMapper, outputDir, API_PACKAGE, BRIDGE_PACKAGE);

		StructLayoutComputer layoutComputer = new StructLayoutComputer(typeRegistry);
		StructOffsetsGenerator.generate(layoutComputer, outputDir, API_PACKAGE);

		VirtualMethodGenerator.generate(classMap, outputDir, API_PACKAGE);
		VirtualMethodIndexGenerator.generate(classMap, outputDir);

		// Generate class registry for typed object wrapping
		ClassRegistryGenerator.generate(classes, outputDir);

		System.out.println();
		System.out.println("Code generation complete!");
	}

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

		String apiPackage = API_PACKAGE.replace('.', '/');
		String bridgePackage = BRIDGE_PACKAGE.replace('.', '/');
		String nodePackage = NODE_PACKAGE.replace('.', '/');

		Path[] keyFiles = {outputBase.resolve(apiPackage).resolve("ApiIndex.java"),
				outputBase.resolve(apiPackage).resolve("VariantType.java"),
				outputBase.resolve(bridgePackage).resolve("ApiSignatures.java"),
				outputBase.resolve(apiPackage).resolve("VirtualMethods.java"),
				outputBase.resolve(apiPackage).resolve("StructOffsets.java"),
				outputBase.resolve(nodePackage).resolve("Object.java"),};

		for (Path keyFile : keyFiles) {
			if (!Files.exists(keyFile)) {
				return false;
			}
			if (Files.getLastModifiedTime(keyFile).compareTo(inputTime) < 0) {
				return false;
			}
		}

		// Check at least some generated node classes exist
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
