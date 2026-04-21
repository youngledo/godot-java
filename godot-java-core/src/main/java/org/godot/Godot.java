package org.godot;

import org.godot.annotation.GodotClass;
import org.godot.internal.api.ApiIndex;
import org.godot.bridge.Bridge;
import org.godot.collection.GodotArray;
import org.godot.core.GodotStringName;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.godot.node.InputEvent;
import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.ADDRESS;

/**
 * Abstract root of the entire Godot object hierarchy.
 *
 * All Godot types (RefCounted, Node, String, Array, Dictionary) extend this
 * class. Provides the common API for calling methods, getting/setting
 * properties, and connecting signals.
 *
 * <pre>
 * {@code
 * // All Godot objects inherit from Godot:
 * public class MyNode extends Node2D {
 * } // Node2D → Node → Godot
 * public class MyArray extends Array {
 * } // Array → Godot
 * public class MyString extends String {
 * } // String → Godot
 * }
 * </pre>
 */
public abstract class Godot {

	private static final Logger logger = LogManager.getLogger(Godot.class);

	/** Native Godot object pointer (0 if null/invalid). */
	protected volatile long nativeObject;

	/**
	 * Whether this wrapper is still valid (set to false when Godot frees the
	 * object).
	 */
	private volatile boolean valid = true;

	/** Creates a new Godot object wrapper with a native pointer. */
	protected Godot(long nativeObject) {
		this.nativeObject = nativeObject;
	}

	/** Creates a new Godot object wrapper from a MemorySegment. */
	protected Godot(MemorySegment nativeSegment) {
		this(nativeSegment.address());
	}

	/** Creates a Godot object wrapper for an existing Godot object. */
	protected Godot() {
		this.nativeObject = 0;
	}

	// ------------------------------------------------------------------------
	// Native object management
	// ------------------------------------------------------------------------

	/**
	 * Get the native Godot object pointer. Returns 0 if this wrapper does not wrap
	 * a valid Godot object.
	 */
	public long getPtr() {
		return nativeObject;
	}

	/**
	 * Check if this wrapper wraps a valid Godot object.
	 */
	public boolean isValid() {
		return valid && nativeObject != 0;
	}

	/**
	 * Invalidate this wrapper. Called by free_instance_func when Godot destroys the
	 * object.
	 */
	public void invalidate() {
		this.valid = false;
	}

	/**
	 * Check that this object is still valid before performing an operation.
	 *
	 * @throws org.godot.exception.GodotInvalidObjectException
	 *             if the object has been freed
	 */
	protected void checkValid() {
		if (!valid || nativeObject == 0) {
			throw new org.godot.exception.GodotInvalidObjectException(getClass().getSimpleName()
					+ " has been freed (nativeObject=0x" + Long.toHexString(nativeObject) + ")");
		}
	}

	// ------------------------------------------------------------------------
	// Method call
	// ------------------------------------------------------------------------

