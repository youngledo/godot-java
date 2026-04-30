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

	/** Scanned user classes, stored for deferred registration at SCENE level. */
	private static java.util.List<Class<?>> pendingClasses;

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

			logger.info("Phase 1 complete. Bridge loaded, {} classes scanned.", pendingClasses.size());
		} catch (Throwable t) {
			throw new RuntimeException("godot-java: Bootstrap.init() failed", t);
		}
	}

	/**
	 * Phase 2: Register extension classes with Godot ClassDB. Called from C++ at
	 * SCENE initialization level, when Node and other engine classes are available
	 * as parent classes.
	 */
	public static void registerClasses() {
		try {
			// Register scanned user classes
			if (pendingClasses != null) {
				Registry.registerUserClasses(pendingClasses);
			}

			logger.info("Classes registered at SCENE level.");
		} catch (Throwable t) {
			logger.error("registerClasses() failed", t);
		}
	}

	/**
	 * Phase 3: Cleanup all Java-side references before JVM destruction. Called from
	 * C++ at SCENE deinitialization level.
	 */
	public static void cleanup() {
		try {
			org.godot.internal.ref.JavaObjectMap.cleanup();
			org.godot.internal.ref.RefCountedHelper.cleanup();
			logger.info("Cleanup complete.");
		} catch (Throwable t) {
			logger.error("cleanup() failed", t);
		}
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
