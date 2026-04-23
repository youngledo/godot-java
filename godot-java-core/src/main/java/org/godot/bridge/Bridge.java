package org.godot.bridge;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import org.godot.internal.ThreadChecker;
import org.godot.internal.api.ApiIndex;

/**
 * Central Panama FFI bridge to all 176 Godot C API functions.
 *
 * Uses Java 25's Foreign Function & Memory API (Panama) to link Godot's C
 * functions as cached MethodHandles, achieving ~50ns per call vs ~5000ns for
 * traditional JNI.
 *
 * Usage:
 *
 * <pre>
 * Bridge.load(getProcAddress, libraryPtr);  // called once from Bootstrap.init()
 * MemorySegment variant = Bridge.allocVariant();
 * Bridge.call(Bridge.API_CLASSDB_CONSTRUCT_OBJECT, className, ...);
 * </pre>
 */
public final class Bridge {

	private Bridge() {
	}

	// ------------------------------------------------------------------------
	// State
	// ------------------------------------------------------------------------

	/** All 176 API function handles, indexed by ApiIndex ordinal. */
	private static final MethodHandle[] API = new MethodHandle[ApiIndex.values().length];

	/**
	 * Arena for persistent allocations (registration phase). Lives for JVM
	 * lifetime.
	 */
	static final Arena ARENA = Arena.ofShared();

	/** Linker instance for the native platform ABI. */
	private static final Linker LINKER = Linker.nativeLinker();

	/** Raw library pointer (GDExtensionClassLibraryPtr). */
	private static long LIBRARY_PTR;

	/**
	 * Tracks whether the current thread is inside a Java→Godot downcall. Used to
	 * detect re-entrant upcalls that would crash Panama FFI.
	 */
	private static final ScopedValue<Boolean> IN_DOWNCALL = ScopedValue.newInstance();

	/**
	 * Scoped value for call-path temporary arenas. When bound (via
	 * {@link #runScoped}), allocations go to the scoped arena which is freed on
	 * scope exit. When unbound (registration phase), allocations fall back to the
	 * persistent {@link #ARENA}.
	 */
	private static final ScopedValue<Arena> CALL_ARENA = ScopedValue.newInstance();

	// ------------------------------------------------------------------------
	// Initialization
	// ------------------------------------------------------------------------

	/**
	 * Load all Godot API functions via Panama FFI. Must be called exactly once
	 * before any other Bridge methods.
	 *
	 * @param getProcAddressPtr
	 *            Native pointer to Godot's get_proc_address function
	 * @param libraryPtr
	 *            Native pointer to the GDExtension library handle
	 */
	public static void load(long getProcAddressPtr, long libraryPtr) throws Throwable {
		LIBRARY_PTR = libraryPtr;
		// get_proc_address is resolved via JNI in Bootstrap.getProcAddressImpl()
		for (ApiIndex api : ApiIndex.values()) {
			API[api.index()] = loadApi(api);
		}
	}

	private static MethodHandle loadApi(ApiIndex api) throws Throwable {
		String cName = toSnakeCase(api.name());
		// Use JNI to call Godot's get_proc_address directly (bypasses Panama FFI issues
		// with function-pointer-returning functions)
		long addr = org.godot.bootstrap.Bootstrap.getProcAddressImpl(cName);
		if (addr == 0) {
			throw new RuntimeException("Missing API: " + api.name());
		}
		FunctionDescriptor fd = ApiSignatures.get(api);
		return LINKER.downcallHandle(MemorySegment.ofAddress(addr), fd);
	}