	/**
	 * Call a method by name with Variant arguments.
	 *
	 * Always uses OBJECT_METHOD_BIND_CALL (variant-based) for safety. Ptrcall is
	 * unsafe for unknown return types.
	 *
	 * @param methodName
	 *            Godot method name (e.g., "move_and_slide")
	 * @param args
	 *            Variable argument list (converted to Variant)
	 * @return Result as a Java object (or null if void/NIL)
	 */
	public Object call(String methodName, Object... args) {
		checkValid();

		// Special case: Object.get_instance_id() has a direct API
		if ("get_instance_id".equals(methodName) && args.length == 0) {
			return Bridge.callLong(ApiIndex.OBJECT_GET_INSTANCE_ID, MemorySegment.ofAddress(nativeObject));
		}

		return Bridge.runScoped(() -> {
			// Get method hash and the class where it was found (walks hierarchy)
			HashResult hashResult = getMethodHashWithClass(methodName);
			long methodHash = hashResult.hash;
			String className = hashResult.className;

			// Get method bind: walk class hierarchy until a bind is found.
			// Godot 4.6+ requires the correct method hash (hash=0 is rejected).
			GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
			long methodBindAddr = 0;

			// Try the class where hash was found first
			if (className != null) {
				GodotStringName classNameStr = GodotStringName.fromJavaString(className);
				methodBindAddr = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameStr.segment(),
						methodSn.segment(), methodHash).address();
			}

			// Fallback: walk from current class up to Object, using each class's correct
			// hash
			if (methodBindAddr == 0) {
				Class<?> clazz = getClass();
				while (clazz != null && clazz != Godot.class) {
					HashResult fallbackHash = lookupMethodHash(clazz, methodName);
					if (fallbackHash.hash != 0) {
						methodHash = fallbackHash.hash;
						className = fallbackHash.className;
						GodotStringName classNameStr = GodotStringName.fromJavaString(className);
						methodBindAddr = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameStr.segment(),
								methodSn.segment(), methodHash).address();
						if (methodBindAddr != 0)
							break;
					}
					clazz = clazz.getSuperclass();
				}
			}

			// Fallback: try Godot parent class hierarchy via @GodotClass annotation
			if (methodBindAddr == 0) {
				HashResult parentHash = lookupGodotParentMethodHash(methodName);
				if (parentHash.hash != 0) {
					methodHash = parentHash.hash;
					className = parentHash.className;
					GodotStringName classNameStr = GodotStringName.fromJavaString(className);
					methodBindAddr = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameStr.segment(),
							methodSn.segment(), methodHash).address();
				}
			}

