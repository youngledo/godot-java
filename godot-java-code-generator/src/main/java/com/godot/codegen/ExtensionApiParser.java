package com.godot.codegen;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Parser for extension_api.json from godot-cpp.
 */
public class ExtensionApiParser {

	private final ExtensionApi api;

	public ExtensionApiParser(String jsonPath) throws IOException {
		try (var reader = Files.newBufferedReader(Path.of(jsonPath), StandardCharsets.UTF_8)) {
			this.api = new Gson().fromJson(reader, ExtensionApi.class);
		}
	}

	public ExtensionApi getApi() {
		return api;
	}

	public List<ClassInfo> getClasses() {
		List<ClassInfo> result = new ArrayList<>();
		if (api.classes() != null) {
			for (ClassExtensionInfo extClass : api.classes()) {
				// Convert enums
				List<EnumInfo> enums = new ArrayList<>();
				if (extClass.enums() != null) {
					for (ClassExtensionInfoEnum extEnum : extClass.enums()) {
						List<EnumValue> values = new ArrayList<>();
						if (extEnum.values() != null) {
							for (EnumValueDef ev : extEnum.values()) {
								values.add(new EnumValue(ev.name(), ev.value()));
							}
						}
						enums.add(new EnumInfo(extEnum.name(), extEnum.is_bitfield(), values));
					}
				}

				// Convert methods
				List<MethodInfo> methods = new ArrayList<>();
				if (extClass.methods() != null) {
					for (ClassExtensionInfoMethod extMethod : extClass.methods()) {
						List<ArgInfo> args = new ArrayList<>();
						if (extMethod.arguments() != null) {
							for (ClassExtensionInfoArg arg : extMethod.arguments()) {
								args.add(new ArgInfo(arg.name(), arg.type(), arg.meta()));
							}
						}
						String returnType = extMethod.return_value() != null ? extMethod.return_value().type() : null;
						String returnMeta = extMethod.return_value() != null ? extMethod.return_value().meta() : null;
						methods.add(new MethodInfo(extMethod.name(), extMethod.is_const(), extMethod.is_static(),
								extMethod.is_virtual(), extMethod.is_vararg(), extMethod.hash(), args, returnType,
								returnMeta));
					}
				}

				// Convert properties
				List<PropertyInfo> properties = new ArrayList<>();
				if (extClass.properties() != null) {
					for (ClassExtensionInfoProp extProp : extClass.properties()) {
						properties.add(
								new PropertyInfo(extProp.name(), extProp.type(), extProp.setter(), extProp.getter()));
					}
				}

				// Convert signals
				List<SignalInfo> signals = new ArrayList<>();
				if (extClass.signals() != null) {
					for (ClassExtensionInfoSignal extSig : extClass.signals()) {
						List<ArgInfo> sigArgs = new ArrayList<>();
						if (extSig.arguments() != null) {
							for (ClassExtensionInfoArg arg : extSig.arguments()) {
								sigArgs.add(new ArgInfo(arg.name(), arg.type(), arg.meta()));
							}
						}
						signals.add(new SignalInfo(extSig.name(), sigArgs));
					}
				}

				result.add(new ClassInfo(extClass.name(), extClass.inherits(), extClass.is_refcounted(),
						extClass.is_instantiable(), extClass.api_type(), enums, methods, properties, signals));
			}
		}
		return result;
	}

	public List<String> getSingletons() {
		if (api.singletons() == null)
			return List.of();
		return api.singletons().stream().map(SingletonEntry::name).toList();
	}

	public List<SingletonEntry> getSingletonEntries() {
		if (api.singletons() == null)
			return List.of();
		return api.singletons();
	}

	public Map<String, BuiltinClassInfo> getBuiltinClasses() {
		Map<String, BuiltinClassInfo> result = new HashMap<>();
		if (api.builtin_classes() != null) {
			for (BuiltinClass bc : api.builtin_classes()) {
				List<Operator> operators = bc.operators() != null ? bc.operators() : new ArrayList<>();
				List<Constructor> constructors = bc.constructors() != null ? bc.constructors() : new ArrayList<>();
				result.put(bc.name(), new BuiltinClassInfo(bc.name(), operators, constructors));
			}
		}
		return result;
	}

	// Root JSON structure
	public record ExtensionApi(Header header,
			@SerializedName("builtin_class_sizes") List<BuiltinClassSize> builtin_class_sizes,
			@SerializedName("builtin_classes") List<BuiltinClass> builtin_classes, List<ClassExtensionInfo> classes,
			@SerializedName("utility_functions") List<UtilityFunction> utility_functions,
			List<SingletonEntry> singletons) {
	}

	public record Header(int version_major, int version_minor, int version_patch, String version_status,
			String version_build, String version_full_name) {
	}

	public record SingletonEntry(String name, String type) {
	}

	public record BuiltinClassSize(@SerializedName("build_configuration") String build_configuration,
			@SerializedName("sizes") List<ClassSize> sizes) {
	}

	public record ClassSize(String name, int size) {
	}

	public record BuiltinClass(String name, @SerializedName("is_keyed") boolean is_keyed, List<Operator> operators,
			List<Constructor> constructors, @SerializedName("has_destructor") boolean has_destructor) {
	}

	public record Operator(String name, @SerializedName("right_type") String right_type,
			@SerializedName("return_type") String return_type) {
	}

	public record Constructor(int index, List<ClassExtensionInfoArg> arguments) {
	}

	public record ClassExtensionInfo(String name, @SerializedName("is_refcounted") boolean is_refcounted,
			@SerializedName("is_instantiable") boolean is_instantiable, String inherits,
			@SerializedName("api_type") String api_type, List<ClassExtensionInfoEnum> enums,
			List<ClassExtensionInfoMethod> methods, List<ClassExtensionInfoProp> properties,
			List<ClassExtensionInfoSignal> signals) {
	}

	public record ClassExtensionInfoEnum(String name, @SerializedName("is_bitfield") boolean is_bitfield,
			List<EnumValueDef> values) {
	}

	public record EnumValueDef(String name, long value) {
	}

	public record ClassExtensionInfoMethod(String name, @SerializedName("is_const") boolean is_const,
			@SerializedName("is_vararg") boolean is_vararg, @SerializedName("is_static") boolean is_static,
			@SerializedName("is_virtual") boolean is_virtual, long hash,
			@SerializedName("hash_compatibility") List<Long> hash_compatibility, List<ClassExtensionInfoArg> arguments,
			@SerializedName("return_value") ReturnValue return_value) {
	}

	public record ReturnValue(String type, String meta) {
	}

	public record ClassExtensionInfoProp(String type, String name, String setter, String getter) {
	}

	public record ClassExtensionInfoSignal(String name, List<ClassExtensionInfoArg> arguments) {
	}

	public record ClassExtensionInfoArg(String name, String type, String meta) {
	}

	public record UtilityFunction(String name, String type, String category) {
	}
}
