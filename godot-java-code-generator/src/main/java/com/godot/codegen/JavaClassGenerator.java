package com.godot.codegen;

import com.squareup.javapoet.*;

import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import javax.lang.model.element.Modifier;

/**
 * Generates Java wrapper classes from class information.
 */
public class JavaClassGenerator {

	private final String packageName;
	private final Map<String, ClassInfo> classMap;

	public JavaClassGenerator(String packageName, List<ClassInfo> classes) {
		this.packageName = packageName;
		this.classMap = new HashMap<>();
		for (ClassInfo cls : classes) {
			classMap.put(cls.name(), cls);
		}
	}

	/**
	 * Generate a Java class file for the given class info.
	 */
	public JavaFile generateClass(ClassInfo classInfo) {
		return buildClass(classInfo).build();
	}

	/**
	 * Build the complete class specification.
	 */
	private JavaFile.Builder buildClass(ClassInfo classInfo) {
		// Build class spec first
		TypeSpec.Builder classBuilder = buildClassHeader(classInfo);

		// Add constructors
		addConstructors(classBuilder);

		// Add methods (from method hashes)
		addMethods(classBuilder, classInfo);

		// Add property getters/setters
		addProperties(classBuilder, classInfo);

		// Add method hash lookup table
		addMethodHashTable(classBuilder, classInfo);

		// Add explicit imports for cross-package base classes.
		// Generated classes live in org.godot.node, but:
		// - Godot lives in org.godot (root class)
		// - RefCounted lives in org.godot.core (refcounted base)
		// These imports are needed so the 'extends' clause uses simple names.
		JavaFile.Builder fileBuilder = JavaFile.builder(packageName, classBuilder.build()).skipJavaLangImports(true)
				.indent("\t");
		return fileBuilder;
	}

	/**
	 * Build class header with proper extends clause.
	 */
	private TypeSpec.Builder buildClassHeader(ClassInfo classInfo) {
		ClassName className = ClassName.get(packageName, classInfo.name());

		TypeSpec.Builder builder = TypeSpec.classBuilder(className);

		// Add modifiers
		builder.addModifiers(Modifier.PUBLIC);

		// Determine parent class.
		// Even if the parent is in SKIP_CLASSES (hand-written), use its mapped name
		// so that Window -> Control -> Node -> Godot inheritance is preserved.
		String parentClass = classInfo.getSimpleParentClass();
		if (parentClass != null && !parentClass.isEmpty() && !parentClass.equals(classInfo.name())) {
			String javaParent = mapToJavaClass(parentClass);
			builder.superclass(superClassRef(javaParent));
		} else if (parentClass != null && !parentClass.isEmpty()) {
			// Self-reference (shouldn't happen), treat as root
			builder.superclass(ClassName.get("org.godot", "Godot"));
		} else {
			// True root class (no Godot parent at all)
			if (classInfo.isRefcounted()) {
				builder.superclass(ClassName.get("org.godot.core", "RefCounted"));
			} else {
				builder.superclass(ClassName.get("org.godot", "Godot"));
			}
		}

		return builder;
	}

	/**
	 * Add constructors.
	 */
	private void addConstructors(TypeSpec.Builder builder) {
		// Constructor from MemorySegment
		builder.addMethod(MethodSpec.constructorBuilder().addParameter(MemorySegment.class, "nativePointer")
				.addStatement("super(nativePointer)").build());

		// Constructor from long address
		builder.addMethod(MethodSpec.constructorBuilder().addParameter(long.class, "nativePointer")
				.addStatement("super(nativePointer)").build());
	}

