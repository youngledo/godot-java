package com.godot.codegen;

import java.io.IOException;
import java.util.List;

/**
 * Generates {@code VariantType.java} from gdextension_interface.json's
 * GDExtensionVariantType enum definition.
 */
public class VariantTypeGenerator {

	public static void generate(List<GdExtensionInterfaceParser.GdType> types, String outputDir, String packageName)
			throws IOException {
		// Find GDExtensionVariantType enum
		GdExtensionInterfaceParser.GdType variantEnum = null;
		for (GdExtensionInterfaceParser.GdType type : types) {
			if ("GDExtensionVariantType".equals(type.name()) && "enum".equals(type.kind())) {
				variantEnum = type;
				break;
			}
		}
		if (variantEnum == null || variantEnum.values() == null) {
			System.err.println("Warning: GDExtensionVariantType not found in JSON");
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(packageName).append(";\n\n");
		sb.append("/**\n");
		sb.append(" * Godot Variant type constants. Auto-generated from\n");
		sb.append(" * gdextension_interface.json (GDExtensionVariantType enum).\n");
		sb.append(" * DO NOT EDIT.\n");
		sb.append(" */\n");
		sb.append("public enum VariantType {\n\n");

		List<GdExtensionInterfaceParser.GdEnumValue> values = variantEnum.values();
		for (int i = 0; i < values.size(); i++) {
			GdExtensionInterfaceParser.GdEnumValue val = values.get(i);
			// Strip GDEXTENSION_VARIANT_TYPE_ prefix
			String shortName = val.name().replace("GDEXTENSION_VARIANT_TYPE_", "");
			sb.append("\t").append(shortName).append("(").append(val.value()).append(")");
			if (i < values.size() - 1) {
				sb.append(",");
			}
			sb.append("\n");
		}

		sb.append(";\n\n");
		sb.append("\tprivate final int id;\n\n");
		sb.append("\tVariantType(int id) {\n");
		sb.append("\t\tthis.id = id;\n");
		sb.append("\t}\n\n");
		sb.append("\tpublic int id() {\n");
		sb.append("\t\treturn id;\n");
		sb.append("\t}\n\n");
		sb.append("\tpublic static VariantType fromId(int id) {\n");
		sb.append("\t\tfor (VariantType vt : values()) {\n");
		sb.append("\t\t\tif (vt.id == id)\n");
		sb.append("\t\t\t\treturn vt;\n");
		sb.append("\t\t}\n");
		sb.append("\t\tthrow new IllegalArgumentException(\"Unknown VariantType id: \" + id);\n");
		sb.append("\t}\n");
		sb.append("}\n");

		ApiIndexGenerator.writeFile(outputDir, packageName, "VariantType.java", sb.toString());
		System.out.println("Generated: VariantType.java (" + values.size() + " types)");
	}
}
