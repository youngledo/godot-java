package org.godot.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
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
 * <li>{@code VirtualDispatch_<Name>} for each @GodotClass — per-parent-class
 * virtual method hash data, aligned with gdext's compile-time approach.</li>
 * <li>{@code TypedDispatch_<ClassName>} for each @GodotClass — typed method
 * dispatch via MethodHandle replacing runtime reflection for @GodotMethod
 * and @Export members.</li>
 * </ol>
 */
@javax.annotation.processing.SupportedAnnotationTypes({"org.godot.annotation.GodotClass",
		"org.godot.annotation.GodotMethod", "org.godot.annotation.Export"})
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
		// Collect @GodotClass elements across rounds
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

		// Generate on the last round (when processing is complete)
		if (roundEnv.processingOver()) {
			generateRegistry();
			if (indexLoaded) {
				generateVirtualDispatchData();
			}
			generateTypedDispatchData();
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
				processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.NOTE,
						"virtual_method_index.txt not found on classpath. Per-class virtual dispatch data will not be generated.");
				return;
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
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
			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.NOTE,
					"Loaded virtual method index: " + classInherits.size() + " classes");
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.WARNING,
					"Failed to load virtual_method_index.txt: " + e.getMessage());
		}
	}

	// -----------------------------------------------------------------------
	// Walk inheritance chain and collect virtual methods
	// -----------------------------------------------------------------------

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
	// Generate VirtualDispatch_<Name>.java for each @GodotClass
	// -----------------------------------------------------------------------

	private void generateVirtualDispatchData() {
		Set<String> generatedParents = new HashSet<>();

		for (ClassEntry entry : discoveredClasses) {
			String parent = entry.parentClass;
			if (!generatedParents.add(parent)) {
				continue;
			}

			Map<String, Long> methodHashes = collectVirtualMethodsForHierarchy(parent);
			if (methodHashes.isEmpty()) {
				continue;
			}

			Map<Long, Set<String>> hashToNames = new LinkedHashMap<>();
			for (Map.Entry<String, Long> e : methodHashes.entrySet()) {
				hashToNames.computeIfAbsent(e.getValue(), k -> new LinkedHashSet<>()).add(e.getKey());
			}

			generateVirtualDispatchClass(parent, methodHashes, hashToNames);
		}
	}

	private void generateVirtualDispatchClass(String parentClass, Map<String, Long> methodHashes,
			Map<Long, Set<String>> hashToNames) {
		String className = "VirtualDispatch_" + parentClass;
		String fqn = REGISTRY_PACKAGE + "." + className;

		try {
			JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(fqn);
			try (Writer writer = sourceFile.openWriter()) {
				writer.write("package " + REGISTRY_PACKAGE + ";\n\n");
				writer.write("import java.util.*;\n\n");
				writer.write("/**\n");
				writer.write(" * Per-parent-class virtual method hash data for " + parentClass + ".\n");
				writer.write(" * Generated by godot-java-processor from extension_api.json.\n");
				writer.write(" * DO NOT EDIT.\n");
				writer.write(" */\n");
				writer.write("final class " + className + " {\n\n");
				writer.write("    private " + className + "() {}\n\n");

				writer.write("    static final Map<Long, Set<String>> HASH_TO_NAMES;\n");
				writer.write("    static {\n");
				writer.write("        Map<Long, Set<String>> m = new HashMap<>();\n");
				for (Map.Entry<Long, Set<String>> entry : hashToNames.entrySet()) {
					Set<String> names = entry.getValue();
					if (names.size() == 1) {
						writer.write("        m.put(" + entry.getKey() + "L, Set.of(\"" + names.iterator().next()
								+ "\"));\n");
					} else {
						writer.write("        m.put(" + entry.getKey() + "L, Set.of(");
						boolean first = true;
						for (String name : names) {
							if (!first)
								writer.write(", ");
							writer.write("\"" + name + "\"");
							first = false;
						}
						writer.write("));\n");
					}
				}
				writer.write("        HASH_TO_NAMES = Collections.unmodifiableMap(m);\n");
				writer.write("    }\n\n");

				writer.write("    static final Set<String> ALL_VIRTUAL_NAMES;\n");
				writer.write("    static {\n");
				writer.write("        Set<String> s = new HashSet<>();\n");
				for (String name : methodHashes.keySet()) {
					writer.write("        s.add(\"" + name + "\");\n");
				}
				writer.write("        ALL_VIRTUAL_NAMES = Collections.unmodifiableSet(s);\n");
				writer.write("    }\n");

				writer.write("}\n");
			}

			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.NOTE,
					"Generated " + fqn + " for parent " + parentClass + " (" + methodHashes.size()
							+ " virtual methods, " + hashToNames.size() + " unique hashes)");
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR,
					"Failed to generate " + fqn + ": " + e.getMessage());
		}
	}

	// -----------------------------------------------------------------------
	// Generate TypedDispatch_<ClassName>.java — typed method + property dispatch
	// -----------------------------------------------------------------------

	private void generateTypedDispatchData() {
		for (ClassEntry entry : discoveredClasses) {
			TypeElement typeElement = processingEnv.getElementUtils().getTypeElement(entry.fqn());
			if (typeElement == null) {
				continue;
			}

			// Collect @GodotMethod methods and @Export fields
			List<MethodInfo> methods = new ArrayList<>();
			List<FieldInfo> fields = new ArrayList<>();

			collectMembers(typeElement, methods, fields);

			if (methods.isEmpty() && fields.isEmpty()) {
				continue;
			}

			generateTypedDispatchClass(entry, methods, fields);
		}
	}

	private void collectMembers(TypeElement typeElement, List<MethodInfo> methods, List<FieldInfo> fields) {
		for (Element member : typeElement.getEnclosedElements()) {
			if (member.getKind() == ElementKind.METHOD) {
				ExecutableElement method = (ExecutableElement) member;
				if (method.getAnnotation(org.godot.annotation.GodotMethod.class) != null) {
					org.godot.annotation.GodotMethod ann = method.getAnnotation(org.godot.annotation.GodotMethod.class);
					String godotName = (ann != null && !ann.value().isEmpty())
							? ann.value()
							: method.getSimpleName().toString();
					List<String> paramTypes = new ArrayList<>();
					List<String> paramNames = new ArrayList<>();
					for (VariableElement param : method.getParameters()) {
						paramTypes.add(typeToDescriptor(param.asType()));
						paramNames.add(param.getSimpleName().toString());
					}
					String returnType = typeToDescriptor(method.getReturnType());
					methods.add(new MethodInfo(method.getSimpleName().toString(), godotName, returnType, paramTypes,
							paramNames));
				}
			} else if (member.getKind() == ElementKind.FIELD) {
				VariableElement field = (VariableElement) member;
				if (field.getAnnotation(org.godot.annotation.Export.class) != null) {
					org.godot.annotation.Export ann = field.getAnnotation(org.godot.annotation.Export.class);
					String propName = (ann != null && !ann.propertyName().isEmpty())
							? ann.propertyName()
							: field.getSimpleName().toString();
					fields.add(new FieldInfo(field.getSimpleName().toString(), propName,
							typeToDescriptor(field.asType())));
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

	private void generateTypedDispatchClass(ClassEntry entry, List<MethodInfo> methods, List<FieldInfo> fields) {
		String className = "TypedDispatch_" + entry.godotClassName();
		String fqn = REGISTRY_PACKAGE + "." + className;
		String ownerClass = entry.fqn();

		try {
			JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(fqn);
			try (Writer w = sourceFile.openWriter()) {
				w.write("package " + REGISTRY_PACKAGE + ";\n\n");
				w.write("import java.lang.invoke.MethodHandle;\n");
				w.write("import java.lang.invoke.MethodHandles;\n");
				w.write("import java.lang.invoke.MethodType;\n");
				w.write("import java.lang.invoke.VarHandle;\n");
				w.write("import java.lang.foreign.MemorySegment;\n");
				w.write("import org.godot.Godot;\n");
				w.write("import org.godot.core.GodotString;\n");
				w.write("import org.godot.core.Variant;\n");
				w.write("import org.godot.core.VariantUtils;\n");
				w.write("import org.godot.internal.ref.JavaObjectMap;\n");
				w.write("import static java.lang.foreign.ValueLayout.*;\n\n");
				w.write("/**\n");
				w.write(" * Typed dispatch for " + entry.godotClassName() + ".\n");
				w.write(" * Generated by godot-java-processor — DO NOT EDIT.\n");
				w.write(" */\n");
				w.write("final class " + className + " {\n\n");
				w.write("    private " + className + "() {}\n\n");

				// MethodHandle fields
				for (MethodInfo m : methods) {
					w.write("    private static final MethodHandle MH_" + m.javaName() + ";\n");
				}
				w.write("\n");

				// VarHandle fields
				for (FieldInfo f : fields) {
					w.write("    private static final VarHandle VH_" + f.javaName() + ";\n");
				}
				w.write("\n");

				// Static initializer
				w.write("    static {\n");
				w.write("        try {\n");
				w.write("            MethodHandles.Lookup lookup = MethodHandles.lookup();\n");
				w.write("            Class<?> cls = Class.forName(\"" + ownerClass + "\");\n");
				for (MethodInfo m : methods) {
					StringBuilder mt = new StringBuilder("            MH_" + m.javaName() + " = lookup.findVirtual(");
					mt.append("cls, \"" + m.javaName() + "\", MethodType.methodType(");
					mt.append(javaTypeForLookup(m.returnType()));
					for (String pt : m.paramTypes()) {
						mt.append(", ").append(javaTypeForLookup(pt));
					}
					mt.append("));\n");
					w.write(mt.toString());
				}
				w.write("\n");
				for (FieldInfo f : fields) {
					w.write("            VH_" + f.javaName() + " = lookup.findVarHandle(cls, \"" + f.javaName() + "\", "
							+ varHandleType(f.type()) + ");\n");
				}
				w.write("        } catch (Exception e) {\n");
				w.write("            throw new ExceptionInInitializerError(e);\n");
				w.write("        }\n");
				w.write("    }\n\n");

				// dispatchMethod
				w.write("    static Object dispatchMethod(String godotMethodName, Godot instance,\n");
				w.write("            MemorySegment argsPtr, int argc) throws Throwable {\n");
				w.write("        if (godotMethodName == null) return null;\n");
				for (MethodInfo m : methods) {
					w.write("        if (\"" + m.godotName() + "\".equals(godotMethodName)) {\n");
					if (m.paramTypes().isEmpty()) {
						if (m.returnType().equals("void")) {
							w.write("            MH_" + m.javaName() + ".invokeExact(instance);\n");
							w.write("            return null;\n");
						} else {
							w.write("            return MH_" + m.javaName() + ".invokeExact(instance);\n");
						}
					} else {
						for (int i = 0; i < m.paramTypes().size(); i++) {
							String pt = m.paramTypes().get(i);
							w.write("            " + boxedType(pt) + " arg" + i + " = (" + boxedType(pt)
									+ ") readArg(argsPtr, " + i + ", argc, " + pt + ".class);\n");
						}
						if (m.returnType().equals("void")) {
							w.write("            MH_" + m.javaName() + ".invokeExact(instance");
							for (int j = 0; j < m.paramTypes().size(); j++) {
								w.write(", arg" + j);
							}
							w.write(");\n");
							w.write("            return null;\n");
						} else {
							w.write("            return MH_" + m.javaName() + ".invokeExact(instance");
							for (int j = 0; j < m.paramTypes().size(); j++) {
								w.write(", arg" + j);
							}
							w.write(");\n");
						}
					}
					w.write("        }\n");
				}
				w.write("        return null;\n");
				w.write("    }\n\n");

				// getProperty
				w.write("    static Object getProperty(String propName, Godot instance) {\n");
				w.write("        if (propName == null) return null;\n");
				for (FieldInfo f : fields) {
					w.write("        if (\"" + f.propertyName() + "\".equals(propName)) return VH_" + f.javaName()
							+ ".get(instance);\n");
				}
				w.write("        return null;\n");
				w.write("    }\n\n");

				// setProperty
				w.write("    static boolean setProperty(String propName, Godot instance, Object value) {\n");
				w.write("        if (propName == null) return false;\n");
				for (FieldInfo f : fields) {
					w.write("        if (\"" + f.propertyName() + "\".equals(propName)) { VH_" + f.javaName()
							+ ".set(instance, (" + boxedType(f.type()) + ") value); return true; }\n");
				}
				w.write("        return false;\n");
				w.write("    }\n\n");

				// readArg helper
				w.write("    private static Object readArg(MemorySegment argsPtr, int index, int argc, Class<?> type) {\n");
				w.write("        if (index >= argc) return null;\n");
				w.write("        MemorySegment ptr = argsPtr.reinterpret((long) argc * ADDRESS.byteSize()).get(ADDRESS, (long) index * ADDRESS.byteSize());\n");
				w.write("        if (ptr.address() == 0) return null;\n");
				w.write("        if (type == double.class) return ptr.reinterpret(8).get(JAVA_DOUBLE, 0);\n");
				w.write("        if (type == float.class) return (float) ptr.reinterpret(4).get(JAVA_FLOAT, 0);\n");
				w.write("        if (type == int.class) return ptr.reinterpret(4).get(JAVA_INT, 0);\n");
				w.write("        if (type == long.class) return ptr.reinterpret(8).get(JAVA_LONG, 0);\n");
				w.write("        if (type == boolean.class) return ptr.get(JAVA_BYTE, 0) != 0;\n");
				w.write("        if (type == String.class) return new GodotString(ptr).toJavaString();\n");
				w.write("        long objPtr = ptr.reinterpret(ADDRESS.byteSize()).get(ADDRESS, 0).address();\n");
				w.write("        if (objPtr == 0) return null;\n");
				w.write("        Godot obj = JavaObjectMap.get(objPtr);\n");
				w.write("        if (obj != null) return obj;\n");
				w.write("        return VariantUtils.toObject(Variant.fromObjectPtr(objPtr));\n");
				w.write("    }\n\n");

				// hasMethod / hasProperty
				w.write("    static boolean hasMethod(String godotMethodName) {\n");
				w.write("        return "
						+ buildEqualsChain(methods.stream().map(MethodInfo::godotName).toList(), "godotMethodName")
						+ ";\n");
				w.write("    }\n\n");
				w.write("    static boolean hasProperty(String propName) {\n");
				w.write("        return "
						+ buildEqualsChain(fields.stream().map(FieldInfo::propertyName).toList(), "propName") + ";\n");
				w.write("    }\n");

				w.write("}\n");
			}

			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.NOTE,
					"Generated " + fqn + " (" + methods.size() + " methods, " + fields.size() + " properties)");
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR,
					"Failed to generate " + fqn + ": " + e.getMessage());
		}
	}

	private String buildEqualsChain(List<String> names, String param) {
		if (names.isEmpty())
			return "false";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names.size(); i++) {
			if (i > 0)
				sb.append("\n            || ");
			sb.append("\"" + names.get(i) + "\".equals(" + param + ")");
		}
		return sb.toString();
	}

	private String javaTypeForLookup(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "boolean.class";
			case "byte" -> "byte.class";
			case "short" -> "short.class";
			case "int" -> "int.class";
			case "long" -> "long.class";
			case "float" -> "float.class";
			case "double" -> "double.class";
			case "void" -> "void.class";
			default -> descriptor + ".class";
		};
	}

	private String varHandleType(String descriptor) {
		return switch (descriptor) {
			case "boolean" -> "boolean.class";
			case "int" -> "int.class";
			case "long" -> "long.class";
			case "float" -> "float.class";
			case "double" -> "double.class";
			default -> descriptor + ".class";
		};
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

	// -----------------------------------------------------------------------
	// GeneratedClassRegistry
	// -----------------------------------------------------------------------

	private void generateRegistry() {
		try {
			JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(REGISTRY_FQN);
			try (Writer writer = sourceFile.openWriter()) {
				writer.write("package " + REGISTRY_PACKAGE + ";\n\n");
				writer.write("import java.util.List;\n");
				writer.write("import java.util.ArrayList;\n\n");
				writer.write("/**\n");
				writer.write(" * Auto-generated by godot-java-processor.\n");
				writer.write(" * Contains all @GodotClass annotated classes found at compile time.\n");
				writer.write(" * DO NOT EDIT - regenerated on each compilation.\n");
				writer.write(" */\n");
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

			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.NOTE,
					"Generated " + REGISTRY_FQN + " with " + discoveredClasses.size() + " registered classes");
		} catch (IOException e) {
			processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR,
					"Failed to generate " + REGISTRY_FQN + ": " + e.getMessage());
		}
	}

	// -----------------------------------------------------------------------
	// Data classes
	// -----------------------------------------------------------------------

	private record ClassEntry(String fqn, String godotClassName, String parentClass) {
	}

	private record MethodInfo(String javaName, String godotName, String returnType, List<String> paramTypes,
			List<String> paramNames) {
	}

	private record FieldInfo(String javaName, String propertyName, String type) {
	}
}
