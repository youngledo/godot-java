package org.godot.core;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.builtin.BuiltinMethodCache;
import org.godot.internal.dispatch.Dispatch;

/// A callable object that wraps a method call on a Godot object.
///
/// Two modes:
/// 1. Java callable: wraps a (Godot object, method name) pair, invoked via dispatch.
/// 2. Native callable: wraps a Godot Callable received from the engine, invoked via CALLABLE_CALL builtin method.
public final class Callable {
	static final long NATIVE_SIZE = 16;

	private static final int CALLABLE_TYPE_INDEX = 25;
	private static final long CALL_HASH = 3643564216L;
	private static volatile MethodHandle callMethodHandle;

	private final Godot object;
	private final String methodName;
	private final Object[] boundArgs;
	private final MemorySegment nativeCallable;

	public Callable(Godot object, String methodName) {
		this(object, methodName, (Object[]) null);
	}

	/// Create a callable with pre-bound arguments.
	public Callable(Godot object, String methodName, Object... boundArgs) {
		this.object = object;
		this.methodName = methodName;
		this.boundArgs = boundArgs != null && boundArgs.length > 0 ? boundArgs : null;
		this.nativeCallable = null;
	}

	/// Wraps a native Godot Callable received from the engine.
	Callable(MemorySegment nativeCallable) {
		this.object = null;
		this.methodName = "";
		this.boundArgs = null;
		this.nativeCallable = nativeCallable;
	}

	public Godot getObject() {
		return object;
	}

	public String getMethod() {
		return methodName;
	}

	/// Invoke this callable with the given arguments.
	///
	/// For native callables (received from Godot), uses the Callable.call() builtin method
	/// through BuiltinMethodCache. For Java callables, delegates to the target object's method.
	public Object call(Object... args) {
		if (nativeCallable != null && !nativeCallable.equals(MemorySegment.NULL)) {
			return callNative(args);
		}
		if (object == null)
			return null;
		Object[] allArgs = boundArgs != null ? concat(boundArgs, args) : args;
		try {
			return Dispatch.dispatchVariantCall(Dispatch.getGodotClassName(object.getClass().getName()), methodName,
					object, allArgs);
		} catch (Throwable t) {
			throw new RuntimeException("Callable call failed: " + methodName, t);
		}
	}

	/// Returns true if this callable can be invoked.
	public boolean isValid() {
		if (nativeCallable != null && !nativeCallable.equals(MemorySegment.NULL)) {
			return true;
		}
		return object != null && object.isValid();
	}

	/// Create a native callable for passing to Godot APIs (e.g., Signal.connect).
	public NativeCallable asNativeCallable() {
		if (nativeCallable != null) {
			return new NativeCallable(nativeCallable, 0);
		}
		return NativeCallable.create(object, methodName, boundArgs);
	}

	Object[] getBoundArgs() {
		return boundArgs;
	}

	MemorySegment nativeSegment() {
		return nativeCallable;
	}

	private Object callNative(Object... args) {
		return Bridge.runScoped(() -> {
			int argc = args != null ? args.length : 0;

			// Allocate argument variants
			MemorySegment argVariants = Bridge.arena().allocate(argc * 24L, 8);
			for (int i = 0; i < argc; i++) {
				VariantUtils.fromObjectInto(args[i], argVariants.asSlice(i * 24L, 24));
			}

			// Build array of pointers to each variant
			MemorySegment argPtrs = argc > 0 ? Bridge.arena().allocate((long) argc * 8, 8) : MemorySegment.NULL;
			for (int i = 0; i < argc; i++) {
				argPtrs.set(ValueLayout.ADDRESS, (long) i * 8, argVariants.asSlice(i * 24L, 24));
			}

			// Allocate return variant (24 bytes)
			MemorySegment retVariant = Bridge.arena().allocate(24, 8);

			// Get cached method handle for Callable.call()
			MethodHandle mh = getCallMethodHandle();

			// Invoke: call(base=callable, args=argPtrs, ret=retVariant, argc=argc)
			BuiltinMethodCache.invoke(mh, nativeCallable, argPtrs, retVariant, argc);

			return VariantUtils.toObject(new Variant(retVariant));
		});
	}

	private static MethodHandle getCallMethodHandle() {
		if (callMethodHandle == null) {
			synchronized (Callable.class) {
				if (callMethodHandle == null) {
					callMethodHandle = BuiltinMethodCache.getMethod(CALLABLE_TYPE_INDEX, "call", CALL_HASH);
				}
			}
		}
		return callMethodHandle;
	}

	private static Object[] concat(Object[] a, Object[] b) {
		Object[] result = new Object[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}
}
