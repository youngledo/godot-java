package com.godot.codegen;

import java.io.IOException;
import java.util.List;

/**
 * Generates {@code ApiSignatures.java} from gdextension_interface.json's
 * interface[] array using PanamaTypeMapper for type resolution.
 */
public class ApiSignaturesGenerator {

	public static void generate(List<GdExtensionInterfaceParser.GdApiFunc> functions, PanamaTypeMapper typeMapper,
			String outputDir, String apiPackage, String bridgePackage) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(bridgePackage).append(";\n\n");
		sb.append("import java.lang.foreign.FunctionDescriptor;\n");
		sb.append("import static java.lang.foreign.ValueLayout.*;\n");
		sb.append("import ").append(apiPackage).append(".ApiIndex;\n\n");
		sb.append("/**\n");
		sb.append(" * Panama FunctionDescriptor for each Godot GDExtension API function.\n");
		sb.append(" * Auto-generated from gdextension_interface.json by the code generator.\n");
		sb.append(" * DO NOT EDIT.\n");
		sb.append(" */\n");
		sb.append("public final class ApiSignatures {\n\n");
		sb.append("\tprivate ApiSignatures() {}\n\n");
		sb.append("\tpublic static FunctionDescriptor get(ApiIndex api) {\n");
		sb.append("\t\tswitch (api) {\n");

		for (GdExtensionInterfaceParser.GdApiFunc func : functions) {
			String enumName = func.name().toUpperCase().replace("-", "_");
			String retLayout = func.return_value() != null
					? typeMapper.mapReturnType(func.return_value().type())
					: null;
			List<GdExtensionInterfaceParser.GdArgument> args = func.arguments() != null ? func.arguments() : List.of();

			sb.append("\t\t\tcase ").append(enumName).append(" :\n");
			sb.append("\t\t\t\treturn ");

			if (retLayout == null) {
				// void return
				sb.append("FunctionDescriptor.ofVoid(");
			} else {
				sb.append("FunctionDescriptor.of(").append(retLayout);
				if (!args.isEmpty()) {
					sb.append(", ");
				}
			}

			for (int i = 0; i < args.size(); i++) {
				String layout = typeMapper.mapType(args.get(i).type());
				sb.append(layout);
				if (i < args.size() - 1) {
					sb.append(", ");
				}
			}

			sb.append(");\n");
		}

		sb.append("\t\t}\n");
		sb.append("\t\tthrow new IllegalStateException(\"Unknown API: \" + api);\n");
		sb.append("\t}\n");
		sb.append("}\n");

		ApiIndexGenerator.writeFile(outputDir, bridgePackage, "ApiSignatures.java", sb.toString());
		System.out.println("Generated: ApiSignatures.java (" + functions.size() + " signatures)");
	}
}
