package org.godot.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.godot.node.Control.SizeFlags;
import org.junit.jupiter.api.Test;

/// Strongly-typed bitfield classes are generated from is_bitfield enums:
/// combinators must behave like Godot flag arithmetic and stay 64-bit safe.
class BitfieldFlagsTest {

	@Test
	void withCombinesAndWithoutRemoves() {
		SizeFlags mask = SizeFlags.SIZE_FILL.with(SizeFlags.SIZE_EXPAND);
		assertEquals(3L, mask.value);
		assertTrue(mask.has(SizeFlags.SIZE_FILL));
		assertTrue(mask.has(SizeFlags.SIZE_EXPAND));
		assertFalse(mask.has(SizeFlags.SIZE_SHRINK_CENTER));

		SizeFlags back = mask.without(SizeFlags.SIZE_FILL);
		assertEquals(2L, back.value);
		assertFalse(back.has(SizeFlags.SIZE_FILL));
	}

	@Test
	void ofRoundTripsAndEqualsByValue() {
		assertEquals(SizeFlags.of(3), SizeFlags.SIZE_FILL.with(SizeFlags.SIZE_EXPAND));
		assertEquals(3L, SizeFlags.of(3).value);
	}

	@Test
	void highBitMasksSurvive64BitValues() {
		// Bitfields cross the ABI as 64-bit values; masks above int32 must not
		// be truncated anywhere in the generated class.
		SizeFlags big = SizeFlags.of(0x8000_0000L).with(SizeFlags.of(0x4000_0000L));
		assertEquals(0xC000_0000L, big.value);
		assertTrue(big.has(SizeFlags.of(0x8000_0000L)));
	}
}
