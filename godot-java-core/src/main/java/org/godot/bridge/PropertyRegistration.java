package org.godot.bridge;

import org.godot.annotation.Export;
import org.godot.annotation.PropertyHint;
import org.godot.core.GodotString;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;
import org.godot.internal.api.StructOffsets;
import org.godot.internal.api.VariantType;
import java.lang.foreign.MemorySegment;
import java.lang.reflect.Field;
import static java.lang.foreign.ValueLayout.*;

/**
 * Handles registration of @Export annotated fields as Godot properties.
 *
 * <p>
 * GDExtensionPropertyInfo layout (48 bytes on 64-bit):
 * <ul>
 * <li>offset 0: type (int32_t) — VariantType enum</li>
 * <li>offset 8: name (StringName*)</li>
 * <li>offset 16: class_name (StringName*)</li>
 * <li>offset 24: hint (uint32_t)</li>
 * <li>offset 32: hint_string (StringPtr*)</li>
 * <li>offset 40: usage (uint32_t)</li>
 * </ul>
 *
 * <p>
 * classdb_register_extension_class_property(library, className, propertyInfo*)
 */
public final class PropertyRegistration {

	private PropertyRegistration() {
	}

	// PROPERTY_USAGE_DEFAULT = 1, PROPERTY_USAGE_EDITOR = 4, PROPERTY_USAGE_STORAGE
	// = 8
	private static final int PROPERTY_USAGE_DEFAULT = 1 | 4 | 8;

	// Shared empty strings — Godot dereferences ALL string pointers unconditionally
	private static final GodotStringName EMPTY_SN = GodotStringName.fromJavaString("");
	private static final GodotString EMPTY_STR = GodotString.fromJavaString("");

	/**
	 * Register all @Export annotated fields of a class.
	 *
	 * <p>
	 * Note: Property data (type, hint, hintString, usage) is now provided to Godot
	 * via {@code get_property_list_func} in InstanceCallbacks, which exposes them
	 * to the Inspector. The ClassDB registration path is intentionally disabled
	 * because using both paths simultaneously causes duplicate properties and
	 * crashes the editor during DocTools::generate().
	 */
	public static int registerProperties(String className) {
		Class<?> clazz = InstanceCallbacks.getJavaClass(className);
		if (clazz == null)
			return 0;

		int count = 0;
		for (Field field : clazz.getDeclaredFields()) {
			if (!field.isAnnotationPresent(Export.class))
				continue;
			count++;
		}
		return count;
	}

	private static void registerProperty(String godotClassName, Field field) {
		Export export = field.getAnnotation(Export.class);
		String propName = export.propertyName().isEmpty() ? field.getName() : export.propertyName();

		// Build PropertyInfo struct
		MemorySegment propertyInfo = buildPropertyInfo(propName, field, export);

		// Register: classdb_register_extension_class_property(library, className,
		// propertyInfo*, setter_name, getter_name)
		GodotStringName classSn = GodotStringName.fromJavaString(godotClassName);

		Bridge.callVoid(ApiIndex.CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY,
				MemorySegment.ofAddress(Bridge.libraryPtr()), classSn.segment(), propertyInfo, EMPTY_SN.segment(),
				EMPTY_SN.segment());
	}

	private static MemorySegment buildPropertyInfo(String propName, Field field, Export export) {
		VariantType type = javaTypeToVariantType(field.getType());

		MemorySegment info = Bridge.allocate(StructOffsets.PROPERTY_INFO_SIZE);

		// type (uint32_t)
		info.set(JAVA_INT, StructOffsets.PROPERTY_INFO_OFF_TYPE, type.id());
		// name (StringName*) — Godot dereferences unconditionally
		GodotStringName nameSn = GodotStringName.fromJavaString(propName);
		info.set(ADDRESS, StructOffsets.PROPERTY_INFO_OFF_NAME, MemorySegment.ofAddress(nameSn.segment().address()));
		// class_name (StringName*) — MUST be valid pointer
		info.set(ADDRESS, StructOffsets.PROPERTY_INFO_OFF_CLASS_NAME,
				MemorySegment.ofAddress(EMPTY_SN.segment().address()));
		// hint (uint32_t)
		PropertyHint hint = export.hint();
		info.set(JAVA_INT, StructOffsets.PROPERTY_INFO_OFF_HINT, hint.id());
		// hint_string (String*) — MUST be valid pointer
		String hintStr = export.hintString();
		GodotString hintString = hintStr.isEmpty() ? EMPTY_STR : GodotString.fromJavaString(hintStr);
		info.set(ADDRESS, StructOffsets.PROPERTY_INFO_OFF_HINT_STRING,
				MemorySegment.ofAddress(hintString.segment().address()));
		// usage (uint32_t)
		info.set(JAVA_INT, StructOffsets.PROPERTY_INFO_OFF_USAGE, PROPERTY_USAGE_DEFAULT);

		return info;
	}

	static VariantType javaTypeToVariantType(Class<?> type) {
		if (type == boolean.class || type == Boolean.class)
			return VariantType.BOOL;
		if (type == byte.class || type == Byte.class)
			return VariantType.INT;
		if (type == short.class || type == Short.class)
			return VariantType.INT;
		if (type == int.class || type == Integer.class)
			return VariantType.INT;
		if (type == long.class || type == Long.class)
			return VariantType.INT;
		if (type == float.class || type == Float.class)
			return VariantType.FLOAT;
		if (type == double.class || type == Double.class)
			return VariantType.FLOAT;
		if (type == String.class)
			return VariantType.STRING;
		if (type == org.godot.math.Vector2.class)
			return VariantType.VECTOR2;
		if (type == org.godot.math.Vector3.class)
			return VariantType.VECTOR3;
		if (type == org.godot.math.Vector2i.class)
			return VariantType.VECTOR2I;
		if (type == org.godot.math.Vector3i.class)
			return VariantType.VECTOR3I;
		// Default to OBJECT for Godot types
		return VariantType.OBJECT;
	}
}
