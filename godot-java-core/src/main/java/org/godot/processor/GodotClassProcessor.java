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
		"org.godot.annotation.GodotMethod", "org.godot.annotation.Export", "org.godot.annotation.Signal"})
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
							discoveredClasses.add(new ClassEntry(fqn, anno.name(), anno.parent()));
						}
					} catch (Exception e) {
						discoveredClasses
								.add(new ClassEntry(fqn, typeElement.getSimpleName().toString(), "RefCounted"));
					}
				}
			}
		}

		if (roundEnv.processingOver()) {
			generateRegistry();
			generateDispatchIndex();
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

	private record ClassEntry(String fqn, String godotClassName, String parentClass) {
	}

	private record MethodInfo(String javaName, String godotName, String returnType, List<String> paramTypes,
			List<String> paramNames) {
	}

	private record FieldInfo(String javaName, String propertyName, String type, int hintId, String hintString) {
	}

	private record SignalInfo(String javaName, String signalName, List<String> paramTypes, List<String> paramNames) {
	}

	private record VirtualOverrideInfo(String javaName, String godotName, String returnType,
			List<ParamTypeInfo> params) {
	}

	private record ParamTypeInfo(String fqn, String category) {
	}

	// -----------------------------------------------------------------------
	// Member collection
	// -----------------------------------------------------------------------

	private void collectMembers(TypeElement typeElement, List<MethodInfo> methods, List<FieldInfo> fields,
			List<SignalInfo> signals) {
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
				if (field.getAnnotation(org.godot.annotation.Export.class) != null) {
					org.godot.annotation.Export ann = field.getAnnotation(org.godot.annotation.Export.class);
					String propName = (ann != null && !ann.propertyName().isEmpty())
							? ann.propertyName()
							: field.getSimpleName().toString();
					int hintId = ann != null ? ann.hint().id() : 0;
					String hintString = ann != null ? ann.hintString() : "";
					fields.add(new FieldInfo(field.getSimpleName().toString(), propName,
							typeToDescriptor(field.asType()), hintId, hintString));
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

		for (ClassEntry entry : discoveredClasses) {
			TypeElement typeElement = processingEnv.getElementUtils().getTypeElement(entry.fqn());
			if (typeElement == null)
				continue;

			List<MethodInfo> methods = new ArrayList<>();
			List<FieldInfo> fields = new ArrayList<>();
			List<SignalInfo> signals = new ArrayList<>();
			collectMembers(typeElement, methods, fields, signals);

			String gcn = entry.godotClassName();
			if (!methods.isEmpty())
				classMethods.put(gcn, methods);
			if (!fields.isEmpty())
				classFields.put(gcn, fields);
			if (!signals.isEmpty())
				classSignals.put(gcn, signals);

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
						virtualAllNames);
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
			Map<String, Map<Long, Set<String>>> virtualHashData, Map<String, Set<String>> virtualAllNames)
			throws IOException {

		// --- Package + imports ---
		w.write("package " + REGISTRY_PACKAGE + ";\n\n");
		w.write("import java.lang.invoke.MethodHandles;\n");
		w.write("import java.lang.invoke.MethodType;\n");
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

		// --- FACTORY map ---
		w.write("    private static final Map<String, LongFunction<Godot>> _FACTORIES;\n");
		w.write("    static {\n");
		w.write("        var m = new HashMap<String, LongFunction<Godot>>();\n");
		for (ClassEntry entry : discoveredClasses) {
			String simpleName = entry.fqn().substring(entry.fqn().lastIndexOf('.') + 1);
			w.write("        m.put(\"" + entry.godotClassName() + "\", ptr -> {\n");
			w.write("            " + simpleName + " instance = new " + simpleName + "();\n");
			w.write("            instance.setNativeObject(ptr);\n");
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
				w.write("            new PropertyMeta(\"" + f.javaName() + "\", \"" + f.propertyName() + "\", \""
						+ f.type() + "\", " + f.hintId() + ", \"" + escapeJava(f.hintString()) + "\"),\n");
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

		// --- VarHandle fields ---
		for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
			for (FieldInfo f : e.getValue()) {
				String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
				w.write("    private static VarHandle VH_" + safeName + ";\n");
			}
		}
		w.write("\n");

		// --- Static initializer for VarHandles ---
		if (!classFields.isEmpty()) {
			w.write("    static {\n");
			w.write("        try {\n");
			w.write("            var lookup = MethodHandles.lookup();\n");
			for (Map.Entry<String, List<FieldInfo>> e : classFields.entrySet()) {
				String classSimpleName = getClassSimpleName(e.getKey());
				for (FieldInfo f : e.getValue()) {
					String safeName = sanitize(e.getKey()) + "_" + sanitize(f.javaName());
					w.write("            VH_" + safeName + " = lookup.findVarHandle(" + classSimpleName + ".class, \""
							+ f.javaName() + "\", " + javaTypeForVarHandle(f.type()) + ");\n");
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
				w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
						+ "\".equals(propName)) return VH_" + safeName + ".get(instance);\n");
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
				String setterArg = unboxExpr(f.type(), "value");
				w.write("            if (\"" + f.propertyName() + "\".equals(propName) || \"" + f.javaName()
						+ "\".equals(propName)) { VH_" + safeName + ".set(instance, " + setterArg
						+ "); return true; }\n");
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
				w.write("            if (ret.address() != 0) ret.set(JAVA_INT, 0, 0);\n");
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

		w.write("}\n");
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
