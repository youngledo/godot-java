package org.godot.singleton;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class SingletonCachesTest {

	/// The aggregate invalidator must run cleanly without a loaded engine — it is
	/// called during the final deinitialization level, when most services are
	/// already gone.
	@Test
	void invalidateAllRunsCleanly() {
		assertDoesNotThrow(SingletonCaches::invalidateAll);
	}
}
