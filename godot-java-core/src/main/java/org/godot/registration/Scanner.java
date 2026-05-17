package org.godot.registration;

import org.godot.annotation.GodotClass;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;

/**
 * Scans for classes annotated with @GodotClass using the compile-time generated
 * registry.
 *
 * <p>
 * Loads {@code GeneratedClassRegistry} via Class.forName (the single allowed
 * reflection call for bootstrap) and calls {@code getRegisteredClasses()} via
 * MethodHandle — no Method.invoke.
 */
public final class Scanner {

	private static final List<Class<?>> CLASSES;

	static {
		List<Class<?>> result;
		try {
			Class<?> registry = Class.forName("org.godot.internal.GeneratedClassRegistry");
			MethodHandle mh = MethodHandles.lookup().findStatic(registry, "getRegisteredClasses",
					MethodType.methodType(List.class));
			@SuppressWarnings("unchecked")
			List<Class<?>> list = (List<Class<?>>) (List<?>) mh.invokeExact();
			result = list;
		} catch (Throwable e) {
			throw new IllegalStateException(
					"APT-generated class registry not found. Ensure godot-java-processor is configured.", e);
		}
		CLASSES = result;
	}

	private Scanner() {
	}

	@SuppressWarnings("unchecked")
	public static List<Class<?>> scan() {
		if (!CLASSES.isEmpty()) {
			System.out.println(
					"[godot-java:scanner] Using APT-generated class registry (" + CLASSES.size() + " classes)");
			return CLASSES;
		}
		throw new IllegalStateException("APT-generated class registry is empty.");
	}

	public static void register(Class<?> clazz) {
		if (clazz.isAnnotationPresent(GodotClass.class)) {
			Registry.registerClass(clazz);
		}
	}

	/**
	 * Rescan using a new ClassLoader for hot reload. Loads GeneratedClassRegistry
	 * and DispatchIndex from the new loader.
	 *
	 * @param loader
	 *            The new ClassLoader pointing at the updated JAR
	 * @return List of classes from the new JAR
	 */
	@SuppressWarnings("unchecked")
	public static List<Class<?>> rescan(ClassLoader loader) {
		try {
			Class<?> registry = Class.forName("org.godot.internal.GeneratedClassRegistry", true, loader);
			MethodHandle mh = MethodHandles.lookup().findStatic(registry, "getRegisteredClasses",
					MethodType.methodType(List.class));
			List<Class<?>> list = (List<Class<?>>) (List<?>) mh.invokeExact();

			// Also reload Dispatch with the new ClassLoader
			org.godot.internal.dispatch.Dispatch.reload(loader);

			System.out.println("[godot-java:scanner] Rescanned with new ClassLoader (" + list.size() + " classes)");
			return list;
		} catch (Throwable e) {
			throw new RuntimeException("godot-java: Failed to rescan with new ClassLoader", e);
		}
	}
}
