package org.godot;

import org.godot.internal.api.ApiIndex;
import org.godot.bridge.Bridge;
import org.godot.collection.GodotArray;
import org.godot.core.GodotStringName;
import org.godot.core.Variant;
import org.godot.core.VariantUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.foreign.MemorySegment;

import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.ADDRESS;

/**
 * Abstract root of the entire Godot object hierarchy.
 *
 * <p>
 * All generated engine classes extend this directly or transitively:
 *
 * <pre>
 * Godot (abstract)
 *   Object (generated)
 *     Node (generated)
 *       Node2D (generated)
 *       Node3D (generated)
 *       ...
 *     RefCounted (generated)
 *       Resource (generated)
 *       ...
 * </pre>
 *
 * <p>
 * Method hash resolution uses virtual dispatch (super call chain), NOT
 * reflection. This ensures:
 * <ul>
 * <li>Zero reflection overhead on the hot call path</li>
 * <li>Full GraalVM native-image compatibility without reflection config</li>
 * <li>JIT-friendly: tiny methods that inline and devirtualize naturally</li>
 * </ul>
 */
public abstract class Godot {

	private static final Logger logger = LogManager.getLogger(Godot.class);

	/** Native Godot object pointer (0 if null/invalid). */
	protected volatile long nativeObject;

	/** Whether this wrapper is still valid. */
	private volatile boolean valid = true;

	protected Godot(long nativeObject) {
		this.nativeObject = nativeObject;
	}

	protected Godot(MemorySegment nativeSegment) {
		this(nativeSegment.address());
	}

	protected Godot() {
		this.nativeObject = 0;
	}

	// ----------------------------------------------------------------
	// Native object management
	// ----------------------------------------------------------------

	public long getPtr() {
		return nativeObject;
	}

	public final long getNativeObject() {
		return nativeObject;
	}

	public final void setNativeObject(long ptr) {
		this.nativeObject = ptr;
	}

	public boolean isValid() {
		return valid && nativeObject != 0;
	}

	public void invalidate() {
		this.valid = false;
	}

	protected void checkValid() {
		if (!valid || nativeObject == 0) {
			throw new org.godot.exception.GodotInvalidObjectException(getClass().getSimpleName()
					+ " has been freed (nativeObject=0x" + Long.toHexString(nativeObject) + ")");
		}
	}

	// ----------------------------------------------------------------
	// Method hash resolution — zero reflection via super call chain
	// ----------------------------------------------------------------

	/**
	 * Result of method hash lookup.
	 */
	public static final class HashResult {
		static final HashResult NOT_FOUND = new HashResult(0, null);
		public final long hash;
		public final String className;

		public HashResult(long hash, String className) {
			this.hash = hash;
			this.className = className;
		}

		boolean isFound() {
			return hash != 0;
		}
	}

	/**
	 * Resolve a method hash by checking this class's METHOD_HASHES, then delegating
	 * to super. Every generated class overrides this.
	 *
	 * <p>
	 * The super call chain naturally walks the Godot class hierarchy:
	 *
	 * <pre>
	 * CharacterBody3D.resolveMethodHash("move_and_slide")
	 *   → found in CharacterBody3D.METHOD_HASHES → return
	 *
	 * CharacterBody3D.resolveMethodHash("get_class")
	 *   → not in CharacterBody3D → super → PhysicsBody3D → ... → Object
	 *   → found in Object.METHOD_HASHES → return
	 * </pre>
	 *
	 * <p>
	 * User classes inherit this from their generated parent — no override needed.
	 */
	protected HashResult resolveMethodHash(String methodName) {
		return HashResult.NOT_FOUND;
	}

	/**
	 * Get the Godot class name for this object. Generated classes override this.
	 */
	protected String getGodotClassName() {
		return null;
	}

	// ----------------------------------------------------------------
	// Method call
	// ----------------------------------------------------------------

	/**
	 * Call a Godot method by name. Uses resolveMethodHash() for hash lookup (zero
	 * reflection) and OBJECT_METHOD_BIND_CALL for variant dispatch.
	 */
	public java.lang.Object call(String methodName, java.lang.Object... args) {
		checkValid();

		if ("get_instance_id".equals(methodName) && args.length == 0) {
			return Bridge.runDowncall(
					() -> Bridge.callLong(ApiIndex.OBJECT_GET_INSTANCE_ID, MemorySegment.ofAddress(nativeObject)));
		}

		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			HashResult hashResult = resolveMethodHash(methodName);
			if (!hashResult.isFound()) {
				throw new RuntimeException(
						"Method hash not found: " + methodName + " on " + getClass().getSimpleName());
			}

			GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
			GodotStringName classNameSn = GodotStringName.fromJavaString(hashResult.className);
			long methodBindAddr = Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameSn.segment(),
					methodSn.segment(), hashResult.hash).address();

			if (methodBindAddr == 0) {
				throw new RuntimeException("Method bind not found: " + methodName + " on " + hashResult.className);
			}

