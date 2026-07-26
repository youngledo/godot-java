package com.godot.codegen;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApiIndexGeneratorTest {

	@Test
	void marksFunctionsIntroducedAfterThe46BaselineAsOptional() throws Exception {
		Path outputDir = Files.createTempDirectory("api-index-generator-test");
		var baselineFunction = new GdExtensionInterfaceParser.GdApiFunc("variant_get_type", null, List.of(), List.of(),
				null);
		var newFunction = new GdExtensionInterfaceParser.GdApiFunc("variant_get_type_by_name", null, List.of(),
				List.of(), "4.7");

		ApiIndexGenerator.generate(List.of(baselineFunction, newFunction), outputDir.toString(), "test.api");

		String source = Files.readString(outputDir.resolve("test/api/ApiIndex.java"));
		assertTrue(source.contains("VARIANT_GET_TYPE(0, null, true)"), source);
		assertTrue(source.contains("VARIANT_GET_TYPE_BY_NAME(1, \"4.7\", false)"), source);
		assertTrue(source.contains("public String since()"), source);
		assertTrue(source.contains("public boolean isRequiredAtBoot()"), source);
	}
}
