package org.godot.registration;

import org.godot.bridge.Bridge;
import org.godot.bridge.InstanceCallbacks;
import org.godot.bridge.MethodDispatch;
import org.godot.bridge.MethodRegistration;
import org.godot.bridge.PropertyRegistration;
import org.godot.bridge.SignalRegistration;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.dispatch.Dispatch;
import org.godot.internal.ref.JavaObjectMap;
import org.godot.internal.ref.RefCountedHelper;
import java.lang.foreign.MemorySegment;
import java.util.List;

/**
 * Central registry for Godot type registration. Responsible for registering
 * builtin types and user @GodotClass types with Godot's ClassDB.
 */
public final class Registry {

	private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(Registry.class);

	/** Tracks registered class names for unregistration during hot reload. */
	private static final java.util.List<String> registeredClassNames = java.util.Collections
			.synchronizedList(new java.util.ArrayList<>());

	private Registry() {
	}

	/**
	 * Register Godot built-in types (Node, RefCounted, String, etc.) These are
	 * registered once at startup. Builtin type wrappers are provided by
	 * godot-java-core; this registers any additional extension-level builtin types.
	 */
	public static void registerBuiltinTypes() {
		// Builtin types (String, Vector2, Array, Dictionary, etc.) are
		// handled natively by Godot's built-in type system.
		// This method is a hook for registering additional extension-specific
		// builtin types if needed.
	}

	/**
	 * Register all user @GodotClass annotated classes to Godot ClassDB. Called
	 * after classpath scanning.
	 */
	public static void registerUserClasses(List<Class<?>> classes) {
		int classCount = 0;
		int methodCount = 0;
		int propertyCount = 0;
		int signalCount = 0;
		long startNanos = System.nanoTime();

		for (Class<?> cls : classes) {
			RegistrationStats stats = registerClass(cls);
			if (stats != null) {
				classCount++;
				methodCount += stats.methods;
				propertyCount += stats.properties;
				signalCount += stats.signals;
			}
		}

		long elapsed = (System.nanoTime() - startNanos) / 1_000_000;
		org.godot.internal.DebugLogger.log("registry",
				String.format("Registered %d classes in %dms: %d methods, %d properties, %d signals", classCount,
						elapsed, methodCount, propertyCount, signalCount));
	}

	/** Stats from a single class registration. */
	private static class RegistrationStats {
		int methods;
		int properties;
		int signals;
	}

	/**
	 * Register a single @GodotClass annotated class to ClassDB.
	 *
	 * <p>
	 * Uses CLASSDB_REGISTER_EXTENSION_CLASS5 to register the class with Godot's
	 * ClassDB. The class must be annotated with @GodotClass specifying its Godot
	 * class name and parent class.
	 *
	 * <p>
	 * The GDExtensionClassCreationInfo4 struct is allocated in native memory and
	 * populated with create_instance_func / free_instance_func upcall stubs that
	 * allow Godot to instantiate Java objects.
	 */
	public static RegistrationStats registerClass(Class<?> cls) {
		String className = Dispatch.getGodotClassName(cls.getName());
		if (className == null) {
			return null;
		}
		RegistrationStats stats = new RegistrationStats();

		String parentName = Dispatch.getParentClass(className);

		// Convert class names to Godot StringNames (required by ClassDB APIs)
		GodotStringName classNameSn = GodotStringName.fromJavaString(className);
		GodotStringName parentNameSn = GodotStringName.fromJavaString(parentName);

		// Register the Java class for instantiation by create_instance_func
		InstanceCallbacks.registerClass(className);

		// Create the GDExtensionClassCreationInfo4 struct with upcall stubs
		MemorySegment creationInfo = InstanceCallbacks.createCreationInfo(className);

		// Call: classdb_register_extension_class5(libraryPtr, className, parentName,
		// creationInfo*)
		Bridge.callVoid(ApiIndex.CLASSDB_REGISTER_EXTENSION_CLASS5, MemorySegment.ofAddress(Bridge.libraryPtr()),
				classNameSn.segment(), parentNameSn.segment(), creationInfo);

		// Register @GodotMethod methods
		MethodDispatch.ensureInitialized();
		stats.methods = MethodRegistration.registerMethods(className);

		// Register @Export properties
		stats.properties = PropertyRegistration.registerProperties(className);

		// Register @ExportGroup/@ExportSubgroup
		PropertyRegistration.registerGroups(className);

		// Register @Signal signals
		stats.signals = SignalRegistration.registerSignals(className);

		registeredClassNames.add(className);

		return stats;
	}

	/**
	 * Unregister all user classes from Godot ClassDB. Called during hot reload
	 * before re-registering with new class definitions.
	 *
	 * <p>
	 * Children must be unregistered before parents (Godot constraint). This method
	 * reverses the registration order to ensure correct teardown.
	 */
	public static void unregisterUserClasses() {
		long startNanos = System.nanoTime();

		// Unregister in reverse order (children before parents)
		java.util.List<String> names = new java.util.ArrayList<>(registeredClassNames);
		java.util.Collections.reverse(names);

		for (String className : names) {
			GodotStringName classNameSn = GodotStringName.fromJavaString(className);
			Bridge.callVoid(ApiIndex.CLASSDB_UNREGISTER_EXTENSION_CLASS, MemorySegment.ofAddress(Bridge.libraryPtr()),
					classNameSn.segment());
			logger.debug("Unregistered class: {}", className);
		}

		// Clear internal caches
		InstanceCallbacks.clearRegistrationData();
		MethodDispatch.reset();
		RefCountedHelper.cleanup();
		JavaObjectMap.cleanup();

		int count = registeredClassNames.size();
		registeredClassNames.clear();

		long elapsed = (System.nanoTime() - startNanos) / 1_000_000;
		logger.info("Unregistered {} classes in {}ms", count, elapsed);
	}

	/**
	 * Reload user classes: unregister old classes, re-register with new
	 * definitions. Used for hot reload.
	 *
	 * @param classes
	 *            The new class list (loaded by a fresh ClassLoader)
	 */
	public static void reloadUserClasses(java.util.List<Class<?>> classes) {
		logger.info("Hot reload: unregistering {} classes...", registeredClassNames.size());
		unregisterUserClasses();

		logger.info("Hot reload: registering {} new classes...", classes.size());
		registerUserClasses(classes);
	}
}
