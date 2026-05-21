package org.godot.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/// Tests for ConnectHandle constants, Signal constructor/getters.
class CoreMiscTest {

	// --- ConnectHandle constants ---

	@Test
	void connectHandle_constants() {
		assertEquals(1, ConnectHandle.CONNECT_DEFERRED);
		assertEquals(2, ConnectHandle.CONNECT_PERSIST);
		assertEquals(4, ConnectHandle.CONNECT_ONE_SHOT);
		assertEquals(8, ConnectHandle.CONNECT_REFERENCE_COUNTED);
	}

	@Test
	void connectHandle_getCallable() {
		Callable callable = new Callable(null, "testMethod");
		ConnectHandle handle = new ConnectHandle(null, "pressed", callable);
		assertEquals(callable, handle.getCallable());
	}

	// --- Signal constructor and getters ---

	@Test
	void signal_constructorAndGetters() {
		Signal signal = new Signal(null, "pressed");
		assertEquals("pressed", signal.getName());
		assertNull(signal.getObject());
	}
}