	/**
	 * Add methods from the method info.
	 */
	private void addMethods(TypeSpec.Builder builder, ClassInfo classInfo) {
		for (MethodInfo method : classInfo.methods()) {
			// Skip private/virtual methods
			if (method.name().startsWith("_") || method.isVirtual()) {
				continue;
			}

			// Skip setter methods (handled by properties)
			if (method.name().startsWith("set_") && method.arguments().size() == 1) {
				continue;
			}

			// Skip getter methods (handled by properties)
			if (method.name().startsWith("get_") && method.arguments().isEmpty()) {
				continue;
			}

			// Convert method name to Java style
			String javaMethodName = toJavaMethodName(method.name());
			String returnType = getReturnType(method);

			// Build parameter list and track types for proper Object boxing
			List<ParameterSpec> params = new ArrayList<>();
			List<String> paramNames = new ArrayList<>();
			List<String> paramTypes = new ArrayList<>();
			for (int i = 0; i < method.arguments().size(); i++) {
				ArgInfo arg = method.arguments().get(i);
				String javaType = TypeMapper.toJavaType(arg.type());
				String javaName = toJavaParamName(arg.name());
				params.add(ParameterSpec.builder(toTypeName(javaType), javaName).build());
				paramNames.add(javaName);
				paramTypes.add(javaType);
			}

			// Build method call arguments - box primitives into Object
			// Java primitives cannot be cast to Object, so we use .valueOf() methods
			// Use fully-qualified java.lang.Object to avoid conflict with
			// org.godot.node.Object
			String callArgs;
			if (paramNames.isEmpty()) {
				callArgs = "";
			} else {
				StringBuilder args = new StringBuilder();
				for (int i = 0; i < paramNames.size(); i++) {
					if (args.length() > 0)
						args.append(", ");
					args.append(boxToObject(paramNames.get(i), paramTypes.get(i)));
				}
				callArgs = ", new java.lang.Object[] { " + args + " }";
			}

			// Build method
			MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(javaMethodName).addModifiers(Modifier.PUBLIC)
					.addParameters(params);

			if (!returnType.equals("void")) {
				methodBuilder.returns(toTypeName(returnType));
				methodBuilder.addStatement("return ($T) super.call($S$L)", toTypeName(returnType), method.name(),
						callArgs);
			} else {
				methodBuilder.addStatement("super.call($S$L)", method.name(), callArgs);
			}

			builder.addMethod(methodBuilder.build());
		}
	}

	/**
	 * Add cached method variant that uses ThreadLocal MethodBind caching.
	 */
	private void addCachedMethodVariant(TypeSpec.Builder builder, MethodInfo method, String javaMethodName,
			String returnType, List<ParameterSpec> params, List<String> paramNames) {
		// Build cached method name (append "Cached" suffix)
		String cachedMethodName = javaMethodName + "Cached";

		// Build parameter list (same as original)
		MethodSpec.Builder cachedBuilder = MethodSpec.methodBuilder(cachedMethodName).addModifiers(Modifier.PUBLIC)
				.addParameters(params).returns(ClassName.get("", returnType))
				.addAnnotation(ClassName.get("", "CachedMethod"));

		// Build call arguments
		String callArgs;
		if (paramNames.isEmpty()) {
			callArgs = "";
		} else {
			StringBuilder args = new StringBuilder();
			for (String paramName : paramNames) {
				if (args.length() > 0)
					args.append(", ");
				args.append("(").append("Object").append(")").append(paramName);
			}
			callArgs = ", new Object[] { " + args.toString() + " }";
		}

		cachedBuilder.addStatement("return ($T) super.callCached($S$L)", ClassName.get("", returnType), method.name(),
				callArgs);

		builder.addMethod(cachedBuilder.build());
	}

