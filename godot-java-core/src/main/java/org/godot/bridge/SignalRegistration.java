package org.godot.bridge;

import org.godot.annotation.Signal;
import org.godot.core.GodotString;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.StructOffsets;
import java.lang.foreign.MemorySegment;
import java.lang.reflect.Method;
import static java.lang.foreign.ValueLayout.*;

/**
 * Handles registration of @Signal annotated methods as Godot signals.
 *
 * <p>
 * classdb_register_extension_class_signal(library, className, signalName,
 * argumentInfo*, argCount)
 *
 * <p>
 * Method parameters become signal argument names. If the method has no
 * parameters, the signal has no arguments.
 */
public final class SignalRegistration {

	private SignalRegistration() {
	}

	// Shared empty strings — Godot dereferences ALL string pointers unconditionally
	private static final GodotStringName EMPTY_SN = GodotStringName.fromJavaString("");
	private static final GodotString EMPTY_STR = GodotString.fromJavaString("");

	/**
	 * Register all @Signal annotated methods of a class as Godot signals.
	 */
	public static int registerSignals(String className) {
		Class<?> clazz = InstanceCallbacks.getJavaClass(className);
		if (clazz == null)
			return 0;

		int count = 0;
		for (Method method : clazz.getDeclaredMethods()) {
			if (!method.isAnnotationPresent(Signal.class))
				continue;

			registerSignal(className, method);
			count++;
		}
		return count;
	}

	private static void registerSignal(String godotClassName, Method method) {
		Signal signal = method.getAnnotation(Signal.class);
		String signalName = signal.name().isEmpty() ? method.getName() : signal.name();

		GodotStringName signalSn = GodotStringName.fromJavaString(signalName);
		GodotStringName classSn = GodotStringName.fromJavaString(godotClassName);

		// Build argument info array from method parameters
		int argCount = method.getParameterCount();
		MemorySegment argumentInfo = buildArgumentInfo(method);

		// Register: classdb_register_extension_class_signal(library, className,
		// signalName, argumentInfo*, argCount)
		Bridge.callVoid4S1L(ApiIndex.CLASSDB_REGISTER_EXTENSION_CLASS_SIGNAL,
				MemorySegment.ofAddress(Bridge.libraryPtr()), classSn.segment(), signalSn.segment(), argumentInfo,
				(long) argCount);
	}

	/**
	 * Build an array of GDExtensionPropertyInfo structs for signal arguments. Each
	 * PropertyInfo is 48 bytes. All string fields MUST be valid pointers.
	 */
	private static MemorySegment buildArgumentInfo(Method method) {
		int argCount = method.getParameterCount();
		if (argCount == 0) {
			return MemorySegment.NULL;
		}

		Class<?>[] paramTypes = method.getParameterTypes();
		java.lang.reflect.Parameter[] params = method.getParameters();

		long totalSize = (long) argCount * StructOffsets.PROPERTY_INFO_SIZE;
		MemorySegment array = Bridge.allocate(totalSize);

		for (int i = 0; i < argCount; i++) {
			long offset = (long) i * StructOffsets.PROPERTY_INFO_SIZE;
			// type (uint32_t)
			int typeId = javaTypeToVariantTypeId(paramTypes[i]);
			array.set(JAVA_INT, offset + StructOffsets.PROPERTY_INFO_OFF_TYPE, typeId);
			// name (StringName*) — MUST be valid pointer
			GodotStringName argNameSn = GodotStringName.fromJavaString(params[i].getName());
			array.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_NAME,
					MemorySegment.ofAddress(argNameSn.segment().address()));
			// class_name (StringName*) — MUST be valid pointer
			array.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_CLASS_NAME,
					MemorySegment.ofAddress(EMPTY_SN.segment().address()));
			// hint (uint32_t) = 0
			// hint_string (String*) — MUST be valid pointer
			array.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_HINT_STRING,
					MemorySegment.ofAddress(EMPTY_STR.segment().address()));
			// usage (uint32_t) = 0
		}

		return array;
	}

	private static int javaTypeToVariantTypeId(Class<?> type) {
		if (type == boolean.class || type == Boolean.class)
			return 1; // BOOL
		if (type == int.class || type == Integer.class)
			return 2; // INT
		if (type == long.class || type == Long.class)
			return 2; // INT
		if (type == float.class || type == Float.class)
			return 3; // FLOAT
		if (type == double.class || type == Double.class)
			return 3; // FLOAT
		if (type == String.class)
			return 4; // STRING
		return 24; // OBJECT
	}
}
