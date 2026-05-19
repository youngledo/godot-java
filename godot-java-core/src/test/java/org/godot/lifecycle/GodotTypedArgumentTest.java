package org.godot.lifecycle;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.godot.Godot;
import org.junit.jupiter.api.Test;

class GodotTypedArgumentTest {

	@Test
	void unsigned32ArgumentsRejectOutOfRangeValues() {
		assertDoesNotThrow(() -> Access.typedUint32(0));
		assertDoesNotThrow(() -> Access.typedUint32(0xffff_ffffL));

		assertThrows(IllegalArgumentException.class, () -> Access.typedUint32(-1));
		assertThrows(IllegalArgumentException.class, () -> Access.typedUint32(0x1_0000_0000L));
	}

	@Test
	void unsigned64BigIntegerArgumentsRejectOutOfRangeValues() {
		BigInteger max = new BigInteger("18446744073709551615");

		assertDoesNotThrow(() -> Access.typedUint64(BigInteger.ZERO));
		assertDoesNotThrow(() -> Access.typedUint64(max));

		assertThrows(IllegalArgumentException.class, () -> Access.typedUint64(null));
		assertThrows(IllegalArgumentException.class, () -> Access.typedUint64(BigInteger.valueOf(-1)));
		assertThrows(IllegalArgumentException.class, () -> Access.typedUint64(max.add(BigInteger.ONE)));
	}

	private static final class Access extends Godot {
		static Object typedUint32(long value) {
			return typedUint32Arg(value);
		}

		static Object typedUint64(BigInteger value) {
			return typedUint64Arg(value);
		}
	}
}