	/**
	 * Add property getter/setter methods.
	 */
	private void addProperties(TypeSpec.Builder builder, ClassInfo classInfo) {
		for (PropertyInfo prop : classInfo.properties()) {
			String javaPropName = toJavaPropertyName(prop.name());
			String javaType = toSingleJavaType(prop.type());

			// Getter - determine getter name
			String getterMethod = prop.getter();
			if (getterMethod == null || getterMethod.isEmpty()) {
				getterMethod = "get_" + prop.name();
				// Check if it's a boolean "is_" getter
				if (javaType.equals("boolean")) {
					getterMethod = "is_" + prop.name();
				}
			}

			// Generate getter
			String getterName = "get" + capitalize(javaPropName);
			if (getterMethod.startsWith("is_")) {
				getterName = "is" + capitalize(javaPropName);
			}

			MethodSpec getterSpec = MethodSpec.methodBuilder(getterName).addModifiers(Modifier.PUBLIC)
					.returns(toTypeName(javaType)).addStatement("return ($T) super.call($S, new java.lang.Object[0])",
							toTypeName(javaType), getterMethod)
					.build();
			builder.addMethod(getterSpec);

			// Setter - determine setter name
			String setterMethod = prop.setter();
			if (setterMethod == null || setterMethod.isEmpty()) {
				setterMethod = "set_" + prop.name();
			}

			String setterName = "set" + capitalize(javaPropName);

			MethodSpec setterSpec = MethodSpec.methodBuilder(setterName).addModifiers(Modifier.PUBLIC)
					.addParameter(toTypeName(javaType), "value")
					.addStatement("super.call($S, new java.lang.Object[] { " + boxToObject("value", javaType) + " })",
							setterMethod)
					.build();
			builder.addMethod(setterSpec);
		}
	}

	/**
	 * Convert Godot property type to a single Java type. Handles types like
	 * "CanvasItemMaterial,ShaderMaterial" -> "Object"
	 */
	private String toSingleJavaType(String godotType) {
		if (godotType == null || godotType.isEmpty()) {
			return "Object";
		}
		// Handle multiple types (e.g., "CanvasItemMaterial,ShaderMaterial")
		if (godotType.contains(",")) {
			return "Object";
		}
		return TypeMapper.toJavaType(godotType);
	}

