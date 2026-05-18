package org.godot.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Compile-time annotation processor for godot-java.
 *
 * <p>
 * Generates:
 * <ol>
 * <li>{@code GeneratedClassRegistry} — list of all @GodotClass-annotated
 * classes (replaces runtime classpath scanning).</li>
 * <li>{@code DispatchIndex} — consolidated dispatch index replacing all
 * scattered VirtualDispatch_*, TypedDispatch_*, VirtualMethodDispatch_* files.
 * Zero runtime reflection.</li>
 * </ol>
 */
@javax.annotation.processing.SupportedAnnotationTypes({"org.godot.annotation.GodotClass",
		"org.godot.annotation.GodotMethod", "org.godot.annotation.Export", "org.godot.annotation.Signal",
		"org.godot.annotation.Rpc", "org.godot.annotation.Tool", "org.godot.annotation.Constant",
		"org.godot.annotation.GetProperty", "org.godot.annotation.SetProperty", "org.godot.annotation.GetPropertyList",
		"org.godot.annotation.ValidateProperty"})
@javax.annotation.processing.SupportedSourceVersion(SourceVersion.RELEASE_25)
public class GodotClassProcessor extends AbstractProcessor {

	private static final String REGISTRY_PACKAGE = "org.godot.internal";
	private static final String REGISTRY_CLASS = "GeneratedClassRegistry";
	private static final String REGISTRY_FQN = REGISTRY_PACKAGE + "." + REGISTRY_CLASS;
	private static final String VIRTUAL_METHOD_INDEX = "/virtual_method_index.txt";

	/** All @GodotClass elements accumulated across rounds. */
	private final List<ClassEntry> discoveredClasses = new ArrayList<>();

	/** Parsed virtual method index: className → (methodName → hash). */
	private Map<String, Map<String, Long>> classVirtualMethods;

	/** Parsed inheritance: className → parent class name. */
	private Map<String, String> classInherits;

