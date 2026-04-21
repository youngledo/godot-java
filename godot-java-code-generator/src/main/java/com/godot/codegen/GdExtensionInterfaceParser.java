package com.godot.codegen;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Parser for gdextension_interface.json from godot-cpp.
 *
 * <p>
 * Extracts:
 * <ul>
 * <li>{@code types[]} — 145 type definitions (enum, struct, handle, alias,
 * function)</li>
 * <li>{@code interface[]} — 176 API function entries with name, arguments, and
 * return type</li>
 * </ul>
 */
public class GdExtensionInterfaceParser {

	private final GdInterfaceData data;
	private final Map<String, GdType> typeRegistry;

	public GdExtensionInterfaceParser(String jsonPath) throws IOException {
		try (var reader = Files.newBufferedReader(Path.of(jsonPath), StandardCharsets.UTF_8)) {
			this.data = new Gson().fromJson(reader, GdInterfaceData.class);
		}
		this.typeRegistry = new HashMap<>();
		if (data.types() != null) {
			for (GdType type : data.types()) {
				typeRegistry.put(type.name(), type);
			}
		}
	}

	public GdInterfaceData getData() {
		return data;
	}

	public Map<String, GdType> getTypeRegistry() {
		return typeRegistry;
	}

	public List<GdApiFunc> getApiFunctions() {
		return data != null ? data.apiFunctions() : List.of();
	}

	public List<GdType> getTypes() {
		return data != null ? data.types() : List.of();
	}

	// ------------------------------------------------------------------------
	// JSON data model — mirrors gdextension_interface.json structure
	// ------------------------------------------------------------------------

	public record GdInterfaceData(List<GdType> types, @SerializedName("interface") List<GdApiFunc> apiFunctions) {
	}

	public record GdType(String name, String kind,
			// enum
			List<GdEnumValue> values,
			// struct
			List<GdMember> members,
			// alias
			String type,
			// function
			GdReturnValue return_value, List<GdArgument> arguments,
			// meta (for argument metadata)
			String meta) {
	}

	public record GdEnumValue(String name, long value) {
	}

	public record GdMember(String name, String type) {
	}

	public record GdReturnValue(String type, List<String> description) {
	}

	public record GdArgument(String name, String type, List<String> description) {
	}

	public record GdApiFunc(String name, GdReturnValue return_value, List<GdArgument> arguments,
			List<String> description, String since) {
	}
}
