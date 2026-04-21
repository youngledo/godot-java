package org.godot.core;

import org.godot.Godot;

/**
 * A callable object that wraps a method call on a Godot object. Used by the
 * signal/connect system.
 *
 * <p>
 * Callables can be created from a Godot object and method name, and can be
 * passed to Godot APIs. For use with Signal.connect() to receive callbacks from
 * Godot, use {@link #asNativeCallable()} to create a native callable.
 *
 * <pre>
 * // Create a callable for a method
 * Callable callable = new Callable(myNode, "onButtonPressed");
 *
 * // Connect to a signal with the native callable
 * button.connect("pressed", callable.asNativeCallable(), 0);
 * </pre>
 */
public final class Callable {
	private final Godot object;
	private final String methodName;
	private final Object[] boundArgs;

	public Callable(Godot object, String methodName) {
		this(object, methodName, (Object[]) null);
	}

	/**
	 * Create a callable with pre-bound arguments.
	 *
	 * @param object
	 *            The Godot object to call the method on
	 * @param methodName
	 *            Name of the method to invoke
	 * @param boundArgs
	 *            Arguments to pre-bind (will be passed before any additional args)
	 */
	public Callable(Godot object, String methodName, Object... boundArgs) {
		this.object = object;
		this.methodName = methodName;
		this.boundArgs = boundArgs != null && boundArgs.length > 0 ? boundArgs : null;
	}

	/**
	 * Return the Godot object this callable targets.
	 */
	public Godot getObject() {
		return object;
	}

	public String getMethod() {
		return methodName;
	}

	/**
	 * Invoke the callable with the given arguments (pre-bound args come first).
	 */
	public Object call(Object... args) {
		if (boundArgs != null) {
			Object[] combined = new Object[boundArgs.length + args.length];
			System.arraycopy(boundArgs, 0, combined, 0, boundArgs.length);
			System.arraycopy(args, 0, combined, boundArgs.length, args.length);
			return object.call(methodName, combined);
		}
		return object.call(methodName, args);
	}

	/**
	 * Create a native callable for passing to Godot APIs (e.g., Signal.connect).
	 *
	 * <p>
	 * The returned NativeCallable must be freed when no longer needed by calling
	 * {@link NativeCallable#free()}.
	 *
	 * @return A new NativeCallable that wraps this callable's object and method
	 */
	public NativeCallable asNativeCallable() {
		return NativeCallable.create(object, methodName, boundArgs);
	}

	/**
	 * Get pre-bound arguments, if any.
	 */
	Object[] getBoundArgs() {
		return boundArgs;
	}
}