			// Final fallback: try Object class using generated method hashes
			if (methodBindAddr == 0) {
				Long objectHash = org.godot.node.ObjectMethodHashes.HASHES.get(methodName);
				if (objectHash != null) {
					GodotStringName objectClass = GodotStringName.fromJavaString("Object");
					methodBindAddr = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, objectClass.segment(),
							methodSn.segment(), objectHash).address();
					if (methodBindAddr != 0)
						className = "Object";
				}
			}

			if (methodBindAddr == 0) {
				throw new RuntimeException("Method bind not found for " + methodName + " on " + className);
			}

			// Convert arguments to Variants
			int argc = args.length;
			MemorySegment argPtrs;
			if (argc > 0) {
				argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);
				for (int i = 0; i < argc; i++) {
					Variant argVar = VariantUtils.fromObject(args[i]);
					argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), argVar.getSegment());
				}
			} else {
				argPtrs = MemorySegment.NULL;
			}

			MemorySegment resultVar = Bridge.allocVariant();
			MemorySegment errorVar = Bridge.allocate(4 * 4);

			Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, MemorySegment.ofAddress(methodBindAddr),
					MemorySegment.ofAddress(nativeObject), argPtrs, (long) argc, resultVar, errorVar);

			int errorCode = errorVar.get(JAVA_INT, 0);
			if (errorCode != 0) {
				int errorArg = errorVar.get(JAVA_INT, 4);
				int errorExpected = errorVar.get(JAVA_INT, 8);
				throw new RuntimeException("Call error " + errorCode + " calling " + methodName + " (arg=" + errorArg
						+ ", expected=" + errorExpected + ")");
			}

			Variant resultVariant = new Variant(resultVar);
			Object result = VariantUtils.toObject(resultVariant);

			// Destroy temporary Variants to release Godot internal references
			Bridge.destroyVariant(resultVar);

			return result;
		});
	}

	/**
	 * Emit a signal on this object.
	 *
	 * Uses the Object.emit_signal vararg method via object_method_bind_call.
	 * Returns the Godot Error code (0 = OK).
	 */
	public int emitSignal(String signalName, Object... args) {
		checkValid();

		return Bridge.runScoped(() -> {
			Long hash = org.godot.node.ObjectMethodHashes.HASHES.get("emit_signal");
			if (hash == null) {
				return -1;
			}

			GodotStringName methodSn = GodotStringName.fromJavaString("emit_signal");
			GodotStringName objectClass = GodotStringName.fromJavaString("Object");
			long methodBindAddr = Bridge
					.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, objectClass.segment(), methodSn.segment(), hash)
					.address();
			if (methodBindAddr == 0) {
				return -2;
			}

			// Build args: [signalName (StringName), ...payload args]
			int argc = 1 + (args != null ? args.length : 0);
			MemorySegment argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);

			Variant snVar = Variant.fromStringName(GodotStringName.fromJavaString(signalName));
			argPtrs.set(ADDRESS, 0, snVar.getSegment());

			for (int i = 0; args != null && i < args.length; i++) {
				Variant argVar = VariantUtils.fromObject(args[i]);
				argPtrs.set(ADDRESS, (long) (i + 1) * ADDRESS.byteSize(), argVar.getSegment());
			}

			MemorySegment resultVar = Bridge.allocVariant();
			MemorySegment errorVar = Bridge.allocate(4 * 4);

			Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, MemorySegment.ofAddress(methodBindAddr),
					MemorySegment.ofAddress(nativeObject), argPtrs, (long) argc, resultVar, errorVar);

			int errorCode = errorVar.get(JAVA_INT, 0);
			if (errorCode != 0) {
				logger.error("emit_signal '{}' failed: call error={}, arg={}, expected={}", signalName, errorCode,
						errorVar.get(JAVA_INT, 4), errorVar.get(JAVA_INT, 8));
				return -3;
			}

			Variant resultVariant = new Variant(resultVar);
			Object result = VariantUtils.toObject(resultVariant);

			Bridge.destroyVariant(resultVar);

			if (result instanceof Number) {
				int err = ((Number) result).intValue();
				if (err != 0) {
					logger.error("emit_signal '{}' returned Error {}", signalName, err);
				}
				return err;
			}
			return 0;
		});
	}

	/**
	 * Get the Godot class name for this object. Subclasses should override this to
	 * enable method bind lookup. Returns null if unknown (method bind lookup will
	 * use NULL class name).
	 */
	protected String getGodotClassName() {
		return null;
	}

	/** Result of method hash lookup: the hash and the class where it was found. */
	protected static class HashResult {
		final long hash;
		final String className;
		HashResult(long hash, String className) {
			this.hash = hash;
			this.className = className;
		}
	}

	/**
	 * Look up a method hash in a specific class's METHOD_HASHES field.
	 */
	@SuppressWarnings("unchecked")
	protected HashResult lookupMethodHash(Class<?> clazz, String methodName) {
		try {
			java.lang.reflect.Field f = clazz.getDeclaredField("METHOD_HASHES");
			f.setAccessible(true);
			java.util.Map<String, Long> hashes = (java.util.Map<String, Long>) f.get(null);
			if (hashes != null && hashes.containsKey(methodName)) {
				String godotClassName = getGodotClassNameFromClass(clazz);
				return new HashResult(hashes.get(methodName), godotClassName);
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			// Not found
		}
		return new HashResult(0L, null);
	}

	/**
	 * Get the GODOT_CLASS_NAME from a class via reflection.
	 */
	protected String getGodotClassNameFromClass(Class<?> clazz) {
		try {
			java.lang.reflect.Field f = clazz.getDeclaredField("GODOT_CLASS_NAME");
			f.setAccessible(true);
			return (String) f.get(null);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			// Fallback: try getGodotClassName() on this instance
			try {
				java.lang.reflect.Method m = clazz.getDeclaredMethod("getGodotClassName");
				m.setAccessible(true);
				return (String) m.invoke(this);
			} catch (Exception e2) {
				return clazz.getSimpleName();
			}
		}
	}

	/**
	 * Get the method hash and the Godot class name where it was found. Walks the
	 * class hierarchy looking for a METHOD_HASHES field. Returns (0, null) if not
	 * found.
	 */
	@SuppressWarnings("unchecked")
	protected HashResult getMethodHashWithClass(String methodName) {
		Class<?> clazz = getClass();
		while (clazz != null && clazz != Godot.class) {
			try {
				java.lang.reflect.Field f = clazz.getDeclaredField("METHOD_HASHES");
				f.setAccessible(true);
				java.util.Map<String, Long> hashes = (java.util.Map<String, Long>) f.get(null);
				if (hashes != null && hashes.containsKey(methodName)) {
					// Get the GODOT_CLASS_NAME from this class
					String godotClassName = null;
					try {
						java.lang.reflect.Field nameField = clazz.getDeclaredField("GODOT_CLASS_NAME");
						nameField.setAccessible(true);
						godotClassName = (String) nameField.get(null);
					} catch (NoSuchFieldException | IllegalAccessException e) {
						// Fall back: use getGodotClassName() via reflection on this instance
						try {
							java.lang.reflect.Method m = clazz.getDeclaredMethod("getGodotClassName");
							m.setAccessible(true);
							godotClassName = (String) m.invoke(this);
						} catch (NoSuchMethodException | IllegalAccessException
								| java.lang.reflect.InvocationTargetException e2) {
							// Last resort: use simple class name
							godotClassName = clazz.getSimpleName();
						}
					}
					return new HashResult(hashes.get(methodName), godotClassName);
				}
			} catch (NoSuchFieldException | IllegalAccessException e) {
				// Not found on this class, try parent
			}
			clazz = clazz.getSuperclass();
		}
		return new HashResult(0L, null);
	}

	/**
	 * Look up a method hash by walking the Godot parent class hierarchy. Used when
	 * the Java class hierarchy doesn't include the Godot parent (e.g., Player
	 * extends Node2D in Java, but @GodotClass(parent="CharacterBody2D")).
	 */
	@SuppressWarnings("unchecked")
	private HashResult lookupGodotParentMethodHash(String methodName) {
		Class<?> cls = getClass();
		GodotClass annotation = cls.getAnnotation(GodotClass.class);
		if (annotation == null) {
			return new HashResult(0L, null);
		}
		String parentName = annotation.parent();
		// Walk the Godot parent class hierarchy via generated Java classes
		while (parentName != null && !parentName.isEmpty()) {
			try {
				Class<?> godotParentClass = Class.forName("org.godot.node." + parentName);
				try {
					java.lang.reflect.Field f = godotParentClass.getDeclaredField("METHOD_HASHES");
					f.setAccessible(true);
					java.util.Map<String, Long> hashes = (java.util.Map<String, Long>) f.get(null);
					if (hashes != null && hashes.containsKey(methodName)) {
						return new HashResult(hashes.get(methodName), parentName);
					}
				} catch (NoSuchFieldException | IllegalAccessException e) {
					// No METHOD_HASHES in this class, continue to parent
				}
				// Move up the Godot hierarchy via Java superclass
				godotParentClass = godotParentClass.getSuperclass();
				parentName = (godotParentClass != null && godotParentClass != Godot.class)
						? godotParentClass.getSimpleName()
						: null;
			} catch (ClassNotFoundException e) {
				break;
			}
		}
		return new HashResult(0L, null);
	}

	/**
	 * Get the Godot class hash for a given method name (legacy, returns hash only).
	 */
	protected long getMethodHash(String methodName) {
		HashResult result = getMethodHashWithClass(methodName);
		return result.hash;
	}

	// ------------------------------------------------------------------------
	// Property access
	// ------------------------------------------------------------------------

	/**
	 * Get a property by name via the scripting property system. Subclasses can
	 * override with typed getters for better performance.
	 */
	public Object getProperty(String name) {
		checkValid();
		// Use the property access method convention: get_<name>
		String getterName = "get_" + name;
		try {
			return call(getterName);
		} catch (RuntimeException e) {
			// Fallback: try property name directly (for indexed accessors)
			return call(name);
		}
	}

	/**
	 * Set a property by name via the scripting property system. Subclasses can
	 * override with typed setters for better performance.
	 */
	public void setProperty(String name, Object value) {
		checkValid();
		// Use the property access method convention: set_<name>
		String setterName = "set_" + name;
		call(setterName, value);
	}

	// ------------------------------------------------------------------------
	// Signal connection
	// ------------------------------------------------------------------------

	/**
	 * Connect a signal to a callable.
	 *
	 * @param signalName
	 *            Name of the signal
	 * @param callable
	 *            Callable to invoke when signal fires
	 * @param flags
	 *            Connection flags (e.g., CONNECT_DEFERRED)
	 * @return true if connected successfully
	 */
	public boolean connect(String signalName, org.godot.core.Callable callable, int flags) {
		checkValid();
		// connect(signal: StringName, callable: Callable, flags: int) -> int (Error)
		Object result = call("connect", signalName, callable, flags);
		if (result instanceof Number) {
			return ((Number) result).intValue() == 0; // 0 = OK in Godot Error enum
		}
		return false;
	}

	// ------------------------------------------------------------------------
	// Virtual lifecycle methods (override in subclasses)
	// ------------------------------------------------------------------------

	/** Called when the node enters the scene tree. */
	public void _ready() {
	}

	/** Called every frame. @param delta Time elapsed since the previous frame. */
	public void _process(double delta) {
	}

	/**
	 * Called every physics frame. @param delta Time elapsed since the previous
	 * physics frame.
	 */
	public void _physicsProcess(double delta) {
	}

	/** Called when the node enters the scene tree. */
	public void _enterTree() {
	}

	/** Called when the node exits the scene tree. */
	public void _exitTree() {
	}

	/**
	 * Called when an InputEvent reaches the node. Return true to indicate the event
	 * was handled.
	 */
	public boolean _input(InputEvent event) {
		return false;
	}

	/**
	 * Called when an InputEvent reaches the node after shortcuts have been
	 * processed.
	 */
	public boolean _shortcutInput(InputEvent event) {
		return false;
	}

	/**
	 * Called when an unhandled InputEvent reaches the node.
	 */
	public boolean _unhandledInput(InputEvent event) {
		return false;
	}

	/**
	 * Called when an unhandled key InputEvent reaches the node.
	 */
	public boolean _unhandledKeyInput(InputEvent event) {
		return false;
	}

	/**
	 * Called to provide configuration warnings for the node.
	 *
	 * @return Array of warning strings
	 */
	public GodotArray _getConfigurationWarnings() {
		return new GodotArray();
	}

	/**
	 * Called to provide accessibility configuration warnings.
	 *
	 * @return Array of warning strings
	 */
	public GodotArray _getAccessibilityConfigurationWarnings() {
		return new GodotArray();
	}

	/**
	 * Returns the currently focused accessibility element.
	 *
	 * @return the focused element or null
	 */
	public Godot _getFocusedAccessibilityElement() {
		return null;
	}

	// ------------------------------------------------------------------------
	// Notifications
	// ------------------------------------------------------------------------

	/**
	 * Called when Godot sends a notification to this object.
	 *
	 * Override to handle notifications like NOTIFICATION_READY (13),
	 * NOTIFICATION_ENTER_TREE (10), NOTIFICATION_EXIT_TREE (11),
	 * NOTIFICATION_PROCESS (15), NOTIFICATION_PHYSICS_PROCESS (16), etc.
	 *
	 * @param what
	 *            The notification constant
	 */
	public void onNotification(int what) {
	}

	// ------------------------------------------------------------------------
	// Lifecycle
	// ------------------------------------------------------------------------

	/**
	 * Free the native Godot object. After calling this, the wrapper is invalid.
	 */
	public void free() {
		if (nativeObject != 0) {
			org.godot.internal.ref.JavaObjectMap.remove(nativeObject);
			nativeObject = 0;
		}
	}

	/**
	 * Called when the native object is freed by Godot. Subclasses can override to
	 * clean up resources.
	 */
	public void onFreed() {
	}

	@Override
	public String toString() {
		if (nativeObject == 0)
			return getClass().getSimpleName() + "[invalid]";
		return getClass().getSimpleName() + "[@" + Long.toHexString(nativeObject) + "]";
	}
}
