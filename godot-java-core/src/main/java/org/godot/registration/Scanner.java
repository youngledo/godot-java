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
}
