package org.godot.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.godot.exception.GodotApiException;
import org.godot.internal.api.ApiIndex;
import org.junit.jupiter.api.Test;

class BridgeCompatibilityTest {

	@Test
	void reportsTheMinimumVersionWhenAnOptionalApiIsUnavailable() {
		GodotApiException exception = Bridge.missingApiException(ApiIndex.VARIANT_GET_TYPE_BY_NAME);

		assertEquals("VARIANT_GET_TYPE_BY_NAME", exception.getApiName());
		assertEquals("VARIANT_GET_TYPE_BY_NAME: Requires Godot 4.7+; function not provided by the current engine",
				exception.getMessage());
	}
}
