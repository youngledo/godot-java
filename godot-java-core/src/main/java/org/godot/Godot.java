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
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.ADDRESS;

public abstract class Godot {

	private static final Logger logger = LogManager.getLogger(Godot.class);

	/** Cache: "className::methodName" → MethodBind pointer. Never evicted. */
	private static final ConcurrentHashMap<String, MemorySegment> METHOD_BIND_CACHE = new ConcurrentHashMap<>();

	private static MemorySegment getCachedMethodBind(String className, String methodName, long hash) {
		String key = className + "::" + methodName;
		return METHOD_BIND_CACHE.computeIfAbsent(key, k -> {
			GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
			GodotStringName classNameSn = GodotStringName.fromJavaString(className);
			return Bridge.callPtr2S1L(ApiIndex.CLASSDB_GET_METHOD_BIND, classNameSn.segment(), methodSn.segment(),
					hash);
		});
	}

	protected volatile long nativeObject;

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
	// Method hash resolution
	// ----------------------------------------------------------------

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

	protected HashResult resolveMethodHash(String methodName) {
		return HashResult.NOT_FOUND;
	}

	protected String getGodotClassName() {
		return null;
	}

	// ----------------------------------------------------------------
	// Method call
	// ----------------------------------------------------------------

	public java.lang.Object call(String methodName, java.lang.Object... args) {
		checkValid();

		if ("get_instance_id".equals(methodName) && args.length == 0) {
			return Bridge.runDowncall(
					() -> Bridge.callLong(ApiIndex.OBJECT_GET_INSTANCE_ID, MemorySegment.ofAddress(nativeObject)));
		}

		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			int depth = Bridge.callDepth();
			if (depth >= Bridge.MAX_CALL_DEPTH) {
				throw new RuntimeException("Maximum call depth exceeded: " + depth);
			}
			int argc = args.length;
			if (argc > Bridge.MAX_CALL_ARGS) {
				throw new RuntimeException("Too many arguments: " + argc + " (max " + Bridge.MAX_CALL_ARGS + ")");
			}

			try {
				// Destroy previous result at this depth to release RefCounted refs.
				// CALL_FRAMES is zero-initialized, so first call is a no-op.
				Bridge.destroyVariant(Bridge.resultSlot(depth));
				MemorySegment argPtrs;
				if (argc > 0) {
					argPtrs = Bridge.argPtrsSlot(depth);
					for (int i = 0; i < argc; i++) {
						MemorySegment slot = Bridge.argSlot(depth, i);
						VariantUtils.fromObjectInto(args[i], slot);
						argPtrs.set(ADDRESS, (long) i * ADDRESS.byteSize(), slot);
					}
				} else {
					argPtrs = MemorySegment.NULL;
				}

				MemorySegment resultVar = Bridge.resultSlot(depth);
				MemorySegment errorVar = Bridge.errorSlot(depth);

				return Bridge.withCallDepth(depth, () -> {
					HashResult hashResult = resolveMethodHash(methodName);
					if (hashResult.isFound()) {
						MemorySegment methodBind = getCachedMethodBind(hashResult.className, methodName,
								hashResult.hash);
						if (methodBind.address() == 0) {
							throw new RuntimeException(
									"Method bind not found: " + methodName + " on " + hashResult.className);
						}
						Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, methodBind,
								MemorySegment.ofAddress(nativeObject), argPtrs, (long) argc, resultVar, errorVar);
					} else {
						GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
						Bridge.callVoid(ApiIndex.OBJECT_CALL_SCRIPT_METHOD, MemorySegment.ofAddress(nativeObject),
								methodSn.segment(), argPtrs, (long) argc, resultVar, errorVar);
					}

					int errorCode = errorVar.get(JAVA_INT, 0);
					if (errorCode != 0) {
						StringBuilder sb = new StringBuilder();
						sb.append("Call error ").append(errorCode).append(" calling ").append(methodName);
						sb.append(" (arg=").append(errorVar.get(JAVA_INT, 4));
						sb.append(", expected=").append(errorVar.get(JAVA_INT, 8)).append(")");
						throw new RuntimeException(sb.toString());
					}

					Variant resultVariant = new Variant(resultVar);
					return VariantUtils.toObject(resultVariant);
				});
			} finally {
				for (int i = 0; i < argc; i++) {
					Bridge.destroyVariant(Bridge.argSlot(depth, i));
				}
			}
		}));
	}

	// ----------------------------------------------------------------
	// Signal emission
	// ----------------------------------------------------------------

	public int emitSignal(String signalName, java.lang.Object... args) {
		checkValid();

		return Bridge.runDowncall(() -> Bridge.runScoped(() -> {
			int depth = Bridge.callDepth();
			if (depth >= Bridge.MAX_CALL_DEPTH) {
				return -1;
			}

			HashResult hr = resolveMethodHash("emit_signal");
			if (!hr.isFound()) {
				return -1;
			}

			MemorySegment methodBind = getCachedMethodBind(hr.className, "emit_signal", hr.hash);
			if (methodBind.address() == 0) {
				return -2;
			}

			int argc = 1 + (args != null ? args.length : 0);
			if (argc > Bridge.MAX_CALL_ARGS) {
				return -1;
			}

			try {
				Bridge.destroyVariant(Bridge.resultSlot(depth));
				MemorySegment argPtrs = Bridge.argPtrsSlot(depth);

				MemorySegment snSlot = Bridge.argSlot(depth, 0);
				Variant.fromStringNameInto(GodotStringName.fromJavaString(signalName), snSlot);
				argPtrs.set(ADDRESS, 0, snSlot);

				for (int i = 0; args != null && i < args.length; i++) {
					MemorySegment slot = Bridge.argSlot(depth, i + 1);
					VariantUtils.fromObjectInto(args[i], slot);
					argPtrs.set(ADDRESS, (long) (i + 1) * ADDRESS.byteSize(), slot);
				}

				MemorySegment resultVar = Bridge.resultSlot(depth);
				MemorySegment errorVar = Bridge.errorSlot(depth);

				return Bridge.withCallDepth(depth, () -> {
					Bridge.callVoid(ApiIndex.OBJECT_METHOD_BIND_CALL, methodBind, MemorySegment.ofAddress(nativeObject),
							argPtrs, (long) argc, resultVar, errorVar);

					int errorCode = errorVar.get(JAVA_INT, 0);
					if (errorCode != 0) {
						logger.error("emit_signal '{}' failed: error={}", signalName, errorCode);
						return -3;
					}

					Variant resultVariant = new Variant(resultVar);
					java.lang.Object result = VariantUtils.toObject(resultVariant);
					if (result instanceof Number) {
						return ((Number) result).intValue();
					}
					return 0;
				});
			} finally {
				for (int i = 0; i < argc; i++) {
					Bridge.destroyVariant(Bridge.argSlot(depth, i));
				}
			}
		}));
	}

	// ----------------------------------------------------------------
	// Virtual lifecycle methods
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