	/**
	 * Add method hash lookup table.
	 */
	private void addMethodHashTable(TypeSpec.Builder builder, ClassInfo classInfo) {
		// Collect methods with hashes
		Map<String, Long> hashMapEntries = new HashMap<>();
		for (MethodInfo method : classInfo.methods()) {
			if (!method.name().startsWith("_") && method.hash() != 0) {
				hashMapEntries.put(method.name(), method.hash());
			}
		}

		if (!hashMapEntries.isEmpty()) {
			// Use Map.ofEntries() instead of Map.of() to avoid the 10-pair limit
			String[] entries = hashMapEntries.entrySet().stream()
					.map(e -> "java.util.Map.entry(\"" + e.getKey() + "\", " + e.getValue() + "L)")
					.toArray(String[]::new);
			String initExpr = "java.util.Map.ofEntries(" + String.join(", ", entries) + ")";

			builder.addField(FieldSpec
					.builder(
							ParameterizedTypeName.get(ClassName.get("java.util", "Map"),
									ClassName.get("java.lang", "String"), ClassName.get("java.lang", "Long")),
							"METHOD_HASHES", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
					.initializer(initExpr).build());
		}
	}

	private String mapToJavaClass(String godotClass) {
		// Object maps to the root Godot class (org.godot.Godot)
		if (godotClass.equals("Object"))
			return "Godot";
		// RefCounted is in org.godot.core (imported explicitly in generated files)
		if (godotClass.equals("RefCounted"))
			return "RefCounted";
		// Hand-written node classes in org.godot.node
		if (godotClass.equals("Node"))
			return "Node";
		if (godotClass.equals("Node2D"))
			return "Node2D";
		if (godotClass.equals("Node3D"))
			return "Node3D";
		if (godotClass.equals("Resource"))
			return "Resource";
		if (godotClass.equals("CanvasItem"))
			return "CanvasItem";
		if (godotClass.equals("CanvasLayer"))
			return "CanvasLayer";
		if (godotClass.equals("Control"))
			return "Control";
		if (godotClass.equals("Viewport"))
			return "Viewport";
		return godotClass;
	}

	/**
	 * Map a Java class name to a ClassName with the correct package. Cross-package
	 * base classes (Godot, RefCounted) need fully-qualified names.
	 */
	private ClassName superClassRef(String javaClass) {
		if (javaClass.equals("Godot")) {
			return ClassName.get("org.godot", "Godot");
		}
		if (javaClass.equals("RefCounted")) {
			return ClassName.get("org.godot.core", "RefCounted");
		}
		return ClassName.get(packageName, javaClass);
	}

	/**
	 * Convert Godot method name to Java method name.
	 */
	private String toJavaMethodName(String godotName) {
		// Methods from java.lang.Object that cannot be overridden
		if (godotName.equals("wait") || godotName.equals("notify") || godotName.equals("notifyAll")
				|| godotName.equals("equals") || godotName.equals("hashCode") || godotName.equals("toString")) {
			return godotName + "_";
		}

		// Already Java-style
		if (Character.isLowerCase(godotName.charAt(0))) {
			// Still check for Java keyword
			if (JAVA_KEYWORDS.contains(godotName)) {
				return godotName + "_";
			}
			return godotName;
		}

		// Convert snake_case to camelCase
		StringBuilder result = new StringBuilder();
		boolean nextUpper = false;
		for (char c : godotName.toCharArray()) {
			if (c == '_') {
				nextUpper = true;
			} else if (nextUpper) {
				result.append(Character.toUpperCase(c));
				nextUpper = false;
			} else {
				result.append(c);
			}
		}
		String name = result.toString();
		// Rename Java keywords to avoid compilation errors
		if (JAVA_KEYWORDS.contains(name)) {
			return name + "_";
		}
		return name;
	}

	/**
	 * Convert Godot property name to Java property name.
	 */
	private String toJavaPropertyName(String godotName) {
		// Remove common prefixes
		if (godotName.startsWith("theme/")) {
			godotName = godotName.substring(6);
		}
		return toJavaMethodName(godotName);
	}

	/**
	 * Convert Godot parameter name to Java-safe name.
	 */
	private static final Set<String> JAVA_KEYWORDS = Set.of("abstract", "assert", "boolean", "break", "byte", "case",
			"catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
			"volatile", "while", "true", "false", "null",
			// Methods from java.lang.Object that cannot be overridden (treated as keywords)
			"wait", "notify", "notifyAll");

	private String toJavaParamName(String name) {
		if (name == null || name.isEmpty()) {
			return "value";
		}
		String result = name;
		// Check if starts with uppercase - convert to lowercase
		if (Character.isUpperCase(result.charAt(0))) {
			result = Character.toLowerCase(result.charAt(0)) + result.substring(1);
		}
		// Handle Java keywords
		if (JAVA_KEYWORDS.contains(result)) {
			return result + "_";
		}
		// Handle names starting with digits or containing invalid chars
		if (!result.isEmpty() && !Character.isJavaIdentifierStart(result.charAt(0))) {
			return "p" + result;
		}
		// Check for invalid identifier characters
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length(); i++) {
			char c = result.charAt(i);
			if (Character.isJavaIdentifierPart(c)) {
				sb.append(c);
			} else {
				sb.append('_');
			}
		}
		result = sb.toString();
		if (result.isEmpty()) {
			result = "p";
		}
		return result;
	}

	/**
	 * Get return type for method.
	 */
	private String getReturnType(MethodInfo method) {
		if (method.returnType() == null || method.returnType().isEmpty()) {
			return "void";
		}
		String type = method.returnMeta() != null && !method.returnMeta().isEmpty()
				? TypeMapper.toJavaTypeFromMeta(method.returnMeta())
				: null;
		return type != null ? type : TypeMapper.toJavaType(method.returnType());
	}

	/**
	 * Convert a variable expression to an Object for use in Object[] varargs. Java
	 * primitives (long, boolean, double, int, float) cannot be cast to Object
	 * directly — they must be boxed using .valueOf() methods. Reference types
	 * (String, GodotObject, Vector2, etc.) are just cast.
	 */
	private String boxToObject(String varName, String javaType) {
		// Primitive types need boxing — use fully-qualified names to avoid
		// shadowing by the generated class named "Object" in org.godot.node
		switch (javaType) {
			case "long" :
				return "java.lang.Long.valueOf(" + varName + ")";
			case "boolean" :
				return "java.lang.Boolean.valueOf(" + varName + ")";
			case "double" :
				return "java.lang.Double.valueOf(" + varName + ")";
			case "int" :
				return "java.lang.Integer.valueOf(" + varName + ")";
			case "float" :
				return "java.lang.Float.valueOf(" + varName + ")";
			case "byte" :
				return "java.lang.Byte.valueOf(" + varName + ")";
			case "short" :
				return "java.lang.Short.valueOf(" + varName + ")";
			case "char" :
				return "java.lang.Character.valueOf(" + varName + ")";
			default :
				// Reference types can be cast to Object directly
				return "(java.lang.Object) " + varName;
		}
	}