	private static String toSnakeCase(String name) {
		// Godot API names are UPPER_SNAKE_CASE (e.g. GET_GODOT_VERSION).
		// Convert to lowercase with single underscores between words:
		// GET_GODOT_VERSION → get_godot_version
		// STRING_NEW_WITH_UTF8_CHARS_AND_LEN → string_new_with_utf8_chars_and_len
		// OBJECT_METHOD_BIND_CALL → object_method_bind_call
		// Strategy: lowercase everything, then collapse runs of multiple underscores to
		// one.
		StringBuilder sb = new StringBuilder(name.length() * 2);
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c == '_') {
				sb.append('_');
			} else if (Character.isUpperCase(c)) {
				if (i > 0 && !name.isEmpty()) {
					char prev = name.charAt(i - 1);
					if (Character.isLowerCase(prev)
							|| (i + 1 < name.length() && Character.isLowerCase(name.charAt(i + 1)))) {
						sb.append('_');
					}
				}
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		String result = sb.toString();
		// Collapse any double underscores back to single (handles cases like
		// GET__VERSION where
		// the rule above produces "get__version" for "GET_VERSION")
		while (result.contains("__")) {
			result = result.replace("__", "_");
		}
		return result;
	}

	// ------------------------------------------------------------------------
	// API access
	// ------------------------------------------------------------------------

	/**
	 * Get a cached MethodHandle for the given API index.
	 */
	public static MethodHandle getAPI(int index) {
		return API[index];
	}

	/**
	 * Get a cached MethodHandle for the given API enum.
	 */
	public static MethodHandle getAPI(ApiIndex api) {
		return API[api.index()];
	}

	/**
	 * Get a cached MethodHandle, throwing if the API is not available.
	 */
	private static MethodHandle requireApi(ApiIndex api) {
		MethodHandle handle = API[api.index()];
		if (handle == null) {
			throw new org.godot.exception.GodotApiException(api.name(),
					"API function not loaded (index=" + api.index() + ")");
		}
		return handle;
	}

	// ------------------------------------------------------------------------
	// Memory allocation
	// ------------------------------------------------------------------------

	/**
	 * Get the active arena. Returns the call-scoped arena if one is bound (via
	 * {@link #runScoped}), otherwise the persistent registration arena.
	 */
	public static Arena arena() {
		return CALL_ARENA.orElse(ARENA);
	}

	/**
	 * Allocate a Godot Variant (24 bytes, 8-byte aligned) from the active arena.
	 */
	public static MemorySegment allocVariant() {
		org.godot.internal.NativeMemoryTracker.onAllocate(24);
		return arena().allocate(24, 8);
	}

	/**
	 * Allocate n bytes (8-byte aligned) from the active arena. During registration
	 * (no call scope), allocations live for JVM lifetime. During call path (call
	 * scope active), allocations are freed when the scope closes.
	 */
	public static MemorySegment allocate(long bytes) {
		org.godot.internal.NativeMemoryTracker.onAllocate(bytes);
		return arena().allocate(bytes, 8);
	}

	/**
	 * Execute an action within a scoped arena for temporary allocations. All
	 * allocations made via {@link #allocVariant()}, {@link #allocate(long)}, and
	 * {@link #arena()} within the action will use the scoped arena, which is freed
	 * when the action completes. Nested calls create nested scopes automatically.
	 *
	 * <pre>
	 * Object result = Bridge.runScoped(() -> {
	 * 	// allocations here are temporary
	 * 	return godot.call("some_method");
	 * });
	 * // scoped arena freed here
	 * </pre>
	 */
	public static <T> T runScoped(java.util.concurrent.Callable<T> action) {
		Arena scope = Arena.ofShared();
		try {
			return ScopedValue.where(CALL_ARENA, scope).call(action::call);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			scope.close();
		}
	}

	/**
	 * Execute a void action within a scoped arena.
	 */
	public static void runScoped(Runnable action) {
		Arena scope = Arena.ofShared();
		try {
			ScopedValue.where(CALL_ARENA, scope).run(action);
		} finally {
			scope.close();
		}
	}

	/**
	 * Destroy a Variant by calling variant_destroy. Notifies Godot that the Variant
	 * is being released, allowing proper cleanup of internal references (e.g.,
	 * reference-counted objects held by the Variant).
	 */
	public static void destroyVariant(MemorySegment variant) {
		try {
			requireApi(ApiIndex.VARIANT_DESTROY).invoke(variant);
		} catch (Throwable t) {
			// Log but don't throw — this is cleanup code
			org.apache.logging.log4j.LogManager.getLogger(Bridge.class).warn("Failed to destroy variant: {}",
					t.getMessage());
		}
	}

