package org.godot.internal.dispatch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/// Tests for APT dispatch metadata records.
class DispatchRecordTest {

	// --- CollectionTypeMeta ---

	@Test
	void arrayFactory_createsArrayMeta() {
		CollectionTypeMeta meta = CollectionTypeMeta.array("int", "Integer");
		assertEquals("Array", meta.containerType());
		assertEquals("int", meta.elementType());
		assertEquals("Integer", meta.elementClassName());
		assertTrue(meta.isArray());
		assertFalse(meta.isDictionary());
	}

	@Test
	void dictionaryFactory_createsDictionaryMeta() {
		CollectionTypeMeta meta = CollectionTypeMeta.dictionary("String", "int", "String", "Integer");
		assertEquals("Dictionary", meta.containerType());
		assertEquals("String", meta.keyType());
		assertEquals("int", meta.valueType());
		assertFalse(meta.isArray());
		assertTrue(meta.isDictionary());
	}

	@Test
	void arrayHintString_withClassName() {
		CollectionTypeMeta meta = CollectionTypeMeta.array("Resource", "MyResource");
		assertEquals("Resource:MyResource", meta.arrayHintString());
	}

	@Test
	void arrayHintString_withoutClassName() {
		CollectionTypeMeta meta = CollectionTypeMeta.array("int", "");
		assertEquals("int", meta.arrayHintString());
	}

	@Test
	void arrayHintString_nullElementType_returnsEmpty() {
		CollectionTypeMeta meta = CollectionTypeMeta.array(null, "");
		assertEquals("", meta.arrayHintString());
	}

	@Test
	void arrayHintString_dictionaryMeta_returnsEmpty() {
		CollectionTypeMeta meta = CollectionTypeMeta.dictionary("String", "int", "", "");
		assertEquals("", meta.arrayHintString());
	}

	// --- MethodMeta ---

	@Test
	void methodMeta_recordAccessors() {
		MethodMeta meta = new MethodMeta("doStuff", "_do_stuff", "void", new String[]{"int", "String"},
				new String[]{"count", "name"});
		assertEquals("doStuff", meta.javaName());
		assertEquals("_do_stuff", meta.godotName());
		assertEquals("void", meta.returnType());
		assertArrayEquals(new String[]{"int", "String"}, meta.paramTypes());
		assertArrayEquals(new String[]{"count", "name"}, meta.paramNames());
	}

	// --- SignalMeta ---

	@Test
	void signalMeta_recordAccessors() {
		SignalMeta meta = new SignalMeta("healthChanged", new String[]{"int"}, new String[]{"newHealth"});
		assertEquals("healthChanged", meta.name());
		assertArrayEquals(new String[]{"int"}, meta.paramTypes());
		assertArrayEquals(new String[]{"newHealth"}, meta.paramNames());
	}

	@Test
	void signalMeta_noParams() {
		SignalMeta meta = new SignalMeta("ready", new String[]{}, new String[]{});
		assertEquals("ready", meta.name());
		assertEquals(0, meta.paramTypes().length);
	}

	// --- PropertyMeta ---

	@Test
	void propertyMeta_5argConstructor_defaultsUsage() {
		PropertyMeta meta = new PropertyMeta("health", "health", "int", 1, "0,100,1");
		assertEquals("health", meta.javaName());
		assertEquals("health", meta.godotName());
		assertEquals("int", meta.typeName());
		assertEquals(1, meta.hintId());
		assertEquals("0,100,1", meta.hintString());
		assertEquals(1 | 2 | 4 | 8, meta.usage());
		assertFalse(meta.readOnly());
		assertNull(meta.collectionType());
	}

	@Test
	void propertyMeta_10argConstructor_withGroups() {
		PropertyMeta meta = new PropertyMeta("speed", "speed", "float", 0, "", 7, "Movement", "", "Fast", "");
		assertEquals("Movement", meta.group());
		assertEquals("Fast", meta.subgroup());
		assertEquals(7, meta.usage());
	}

	@Test
	void propertyMeta_13argConstructor_withGetterSetter() {
		PropertyMeta meta = new PropertyMeta("name", "name", "String", 0, "", 15, "getName", "setName", false, "Info",
				"", "", "");
		assertEquals("getName", meta.getter());
		assertEquals("setName", meta.setter());
		assertFalse(meta.readOnly());
	}
}
