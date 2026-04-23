package com.godot.codegen;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.LongFunction;

/**
 * Generates GodotClassRegistry.java — a registry mapping Godot engine class
 * names to Java wrapper factory functions. Used by VariantUtils.toObject() to
 * create properly typed wrappers instead of GenericGodotObject.
 */
public class ClassRegistryGenerator {

	private static final String PACKAGE = "org.godot.internal";
	private static final String CLASS_NAME = "GodotClassRegistry";

	public static void generate(List<ClassInfo> classes, String outputDir) throws IOException {
		ClassName godotClass = ClassName.get("org.godot", "Godot");
		TypeName longFunction = ParameterizedTypeName.get(ClassName.get(LongFunction.class), godotClass);
		TypeName mapType = ParameterizedTypeName.get(ClassName.get(Map.class), ClassName.get(String.class),
				longFunction);

		TypeSpec.Builder classBuilder = TypeSpec.classBuilder(CLASS_NAME).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build());

		// Registry field
		classBuilder.addField(FieldSpec.builder(mapType, "REGISTRY", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
				.initializer("new $T<>($L)", HashMap.class, classes.size() + 50).build());

		// Static initializer — register all engine classes
		CodeBlock.Builder initBlock = CodeBlock.builder();
		for (ClassInfo cls : classes) {
			String godotName = cls.name();
			ClassName javaClass = ClassName.get("org.godot.node", godotName);
			initBlock.addStatement("REGISTRY.put($S, ptr -> new $T(ptr))", godotName, javaClass);
		}
		classBuilder.addStaticBlock(initBlock.build());

		// --- Fixed methods (not generated from class list) ---

		// create(String className, long nativePtr)
		classBuilder.addMethod(MethodSpec.methodBuilder("create").addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addParameter(String.class, "className").addParameter(long.class, "nativePtr").returns(godotClass)
				.addStatement("$T<org.godot.Godot> factory = REGISTRY.get(className)", LongFunction.class)
				.addStatement("return factory != null ? factory.apply(nativePtr) : null").build());

		// hasClass(String className)
		classBuilder.addMethod(MethodSpec.methodBuilder("hasClass").addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addParameter(String.class, "className").returns(boolean.class)
				.addStatement("return REGISTRY.containsKey(className)").build());

		// createTypedWrapper(long ptr) — query class name and create wrapper
		classBuilder.addMethod(MethodSpec.methodBuilder("createTypedWrapper")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC).addParameter(long.class, "ptr").returns(godotClass)
				.addStatement("String className = queryClassName(ptr)")
				.addStatement("if (className == null) return null").addStatement("return create(className, ptr)")
				.build());

		// queryClassName(long ptr) — uses OBJECT_GET_CLASS_NAME + VARIANT_STRINGIFY
		classBuilder.addMethod(MethodSpec.methodBuilder("queryClassName").addModifiers(Modifier.STATIC)
				.addParameter(long.class, "ptr").returns(String.class).addCode(
						//
						"return $T.runScoped(() -> {\n" +
						//
								"    $T objSeg = $T.ofAddress(ptr);\n" + "    $T refBuf = $T.arena().allocate(1);\n"
								+ "    $T outBuf = $T.arena().allocate(8, 8);\n" +
								//
								"    int ok = $T.callInt($T.OBJECT_GET_CLASS_NAME, objSeg, refBuf, outBuf);\n"
								+ "    if (ok == 0) return null;\n" + "\n"
								+ "    // Build a Variant with type STRING_NAME containing the StringName\n"
								+ "    $T variant = $T.allocVariant();\n"
								+ "    variant.set($T.JAVA_INT, 0, $T.STRING_NAME.id());\n"
								+ "    $T.copy(outBuf, 0, variant, 8, 8);\n" + "\n"
								+ "    // Stringify to convert StringName → String\n"
								+ "    $T outStr = $T.arena().allocate(8, 8);\n"
								+ "    $T.callVoid($T.VARIANT_STRINGIFY, variant, outStr);\n" + "\n"
								+ "    String result = new $T(outStr).toJavaString();\n"
								+ "    $T.destroyVariant(variant);\n" + "    return result;\n" + "});\n",
						//
						ClassName.get("org.godot.bridge", "Bridge"), // runScoped
						ClassName.get("java.lang.foreign", "MemorySegment"), // objSeg
						ClassName.get("java.lang.foreign", "MemorySegment"), // ofAddress
						ClassName.get("java.lang.foreign", "MemorySegment"), // refBuf
						ClassName.get("org.godot.bridge", "Bridge"), // arena
						ClassName.get("java.lang.foreign", "MemorySegment"), // outBuf
						ClassName.get("org.godot.bridge", "Bridge"), // arena
						ClassName.get("org.godot.bridge", "Bridge"), // callInt
						ClassName.get("org.godot.internal.api", "ApiIndex"), // OBJECT_GET_CLASS_NAME
						ClassName.get("java.lang.foreign", "MemorySegment"), // variant
						ClassName.get("org.godot.bridge", "Bridge"), // allocVariant
						ClassName.get("java.lang.foreign", "ValueLayout"), // JAVA_INT
						ClassName.get("org.godot.internal.api", "VariantType"), // STRING_NAME
						ClassName.get("java.lang.foreign", "MemorySegment"), // copy
						ClassName.get("java.lang.foreign", "MemorySegment"), // outStr
						ClassName.get("org.godot.bridge", "Bridge"), // arena
						ClassName.get("org.godot.bridge", "Bridge"), // callVoid
						ClassName.get("org.godot.internal.api", "ApiIndex"), // VARIANT_STRINGIFY
						ClassName.get("org.godot.core", "GodotString"), // GodotString
						ClassName.get("org.godot.bridge", "Bridge") // destroyVariant
				).build());

		// Write file
		JavaFile javaFile = JavaFile.builder(PACKAGE, classBuilder.build()).skipJavaLangImports(true).indent("\t")
				.build();

		Path dirPath = Path.of(outputDir, PACKAGE.replace('.', '/'));
		Files.createDirectories(dirPath);
		Path filePath = dirPath.resolve(CLASS_NAME + ".java");
		try (var writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
			javaFile.writeTo(writer);
		}

		System.out.println("Generated " + CLASS_NAME + ".java with " + classes.size() + " class entries");
	}
}
