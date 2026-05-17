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
		TypedCallSupport.configure(classMap);
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
		addSignals(classBuilder, classInfo);
		addCreateFactory(classBuilder, classInfo);
		addGetGodotClassName(classBuilder, classInfo);
		addResolveMethodHash(classBuilder, classInfo);
		addConvenienceMethods(classBuilder, classInfo);

		JavaFile.Builder fileBuilder = JavaFile.builder(packageName, classBuilder.build()).skipJavaLangImports(false)
				.indent("	");
		return fileBuilder;
	}

	/**
	 * Add hand-written convenience methods to specific generated classes. These are
	 * typed helper methods not derived from the Godot API but improve Java
	 * ergonomics by providing typed access to common patterns.
	 */
	private void addConvenienceMethods(TypeSpec.Builder builder, ClassInfo classInfo) {
		String name = classInfo.name();

		if ("Object".equals(name)) {
			MethodBindRef bytesToVarBind = findMethodBind(classInfo, "bytes_to_var");
			builder.addMethod(MethodSpec.methodBuilder("bytesToVar").addModifiers(Modifier.PUBLIC)
					.returns(java.lang.Object.class).addParameter(byte[].class, "bytes")
					.addStatement("return callEngine($S, $S, $LL, new java.lang.Object[] { bytes })",
							bytesToVarBind.className(), "bytes_to_var", bytesToVarBind.hash())
					.build());

			MethodBindRef bytesToVarWithObjectsBind = findMethodBind(classInfo, "bytes_to_var_with_objects");
			builder.addMethod(MethodSpec.methodBuilder("bytesToVarWithObjects").addModifiers(Modifier.PUBLIC)
					.returns(java.lang.Object.class).addParameter(byte[].class, "bytes")
					.addStatement("return callEngine($S, $S, $LL, new java.lang.Object[] { bytes })",
							bytesToVarWithObjectsBind.className(), "bytes_to_var_with_objects",
							bytesToVarWithObjectsBind.hash())
					.build());

			MethodBindRef varToStrBind = findMethodBind(classInfo, "var_to_str");
			builder.addMethod(MethodSpec.methodBuilder("varToStr").addModifiers(Modifier.PUBLIC).returns(String.class)
					.addParameter(java.lang.Object.class, "value")
					.addStatement("return (String) callEngine($S, $S, $LL, new java.lang.Object[] { value })",
							varToStrBind.className(), "var_to_str", varToStrBind.hash())
					.build());

			MethodBindRef strToVarBind = findMethodBind(classInfo, "str_to_var");
			builder.addMethod(MethodSpec.methodBuilder("strToVar").addModifiers(Modifier.PUBLIC)
					.returns(java.lang.Object.class).addParameter(String.class, "value")
					.addStatement("return callEngine($S, $S, $LL, new java.lang.Object[] { value })",
							strToVarBind.className(), "str_to_var", strToVarBind.hash())
					.build());

			MethodBindRef getStringFromUtf8Bind = findMethodBind(classInfo, "get_string_from_utf8");
			builder.addMethod(MethodSpec.methodBuilder("getStringFromUtf8").addModifiers(Modifier.PUBLIC)
					.returns(String.class).addParameter(byte[].class, "bytes")
					.addStatement("return (String) callEngine($S, $S, $LL, new java.lang.Object[] { bytes })",
							getStringFromUtf8Bind.className(), "get_string_from_utf8", getStringFromUtf8Bind.hash())
					.build());

			MethodBindRef isInstanceValidBind = findMethodBind(classInfo, "is_instance_valid");
			builder.addMethod(
					MethodSpec.methodBuilder("isInstanceValid").addModifiers(Modifier.PUBLIC).returns(boolean.class)
							.addParameter(java.lang.Object.class, "value")
							.addStatement("return (boolean) callEngine($S, $S, $LL, new java.lang.Object[] { value })",
									isInstanceValidBind.className(), "is_instance_valid", isInstanceValidBind.hash())
							.build());
		}

		if ("Node".equals(name)) {
			ClassName nodeType = ClassName.get(packageName, "Node");
			ClassName objectType = ClassName.get(packageName, "Object");

			builder.addMethod(MethodSpec.methodBuilder("getNodeAs").addModifiers(Modifier.PUBLIC)
					.addTypeVariable(TypeVariableName.get("T", objectType)).returns(TypeVariableName.get("T"))
					.addParameter(String.class, "path")
					.addParameter(ParameterizedTypeName.get(ClassName.get(Class.class), TypeVariableName.get("T")),
							"type")
					.addAnnotation(AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "$S", "unchecked")
							.build())
					.addStatement("$T node = getNode(path)", nodeType).addStatement("if (node == null) return null")
					.addStatement("return ($T) node", TypeVariableName.get("T")).build());

			// rpc(String method, Object... args) - varargs overload for RPC with extra
			// arguments.
			// The Godot API declares rpc as is_vararg, meaning additional arguments after
			// "method" are forwarded to the remote method call.
			MethodBindRef rpcBind = findMethodBind(classInfo, "rpc");
			builder.addMethod(MethodSpec.methodBuilder("rpc").addModifiers(Modifier.PUBLIC).returns(int.class)
					.addParameter(String.class, "method").addParameter(ArrayTypeName.of(Object.class), "args")
					.varargs(true).addStatement("java.lang.Object[] allArgs = new java.lang.Object[1 + args.length]")
					.addStatement("allArgs[0] = (java.lang.Object) method")
					.addStatement("$T.arraycopy(args, 0, allArgs, 1, args.length)", System.class)
					.addStatement("return (int) callEngine($S, $S, $LL, allArgs)", rpcBind.className(), "rpc",
							rpcBind.hash())
					.build());

			// rpcId(long peer_id, String method, Object... args) - varargs overload.
			// The Godot API declares rpc_id as is_vararg with additional args forwarded.
			MethodBindRef rpcIdBind = findMethodBind(classInfo, "rpc_id");
			builder.addMethod(MethodSpec.methodBuilder("rpcId").addModifiers(Modifier.PUBLIC).returns(int.class)
					.addParameter(long.class, "peer_id").addParameter(String.class, "method")
					.addParameter(ArrayTypeName.of(Object.class), "args").varargs(true)
					.addStatement("java.lang.Object[] allArgs = new java.lang.Object[2 + args.length]")
					.addStatement("allArgs[0] = java.lang.Long.valueOf(peer_id)")
					.addStatement("allArgs[1] = (java.lang.Object) method")
					.addStatement("$T.arraycopy(args, 0, allArgs, 2, args.length)", System.class)
					.addStatement("return (int) callEngine($S, $S, $LL, allArgs)", rpcIdBind.className(), "rpc_id",
							rpcIdBind.hash())
					.build());
		}

		if ("MultiplayerSpawner".equals(name)) {
			ClassName nodeType = ClassName.get(packageName, "Node");
			MethodBindRef spawnBind = findMethodBind(classInfo, "spawn");

			builder.addMethod(MethodSpec.methodBuilder("spawnData").addModifiers(Modifier.PUBLIC).returns(nodeType)
					.addParameter(ArrayTypeName.of(TypeName.get(java.lang.Object.class)), "data").varargs(true)
					.addStatement("return ($T) callEngine($S, $S, $LL, new java.lang.Object[] { data })", nodeType,
							spawnBind.className(), "spawn", spawnBind.hash())
					.build());
		}

		if ("Image".equals(name)) {
			MethodBindRef getDataBind = findMethodBind(classInfo, "get_data");
			builder.addMethod(
					MethodSpec.methodBuilder("getImageData").addModifiers(Modifier.PUBLIC).returns(byte[].class)
							.addStatement("return (byte[]) callEngine($S, $S, $LL, new java.lang.Object[0])",
									getDataBind.className(), "get_data", getDataBind.hash())
							.build());
		}

		if ("PackedScene".equals(name)) {
			ClassName nodeType = ClassName.get(packageName, "Node");

			builder.addMethod(MethodSpec.methodBuilder("instantiateAs").addModifiers(Modifier.PUBLIC)
					.addTypeVariable(TypeVariableName.get("T", nodeType)).returns(TypeVariableName.get("T"))
					.addParameter(ParameterizedTypeName.get(ClassName.get(Class.class), TypeVariableName.get("T")),
							"type")
					.addAnnotation(AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "$S", "unchecked")
							.build())
					.addStatement("$T node = instantiate(GenEditState.GEN_EDIT_STATE_DISABLED)", nodeType)
					.addStatement("if (node == null) return null")
					.addStatement("return ($T) node", TypeVariableName.get("T")).build());
		}
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

			// Add fromValue() for non-bitfield enums
			if (!enumInfo.isBitfield()) {
				enumBuilder.addMethod(MethodSpec.methodBuilder("fromValue")
						.addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(ClassName.get("", enumInfo.name()))
						.addParameter(int.class, "value").beginControlFlow("for (var e : values())")
						.addStatement("if (e.value == value) return e").endControlFlow().addStatement("return null")
						.build());
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

		// Build set of property Java accessor names (getXxx, setXxx, isXxx)
		// to avoid generating duplicate methods when a Godot method name
		// converts to the same Java name as a property accessor.
		Set<String> propertyJavaAccessorNames = new java.util.HashSet<>();

		for (PropertyInfo prop : classInfo.properties()) {
			String javaPropName = toJavaPropertyName(prop.name());
			String capitalized = Character.toUpperCase(javaPropName.charAt(0)) + javaPropName.substring(1);
			if (prop.getter() != null && !prop.getter().isEmpty()) {
				propertyJavaAccessorNames.add("get" + capitalized);
				propertyJavaAccessorNames.add("is" + capitalized);
			}
			if (prop.setter() != null && !prop.setter().isEmpty()) {
				propertyJavaAccessorNames.add("set" + capitalized);
			}
		}

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

			String javaMethodName = toJavaMethodName(method.name());

			// Skip methods whose Java name collides with a property accessor
			if (propertyJavaAccessorNames.contains(javaMethodName)) {
				continue;
			}

			String returnType = getEnumAwareReturnType(method);

			// Build parameter list
			List<ParameterSpec> params = new ArrayList<>();
			List<String> paramNames = new ArrayList<>();
			List<String> paramTypes = new ArrayList<>();
			for (int i = 0; i < method.arguments().size(); i++) {
				ArgInfo arg = method.arguments().get(i);
				String javaType = getEnumAwareParamType(arg);
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

			MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(javaMethodName).addParameters(params);

			if (method.isStatic()) {
				// Static method: use callStatic with class name and hash
				methodBuilder.addModifiers(Modifier.PUBLIC, Modifier.STATIC);
				if (!returnType.equals("void")) {
					methodBuilder.returns(toTypeName(returnType));
					String typedHelper = TypedCallSupport.helperName(method, true);
					if (typedHelper != null && TypedCallSupport.argumentsSupported(method)) {
						if (isEnumReturnType(method)) {
							methodBuilder.addStatement("return $T.fromValue($L($S, $S, $L$L$L))",
									toTypeName(returnType), typedHelper, classInfo.name(), method.name(),
									method.hash() + "L", TypedCallSupport.returnMetadataArgs(method),
									hasEnumParams(method)
											? buildEnumAwareCallArgs(method, paramNames)
											: TypedCallSupport.callArgs(method, paramNames));
						} else {
							methodBuilder.addStatement("return $L($S, $S, $L$L$L)", typedHelper, classInfo.name(),
									method.name(), method.hash() + "L", TypedCallSupport.returnMetadataArgs(method),
									hasEnumParams(method)
											? buildEnumAwareCallArgs(method, paramNames)
											: TypedCallSupport.callArgs(method, paramNames));
						}
					} else {
						if (isEnumReturnType(method)) {
							methodBuilder.addStatement(
									"return $T.fromValue(((java.lang.Number) callStatic($S, $S, $L$L)).intValue())",
									toTypeName(returnType), classInfo.name(), method.name(), method.hash() + "L",
									callArgs);
						} else {
							methodBuilder.addStatement("return ($T) callStatic($S, $S, $L$L)", toTypeName(returnType),
									classInfo.name(), method.name(), method.hash() + "L", callArgs);
						}
					}
				} else {
					String typedHelper = TypedCallSupport.helperName(method, true);
					if (typedHelper != null && TypedCallSupport.argumentsSupported(method)) {
						methodBuilder.addStatement("$L($S, $S, $L$L$L)", typedHelper, classInfo.name(), method.name(),
								method.hash() + "L", TypedCallSupport.returnMetadataArgs(method),
								hasEnumParams(method)
										? buildEnumAwareCallArgs(method, paramNames)
										: TypedCallSupport.callArgs(method, paramNames));
					} else {
						methodBuilder.addStatement("callStatic($S, $S, $L$L)", classInfo.name(), method.name(),
								method.hash() + "L", callArgs);
					}
				}
			} else {
				methodBuilder.addModifiers(Modifier.PUBLIC);
				if (!returnType.equals("void")) {
					methodBuilder.returns(toTypeName(returnType));
					String typedHelper = TypedCallSupport.helperName(method, false);
					if (typedHelper != null && TypedCallSupport.argumentsSupported(method)) {
						if (isEnumReturnType(method)) {
							methodBuilder.addStatement("return $T.fromValue($L($S, $S, $L$L$L))",
									toTypeName(returnType), typedHelper, classInfo.name(), method.name(),
									method.hash() + "L", TypedCallSupport.returnMetadataArgs(method),
									hasEnumParams(method)
											? buildEnumAwareCallArgs(method, paramNames)
											: TypedCallSupport.callArgs(method, paramNames));
						} else {
							methodBuilder.addStatement("return $L($S, $S, $L$L$L)", typedHelper, classInfo.name(),
									method.name(), method.hash() + "L", TypedCallSupport.returnMetadataArgs(method),
									hasEnumParams(method)
											? buildEnumAwareCallArgs(method, paramNames)
											: TypedCallSupport.callArgs(method, paramNames));
						}
					} else {
						if (isEnumReturnType(method)) {
							methodBuilder.addStatement(
									"return $T.fromValue(((java.lang.Number) callEngine($S, $S, $L$L)).intValue())",
									toTypeName(returnType), classInfo.name(), method.name(), method.hash() + "L",
									callArgs);
						} else {
							methodBuilder.addStatement("return ($T) callEngine($S, $S, $L$L)", toTypeName(returnType),
									classInfo.name(), method.name(), method.hash() + "L", callArgs);
						}
					}
				} else {
					String typedHelper = TypedCallSupport.helperName(method, false);
					if (typedHelper != null && TypedCallSupport.argumentsSupported(method)) {
						methodBuilder.addStatement("$L($S, $S, $L$L$L)", typedHelper, classInfo.name(), method.name(),
								method.hash() + "L", TypedCallSupport.returnMetadataArgs(method),
								hasEnumParams(method)
										? buildEnumAwareCallArgs(method, paramNames)
										: TypedCallSupport.callArgs(method, paramNames));
					} else {
						methodBuilder.addStatement("callEngine($S, $S, $L$L)", classInfo.name(), method.name(),
								method.hash() + "L", callArgs);
					}
				}
			}

			builder.addMethod(methodBuilder.build());

			// Generate overloads for trailing default-value parameters
			generateDefaultOverloads(builder, classInfo, method, javaMethodName, returnType, params, paramNames,
					paramTypes, generatedSignatures);
		}
	}

	/**
	 * Generate convenience overloads by progressively omitting trailing parameters
	 * that have default values.
	 */
	private void generateDefaultOverloads(TypeSpec.Builder builder, ClassInfo classInfo, MethodInfo method,
			String javaMethodName, String returnType, List<ParameterSpec> fullParams, List<String> paramNames,
			List<String> paramTypes, Set<String> generatedSignatures) {
		List<ArgInfo> args = method.arguments();
		if (args.isEmpty()) {
			return;
		}

		// Find the first trailing argument with a default value
		int firstDefaultIdx = -1;
		for (int i = args.size() - 1; i >= 0; i--) {
			if (args.get(i).defaultValue() != null) {
				firstDefaultIdx = i;
			} else {
				break;
			}
		}
		if (firstDefaultIdx < 0) {
			return;
		}

		// Generate overloads from removing 1, 2, ... trailing defaults
		for (int cutAt = args.size() - 1; cutAt >= firstDefaultIdx; cutAt--) {
			int overloadArgCount = cutAt;

			// Skip this overload if any omitted default value can't be expressed in Java
			// (e.g., null for primitive types like long, or 0 for Godot class types)
			boolean skipOverload = false;
			for (int i = overloadArgCount; i < args.size(); i++) {
				String defVal = defaultValueToJava(args.get(i), paramTypes.get(i));
				String paramType = paramTypes.get(i);
				if ("null".equals(defVal) && isPrimitiveType(paramType)) {
					skipOverload = true;
					break;
				}
				if ("null".equals(defVal) && !isPrimitiveType(paramType) && !"String".equals(paramType)) {
					// null is fine for reference types (except String which maps to java String)
				}
				if (!"null".equals(defVal) && !isPrimitiveType(paramType) && !"String".equals(paramType)
						&& !"double".equals(paramType) && !"float".equals(paramType)) {
					// Numeric default for a Godot class type — can't convert
					if (defVal.matches("-?\\d+L?") || defVal.matches("-?\\d+\\.\\d*f?")) {
						skipOverload = true;
						break;
					}
				}
			}
			if (skipOverload) {
				continue;
			}

			List<ParameterSpec> overloadParams = new ArrayList<>();
			List<String> overloadTypes = new ArrayList<>();
			for (int i = 0; i < overloadArgCount; i++) {
				overloadParams.add(fullParams.get(i));
				overloadTypes.add(paramTypes.get(i));
			}

			String overloadSig = javaMethodName + "(" + String.join(",", overloadTypes) + ")";
			if (!generatedSignatures.add(overloadSig)) {
				continue;
			}

			StringBuilder delegateArgs = new StringBuilder();
			for (int i = 0; i < overloadArgCount; i++) {
				if (delegateArgs.length() > 0)
					delegateArgs.append(", ");
				delegateArgs.append(paramNames.get(i));
			}
			for (int i = overloadArgCount; i < args.size(); i++) {
				if (delegateArgs.length() > 0)
					delegateArgs.append(", ");
				delegateArgs.append(defaultValueToJava(args.get(i), paramTypes.get(i)));
			}

			MethodSpec.Builder overloadBuilder = MethodSpec.methodBuilder(javaMethodName).addParameters(overloadParams);
			if (method.isStatic()) {
				overloadBuilder.addModifiers(Modifier.PUBLIC, Modifier.STATIC);
			} else {
				overloadBuilder.addModifiers(Modifier.PUBLIC);
			}

			String delegateCall = javaMethodName + "(" + delegateArgs + ")";
			if (!returnType.equals("void")) {
				overloadBuilder.returns(toTypeName(returnType));
				overloadBuilder.addStatement("return " + delegateCall);
			} else {
				overloadBuilder.addStatement(delegateCall);
			}

			builder.addMethod(overloadBuilder.build());
		}
	}

	private boolean isPrimitiveType(String javaType) {
		return switch (javaType) {
			case "boolean", "byte", "short", "int", "long", "float", "double", "char" -> true;
			default -> false;
		};
	}

	private String defaultValueToJava(ArgInfo arg, String javaType) {
		String dv = arg.defaultValue();
		if (dv == null) {
			return "null";
		}
		switch (dv) {
			case "false" :
				return "false";
			case "true" :
				return "true";
			case "null" :
				return "null";
			default :
				break;
		}
		if (dv.matches("-?\\d+")) {
			// Enum types (ClassName.EnumName format, not fully qualified)
			if (javaType.contains(".") && !javaType.startsWith("java.")
					&& javaType.indexOf('.') == javaType.lastIndexOf('.')) {
				return javaType + ".fromValue(" + dv + ")";
			}
			switch (javaType) {
				case "java.math.BigInteger" :
					return "java.math.BigInteger.valueOf(" + dv + "L)";
				case "long" :
					return dv + "L";
				case "int" :
					return dv;
				case "short" :
					return "(short)" + dv;
				case "byte" :
					return "(byte)" + dv;
				default :
					return dv;
			}
		}
		if (dv.matches("-?\\d+\\.\\d*")) {
			switch (javaType) {
				case "double" :
					return dv;
				case "float" :
					return dv + "f";
				default :
					return dv;
			}
		}
		if (dv.startsWith("\"") && dv.endsWith("\"")) {
			return dv;
		}
		if (dv.endsWith("()")) {
			switch (javaType) {
				case "byte[]" :
					return "new byte[0]";
				case "int[]" :
					return "new int[0]";
				case "long[]" :
					return "new long[0]";
				case "double[]" :
					return "new double[0]";
				case "String[]" :
					return "new String[0]";
				case "double[][]" :
					return "new double[0][]";
				default :
					return "null";
			}
		}
		return "null";
	}

	/**
	 * Build a map of all accessor Java names to their Java return types by walking
	 * up the inheritance chain. Includes both property accessors and regular
	 * methods to detect parent/child conflicts.
	 */
	private Map<String, String> buildParentAccessorTypes(ClassInfo classInfo) {
		Map<String, String> result = new HashMap<>();
		String parentName = classInfo.inherits();
		while (parentName != null && !parentName.isEmpty()) {
			ClassInfo parent = classMap.get(parentName);
			if (parent == null)
				break;
			// Collect property accessor types
			for (PropertyInfo prop : parent.properties()) {
				String propJavaName = toJavaPropertyName(prop.name());
				String propJavaType = toSingleJavaType(prop.type());
				String capitalized = capitalize(propJavaName);
				String getterMethod = prop.getter();
				if (getterMethod != null && getterMethod.startsWith("is_")) {
					result.putIfAbsent("is" + capitalized, propJavaType);
				} else {
					result.putIfAbsent("get" + capitalized, propJavaType);
				}
				result.putIfAbsent("set" + capitalized, propJavaType);
			}
			// Collect method return types (to detect method-property conflicts)
			for (MethodInfo m : parent.methods()) {
				String javaName = toJavaMethodName(m.name());
				String javaRetType = getReturnType(m);
				if (javaRetType != null && !javaRetType.equals("void")) {
					result.putIfAbsent(javaName, javaRetType);
				}
			}
			parentName = parent.inherits();
		}
		return result;
	}

	private record MethodBindRef(String className, long hash, MethodInfo method) {
	}

	private MethodBindRef findMethodBind(ClassInfo classInfo, String methodName) {
		String currentName = classInfo.name();
		while (currentName != null && !currentName.isEmpty()) {
			ClassInfo current = classMap.get(currentName);
			if (current == null)
				break;
			for (MethodInfo method : current.methods()) {
				if (method.name().equals(methodName)) {
					return new MethodBindRef(current.name(), method.hash(), method);
				}
			}
			currentName = current.inherits();
		}
		return new MethodBindRef(classInfo.name(), 0L, null);
	}

	/**
	 * Add property getter/setter methods.
	 */
	private void addProperties(TypeSpec.Builder builder, ClassInfo classInfo) {
		Map<String, String> parentAccessorTypes = buildParentAccessorTypes(classInfo);

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

			// Skip if parent has same accessor name with different type
			String parentGetterType = parentAccessorTypes.get(getterName);
			if (parentGetterType != null && !parentGetterType.equals(javaType)) {
				continue;
			}

			MethodBindRef getterBind = findMethodBind(classInfo, getterMethod);
			MethodSpec.Builder getterBuilder = MethodSpec.methodBuilder(getterName).addModifiers(Modifier.PUBLIC)
					.returns(toTypeName(javaType));
			String typedGetter = getterBind.method() != null
					? TypedCallSupport.helperName(getterBind.method(), false)
					: null;
			if (typedGetter != null
					&& TypedCallSupport.propertyGetterFallbackReason(getterBind.method(), javaType) == null) {
				getterBuilder.addStatement("return $L($S, $S, $LL$L)", typedGetter, getterBind.className(),
						getterMethod, getterBind.hash(), TypedCallSupport.returnMetadataArgs(getterBind.method()));
			} else {
				getterBuilder.addStatement("return ($T) callEngine($S, $S, $LL, new java.lang.Object[0])",
						toTypeName(javaType), getterBind.className(), getterMethod, getterBind.hash());
			}
			MethodSpec getterSpec = getterBuilder.build();
			builder.addMethod(getterSpec);

			// Determine setter method name
			String setterMethod = prop.setter();
			if (setterMethod == null || setterMethod.isEmpty()) {
				setterMethod = "set_" + prop.name();
			}

			String setterName = "set" + capitalize(javaPropName);

			MethodBindRef setterBind = findMethodBind(classInfo, setterMethod);
			MethodSpec.Builder setterBuilder = MethodSpec.methodBuilder(setterName).addModifiers(Modifier.PUBLIC)
					.addParameter(toTypeName(javaType), "value");
			String typedSetter = setterBind.method() != null
					? TypedCallSupport.helperName(setterBind.method(), false)
					: null;
			if (typedSetter != null
					&& TypedCallSupport.propertySetterFallbackReason(setterBind.method(), javaType) == null) {
				setterBuilder.addStatement("$L($S, $S, $LL$L)", typedSetter, setterBind.className(), setterMethod,
						setterBind.hash(), TypedCallSupport.callArgs(setterBind.method(), List.of("value")));
			} else {
				setterBuilder.addStatement(
						"callEngine($S, $S, $LL, new java.lang.Object[] { " + boxToObject("value", javaType) + " })",
						setterBind.className(), setterMethod, setterBind.hash());
			}
			MethodSpec setterSpec = setterBuilder.build();
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
			Map.entry("Variant", "org.godot.core"), Map.entry("GodotString", "org.godot.core"),
			Map.entry("GodotStringName", "org.godot.core"), Map.entry("GodotVariant", "org.godot.core"), // Collection
																											// package
			Map.entry("GodotArray", "org.godot.collection"), Map.entry("GodotDictionary", "org.godot.collection"));

	private static final Map<String, String> JAVA_BOXED_TYPES = Map.of("Boolean", "java.lang", "Byte", "java.lang",
			"Short", "java.lang", "Integer", "java.lang", "Long", "java.lang", "Float", "java.lang", "Double",
			"java.lang", "String", "java.lang");

	private ClassName superClassRef(String godotParentName) {
		// All engine classes (Object, RefCounted, Node, etc.) are in org.godot.node
		return ClassName.get(packageName, godotParentName);
	}

	private TypeName toTypeName(String type) {
		if (type == null || type.isEmpty()) {
			return TypeName.get(java.lang.Object.class);
		}

		if (type.equals("Object") || type.equals("java.lang.Object")) {
			return TypeName.get(java.lang.Object.class);
		}

		// Handle parameterized types like "GodotArray<String>" or
		// "GodotDictionary<Long, String>"
		int lt = type.indexOf('<');
		if (lt > 0 && type.endsWith(">")) {
			String rawType = type.substring(0, lt);
			String params = type.substring(lt + 1, type.length() - 1);
			ClassName raw = resolveClassName(rawType);
			List<TypeName> typeArgs = parseTypeArgs(params);
			return ParameterizedTypeName.get(raw, typeArgs.toArray(new TypeName[0]));
		}

		if (type.endsWith("[]")) {
			String component = type.substring(0, type.length() - 2);
			return ArrayTypeName.of(toTypeName(component));
		}

		// Cross-package type (Vector2, Color, etc.)
		if (CROSS_PACKAGE_TYPES.containsKey(type)) {
			return ClassName.get(CROSS_PACKAGE_TYPES.get(type), type);
		}

		// Java boxed primitive types (Long, String, etc.) used as generic type
		// arguments
		if (JAVA_BOXED_TYPES.containsKey(type)) {
			return ClassName.get(JAVA_BOXED_TYPES.get(type), type);
		}

		// Nested types (enum references): "Tree.SelectMode" ->
		// ClassName.get(packageName, "Tree", "SelectMode")
		int dot = type.indexOf('.');
		if (dot > 0 && !type.startsWith("GodotArray") && !type.startsWith("GodotDictionary")) {
			String outer = type.substring(0, dot);
			String inner = type.substring(dot + 1);
			String outerPkg = CROSS_PACKAGE_TYPES.getOrDefault(outer, packageName);
			return ClassName.get(outerPkg, outer, inner);
		}

		return ClassName.get(packageName, type);
	}

	private ClassName resolveClassName(String type) {
		if (CROSS_PACKAGE_TYPES.containsKey(type)) {
			return ClassName.get(CROSS_PACKAGE_TYPES.get(type), type);
		}
		// Java boxed primitive types used as generic arguments
		if (JAVA_BOXED_TYPES.containsKey(type)) {
			return ClassName.get(JAVA_BOXED_TYPES.get(type), type);
		}
		return ClassName.get(packageName, type);
	}

	private List<TypeName> parseTypeArgs(String params) {
		List<TypeName> args = new ArrayList<>();
		int depth = 0;
		int start = 0;
		for (int i = 0; i < params.length(); i++) {
			char c = params.charAt(i);
			if (c == '<')
				depth++;
			else if (c == '>')
				depth--;
			else if (c == ',' && depth == 0) {
				args.add(toTypeName(params.substring(start, i).trim()));
				start = i + 1;
			}
		}
		args.add(toTypeName(params.substring(start).trim()));
		return args;
	}

	// ------------------------------------------------------------------
	// Name conversion utilities
	// ------------------------------------------------------------------

	private String toJavaMethodName(String godotName) {
		// Methods from java.lang.Object that cannot be overridden
		if (godotName.equals("wait") || godotName.equals("notify") || godotName.equals("notifyAll")
				|| godotName.equals("equals") || godotName.equals("hashCode") || godotName.equals("toString")
				|| godotName.equals("get_class")) {
			return godotName + "_";
		}

		// Convert snake_case to camelCase for Java convention
		String name = godotName;
		if (godotName.contains("_")) {
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
			name = result.toString();
		}

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

	private boolean isEnumReturnType(MethodInfo method) {
		return resolveEnumType(method.returnType()) != null;
	}

	private String resolveEnumType(String godotType) {
		if (godotType == null || !godotType.startsWith("enum::")) {
			return null;
		}
		String enumRef = godotType.substring("enum::".length());
		int dot = enumRef.indexOf('.');
		if (dot <= 0) {
			return null;
		}
		String className = enumRef.substring(0, dot);
		if (!classMap.containsKey(className)) {
			return null;
		}
		return enumRef;
	}

	private String getEnumAwareParamType(ArgInfo arg) {
		String resolved = resolveEnumType(arg.type());
		if (resolved != null) {
			return resolved;
		}
		return TypeMapper.getJavaParamType(arg.type(), arg.meta());
	}

	private String getEnumAwareReturnType(MethodInfo method) {
		if (method.returnType() == null || method.returnType().isEmpty()) {
			return "void";
		}
		String resolved = resolveEnumType(method.returnType());
		if (resolved != null) {
			return resolved;
		}
		return getReturnType(method);
	}

	private boolean hasEnumParams(MethodInfo method) {
		for (ArgInfo arg : method.arguments()) {
			if (resolveEnumType(arg.type()) != null)
				return true;
		}
		return false;
	}

	/**
	 * Build typed call args, using .value for enum-typed parameters.
	 */
	private String buildEnumAwareCallArgs(MethodInfo method, List<String> paramNames) {
		if (method.arguments().isEmpty()) {
			return "";
		}
		StringBuilder args = new StringBuilder();
		for (int i = 0; i < method.arguments().size(); i++) {
			args.append(", ");
			ArgInfo arg = method.arguments().get(i);
			if (resolveEnumType(arg.type()) != null) {
				// Resolved enum type: extract int value
				args.append(paramNames.get(i)).append(".value");
			} else {
				// Non-enum: use TypedCallSupport
				String expr = TypedCallSupport.argExpression(arg, paramNames.get(i));
				if (expr != null) {
					args.append(expr);
				} else {
					return null; // unsupported arg type
				}
			}
		}
		return args.toString();
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

	// ------------------------------------------------------------------
	// Signal generation
	// ------------------------------------------------------------------

	private List<SignalInfo> collectAllSignals(ClassInfo classInfo) {
		List<SignalInfo> allSignals = new ArrayList<>();
		Set<String> seen = new java.util.HashSet<>();
		String currentName = classInfo.name();
		while (currentName != null && !currentName.isEmpty()) {
			ClassInfo current = classMap.get(currentName);
			if (current == null)
				break;
			for (SignalInfo signal : current.signals()) {
				if (seen.add(signal.name())) {
					allSignals.add(signal);
				}
			}
			currentName = current.inherits();
		}
		return allSignals;
	}

	private String findSignalsOfParent(ClassInfo classInfo) {
		String parentName = classInfo.inherits();
		while (parentName != null && !parentName.isEmpty()) {
			ClassInfo parent = classMap.get(parentName);
			if (parent == null)
				return null;
			if (!collectAllSignals(parent).isEmpty()) {
				return parentName;
			}
			parentName = parent.inherits();
		}
		return null;
	}

	private void addSignals(TypeSpec.Builder builder, ClassInfo classInfo) {
		List<SignalInfo> allSignals = collectAllSignals(classInfo);
		if (allSignals.isEmpty()) {
			return;
		}
		String signalsClassName = "SignalsOf" + classInfo.name();
		ClassName signalsType = ClassName.get(packageName, signalsClassName);

		builder.addField(FieldSpec.builder(signalsType, "_signals", Modifier.PRIVATE).build());

		builder.addMethod(MethodSpec.methodBuilder("signals").addModifiers(Modifier.PUBLIC).returns(signalsType)
				.beginControlFlow("if (_signals == null)").addStatement("_signals = new $T(this)", signalsType)
				.endControlFlow().addStatement("return _signals").build());
	}

	public JavaFile generateSignalsOf(ClassInfo classInfo) {
		List<SignalInfo> allSignals = collectAllSignals(classInfo);
		if (allSignals.isEmpty()) {
			return null;
		}

		String signalsClassName = "SignalsOf" + classInfo.name();
		ClassName ownerType = ClassName.get(packageName, classInfo.name());

		TypeSpec.Builder signalsBuilder = TypeSpec.classBuilder(signalsClassName).addModifiers(Modifier.PUBLIC);

		// Find parent with signals for inheritance
		String signalsParent = findSignalsOfParent(classInfo);
		if (signalsParent != null) {
			signalsBuilder.superclass(ClassName.get(packageName, "SignalsOf" + signalsParent));
		}

		if (signalsParent == null) {
			// Root class: own the owner field
			signalsBuilder.addField(FieldSpec
					.builder(ClassName.get("org.godot", "Godot"), "owner", Modifier.PROTECTED, Modifier.FINAL).build());
			signalsBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
					.addParameter(ownerType, "owner").addStatement("this.owner = owner").build());
		} else {
			// Child class: delegate to parent constructor
			signalsBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
					.addParameter(ownerType, "owner").addStatement("super(owner)").build());
		}

		// Only this class's OWN signals (inherited ones come from parent)
		for (SignalInfo signal : classInfo.signals()) {
			addSignalAccessor(signalsBuilder, signal);
		}

		return JavaFile.builder(packageName, signalsBuilder.build()).skipJavaLangImports(false).indent("	").build();
	}

	private void addSignalAccessor(TypeSpec.Builder builder, SignalInfo signal) {
		int arity = signal.arguments().size();
		if (arity > 5) {
			return;
		}

		String signalJavaName = toJavaMethodName(signal.name());
		ClassName signalType = ClassName.get("org.godot.core", "TypedSignal" + arity);

		TypeName returnType;
		if (arity == 0) {
			returnType = signalType;
		} else {
			List<TypeName> typeParams = new ArrayList<>();
			for (ArgInfo arg : signal.arguments()) {
				String javaType = getSignalParamJavaType(arg);
				typeParams.add(toTypeName(javaType));
			}
			returnType = ParameterizedTypeName.get(signalType, typeParams.toArray(new TypeName[0]));
		}

		builder.addMethod(MethodSpec.methodBuilder(signalJavaName).addModifiers(Modifier.PUBLIC).returns(returnType)
				.addStatement("return new $T(owner, $S)", returnType, signal.name()).build());
	}

	private String getSignalParamJavaType(ArgInfo arg) {
		String enumResolved = resolveEnumType(arg.type());
		if (enumResolved != null) {
			return enumResolved;
		}
		String javaType = TypeMapper.getJavaParamType(arg.type(), arg.meta());
		return TypeMapper.boxType(javaType);
	}
}
