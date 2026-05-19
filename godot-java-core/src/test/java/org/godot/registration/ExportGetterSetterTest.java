package org.godot.registration;

import org.godot.annotation.Export;
import org.godot.annotation.PropertyUsage;
import org.godot.internal.dispatch.PropertyMeta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExportGetterSetterTest {

	@Test
	void exportAnnotationHasGetterSetterReadOnly() throws NoSuchMethodException {
		var method = Export.class.getDeclaredMethod("getter");
		assertNotNull(method);
		assertEquals("", Export.class.getDeclaredMethod("getter").getDefaultValue());
		assertEquals("", Export.class.getDeclaredMethod("setter").getDefaultValue());
		assertEquals(false, Export.class.getDeclaredMethod("readOnly").getDefaultValue());
	}

	@Test
	void propertyUsageHasReadOnly() {
		assertEquals(4096, PropertyUsage.READ_ONLY_INTERNAL.value);
		assertEquals(2 | 4 | 4096, PropertyUsage.EDITOR_READ_ONLY.value);
	}

	@Test
	void propertyMetaIncludesGetterSetter() {
		PropertyMeta meta = new PropertyMeta("speed", "speed", "float", 0, "", 1 | 2 | 4 | 8, "getSpeed", "setSpeed",
				true, "", "", "", "");
		assertEquals("getSpeed", meta.getter());
		assertEquals("setSpeed", meta.setter());
		assertTrue(meta.readOnly());
	}

	@Test
	void propertyMetaBackwardCompatible() {
		PropertyMeta meta = new PropertyMeta("speed", "speed", "float", 0, "");
		assertEquals("", meta.getter());
		assertEquals("", meta.setter());
		assertFalse(meta.readOnly());
	}
}
