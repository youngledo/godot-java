package com.godot.codegen;

import java.util.List;

/**
 * Extracted class information for code generation.
 *
 * @param name
 *            class name (e.g. "Node")
 * @param inherits
 *            parent class name, may include namespace prefix (e.g.
 *            "Classes::Node")
 * @param isRefcounted
 *            whether this class extends RefCounted
 * @param isInstantiable
 *            whether this class can be instantiated
 * @param apiType
 *            API type string from extension_api.json
 * @param enums
 *            enum declarations
 * @param methods
 *            method declarations
 * @param properties
 *            property declarations
 * @param signals
 *            signal declarations
 */
public record ClassInfo(String name, String inherits, boolean isRefcounted, boolean isInstantiable, String apiType,
		List<EnumInfo> enums, List<MethodInfo> methods, List<PropertyInfo> properties, List<SignalInfo> signals) {

	public boolean isBuiltin() {
		return false;
	}

	public String getParentClass() {
		return inherits;
	}

	public String getSimpleParentClass() {
		if (inherits == null || inherits.isEmpty()) {
			return null;
		}
		int idx = inherits.indexOf("::");
		return idx > 0 ? inherits.substring(idx + 2) : inherits;
	}
}

/**
 * Extracted builtin class information.
 *
 * @param name
 *            builtin type name (e.g. "Vector2")
 * @param operators
 *            operator declarations
 * @param constructors
 *            constructor declarations
 */
record BuiltinClassInfo(String name, List<ExtensionApiParser.Operator> operators,
		List<ExtensionApiParser.Constructor> constructors) {

	public boolean isBuiltin() {
		return true;
	}
}

/**
 * Extracted enum information.
 *
 * @param name
 *            enum name (e.g. "ProcessMode")
 * @param isBitfield
 *            whether this enum is a bitfield
 * @param values
 *            enum values
 */
record EnumInfo(String name, boolean isBitfield, List<EnumValue> values) {
}

/**
 * A single enum value.
 *
 * @param name
 *            value name (e.g. "PROCESS_MODE_INHERIT")
 * @param value
 *            numeric value
 */
record EnumValue(String name, long value) {
}

/**
 * Extracted method information.
 *
 * @param name
 *            Godot method name (e.g. "get_child_count")
 * @param isConst
 *            whether the method is const
 * @param isStatic
 *            whether the method is static
 * @param isVirtual
 *            whether the method is virtual
 * @param isVararg
 *            whether the method accepts variable arguments
 * @param hash
 *            method hash for binding lookup
 * @param arguments
 *            method parameters
 * @param returnType
 *            return type string from Godot API, or null for void
 * @param returnMeta
 *            return type meta (e.g. "int32"), or null
 */
record MethodInfo(String name, boolean isConst, boolean isStatic, boolean isVirtual, boolean isVararg, long hash,
		List<ArgInfo> arguments, String returnType, String returnMeta) {
}

/**
 * Extracted argument information.
 *
 * @param name
 *            argument name
 * @param type
 *            Godot type string
 * @param meta
 *            type meta (e.g. "int32"), or null
 */
record ArgInfo(String name, String type, String meta) {
}

/**
 * Extracted property information.
 *
 * @param name
 *            property name
 * @param type
 *            Godot type string
 * @param setter
 *            setter method name, or null
 * @param getter
 *            getter method name, or null
 */
record PropertyInfo(String name, String type, String setter, String getter) {
}

/**
 * Extracted signal information.
 *
 * @param name
 *            signal name
 * @param arguments
 *            signal parameters
 */
record SignalInfo(String name, List<ArgInfo> arguments) {
}
