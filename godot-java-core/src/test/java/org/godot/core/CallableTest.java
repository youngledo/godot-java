package org.godot.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/// Tests for [Callable] Java-mode constructors, getters, and isValid.
class CallableTest {

	@Test
	void constructor_twoArg_storesObjectAndMethod() {
		Callable c = new Callable(null, "doStuff");
		assertNull(c.getObject());
		assertEquals("doStuff", c.getMethod());
	}

	@Test
	void constructor_threeArg_storesBoundArgs() {
		Callable c = new Callable(null, "compute", 42, "hello");
		assertNull(c.getObject());
		assertEquals("compute", c.getMethod());
		assertArrayEquals(new Object[]{42, "hello"}, c.getBoundArgs());
	}

	@Test
	void constructor_threeArg_emptyArray_noBoundArgs() {
		Callable c = new Callable(null, "run", (Object[]) null);
		assertNull(c.getBoundArgs());
	}

	@Test
	void isValid_nullObject_returnsFalse() {
		Callable c = new Callable(null, "method");
		assertFalse(c.isValid());
	}

	@Test
	void nativeSegment_noNative_returnsNull() {
		Callable c = new Callable(null, "method");
		assertNull(c.nativeSegment());
	}
}
