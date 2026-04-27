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
 *
 * Generates ALL engine API classes including Object, RefCounted, Node, etc.
 * Each generated class includes: - GODOT_CLASS_NAME constant -
 * getGodotClassName() override - METHOD_HASHES map (embedded) - create()
 * factory for instantiable classes - Nested enums from class enum definitions -
 * Public constructors - Method wrappers and property accessors
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

	public JavaFile generateClass(ClassInfo classInfo) {
		return buildClass(classInfo).build();
	}

	private JavaFile.Builder buildClass(ClassInfo classInfo) {
		TypeSpec.Builder classBuilder = buildClassHeader(classInfo);

		addGodotClassName(classBuilder, classInfo);
		addConstructors(classBuilder, classInfo);
		addMethodHashTable(classBuilder, classInfo);
		addEnums(classBuilder, classInfo);
		addMethods(classBuilder, classInfo);
		addProperties(classBuilder, classInfo);
		addCreateFactory(classBuilder, classInfo);
		addGetGodotClassName(classBuilder, classInfo);
		addResolveMethodHash(classBuilder, classInfo);

		JavaFile.Builder fileBuilder = JavaFile.builder(packageName, classBuilder.build()).skipJavaLangImports(true)
				.indent("\t");
		return fileBuilder;
	}

	/**
	 * Build class header with proper extends clause.
	 *
	 * - Object (no parent) extends org.godot.Godot - RefCounted (parent: Object)
	 * extends org.godot.node.Object - All others extend their parent in
	 * org.godot.node
	 */
	private TypeSpec.Builder buildClassHeader(ClassInfo classInfo) {
		ClassName className = ClassName.get(packageName, classInfo.name());
		TypeSpec.Builder builder = TypeSpec.classBuilder(className);
		builder.addModifiers(Modifier.PUBLIC);

		String parentClass = classInfo.getSimpleParentClass();
		if (parentClass != null && !parentClass.isEmpty()) {
			builder.superclass(superClassRef(parentClass));
		} else {
			// Root class (Object) or classes with no parent -> extends Godot
			builder.superclass(ClassName.get("org.godot", "Godot"));
		}

		return builder;
	}

	/**
	 * Add GODOT_CLASS_NAME static constant.
	 */
	private void addGodotClassName(TypeSpec.Builder builder, ClassInfo classInfo) {
		builder.addField(
				FieldSpec.builder(String.class, "GODOT_CLASS_NAME", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
						.initializer("$S", classInfo.name()).build());
	}

	/**
	 * Add getGodotClassName() override.
	 */
	private void addGetGodotClassName(TypeSpec.Builder builder, ClassInfo classInfo) {
		builder.addMethod(MethodSpec.methodBuilder("getGodotClassName").addModifiers(Modifier.PUBLIC)
				.returns(String.class).addAnnotation(Override.class).addStatement("return GODOT_CLASS_NAME").build());
	}

	/**
	 * Add resolveMethodHash() override - the core of zero-reflection dispatch.
	 * Checks this class's METHOD_HASHES, then delegates to super.
	 */
	private void addResolveMethodHash(TypeSpec.Builder builder, ClassInfo classInfo) {
		builder.addMethod(MethodSpec.methodBuilder("resolveMethodHash").addModifiers(Modifier.PROTECTED)
				.returns(ClassName.get("org.godot", "Godot").nestedClass("HashResult")).addAnnotation(Override.class)
				.addParameter(String.class, "methodName")
				.addStatement("$T hash = METHOD_HASHES.get(methodName)", Long.class)
				.addStatement("if (hash != null) return new $T(hash, GODOT_CLASS_NAME)",
						ClassName.get("org.godot", "Godot").nestedClass("HashResult"))
				.addStatement("return super.resolveMethodHash(methodName)").build());
	}

	/**
	 * Add public constructors.
	 */
	private void addConstructors(TypeSpec.Builder builder, ClassInfo classInfo) {
		// Constructor from MemorySegment
		builder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
				.addParameter(MemorySegment.class, "nativePointer").addStatement("super(nativePointer)").build());

		// Constructor from long address
		builder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
				.addParameter(long.class, "nativePointer").addStatement("super(nativePointer)").build());

		// No-arg constructor for @GodotClass subclass instantiation
		builder.addMethod(
				MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addStatement("super()").build());
	}

	/**
	 * Add create() factory method for instantiable classes.
	 */
	private void addCreateFactory(TypeSpec.Builder builder, ClassInfo classInfo) {
		if (!classInfo.isInstantiable()) {
			return;
		}

		// Check if the class has a method named "create" that would conflict
		boolean hasCreateNoArgs = false;
		for (MethodInfo method : classInfo.methods()) {
			if (method.name().equals("create") && method.arguments().isEmpty()) {
				hasCreateNoArgs = true;
				break;
			}
		}

		String factoryName = hasCreateNoArgs ? "createNew" : "create";
		ClassName returnType = ClassName.get(packageName, classInfo.name());

		builder.addMethod(
				MethodSpec.methodBuilder(factoryName).addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(returnType)
						.addStatement("$T name = $T.fromJavaString(GODOT_CLASS_NAME)",
								ClassName.get("org.godot.core", "GodotStringName"),
								ClassName.get("org.godot.core", "GodotStringName"))
						.addStatement("$T ptr = $T.callPtr($T.CLASSDB_CONSTRUCT_OBJECT, name.segment())",
								MemorySegment.class, ClassName.get("org.godot.bridge", "Bridge"),
								ClassName.get("org.godot.internal.api", "ApiIndex"))
						.addStatement("return new $T(ptr)", returnType).build());
	}

	/**
	 * Add nested enums from class enum definitions.
	 */
	private void addEnums(TypeSpec.Builder builder, ClassInfo classInfo) {
		for (EnumInfo enumInfo : classInfo.enums()) {
			TypeSpec.Builder enumBuilder = TypeSpec.enumBuilder(enumInfo.name()).addModifiers(Modifier.PUBLIC);

			// Value field
			enumBuilder.addField(FieldSpec
					.builder(enumInfo.isBitfield() ? long.class : int.class, "value", Modifier.PUBLIC, Modifier.FINAL)
					.build());

			// Constructor
			enumBuilder.addMethod(MethodSpec.constructorBuilder()
					.addParameter(enumInfo.isBitfield() ? long.class : int.class, "value")
					.addStatement("this.value = value").build());

			// Enum constants - use int for enums, long for bitfields
			for (EnumValue ev : enumInfo.values()) {
				String literal = enumInfo.isBitfield() ? ev.value() + "L" : String.valueOf((int) ev.value());
				enumBuilder.addEnumConstant(ev.name(), TypeSpec.anonymousClassBuilder("$L", literal).build());
			}

			builder.addType(enumBuilder.build());
		}
	}

	/**
	 * Add methods from the method info.
	 */
	private void addMethods(TypeSpec.Builder builder, ClassInfo classInfo) {
		// Track generated method signatures to avoid duplicates
		Set<String> generatedSignatures = new java.util.HashSet<>();

		for (MethodInfo method : classInfo.methods()) {
			// Skip virtual methods (prefixed with _)
			if (method.name().startsWith("_") || method.isVirtual()) {
				continue;
			}

			// Skip call/call_deferred - Godot.call() already handles dynamic
			// dispatch; generating a wrapper intercepts single-arg call("method")
			// away from Godot.call(String, Object...) into the broken vararg
			// method bind path
			if (method.name().equals("call") || method.name().equals("call_deferred")) {
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

			String javaMethodName = toJavaMethodName(method.name());
			String returnType = getReturnType(method);

			// Build parameter list
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

			// Check for duplicate method signatures
			String sig = javaMethodName + "(" + String.join(",", paramTypes) + ")";
			if (!generatedSignatures.add(sig)) {
				continue;
			}

			// Build call arguments with proper boxing
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
	 * Add property getter/setter methods.
	 */
	private void addProperties(TypeSpec.Builder builder, ClassInfo classInfo) {
		for (PropertyInfo prop : classInfo.properties()) {
			String javaPropName = toJavaPropertyName(prop.name());
			String javaType = toSingleJavaType(prop.type());

			// Determine getter method name
			String getterMethod = prop.getter();
			if (getterMethod == null || getterMethod.isEmpty()) {
				getterMethod = "get_" + prop.name();
				if (javaType.equals("boolean")) {
					getterMethod = "is_" + prop.name();
				}
			}

			String getterName = "get" + capitalize(javaPropName);
			if (getterMethod.startsWith("is_")) {
				getterName = "is" + capitalize(javaPropName);
			}

			MethodSpec getterSpec = MethodSpec.methodBuilder(getterName).addModifiers(Modifier.PUBLIC)
					.returns(toTypeName(javaType)).addStatement("return ($T) super.call($S, new java.lang.Object[0])",
							toTypeName(javaType), getterMethod)
					.build();
			builder.addMethod(getterSpec);

			// Determine setter method name
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
	 * Add method hash lookup table embedded directly in the class.
	 */
	private void addMethodHashTable(TypeSpec.Builder builder, ClassInfo classInfo) {
		Map<String, Long> hashMapEntries = new HashMap<>();
		for (MethodInfo method : classInfo.methods()) {
			if (!method.name().startsWith("_") && method.hash() != 0) {
				hashMapEntries.put(method.name(), method.hash());
			}
		}

		if (!hashMapEntries.isEmpty()) {
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
		} else {
			// Empty hash map for classes with no methods
			builder.addField(FieldSpec
					.builder(
							ParameterizedTypeName.get(ClassName.get("java.util", "Map"),
									ClassName.get("java.lang", "String"), ClassName.get("java.lang", "Long")),
							"METHOD_HASHES", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
					.initializer("java.util.Map.of()").build());
		}
	}

	// ------------------------------------------------------------------
	// Type resolution
	// ------------------------------------------------------------------

	private static final Map<String, String> CROSS_PACKAGE_TYPES = Map.ofEntries(
			// Root package
			Map.entry("Godot", "org.godot"),
			// java.lang (needed to avoid shadowing when generating org.godot.node.Object)
			Map.entry("java.lang.Object", "java.lang"),
			// Math package
			Map.entry("Vector2", "org.godot.math"), Map.entry("Vector2i", "org.godot.math"),
			Map.entry("Vector3", "org.godot.math"), Map.entry("Vector3i", "org.godot.math"),
			Map.entry("Vector4", "org.godot.math"), Map.entry("Vector4i", "org.godot.math"),
			Map.entry("Rect2", "org.godot.math"), Map.entry("Rect2i", "org.godot.math"),
			Map.entry("Plane", "org.godot.math"), Map.entry("Quaternion", "org.godot.math"),
			Map.entry("AABB", "org.godot.math"), Map.entry("Basis", "org.godot.math"),
			Map.entry("Transform2D", "org.godot.math"), Map.entry("Transform3D", "org.godot.math"),
			Map.entry("Projection", "org.godot.math"), Map.entry("Color", "org.godot.math"),
			// Core package
			Map.entry("Callable", "org.godot.core"), Map.entry("Signal", "org.godot.core"),
			Map.entry("GodotString", "org.godot.core"), Map.entry("GodotStringName", "org.godot.core"),
			Map.entry("GodotVariant", "org.godot.core"), // Collection package
			Map.entry("GodotArray", "org.godot.collection"), Map.entry("GodotDictionary", "org.godot.collection"));

	private ClassName superClassRef(String godotParentName) {
		// All engine classes (Object, RefCounted, Node, etc.) are in org.godot.node
		return ClassName.get(packageName, godotParentName);
	}

	private TypeName toTypeName(String type) {
		if (type == null || type.isEmpty()) {
			return ClassName.get("java.lang", "Object");
		}

		if (type.endsWith("[]")) {
			String component = type.substring(0, type.length() - 2);
			return ArrayTypeName.of(toTypeName(component));
		}

		// Cross-package type (Vector2, Color, etc.)
		if (CROSS_PACKAGE_TYPES.containsKey(type)) {
			return ClassName.get(CROSS_PACKAGE_TYPES.get(type), type);
		}

		// "Object" from TypeMapper (Variant return) -> java.lang.Object
		if (type.equals("Object")) {
			return ClassName.get("java.lang", "Object");
		}

		return ClassName.get("", type);
	}

	// ------------------------------------------------------------------
	// Name conversion utilities
	// ------------------------------------------------------------------

	private String toJavaMethodName(String godotName) {
		// Methods from java.lang.Object that cannot be overridden
		if (godotName.equals("wait") || godotName.equals("notify") || godotName.equals("notifyAll")
				|| godotName.equals("equals") || godotName.equals("hashCode") || godotName.equals("toString")) {
			return godotName + "_";
		}

		if (Character.isLowerCase(godotName.charAt(0))) {
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
		if (JAVA_KEYWORDS.contains(name)) {
			return name + "_";
		}
		return name;
	}

	private String toJavaPropertyName(String godotName) {
		if (godotName.startsWith("theme/")) {
			godotName = godotName.substring(6);
		}
		return toJavaMethodName(godotName);
	}

	private static final Set<String> JAVA_KEYWORDS = Set.of("abstract", "assert", "boolean", "break", "byte", "case",
			"catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
			"volatile", "while", "true", "false", "null", "wait", "notify", "notifyAll");

	private String toJavaParamName(String name) {
		if (name == null || name.isEmpty()) {
			return "value";
		}
		String result = name;
		if (Character.isUpperCase(result.charAt(0))) {
			result = Character.toLowerCase(result.charAt(0)) + result.substring(1);
		}
		if (JAVA_KEYWORDS.contains(result)) {
			return result + "_";
		}
		if (!result.isEmpty() && !Character.isJavaIdentifierStart(result.charAt(0))) {
			return "p" + result;
		}
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

	private String getReturnType(MethodInfo method) {
		if (method.returnType() == null || method.returnType().isEmpty()) {
			return "void";
		}
		String type = method.returnMeta() != null && !method.returnMeta().isEmpty()
				? TypeMapper.toJavaTypeFromMeta(method.returnMeta())
				: null;
		return type != null ? type : TypeMapper.toJavaType(method.returnType());
	}

	private String toSingleJavaType(String godotType) {
		if (godotType == null || godotType.isEmpty()) {
			return "Object";
		}
		if (godotType.contains(",")) {
			return "Object";
		}
		return TypeMapper.toJavaType(godotType);
	}

	private String boxToObject(String varName, String javaType) {
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
				return "(java.lang.Object) " + varName;
		}
	}

	private String capitalize(String s) {
		if (s == null || s.isEmpty())
			return s;
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
}
