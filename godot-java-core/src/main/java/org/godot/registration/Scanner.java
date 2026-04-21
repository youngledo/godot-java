package org.godot.registration;

import org.godot.annotation.GodotClass;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Scans for classes annotated with @GodotClass using the compile-time generated
 * registry.
 *
 * <p>
 * Requires the annotation processor ({@code godot-java-processor}) to be
 * configured in the build. At compile time, the processor generates
 * {@code org.godot.internal.GeneratedClassRegistry} containing all
 * {@code @GodotClass} annotated classes — zero reflection overhead, zero
 * classpath scanning.
 */
public final class Scanner {

	private Scanner() {
	}

	/**
	 * Scan for classes annotated with @GodotClass via APT-generated registry.
	 *
	 * @return List of Class objects annotated with @GodotClass
	 * @throws IllegalStateException
	 *             if APT registry is not available
	 */
	@SuppressWarnings("unchecked")
	public static List<Class<?>> scan() {
		try {
			Class<?> registry = Class.forName("org.godot.internal.GeneratedClassRegistry");
			Method m = registry.getMethod("getRegisteredClasses");
			List<Class<?>> classes = (List<Class<?>>) m.invoke(null);
			if (classes != null && !classes.isEmpty()) {
				System.out.println(
						"[godot-java:scanner] Using APT-generated class registry (" + classes.size() + " classes)");
				return classes;
			}
		} catch (ReflectiveOperationException e) {
			throw new IllegalStateException(
					"APT-generated class registry not found. Ensure godot-java-processor is configured "
							+ "as a compile dependency in your build.",
					e);
		}
		throw new IllegalStateException(
				"APT-generated class registry is empty. No @GodotClass annotated classes were found at compile time.");
	}

	/**
	 * Register a single class directly (for explicit registration).
	 */
	public static void register(Class<?> clazz) {
		if (clazz.isAnnotationPresent(GodotClass.class)) {
			Registry.registerClass(clazz);
		}
	}
}
