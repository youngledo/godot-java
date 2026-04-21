package org.godot.internal.ref;

import org.godot.Godot;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bidirectional map between native Godot object pointers (long) and Java Godot
 * object wrappers (Godot subclasses).
 *
 * Maintains: - nativePtr → Java object (for Godot → Java callbacks) - Java
 * object → nativePtr (for lookups)
 */
public final class JavaObjectMap {

	private JavaObjectMap() {
	}

	/**
	 * Native pointer (key) → Java object (value).
	 */
	private static final ConcurrentHashMap<Long, Godot> NATIVE_TO_JAVA = new ConcurrentHashMap<>();

	/**
	 * Java object → native pointer.
	 */
	private static final ConcurrentHashMap<Godot, Long> JAVA_TO_NATIVE = new ConcurrentHashMap<>();

	/**
	 * Register a Java wrapper for a native object.
	 */
	public static void put(long nativePtr, Godot javaObj) {
		NATIVE_TO_JAVA.put(nativePtr, javaObj);
		JAVA_TO_NATIVE.put(javaObj, nativePtr);
	}

	/**
	 * Look up a Java wrapper by native pointer. Returns null if not registered.
	 */
	public static Godot get(long nativePtr) {
		return NATIVE_TO_JAVA.get(nativePtr);
	}

	/**
	 * Remove a registration. Called when Godot destroys the native object.
	 */
	public static void remove(long nativePtr) {
		Godot obj = NATIVE_TO_JAVA.remove(nativePtr);
		if (obj != null) {
			JAVA_TO_NATIVE.remove(obj);
			obj.onFreed();
		}
	}

	/**
	 * Check if a native pointer is registered.
	 */
	public static boolean contains(long nativePtr) {
		return NATIVE_TO_JAVA.containsKey(nativePtr);
	}
}