	/** Get native memory allocation statistics. */
	public static String getMemoryStats() {
		return org.godot.internal.NativeMemoryTracker.getStats();
	}

	// ------------------------------------------------------------------------
	// Re-entrant upcall protection
	// ------------------------------------------------------------------------

	/**
	 * Whether the current thread is inside a Java→Godot downcall. When true,
	 * upcalls from Godot are discarded to avoid Panama FFI crash.
	 */
	public static boolean isInDowncall() {
		return IN_DOWNCALL.orElse(false);
	}

	/**
	 * Execute a native downcall with re-entrant upcall protection. Binds
	 * IN_DOWNCALL to true for the duration, so upcall entry points can detect and
	 * discard re-entrant calls.
	 */
	public static <T> T runDowncall(java.util.concurrent.Callable<T> downcall) {
		return ScopedValue.where(IN_DOWNCALL, true).call(() -> {
			try {
				return downcall.call();
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}

	/**
	 * Execute a void native downcall with re-entrant upcall protection.
	 */
	public static void runDowncall(Runnable downcall) {
		ScopedValue.where(IN_DOWNCALL, true).run(downcall);
	}

	// ------------------------------------------------------------------------
	// Convenience call helpers
	// ------------------------------------------------------------------------

	/**
	 * Call an API function with no arguments.
	 */
	public static void callVoid(ApiIndex api) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke();
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with a single MemorySegment argument.
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with two MemorySegment arguments.
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with three MemorySegment arguments.
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with two MemorySegment arguments and one primitive int.
	 * Used for APIs like STRING_NAME_NEW_WITH_LATIN1_CHARS (takes GDExtensionBool
	 * is_static).
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2, int arg3) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with two MemorySegment arguments and one primitive long.
	 * Used for APIs like STRING_NEW_WITH_UTF8_CHARS_AND_LEN (takes int64_t length).
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2, long arg3) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with a MemorySegment, a long, and a MemorySegment. Used
	 * for variant_get_indexed(self, index, ret).
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, long arg2, MemorySegment arg3) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with four MemorySegment arguments.
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3,
			MemorySegment arg4) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3, arg4);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with 3 MemorySegments and 1 long argument. Used for
	 * classdb_register_extension_class_signal.
	 */
	public static void callVoid3S1L(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3,
			long arg4) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3, arg4);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid3S1L", t);
		}
	}

	/**
	 * Call an API function with 4 MemorySegments and 1 long argument. Used for
	 * classdb_register_extension_class_signal(library, className, signalName,
	 * argumentInfo*, argCount).
	 */
	public static void callVoid4S1L(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3,
			MemorySegment arg4, long arg5) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3, arg4, arg5);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid4S1L", t);
		}
	}

	/**
	 * Call an API function with five MemorySegment arguments.
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3,
			MemorySegment arg4, MemorySegment arg5) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3, arg4, arg5);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function with 6 arguments: 3 MemorySegments, a long, and 2
	 * MemorySegments. Used for object_method_bind_call(bind, object, args, argc,
	 * result, error).
	 */
	public static void callVoid(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3, long arg4,
			MemorySegment arg5, MemorySegment arg6) {
		ThreadChecker.ensureMainThread();
		try {
			requireApi(api).invoke(arg1, arg2, arg3, arg4, arg5, arg6);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callVoid", t);
		}
	}

	/**
	 * Call an API function that returns int, with 1 MemorySegment argument.
	 */
	public static int callInt(ApiIndex api, MemorySegment arg1) {
		ThreadChecker.ensureMainThread();
		try {
			return (int) requireApi(api).invoke(arg1);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callInt", t);
		}
	}

	/**
	 * Call an API function that returns int, with 2 MemorySegment arguments.
	 */
	public static int callInt(ApiIndex api, MemorySegment arg1, MemorySegment arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (int) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callInt", t);
		}
	}

	/**
	 * Call an API function that returns int, with 3 MemorySegment arguments.
	 */
	public static int callInt(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3) {
		ThreadChecker.ensureMainThread();
		try {
			return (int) requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callInt", t);
		}
	}

	/**
	 * Call an API function that returns a pointer (as MemorySegment).
	 */
	public static MemorySegment callPtr(ApiIndex api, MemorySegment arg1) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtr", t);
		}
	}

	/**
	 * Call an API function that returns a pointer, with int + MemorySegment args.
	 * Used for get_variant_from_type_constructor(type, hint).
	 */
	public static MemorySegment callPtr(ApiIndex api, int arg1, MemorySegment arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtr", t);
		}
	}

	/**
	 * Call an API function that returns a pointer, with 2 MemorySegment arguments.
	 * Used for array_operator_index_const, etc.
	 */
	public static MemorySegment callPtr2(ApiIndex api, MemorySegment arg1, MemorySegment arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtr2", t);
		}
	}

	/**
	 * Call an API function that returns a pointer, with MemorySegment + int
	 * arguments. Used for array_operator_index_const(Array*, GDExtensionInt).
	 */
	public static MemorySegment callPtrInt(ApiIndex api, MemorySegment arg1, int arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtrInt", t);
		}
	}
	/**
	 * Call an API function that returns a pointer, with a single long argument.
	 * Used for object_get_instance_from_id(ObjectID).
	 */
	public static MemorySegment callPtr(ApiIndex api, long arg1) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtr(long)", t);
		}
	}

	/**
	 * Call an API function that returns a pointer, with MemorySegment + long
	 * arguments. Takes long directly to avoid int→long widening in native
	 * MethodHandle.invoke.
	 */
	public static MemorySegment callPtrLong(ApiIndex api, MemorySegment arg1, long arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtrLong", t);
		}
	}

	/**
	 * Call an API function that returns long with 1 MemorySegment argument.
	 */
	public static long callLong(ApiIndex api, MemorySegment arg1) {
		ThreadChecker.ensureMainThread();
		try {
			return (long) requireApi(api).invoke(arg1);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callLong", t);
		}
	}

	/**
	 * Call an API function that returns long with 2 MemorySegment arguments.
	 */
	public static long callLong(ApiIndex api, MemorySegment arg1, MemorySegment arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (long) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callLong", t);
		}
	}

	/**
	 * Call an API function that returns long with 3 MemorySegment arguments.
	 */
	public static long callLong(ApiIndex api, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3) {
		ThreadChecker.ensureMainThread();
		try {
			return (long) requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callLong", t);
		}
	}

	/**
	 * Call an API function that returns long with 2 MemorySegment args and a long
	 * arg.
	 */
	public static long callLong(ApiIndex api, MemorySegment arg1, MemorySegment arg2, long arg3) {
		ThreadChecker.ensureMainThread();
		try {
			return (long) requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callLong", t);
		}
	}

	/**
	 * Call an API function that returns a pointer with 2 args.
	 */
	public static MemorySegment callPtr(ApiIndex api, MemorySegment arg1, MemorySegment arg2) {
		ThreadChecker.ensureMainThread();
		try {
			return (MemorySegment) requireApi(api).invoke(arg1, arg2);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtr", t);
		}
	}

	/**
	 * Call an API function that returns a pointer with 2 MemorySegment args and 1
	 * long arg. Used for classdb_get_method_bind(class, method, hash).
	 */
	public static MemorySegment callPtr2S1L(ApiIndex api, MemorySegment arg1, MemorySegment arg2, long arg3) {
		try {
			return (MemorySegment) requireApi(api).invoke(arg1, arg2, arg3);
		} catch (Throwable t) {
			throw new org.godot.exception.GodotApiException(api.name(), "callPtr2S1L", t);
		}
	}

	/** Return the raw library pointer (GDExtensionClassLibraryPtr). */
	public static long libraryPtr() {
		return LIBRARY_PTR;
	}

	/** Expose the Linker for upcall stub creation in other bridge classes. */
	public static Linker linker() {
		return LINKER;
	}
}
