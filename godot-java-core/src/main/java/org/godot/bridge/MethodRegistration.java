package org.godot.bridge;

import org.godot.annotation.GodotMethod;
import org.godot.core.GodotString;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.StructOffsets;
import java.lang.foreign.MemorySegment;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import static java.lang.foreign.ValueLayout.*;

/**
 * Handles registration of @GodotMethod annotated methods.
 *
 * <p>
 * Creates GDExtensionClassMethodInfo structs with upcall stubs that route Godot
 * method calls back to the correct Java methods.
 *
 * <p>
 * GDExtensionClassMethodInfo layout (88 bytes on 64-bit, from Godot 4.6):
 * <ul>
 * <li>offset 0: name (StringName*)</li>
 * <li>offset 8: method_userdata (void*)</li>
 * <li>offset 16: call_func (function pointer)</li>
 * <li>offset 24: ptrcall_func (NULL for variant-based)</li>
 * <li>offset 32: method_flags (uint32_t)</li>
 * <li>offset 36: has_return_value (GDExtensionBool, uint8_t)</li>
 * <li>offset 40: return_value_info (GDExtensionPropertyInfo*)</li>
 * <li>offset 48: return_value_metadata (int32_t)</li>
 * <li>offset 52: argument_count (uint32_t)</li>
 * <li>offset 56: arguments_info (GDExtensionPropertyInfo*)</li>
 * <li>offset 64: arguments_metadata (int32_t*)</li>
 * <li>offset 72: default_argument_count (uint32_t)</li>
 * <li>offset 80: default_arguments (VariantPtr*)</li>
 * </ul>
 *
 * <p>
 * GDExtensionPropertyInfo layout (48 bytes):
 * <ul>
 * <li>offset 0: type (uint32_t, Variant type)</li>
 * <li>offset 8: name (StringName*)</li>
 * <li>offset 16: class_name (StringName*)</li>
 * <li>offset 24: hint (uint32_t)</li>
 * <li>offset 32: hint_string (String*)</li>
 * <li>offset 40: usage (uint32_t)</li>
 * </ul>
 */
public final class MethodRegistration {

	private MethodRegistration() {
	}

	private static final int METHOD_FLAG_NORMAL = 1;

	// Shared empty StringName/String — Godot's PropertyInfo constructor
	// dereferences
	// ALL string pointers unconditionally, so NULL causes SIGSEGV.
	private static final GodotStringName EMPTY_SN = GodotStringName.fromJavaString("");
	private static final GodotString EMPTY_STR = GodotString.fromJavaString("");

	/**
	 * Register all @GodotMethod annotated methods of a class.
	 */
	public static int registerMethods(String className) {
		Class<?> clazz = InstanceCallbacks.getJavaClass(className);
		if (clazz == null)
			return 0;

		int count = 0;
		for (Method method : clazz.getDeclaredMethods()) {
			if (!method.isAnnotationPresent(GodotMethod.class))
				continue;
			registerMethod(className, method);
			count++;
		}
		return count;
	}

	private static void registerMethod(String godotClassName, Method method) {
		String methodName = method.getName();
		GodotMethod ann = method.getAnnotation(GodotMethod.class);
		if (ann != null && !ann.value().isEmpty()) {
			methodName = ann.value();
		}
		GodotStringName methodSn = GodotStringName.fromJavaString(methodName);
		GodotStringName classSn = GodotStringName.fromJavaString(godotClassName);

		MemorySegment methodInfo = buildMethodInfo(methodSn, method, godotClassName);

		Bridge.callVoid(ApiIndex.CLASSDB_REGISTER_EXTENSION_CLASS_METHOD, MemorySegment.ofAddress(Bridge.libraryPtr()),
				classSn.segment(), methodInfo);
	}

