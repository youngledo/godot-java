package org.godot.core;

import java.lang.foreign.MemorySegment;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;
import org.godot.Godot;
import org.godot.bridge.Bridge;
import org.godot.bridge.CallableDispatch;
import org.godot.internal.api.ApiIndex;

/**
 * A native Godot Callable wrapper.
 *
 * <p>
 * Wraps a native callable_custom created via callable_custom_create2. This
 * allows Java to receive callbacks from native code when a signal is emitted.
 *
 * <p>
 * The native callable stores an upcall stub pointer (call_func) that Godot
 * calls when the callable is invoked. The upcall stub dispatches to the bound
 * Java method via CallableDispatch.
 *
 * <pre>
 * // Create a callable that invokes "onButtonPressed" on myNode when called
 * NativeCallable callable = NativeCallable.create(myNode, "onButtonPressed");
 *
 * // Pass to Godot signal connect
 * button.connect("pressed", callable.asCallable(), 0);
 * </pre>
 */
public final class NativeCallable {

	/** Size of GDExtensionCallableCustomInfo2 struct (96 bytes). */
	private static final long INFO_SIZE = 96;

	/** Token pointer for identifying this GDExtension (library pointer). */
	private static final long TOKEN = Bridge.libraryPtr();

	/** Native memory segment pointing to the Callable struct (32 bytes). */
	private final MemorySegment segment;

	/** Key for unregistering from CallableDispatch. */
	private final long dispatchKey;

	/**
	 * Create a NativeCallable for the given object and method.
	 *
	 * @param object
	 *            The Godot object to call the method on
	 * @param methodName
	 *            Name of the method to invoke
	 * @return A new NativeCallable wrapping the native callable
	 */
	public static NativeCallable create(Godot object, String methodName) {
		return create(object, methodName, (Object[]) null);
	}

	/**
	 * Create a NativeCallable with pre-bound arguments.
	 *
	 * @param object
	 *            The Godot object to call the method on
	 * @param methodName
	 *            Name of the method to invoke
	 * @param boundArgs
	 *            Arguments to pre-bind (passed before any additional args)
	 * @return A new NativeCallable wrapping the native callable
	 */
	public static NativeCallable create(Godot object, String methodName, Object... boundArgs) {
		// Register the callable with CallableDispatch, get a key for userdata
		long key = CallableDispatch.registerCallable(object, methodName, boundArgs);

		// Allocate the native Callable struct (32 bytes)
		MemorySegment callableSeg = Bridge.allocate(32);

		// Allocate the GDExtensionCallableCustomInfo2 struct
		MemorySegment infoSeg = Bridge.allocate(INFO_SIZE);

		// Fill GDExtensionCallableCustomInfo2 at offset 0 of infoSeg:
		// 0: callable_userdata (key as pointer)
		// 8: token
		// 16: object_id
		// 24: call_func
		// 32: is_valid_func (0 = use default)
		// 40: free_func
		// 48: hash_func
		// 56: equal_func
		// 64: less_than_func
		// 72: to_string_func
		// 80: get_argument_count_func
		infoSeg.set(ADDRESS, 0, MemorySegment.ofAddress(key)); // callable_userdata = dispatch key
		infoSeg.set(ADDRESS, 8, MemorySegment.ofAddress(TOKEN)); // token = library ptr
		long instanceId = Bridge.callLong(ApiIndex.OBJECT_GET_INSTANCE_ID, MemorySegment.ofAddress(object.getPtr()));
		infoSeg.set(JAVA_LONG, 16, instanceId); // object_id
		infoSeg.set(ADDRESS, 24, CallableDispatch.getCallStub()); // call_func

		// Optional function pointers — set to NULL (use defaults)
		infoSeg.set(ADDRESS, 32, MemorySegment.ofAddress(0)); // is_valid_func
		infoSeg.set(ADDRESS, 40, MemorySegment.ofAddress(0)); // free_func
		infoSeg.set(ADDRESS, 48, MemorySegment.ofAddress(0)); // hash_func
		infoSeg.set(ADDRESS, 56, MemorySegment.ofAddress(0)); // equal_func
		infoSeg.set(ADDRESS, 64, MemorySegment.ofAddress(0)); // less_than_func
		infoSeg.set(ADDRESS, 72, MemorySegment.ofAddress(0)); // to_string_func
		infoSeg.set(ADDRESS, 80, MemorySegment.ofAddress(0)); // get_argument_count_func

		// Call callable_custom_create2 to create the native callable
		// signature: void(GDExtensionTypePtr r_callable,
		// GDExtensionCallableCustomInfo2*
		// p_callable_custom_info)
		Bridge.callVoid(ApiIndex.CALLABLE_CUSTOM_CREATE2, callableSeg, infoSeg);

		return new NativeCallable(callableSeg, key);
	}

	private NativeCallable(MemorySegment segment, long dispatchKey) {
		this.segment = segment;
		this.dispatchKey = dispatchKey;
	}

	/**
	 * Get the native memory segment for this callable.
	 */
	public MemorySegment getSegment() {
		return segment;
	}

	/**
	 * Get the native pointer to this callable (for passing to Godot APIs).
	 */
	public long getPtr() {
		return segment.address();
	}

	/**
	 * Free this callable and unregister from CallableDispatch.
	 */
	public void free() {
		CallableDispatch.unregisterCallable(dispatchKey);
	}
}
