package com.godot.codegen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Computes C struct field offsets from gdextension_interface.json type
 * definitions.
 *
 * <p>
 * Applies standard C struct alignment rules on 64-bit platforms:
 * <ul>
 * <li>Each field aligned to its natural alignment boundary</li>
 * <li>Struct size padded to alignment of its most-aligned member</li>
 * <li>Pointers/handles/function-ptrs = 8 bytes, enum = 4 bytes</li>
 * </ul>
 */
public class StructLayoutComputer {

	private final Map<String, GdExtensionInterfaceParser.GdType> typeRegistry;

	public StructLayoutComputer(Map<String, GdExtensionInterfaceParser.GdType> typeRegistry) {
		this.typeRegistry = typeRegistry;
	}

	/**
	 * Compute layout for a struct by name.
	 *
	 * @return StructLayout with size and field offsets
	 */
	public StructLayout compute(String structName) {
		GdExtensionInterfaceParser.GdType type = typeRegistry.get(structName);
		if (type == null || !"struct".equals(type.kind())) {
			throw new IllegalArgumentException("Not a struct: " + structName);
		}
		return computeStruct(type);
	}

	private StructLayout computeStruct(GdExtensionInterfaceParser.GdType structType) {
		Map<String, Long> offsets = new LinkedHashMap<>();
		long currentOffset = 0;
		long maxAlignment = 1;

		for (GdExtensionInterfaceParser.GdMember member : structType.members()) {
			long size = typeSize(member.type());
			long alignment = typeAlignment(member.type());

			// Align current offset
			currentOffset = alignUp(currentOffset, alignment);
			offsets.put(member.name(), currentOffset);
			currentOffset += size;

			if (alignment > maxAlignment) {
				maxAlignment = alignment;
			}
		}

		// Pad struct size to alignment of most-aligned member
		long structSize = alignUp(currentOffset, maxAlignment);
		return new StructLayout(structSize, offsets);
	}

	/**
	 * Resolve the byte size of a type name.
	 */
	public long typeSize(String typeName) {
		// Strip const prefix
		String resolved = typeName.replace("const ", "").trim();
		// Pointer types (end with *)
		if (resolved.endsWith("*")) {
			return 8;
		}
		// Primitive types
		switch (resolved) {
			case "uint8_t" :
			case "int8_t" :
			case "char" :
				return 1;
			case "uint16_t" :
			case "int16_t" :
			case "char16_t" :
				return 2;
			case "uint32_t" :
			case "int32_t" :
			case "float" :
			case "char32_t" :
				return 4;
			case "uint64_t" :
			case "int64_t" :
			case "size_t" :
			case "double" :
				return 8;
			case "bool" :
				return 1;
			default :
				break;
		}
		// Look up in type registry
		GdExtensionInterfaceParser.GdType type = typeRegistry.get(resolved);
		if (type == null) {
			throw new IllegalArgumentException("Unknown type: " + typeName + " (resolved: " + resolved + ")");
		}
		switch (type.kind()) {
			case "alias" :
				return typeSize(type.type());
			case "handle" :
				return 8; // opaque pointer
			case "enum" :
				return 4; // C enum = int
			case "function" :
				return 8; // function pointer
			case "struct" :
				return computeStruct(type).size;
			default :
				throw new IllegalArgumentException("Unknown kind: " + type.kind() + " for type " + resolved);
		}
	}

	/**
	 * Resolve the alignment requirement of a type name.
	 */
	public long typeAlignment(String typeName) {
		// Strip const prefix
		String resolved = typeName.replace("const ", "").trim();
		// Pointer types
		if (resolved.endsWith("*")) {
			return 8;
		}
		// Primitive alignments
		switch (resolved) {
			case "uint8_t" :
			case "int8_t" :
			case "char" :
			case "bool" :
				return 1;
			case "uint16_t" :
			case "int16_t" :
			case "char16_t" :
				return 2;
			case "uint32_t" :
			case "int32_t" :
			case "float" :
			case "char32_t" :
				return 4;
			case "uint64_t" :
			case "int64_t" :
			case "size_t" :
			case "double" :
				return 8;
			default :
				break;
		}
		// Look up in type registry
		GdExtensionInterfaceParser.GdType type = typeRegistry.get(resolved);
		if (type == null) {
			throw new IllegalArgumentException("Unknown type: " + typeName);
		}
		switch (type.kind()) {
			case "alias" :
				return typeAlignment(type.type());
			case "handle" :
				return 8;
			case "enum" :
				return 4;
			case "function" :
				return 8;
			case "struct" : {
				long maxAlign = 1;
				for (GdExtensionInterfaceParser.GdMember m : type.members()) {
					long a = typeAlignment(m.type());
					if (a > maxAlign)
						maxAlign = a;
				}
				return maxAlign;
			}
			default :
				return 8; // safe default
		}
	}

	private static long alignUp(long offset, long alignment) {
		return (offset + alignment - 1) & ~(alignment - 1);
	}

	/**
	 * Result of struct layout computation.
	 */
	public record StructLayout(long size, Map<String, Long> fieldOffsets) {
		public long getOffset(String fieldName) {
			return fieldOffsets.getOrDefault(fieldName, -1L);
		}
	}
}