	private static MemorySegment buildMethodInfo(GodotStringName methodSn, Method method, String godotClassName) {
		int argc = method.getParameterCount();
		boolean hasReturn = method.getReturnType() != void.class;

		MemorySegment info = Bridge.allocate(StructOffsets.METHOD_INFO_SIZE);

		// name (StringName*)
		info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_NAME, MemorySegment.ofAddress(methodSn.segment().address()));
		// method_userdata — unique key for MethodDispatch lookup
		long methodKey = MethodDispatch.registerMethod(method, godotClassName);
		info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_METHOD_USERDATA, MemorySegment.ofAddress(methodKey));
		// call_func upcall stub
		info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_CALL_FUNC,
				MemorySegment.ofAddress(MethodDispatch.getCallStub().address()));
		// ptrcall_func — typed zero-copy dispatch
		info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_PTRCALL_FUNC,
				MemorySegment.ofAddress(MethodDispatch.getPtrcallStub().address()));
		// method_flags (uint32_t)
		info.set(JAVA_INT, StructOffsets.METHOD_INFO_OFF_METHOD_FLAGS, METHOD_FLAG_NORMAL);
		// has_return_value (GDExtensionBool = uint8_t)
		info.set(JAVA_BYTE, StructOffsets.METHOD_INFO_OFF_HAS_RETURN_VALUE, (byte) (hasReturn ? 1 : 0));

		// return_value_info — ALWAYS valid (godot-cpp never sets this to NULL)
		int retType = hasReturn ? javaTypeToVariantType(method.getReturnType()) : 0; // NIL for void
		MemorySegment retInfo = buildPropertyInfo(retType, null);
		info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_RETURN_VALUE_INFO, retInfo);
		// return_value_metadata
		info.set(JAVA_INT, StructOffsets.METHOD_INFO_OFF_RETURN_VALUE_METADATA,
				hasReturn ? javaTypeToMetadata(method.getReturnType()) : 0);

		// argument_count (uint32_t)
		info.set(JAVA_INT, StructOffsets.METHOD_INFO_OFF_ARGUMENT_COUNT, argc);

		// arguments_info — MUST be valid when argument_count > 0
		// arguments_metadata — MUST be valid when argument_count > 0
		if (argc > 0) {
			MemorySegment argsInfo = Bridge.allocate((long) argc * StructOffsets.PROPERTY_INFO_SIZE);
			MemorySegment argsMeta = Bridge.allocate((long) argc * 4L);

			Parameter[] params = method.getParameters();
			Class<?>[] paramTypes = method.getParameterTypes();
			for (int i = 0; i < argc; i++) {
				long off = (long) i * StructOffsets.PROPERTY_INFO_SIZE;
				GodotStringName paramNameSn = GodotStringName.fromJavaString(params[i].getName());
				fillPropertyInfo(argsInfo, off, javaTypeToVariantType(paramTypes[i]), paramNameSn);
				argsMeta.set(JAVA_INT, (long) i * 4L, javaTypeToMetadata(paramTypes[i]));
			}

			info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_ARGUMENTS_INFO, argsInfo);
			info.set(ADDRESS, StructOffsets.METHOD_INFO_OFF_ARGUMENTS_METADATA, argsMeta);
		}

		// default_argument_count = 0
		// default_arguments = NULL

		return info;
	}

	/**
	 * Allocate and fill a single GDExtensionPropertyInfo (48 bytes).
	 */
	private static MemorySegment buildPropertyInfo(int variantType, GodotStringName name) {
		MemorySegment pi = Bridge.allocate(StructOffsets.PROPERTY_INFO_SIZE);
		fillPropertyInfo(pi, 0, variantType, name);
		return pi;
	}

	private static void fillPropertyInfo(MemorySegment base, long offset, int variantType, GodotStringName name) {
		// type (uint32_t)
		base.set(JAVA_INT, offset + StructOffsets.PROPERTY_INFO_OFF_TYPE, variantType);
		// name (StringName*) — MUST be valid pointer, Godot dereferences
		// unconditionally
		GodotStringName nameSn = (name != null) ? name : EMPTY_SN;
		base.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_NAME,
				MemorySegment.ofAddress(nameSn.segment().address()));
		// class_name (StringName*) — MUST be valid pointer
		base.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_CLASS_NAME,
				MemorySegment.ofAddress(EMPTY_SN.segment().address()));
		// hint (uint32_t) = 0 (already zeroed)
		// hint_string (String*) — MUST be valid pointer
		base.set(ADDRESS, offset + StructOffsets.PROPERTY_INFO_OFF_HINT_STRING,
				MemorySegment.ofAddress(EMPTY_STR.segment().address()));
		// usage (uint32_t) = 0 (already zeroed)
	}

	private static int javaTypeToVariantType(Class<?> type) {
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
		return 0; // NIL for void/others
	}

	/**
	 * Map Java types to GDExtensionClassMethodArgumentMetadata. NONE=0,
	 * INT_IS_INT32=3, INT_IS_INT64=4, DOUBLE_IS_FLOAT=9
	 */
	private static int javaTypeToMetadata(Class<?> type) {
		if (type == int.class || type == Integer.class)
			return 3; // INT_IS_INT32
		if (type == long.class || type == Long.class)
			return 4; // INT_IS_INT64
		if (type == float.class || type == Float.class)
			return 9; // DOUBLE_IS_FLOAT
		return 0; // NONE
	}
}