			int argc = args.length;
			MemorySegment argPtrs;
			MemorySegment[] argVarSegments = new MemorySegment[argc];
			try {
				if (argc > 0) {
					argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);
					for (int i = 0; i < argc; i++) {
						Variant argVar = VariantUtils.fromObject(args[i]);
						argVarSegments[i] = argVar.getSegment();
						argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), argVarSegments[i]);
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
					throw new RuntimeException("Call error " + errorCode + " calling " + methodName + " (arg="
							+ errorVar.get(JAVA_INT, 4) + ", expected=" + errorVar.get(JAVA_INT, 8) + ")");
				}

				Variant resultVariant = new Variant(resultVar);
				java.lang.Object result = VariantUtils.toObject(resultVariant);
				Bridge.destroyVariant(resultVar);
				return result;
			} finally {
				for (MemorySegment seg : argVarSegments) {
					if (seg != null) {
						Bridge.destroyVariant(seg);
					}
				}
			}
		}));
	}

	// ----------------------------------------------------------------
	// Signal emission
	// ----------------------------------------------------------------

	/**
	 * Emit a signal on this object. Uses resolveMethodHash() to find
	 * Object.emit_signal hash (zero reflection).
	 */
	public int emitSignal(String signalName, java.lang.Object... args) {
		checkValid();

		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			HashResult hr = resolveMethodHash("emit_signal");
			if (!hr.isFound()) {
				return -1;
			}

			GodotStringName methodSn = GodotStringName.fromJavaString("emit_signal");
			GodotStringName objectClass = GodotStringName.fromJavaString(hr.className);
			long methodBindAddr = Bridge
					.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, objectClass.segment(), methodSn.segment(), hr.hash)
					.address();
			if (methodBindAddr == 0) {
				return -2;
			}

			int argc = 1 + (args != null ? args.length : 0);
			MemorySegment argPtrs = Bridge.allocate(ADDRESS.byteSize() * argc);

			MemorySegment snVarSegment = null;
			MemorySegment[] payloadVarSegments = args != null ? new MemorySegment[args.length] : new MemorySegment[0];
			try {
				Variant snVar = Variant.fromStringName(GodotStringName.fromJavaString(signalName));
				snVarSegment = snVar.getSegment();
				argPtrs.set(ADDRESS, 0, snVarSegment);

				for (int i = 0; args != null && i < args.length; i++) {
					Variant argVar = VariantUtils.fromObject(args[i]);
					payloadVarSegments[i] = argVar.getSegment();
					argPtrs.set(ADDRESS, (long) (i + 1) * ADDRESS.byteSize(), payloadVarSegments[i]);
				}

				MemorySegment resultVar = Bridge.allocVariant();
				MemorySegment errorVar = Bridge.allocate(4 * 4);

				Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, MemorySegment.ofAddress(methodBindAddr),
						MemorySegment.ofAddress(nativeObject), argPtrs, (long) argc, resultVar, errorVar);

				int errorCode = errorVar.get(JAVA_INT, 0);
				if (errorCode != 0) {
					logger.error("emit_signal '{}' failed: error={}", signalName, errorCode);
					return -3;
				}

				Variant resultVariant = new Variant(resultVar);
				java.lang.Object result = VariantUtils.toObject(resultVariant);
				Bridge.destroyVariant(resultVar);

				if (result instanceof Number) {
					return ((Number) result).intValue();
				}
				return 0;
			} finally {
				if (snVarSegment != null) {
					Bridge.destroyVariant(snVarSegment);
				}
				for (MemorySegment seg : payloadVarSegments) {
					if (seg != null) {
						Bridge.destroyVariant(seg);
					}
				}
			}
		}));
	}

	// ----------------------------------------------------------------
	// Virtual lifecycle methods (override in subclasses)
	// ----------------------------------------------------------------

	public void _ready() {
	}

	public void _process(double delta) {
	}

	public void _physicsProcess(double delta) {
	}

	public void _enterTree() {
	}

	public void _exitTree() {
	}

	public boolean _input(java.lang.Object event) {
		return false;
	}

	public boolean _shortcutInput(java.lang.Object event) {
		return false;
	}

	public boolean _unhandledInput(java.lang.Object event) {
		return false;
	}

	public boolean _unhandledKeyInput(java.lang.Object event) {
		return false;
	}

	public GodotArray _getConfigurationWarnings() {
		return new GodotArray();
	}

	public GodotArray _getAccessibilityConfigurationWarnings() {
		return new GodotArray();
	}

	public Godot _getFocusedAccessibilityElement() {
		return null;
	}

	public void onNotification(int what) {
	}

	// ----------------------------------------------------------------
	// Property access
	// ----------------------------------------------------------------

	public java.lang.Object getProperty(String name) {
		checkValid();
		try {
			return call("get_" + name);
		} catch (RuntimeException e) {
			return call(name);
		}
	}

	public void setProperty(String name, java.lang.Object value) {
		checkValid();
		call("set_" + name, value);
	}

	// ----------------------------------------------------------------
	// Signal connection
	// ----------------------------------------------------------------

	public boolean connect(String signalName, org.godot.core.Callable callable, int flags) {
		checkValid();
		java.lang.Object result = call("connect", signalName, callable, flags);
		if (result instanceof Number) {
			return ((Number) result).intValue() == 0;
		}
		return false;
	}

	// ----------------------------------------------------------------
	// Lifecycle
	// ----------------------------------------------------------------

	public void free() {
		if (nativeObject != 0) {
			org.godot.internal.ref.JavaObjectMap.remove(nativeObject);
			nativeObject = 0;
		}
	}

	public void onFreed() {
	}

	@Override
	public String toString() {
		if (nativeObject == 0)
			return getClass().getSimpleName() + "[invalid]";
		return getClass().getSimpleName() + "[@" + Long.toHexString(nativeObject) + "]";
	}
}
