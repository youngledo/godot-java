package org.godot.builtin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.godot.math.Rect2;
import org.godot.math.Rect2i;
import org.godot.math.Vector2;
import org.godot.math.Vector2i;
import org.godot.math.Vector3;
import org.godot.math.Vector3i;
import org.godot.math.Vector4;
import org.godot.math.Vector4i;
import org.junit.jupiter.api.Test;

class MathConversionsTest {

	@Test
	void vector2TruncatesTowardZeroAndBack() {
		Vector2i i = new Vector2(3.7, -2.7).toVector2i();
		assertEquals(3, i.x);
		assertEquals(-2, i.y);
		assertEquals(new Vector2(3.0, -2.0), i.toVector2());
	}

	@Test
	void vector3TruncatesTowardZeroAndBack() {
		Vector3i i = new Vector3(1.9, -0.5, 2.5).toVector3i();
		assertEquals(1, i.x);
		assertEquals(0, i.y);
		assertEquals(2, i.z);
		assertEquals(new Vector3(1.0, 0.0, 2.0), i.toVector3());
	}

	@Test
	void vector4TruncatesTowardZeroAndBack() {
		Vector4i i = new Vector4(1.5, -1.5, 2.5, -2.5).toVector4i();
		assertEquals(1, i.x);
		assertEquals(-1, i.y);
		assertEquals(2, i.z);
		assertEquals(-2, i.w);
		assertEquals(new Vector4(1.0, -1.0, 2.0, -2.0), i.toVector4());
	}

	@Test
	void rect2TruncatesTowardZeroAndBack() {
		Rect2i i = new Rect2(1.5, 2.5, 3.5, 4.5).toRect2i();
		assertEquals(1, i.x);
		assertEquals(2, i.y);
		assertEquals(3, i.width);
		assertEquals(4, i.height);
		Rect2 back = i.toRect2();
		assertEquals(1.0, back.position.x);
		assertEquals(2.0, back.position.y);
		assertEquals(3.0, back.size.x);
		assertEquals(4.0, back.size.y);
	}
}