	private String capitalize(String s) {
		if (s == null || s.isEmpty())
			return s;
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	/**
	 * Map Godot types to their actual package for import generation. Generated
	 * classes live in org.godot.node, so cross-package types need explicit package
	 * qualification so JavaPoet can auto-generate correct import statements. Types
	 * NOT listed here will use the empty package (org.godot.node, or java.lang.*
	 * for primitives) — their simple name is assumed to resolve in the same
	 * package.
	 *
	 * Packages: org.godot — Godot, GodotObject (root / bootstrap) org.godot.math —
	 * Vector2, Vector3, Rect2, Color, etc. org.godot.core — Callable, Signal,
	 * Variant, GodotString, RefCounted org.godot.collection — GodotArray,
	 * GodotDictionary
	 */
	private static final Map<String, String> CROSS_PACKAGE_TYPES = Map.ofEntries(
			// Root package
			Map.entry("Godot", "org.godot"), Map.entry("GodotObject", "org.godot"),
			// Math package (hand-written)
			Map.entry("Vector2", "org.godot.math"), Map.entry("Vector2i", "org.godot.math"),
			Map.entry("Vector3", "org.godot.math"), Map.entry("Vector3i", "org.godot.math"),
			Map.entry("Vector4", "org.godot.math"), Map.entry("Vector4i", "org.godot.math"),
			Map.entry("Rect2", "org.godot.math"), Map.entry("Rect2i", "org.godot.math"),
			Map.entry("Plane", "org.godot.math"), Map.entry("Quaternion", "org.godot.math"),
			Map.entry("AABB", "org.godot.math"), Map.entry("Basis", "org.godot.math"),
			Map.entry("Transform2D", "org.godot.math"), Map.entry("Transform3D", "org.godot.math"),
			Map.entry("Projection", "org.godot.math"), Map.entry("Color", "org.godot.math"),
			// Core package (hand-written)
			Map.entry("Callable", "org.godot.core"), Map.entry("Signal", "org.godot.core"),
			Map.entry("GodotString", "org.godot.core"), Map.entry("GodotStringName", "org.godot.core"),
			Map.entry("GodotVariant", "org.godot.core"), Map.entry("RefCounted", "org.godot.core"),
			// Collection package (hand-written)
			Map.entry("GodotArray", "org.godot.collection"), Map.entry("GodotDictionary", "org.godot.collection"));

	/**
	 * Convert a Java type string to a TypeName, handling cross-package types and
	 * array types. - Cross-package types (Vector2, Color, etc.) use
	 * ClassName.get(pkg, name) so JavaPoet can auto-generate the correct import. -
	 * Array types use ArrayTypeName.of() (ClassName.get("", "String[]") is
	 * invalid). - Primitive/well-known types use the empty package (JavaPoet infers
	 * java.lang.* imports).
	 */
	private TypeName toTypeName(String type) {
		if (type == null || type.isEmpty()) {
			return ClassName.get("", "Object");
		}

		if (type.endsWith("[]")) {
			String component = type.substring(0, type.length() - 2);
			return ArrayTypeName.of(toTypeName(component));
		}

		// Cross-package type (math/struct types in org.godot, GodotObject hierarchy)
		if (CROSS_PACKAGE_TYPES.containsKey(type)) {
			return ClassName.get(CROSS_PACKAGE_TYPES.get(type), type);
		}

		return ClassName.get("", type);
	}
}
