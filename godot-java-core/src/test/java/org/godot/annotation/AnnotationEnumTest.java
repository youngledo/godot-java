package org.godot.annotation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/// Tests for annotation enums — PropertyHint, InitLevel, OnReadyMode, TransferMode, RpcMode.
class AnnotationEnumTest {

	// --- PropertyHint ---

	@Test
	void propertyHint_noneIsZero() {
		assertEquals(0, PropertyHint.NONE.id());
	}

	@Test
	void propertyHint_rangeIsOne() {
		assertEquals(1, PropertyHint.RANGE.id());
	}

	@Test
	void propertyHint_enumIsThree() {
		assertEquals(3, PropertyHint.ENUM.id());
	}

	@Test
	void propertyHint_maxIs40() {
		assertEquals(40, PropertyHint.MAX.id());
	}

	@Test
	void propertyHint_allValuesUnique() {
		java.util.Set<Integer> ids = new java.util.HashSet<>();
		for (PropertyHint hint : PropertyHint.values()) {
			assertTrue(ids.add(hint.id()), "Duplicate id: " + hint.id() + " for " + hint);
		}
	}

	// --- InitLevel ---

	@Test
	void initLevel_valuesInOrder() {
		InitLevel[] levels = InitLevel.values();
		assertEquals(4, levels.length);
		assertEquals(InitLevel.CORE, levels[0]);
		assertEquals(InitLevel.SERVERS, levels[1]);
		assertEquals(InitLevel.SCENE, levels[2]);
		assertEquals(InitLevel.EDITOR, levels[3]);
	}

	// --- OnReadyMode ---

	@Test
	void onReadyMode_valuesInOrder() {
		OnReadyMode[] modes = OnReadyMode.values();
		assertEquals(3, modes.length);
		assertEquals(OnReadyMode.NEW, modes[0]);
		assertEquals(OnReadyMode.NODE, modes[1]);
		assertEquals(OnReadyMode.MANUAL, modes[2]);
	}

	// --- TransferMode ---

	@Test
	void transferMode_values() {
		assertEquals(0, TransferMode.UNRELIABLE.value);
		assertEquals(1, TransferMode.UNRELIABLE_ORDERED.value);
		assertEquals(2, TransferMode.RELIABLE.value);
	}

	@Test
	void transferMode_allValuesUnique() {
		java.util.Set<Integer> vals = new java.util.HashSet<>();
		for (TransferMode mode : TransferMode.values()) {
			assertTrue(vals.add(mode.value), "Duplicate value: " + mode.value);
		}
	}

	// --- RpcMode ---

	@Test
	void rpcMode_values() {
		assertEquals(0, RpcMode.DISABLED.value);
		assertEquals(1, RpcMode.ANY_PEER.value);
		assertEquals(2, RpcMode.AUTHORITY.value);
	}

	@Test
	void rpcMode_allValuesUnique() {
		java.util.Set<Integer> vals = new java.util.HashSet<>();
		for (RpcMode mode : RpcMode.values()) {
			assertTrue(vals.add(mode.value), "Duplicate value: " + mode.value);
		}
	}
}
