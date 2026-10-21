package org.godot.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.foreign.Arena;

import org.godot.Godot;
import org.godot.bridge.CallableDispatch;
import org.junit.jupiter.api.Test;

class CallableValidityTest {

	@Test
	void objectCallableFollowsObjectLiveness() {
		Godot obj = new Godot() {
		};
		obj.setNativeObject(0x1234);
		long key = CallableDispatch.registerCallable(obj, "myMethod");
		assertTrue(CallableDispatch.isCallableValid(key));
		obj.invalidate();
		assertFalse(CallableDispatch.isCallableValid(key));
		CallableDispatch.unregisterCallable(key);
		assertFalse(CallableDispatch.isCallableValid(key));
	}

	@Test
	void lambdaCallableStaysValidWhileRegistered() {
		long key = CallableDispatch.registerLambdaCallable(() -> {
		});
		assertTrue(CallableDispatch.isCallableValid(key));
		CallableDispatch.unregisterCallable(key);
		assertFalse(CallableDispatch.isCallableValid(key));
	}

	@Test
	void callableWrappingNativeCallableTracksSource() {
		Godot obj = new Godot() {
		};
		obj.setNativeObject(0x1234);
		long key = CallableDispatch.registerCallable(obj, "myMethod");
		try (Arena arena = Arena.ofShared()) {
			NativeCallable nc = new NativeCallable(arena.allocate(Callable.NATIVE_SIZE), key);
			Callable callable = new Callable(nc);
			assertTrue(callable.isValid());
			obj.invalidate();
			// The callable must no longer claim validity once its bound object dies
			assertFalse(callable.isValid());
		}
	}
}
