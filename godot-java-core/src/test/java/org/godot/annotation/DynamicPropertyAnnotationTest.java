package org.godot.annotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DynamicPropertyAnnotationTest {

	@Test
	void getPropertyAnnotationExists() {
		assertNotNull(GetProperty.class);
		assertTrue(GetProperty.class.isAnnotationPresent(java.lang.annotation.Retention.class));
	}

	@Test
	void setPropertyAnnotationExists() {
		assertNotNull(SetProperty.class);
		assertTrue(SetProperty.class.isAnnotationPresent(java.lang.annotation.Retention.class));
	}

	@Test
	void getPropertyListAnnotationExists() {
		assertNotNull(GetPropertyList.class);
		assertTrue(GetPropertyList.class.isAnnotationPresent(java.lang.annotation.Retention.class));
	}
}
