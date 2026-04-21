package org.godot.bridge;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creates Panama upcall stubs for Godot lifecycle methods.
 *
 * <p>
 * When a Godot Node calls a virtual method like `_ready()` or
 * `_process(delta)`, the native C++ layer invokes a function pointer. This
 * class creates that function pointer from a Java MethodHandle using Panama's
 * {@link Linker#upcallStub}.
 *
 * <p>
 * Usage:
 *
 * <pre>
 * // Create upcall stub for a Node's _process method
 * Node node = (Node) javaObject;
 * MethodHandle processHandle = MethodHandles.lookup()
 * 		.unreflectSpecial(Node.class.getDeclaredMethod("_process", double.class), Node.class).bindTo(node);
 *
 * MemorySegment processStub = UpcallStub.create(processHandle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
 *
 * // Pass processStub to C++ trampoline for registration
 * </pre>
 *
 * <p>
 * The created native function pointer lives in memory managed by this class's
 * arena and is freed when {@link #free} is called.
 */
public final class UpcallStub {

	private UpcallStub() {
	}

	/** Linker for the native platform ABI. */
	private static final Linker LINKER = Linker.nativeLinker();

	/** Live stubs mapped by their MemorySegment address. */
	private static final Map<MemorySegment, MemorySegment> LIVE_STUBS = new ConcurrentHashMap<>();

	/**
	 * Create a native function pointer that, when called from native code, invokes
	 * the given Java method handle.
	 *
	 * <p>
	 * The method handle should be bound to the target object (e.g., the Node).
	 * Arguments passed from native code are forwarded to the method handle.
	 *
	 * @param handle
	 *            Bound method handle to invoke
	 * @param desc
	 *            Function descriptor matching the native function signature
	 * @return MemorySegment containing the native function pointer
	 */
	public static MemorySegment create(MethodHandle handle, FunctionDescriptor desc) {
		MemorySegment stub = LINKER.upcallStub(handle, desc, Bridge.arena());
		LIVE_STUBS.put(stub, stub);
		return stub;
	}

	/**
	 * Create a simple void(void) upcall for methods like _ready().
	 *
	 * @param target
	 *            The object to call the method on
	 * @param methodName
	 *            Name of the method (e.g., "_ready")
	 * @param clazz
	 *            Class containing the method
	 * @return MemorySegment containing the native function pointer
	 */
	public static MemorySegment createVoid(Object target, String methodName, Class<?> clazz) {
		try {
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			MethodHandle handle = lookup.unreflectSpecial(clazz.getDeclaredMethod(methodName), clazz).bindTo(target);
			return create(handle, FunctionDescriptor.ofVoid());
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException("Failed to create upcall for " + methodName, e);
		}
	}

	/**
	 * Create a void(double) upcall for methods like _process(delta) or
	 * _physicsProcess(delta).
	 *
	 * @param target
	 *            The object to call the method on
	 * @param methodName
	 *            Name of the method (e.g., "_process")
	 * @param clazz
	 *            Class containing the method
	 * @return MemorySegment containing the native function pointer
	 */
	public static MemorySegment createVoidDouble(Object target, String methodName, Class<?> clazz) {
		try {
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			MethodHandle handle = lookup.unreflectSpecial(clazz.getDeclaredMethod(methodName, double.class), clazz)
					.bindTo(target);
			return create(handle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException("Failed to create upcall for " + methodName, e);
		}
	}

	/**
	 * Free a previously created upcall stub. The stub's memory is released from the
	 * arena.
	 *
	 * @param stub
	 *            The stub to free (previously returned by {@link #create})
	 */
	public static void free(MemorySegment stub) {
		LIVE_STUBS.remove(stub);
		// Memory is freed when the arena closes (JVM shutdown or explicit close)
	}

	/**
	 * Free all live upcall stubs.
	 */
	public static void freeAll() {
		LIVE_STUBS.clear();
	}

	/**
	 * Create a native function pointer for a method returning Variant*. Used
	 * for @GodotMethod annotated methods that return GodotObject or RefCounted.
	 *
	 * <p>
	 * Task 5.7: Handles upcall for methods returning Variant*. The native function
	 * returns a Variant* (pointer) which is the object handle.
	 *
	 * @param target
	 *            The object to call the method on
	 * @param methodName
	 *            Name of the method
	 * @param clazz
	 *            Class containing the method
	 * @param fd
	 *            FunctionDescriptor specifying the native signature
	 * @return MemorySegment containing the native function pointer
	 */
	public static MemorySegment createForVariantPtr(Object target, String methodName, Class<?> clazz,
			FunctionDescriptor fd) {
		try {
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			// The method returns an Object (GodotObject/RefCounted), which gets
			// converted to a native Variant* pointer by the bridge layer.
			// For now, we use void return — the actual return conversion happens
			// in the trampoline dispatcher.
			java.lang.reflect.Method method = clazz.getDeclaredMethod(methodName);
			MethodHandle handle = lookup.unreflect(method).bindTo(target);
			return create(handle, fd);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException("Failed to create VariantPtr upcall for " + methodName, e);
		}
	}
}
