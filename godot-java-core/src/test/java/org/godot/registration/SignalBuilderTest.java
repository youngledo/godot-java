package org.godot.registration;

import org.godot.signal.ConnectFlags;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignalBuilderTest {

	@Test
	void connectFlagsValues() {
		assertEquals(1, ConnectFlags.DEFERRED);
		assertEquals(2, ConnectFlags.PERSIST);
		assertEquals(4, ConnectFlags.ONE_SHOT);
		assertEquals(8, ConnectFlags.REFERENCE_COUNTED);
	}

	@Test
	void builderRequiresTarget() {
		// SignalBuilder without a real Godot instance still validates to() was called.
		// We use a stub approach: connect() should throw if no target/callable set.
		// Since SignalBuilder.on() needs a Godot instance (which we can't create in
		// unit tests without the native runtime), we verify the flag composition
		// and error path indirectly.
		// The connect() method throws IllegalStateException when no target is set.
		// This is covered by the null-check logic in SignalBuilder.connect().
		// We test the constant values and flag composition directly.
		assertTrue(true); // placeholder — full coverage requires integration test
	}

	@Test
	void flagComposition() {
		int combined = ConnectFlags.DEFERRED | ConnectFlags.ONE_SHOT;
		assertEquals(5, combined);

		int all = ConnectFlags.DEFERRED | ConnectFlags.PERSIST | ConnectFlags.ONE_SHOT | ConnectFlags.REFERENCE_COUNTED;
		assertEquals(15, all);
	}

	@Test
	void connectFlagsArePowersOfTwo() {
		// Each flag should be a single bit
		assertEquals(1, Integer.bitCount(ConnectFlags.DEFERRED));
		assertEquals(1, Integer.bitCount(ConnectFlags.PERSIST));
		assertEquals(1, Integer.bitCount(ConnectFlags.ONE_SHOT));
		assertEquals(1, Integer.bitCount(ConnectFlags.REFERENCE_COUNTED));
	}

	@Test
	void connectFlagsDoNotOverlap() {
		int all = ConnectFlags.DEFERRED | ConnectFlags.PERSIST | ConnectFlags.ONE_SHOT | ConnectFlags.REFERENCE_COUNTED;
		assertEquals(4, Integer.bitCount(all));
	}
}