	private boolean indexLoaded = false;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		loadVirtualMethodIndex();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement annotation : annotations) {
			for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
				if (element instanceof TypeElement typeElement) {
					String fqn = typeElement.getQualifiedName().toString();
					try {
						var anno = element.getAnnotation(org.godot.annotation.GodotClass.class);
						if (anno != null) {
							boolean isTool = typeElement.getAnnotation(org.godot.annotation.Tool.class) != null;
							boolean isSingleton = anno.singleton();
							boolean isInternal = anno.internal();
							boolean noInit = anno.noInit();
							discoveredClasses.add(new ClassEntry(fqn, anno.name(), anno.parent(), isTool, isSingleton,
									isInternal, noInit));
						}
					} catch (Exception e) {
						discoveredClasses.add(new ClassEntry(fqn, typeElement.getSimpleName().toString(), "RefCounted",
								false, false, false, false));
					}
				}
			}
		}

		if (roundEnv.processingOver()) {
			generateRegistry();
			generateDispatchIndex();
			generateSignalFacades();
			return true;
		}

		return true;
	}

	// -----------------------------------------------------------------------
	// Virtual method index loading
	// -----------------------------------------------------------------------

	private void loadVirtualMethodIndex() {
		classVirtualMethods = new HashMap<>();
		classInherits = new HashMap<>();

		try (InputStream is = getClass().getResourceAsStream(VIRTUAL_METHOD_INDEX)) {
			if (is == null) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
						"virtual_method_index.txt not found on classpath.");
				return;
			}

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
				String currentClass = null;

				String line;
				while ((line = reader.readLine()) != null) {
					line = line.trim();
					if (line.isEmpty() || line.startsWith("#")) {
						continue;
					}

					int colonIdx = line.indexOf(':');
					if (colonIdx > 0 && !line.contains("=")) {
						currentClass = line.substring(0, colonIdx);
						String parent = line.substring(colonIdx + 1);
						classInherits.put(currentClass, parent.isEmpty() ? null : parent);
						classVirtualMethods.put(currentClass, new LinkedHashMap<>());
					} else if (currentClass != null && line.contains("=")) {
						int eqIdx = line.indexOf('=');
						String methodName = line.substring(0, eqIdx);
						long hash = Long.parseUnsignedLong(line.substring(eqIdx + 1));
						classVirtualMethods.get(currentClass).put(methodName, hash);
					}
				}

				indexLoaded = true;
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
						"Loaded virtual method index: " + classInherits.size() + " classes");
			}
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
					"Failed to load virtual_method_index.txt: " + e.getMessage());
		}
	}

	private Map<String, Long> collectVirtualMethodsForHierarchy(String parentClass) {
		Map<String, Long> result = new LinkedHashMap<>();
		Set<String> visited = new HashSet<>();
		String current = parentClass;
		while (current != null && !current.isEmpty() && visited.add(current)) {
			Map<String, Long> methods = classVirtualMethods.get(current);
			if (methods != null) {
				methods.forEach(result::putIfAbsent);
			}
			current = classInherits.get(current);
		}
		return result;
	}

	// -----------------------------------------------------------------------
	// Data records
	// -----------------------------------------------------------------------

	private record ClassEntry(String fqn, String godotClassName, String parentClass, boolean isTool,
			boolean isSingleton, boolean isInternal, boolean noInit) {
	}

	private record MethodInfo(String javaName, String godotName, String returnType, List<String> paramTypes,
			List<String> paramNames) {
	}

	private record FieldInfo(String javaName, String propertyName, String type, int hintId, String hintString,
			int usage, String group, String groupHint, String subgroup, String subgroupHint, String getter,
			String setter, boolean readOnly) {
	}

	private record SignalInfo(String javaName, String signalName, List<String> paramTypes, List<String> paramNames) {
	}

	private record VirtualOverrideInfo(String javaName, String godotName, String returnType,
			List<ParamTypeInfo> params) {
	}

	private record ParamTypeInfo(String fqn, String category) {
	}

	private record RpcInfo(String godotName, int rpcMode, int transferMode, boolean callLocal, int channel) {
	}

	private record RpcProxyInfo(String godotName, List<String> paramTypes) {
	}

	private record ConstantInfo(String name, int value) {
	}

	private record VirtualMethodInfo(String godotName, String returnType, List<String> paramTypes) {
	}

	private record ClassDoc(String briefDesc, String description) {
	}

	private record MethodDoc(String briefDesc, String description) {
	}

	private record PropertyDoc(String description) {
	}

	private record SignalDoc(String description) {
	}

	private record ConstantDoc(String description) {
	}

	// -----------------------------------------------------------------------
	// Member collection
	// -----------------------------------------------------------------------

	private void collectMembers(TypeElement typeElement, List<MethodInfo> methods, List<FieldInfo> fields,
			List<SignalInfo> signals, List<ConstantInfo> constants, List<String> dynamicGetters,
			List<String> dynamicSetters, List<String> dynamicPropertyLists, List<String> validatePropertyMethods) {
		String currentGroup = "";
		String currentGroupHint = "";
		String currentSubgroup = "";
		String currentSubgroupHint = "";
		for (Element member : typeElement.getEnclosedElements()) {
			if (member.getKind() == ElementKind.METHOD) {
				ExecutableElement method = (ExecutableElement) member;

				// Collect @Signal regardless of visibility
				if (method.getAnnotation(org.godot.annotation.Signal.class) != null) {
					org.godot.annotation.Signal signalAnn = method.getAnnotation(org.godot.annotation.Signal.class);
					String signalName = (signalAnn != null && !signalAnn.name().isEmpty())
							? signalAnn.name()
							: method.getSimpleName().toString();
					List<String> paramTypes = new ArrayList<>();
					List<String> paramNames = new ArrayList<>();
					for (VariableElement param : method.getParameters()) {
						paramTypes.add(typeToDescriptor(param.asType()));
						paramNames.add(param.getSimpleName().toString());
					}
					signals.add(new SignalInfo(method.getSimpleName().toString(), signalName, paramTypes, paramNames));
				}

				// @Signal methods are registered as signals, not callable methods
				if (method.getAnnotation(org.godot.annotation.Signal.class) != null) {
					continue;
				}
				// @GetProperty / @SetProperty / @GetPropertyList — dynamic property dispatch
				if (method.getAnnotation(org.godot.annotation.GetProperty.class) != null) {
					dynamicGetters.add(method.getSimpleName().toString());
					continue;
				}
				if (method.getAnnotation(org.godot.annotation.SetProperty.class) != null) {
					dynamicSetters.add(method.getSimpleName().toString());
					continue;
				}
				if (method.getAnnotation(org.godot.annotation.GetPropertyList.class) != null) {
					dynamicPropertyLists.add(method.getSimpleName().toString());
					continue;
				}
				if (method.getAnnotation(org.godot.annotation.ValidateProperty.class) != null) {
					validatePropertyMethods.add(method.getSimpleName().toString());
					continue;
				}
				// Only collect public, non-static methods (skip Object/Godot overrides)
				Set<javax.lang.model.element.Modifier> mods = method.getModifiers();
				if (!mods.contains(javax.lang.model.element.Modifier.PUBLIC)
						|| mods.contains(javax.lang.model.element.Modifier.STATIC)) {
					continue;
				}
				String methodName = method.getSimpleName().toString();
				if (methodName.equals("toString") || methodName.equals("hashCode") || methodName.equals("equals")
						|| methodName.equals("getClass") || methodName.equals("notify")
						|| methodName.equals("notifyAll") || methodName.equals("wait")) {
					continue;
				}

				// @GodotMethod can override the Godot method name
				String godotName = methodName;
				org.godot.annotation.GodotMethod gmAnn = method.getAnnotation(org.godot.annotation.GodotMethod.class);
				if (gmAnn != null && !gmAnn.value().isEmpty()) {
					godotName = gmAnn.value();
				}

				List<String> paramTypes = new ArrayList<>();
				List<String> paramNames = new ArrayList<>();
				for (VariableElement param : method.getParameters()) {
					paramTypes.add(typeToDescriptor(param.asType()));
					paramNames.add(param.getSimpleName().toString());
				}
				String returnType = typeToDescriptor(method.getReturnType());
				methods.add(new MethodInfo(methodName, godotName, returnType, paramTypes, paramNames));
			} else if (member.getKind() == ElementKind.FIELD) {
				VariableElement field = (VariableElement) member;
				// Track group/subgroup state
				org.godot.annotation.ExportGroup groupAnn = field.getAnnotation(org.godot.annotation.ExportGroup.class);
				if (groupAnn != null) {
					currentGroup = groupAnn.value();
					currentGroupHint = groupAnn.hint();
					currentSubgroup = "";
					currentSubgroupHint = "";
				}
				org.godot.annotation.ExportSubgroup subgroupAnn = field
						.getAnnotation(org.godot.annotation.ExportSubgroup.class);
				if (subgroupAnn != null) {
					currentSubgroup = subgroupAnn.value();
					currentSubgroupHint = subgroupAnn.hint();
				}
				if (field.getAnnotation(org.godot.annotation.Export.class) != null) {
					org.godot.annotation.Export ann = field.getAnnotation(org.godot.annotation.Export.class);
					String propName = (ann != null && !ann.propertyName().isEmpty())
							? ann.propertyName()
							: field.getSimpleName().toString();
					int hintId = ann != null ? ann.hint().id() : 0;
					String hintString = ann != null ? ann.hintString() : "";
					int usage = ann != null ? ann.usage().value : (1 | 2 | 4 | 8);
					String getter = ann != null ? ann.getter() : "";
					String setter = ann != null ? ann.setter() : "";
					boolean readOnly = ann != null && ann.readOnly();
					if (readOnly) {
						usage = org.godot.annotation.PropertyUsage.EDITOR_READ_ONLY.value;
						setter = "";
					}
					fields.add(new FieldInfo(field.getSimpleName().toString(), propName,
							typeToDescriptor(field.asType()), hintId, hintString, usage, currentGroup, currentGroupHint,
							currentSubgroup, currentSubgroupHint, getter, setter, readOnly));
				}
			}
		}
	}

	private String typeToDescriptor(TypeMirror type) {
		TypeKind kind = type.getKind();
		return switch (kind) {
			case BOOLEAN -> "boolean";
			case BYTE -> "byte";
			case SHORT -> "short";
			case INT -> "int";
			case LONG -> "long";
			case FLOAT -> "float";
			case DOUBLE -> "double";
			case VOID -> "void";
			case ARRAY, DECLARED -> type.toString();
			default -> type.toString();
		};
	}

	private ParamTypeInfo categorizeParam(TypeMirror type) {
		TypeKind kind = type.getKind();
		return switch (kind) {
			case DOUBLE -> new ParamTypeInfo("double", "DOUBLE");
			case FLOAT -> new ParamTypeInfo("float", "FLOAT");
			case INT -> new ParamTypeInfo("int", "INT");
			case LONG -> new ParamTypeInfo("long", "LONG");
			case BOOLEAN -> new ParamTypeInfo("boolean", "BOOLEAN");
			default -> {
				String fqn = type.toString();
				if ("java.lang.String".equals(fqn)) {
					yield new ParamTypeInfo(fqn, "STRING");
				} else if (isGodotSubclass(type)) {
					yield new ParamTypeInfo(fqn, "GODOT_OBJECT");
				} else {
					yield new ParamTypeInfo(fqn, "UNKNOWN");
				}
			}
		};
	}

	private boolean isGodotSubclass(TypeMirror type) {
		TypeElement godotElement = processingEnv.getElementUtils().getTypeElement("org.godot.Godot");
		if (godotElement == null)
			return false;
		return processingEnv.getTypeUtils().isSubtype(type, godotElement.asType());
	}

	private String javaToGodotMethodName(String javaName) {
		if (javaName.length() <= 1)
			return javaName;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < javaName.length(); i++) {
			char c = javaName.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append('_').append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private String javaTypeForVarHandle(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "boolean.class";
			case "int" -> "int.class";
			case "long" -> "long.class";
			case "float" -> "float.class";
			case "double" -> "double.class";
			default -> descriptor + ".class";
		};
	}

	private String javaTypeForMethodHandle(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "boolean.class";
			case "int" -> "int.class";
			case "long" -> "long.class";
			case "float" -> "float.class";
			case "double" -> "double.class";
			default -> descriptor + ".class";
		};
	}

	// -----------------------------------------------------------------------
	// Generate GeneratedClassRegistry.java
	// -----------------------------------------------------------------------

	private void generateRegistry() {
		try {
			JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(REGISTRY_FQN);
			try (Writer writer = sourceFile.openWriter()) {
				writer.write("package " + REGISTRY_PACKAGE + ";\n\n");
				writer.write("import java.util.List;\n");
				writer.write("import java.util.ArrayList;\n\n");
				writer.write("public final class " + REGISTRY_CLASS + " {\n\n");
				writer.write("    private " + REGISTRY_CLASS + "() {}\n\n");

				if (discoveredClasses.isEmpty()) {
					writer.write("    public static List<Class<?>> getRegisteredClasses() {\n");
					writer.write("        return List.of();\n");
					writer.write("    }\n");
				} else {
					int chunkSize = 200;
					List<String> fqns = discoveredClasses.stream().map(e -> e.fqn).toList();
					int chunks = (fqns.size() + chunkSize - 1) / chunkSize;

					if (chunks == 1) {
						writer.write("    public static List<Class<?>> getRegisteredClasses() {\n");
						writer.write("        return List.of(\n");
						for (int i = 0; i < fqns.size(); i++) {
							writer.write("            " + fqns.get(i) + ".class");
							if (i < fqns.size() - 1) {
								writer.write(",");
							}
							writer.write("\n");
						}
						writer.write("        );\n");
						writer.write("    }\n");
					} else {
						writer.write("    public static List<Class<?>> getRegisteredClasses() {\n");
						writer.write("        List<Class<?>> classes = new ArrayList<>(" + fqns.size() + ");\n");
						for (int c = 0; c < chunks; c++) {
							int start = c * chunkSize;
							int end = Math.min(start + chunkSize, fqns.size());
							writer.write("        classes.addAll(List.of(\n");
							for (int i = start; i < end; i++) {
								writer.write("            " + fqns.get(i) + ".class");
								if (i < end - 1) {
									writer.write(",");
								}
								writer.write("\n");
							}
							writer.write("        ));\n");
						}
						writer.write("        return classes;\n");
						writer.write("    }\n");
					}
				}

				writer.write("}\n");
			}

			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
					"Generated " + REGISTRY_FQN + " with " + discoveredClasses.size() + " registered classes");
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
					"Failed to generate " + REGISTRY_FQN + ": " + e.getMessage());
		}
	}

	// -----------------------------------------------------------------------
	// Generate DispatchIndex.java — consolidated zero-reflection dispatch
	// -----------------------------------------------------------------------

	private void generateDispatchIndex() {
		// Pre-compute per-class data
		Map<String, List<MethodInfo>> classMethods = new LinkedHashMap<>();
		Map<String, List<FieldInfo>> classFields = new LinkedHashMap<>();
		Map<String, List<SignalInfo>> classSignals = new LinkedHashMap<>();
		Map<String, List<VirtualOverrideInfo>> classVirtualOverrides = new LinkedHashMap<>();
		Map<String, Map<Long, Set<String>>> virtualHashData = new LinkedHashMap<>();
		Map<String, Set<String>> virtualAllNames = new LinkedHashMap<>();
		Map<String, List<RpcInfo>> classRpcConfigs = new LinkedHashMap<>();
		Map<String, List<ConstantInfo>> classConstants = new LinkedHashMap<>();
		Map<String, List<VirtualMethodInfo>> classVirtualScriptMethods = new LinkedHashMap<>();
		Map<String, List<String>> classDynamicGetters = new LinkedHashMap<>();
		Map<String, List<String>> classDynamicSetters = new LinkedHashMap<>();
		Map<String, List<String>> classDynamicPropertyLists = new LinkedHashMap<>();
		Map<String, String> classValidateProperty = new LinkedHashMap<>();

		Map<String, ClassDoc> classDocs = new LinkedHashMap<>();
		Map<String, Map<String, MethodDoc>> methodDocs = new LinkedHashMap<>();
		Map<String, Map<String, PropertyDoc>> propertyDocs = new LinkedHashMap<>();
		Map<String, Map<String, SignalDoc>> signalDocs = new LinkedHashMap<>();
		Map<String, Map<String, ConstantDoc>> constantDocs = new LinkedHashMap<>();

		for (ClassEntry entry : discoveredClasses) {
			TypeElement typeElement = processingEnv.getElementUtils().getTypeElement(entry.fqn());
			if (typeElement == null)
				continue;

			List<MethodInfo> methods = new ArrayList<>();
			List<FieldInfo> fields = new ArrayList<>();
			List<SignalInfo> signals = new ArrayList<>();
			List<ConstantInfo> constants = new ArrayList<>();
			List<String> dynamicGetters = new ArrayList<>();
			List<String> dynamicSetters = new ArrayList<>();
			List<String> dynamicPropertyLists = new ArrayList<>();
			List<String> validatePropertyMethods = new ArrayList<>();
			collectMembers(typeElement, methods, fields, signals, constants, dynamicGetters, dynamicSetters,
					dynamicPropertyLists, validatePropertyMethods);

			String gcn = entry.godotClassName();
			if (!methods.isEmpty())
				classMethods.put(gcn, methods);
			if (!fields.isEmpty())
				classFields.put(gcn, fields);
			if (!signals.isEmpty())
				classSignals.put(gcn, signals);

			// --- Extract Javadoc for class ---
			String classDocComment = processingEnv.getElementUtils().getDocComment(typeElement);
			if (classDocComment != null && !classDocComment.isBlank()) {
				String bbcode = DocConverter.markdownToBbcode(classDocComment);
				String brief = bbcode.contains("\n") ? bbcode.substring(0, bbcode.indexOf('\n')).trim() : bbcode;
				classDocs.put(gcn, new ClassDoc(DocConverter.escapeXml(brief), DocConverter.escapeXml(bbcode)));
			}

			// --- Extract Javadoc for methods ---
			for (MethodInfo mi : methods) {
				for (Element enclosed : typeElement.getEnclosedElements()) {
					if (enclosed.getKind() != ElementKind.METHOD)
						continue;
					if (!enclosed.getSimpleName().toString().equals(mi.javaName()))
						continue;
					String methodDocComment = processingEnv.getElementUtils().getDocComment(enclosed);
					if (methodDocComment != null && !methodDocComment.isBlank()) {
						String bbcode = DocConverter.markdownToBbcode(methodDocComment);
						String brief = bbcode.contains("\n")
								? bbcode.substring(0, bbcode.indexOf('\n')).trim()
								: bbcode;
						methodDocs.computeIfAbsent(gcn, k -> new LinkedHashMap<>()).put(mi.godotName(),
								new MethodDoc(DocConverter.escapeXml(brief), DocConverter.escapeXml(bbcode)));
					}
				}
			}

			// --- Extract Javadoc for @Export properties ---
			for (Element enclosed : typeElement.getEnclosedElements()) {
				if (enclosed.getKind() != ElementKind.FIELD)
					continue;
				if (enclosed.getAnnotation(org.godot.annotation.Export.class) == null)
					continue;
				String fieldDocComment = processingEnv.getElementUtils().getDocComment(enclosed);
				if (fieldDocComment != null && !fieldDocComment.isBlank()) {
					String propName = enclosed.getSimpleName().toString();
					org.godot.annotation.Export expAnn = enclosed.getAnnotation(org.godot.annotation.Export.class);
					if (expAnn != null && !expAnn.propertyName().isEmpty()) {
						propName = expAnn.propertyName();
					}
					String bbcode = DocConverter.markdownToBbcode(fieldDocComment);
					propertyDocs.computeIfAbsent(gcn, k -> new LinkedHashMap<>()).put(propName,
							new PropertyDoc(DocConverter.escapeXml(bbcode)));
				}
			}

			// --- Extract Javadoc for @Signal methods ---
			for (Element enclosed : typeElement.getEnclosedElements()) {
				if (enclosed.getKind() != ElementKind.METHOD)
					continue;
				if (enclosed.getAnnotation(org.godot.annotation.Signal.class) == null)
					continue;
				String signalDocComment = processingEnv.getElementUtils().getDocComment(enclosed);
				if (signalDocComment != null && !signalDocComment.isBlank()) {
					org.godot.annotation.Signal sigAnn = enclosed.getAnnotation(org.godot.annotation.Signal.class);
					String signalName = (sigAnn != null && !sigAnn.name().isEmpty())
							? sigAnn.name()
							: enclosed.getSimpleName().toString();
					String bbcode = DocConverter.markdownToBbcode(signalDocComment);
					signalDocs.computeIfAbsent(gcn, k -> new LinkedHashMap<>()).put(signalName,
							new SignalDoc(DocConverter.escapeXml(bbcode)));
				}
			}

			// --- Extract Javadoc for @Constant fields ---
			for (Element enclosed : typeElement.getEnclosedElements()) {
				if (enclosed.getKind() != ElementKind.FIELD)
					continue;
				if (enclosed.getAnnotation(org.godot.annotation.Constant.class) == null)
					continue;
				String constDocComment = processingEnv.getElementUtils().getDocComment(enclosed);
				if (constDocComment != null && !constDocComment.isBlank()) {
					String constName = enclosed.getSimpleName().toString();
					String bbcode = DocConverter.markdownToBbcode(constDocComment);
					constantDocs.computeIfAbsent(gcn, k -> new LinkedHashMap<>()).put(constName,
							new ConstantDoc(DocConverter.escapeXml(bbcode)));
				}
			}

			// @Rpc configs
			List<RpcInfo> rpcs = new ArrayList<>();
			for (Element member : typeElement.getEnclosedElements()) {
				if (member.getKind() != ElementKind.METHOD)
					continue;
				ExecutableElement method = (ExecutableElement) member;
				org.godot.annotation.Rpc rpcAnn = method.getAnnotation(org.godot.annotation.Rpc.class);
				if (rpcAnn == null)
					continue;
				String methodName = method.getSimpleName().toString();
				String godotName = methodName;
				org.godot.annotation.GodotMethod gmAnn = method.getAnnotation(org.godot.annotation.GodotMethod.class);
				if (gmAnn != null && !gmAnn.value().isEmpty()) {
					godotName = gmAnn.value();
				}
				rpcs.add(new RpcInfo(godotName, rpcAnn.mode().value, rpcAnn.transfer().value, rpcAnn.callLocal(),
						rpcAnn.channel()));
			}
			if (!rpcs.isEmpty())
				classRpcConfigs.put(gcn, rpcs);

			// @Constant fields
			if (!constants.isEmpty())
				classConstants.put(gcn, constants);

			if (!dynamicGetters.isEmpty())
				classDynamicGetters.put(gcn, dynamicGetters);
			if (!dynamicSetters.isEmpty())
				classDynamicSetters.put(gcn, dynamicSetters);
			if (!dynamicPropertyLists.isEmpty())
				classDynamicPropertyLists.put(gcn, dynamicPropertyLists);
			if (!validatePropertyMethods.isEmpty())
				classValidateProperty.put(gcn, validatePropertyMethods.get(0));

			// @GodotMethod(virtual=true) script-virtual methods
			for (MethodInfo mi : methods) {
				for (Element member : typeElement.getEnclosedElements()) {
					if (member.getKind() != ElementKind.METHOD)
						continue;
					if (!member.getSimpleName().toString().equals(mi.javaName()))
						continue;
					org.godot.annotation.GodotMethod gmAnn = member
							.getAnnotation(org.godot.annotation.GodotMethod.class);
					if (gmAnn != null && gmAnn.virtual()) {
						classVirtualScriptMethods.computeIfAbsent(gcn, k -> new ArrayList<>())
								.add(new VirtualMethodInfo(mi.godotName(), mi.returnType(), mi.paramTypes()));
					}
				}
			}

			// Virtual overrides
			if (indexLoaded) {
				String parentClass = entry.parentClass();
				Map<String, Long> virtualMethods = collectVirtualMethodsForHierarchy(parentClass);
				if (!virtualMethods.isEmpty()) {
					// Compute hash data for this parent (once per parent)
					if (!virtualHashData.containsKey(parentClass)) {
						Map<Long, Set<String>> htn = new LinkedHashMap<>();
						for (Map.Entry<String, Long> e : virtualMethods.entrySet()) {
							htn.computeIfAbsent(e.getValue(), k -> new LinkedHashSet<>()).add(e.getKey());
						}
						virtualHashData.put(parentClass, htn);
						virtualAllNames.put(parentClass, new LinkedHashSet<>(virtualMethods.keySet()));
					}

					Set<String> allVirtualNames = virtualMethods.keySet();
					List<VirtualOverrideInfo> overrides = new ArrayList<>();
					for (Element member : typeElement.getEnclosedElements()) {
						if (member.getKind() != ElementKind.METHOD)
							continue;
						ExecutableElement method = (ExecutableElement) member;
						String javaName = method.getSimpleName().toString();
						if (!javaName.startsWith("_") || !method.getModifiers().contains(Modifier.PUBLIC))
							continue;

						String godotName = javaToGodotMethodName(javaName);
						boolean isVirtual = allVirtualNames.contains(godotName) || allVirtualNames.contains(javaName);
						if (!isVirtual)
							continue;

						String matchedName = allVirtualNames.contains(godotName) ? godotName : javaName;
						List<ParamTypeInfo> params = new ArrayList<>();
						for (VariableElement param : method.getParameters()) {
							params.add(categorizeParam(param.asType()));
						}
						String returnType = typeToDescriptor(method.getReturnType());
						overrides.add(new VirtualOverrideInfo(javaName, matchedName, returnType, params));
					}
					if (!overrides.isEmpty()) {
						classVirtualOverrides.put(gcn, overrides);
					}
				}
			}
		}

		String fqn = REGISTRY_PACKAGE + ".DispatchIndex";
		try {
			JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(fqn);
			try (Writer w = sourceFile.openWriter()) {
				writeDispatchIndex(w, classMethods, classFields, classSignals, classVirtualOverrides, virtualHashData,
						virtualAllNames, classRpcConfigs, classConstants, classVirtualScriptMethods, classDocs,
						methodDocs, propertyDocs, signalDocs, constantDocs, classDynamicGetters, classDynamicSetters,
						classDynamicPropertyLists, classValidateProperty);
			}

			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
					"Generated " + fqn + " for " + discoveredClasses.size() + " classes");
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
					"Failed to generate DispatchIndex: " + e.getMessage());
		}
	}

	private void writeDispatchIndex(Writer w, Map<String, List<MethodInfo>> classMethods,
			Map<String, List<FieldInfo>> classFields, Map<String, List<SignalInfo>> classSignals,
			Map<String, List<VirtualOverrideInfo>> classVirtualOverrides,
			Map<String, Map<Long, Set<String>>> virtualHashData, Map<String, Set<String>> virtualAllNames,
			Map<String, List<RpcInfo>> classRpcConfigs, Map<String, List<ConstantInfo>> classConstants,
			Map<String, List<VirtualMethodInfo>> classVirtualScriptMethods, Map<String, ClassDoc> classDocs,
			Map<String, Map<String, MethodDoc>> methodDocs, Map<String, Map<String, PropertyDoc>> propertyDocs,
			Map<String, Map<String, SignalDoc>> signalDocs, Map<String, Map<String, ConstantDoc>> constantDocs,
			Map<String, List<String>> classDynamicGetters, Map<String, List<String>> classDynamicSetters,
			Map<String, List<String>> classDynamicPropertyLists, Map<String, String> classValidateProperty)
			throws IOException {

		// --- Package + imports ---
		w.write("package " + REGISTRY_PACKAGE + ";\n\n");
		w.write("import java.lang.invoke.MethodHandles;\n");
		w.write("import java.lang.invoke.MethodType;\n");
		w.write("import java.lang.invoke.MethodHandle;\n");
		w.write("import java.lang.invoke.VarHandle;\n");
		w.write("import java.lang.foreign.MemorySegment;\n");
		w.write("import java.util.Collections;\n");
		w.write("import java.util.HashMap;\n");
		w.write("import java.util.HashSet;\n");
		w.write("import java.util.Map;\n");
		w.write("import java.util.Set;\n");
		w.write("import java.util.function.LongFunction;\n");
		w.write("import org.godot.Godot;\n");
		w.write("import org.godot.core.GodotString;\n");
		w.write("import org.godot.core.Variant;\n");
		w.write("import org.godot.core.VariantUtils;\n");
		w.write("import org.godot.internal.dispatch.PropertyMeta;\n");
		w.write("import org.godot.internal.dispatch.MethodMeta;\n");
		w.write("import org.godot.internal.dispatch.SignalMeta;\n");
		w.write("import org.godot.internal.dispatch.DispatchAccessor;\n");
		w.write("import org.godot.internal.ref.JavaObjectMap;\n");
		w.write("import org.godot.bridge.Bridge;\n");
		w.write("import org.godot.internal.api.ApiIndex;\n");
		w.write("import static java.lang.foreign.ValueLayout.*;\n\n");

		// Import user classes
		for (ClassEntry entry : discoveredClasses) {
			w.write("import " + entry.fqn() + ";\n");
		}
		w.write("\n");

		w.write("/**\n");
		w.write(" * Consolidated dispatch index — zero runtime reflection.\n");
		w.write(" * Generated by godot-java-processor — DO NOT EDIT.\n");
		w.write(" */\n");
		w.write("public final class DispatchIndex implements DispatchAccessor {\n\n");
		w.write("    public static final DispatchAccessor INSTANCE = new DispatchIndex();\n");
		w.write("    private DispatchIndex() {}\n\n");

		// --- Empty arrays for defaults ---
		w.write("    private static final PropertyMeta[] _EMPTY_PROPS = new PropertyMeta[0];\n");
		w.write("    private static final MethodMeta[] _EMPTY_METHODS = new MethodMeta[0];\n");
		w.write("    private static final SignalMeta[] _EMPTY_SIGNALS = new SignalMeta[0];\n\n");

		// --- PARENT_CLASS map ---
		w.write("    private static final Map<String, String> _PARENT_CLASS;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, String>();\n");
		for (ClassEntry entry : discoveredClasses) {
			w.write("        m.put(\"" + entry.godotClassName() + "\", \"" + entry.parentClass() + "\");\n");
		}
		w.write("        _PARENT_CLASS = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public String getParentClass(String name) { return _PARENT_CLASS.get(name); }\n\n");

		// --- JAVA_CLASS map ---
		w.write("    private static final Map<String, Class<?>> _JAVA_CLASS;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, Class<?>>();\n");
		for (ClassEntry entry : discoveredClasses) {
			String simpleName = entry.fqn().substring(entry.fqn().lastIndexOf('.') + 1);
			w.write("        m.put(\"" + entry.godotClassName() + "\", " + simpleName + ".class);\n");
		}
		w.write("        _JAVA_CLASS = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public Class<?> getJavaClass(String name) { return _JAVA_CLASS.get(name); }\n\n");

		// --- FQN_TO_GODOT_NAME map ---
		w.write("    private static final Map<String, String> _FQN_TO_GODOT_NAME;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, String>();\n");
		for (ClassEntry entry : discoveredClasses) {
			w.write("        m.put(\"" + entry.fqn() + "\", \"" + entry.godotClassName() + "\");\n");
		}
		w.write("        _FQN_TO_GODOT_NAME = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public String getGodotClassName(String fqn) { return _FQN_TO_GODOT_NAME.get(fqn); }\n\n");

		// --- TOOL_CLASSES set ---
		w.write("    private static final Set<String> _TOOL_CLASSES;\n");
		w.write("    static {\n");
		w.write("        var s = new HashSet<String>();\n");
		for (ClassEntry entry : discoveredClasses) {
			if (entry.isTool()) {
				w.write("        s.add(\"" + entry.godotClassName() + "\");\n");
			}
		}
		w.write("        _TOOL_CLASSES = Collections.unmodifiableSet(s);\n");
		w.write("    }\n");
		w.write("    public boolean isToolClass(String name) { return _TOOL_CLASSES.contains(name); }\n\n");

		// --- FACTORY map ---
		w.write("    private static final Map<String, LongFunction<Godot>> _FACTORIES;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, LongFunction<Godot>>();\n");
		for (ClassEntry entry : discoveredClasses) {
			String simpleName = entry.fqn().substring(entry.fqn().lastIndexOf('.') + 1);
			w.write("        m.put(\"" + entry.godotClassName() + "\", ptr -> {\n");
			w.write("            " + simpleName + " instance = new " + simpleName + "();\n");
			w.write("            instance.setNativeObject(ptr);\n");
			if (classRpcConfigs.containsKey(entry.godotClassName())) {
				w.write("            registerRpcConfigs(\"" + entry.godotClassName() + "\", instance);\n");
			}
			w.write("            return instance;\n");
			w.write("        });\n");
		}
		w.write("        _FACTORIES = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public Godot createInstance(String name, long nativePtr) {\n");
		w.write("        var f = _FACTORIES.get(name);\n");
		w.write("        return f != null ? f.apply(nativePtr) : null;\n");
		w.write("    }\n\n");

		// --- EXPORTS map ---
		w.write("    private static final Map<String, PropertyMeta[]> _EXPORTS;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, PropertyMeta[]>();\n");
		for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
			w.write("        m.put(\"" + e.getKey() + "\", new PropertyMeta[] {\n");
			for (FieldInfo f : e.getValue()) {
				String line = "            new PropertyMeta(" + "\"" + f.javaName() + "\"" + ", " + "\""
						+ f.propertyName() + "\"" + ", " + "\"" + f.type() + "\"" + ", " + f.hintId() + ", " + "\""
						+ escapeJava(f.hintString()) + "\"" + ", " + f.usage() + ", " + "\"" + escapeJava(f.getter())
						+ "\"" + ", " + "\"" + escapeJava(f.setter()) + "\"" + ", " + f.readOnly() + ", " + "\""
						+ escapeJava(f.group()) + "\"" + ", " + "\"" + escapeJava(f.groupHint()) + "\"" + ", " + "\""
						+ escapeJava(f.subgroup()) + "\"" + ", " + "\"" + escapeJava(f.subgroupHint()) + "\"" + "),\n";
				w.write(line);
			}
			w.write("        });\n");
		}
		w.write("        _EXPORTS = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public PropertyMeta[] getExports(String name) {\n");
		w.write("        return _EXPORTS.getOrDefault(name, _EMPTY_PROPS);\n");
		w.write("    }\n\n");

		// --- METHODS map ---
		w.write("    private static final Map<String, MethodMeta[]> _METHODS;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, MethodMeta[]>();\n");
		for (Map.Entry<String, List<MethodInfo>> e : classMethods.entrySet()) {
			w.write("        m.put(\"" + e.getKey() + "\", new MethodMeta[] {\n");
			for (MethodInfo mi : e.getValue()) {
				w.write("            new MethodMeta(\"" + mi.javaName() + "\", \"" + mi.godotName() + "\", \""
						+ mi.returnType() + "\",\n");
				w.write("                new String[] {");
				for (int i = 0; i < mi.paramTypes().size(); i++) {
					if (i > 0)
						w.write(", ");
					w.write("\"" + mi.paramTypes().get(i) + "\"");
				}
				w.write("},\n");
				w.write("                new String[] {");
				for (int i = 0; i < mi.paramNames().size(); i++) {
					if (i > 0)
						w.write(", ");
					w.write("\"" + mi.paramNames().get(i) + "\"");
				}
				w.write("}),\n");
			}
			w.write("        });\n");
		}
		w.write("        _METHODS = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public MethodMeta[] getMethods(String name) {\n");
		w.write("        return _METHODS.getOrDefault(name, _EMPTY_METHODS);\n");
		w.write("    }\n\n");

		// --- SIGNALS map ---
		w.write("    private static final Map<String, SignalMeta[]> _SIGNALS;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, SignalMeta[]>();\n");
		for (Map.Entry<String, List<SignalInfo>> e : classSignals.entrySet()) {
			w.write("        m.put(\"" + e.getKey() + "\", new SignalMeta[] {\n");
			for (SignalInfo si : e.getValue()) {
				w.write("            new SignalMeta(\"" + si.signalName() + "\",\n");
				w.write("                new String[] {");
				for (int i = 0; i < si.paramTypes().size(); i++) {
					if (i > 0)
						w.write(", ");
					w.write("\"" + si.paramTypes().get(i) + "\"");
				}
				w.write("},\n");
				w.write("                new String[] {");
				for (int i = 0; i < si.paramNames().size(); i++) {
					if (i > 0)
						w.write(", ");
					w.write("\"" + si.paramNames().get(i) + "\"");
				}
				w.write("}),\n");
			}
			w.write("        });\n");
		}
		w.write("        _SIGNALS = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public SignalMeta[] getSignals(String name) {\n");
		w.write("        return _SIGNALS.getOrDefault(name, _EMPTY_SIGNALS);\n");
		w.write("    }\n\n");

		// --- RPC_CONFIGS map ---
		if (!classRpcConfigs.isEmpty()) {
			w.write("    private static final Map<String, String[][]> _RPC_CONFIGS;\n");
			w.write("    static {\n");
			w.write("        var m = new HashMap<String, String[][]>();\n");
			for (var e : classRpcConfigs.entrySet()) {
				w.write("        m.put(\"" + e.getKey() + "\", new String[][] {");
				for (var rpc : e.getValue()) {
					w.write("{\"" + rpc.godotName() + "\", \"" + rpc.rpcMode() + "\", \"" + rpc.transferMode()
							+ "\", \"" + rpc.callLocal() + "\", \"" + rpc.channel() + "\"}, ");
				}
				w.write("});\n");
			}
			w.write("        _RPC_CONFIGS = Collections.unmodifiableMap(m);\n");
			w.write("    }\n");
			w.write("    public static String[][] getRpcConfigs(String name) {\n");
			w.write("        return _RPC_CONFIGS.getOrDefault(name, new String[0][]);\n");
			w.write("    }\n");
			w.write("    public static void registerRpcConfigs(String godotClassName, Godot instance) {\n");
			w.write("        var configs = _RPC_CONFIGS.get(godotClassName);\n");
			w.write("        if (configs == null) return;\n");
			w.write("        for (var cfg : configs) {\n");
			w.write("            var dict = new org.godot.collection.GodotDictionary();\n");
			w.write("            dict.put(\"rpc_mode\", Integer.parseInt(cfg[1]));\n");
			w.write("            dict.put(\"transfer_mode\", Integer.parseInt(cfg[2]));\n");
			w.write("            dict.put(\"call_local\", Boolean.parseBoolean(cfg[3]));\n");
			w.write("            dict.put(\"channel\", Integer.parseInt(cfg[4]));\n");
			w.write("            instance.call(\"rpc_config\", cfg[0], dict);\n");
			w.write("        }\n");
			w.write("    }\n\n");
		}

		// --- VIRTUAL_OVERRIDES map ---
		w.write("    private static final Map<String, Set<String>> _VIRTUAL_OVERRIDES;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, Set<String>>();\n");
		for (Map.Entry<String, List<VirtualOverrideInfo>> e : classVirtualOverrides.entrySet()) {
			w.write("        m.put(\"" + e.getKey() + "\", Set.of(");
			boolean first = true;
			for (VirtualOverrideInfo voi : e.getValue()) {
				if (!first)
					w.write(", ");
				w.write("\"" + voi.godotName() + "\"");
				first = false;
			}
			w.write("));\n");
		}
		w.write("        _VIRTUAL_OVERRIDES = Collections.unmodifiableMap(m);\n");
		w.write("    }\n");
		w.write("    public Set<String> getVirtualOverrides(String name) {\n");
		w.write("        return _VIRTUAL_OVERRIDES.getOrDefault(name, Set.of());\n");
		w.write("    }\n\n");

		// --- VIRTUAL HASH DATA ---
		w.write("    private static final Map<String, Map<Long, Set<String>>> _VIRTUAL_HASH_TO_NAMES;\n");
		w.write("    private static final Map<String, Set<String>> _VIRTUAL_ALL_NAMES;\n");
		w.write("    static {\n");
		w.write("        var hm = new HashMap<String, Map<Long, Set<String>>>();\n");
		w.write("        var am = new HashMap<String, Set<String>>();\n");
		for (Map.Entry<String, Map<Long, Set<String>>> e : virtualHashData.entrySet()) {
			w.write("        var htn_" + sanitize(e.getKey()) + " = new HashMap<Long, Set<String>>();\n");
			for (Map.Entry<Long, Set<String>> he : e.getValue().entrySet()) {
				w.write("        htn_" + sanitize(e.getKey()) + ".put(" + he.getKey() + "L, Set.of(");
				boolean first = true;
				for (String name : he.getValue()) {
					if (!first)
						w.write(", ");
					w.write("\"" + name + "\"");
					first = false;
				}
				w.write("));\n");
			}
			w.write("        hm.put(\"" + e.getKey() + "\", Collections.unmodifiableMap(htn_" + sanitize(e.getKey())
					+ "));\n");

			w.write("        var an_" + sanitize(e.getKey()) + " = new HashSet<String>();\n");
			for (String name : virtualAllNames.getOrDefault(e.getKey(), Set.of())) {
				w.write("        an_" + sanitize(e.getKey()) + ".add(\"" + name + "\");\n");
			}
			w.write("        am.put(\"" + e.getKey() + "\", Collections.unmodifiableSet(an_" + sanitize(e.getKey())
					+ "));\n");
		}
		w.write("        _VIRTUAL_HASH_TO_NAMES = Collections.unmodifiableMap(hm);\n");
		w.write("        _VIRTUAL_ALL_NAMES = Collections.unmodifiableMap(am);\n");
		w.write("    }\n");
		w.write("    public Map<Long, Set<String>> getVirtualHashToNames(String parent) {\n");
		w.write("        return _VIRTUAL_HASH_TO_NAMES.getOrDefault(parent, Map.of());\n");
		w.write("    }\n");
		w.write("    public Set<String> getVirtualAllNames(String parent) {\n");
		w.write("        return _VIRTUAL_ALL_NAMES.getOrDefault(parent, Set.of());\n");
		w.write("    }\n\n");

		// --- SINGLETON_CLASSES set ---
		w.write("    private static final Set<String> _SINGLETON_CLASSES;\n");
		w.write("    static {\n");
		w.write("        var s = new HashSet<String>();\n");
		for (ClassEntry entry : discoveredClasses) {
			if (entry.isSingleton()) {
				w.write("        s.add(\"" + entry.godotClassName() + "\");\n");
			}
		}
		w.write("        _SINGLETON_CLASSES = Collections.unmodifiableSet(s);\n");
		w.write("    }\n");
		w.write("    public boolean isSingletonClass(String name) { return _SINGLETON_CLASSES.contains(name); }\n\n");

		// --- INTERNAL_CLASSES set ---
		w.write("    private static final Set<String> _INTERNAL_CLASSES;\n");
		w.write("    static {\n");
		w.write("        var s = new HashSet<String>();\n");
		for (ClassEntry entry : discoveredClasses) {
			if (entry.isInternal()) {
				w.write("        s.add(\"" + entry.godotClassName() + "\");\n");
			}
		}
		w.write("        _INTERNAL_CLASSES = Collections.unmodifiableSet(s);\n");
		w.write("    }\n");
		w.write("    public boolean isInternalClass(String name) { return _INTERNAL_CLASSES.contains(name); }\n\n");

		// --- NO_INIT_CLASSES set ---
		w.write("    private static final Set<String> _NO_INIT_CLASSES;\n");
		w.write("    static {\n");
		w.write("        var s = new HashSet<String>();\n");
		for (ClassEntry entry : discoveredClasses) {
			if (entry.noInit()) {
				w.write("        s.add(\"" + entry.godotClassName() + "\");\n");
			}
		}
		w.write("        _NO_INIT_CLASSES = Collections.unmodifiableSet(s);\n");
		w.write("    }\n");
		w.write("    public boolean isNoInitClass(String name) { return _NO_INIT_CLASSES.contains(name); }\n\n");

		// --- CONSTANTS map ---
		if (!classConstants.isEmpty()) {
			w.write("    private static final Map<String, String[][]> _CONSTANTS;\n");
			w.write("    static {\n");
			w.write("        var m = new HashMap<String, String[][]>();\n");
			for (var e : classConstants.entrySet()) {
				w.write("        m.put(\"" + e.getKey() + "\", new String[][] {");
				for (var c : e.getValue()) {
					w.write("{{\"" + c.name() + "\", \"" + c.value() + "\"}, ");
				}
				w.write("});\n");
			}
			w.write("        _CONSTANTS = Collections.unmodifiableMap(m);\n");
			w.write("    }\n");
		}
		w.write("    public String[][] getConstants(String name) {\n");
		if (!classConstants.isEmpty()) {
			w.write("        return _CONSTANTS != null ? _CONSTANTS.getOrDefault(name, new String[0][]) : new String[0][];\n");
		} else {
			w.write("        return new String[0][];\n");
		}
		w.write("    }\n\n");

		// --- VIRTUAL_SCRIPT_METHODS map ---
		if (!classVirtualScriptMethods.isEmpty()) {
			w.write("    private static final Map<String, String[][]> _VIRTUAL_SCRIPT_METHODS;\n");
			w.write("    static {\n");
			w.write("        var m = new HashMap<String, String[][]>();\n");
			for (var e : classVirtualScriptMethods.entrySet()) {
				w.write("        m.put(\"" + e.getKey() + "\", new String[][] {");
				for (var vm : e.getValue()) {
					StringBuilder row = new StringBuilder("{\"").append(vm.godotName()).append("\", \"")
							.append(vm.returnType()).append("\"");
					for (String pt : vm.paramTypes()) {
						row.append(", \"").append(pt).append("\"");
					}
					row.append("}, ");
					w.write(row.toString());
				}
				w.write("});\n");
			}
			w.write("        _VIRTUAL_SCRIPT_METHODS = Collections.unmodifiableMap(m);\n");
			w.write("    }\n");
		}
		w.write("    public String[][] getVirtualScriptMethods(String name) {\n");
		if (!classVirtualScriptMethods.isEmpty()) {
			w.write("        return _VIRTUAL_SCRIPT_METHODS != null ? _VIRTUAL_SCRIPT_METHODS.getOrDefault(name, new String[0][]) : new String[0][];\n");
		} else {
			w.write("        return new String[0][];\n");
		}
		w.write("    }\n\n");

		// --- CLASS_DOC_XML map ---
		boolean hasAnyDocs = !classDocs.isEmpty() || !methodDocs.isEmpty() || !propertyDocs.isEmpty()
				|| !signalDocs.isEmpty() || !constantDocs.isEmpty();
		if (hasAnyDocs) {
			w.write("    private static final Map<String, String> _CLASS_DOC_XML;\n");
			w.write("    static {\n");
			w.write("        var m = new HashMap<String, String>();\n");
			for (ClassEntry entry : discoveredClasses) {
				String gcn = entry.godotClassName();
				ClassDoc cd = classDocs.get(gcn);
				Map<String, MethodDoc> mDocs = methodDocs.getOrDefault(gcn, Map.of());
				Map<String, PropertyDoc> pDocs = propertyDocs.getOrDefault(gcn, Map.of());
				Map<String, SignalDoc> sDocs = signalDocs.getOrDefault(gcn, Map.of());
				Map<String, ConstantDoc> cDocs = constantDocs.getOrDefault(gcn, Map.of());
				if (cd == null && mDocs.isEmpty() && pDocs.isEmpty() && sDocs.isEmpty() && cDocs.isEmpty())
					continue;
				String xml = buildClassDocXml(gcn, entry.parentClass(), cd, mDocs, pDocs, sDocs, cDocs);
				w.write("        m.put(\"" + gcn + "\", \"" + escapeJava(xml) + "\");\n");
			}
			w.write("        _CLASS_DOC_XML = Collections.unmodifiableMap(m);\n");
			w.write("    }\n");
			w.write("    public String getClassDocXml(String name) {\n");
			w.write("        return _CLASS_DOC_XML != null ? _CLASS_DOC_XML.getOrDefault(name, null) : null;\n");
			w.write("    }\n\n");
		} else {
			w.write("    public String getClassDocXml(String name) { return null; }\n\n");
		}

		// --- VarHandle fields ---
		for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
			for (FieldInfo f : e.getValue()) {
				String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
				w.write("    private static VarHandle VH_" + safeName + ";\n");
			}
		}

		// --- MethodHandle fields for custom getter/setter ---
		for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
			for (FieldInfo f : e.getValue()) {
				String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
				if (!f.getter().isEmpty()) {
					w.write("    private static MethodHandle MH_GET_" + safeName + ";\n");
				}
				if (!f.setter().isEmpty()) {
					w.write("    private static MethodHandle MH_SET_" + safeName + ";\n");
				}
			}
		}
		w.write("\n");

		// --- Static initializer for VarHandles and MethodHandles ---
		if (!classFields.isEmpty()) {
			w.write("    static {\n");
			w.write("        try {\n");
			w.write("            var lookup = MethodHandles.lookup();\n");
			for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
				String classSimpleName = getClassSimpleName(e.getKey());
				String lookupVar = "lookup_" + sanitize(e.getKey());
				w.write("            var " + lookupVar + " = MethodHandles.privateLookupIn(" + classSimpleName
						+ ".class, lookup);\n");
				for (FieldInfo f : e.getValue()) {
					String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
					if (f.getter().isEmpty() && f.setter().isEmpty()) {
						w.write("            VH_" + safeName + " = " + lookupVar + ".findVarHandle(" + classSimpleName
								+ ".class, \"" + f.javaName() + "\", " + javaTypeForVarHandle(f.type()) + ");\n");
					}
				}
			}
			for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
				String classSimpleName = getClassSimpleName(e.getKey());
				String lookupVar = "lookup_" + sanitize(e.getKey());
				for (FieldInfo f : e.getValue()) {
					String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
					if (!f.getter().isEmpty()) {
						w.write("            MH_GET_" + safeName + " = " + lookupVar + ".findVirtual(" + classSimpleName
								+ ".class, \"" + f.getter() + "\", MethodType.methodType("
								+ javaTypeForMethodHandle(f.type()) + "));\n");
					}
					if (!f.setter().isEmpty()) {
						w.write("            MH_SET_" + safeName + " = " + lookupVar + ".findVirtual(" + classSimpleName
								+ ".class, \"" + f.setter() + "\", MethodType.methodType(void.class, "
								+ javaTypeForMethodHandle(f.type()) + "));\n");
					}
				}
			}
			w.write("        } catch (Exception e) {\n");
			w.write("            throw new ExceptionInInitializerError(e);\n");
			w.write("        }\n");
			w.write("    }\n\n");
		}

		// --- Property dispatch ---
		w.write("    public boolean hasProperty(String godotClassName, String propName) {\n");
		w.write("        var exports = _EXPORTS.get(godotClassName);\n");
		w.write("        if (exports == null) return false;\n");
		w.write("        for (var e : exports) {\n");
		w.write("            if (e.godotName().equals(propName) || e.javaName().equals(propName)) return true;\n");
		w.write("        }\n");
		w.write("        return false;\n");
		w.write("    }\n\n");

		w.write("    public Object getProperty(String godotClassName, String propName, Godot instance) {\n");
		w.write("        var exports = _EXPORTS.get(godotClassName);\n");
		w.write("        if (exports == null) return null;\n");
		for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
			w.write("        if (\"" + e.getKey() + "\".equals(godotClassName)) {\n");
			for (FieldInfo f : e.getValue()) {
				String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
				if (!f.getter().isEmpty()) {
					w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
							+ "\".equals(propName)) { try { return MH_GET_" + safeName
							+ ".invoke(instance); } catch (Throwable t) { throw new RuntimeException(t); } }\n");
				} else {
					w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
							+ "\".equals(propName)) return VH_" + safeName + ".get(instance);\n");
				}
			}
			w.write("        }\n");
		}
		w.write("        return null;\n");
		w.write("    }\n\n");

		w.write("    public boolean setProperty(String godotClassName, String propName, Godot instance, Object value) {\n");
		w.write("        var exports = _EXPORTS.get(godotClassName);\n");
		w.write("        if (exports == null) return false;\n");
		for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
			w.write("        if (\"" + e.getKey() + "\".equals(godotClassName)) {\n");
			for (FieldInfo f : e.getValue()) {
				String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
				if (f.readOnly()) {
					w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
							+ "\".equals(propName)) return false; // read-only\n");
				} else if (!f.setter().isEmpty()) {
					String setterArg = unboxExpr(f.type(), "value");
					w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
							+ "\".equals(propName)) { try { MH_SET_" + safeName + ".invoke(instance, " + setterArg
							+ "); return true; } catch (Throwable t) { throw new RuntimeException(t); } }\n");
				} else {
					String setterArg = unboxExpr(f.type(), "value");
					w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
							+ "\".equals(propName)) { VH_" + safeName + ".set(instance, " + setterArg
							+ "); return true; }\n");
				}
			}
			w.write("        }\n");
		}
		w.write("        return false;\n");
		w.write("    }\n\n");

		// --- Method dispatch (has, ptrcall, variant) ---
		w.write("    public boolean hasMethod(String godotClassName, String methodName) {\n");
		w.write("        var methods = _METHODS.get(godotClassName);\n");
		w.write("        if (methods == null) return false;\n");
		w.write("        for (var m : methods) {\n");
		w.write("            if (m.godotName().equals(methodName)) return true;\n");
		w.write("        }\n");
		w.write("        return false;\n");
		w.write("    }\n\n");

		// ptrcall dispatch — typed pointer args
		w.write("    public Object dispatchPtrcall(String godotClassName, String methodName,\n");
		w.write("            Godot instance, MemorySegment args, int argc) throws Throwable {\n");
		if (!classMethods.isEmpty()) {
			w.write("        return switch (godotClassName) {\n");
			for (Map.Entry<String, List<MethodInfo>> e : classMethods.entrySet()) {
				String classSimpleName = getClassSimpleName(e.getKey());
				w.write("            case \"" + e.getKey() + "\" -> _dispatch_" + sanitize(e.getKey())
						+ "_ptrcall(methodName, (" + classSimpleName + ") instance, args, argc);\n");
			}
			w.write("            default -> null;\n");
			w.write("        };\n");
		} else {
			w.write("        return null;\n");
		}
		w.write("    }\n\n");

		// variant call dispatch — Object[] args
		w.write("    public Object dispatchVariantCall(String godotClassName, String methodName,\n");
		w.write("            Godot instance, Object[] args) throws Throwable {\n");
		if (!classMethods.isEmpty()) {
			w.write("        return switch (godotClassName) {\n");
			for (Map.Entry<String, List<MethodInfo>> e : classMethods.entrySet()) {
				String classSimpleName = getClassSimpleName(e.getKey());
				w.write("            case \"" + e.getKey() + "\" -> _dispatch_" + sanitize(e.getKey())
						+ "_variant(methodName, (" + classSimpleName + ") instance, args);\n");
			}
			w.write("            default -> null;\n");
			w.write("        };\n");
		} else {
			w.write("        return null;\n");
		}
		w.write("    }\n\n");

		// Per-class ptrcall dispatch methods
		for (Map.Entry<String, List<MethodInfo>> e : classMethods.entrySet()) {
			String classSimpleName = getClassSimpleName(e.getKey());
			w.write("    private static Object _dispatch_" + sanitize(e.getKey()) + "_ptrcall(String methodName, "
					+ classSimpleName + " self,\n");
			w.write("            MemorySegment args, int argc) throws Throwable {\n");
			for (MethodInfo mi : e.getValue()) {
				if (mi.paramTypes().isEmpty()) {
					if ("void".equals(mi.returnType())) {
						w.write("        if (\"" + mi.godotName() + "\".equals(methodName)) { self." + mi.javaName()
								+ "(); return null; }\n");
					} else {
						w.write("        if (\"" + mi.godotName() + "\".equals(methodName)) { return self."
								+ mi.javaName() + "(); }\n");
					}
				} else {
					w.write("        if (\"" + mi.godotName() + "\".equals(methodName)) {\n");
					for (int i = 0; i < mi.paramTypes().size(); i++) {
						generateArgRead(w, mi.paramTypes().get(i), i);
					}
					if ("void".equals(mi.returnType())) {
						w.write("            self." + mi.javaName() + "(");
						for (int i = 0; i < mi.paramTypes().size(); i++) {
							if (i > 0)
								w.write(", ");
							w.write("arg" + i);
						}
						w.write(");\n");
						w.write("            return null;\n");
					} else {
						w.write("            return self." + mi.javaName() + "(");
						for (int i = 0; i < mi.paramTypes().size(); i++) {
							if (i > 0)
								w.write(", ");
							w.write("arg" + i);
						}
						w.write(");\n");
					}
					w.write("        }\n");
				}
			}
			w.write("        return null;\n");
			w.write("    }\n\n");
		}

		// Per-class variant dispatch methods
		for (Map.Entry<String, List<MethodInfo>> e : classMethods.entrySet()) {
			String classSimpleName = getClassSimpleName(e.getKey());
			w.write("    private static Object _dispatch_" + sanitize(e.getKey()) + "_variant(String methodName, "
					+ classSimpleName + " self,\n");
			w.write("            Object[] args) throws Throwable {\n");
			for (MethodInfo mi : e.getValue()) {
				if (mi.paramTypes().isEmpty()) {
					if ("void".equals(mi.returnType())) {
						w.write("        if (\"" + mi.godotName() + "\".equals(methodName)) { self." + mi.javaName()
								+ "(); return null; }\n");
					} else {
						w.write("        if (\"" + mi.godotName() + "\".equals(methodName)) { return self."
								+ mi.javaName() + "(); }\n");
					}
				} else {
					w.write("        if (\"" + mi.godotName() + "\".equals(methodName)) {\n");
					for (int i = 0; i < mi.paramTypes().size(); i++) {
						String pt = mi.paramTypes().get(i);
						w.write("            " + pt + " arg" + i + " = " + unboxExpr(pt, "args[" + i + "]") + ";\n");
					}
					if ("void".equals(mi.returnType())) {
						w.write("            self." + mi.javaName() + "(");
						for (int i = 0; i < mi.paramTypes().size(); i++) {
							if (i > 0)
								w.write(", ");
							w.write("arg" + i);
						}
						w.write(");\n");
						w.write("            return null;\n");
					} else {
						w.write("            return self." + mi.javaName() + "(");
						for (int i = 0; i < mi.paramTypes().size(); i++) {
							if (i > 0)
								w.write(", ");
							w.write("arg" + i);
						}
						w.write(");\n");
					}
					w.write("        }\n");
				}
			}
			w.write("        return null;\n");
			w.write("    }\n\n");
		}

		// --- Virtual dispatch ---
		if (!classVirtualOverrides.isEmpty()) {
			w.write("    public void dispatchVirtual(String godotClassName, String methodName,\n");
			w.write("            MemorySegment instance, MemorySegment args, MemorySegment ret) {\n");
			w.write("        switch (godotClassName) {\n");
			for (Map.Entry<String, List<VirtualOverrideInfo>> e : classVirtualOverrides.entrySet()) {
				w.write("            case \"" + e.getKey() + "\" -> _dispatch_" + sanitize(e.getKey())
						+ "_virtual(methodName, instance, args, ret);\n");
			}
			w.write("            default -> {}\n");
			w.write("        }\n");
			w.write("    }\n\n");

			// Per-class virtual dispatch
			for (Map.Entry<String, List<VirtualOverrideInfo>> e : classVirtualOverrides.entrySet()) {
				String ownerFQN = getFQN(e.getKey());
				String classSimpleName = getClassSimpleName(e.getKey());
				w.write("    private static void _dispatch_" + sanitize(e.getKey()) + "_virtual(String methodName,\n");
				w.write("            MemorySegment instance, MemorySegment args, MemorySegment ret) {\n");
				w.write("        if (Bridge.isInNativeCallback()) {\n");
				w.write("            if (ret.address() != 0) { MemorySegment rs = MemorySegment.ofAddress(ret.address()).reinterpret(24); for (long i = 0; i < 24; i++) rs.set(JAVA_BYTE, i, (byte)0); }\n");
				w.write("            return;\n");
				w.write("        }\n");
				w.write("        long instanceAddr = instance.address();\n");
				w.write("        Godot obj = JavaObjectMap.get(instanceAddr);\n");
				w.write("        if (obj == null) return;\n");
				w.write("        " + ownerFQN + " self = (" + ownerFQN + ") obj;\n");

				for (VirtualOverrideInfo voi : e.getValue()) {
					w.write("        if (\"" + voi.godotName() + "\".equals(methodName)) {\n");
					w.write("            try {\n");
					if (!voi.params().isEmpty()) {
						for (int i = 0; i < voi.params().size(); i++) {
							generateVirtualArgRead(w, voi.params().get(i), i, voi.params().size());
						}
					}
					boolean hasReturn = !"void".equals(voi.returnType());
					w.write("                ");
					if (hasReturn) {
						w.write("Object result = ");
					}
					w.write("self." + voi.javaName() + "(");
					for (int i = 0; i < voi.params().size(); i++) {
						if (i > 0)
							w.write(", ");
						w.write("arg" + i);
					}
					w.write(");\n");
					if (hasReturn) {
						w.write("                if (ret.address() != 0) {\n");
						w.write("                    VariantUtils.writeVariantFromObject(ret, result);\n");
						w.write("                }\n");
					}
					w.write("            } catch (Throwable t) {\n");
					w.write("                System.err.println(\"WARN: " + classSimpleName + "." + voi.javaName()
							+ "() failed: \" + t.getMessage());\n");
					w.write("            }\n");
					w.write("            return;\n");
					w.write("        }\n");
				}
				w.write("    }\n\n");
			}
		} else {
			w.write("    public void dispatchVirtual(String godotClassName, String methodName,\n");
			w.write("            MemorySegment instance, MemorySegment args, MemorySegment ret) {\n");
			w.write("        // No virtual overrides\n");
			w.write("    }\n\n");
		}

		// --- Dynamic property dispatch ---
		w.write("    public boolean hasDynamicGetter(String godotClassName) {\n");
		w.write("        return dynamicGetterMHs.containsKey(godotClassName);\n");
		w.write("    }\n\n");
		w.write("    public boolean hasDynamicSetter(String godotClassName) {\n");
		w.write("        return dynamicSetterMHs.containsKey(godotClassName);\n");
		w.write("    }\n\n");
		w.write("    public boolean hasDynamicPropertyList(String godotClassName) {\n");
		w.write("        return dynamicPropertyListMHs.containsKey(godotClassName);\n");
		w.write("    }\n\n");

		w.write("    public Object dispatchDynamicGet(String godotClassName, Godot instance, String propertyName) {\n");
		w.write("        MethodHandle mh = dynamicGetterMHs.get(godotClassName);\n");
		w.write("        if (mh == null) return null;\n");
		w.write("        try {\n");
		w.write("            return mh.invoke(instance, propertyName);\n");
		w.write("        } catch (Throwable t) {\n");
		w.write("            throw new RuntimeException(t);\n");
		w.write("        }\n");
		w.write("    }\n\n");

		w.write("    public boolean dispatchDynamicSet(String godotClassName, Godot instance, String propertyName, Object value) {\n");
		w.write("        MethodHandle mh = dynamicSetterMHs.get(godotClassName);\n");
		w.write("        if (mh == null) return false;\n");
		w.write("        try {\n");
		w.write("            mh.invoke(instance, propertyName, value);\n");
		w.write("            return true;\n");
		w.write("        } catch (Throwable t) {\n");
		w.write("            throw new RuntimeException(t);\n");
		w.write("        }\n");
		w.write("    }\n\n");

		w.write("    public Object dispatchDynamicPropertyList(String godotClassName, Godot instance) {\n");
		w.write("        MethodHandle mh = dynamicPropertyListMHs.get(godotClassName);\n");
		w.write("        if (mh == null) return null;\n");
		w.write("        try {\n");
		w.write("            return mh.invoke(instance);\n");
		w.write("        } catch (Throwable t) {\n");
		w.write("            throw new RuntimeException(t);\n");
		w.write("        }\n");
		w.write("    }\n\n");

		// --- Dynamic property MethodHandle fields ---
		if (!classDynamicGetters.isEmpty() || !classDynamicSetters.isEmpty() || !classDynamicPropertyLists.isEmpty()) {
			w.write("    private static final Map<String, MethodHandle> dynamicGetterMHs;\n");
			w.write("    private static final Map<String, MethodHandle> dynamicSetterMHs;\n");
			w.write("    private static final Map<String, MethodHandle> dynamicPropertyListMHs;\n");
			w.write("    static {\n");
			w.write("        Map<String, MethodHandle> gMap = new HashMap<>();\n");
			w.write("        Map<String, MethodHandle> sMap = new HashMap<>();\n");
			w.write("        Map<String, MethodHandle> pMap = new HashMap<>();\n");

			for (Map.Entry<String, List<String>> dynEntry : classDynamicGetters.entrySet()) {
				String dynGcn = dynEntry.getKey();
				ClassEntry dynEntryObj = null;
				for (ClassEntry ce : discoveredClasses) {
					if (ce.godotClassName().equals(dynGcn)) {
						dynEntryObj = ce;
						break;
					}
				}
				if (dynEntryObj == null)
					continue;
				String dynFqn = dynEntryObj.fqn();
				String dynSimple = dynFqn.substring(dynFqn.lastIndexOf('.') + 1);
				for (String methodName : dynEntry.getValue()) {
					w.write("        try { gMap.put(\"" + dynGcn + "\", MethodHandles.lookup().findVirtual(" + dynSimple
							+ ".class, \"" + methodName + "\", MethodType.methodType(Object.class, String.class))); }"
							+ " catch (Exception e) { throw new ExceptionInInitializerError(e); }\n");
				}
			}

			for (Map.Entry<String, List<String>> dynEntry : classDynamicSetters.entrySet()) {
				String dynGcn = dynEntry.getKey();
				ClassEntry dynEntryObj = null;
				for (ClassEntry ce : discoveredClasses) {
					if (ce.godotClassName().equals(dynGcn)) {
						dynEntryObj = ce;
						break;
					}
				}
				if (dynEntryObj == null)
					continue;
				String dynFqn = dynEntryObj.fqn();
				String dynSimple = dynFqn.substring(dynFqn.lastIndexOf('.') + 1);
				for (String methodName : dynEntry.getValue()) {
					w.write("        try { sMap.put(\"" + dynGcn + "\", MethodHandles.lookup().findVirtual(" + dynSimple
							+ ".class, \"" + methodName
							+ "\", MethodType.methodType(boolean.class, String.class, Object.class))); }"
							+ " catch (Exception e) { throw new ExceptionInInitializerError(e); }\n");
				}
			}

			for (Map.Entry<String, List<String>> dynEntry : classDynamicPropertyLists.entrySet()) {
				String dynGcn = dynEntry.getKey();
				ClassEntry dynEntryObj = null;
				for (ClassEntry ce : discoveredClasses) {
					if (ce.godotClassName().equals(dynGcn)) {
						dynEntryObj = ce;
						break;
					}
				}
				if (dynEntryObj == null)
					continue;
				String dynFqn = dynEntryObj.fqn();
				String dynSimple = dynFqn.substring(dynFqn.lastIndexOf('.') + 1);
				for (String methodName : dynEntry.getValue()) {
					w.write("        try { pMap.put(\"" + dynGcn + "\", MethodHandles.lookup().findVirtual(" + dynSimple
							+ ".class, \"" + methodName + "\", MethodType.methodType(Object.class))); }"
							+ " catch (Exception e) { throw new ExceptionInInitializerError(e); }\n");
				}
			}

			w.write("        dynamicGetterMHs = Collections.unmodifiableMap(gMap);\n");
			w.write("        dynamicSetterMHs = Collections.unmodifiableMap(sMap);\n");
			w.write("        dynamicPropertyListMHs = Collections.unmodifiableMap(pMap);\n");
			w.write("    }\n\n");
		} else {
			w.write("    private static final Map<String, MethodHandle> dynamicGetterMHs = Collections.emptyMap();\n");
			w.write("    private static final Map<String, MethodHandle> dynamicSetterMHs = Collections.emptyMap();\n");
			w.write("    private static final Map<String, MethodHandle> dynamicPropertyListMHs = Collections.emptyMap();\n\n");
		}

		// --- Validate property dispatch ---
		if (!classValidateProperty.isEmpty()) {
			w.write("    private static final Set<String> _HAS_VALIDATE_PROPERTY = Set.of(");
			StringJoiner vj = new StringJoiner(", ");
			for (String vn : classValidateProperty.keySet()) {
				vj.add("\"" + vn + "\"");
			}
			w.write(vj.toString());
			w.write(");\n");

			w.write("    public boolean hasValidateProperty(String godotClassName) {\n");
			w.write("        return _HAS_VALIDATE_PROPERTY.contains(godotClassName);\n");
			w.write("    }\n\n");

			w.write("    public boolean dispatchValidateProperty(String godotClassName, Godot instance, String propertyName, long propertyInfoPtr) {\n");
			for (Map.Entry<String, String> vpEntry : classValidateProperty.entrySet()) {
				String vpGcn = vpEntry.getKey();
				String vpMethod = vpEntry.getValue();
				// Find the class simple name
				String vpFqn = null;
				for (ClassEntry ce : discoveredClasses) {
					if (ce.godotClassName().equals(vpGcn)) {
						vpFqn = ce.fqn();
						break;
					}
				}
				if (vpFqn == null)
					continue;
				String vpSimple = vpFqn.substring(vpFqn.lastIndexOf('.') + 1);
				w.write("        if (godotClassName.equals(\"" + vpGcn + "\")) {\n");
				w.write("            try {\n");
				w.write("                MethodHandle mh = MethodHandles.lookup().findVirtual(" + vpSimple
						+ ".class, \"" + vpMethod
						+ "\", MethodType.methodType(boolean.class, String.class, long.class));\n");
				w.write("                return (boolean) mh.invoke(instance, propertyName, propertyInfoPtr);\n");
				w.write("            } catch (Throwable t) {\n");
				w.write("                throw new RuntimeException(t);\n");
				w.write("            }\n");
				w.write("        }\n");
			}
			w.write("        return true;\n");
			w.write("    }\n\n");
		} else {
			w.write("    public boolean hasValidateProperty(String godotClassName) { return false; }\n");
			w.write("    public boolean dispatchValidateProperty(String godotClassName, Godot instance, String propertyName, long propertyInfoPtr) { return true; }\n\n");
		}

		w.write("}\n");
	}

	/**
	 * Build Godot class reference XML for documentation registration.
	 */
	private String buildClassDocXml(String className, String parentClass, ClassDoc classDoc,
			Map<String, MethodDoc> mDocs, Map<String, PropertyDoc> pDocs, Map<String, SignalDoc> sDocs,
			Map<String, ConstantDoc> cDocs) {
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		xml.append("<class name=\"").append(className).append("\" inherits=\"").append(parentClass)
				.append("\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"")
				.append(" xsi:noNamespaceSchemaLocation=\"../class.xsd\">\n");

		// brief_description
		xml.append("\t<brief_description>\n");
		if (classDoc != null && !classDoc.briefDesc().isEmpty()) {
			xml.append("\t").append(classDoc.briefDesc()).append("\n");
		}
		xml.append("\t</brief_description>\n");

		// description
		xml.append("\t<description>\n");
		if (classDoc != null && !classDoc.description().isEmpty()) {
			xml.append("\t").append(classDoc.description()).append("\n");
		}
		xml.append("\t</description>\n");

		// methods
		if (!mDocs.isEmpty()) {
			xml.append("\t<methods>\n");
			for (Map.Entry<String, MethodDoc> me : mDocs.entrySet()) {
				xml.append("\t\t<method name=\"").append(me.getKey()).append("\">\n");
				xml.append("\t\t\t<description>\n");
				if (!me.getValue().description().isEmpty()) {
					xml.append("\t\t\t").append(me.getValue().description()).append("\n");
				}
				xml.append("\t\t\t</description>\n");
				xml.append("\t\t</method>\n");
			}
			xml.append("\t</methods>\n");
		}

		// members (properties)
		if (!pDocs.isEmpty()) {
			xml.append("\t<members>\n");
			for (Map.Entry<String, PropertyDoc> pe : pDocs.entrySet()) {
				xml.append("\t\t<member name=\"").append(pe.getKey()).append("\">\n");
				if (!pe.getValue().description().isEmpty()) {
					xml.append("\t\t").append(pe.getValue().description()).append("\n");
				}
				xml.append("\t\t</member>\n");
			}
			xml.append("\t</members>\n");
		}

		// signals
		if (!sDocs.isEmpty()) {
			xml.append("\t<signals>\n");
			for (Map.Entry<String, SignalDoc> se : sDocs.entrySet()) {
				xml.append("\t\t<signal name=\"").append(se.getKey()).append("\">\n");
				xml.append("\t\t\t<description>\n");
				if (!se.getValue().description().isEmpty()) {
					xml.append("\t\t\t").append(se.getValue().description()).append("\n");
				}
				xml.append("\t\t\t</description>\n");
				xml.append("\t\t</signal>\n");
			}
			xml.append("\t</signals>\n");
		}

		// constants
		if (!cDocs.isEmpty()) {
			xml.append("\t<constants>\n");
			for (Map.Entry<String, ConstantDoc> ce : cDocs.entrySet()) {
				xml.append("\t\t<constant name=\"").append(ce.getKey()).append("\">\n");
				if (!ce.getValue().description().isEmpty()) {
					xml.append("\t\t").append(ce.getValue().description()).append("\n");
				}
				xml.append("\t\t</constant>\n");
			}
			xml.append("\t</constants>\n");
		}

		xml.append("</class>");
		return xml.toString();
	}

	private String sanitize(String name) {
		return name.replace('.', '_').replace('$', '_');
	}

	private String getClassSimpleName(String godotClassName) {
		for (ClassEntry entry : discoveredClasses) {
			if (entry.godotClassName().equals(godotClassName)) {
				return entry.fqn().substring(entry.fqn().lastIndexOf('.') + 1);
			}
		}
		return godotClassName;
	}

	private String getFQN(String godotClassName) {
		for (ClassEntry entry : discoveredClasses) {
			if (entry.godotClassName().equals(godotClassName)) {
				return entry.fqn();
			}
		}
		return godotClassName;
	}

	private String boxedType(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "Boolean";
			case "byte" -> "Byte";
			case "short" -> "Short";
			case "int" -> "Integer";
			case "long" -> "Long";
			case "float" -> "Float";
			case "double" -> "Double";
			default -> "Object";
		};
	}

	private String castTypeForVariant(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "Boolean";
			case "int" -> "Number";
			case "long" -> "Number";
			case "float" -> "Number";
			case "double" -> "Number";
			case "byte" -> "Number";
			case "short" -> "Number";
			case "java.lang.String" -> "String";
			default -> "Object";
		};
	}

	private String unboxExpr(String descriptor, String expr) {
		return switch (descriptor) {
			case "int" -> "((Number) " + expr + ").intValue()";
			case "long" -> "((Number) " + expr + ").longValue()";
			case "float" -> "((Number) " + expr + ").floatValue()";
			case "double" -> "((Number) " + expr + ").doubleValue()";
			case "short" -> "((Number) " + expr + ").shortValue()";
			case "byte" -> "((Number) " + expr + ").byteValue()";
			case "boolean" -> "(Boolean) " + expr;
			case "java.lang.String" -> "(String) " + expr;
			default -> "(" + descriptor + ") " + expr;
		};
	}

	private String escapeJava(String s) {
		return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
	}

	private void generateArgRead(Writer w, String paramType, int index) throws IOException {
		// Read typed pointer from args array for ptrcall dispatch
		w.write("            long dataPtr" + index + " = args.reinterpret((long) argc * ADDRESS.byteSize())\n");
		w.write("                .get(ADDRESS, (long) " + index + " * ADDRESS.byteSize()).address();\n");

		switch (paramType) {
			case "double" -> w.write(
					"            double arg" + index + " = dataPtr" + index + " != 0 ? MemorySegment.ofAddress(dataPtr"
							+ index + ").reinterpret(8).get(JAVA_DOUBLE, 0) : 0.0;\n");
			case "float" -> w.write(
					"            float arg" + index + " = dataPtr" + index + " != 0 ? MemorySegment.ofAddress(dataPtr"
							+ index + ").reinterpret(4).get(JAVA_FLOAT, 0) : 0.0f;\n");
			case "int" -> w.write("            int arg" + index + " = dataPtr" + index
					+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index + ").reinterpret(4).get(JAVA_INT, 0) : 0;\n");
			case "long" -> w.write("            long arg" + index + " = dataPtr" + index
					+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index + ").reinterpret(8).get(JAVA_LONG, 0) : 0L;\n");
			case "boolean" -> w.write("            boolean arg" + index + " = dataPtr" + index
					+ " != 0 && MemorySegment.ofAddress(dataPtr" + index
					+ ").reinterpret(1).get(JAVA_BYTE, 0) != 0;\n");
			case "java.lang.String" -> w.write("            String arg" + index + " = dataPtr" + index
					+ " != 0 ? new GodotString(MemorySegment.ofAddress(dataPtr" + index
					+ ")).toJavaString() : null;\n");
			default -> {
				// Object types — read pointer and wrap
				w.write("            long objPtr" + index + " = dataPtr" + index
						+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(ADDRESS.byteSize()).get(JAVA_LONG, 0) : 0L;\n");
				w.write("            " + paramType + " arg" + index + " = objPtr" + index + " != 0 ? (" + paramType
						+ ") VariantUtils.toObject(Variant.fromObjectPtr(objPtr" + index + ")) : null;\n");
			}
		}
	}

	// -----------------------------------------------------------------------
	// Generate typed signal facade classes
	// -----------------------------------------------------------------------

	private static final int MAX_TYPED_SIGNAL_ARITY = 5;

	private void generateSignalFacades() {
		for (ClassEntry entry : discoveredClasses) {
			TypeElement typeElement = processingEnv.getElementUtils().getTypeElement(entry.fqn());
			if (typeElement == null)
				continue;

			List<SignalInfo> signals = new ArrayList<>();
			collectMembers(typeElement, new ArrayList<>(), new ArrayList<>(), signals, new ArrayList<>(),
					new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

			List<SignalInfo> supported = new ArrayList<>();
			for (SignalInfo si : signals) {
				if (si.paramTypes().size() > MAX_TYPED_SIGNAL_ARITY)
					continue;
				boolean allSupported = true;
				for (String pt : si.paramTypes()) {
					if (!isSupportedSignalParamType(pt)) {
						allSupported = false;
						break;
					}
				}
				if (allSupported) {
					supported.add(si);
				}
			}

			// Collect @Rpc methods for typed proxy generation
			List<RpcProxyInfo> rpcs = new ArrayList<>();
			for (Element member : typeElement.getEnclosedElements()) {
				if (member.getKind() != ElementKind.METHOD)
					continue;
				ExecutableElement method = (ExecutableElement) member;
				org.godot.annotation.Rpc rpcAnn = method.getAnnotation(org.godot.annotation.Rpc.class);
				if (rpcAnn == null)
					continue;
				String methodName = method.getSimpleName().toString();
				String godotName = methodName;
				org.godot.annotation.GodotMethod gmAnn = method.getAnnotation(org.godot.annotation.GodotMethod.class);
				if (gmAnn != null && !gmAnn.value().isEmpty()) {
					godotName = gmAnn.value();
				}
				List<String> paramTypes = new ArrayList<>();
				for (VariableElement param : method.getParameters()) {
					paramTypes.add(typeToDescriptor(param.asType()));
				}
				rpcs.add(new RpcProxyInfo(godotName, paramTypes));
			}

			if (supported.isEmpty() && rpcs.isEmpty())
				continue;

			String fqn = entry.fqn();
			String pkg = fqn.substring(0, fqn.lastIndexOf('.'));
			String simpleName = fqn.substring(fqn.lastIndexOf('.') + 1);
			String facadeName = simpleName + "Signals";
			String facadeFQN = pkg + "." + facadeName;

			try {
				JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(facadeFQN);
				try (Writer w = sourceFile.openWriter()) {
					writeSignalFacade(w, pkg, simpleName, facadeName, supported, rpcs);
				}
			} catch (IOException e) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
						"Failed to generate signal facade " + facadeFQN + ": " + e.getMessage());
			}
		}
	}

	private void writeSignalFacade(Writer w, String pkg, String ownerSimpleName, String facadeName,
			List<SignalInfo> signals, List<RpcProxyInfo> rpcs) throws IOException {
		w.write("package " + pkg + ";\n\n");

		Set<Integer> arities = new LinkedHashSet<>();
		for (SignalInfo si : signals) {
			arities.add(si.paramTypes().size());
		}
		for (int arity : arities) {
			w.write("import org.godot.core.TypedSignal" + arity + ";\n");
		}

		Set<String> typeImports = new LinkedHashSet<>();
		for (SignalInfo si : signals) {
			for (String pt : si.paramTypes()) {
				if (needsSignalImport(pt)) {
					typeImports.add(pt);
				}
			}
		}
		for (String imp : typeImports) {
			w.write("import " + imp + ";\n");
		}
		w.write("\n");

		w.write("public final class " + facadeName + " {\n");
		w.write("    private final " + ownerSimpleName + " owner;\n\n");
		w.write("    public " + facadeName + "(" + ownerSimpleName + " owner) {\n");
		w.write("        this.owner = owner;\n");
		w.write("    }\n");

		// Signal accessors
		for (SignalInfo si : signals) {
			int arity = si.paramTypes().size();
			w.write("\n    public TypedSignal" + arity);
			if (arity > 0) {
				w.write("<" + si.paramTypes().stream().map(this::genericTypeForSignal)
						.collect(java.util.stream.Collectors.joining(", ")) + ">");
			}
			w.write(" " + si.javaName() + "() {\n");
			String diamond = arity > 0 ? "<>" : "";
			w.write("        return new TypedSignal" + arity + diamond + "(owner, \"" + si.signalName() + "\");\n");
			w.write("    }\n");
		}

		// RPC proxy methods
		for (RpcProxyInfo rpc : rpcs) {
			String method = rpc.godotName();
			String javaName = method + "Rpc";
			List<String> paramTypes = rpc.paramTypes();

			// rpc broadcast: methodNameRpc(params...)
			w.write("\n    public void " + javaName + "(");
			for (int i = 0; i < paramTypes.size(); i++) {
				if (i > 0)
					w.write(", ");
				w.write(paramTypes.get(i) + " arg" + i);
			}
			w.write(") {\n");
			w.write("        owner.rpc(\"" + method + "\"");
			for (int i = 0; i < paramTypes.size(); i++) {
				w.write(", " + boxExpr(paramTypes.get(i), "arg" + i));
			}
			w.write(");\n");
			w.write("    }\n");

			// rpc to specific peer: methodNameRpcId(long peerId, params...)
			w.write("\n    public void " + javaName + "Id(long peerId");
			for (int i = 0; i < paramTypes.size(); i++) {
				w.write(", " + paramTypes.get(i) + " arg" + i);
			}
			w.write(") {\n");
			w.write("        owner.rpcId(peerId, \"" + method + "\"");
			for (int i = 0; i < paramTypes.size(); i++) {
				w.write(", " + boxExpr(paramTypes.get(i), "arg" + i));
			}
			w.write(");\n");
			w.write("    }\n");
		}

		w.write("}\n");
	}

	private String boxExpr(String descriptor, String expr) {
		return switch (descriptor) {
			case "int" -> "Integer.valueOf(" + expr + ")";
			case "long" -> "Long.valueOf(" + expr + ")";
			case "float" -> "Float.valueOf(" + expr + ")";
			case "double" -> "Double.valueOf(" + expr + ")";
			case "short" -> "Short.valueOf(" + expr + ")";
			case "byte" -> "Byte.valueOf(" + expr + ")";
			case "boolean" -> "Boolean.valueOf(" + expr + ")";
			default -> expr;
		};
	}

	private boolean isSupportedSignalParamType(String descriptor) {
		return switch (descriptor) {
			case "boolean", "byte", "short", "int", "long", "float", "double", "java.lang.String" -> true;
			default -> false;
		};
	}

	private String genericTypeForSignal(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "Boolean";
			case "byte" -> "Byte";
			case "short" -> "Short";
			case "int" -> "Integer";
			case "long" -> "Long";
			case "float" -> "Float";
			case "double" -> "Double";
			case "java.lang.String" -> "String";
			default -> descriptor.substring(descriptor.lastIndexOf('.') + 1);
		};
	}

	private boolean needsSignalImport(String descriptor) {
		return switch (descriptor) {
			case "boolean", "byte", "short", "int", "long", "float", "double", "java.lang.String", "void" -> false;
			default -> true;
		};
	}

	private void generateVirtualArgRead(Writer w, ParamTypeInfo param, int index, int totalParamCount)
			throws IOException {
		String fqn = param.fqn();
		String category = param.category();
		// Virtual dispatch args are GDExtensionConstTypePtr* (raw typed pointer
		// array), NOT VariantPtr.
		// Each p_args[i] points to raw type data (e.g., 8 bytes for double,
		// pointer for Object). Same layout as ptrcall.
		w.write("            long dataPtr" + index + " = 0;\n");
		w.write("            if (args.address() != 0) {\n");
		w.write("                dataPtr" + index + " = args.reinterpret((long) " + totalParamCount
				+ " * ADDRESS.byteSize())\n");
		w.write("                    .get(ADDRESS, (long) " + index + " * ADDRESS.byteSize()).address();\n");
		w.write("            }\n");

		switch (category) {
			case "DOUBLE" -> {
				w.write("            double arg" + index + " = dataPtr" + index
						+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(8).get(JAVA_DOUBLE, 0) : 0.0;\n");
			}
			case "FLOAT" -> {
				w.write("            float arg" + index + " = dataPtr" + index
						+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(4).get(JAVA_FLOAT, 0) : 0.0f;\n");
			}
			case "INT" -> {
				w.write("            int arg" + index + " = dataPtr" + index + " != 0 ? MemorySegment.ofAddress(dataPtr"
						+ index + ").reinterpret(4).get(JAVA_INT, 0) : 0;\n");
			}
			case "LONG" -> {
				w.write("            long arg" + index + " = dataPtr" + index
						+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(8).get(JAVA_LONG, 0) : 0L;\n");
			}
			case "BOOLEAN" -> {
				w.write("            boolean arg" + index + " = dataPtr" + index
						+ " != 0 && MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(1).get(JAVA_BYTE, 0) != 0;\n");
			}
			case "STRING" -> {
				w.write("            String arg" + index + " = dataPtr" + index
						+ " != 0 ? new GodotString(MemorySegment.ofAddress(dataPtr" + index
						+ ")).toJavaString() : null;\n");
			}
			case "GODOT_OBJECT" -> {
				w.write("            long objPtr" + index + " = dataPtr" + index
						+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(ADDRESS.byteSize()).get(JAVA_LONG, 0) : 0L;\n");
				w.write("            " + fqn + " arg" + index + " = objPtr" + index + " != 0 ? (" + fqn
						+ ") VariantUtils.toObject(Variant.fromObjectPtr(objPtr" + index + ")) : null;\n");
			}
			default -> {
				w.write("            long objPtr" + index + " = dataPtr" + index
						+ " != 0 ? MemorySegment.ofAddress(dataPtr" + index
						+ ").reinterpret(ADDRESS.byteSize()).get(JAVA_LONG, 0) : 0L;\n");
				w.write("            " + fqn + " arg" + index + " = objPtr" + index + " != 0 ? (" + fqn
						+ ") VariantUtils.toObject(Variant.fromObjectPtr(objPtr" + index + ")) : null;\n");
			}
		}
	}
}
