package org.godot.registration;

import org.godot.core.TypedSignal;
import org.godot.core.TypedSignal0;
import org.godot.core.TypedSignal1;
import org.godot.core.TypedSignal2;
import org.godot.core.TypedSignal3;
import org.godot.core.TypedSignal4;
import org.godot.core.TypedSignal5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypedSignalTest {

	@Test
	void typedSignal0Construction() {
		TypedSignal0 sig = new TypedSignal0(null, "testSignal");
		assertEquals("testSignal", sig.getName());
	}

	@Test
	void typedSignal1Construction() {
		TypedSignal1<Integer> sig = new TypedSignal1<>(null, "scoreChanged");
		assertEquals("scoreChanged", sig.getName());
	}

	@Test
	void typedSignal2Construction() {
		TypedSignal2<String, Integer> sig = new TypedSignal2<>(null, "levelCompleted");
		assertEquals("levelCompleted", sig.getName());
	}

	@Test
	void typedSignalHierarchy() {
		TypedSignal0 sig0 = new TypedSignal0(null, "a");
		TypedSignal1<Integer> sig1 = new TypedSignal1<>(null, "b");
		TypedSignal2<String, Integer> sig2 = new TypedSignal2<>(null, "c");

		assertInstanceOf(TypedSignal.class, sig0);
		assertInstanceOf(TypedSignal.class, sig1);
		assertInstanceOf(TypedSignal.class, sig2);
	}

	@Test
	void typedSignal345Construction() {
		TypedSignal3<Boolean, Integer, String> sig3 = new TypedSignal3<>(null, "three");
		TypedSignal4<Boolean, Integer, String, Double> sig4 = new TypedSignal4<>(null, "four");
		TypedSignal5<Boolean, Integer, String, Double, Long> sig5 = new TypedSignal5<>(null, "five");

		assertEquals("three", sig3.getName());
		assertEquals("four", sig4.getName());
		assertEquals("five", sig5.getName());
	}
}
