package org.godot.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;

import org.junit.jupiter.api.Test;

class VariantDestroyElisionTest {

	/// In-place Variant types (Godot's needs_deinit = false) must skip the
	/// variant_destroy FFI call — provable in unit tests without a loaded
	/// engine, because the FFI path would fail and leave memory untouched.
	@Test
	void trivialTypesSkipFfiAndResetTypeToNil() {
		try (Arena arena = Arena.ofShared()) {
			// NIL, BOOL, INT, FLOAT, VECTOR2/2I, RECT2/2I, VECTOR3/3I, VECTOR4/4I,
			// PLANE, QUATERNION, COLOR, RID
			int[] trivialTypes = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 20, 23};
			for (int type : trivialTypes) {
				var seg = arena.allocate(24, 8);
				seg.set(ValueLayout.JAVA_INT, 0, type);
				Bridge.destroyVariant(seg);
				assertEquals(0, seg.get(ValueLayout.JAVA_INT, 0), "type " + type + " should be reset to NIL");
			}
		}
	}

	/// Types with internal state (e.g. STRING) must still route through FFI; with
	/// no API loaded the call fails harmlessly and memory is left untouched.
	@Test
	void nonTrivialTypesStillRouteThroughFfiWithoutThrowing() {
		try (Arena arena = Arena.ofShared()) {
			var seg = arena.allocate(24, 8);
			seg.set(ValueLayout.JAVA_INT, 0, 4 /* STRING */);
			Bridge.destroyVariant(seg);
			assertEquals(4, seg.get(ValueLayout.JAVA_INT, 0));
		}
	}
}
