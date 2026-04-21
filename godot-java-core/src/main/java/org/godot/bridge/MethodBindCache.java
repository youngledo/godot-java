package org.godot.bridge;

import org.godot.core.GodotString;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache for ClassDB method bind IDs.
 *
 * Key format: "ClassName.methodName#hashHex" (e.g.
 * "Node2D.get_position#f4ff7e48") The hash distinguishes variant-call vs
 * ptrcall for the same method.
 *
 * Lookup flow: 1. Check cache → return if found 2. Call
 * classdb_get_method_bind(className, methodName, hash) 3. Store in cache (even
 * if result is 0, to avoid repeated lookup)
 */
public final class MethodBindCache {

	private MethodBindCache() {
	}

	private static final ConcurrentHashMap<String, Integer> CACHE = new ConcurrentHashMap<>();

	/**
	 * Get a method bind ID, using cache if available.
	 *
	 * @param className
	 *            Godot class name (e.g. "Node2D")
	 * @param methodName
	 *            Godot method name (e.g. "get_position")
	 * @param hash
	 *            Method hash from method_hashes.txt (0 if unknown)
	 * @return Method bind ID, or 0 if not found
	 */
	public static int get(String className, String methodName, int hash) {
		String key = makeKey(className, methodName, hash);
		return CACHE.computeIfAbsent(key, k -> lookup(className, methodName, hash));
	}

	/**
	 * Look up and cache a method bind. Returns cached value if already looked up.
	 *
	 * @return method bind ID (cast from pointer), or 0 if not found
	 */
	private static int lookup(String className, String methodName, int hash) {
		// Create native GodotString for class name and method name
		GodotString classNameStr = GodotString.fromJavaString(className);
		GodotString methodNameStr = GodotString.fromJavaString(methodName);

		// Call: GDExtensionMethodBindPtr classdb_get_method_bind(StringName*,
		// StringName*, GDExtensionInt hash)
		// Returns a pointer
		MemorySegment bindPtr = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameStr.segment(),
				methodNameStr.segment(), hash);

		// Cast pointer to int (Godot does the same internally for method bind IDs)
		return (int) bindPtr.address();
	}

	/**
	 * Clear the entire cache. Call when Godot ClassDB is modified.
	 */
	public static void clear() {
		CACHE.clear();
	}

	/**
	 * Check if a method is cached.
	 */
	public static boolean contains(String className, String methodName, int hash) {
		return CACHE.containsKey(makeKey(className, methodName, hash));
	}

	private static String makeKey(String className, String methodName, int hash) {
		return className + "." + methodName + "#" + Integer.toHexString(hash);
	}
}
