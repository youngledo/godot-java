package org.godot.bootstrap;

import org.godot.bridge.Bridge;
import org.godot.bridge.UpcallStub;
import org.godot.registration.Registry;
import org.godot.registration.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;

/**
 * Entry point for godot-java. Called by C++ via JNI during GDExtension
 * initialization.
 *
 * Initialization is split into two phases: 1. {@link #init(long, long)} —
 * Called during GDExtension entry point (before init levels). Loads Bridge,
 * registers builtins, scans classpath. 2. {@link #registerClasses()} — Called
 * at SCENE initialization level, when Node and other scene classes are
 * available in ClassDB.
 */
public final class Bootstrap {

	private static final Logger logger = LogManager.getLogger(Bootstrap.class);

	private Bootstrap() {
	}

	/** Scanned user classes, stored for deferred registration by init level. */
	private static java.util.List<Class<?>> pendingClasses;

	/** Classes grouped by init level (CORE=0, SERVERS=1, SCENE=2, EDITOR=3). */
	private static java.util.List<java.util.List<Class<?>>> classesByLevel;

	/**
	 * Phase 1: Initialize godot-java infrastructure. Called once from C++ via JNI
	 * during GDExtension entry point.
	 */
	public static void init(long getProcAddress, long libraryPtr) {
		try {
			// Step 0: Record the main thread (Godot API must be called from this thread)
			org.godot.internal.ThreadChecker.recordMainThread();

			// Step 1: Load all Godot C API as Panama MethodHandles
			Bridge.load(getProcAddress, libraryPtr);

			// Initialize Variant type constructors (needs Bridge)
			org.godot.core.Variant.initConstructors();

			// Step 2: Register Godot built-in types (engine classes)
			Registry.registerBuiltinTypes();

			// Step 3: Scan classpath for @GodotClass annotated user classes
			pendingClasses = Scanner.scan();

			// Group classes by init level (CORE=0, SERVERS=1, SCENE=2, EDITOR=3)
			classesByLevel = new java.util.ArrayList<>(4);
			for (int i = 0; i < 4; i++) {
				classesByLevel.add(new java.util.ArrayList<>());
			}
			for (Class<?> cls : pendingClasses) {
				String name = org.godot.internal.dispatch.Dispatch.getGodotClassName(cls.getName());
				int lvl = org.godot.internal.dispatch.Dispatch.getInitLevel(name);
				classesByLevel.get(lvl).add(cls);
			}

			// Step 4: Start hot reload watcher if enabled
			startHotReloadWatcher();

			logger.info(
					"Phase 1 complete. Bridge loaded, {} classes scanned (CORE={}, SERVERS={}, SCENE={}, EDITOR={}).",
					pendingClasses.size(), classesByLevel.get(0).size(), classesByLevel.get(1).size(),
					classesByLevel.get(2).size(), classesByLevel.get(3).size());
		} catch (Throwable t) {
			throw new RuntimeException("godot-java: Bootstrap.init() failed", t);
		}
	}

	/**
	 * Phase 2: Register extension classes for a specific init level. Called from
	 * C++ at each initialization level (CORE, SERVERS, SCENE, EDITOR).
	 *
	 * @param level
	 *            the GDExtension initialization level (0=CORE, 1=SERVERS, 2=SCENE,
	 *            3=EDITOR)
	 */
	public static void registerClassesAtLevel(int level) {
		try {
			if (classesByLevel == null || level < 0 || level >= classesByLevel.size()) {
				return;
			}
			java.util.List<Class<?>> classes = classesByLevel.get(level);
			if (classes != null && !classes.isEmpty()) {
				Registry.registerUserClasses(classes);
				logger.info("Registered {} classes at level {}.", classes.size(), level);
			}
		} catch (Throwable t) {
			logger.error("registerClassesAtLevel({}) failed", level, t);
		}
	}

	/**
	 * Backward-compatible method: register all pending classes (for non-updated
	 * native layers).
	 */
	public static void registerClasses() {
		try {
			if (pendingClasses != null) {
				Registry.registerUserClasses(pendingClasses);
			}
			logger.info("Classes registered (legacy path).");
		} catch (Throwable t) {
			logger.error("registerClasses() failed", t);
		}
	}

	/**
	 * Phase 3: Cleanup at a specific deinitialization level. Called from C++ at
	 * each deinitialization level in reverse order.
	 *
	 * @param level
	 *            the GDExtension initialization level being deinitialized
	 */
	public static void cleanupAtLevel(int level) {
		try {
			if (classesByLevel != null && level >= 0 && level < classesByLevel.size()) {
				java.util.List<Class<?>> classes = classesByLevel.get(level);
				if (classes != null) {
					Registry.unregisterClasses(classes);
				}
			}
			// Full cleanup at SCENE level (level 2)
			if (level == 2) {
				org.godot.registration.HotReloadWatcher.stop();
				org.godot.internal.ref.JavaObjectMap.cleanup();
				org.godot.internal.ref.RefCountedHelper.cleanup();
			}
			logger.info("Cleanup at level {} complete.", level);
		} catch (Throwable t) {
			logger.error("cleanupAtLevel({}) failed", level, t);
		}
	}

	/**
	 * Backward-compatible cleanup method.
	 */
	public static void cleanup() {
		try {
			org.godot.registration.HotReloadWatcher.stop();
			org.godot.internal.ref.JavaObjectMap.cleanup();
			org.godot.internal.ref.RefCountedHelper.cleanup();
			logger.info("Cleanup complete (legacy path).");
		} catch (Throwable t) {
			logger.error("cleanup() failed", t);
		}
	}

	private static void startHotReloadWatcher() {
		if (!org.godot.registration.HotReloadWatcher.isEnabled()) {
			return;
		}
		String classpath = System.getProperty("java.class.path");
		if (classpath != null) {
			for (String entry : classpath.split(System.getProperty("path.separator"))) {
				if (entry.endsWith(".jar") && !entry.contains("godot-java-core")) {
					org.godot.registration.HotReloadWatcher.start(entry);
					return;
				}
			}
		}
		logger.warn("Hot reload enabled but no user JAR found on classpath");
	}

	// ------------------------------------------------------------------------
	// JNI native methods
	// ------------------------------------------------------------------------

	public static native void registerUpcallTrampoline(String className, String methodName, long functionPtr);
	public static native long getProcAddressImpl(String funcName);
	public static native long getLibraryPtrImpl();

	// ------------------------------------------------------------------------
	// Upcall stub helpers (for per-instance method registration)
	// ------------------------------------------------------------------------

	public static long createAndRegisterVoidVoidUpcall(Object target, String methodName, Class<?> clazz) {
		MemorySegment stub = UpcallStub.createVoid(target, methodName, clazz);
		registerUpcallTrampoline(clazz.getSimpleName(), methodName, stub.address());
		return stub.address();
	}

	public static long createAndRegisterVoidDoubleUpcall(Object target, String methodName, Class<?> clazz) {
		MemorySegment stub = UpcallStub.createVoidDouble(target, methodName, clazz);
		registerUpcallTrampoline(clazz.getSimpleName(), methodName, stub.address());
		return stub.address();
	}

	public static long createAndRegisterVariantPtrUpcall(Object target, String methodName, Class<?> clazz) {
		FunctionDescriptor fd = FunctionDescriptor.of(java.lang.foreign.ValueLayout.ADDRESS,
				java.lang.foreign.ValueLayout.ADDRESS);
		MemorySegment stub = UpcallStub.createForVariantPtr(target, methodName, clazz, fd);
		registerUpcallTrampoline(clazz.getSimpleName(), methodName, stub.address());
		return stub.address();
	}
}
